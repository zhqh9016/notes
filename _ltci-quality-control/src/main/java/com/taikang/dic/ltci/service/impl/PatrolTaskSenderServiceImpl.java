package com.taikang.dic.ltci.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.common.enumeration.ModuleCodeEnum;
import com.taikang.dic.ltci.common.enumeration.MqTypeEnum;
import com.taikang.dic.ltci.common.enumeration.OperationTypeEnum;
import com.taikang.dic.ltci.common.enumeration.TransportTypeEnum;
import com.taikang.dic.ltci.common.exception.ThrowsException;
import com.taikang.dic.ltci.common.util.DateFormat;
import com.taikang.dic.ltci.common.util.IPUtil;
import com.taikang.dic.ltci.dao.IPatrolTaskDAO;
import com.taikang.dic.ltci.dao.IPatrolTaskDetailDAO;
import com.taikang.dic.ltci.dao.MqMessageLogDAO;
import com.taikang.dic.ltci.model.MqFailMessageLogDO;
import com.taikang.dic.ltci.model.MqMessageLogDO;
import com.taikang.dic.ltci.model.PatrolTaskDO;
import com.taikang.dic.ltci.model.PatrolTaskDetailDO;
import com.taikang.dic.ltci.model.PatrolTaskDetailDOExample;
import com.taikang.dic.ltci.model.PatrolTaskDetailDOExample.Criteria;
import com.taikang.dic.ltci.mqmodel.MqBaseModel;
import com.taikang.dic.ltci.service.PatrolTaskSenderService;

@Service
public class PatrolTaskSenderServiceImpl implements PatrolTaskSenderService {
  private static final Logger logger = LoggerFactory.getLogger(PatrolTaskSenderServiceImpl.class);

  @Value("${ltci.deputyBindingSendCase.exchange}")
  private String exchangeName;

  @Value("${ltci.deputyBindingSendCase.queue}")
  private String routingKey;

  @Value("${ltci.deputyBindingSend.messageCode}")
  private String messageCode;

  @Autowired private AmqpTemplate rabbitTemplate;

  @Autowired private MqMessageLogDAO mqMessageLogDAO;
  @Autowired private IPatrolTaskDetailDAO iPatrolTaskDetailDAO;
  @Autowired private IPatrolTaskDAO patrolTaskDAO;
  @Autowired private MqFailMessageLogServiceImpl failMessageLogService;

  @Value("${systemCode}")
  protected String systemCode;

  @Value("${systemCharset}")
  private String systemCharset;

  @Override
  public void send(String context) throws Exception {
    byte[] bytes = context.getBytes(systemCharset);
    rabbitTemplate.convertAndSend(exchangeName, routingKey, bytes);
  }

  @Override
  public void sendPatrolTask(String patrolTaskIdStrMq) {
    HashMap<String, String> map = new HashMap<String, String>();
    //任务分配发送mq信息查询放入map中
    PatrolTaskDO patrolTaskDO = patrolTaskDAO.selectByPrimaryKey(patrolTaskIdStrMq);

    PatrolTaskDetailDOExample doExample = new PatrolTaskDetailDOExample();
    Criteria criteria = doExample.createCriteria();
    criteria.andPatrolTaskIdEqualTo(patrolTaskIdStrMq);

    List<PatrolTaskDetailDO> patrolTaskDetailDOs = iPatrolTaskDetailDAO.selectByExample(doExample);
    map.put("staffCode", patrolTaskDO.getPatrolStaffId());
    map.put("staffName", patrolTaskDO.getPatrolStaffName());
    map.put("patrolTaskId", patrolTaskDO.getPatrolTaskId());
    map.put("taskLevel", patrolTaskDO.getTaskLevel().toString());
    map.put("taskCategory", patrolTaskDO.getTaskCategory().toString());
    map.put("patrolObjectType", patrolTaskDO.getPatrolObjectType().toString());

    //    List<HashMap> serviceTypeList = new ArrayList<>();
    //    for (PatrolTaskDetailDO patrolTaskDetailDO : patrolTaskDetailDOs) {
    //      HashMap<String, String> mapDetail = new HashMap<String, String>();
    //      mapDetail.put("serviceType", patrolTaskDetailDO.getServiceType().toString());
    //      serviceTypeList.add(mapDetail);
    //    }
    logger.debug("====任务分配mq发送信息【" + JSONObject.toJSONString(map) + "】=========");

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
    mqBaseModel.setModuleCode(ModuleCodeEnum.SEND_PATROL_TASK.getValue());
    mqBaseModel.setMessageCode(messageCode);
    mqBaseModel.setData(map);
    //创建日志基本信息
    MqMessageLogDO mqLogDo = new MqMessageLogDO();
    mqLogDo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
    mqLogDo.setType(MqTypeEnum.SEND.getValue());
    mqLogDo.setSendTime(new Date());
    mqLogDo.setCreateTime(new Date());
    mqLogDo.setReSendNum(0L);
    mqLogDo.setSendState("0");
    mqLogDo.setExchangeName(exchangeName);
    mqLogDo.setQueueName(routingKey);
    mqLogDo.setSendContent(JSONObject.toJSONString(mqBaseModel));

    String jsonString = JSONObject.toJSONString(mqBaseModel);
    //2.保存日志信息
    mqMessageLogDAO.insert(mqLogDo);
    //3.发送MQ信息
    try {
      send(jsonString);
    } catch (Exception e) {
      logger.info("发送MQ失败错误：", e);
      mqMessageLogDAO.deleteByPrimaryKey(mqLogDo.getId());
      MqFailMessageLogDO failLog = new MqFailMessageLogDO();

      failLog.setId(mqLogDo.getId());
      failLog.setTransportType(TransportTypeEnum.ASYNCHRONIZE.getValue()); //交互方式：异步
      failLog.setOperationType(OperationTypeEnum.SEND.getValue()); //发送接收类型
      failLog.setExchangeName(exchangeName);
      failLog.setQueryName(routingKey);
      failLog.setContent(jsonString);
      failLog.setErrorMessage(e.getMessage());
      failLog.setCreateTime(new Date());
      failLog.setHttpAction(HttpMethod.POST.name());
      // 添加重试url
      failMessageLogService.saveOrUpdateFailLog(failLog);
    }
  }
}
