package com.taikang.dic.ltci.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.ExecutionScheduleEnum;
import com.taikang.dic.ltci.common.enumeration.ExecutionStatusEnum;
import com.taikang.dic.ltci.common.enumeration.OperationTypeEnum;
import com.taikang.dic.ltci.common.enumeration.TransportTypeEnum;
import com.taikang.dic.ltci.common.util.IPUtil;
import com.taikang.dic.ltci.dao.IMqFailMessageLogDAO;
import com.taikang.dic.ltci.dao.ScheduleDAO;
import com.taikang.dic.ltci.model.BaseModel;
import com.taikang.dic.ltci.model.MqFailMessageLogDO;
import com.taikang.dic.ltci.model.MqFailMessageLogDOExample;
import com.taikang.dic.ltci.model.MqFailMessageLogDOExample.Criteria;
import com.taikang.dic.ltci.model.ScheduleDO;
import com.taikang.dic.ltci.model.ScheduleDOExample;

@Component
public class ScheduleMqFailRetry {

  private static final Logger logger = LoggerFactory.getLogger(ScheduleMqFailRetry.class);

  @Autowired private IMqFailMessageLogDAO failMessageLogDAO;
  @Autowired private ScheduleDAO scheduleDAO;
  @Autowired private AmqpTemplate rabbitTemplate;
  private RestTemplate restTemplate = new RestTemplate();

  @Value("${systemCharset}")
  private String systemCharset;

  /** 每小时执行一次，将mq 接收/发送 失败的消息重新处理 */
  @Scheduled(cron = "${retryFailMessageTiming:00 00 0/1 * * ?}")
  public void retryFailMessage() {

    logger.info("____begin retryFailMessageTiming");
    long begin = System.currentTimeMillis();
    if (!getLock("retryFailMessageTiming")) {
      logger.info("获取执行锁失败，其他服务器正在处理！");
      return;
    }
    MqFailMessageLogDOExample example = new MqFailMessageLogDOExample();
    Criteria criteria = example.createCriteria();
    criteria.andRetryNumLessThan(3); //重试次数小于3
    //查询 重试次数小于3的
    List<MqFailMessageLogDO> messageList = failMessageLogDAO.selectByExampleWithBLOBs(example);
    logger.info("获取需要重试的异常数据" + messageList.size() + "条");
    for (MqFailMessageLogDO mqFailMessageLogDO : messageList) {
      if (TransportTypeEnum.ASYNCHRONIZE.getValue().equals(mqFailMessageLogDO.getTransportType())
          && OperationTypeEnum.RECEIVE.getValue().equals(mqFailMessageLogDO.getOperationType())) {
        //异步 接收
        retryMqReceive(mqFailMessageLogDO);
      } else if (TransportTypeEnum.ASYNCHRONIZE
              .getValue()
              .equals(mqFailMessageLogDO.getTransportType())
          && OperationTypeEnum.SEND.getValue().equals(mqFailMessageLogDO.getOperationType())) {
        //异步发送
        retryMqSend(mqFailMessageLogDO);
      }
    }
    releaseLock("retryFailMessageTiming");
    logger.info(
        "____end retryFailMessageTiming耗时S:" + ((System.currentTimeMillis()) - begin) / 1000);
  }

  /**
   * mq 发送异常重试
   *
   * @param mqFailMessageLog
   */
  private void retryMqSend(MqFailMessageLogDO mqFailMessageLog) {
    try {
      rabbitTemplate.convertAndSend(
          mqFailMessageLog.getExchangeName(),
          "jingmen",
          mqFailMessageLog.getContent().getBytes(systemCharset));
      //成功删除此数据
      failMessageLogDAO.deleteByPrimaryKey(mqFailMessageLog.getId());
      logger.info(
          "定时任务重新发送MQ数据id:"
              + mqFailMessageLog.getId()
              + ",exChangeName:"
              + mqFailMessageLog.getExchangeName()
              + "成功");
    } catch (AmqpException | UnsupportedEncodingException e) {
      logger.error(
          "定时任务重新发送MQ数据id:"
              + mqFailMessageLog.getId()
              + ",exChangeName:"
              + mqFailMessageLog.getExchangeName()
              + "失败：",
          e);
      //失败重试次数加1
      mqFailMessageLog.setRetryNum(mqFailMessageLog.getRetryNum() + 1);
      failMessageLogDAO.updateByPrimaryKeySelective(mqFailMessageLog);
    }
  }
  /**
   * 异步接收异常重试
   *
   * @param mqFailMessageLogDO
   */
  private void retryMqReceive(MqFailMessageLogDO mqFailMessageLogDO) {
    String retryUrl = mqFailMessageLogDO.getRetryUrl();
    String content = mqFailMessageLogDO.getContent();
    MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
    List<String> list = new ArrayList<>();
    list.add(content);
    map.put("message", list);
    try {
      ResultDTO result = restTemplate.postForObject(retryUrl, map, ResultDTO.class);
      if (ExecutionStatusEnum.SUCCESS.getValue() == result.getStatus()) {
        failMessageLogDAO.deleteByPrimaryKey(mqFailMessageLogDO.getId());
        logger.info(
            "定时任务重新接收MQ数据id:" + mqFailMessageLogDO.getId() + ",retryUrl:" + retryUrl + "成功");
      } else {
        logger.info(
            "定时任务重新接收MQ数据id:" + mqFailMessageLogDO.getId() + ",retryUrl:" + retryUrl + "失败");
      }
    } catch (Exception e) {
      mqFailMessageLogDO.setRetryNum(mqFailMessageLogDO.getRetryNum() + 1);
      failMessageLogDAO.updateByPrimaryKeySelective(mqFailMessageLogDO);
      logger.error(
          "定时任务重新接收MQ数据id:" + mqFailMessageLogDO.getId() + ",retryUrl:" + retryUrl + "失败：", e);
    }
  }

