package com.taikang.dic.ltci.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.AttachmentDTO;
import com.taikang.dic.ltci.api.model.ReconsiderDTO;
import com.taikang.dic.ltci.api.model.ReconsiderFileDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.IsValidEnum;
import com.taikang.dic.ltci.common.enumeration.ModuleCodeEnum;
import com.taikang.dic.ltci.common.enumeration.OperationTypeEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.enumeration.TaskStateEnum;
import com.taikang.dic.ltci.common.enumeration.TransportTypeEnum;
import com.taikang.dic.ltci.common.exception.ThrowsException;
import com.taikang.dic.ltci.common.util.DateFormat;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.common.util.Encodes;
import com.taikang.dic.ltci.common.util.FileTypeDecideUtil;
import com.taikang.dic.ltci.common.util.IPUtil;
import com.taikang.dic.ltci.common.util.SpringContextUtil;
import com.taikang.dic.ltci.common.util.UrlUtil;
import com.taikang.dic.ltci.controller.ReconsiderController;
import com.taikang.dic.ltci.dao.IExecuteResultDAO;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.IPatrolTaskDAO;
import com.taikang.dic.ltci.dao.IRReconsiderFileDAO;
import com.taikang.dic.ltci.dao.IReconsiderDAO;
import com.taikang.dic.ltci.model.BaseModel;
import com.taikang.dic.ltci.model.ExecuteResultDO;
import com.taikang.dic.ltci.model.ExecuteResultDOExample;
import com.taikang.dic.ltci.model.ExecuteResultDOExample.Criteria;
import com.taikang.dic.ltci.model.MqFailMessageLogDO;
import com.taikang.dic.ltci.model.PatrolTaskDO;
import com.taikang.dic.ltci.model.RReconsiderFileDO;
import com.taikang.dic.ltci.model.RReconsiderFileDOExample;
import com.taikang.dic.ltci.model.ReconsiderDO;
import com.taikang.dic.ltci.model.ReconsiderDOExample;
import com.taikang.dic.ltci.mqmodel.AppealReconsiderModel;
import com.taikang.dic.ltci.mqmodel.MqBaseModel;
import com.taikang.dic.ltci.mqmodel.ReplyReconsiderModel;
import com.taikang.dic.ltci.serverClient.AttachmentServiceClient;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.IMqFailMessageLogService;
import com.taikang.dic.ltci.service.IMqMessageLogService;
import com.taikang.dic.ltci.service.IReconsiderService;

