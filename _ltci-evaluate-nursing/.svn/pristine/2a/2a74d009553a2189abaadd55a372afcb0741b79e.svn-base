package com.taikang.dic.ltci.service.impl;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.ErrorReasonStateEnum;
import com.taikang.dic.ltci.common.enumeration.ExecutionScheduleEnum;
import com.taikang.dic.ltci.common.enumeration.ExecutionStatusEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.enumeration.ThirdInterfaceLogEnum;
import com.taikang.dic.ltci.common.util.IPUtil;
import com.taikang.dic.ltci.common.ws.ErrorReason;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.MQMessageLogDAO;
import com.taikang.dic.ltci.dao.ScheduleDAO;
import com.taikang.dic.ltci.dao.ThirdInterfaceLogDAO;
import com.taikang.dic.ltci.model.BaseModel;
import com.taikang.dic.ltci.model.CheckInDO;
import com.taikang.dic.ltci.model.MQMessageLogDO;
import com.taikang.dic.ltci.model.MqBaseModel;
import com.taikang.dic.ltci.model.ScheduleDO;
import com.taikang.dic.ltci.model.ScheduleDOExample;
import com.taikang.dic.ltci.model.ThirdInterfaceLogDO;
import com.taikang.dic.ltci.model.ThirdInterfaceLogDOExample;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.ScheduleService;

