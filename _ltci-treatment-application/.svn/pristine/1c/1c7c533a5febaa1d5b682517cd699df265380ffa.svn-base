package com.taikang.dic.ltci.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.common.IPUtil;
import com.taikang.dic.ltci.common.enumeration.ModuleCodeEnum;
import com.taikang.dic.ltci.common.enumeration.MqTypeEnum;
import com.taikang.dic.ltci.common.enumeration.OperationTypeEnum;
import com.taikang.dic.ltci.common.enumeration.TransportTypeEnum;
import com.taikang.dic.ltci.common.exception.ThrowsException;
import com.taikang.dic.ltci.common.utils.DateFormat;
import com.taikang.dic.ltci.dao.IMqFailMessageLogDAO;
import com.taikang.dic.ltci.dao.MQMessageLogDAO;
import com.taikang.dic.ltci.model.MQMessageLogDO;
import com.taikang.dic.ltci.model.MqBaseModel;
import com.taikang.dic.ltci.model.MqFailMessageLogDO;
import com.taikang.dic.ltci.service.DeputyBingdingSenderService;

@Service
public class DeputyBindingSenderServiceImpl implements DeputyBingdingSenderService {
  private static final Logger logger =
      LoggerFactory.getLogger(DeputyBindingSenderServiceImpl.class);

  @Value("${ltci.deputyBindingSendCase.exchange}")
  private String exchangeName;

  @Value("${ltci.deputyBindingSendCase.queue}")
  private String routingKey;

  @Value("${ltci.deputyBindingSend.messageCode}")
  private String messageCode;

  @Autowired private AmqpTemplate rabbitTemplate;

  @Autowired private MQMessageLogDAO mqMessageLogDAO;
  @Autowired private IMqFailMessageLogDAO mqFailMessageLogDAO;

  @Value("${systemCode}")
  protected String systemCode;

  @Value("${systemCharset}")
  private String systemCharset;

  @Override
  public void send(String context) {
    try {
      byte[] bytes = context.getBytes(systemCharset);
      rabbitTemplate.convertAndSend(exchangeName, routingKey, bytes);
    } catch (UnsupportedEncodingException e) {
      logger.error("MQ发送：", e);
      throw new ThrowsException("发送MQ解析String为byte[]时出错");
    }
  }

  @Override
  public void sendDeputyBingdingState(
      String serialNumber,
      String deputyName,
      String deputyIdCard,
      String idCard,
      String securityNumber,
      String checkState,
      String checkReason,
      String insuredPersonName) {
    HashMap<String, Object> map = new HashMap<>();
    map.put("serialNumber", serialNumber);
    map.put("deputyName", deputyName);
    map.put("deputyIdCard", deputyIdCard);
    map.put("securityNumber", securityNumber);
    map.put("checkState", checkState);
    map.put("checkReason", checkReason);
    map.put("idCard", idCard);
    map.put("insuredPersonName", insuredPersonName);
    map.put("operatedTime", System.currentTimeMillis());

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
    mqBaseModel.setModuleCode(ModuleCodeEnum.SEND_EVALUATE_TASK.getValue());
    mqBaseModel.setMessageCode(messageCode);
    mqBaseModel.setData(map);
    //创建日志基本信息
    MQMessageLogDO mqLogDo = new MQMessageLogDO();
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
    //2.发送MQ信息

    try {
      //3.保存日志信息
      send(jsonString);
      mqMessageLogDAO.insert(mqLogDo);
    } catch (Exception e) {
      logger.error("发送mq失败，存入错误日志表", e);
      MqFailMessageLogDO failLog = new MqFailMessageLogDO();
      failLog.setId(mqBaseModel.getBusinessSerialid().replaceAll("-", ""));
      failLog.setTransportType(TransportTypeEnum.ASYNCHRONIZE.getValue()); //交互方式：异步
      failLog.setOperationType(OperationTypeEnum.SEND.getValue()); //发送类型
      failLog.setContent(jsonString);
      failLog.setErrorMessage(e.getMessage());
      failLog.setCreateTime(new Date());
      failLog.setExchangeName(exchangeName);
      mqFailMessageLogDAO.insertSelective(failLog);
    }
  }
}