@Service
public class ReconsiderServiceImpl extends AbstractGenericService<ReconsiderDO, String>
    implements IReconsiderService {
  private Logger logger = LoggerFactory.getLogger(ReconsiderServiceImpl.class);

  @Autowired private IReconsiderDAO reconsiderDAO;
  @Autowired private IRReconsiderFileDAO reconsiderFileDAO;
  @Autowired private IMqMessageLogService messageLogService;
  @Autowired private IMqFailMessageLogService failMessageLogService;
  @Autowired private IExecuteResultDAO executeResultDAO;
  @Autowired private IPatrolTaskDAO patrolTaskDAO;
  @Autowired private UrlUtil urlUtil;
  @Autowired private AttachmentServiceClient attachmentServiceClient;
  @Autowired private SpringContextUtil springContextUtil;
  //申诉复议接收query
  @Value("${ltci.appealReconsider.queue}")
  private String appealReconsiderQueueName;
  //申诉复议消息编码
  @Value("${ltci.appealReconsider.messageCode}")
  private String appealReconsiderMessageCode;

  //申诉复议结果告知exchange
  @Value("${ltci.appealResult.exchange}")
  private String appealResultExchange;

  //申诉复议结果告知消息编码
  @Value("${ltci.appealResult.messageCode}")
  private String appealResultMessageCode;

  /**
   * 申诉复议结果mq接收（专业服务->经办） mq监听
   *
   * @author itw_muwg
   */
  @RabbitListener(queues = "${ltci.appealReconsider.queue}")
  @Override
  public void getReconsiderReceive(byte[] bytes) {
    logger.debug("=======进入ReconsiderServiceImpl getReconsiderReceive方法=========");
    String message = null;
    try {
      message = new String(bytes, systemCharset);
    } catch (UnsupportedEncodingException e) {
      logger.error(e.getMessage(), e);
      return;
    }
    logger.info("=======mq " + appealReconsiderQueueName + " 消息队列监听到的消息=========");
    //调用处理逻辑
    parseMessage(message);
  }
  /**
   * 处理获取的数据
   *
   * @param message
   */
  @Override
  public void parseMessage(String message) {
    //转成格式为MqBaseModel
    MqBaseModel mqBaseModel = JSONObject.parseObject(message, MqBaseModel.class);
    try {
      //通过判断messageCode筛选信息
      if (appealReconsiderMessageCode.equals(mqBaseModel.getMessageCode())) {
        //首先通过id和type到日志表中查询数据 判重复
        boolean has = messageLogService.isHas(mqBaseModel.getBusinessSerialid());
        if (has) {
          logger.debug("======此id【" + mqBaseModel.getBusinessSerialid() + "】信息已经监听处理=============");
          return;
        }
        //存储复议申请信息
        JSONObject data = JSONObject.parseObject(String.valueOf(mqBaseModel.getData()));
        //转成复议申请DO
        ReconsiderDO reconsider = data2Reconsider(data);
        String executeResultId =
            getExecuteResultId(data.getString(AppealReconsiderModel.PATROL_TASK_ID));
        reconsider.setExecuteResultId(executeResultId);
        //查询申诉表中是否已经有该条数据
        ReconsiderDOExample example = new ReconsiderDOExample();
        com.taikang.dic.ltci.model.ReconsiderDOExample.Criteria criteria = example.createCriteria();
        criteria.andSerialNumberEqualTo(reconsider.getSerialNumber());
        List<ReconsiderDO> list = reconsiderDAO.selectByExample(example);
        //通过spring获得代理bean，事务正常执行
        ReconsiderServiceImpl bean =
            springContextUtil.getApplicationContext().getBean(ReconsiderServiceImpl.class);
        if (list != null && list.isEmpty()) {
          //存储基础信息
          bean.saveReconsider(mqBaseModel.getBusinessSerialid(), data, reconsider, message);
        }

        logger.debug("=====监听mq接收申诉复议信息完成==========");
      }
    } catch (Exception e) {
      //存储异常日志
      logger.error("===监听mq接收申诉复议信息异常===", e);
      if (StringUtils.isNotBlank(mqBaseModel.getBusinessSerialid())) {
        MqFailMessageLogDO failLog = new MqFailMessageLogDO();
        failLog.setId(mqBaseModel.getBusinessSerialid());
        failLog.setTransportType(TransportTypeEnum.ASYNCHRONIZE.getValue()); //交互方式：异步
        failLog.setOperationType(OperationTypeEnum.RECEIVE.getValue()); //发送接收类型
        failLog.setQueryName(appealReconsiderQueueName);
        failLog.setContent(message);
        failLog.setErrorMessage(e.getMessage());
        failLog.setCreateTime(new Date());
        failLog.setHttpAction(HttpMethod.POST.name());
        // 添加重试url
        failLog.setRetryUrl(urlUtil.getBaseUrl() + ReconsiderController.RETRY_URL);
        failMessageLogService.saveOrUpdateFailLog(failLog);
      }
    }
  }

  /**
   * 保存申诉复议信息
   *
   * @param data
   * @param reconsider
   */
  @Transactional
  public void saveReconsider(
      String businessSerialid, JSONObject data, ReconsiderDO reconsider, String message) {
    //先将监听到的数据存入日志表
    messageLogService.receiveMqMessageLog(businessSerialid, appealReconsiderQueueName, message);
    reconsiderDAO.insertSelective(reconsider);
    //更新任务表中状态为“申诉中”
    PatrolTaskDO patrol = new PatrolTaskDO();
    patrol.setPatrolTaskId(reconsider.getPatrolTaskId());
    patrol.setTaskState(TaskStateEnum.IN_APPEAL.getValue());
    patrolTaskDAO.updateByPrimaryKeySelective(patrol);
    //存储附件信息
    saveAdditional(data, reconsider.getReconsiderid());
  }
  //存储附件
  private void saveAdditional(JSONObject data, String reconsiderId) {
    JSONArray jsonArray = data.getJSONArray(AppealReconsiderModel.ADDITIONS);
    for (int i = 0; i < jsonArray.size(); i++) {
      JSONObject json = jsonArray.getJSONObject(i);
      String fileType =
          FileTypeDecideUtil.getFileType(json.getString(AppealReconsiderModel.ADDITION_TYPE));

      AttachmentDTO dto = new AttachmentDTO();
      dto.setContent(Encodes.encodeBase64(json.getBytes(AppealReconsiderModel.ADDITION_INFO)));
      dto.setFileName("");
      dto.setSuffix(json.getString(AppealReconsiderModel.ADDITION_TYPE));
      dto.setFileType(fileType);

      ResultDTO resultDTO = attachmentServiceClient.addAttachment(dto);
      if (resultDTO == null || !resultDTO.getStatus().equals(StatusCodeEnum.CREATED.getValue())) {
        throw new ThrowsException("调用媒体文件微服务端保存文件失败！");
      }
      JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(resultDTO.getDatas()));
      String fileId = jsonObject.getString("attachmentid");

      RReconsiderFileDO rFileDO = new RReconsiderFileDO();
      rFileDO.setFileId(fileId); //附件id
      rFileDO.setFileType(json.getString(AppealReconsiderModel.ADDITION_TYPE)); //附件类型
      rFileDO.setLcpsFileId(json.getString(AppealReconsiderModel.ADDITION_INFO_ID)); //专业系统附件id
      rFileDO.setReconsiderid(reconsiderId);
      rFileDO.setId(BaseModel.getUUID());
      reconsiderFileDAO.insertSelective(rFileDO);
    }
  }

  //查询任务执行结果id
  private String getExecuteResultId(String patrolTaskId) {
    ExecuteResultDOExample example = new ExecuteResultDOExample();
    Criteria criteria = example.createCriteria();
    criteria.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());
    criteria.andPatrolTaskIdEqualTo(patrolTaskId);
    List<ExecuteResultDO> list = executeResultDAO.selectByExample(example);
    if (list != null && !list.isEmpty()) {
      return list.get(0).getExecuteResultId();
    }
    return null;
  }
  //将接收的data转成DO
  private ReconsiderDO data2Reconsider(JSONObject data) {
    ReconsiderDO reconsider = new ReconsiderDO();
    reconsider.setReconsiderid(BaseModel.getUUID());
    reconsider.setSerialNumber(data.getString(AppealReconsiderModel.SER_NUM));
    reconsider.setPatrolTaskId(data.getString(AppealReconsiderModel.PATROL_TASK_ID));
    reconsider.setAppealPerson(data.getString(AppealReconsiderModel.RECON_APPLICANT));
    reconsider.setApplealContent(data.getString(AppealReconsiderModel.RECON_CONTENT));
    reconsider.setAppealPhone(data.getString(AppealReconsiderModel.RECON_APPLICANT_PHONE));
    reconsider.setAppealTime(data.getDate(AppealReconsiderModel.RECON_DATE));
    reconsider.setCreateTime(new Date());
    reconsider.setIsValid(IsValidEnum.NO_DELETE.getValue());
    return reconsider;
  }

  @Override
  public IGenericDAO<ReconsiderDO, String> getDao() {
    return reconsiderDAO;
  }
  /**
   * 根据任务ID查询复议列表
   *
   * @param reconsider
   * @return
   */
  @Override
  public ResultDTO listReconsidersByPatrolTaskId(String patrolTaskId) {
    ResultDTO result = new ResultDTO();

    //根据任务ID查询申述列表
    ReconsiderDOExample example = new ReconsiderDOExample();
    com.taikang.dic.ltci.model.ReconsiderDOExample.Criteria criteria = example.createCriteria();
    criteria.andPatrolTaskIdEqualTo(patrolTaskId);
    criteria.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());
    example.setOrderByClause("create_time asc");
    List<ReconsiderDO> list = reconsiderDAO.selectByExample(example);

    //将DO转换成DTO
    List<ReconsiderDTO> dtoList = new ArrayList<>();
    if (!CollectionUtils.isEmpty(list)) {
      String stringWithDateFormat =
          JSONArray.toJSONStringWithDateFormat(
              list, DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
      List<ReconsiderDTO> parseArray =
          JSONArray.parseArray(stringWithDateFormat, ReconsiderDTO.class);
      //填充附件信息
      for (ReconsiderDTO reconsiderDTO : parseArray) {
        String reconsiderid = reconsiderDTO.getReconsiderid();
        RReconsiderFileDOExample fileexample = new RReconsiderFileDOExample();
        com.taikang.dic.ltci.model.RReconsiderFileDOExample.Criteria createCriteria =
            fileexample.createCriteria();
        createCriteria.andReconsideridEqualTo(reconsiderid);
        List<RReconsiderFileDO> selectByExample = reconsiderFileDAO.selectByExample(fileexample);
        if (!CollectionUtils.isEmpty(selectByExample)) {
          String jsonStringWithDateFormat =
              JSONArray.toJSONStringWithDateFormat(
                  selectByExample, DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
          List<ReconsiderFileDTO> parseArray2 =
              JSONArray.parseArray(jsonStringWithDateFormat, ReconsiderFileDTO.class);
          reconsiderDTO.setFiles(parseArray2);
        }
      }

      if (!CollectionUtils.isEmpty(parseArray)) {
        dtoList = parseArray;
      }
    }
    result.setDatas(dtoList);
    return result;
  }

  /**
   * 根据任务ID查询出回复信息为null的最后一条记录,并将回复信息更新到该记录中
   *
   * @param reconsider
   * @return
   */
  @Override
  public ResultDTO saveReconsider(ReconsiderDTO reconsider) {

    ResultDTO result = new ResultDTO();

    //查询出patrolTaskId对应的复议列表中回复信息为空的最后一条记录
    ReconsiderDOExample example = new ReconsiderDOExample();
    com.taikang.dic.ltci.model.ReconsiderDOExample.Criteria criteria = example.createCriteria();

    //查询条件: patrol_task_id = #{patrolTaskId} 和 replyOpinion is null
    criteria.andPatrolTaskIdEqualTo(reconsider.getPatrolTaskId());
    criteria.andReplyOpinionIsNull();

    //按创建时间倒序排序
    example.setOrderByClause("create_time desc");

    List<ReconsiderDO> byExample = reconsiderDAO.selectByExample(example);
    if (!CollectionUtils.isEmpty(byExample)) {

      ReconsiderDO reconsiderDO = byExample.get(0);
      ReconsiderServiceImpl bean =
          springContextUtil.getApplicationContext().getBean(ReconsiderServiceImpl.class);
      bean.updateReconsiderAndSendReplyToOrg(reconsider, reconsiderDO);
      result.setStatus(StatusCodeEnum.OK.getValue());
    } else {

      result.setStatus(407);
      result.setMessage("记录已被他人操作请刷新页面查看");
    }
    return result;
  }

  @Transactional
  public void updateReconsiderAndSendReplyToOrg(
      ReconsiderDTO reconsider, ReconsiderDO reconsiderDO) {
    reconsiderDO.setOperatedBy(reconsider.getOperatedBy());
    reconsiderDO.setOperatedOrg(reconsider.getOperatedOrg());

    reconsiderDO.setOperatedTime(new Date());

    reconsiderDO.setReplyOpinion(reconsider.getReplyOpinion());
    reconsiderDO.setReplyPhone(reconsider.getReplyPhone());
    reconsiderDO.setReplyPerson(reconsider.getReplyPerson());

    reconsiderDAO.updateByPrimaryKeySelective(reconsiderDO);

    //更新任务表中状态为“复议中”
    PatrolTaskDO patrol = new PatrolTaskDO();
    patrol.setPatrolTaskId(reconsider.getPatrolTaskId());
    patrol.setTaskState(TaskStateEnum.IN_RECONSIDER.getValue());
    patrolTaskDAO.updateByPrimaryKeySelective(patrol);

    //申述复议意见告知专业系统
    sendReplyReconsider(reconsiderDO);
  }
  /** 申诉复议意见结果告知专业系统 */
  private void sendReplyReconsider(ReconsiderDO reconsider) {
    //转换成接口参数
    ReplyReconsiderModel model = new ReplyReconsiderModel();
    model.setSerialNumber(reconsider.getSerialNumber());
    model.setPatrolTaskId(reconsider.getPatrolTaskId());
    model.setFeedbackDate(DateFormatUtil.dateToTimeStr(reconsider.getOperatedTime()));
    model.setFeedbackContent(reconsider.getReplyOpinion());
    model.setContactPhone(reconsider.getReplyPhone());
    model.setContact(reconsider.getReplyPerson());
    //构建公共mq接口规范
    MqBaseModel mqBaseModel = new MqBaseModel();
    mqBaseModel.setBusinessSerialid(BaseModel.getUUID());
    mqBaseModel.setTimestamp(DateFormat.getLocalDateTime());
    try {
      mqBaseModel.setNodeIP(IPUtil.getLocalIp());
    } catch (Exception e) {
      logger.error("获取本地IP失败：" + e);
    }
    mqBaseModel.setSystemCode(systemCode);
    mqBaseModel.setModuleCode(ModuleCodeEnum.SEND_APPEAL_RESULT.getValue());
    mqBaseModel.setMessageCode(appealResultMessageCode);
    mqBaseModel.setData(model);
    String jsonString = JSONObject.toJSONString(mqBaseModel);
    //记录日志
    messageLogService.sendMqMessageLog(0L, "0", jsonString, appealResultExchange, null);
    //发送至mq routingKey 是 “jingmen”,不是queryName
    sendMessage(appealResultExchange, "jingmen", jsonString);
  }
}
