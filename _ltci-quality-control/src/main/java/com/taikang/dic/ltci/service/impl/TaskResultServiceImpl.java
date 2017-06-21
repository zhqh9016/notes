package com.taikang.dic.ltci.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.AttachmentDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.ExecutionStatusEnum;
import com.taikang.dic.ltci.common.enumeration.MqTypeEnum;
import com.taikang.dic.ltci.common.enumeration.OperationTypeEnum;
import com.taikang.dic.ltci.common.enumeration.TaskStateEnum;
import com.taikang.dic.ltci.common.enumeration.TransportTypeEnum;
import com.taikang.dic.ltci.common.exception.ThrowsException;
import com.taikang.dic.ltci.common.util.FileTypeDecideUtil;
import com.taikang.dic.ltci.common.util.SpringContextUtil;
import com.taikang.dic.ltci.common.util.UrlUtil;
import com.taikang.dic.ltci.controller.PatrolTaskController;
import com.taikang.dic.ltci.dao.IExecuteResultDAO;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.IMqFailMessageLogDAO;
import com.taikang.dic.ltci.dao.IPatrolTaskDAO;
import com.taikang.dic.ltci.dao.IRExecuteFileDAO;
import com.taikang.dic.ltci.dao.MqMessageLogDAO;
import com.taikang.dic.ltci.model.ExecuteResultDO;
import com.taikang.dic.ltci.model.MqFailMessageLogDO;
import com.taikang.dic.ltci.model.MqMessageLogDO;
import com.taikang.dic.ltci.model.MqMessageLogDOExample;
import com.taikang.dic.ltci.model.MqMessageLogDOExample.Criteria;
import com.taikang.dic.ltci.model.PatrolTaskDO;
import com.taikang.dic.ltci.model.RExecuteFileDO;
import com.taikang.dic.ltci.mqmodel.MqBaseModel;
import com.taikang.dic.ltci.mqmodel.PatrolDatumModel;
import com.taikang.dic.ltci.mqmodel.TaskResultFileModel;
import com.taikang.dic.ltci.mqmodel.TaskResultMqModel;
import com.taikang.dic.ltci.serverClient.AttachmentServiceClient;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.IMqFailMessageLogService;
import com.taikang.dic.ltci.service.ITaskResultService;