@Service
public class ScheduleServiceImpl extends AbstractGenericService<MQMessageLogDO, String>
    implements ScheduleService {

  @Autowired private ScheduleDAO scheduleDAO;

  @Autowired private ThirdInterfaceLogDAO thirdInterfaceLogDAO;

  @Autowired private CheckInServiceImpl checkInServiceImpl;

  @Autowired private MQMessageLogDAO mQMessageLogDAO;

  @Value(value = "${spring.application.name}")
  private String systemCode;

  /**
   * 定时重发到第三方接口 第三方接口（评估护理服务）调用失败，会记录错误信息到第三方日志表 本定时任务，扫描第三方日志表，对失败数据进行重新发送，如果成则更新为成功；
   * 如果失败，则更新重发次数，失败超过三次则放弃重发，并记录人工处理表，让人工进行处理
   *
   * <p>重新处理协议入住
   *
   * @return
   */
  @Scheduled(cron = "${reCheckInAndToDRTiming}")
  public ResultDTO reCheckInAndToDR() {
    logger.info("____begin reCheckInAndToDR____");
    long begin = System.currentTimeMillis();
    ResultDTO resultDTO = new ResultDTO();
    try {
      if (!getLock("reCheckInAndToDR")) {
        resultDTO.setStatus(StatusCodeEnum.OK.getValue());
        resultDTO.setMessage("其他服务器正在新增评估任务的定时任务的业务操作！");
        return resultDTO;
      }

      ThirdInterfaceLogDOExample doe = new ThirdInterfaceLogDOExample();
      doe.createCriteria()
          .andTypeEqualTo(ThirdInterfaceLogEnum.TYPE_CHECK_IN.getValue())
          .andBusiTypeEqualTo(ThirdInterfaceLogEnum.BUSI_TYPE_04.getValue())
          .andReSendNumLessThanOrEqualTo(3)
          .andIsSendSuccessEqualTo(0);

      int count = thirdInterfaceLogDAO.countByExample(doe);
      int pageSize = 10; //每次查询30条数据
      int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
      ThirdInterfaceLogDOExample texample = doe;
      for (int i = 1; i <= totalPage; i++) {
        int pageIndex = (i - 1) * pageSize;
        texample.setOrderByClause(" create_time asc  limit " + pageIndex + " , " + pageSize + " ");
        List<ThirdInterfaceLogDO> thirdInterfaceLogDoList =
            thirdInterfaceLogDAO.selectByExample(texample);
        for (ThirdInterfaceLogDO ddo : thirdInterfaceLogDoList) {
          String sendContent = ddo.getSendContent();
          MqBaseModel mqBaseModel = JSONObject.parseObject(sendContent, MqBaseModel.class);
          //重新 新增协议入住，并且推送给东软
          reCheckInAndToDR(ddo, mqBaseModel);
        }
      }
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    } finally {
      releaseLock("reCheckInAndToDR");
    }
    logger.info("____end reCheckInAndToDR___耗时S:" + ((System.currentTimeMillis()) - begin) / 1000);
    return resultDTO;
  }

  /**
   * 定时重新处理协议退出
   *
   * @return
   */
  @Scheduled(cron = "${reCheckOutAndToDRTiming}")
  public ResultDTO reCheckOutAndToDR() {
    logger.info("____begin reCheckOutAndToDR____");
    long begin = System.currentTimeMillis();
    ResultDTO resultDTO = new ResultDTO();
    try {
      if (!getLock("reCheckOutAndToDR")) {
        resultDTO.setStatus(StatusCodeEnum.OK.getValue());
        resultDTO.setMessage("其他服务器正在新增评估任务的定时任务的业务操作！");
        return resultDTO;
      }

      ThirdInterfaceLogDOExample doe = new ThirdInterfaceLogDOExample();
      doe.createCriteria()
          .andTypeEqualTo(ThirdInterfaceLogEnum.TYPE_CHECK_OUT.getValue())
          .andBusiTypeEqualTo(ThirdInterfaceLogEnum.BUSI_TYPE_05.getValue())
          .andReSendNumLessThanOrEqualTo(3)
          .andIsSendSuccessEqualTo(0);

      int count = thirdInterfaceLogDAO.countByExample(doe);
      int pageSize = 10; //每次查询30条数据
      int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
      ThirdInterfaceLogDOExample texample = doe;
      for (int i = 1; i <= totalPage; i++) {
        int pageIndex = (i - 1) * pageSize;
        texample.setOrderByClause(" create_time asc  limit " + pageIndex + " , " + pageSize + " ");
        List<ThirdInterfaceLogDO> thirdInterfaceLogDoList =
            thirdInterfaceLogDAO.selectByExample(texample);
        for (ThirdInterfaceLogDO ddo : thirdInterfaceLogDoList) {
          String sendContent = ddo.getSendContent();
          MqBaseModel mqBaseModel = JSONObject.parseObject(sendContent, MqBaseModel.class);
          //重新 新增协议退出，并且推送给东软
          reCheckOutAndToDR(ddo, mqBaseModel);
        }
      }
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    } finally {
      releaseLock("reCheckOutAndToDR");
    }
    logger.info("____end reCheckOutAndToDR___耗时S:" + ((System.currentTimeMillis()) - begin) / 1000);
    return resultDTO;
  }

  /**
   * 定时重新处理经办的协议退出
   *
   * @return
   */
  @Scheduled(cron = "${reUpdateCheckInAndToDRTiming}")
  public ResultDTO reUpdateCheckInAndToDR() {
    logger.info("____begin reUpdateCheckInAndToDR____");
    long begin = System.currentTimeMillis();
    ResultDTO resultDTO = new ResultDTO();
    try {
      if (!getLock("reUpdateCheckInAndToDR")) {
        resultDTO.setStatus(StatusCodeEnum.OK.getValue());
        resultDTO.setMessage("其他服务器正在处理协议退出的定时任务的业务操作！");
        return resultDTO;
      }

      ThirdInterfaceLogDOExample doe = new ThirdInterfaceLogDOExample();
      doe.createCriteria()
          .andTypeEqualTo(ThirdInterfaceLogEnum.TYPE_CHECK_OUT_JINGBAN.getValue())
          .andBusiTypeEqualTo(ThirdInterfaceLogEnum.BUSI_TYPE_06.getValue())
          .andReSendNumLessThanOrEqualTo(3)
          .andIsSendSuccessEqualTo(0);

      int count = thirdInterfaceLogDAO.countByExample(doe);
      int pageSize = 10; //每次查询30条数据
      int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
      ThirdInterfaceLogDOExample texample = doe;
      for (int i = 1; i <= totalPage; i++) {
        int pageIndex = (i - 1) * pageSize;
        texample.setOrderByClause(" create_time asc  limit " + pageIndex + " , " + pageSize + " ");
        List<ThirdInterfaceLogDO> thirdInterfaceLogDoList =
            thirdInterfaceLogDAO.selectByExample(texample);
        for (ThirdInterfaceLogDO ddo : thirdInterfaceLogDoList) {
          String sendContent = ddo.getSendContent();
          CheckInDO checkInDO = JSONObject.parseObject(sendContent, CheckInDO.class);
          //重新 新增协议退出，并且推送给东软
          reUpdateCheckInAndToDR(ddo, checkInDO);
        }
      }
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    } finally {
      releaseLock("reUpdateCheckInAndToDR");
    }
    logger.info(
        "____end reUpdateCheckInAndToDR___耗时S:" + ((System.currentTimeMillis()) - begin) / 1000);
    return resultDTO;
  }

  /**
   * 判断是否可以获取锁，返回true表示拿到锁，可以继续执行，返回false表示锁定状态，不可以继续执行
   *
   * @return
   */
  private boolean getLock(String moudleType) {
    ScheduleDOExample doExample = new ScheduleDOExample();
    ScheduleDOExample.Criteria criteria = doExample.createCriteria();
    criteria.andMoudleTypeEqualTo(moudleType);
    List<ScheduleDO> list = scheduleDAO.selectByExample(doExample);

    String ip = "";
    try {
      ip = IPUtil.getLocalIp();
    } catch (UnknownHostException | SocketException e) {
      logger.error("获取本机服务器IP失败：", e);
    }

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
        logger.info("其他服务器正在执行评估任务提醒的定时任务的业务操作，" + ip + " 服务器停止执行");
        return false;
      }
      logger.info("服务器" + ip + "开始执行评估任务提醒的定时任务的业务操作");
    } else {
      //未超期，但是现在状态为执行状态
      if (scheduleDO.getExecutionSchedule() == ExecutionScheduleEnum.ON.getValue()) {
        logger.info("其他服务器在执行评估任务提醒的定时任务的业务操作，" + ip + "服务器停止执行");
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
          logger.info("其他服务器在执行评估任务提醒的定时任务的业务操作，" + ip + "服务器停止执行");
          return false;
        }
        logger.info("服务器" + ip + "开始执行评估任务提醒的定时任务的业务操作");
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

  /**
   * 重新 新增协议入住，并且推送给东软
   *
   * @param ddo
   * @param mqBaseModel
   */
  private void reCheckInAndToDR(ThirdInterfaceLogDO ddo, MqBaseModel mqBaseModel) {
    try {
      //开始重新 发送 协议入住信息
      ErrorReason errorReason = checkInServiceImpl.checkInAndToDR(mqBaseModel);

      ddo.setReveiceContent(JSONObject.toJSONString(mqBaseModel));
      ddo.setReveiceTime(new Date());

      if (ErrorReasonStateEnum.IS_SUCCESS
          .getValue()
          .equals(errorReason.getErrorReasonCode())) { //插入东软成功
        ddo.setIsSendSuccess(1);
      } else { //插入东软失败
        ddo.setIsSendSuccess(0);
        ddo.setFailMessage(errorReason.getErrorReason());
      }
    } catch (Exception e) {
      ddo.setIsSendSuccess(0);
      ddo.setFailMessage(e.getMessage());
      logger.error("reCheckInAndToDR 新增协议入住并通知东软失败：" + e);
    }
    //更新重发次数
    checkInServiceImpl.insertInterfaceLog(ddo);
  }

  /**
   * 重新 新增协议退出，并且推送给东软
   *
   * @param ddo
   * @param mqBaseModel
   */
  private void reCheckOutAndToDR(ThirdInterfaceLogDO ddo, MqBaseModel mqBaseModel) {
    try {
      //开始重新 发送 协议入住信息
      ErrorReason errorReason = checkInServiceImpl.checkOutAndToDR(mqBaseModel);

      ddo.setReveiceContent(JSONObject.toJSONString(mqBaseModel));
      ddo.setReveiceTime(new Date());

      if (ErrorReasonStateEnum.IS_SUCCESS
          .getValue()
          .equals(errorReason.getErrorReasonCode())) { //插入东软成功
        ddo.setIsSendSuccess(1);
      } else { //插入东软失败
        ddo.setIsSendSuccess(0);
        ddo.setFailMessage(errorReason.getErrorReason());
      }
    } catch (Exception e) {
      ddo.setIsSendSuccess(0);
      ddo.setFailMessage(e.getMessage());
      logger.error("reCheckOutAndToDR 协议退出并通知东软失败：" + e);
    }
    //更新重发次数
    checkInServiceImpl.insertInterfaceLog(ddo);
  }

  /**
   * 重新经办协议退出，并且推送给东软
   *
   * @param ddo
   * @param checkInDO
   */
  private void reUpdateCheckInAndToDR(ThirdInterfaceLogDO ddo, CheckInDO checkInDO) {
    try {
      //开始重新 发送 协议退出信息信息
      int updateResult = checkInServiceImpl.updateCheckInAndToDR(checkInDO);

      ddo.setReveiceContent(JSONObject.toJSONString(checkInDO));
      ddo.setReveiceTime(new Date());

      if (updateResult > 0) { //修改成功
        ddo.setIsSendSuccess(1);
      } else { //插入东软失败
        ddo.setIsSendSuccess(0);
        ddo.setFailMessage("经办修改协议退出失败");
      }
    } catch (Exception e) {
      ddo.setIsSendSuccess(0);
      ddo.setFailMessage(e.getMessage());
      logger.error("reUpdateCheckInAndToDR 经办协议退出并通知东软失败：" + e);
    }
    //更新重发次数
    checkInServiceImpl.insertInterfaceLog(ddo);
  }

  @Override
  public IGenericDAO<MQMessageLogDO, String> getDao() {
    return mQMessageLogDAO;
  }
}