  /**
   * 判断是否可以获取锁，返回true表示拿到锁，可以继续执行，返回false表示锁定状态，不可以继续执行
   *
   * @return
   */
  private boolean getLock(String moudleType) {
    String ip = "";
    try {
      ip = IPUtil.getLocalIp();
    } catch (UnknownHostException | SocketException e) {
      logger.error("获取本机服务器IP失败：", e);
    }
    ScheduleDOExample doExample = new ScheduleDOExample();
    ScheduleDOExample.Criteria criteria = doExample.createCriteria();
    criteria.andMoudleTypeEqualTo(moudleType);
    List<ScheduleDO> list = scheduleDAO.selectByExample(doExample);
    if (list.isEmpty()) {
      ScheduleDO scheduleDO = new ScheduleDO();
      scheduleDO.setExecutionSchedule(ExecutionScheduleEnum.ON.getValue());
      scheduleDO.setExecutionStatus(ExecutionStatusEnum.SUCCESS.getValue());
      scheduleDO.setTimeWindow(60); //窗口期 60分钟
      scheduleDO.setVersion(1L);
      scheduleDO.setId(BaseModel.getUUID());
      scheduleDO.setIp(ip);
      scheduleDO.setMoudleType(moudleType);
      scheduleDO.setOperatedTime(new Date());
      scheduleDAO.insertSelective(scheduleDO);
      return true;
    }
    ScheduleDO scheduleDO = list.get(0);
    Date operatedTime = scheduleDO.getOperatedTime();
    int timeWindow = scheduleDO.getTimeWindow();

    Calendar nowCalendar = Calendar.getInstance();
    Calendar operatedCalendar = Calendar.getInstance();
    operatedCalendar.setTime(operatedTime);

    operatedCalendar.add(Calendar.MINUTE, timeWindow);

    if (nowCalendar.after(operatedCalendar)) {
      //超过窗口期，将状态改为开始，修改版本号和开始时间
      if (scheduleDO.getExecutionSchedule() == ExecutionScheduleEnum.ON.getValue()) {
        logger.info("上次定时任务执行失败的服务器IP为：" + ip);
      }
      logger.info("距离上次执行定时任务的时间间隔超过窗口期（" + scheduleDO.getTimeWindow() + "分钟）时间！");
      scheduleDO.setExecutionSchedule(ExecutionScheduleEnum.ON.getValue());
      scheduleDO.setVersion(scheduleDO.getVersion() + 1);
      scheduleDO.setOperatedTime(new Date());
      scheduleDO.setIp(ip);
      scheduleDO.setExecutionStatus(ExecutionStatusEnum.SUCCESS.getValue());
      int size = scheduleDAO.updateByExampleSelective(scheduleDO, doExample);
      if (size == 0) {
        logger.info("其他服务器正在执行定时任务的业务操作，" + ip + " 服务器停止执行");
        return false;
      }
      logger.info("服务器" + ip + "开始执行定时任务的业务操作");
    } else {
      //未超期，但是现在状态为执行状态
      if (scheduleDO.getExecutionSchedule() == ExecutionScheduleEnum.ON.getValue()) {
        logger.info("其他服务器在执行定时任务的业务操作，" + ip + "服务器停止执行");
        return false;
      } else {
        //未超期，现在为完成状态，修改为当前服务器的执行状态
        scheduleDO.setExecutionSchedule(ExecutionScheduleEnum.ON.getValue());
        scheduleDO.setVersion(scheduleDO.getVersion() + 1);
        scheduleDO.setOperatedTime(new Date());
        scheduleDO.setIp(ip);
        scheduleDO.setExecutionStatus(ExecutionStatusEnum.SUCCESS.getValue());
        int size = scheduleDAO.updateByExampleSelective(scheduleDO, doExample);
        if (size == 0) {
          logger.info("其他服务器在执行定时任务的业务操作，" + ip + "服务器停止执行");
          return false;
        }
        logger.info("服务器" + ip + "开始执行定时任务的业务操作");
      }
    }
    return true;
  }

  /** 重置状态锁 */
  public void releaseLock(String moudleType) {
    ScheduleDO scheduleDO = new ScheduleDO();
    ScheduleDOExample doExample = new ScheduleDOExample();
    ScheduleDOExample.Criteria criteria = doExample.createCriteria();
    criteria.andMoudleTypeEqualTo(moudleType);

    scheduleDO.setExecutionSchedule(ExecutionScheduleEnum.OFF.getValue());
    scheduleDO.setExecutionStatus(ExecutionStatusEnum.SUCCESS.getValue());
    scheduleDAO.updateByExampleSelective(scheduleDO, doExample);
  }
}