@Service
@Component
public class TaskResultServiceImpl extends AbstractGenericService<ExecuteResultDO, String>
    implements ITaskResultService {

  @Value(value = "${ltci.taskResult.queue}")
  private String taskResult;

  @Autowired private IExecuteResultDAO executeResultDao;
  @Autowired private MqMessageLogDAO mqMessageLogDAO;
  @Autowired private SpringContextUtil springContextUtil;
  @Autowired private UrlUtil urlUtil;
  @Autowired private IMqFailMessageLogService failMessageLogService;
  @Autowired private IMqFailMessageLogDAO failMessageLogDAO;
  @Autowired private IPatrolTaskDAO patrolTaskDao;
  @Autowired private AttachmentServiceClient attachmentServiceClient;
  @Autowired private IRExecuteFileDAO executeFileDao;

  @Override
  public IGenericDAO<ExecuteResultDO, String> getDao() {
    return null;
  }

  @Override
  @RabbitListener(queues = "${ltci.taskResult.queue}")
  public void receiveMessage(byte[] bytes) {
    String message = "";
    MqBaseModel mqBaseModel = null;
    try {
      //1.按照UTF-8转化byte[]
      message = new String(bytes, systemCharset);
      abLogger.info("------" + message + "------");
      mqBaseModel = JSONObject.parseObject(message, MqBaseModel.class);

      //2.判断监听数据是否重复
      MqMessageLogDOExample doExample = new MqMessageLogDOExample();
      Criteria criteria = doExample.createCriteria();
      criteria.andTypeEqualTo(MqTypeEnum.RECEIVE.getValue());
      criteria.andIdEqualTo(mqBaseModel.getBusinessSerialid());

      List<MqMessageLogDO> mqMessageLogDOs = mqMessageLogDAO.selectByExample(doExample);
      if (!mqMessageLogDOs.isEmpty()) {
        abLogger.debug("======此id【" + mqBaseModel.getBusinessSerialid() + "】信息已经监听处理=============");
        return;
      }
      //在这个方法中做事务处理
      TaskResultServiceImpl bean =
          springContextUtil.getApplicationContext().getBean(TaskResultServiceImpl.class);
      bean.insertMqMessageLog(message);
    } catch (Exception e) {
      abLogger.error("监听移动端投诉接口异常：", e);
      if (mqBaseModel != null && StringUtils.isNotBlank(mqBaseModel.getBusinessSerialid())) {
        MqFailMessageLogDO failLog = new MqFailMessageLogDO();
        failLog.setId(mqBaseModel.getBusinessSerialid().replaceAll("-", ""));
        failLog.setTransportType(TransportTypeEnum.ASYNCHRONIZE.getValue()); //交互方式：异步
        failLog.setOperationType(OperationTypeEnum.RECEIVE.getValue()); //发送接收类型
        failLog.setQueryName(taskResult);
        failLog.setContent(message);
        failLog.setErrorMessage(e.getMessage());
        failLog.setCreateTime(new Date());
        failLog.setHttpAction(HttpMethod.POST.name());
        // 添加重试url
        failLog.setRetryUrl(urlUtil.getBaseUrl() + PatrolTaskController.RETRY_URL);
        failMessageLogService.saveOrUpdateFailLog(failLog);
      }
    }
  }

  /**
   * 4.添加任务执行结果,5.更新巡查任务信息,6.添加任务执行结果附件,7.添加任务执行结果资源中间数据
   *
   * @param message
   */
  @Transactional
  public ResultDTO insertMqMessageLog(String message) {
    MqBaseModel mqBaseModel = JSONObject.parseObject(message, MqBaseModel.class);

    TaskResultMqModel taskResultMqModel = null;
    try {
      taskResultMqModel =
          JSONObject.parseObject(
              JSONObject.toJSONString(mqBaseModel.getData()), TaskResultMqModel.class);
    } catch (Exception e) {
      abLogger.error("监听移动端投诉信息数据格式转换错误：", e);
      throw new ThrowsException("监听移动端投诉信息数据转换错误");
    }

    MqMessageLogDO mqMessageLogDO = new MqMessageLogDO();
    mqMessageLogDO.setId(mqBaseModel.getBusinessSerialid().replaceAll("-", ""));
    mqMessageLogDO.setType(MqTypeEnum.RECEIVE.getValue());
    mqMessageLogDO.setSendContent(JSONObject.toJSONString(mqBaseModel));
    //发送状态暂时写1
    mqMessageLogDO.setSendState("1");
    mqMessageLogDO.setCreateTime(new Date());
    mqMessageLogDO.setQueueName(taskResult);
    mqMessageLogDAO.insert(mqMessageLogDO);
    abLogger.info("taskResultMqModel:【" + taskResultMqModel + "】");
    //4.更新巡查任务信息,5.添加任务执行结果,6.添加任务执行结果附件,7.添加任务执行结果资源中间数据
    insertTaskExecuteResult(taskResultMqModel);
    //8.删除错误表数据
    failMessageLogDAO.deleteByPrimaryKey(mqBaseModel.getBusinessSerialid().replaceAll("-", ""));
    ResultDTO resultDto = new ResultDTO();
    resultDto.setStatus(ExecutionStatusEnum.SUCCESS.getValue());
    return resultDto;
  }

  /**
   * 4.更新巡查任务信息,5.添加任务执行结果,6.添加任务执行结果附件,7.添加任务执行结果资源中间数据
   *
   * @param taskResultMqModel
   */
  @SuppressWarnings("unchecked")
  private void insertTaskExecuteResult(TaskResultMqModel taskResultMqModel) {
    // 更新巡查任务信息
    PatrolTaskDO patrolTaskDO = new PatrolTaskDO();
    patrolTaskDO.setPatrolTaskId(taskResultMqModel.getPatrolTaskId());
    patrolTaskDO.setPatrolStaffId(taskResultMqModel.getStaffCode());
    patrolTaskDO.setPatrolStaffName(taskResultMqModel.getStaffName());
    patrolTaskDO.setTaskState(TaskStateEnum.ALREDY_EXECUTE.getValue());
    patrolTaskDao.updateByPrimaryKeySelective(patrolTaskDO);
    // 添加任务执行结果信息
    ExecuteResultDO executeResultDO = new ExecuteResultDO();
    executeResultDO.setExecuteResultId(UUID.randomUUID().toString().replace("-", ""));
    executeResultDO.setPatrolTaskId(taskResultMqModel.getPatrolTaskId());
    executeResultDO.setResultDesc(taskResultMqModel.getPatrolResult());
    executeResultDO.setPartolTime(taskResultMqModel.getPatrolTime());
    executeResultDO.setReceiveResultTime(new Date());
    int length = taskResultMqModel.getPatrolInfo().size();
    String[] violationItemStr = new String[length];
    for (int i = 0; i < length; i++) {
      PatrolDatumModel patrolDatum = taskResultMqModel.getPatrolInfo().get(i);
      abLogger.info("patrolDatum:【" + patrolDatum.getItemId() + "】");
      violationItemStr[i] = patrolDatum.getItemId();
      for (int j = 0; j < patrolDatum.getItemFiles().size(); j++) {
        // 附件信息存储
        TaskResultFileModel taskResultFile = patrolDatum.getItemFiles().get(j);
        if (taskResultFile != null) {
          AttachmentDTO attachmentDto = new AttachmentDTO();
          attachmentDto.setFileName(taskResultFile.getMaterialFileName());
          attachmentDto.setSuffix(taskResultFile.getMaterialType());
          attachmentDto.setContent(taskResultFile.getMaterialInfo());
          if (!StringUtils.isEmpty(taskResultFile.getMaterialFileType())) {
            attachmentDto.setFileType(taskResultFile.getMaterialFileType());
          } else {
            attachmentDto.setFileType(
                FileTypeDecideUtil.getFileType(taskResultFile.getMaterialType()));
          }
          ResultDTO fileResult = attachmentServiceClient.addAttachment(attachmentDto);
          // 存储执行结果附件中间资源数据
          Map<String, Object> map = (Map<String, Object>) fileResult.getDatas();
          String fileId = map.get("attachmentid").toString();
          RExecuteFileDO rExecuteFile = new RExecuteFileDO();
          rExecuteFile.setId(UUID.randomUUID().toString().replace("-", ""));
          rExecuteFile.setExecuteResultId(executeResultDO.getExecuteResultId());
          rExecuteFile.setFileId(fileId);
          // 巡查资料ID TODO 后期或需保存（中间资源表添加字段materialId和materialGroup）
          rExecuteFile.setFileType(attachmentDto.getSuffix());
          rExecuteFile.setFileName(taskResultFile.getMaterialFileName());
          executeFileDao.insertSelective(rExecuteFile);
        }
      }
    }
    executeResultDO.setViolationItem(
        Arrays.toString(violationItemStr).replace("[", "").replace("]", "").replace(" ", ""));
    executeResultDao.insert(executeResultDO);
  }
}
