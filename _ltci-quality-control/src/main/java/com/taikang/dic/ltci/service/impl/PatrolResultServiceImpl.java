package com.taikang.dic.ltci.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.common.enumeration.ModuleCodeEnum;
import com.taikang.dic.ltci.common.enumeration.OperationTypeEnum;
import com.taikang.dic.ltci.common.enumeration.TaskStateEnum;
import com.taikang.dic.ltci.common.enumeration.TransportTypeEnum;
import com.taikang.dic.ltci.common.exception.ThrowsException;
import com.taikang.dic.ltci.common.util.DateFormat;
import com.taikang.dic.ltci.common.util.IPUtil;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.IMqFailMessageLogDAO;
import com.taikang.dic.ltci.dao.IPatrolResultDAO;
import com.taikang.dic.ltci.dao.IPatrolTaskDAO;
import com.taikang.dic.ltci.dao.MqMessageLogDAO;
import com.taikang.dic.ltci.model.MqFailMessageLogDO;
import com.taikang.dic.ltci.model.PatrolTaskDO;
import com.taikang.dic.ltci.model.ViolationItemDO;
import com.taikang.dic.ltci.mqmodel.MqBaseModel;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.IMqMessageLogService;
import com.taikang.dic.ltci.service.IPatrolResultService;
import com.taikang.dic.ltci.service.ServiceException;

@Service
public class PatrolResultServiceImpl extends AbstractGenericService<PatrolTaskDO, String>
    implements IPatrolResultService {

  private static final Logger logger = LoggerFactory.getLogger(PatrolResultServiceImpl.class);

  private static final String String = null;

  @Value("${ltci.patrolResult.queue}")
  private String patrolResultQ;

  @Value("${ltci.patrolResult.exechange}")
  private String exechange;

  @Value("${ltci.sendPatrolResult.messageCode}")
  private String messageCode;

  @Value("${systemCode}")
  protected String systemCode;

  @Autowired private IPatrolResultDAO patrolResultDAO;

  @Autowired private IPatrolTaskDAO patrolTaskDAO;

  @Autowired private IMqMessageLogService mqMessageLogService;

  @Autowired private IMqFailMessageLogDAO mqFailMessageLogDAO;

  @Autowired private MqMessageLogDAO mqMessageLogDAO;

  @Override
  public int putPatrolResult(String patrolTaskId) {

    Map<String, Object> map = patrolResultDAO.getPatrolResult(patrolTaskId);
    String result = "";
    String object = (String) map.get("violationItem");
    if ("".equals(object) || object == null) {
      result = "";
    } else {
      logger.debug(object);
      List<ViolationItemDO> list = JSONArray.parseArray(object, ViolationItemDO.class);

      for (ViolationItemDO violationItemDO : list) {
        result += violationItemDO.getItemName();
        result += ",";
      }
      result = result.substring(0, result.length() - 1);
      logger.debug(result);
    }
    map.replace("violationItem", result);
    List<Map<String, Object>> orgList = patrolResultDAO.getOrgTaskId(patrolTaskId);
    if (orgList != null && !orgList.isEmpty()) {
      map.put("taskId", orgList);
    }
    List<Map<String, Object>> executeList = patrolResultDAO.getExecuteFile(patrolTaskId);
    if (executeList != null && !executeList.isEmpty()) {
      map.put("patrolFile", executeList);
    }
    List<Map<String, Object>> complaintList = patrolResultDAO.getComplaintResource(patrolTaskId);
    if (complaintList != null && !complaintList.isEmpty()) {
      map.put("complaintResource", complaintList);
    }

    //封装MqBaseModel信息
    MqBaseModel mqBaseModel = new MqBaseModel();
    mqBaseModel.setBusinessSerialid(UUID.randomUUID().toString());
    mqBaseModel.setTimestamp(DateFormat.getLocalDateTime());
    try {
      mqBaseModel.setNodeIP(IPUtil.getLocalIp());
    } catch (Exception e) {
      logger.error("错误信息：" + e);
      throw new ThrowsException("获取本地IP失败！");
    }
    mqBaseModel.setSystemCode(systemCode);
    mqBaseModel.setModuleCode(ModuleCodeEnum.SEND_APPEAL_RESULT.getValue());
    mqBaseModel.setMessageCode(messageCode);
    mqBaseModel.setData(map);
    String message = JSONObject.toJSONString(mqBaseModel);
    try {
      logger.debug("send message content:" + JSONObject.toJSONString(mqBaseModel, true));
      sendMessage(exechange, patrolResultQ, message);
      logger.debug("send message content:" + message);
      mqMessageLogService.sendMqMessageLog(1L, "0", message, exechange, patrolResultQ);
    } catch (Exception e) {
      logger.debug("发送mq失败，存入错误日志表");
      MqFailMessageLogDO failLog = new MqFailMessageLogDO();
      failLog.setId(mqBaseModel.getBusinessSerialid().replaceAll("-", ""));
      failLog.setTransportType(TransportTypeEnum.ASYNCHRONIZE.getValue()); //交互方式：异步
      failLog.setOperationType(OperationTypeEnum.SEND.getValue()); //发送类型
      failLog.setContent(message);
      failLog.setErrorMessage(e.getMessage());
      failLog.setCreateTime(new Date());
      failLog.setExchangeName(exechange);
      mqFailMessageLogDAO.insertSelective(failLog);
    }

    return 1;
  }

  @Override
  public boolean updateAuditState(String patrolTaskId, int auditState, String rejectionReason)
      throws ServiceException {
    String[] stringArr = patrolTaskId.split(",");
    for (String id : stringArr) {
      PatrolTaskDO patrolTaskDO = patrolTaskDAO.selectByPrimaryKey(id);
      if (patrolTaskDO.getTaskState() == TaskStateEnum.ALREDY_PASS.getValue()
          || patrolTaskDO.getTaskState() == TaskStateEnum.NO_PASS.getValue()) {
        throw new ServiceException(407, "记录已被他人操作，请刷新界面，重新选择数据！");
      }
    }
    for (String id : stringArr) {
      int i = patrolResultDAO.updatePatrolTask(id, auditState);
      int j = patrolResultDAO.updateExecuteResult(id, auditState, rejectionReason);
      if (i > 0 && j > 0) {
        // 巡查结果初审告知接口（经办->专业）
        if (auditState == TaskStateEnum.ALREDY_PASS.getValue()) {
          putPatrolResult(id);
        }
      } else {
        throw new ServiceException(500, "操作失败");
      }
    }
    return true;
  }

  @Override
  public IGenericDAO<PatrolTaskDO, String> getDao() {
    return null;
  }
}
