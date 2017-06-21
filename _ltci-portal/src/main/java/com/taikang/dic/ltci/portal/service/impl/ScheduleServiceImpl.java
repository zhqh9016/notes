package com.taikang.dic.ltci.portal.service.impl;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.evaluate.nursing.serviceClient.EvaluateTaskServerClient;
import com.taikang.dic.ltci.portal.api.model.EvaluateTaskDTO;
import com.taikang.dic.ltci.portal.api.model.RestResponseDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.UserPushDTO;
import com.taikang.dic.ltci.portal.api.model.UserPushResultDTO;
import com.taikang.dic.ltci.portal.common.enumeration.ExecutionScheduleEnum;
import com.taikang.dic.ltci.portal.common.enumeration.ExecutionStatusEnum;
import com.taikang.dic.ltci.portal.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.portal.common.enumeration.ThirdInterfaceLogEnum;
import com.taikang.dic.ltci.portal.common.restRequestResponse.RestResponseFormat;
import com.taikang.dic.ltci.portal.common.util.IPUtil;
import com.taikang.dic.ltci.portal.dao.ScheduleDAO;
import com.taikang.dic.ltci.portal.dao.ThirdInterfaceLogDAO;
import com.taikang.dic.ltci.portal.model.BaseModel;
import com.taikang.dic.ltci.portal.model.ScheduleDO;
import com.taikang.dic.ltci.portal.model.ScheduleDOExample;
import com.taikang.dic.ltci.portal.model.ThirdInterfaceLogDO;
import com.taikang.dic.ltci.portal.model.ThirdInterfaceLogDOExample;
import com.taikang.dic.ltci.portal.service.ScheduleService;
import com.taikang.dic.ltci.system.common.enumeration.PushUserStateCodeEnum;
import com.taikang.dic.ltci.system.serverClient.UserPushServerClient;

@Service
public class ScheduleServiceImpl implements ScheduleService {
  private static final Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);

  @Autowired private ScheduleDAO scheduleDAO;

  @Autowired private ThirdInterfaceLogDAO thirdInterfaceLogDAO;

  @Autowired private EvaluateTaskServerClient evaluateTaskServerClient;

  @Value(value = "${spring.application.name}")
  private String systemCode;

  @Autowired private UserPushServerClient userPushServerClient;

  @Value(value = "${user.push.cityId}")
  private String cityId;

  /**
   * 定时重发到第三方接口 第三方接口（评估护理服务）调用失败，会记录错误信息到第三方日志表 本定时任务，扫描第三方日志表，对失败数据进行重新发送，如果成则更新为成功；
   * 如果失败，则更新重发次数，失败超过三次则放弃重发，并记录人工处理表，让人工进行处理
   *
   * @return
   */
  @Scheduled(cron = "${reSend2ExpertTaskAdd}")
  public ResultDTO reSend2ExpertTaskAdd() {
    logger.info("____begin reSend2ExpertTaskAdd____");
    long begin = System.currentTimeMillis();
    ResultDTO resultDTO = new ResultDTO();
    try {
      if (!getLock("reSend2ExpertTaskAdd")) {
        resultDTO.setStatus(StatusCodeEnum.OK.getValue());
        resultDTO.setMessage("其他服务器正在新增评估任务的定时任务的业务操作！");
        return resultDTO;
      }

      ThirdInterfaceLogDOExample doe = new ThirdInterfaceLogDOExample();
      doe.createCriteria()
          .andTypeEqualTo(ThirdInterfaceLogEnum.TYPE_EVALUATE_NURSING.getValue())
          .andBusiTypeEqualTo(ThirdInterfaceLogEnum.BUSI_TYPE_03.getValue())
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
          EvaluateTaskDTO evaluateTaskDTO =
              JSONObject.parseObject(sendContent, EvaluateTaskDTO.class);
          //重新 发送 评估任务新增
          reExpertTaskAdd(ddo, evaluateTaskDTO);
        }
      }
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    } finally {
      releaseLock("reSend2ExpertTaskAdd");
    }
    logger.info(
        "____end reSend2ExpertTaskAdd___耗时S:" + ((System.currentTimeMillis()) - begin) / 1000);
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
   * 重新 发送 评估任务新增
   *
   * @param ddo
   * @param evaluateTaskDTO
   */
  private void reExpertTaskAdd(ThirdInterfaceLogDO ddo, EvaluateTaskDTO evaluateTaskDTO) {
    try {
      //开始重新 发送 评估任务新增
      RestResponseDTO evaluateTaskRestResponseDTO =
          evaluateTaskServerClient.expertTaskAdd(evaluateTaskDTO, systemCode);
      ResultDTO evaluateTaskResultDTO =
          RestResponseFormat.restResponseDTO2ResultDTO(evaluateTaskRestResponseDTO);

      ddo.setReveiceContent(JSONObject.toJSONString(evaluateTaskResultDTO));
      ddo.setReveiceTime(new Date());
      if (StatusCodeEnum.CREATED.getValue().equals(evaluateTaskResultDTO.getStatus())) {
        ddo.setIsSendSuccess(1);
      } else {
        ddo.setIsSendSuccess(0);
        ddo.setFailMessage(evaluateTaskResultDTO.getMessage());
      }
    } catch (Exception e) {
      ddo.setIsSendSuccess(0);
      ddo.setFailMessage(e.getMessage());
      logger.error(
          "ltci-portal TreatmentApplicationServiceImpl caseTreatmentApplicationStauts 审核通过，创建评估任务失败："
              + e);
    }
    //更新重发次数
    insertInterfaceLog(ddo);
  }

  /**
   * 保存或更新第三方日志表
   *
   * @param log
   * @return
   */
  public boolean insertInterfaceLog(ThirdInterfaceLogDO log) {
    ThirdInterfaceLogDOExample doe = new ThirdInterfaceLogDOExample();
    doe.createCriteria()
        .andBusiTypeEqualTo(log.getBusiType())
        .andTypeEqualTo(ThirdInterfaceLogEnum.TYPE_EVALUATE_NURSING.getValue())
        .andBusiDataIdEqualTo(log.getBusiDataId());
    List<ThirdInterfaceLogDO> list = thirdInterfaceLogDAO.selectByExample(doe);
    if (list != null && !list.isEmpty()) {
      //更新失败次数
      ThirdInterfaceLogDO ldo = list.get(0);
      ldo.setSendContent(log.getSendContent());
      ldo.setSendTime(log.getSendTime());
      ldo.setReveiceContent(log.getReveiceContent());
      ldo.setReveiceTime(log.getReveiceTime());
      ldo.setIsSendSuccess(log.getIsSendSuccess());
      ldo.setReSendNum(ldo.getReSendNum() + 1);
      //重试三次记录错误日志表
      return thirdInterfaceLogDAO.updateByPrimaryKeySelective(ldo) > 0;
    } else if (log.getIsSendSuccess() == 0) {
      ThirdInterfaceLogDO third = new ThirdInterfaceLogDO();
      third.setId(UUID.randomUUID().toString().replaceAll("-", ""));
      third.setType(ThirdInterfaceLogEnum.TYPE_EVALUATE_NURSING.getValue()); //评估护理服务
      third.setBusiType(log.getBusiType());
      third.setBusiDataId(log.getBusiDataId());
      third.setCreateTime(new Date());
      third.setSendContent(log.getSendContent());
      third.setSendTime(log.getSendTime());
      third.setReveiceContent(log.getReveiceContent());
      third.setReveiceTime(log.getReveiceTime());
      return thirdInterfaceLogDAO.insertSelective(third) > 0;
    } else {
      return false;
    }
  }

  /**
   * 定时重发到第三方接口 第三方接口（推送用户）调用失败，会记录错误信息到第三方日志表 本定时任务，扫描第三方日志表，对失败数据进行重新发送，如果成则更新为成功；
   * 如果失败，则更新重发次数，失败超过三次则放弃重发，并记录人工处理表，让人工进行处理
   *
   * @return
   */
  @Scheduled(cron = "0 0/2 * * * ?")
  public ResultDTO reSend2PushUser() {
    logger.info("____begin reSend2PushUser____");
    long begin = System.currentTimeMillis();
    ResultDTO resultDTO = new ResultDTO();
    try {
      if (!getLock("reSend2UserAdd")) {
        resultDTO.setStatus(StatusCodeEnum.OK.getValue());
        resultDTO.setMessage("其他服务器正在推送用户的定时任务的业务操作！");
        return resultDTO;
      }

      ThirdInterfaceLogDOExample doe = new ThirdInterfaceLogDOExample();
      doe.createCriteria()
          .andTypeEqualTo(ThirdInterfaceLogEnum.TYPE_PUSH_USER.getValue())
          .andBusiTypeEqualTo(ThirdInterfaceLogEnum.BUSI_PUSH_USER.getValue())
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
          UserPushDTO userPushDTO = JSONObject.parseObject(sendContent, UserPushDTO.class);
          //重新 发送 用户信息
          reExpertPushUser(ddo, userPushDTO);
        }
      }
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    } finally {
      releaseLock("reSend2PushUser");
    }
    logger.info("____end reSend2PushUser___耗时S:" + ((System.currentTimeMillis()) - begin) / 1000);
    return resultDTO;
  }

  /**
   * 重新 发送 评估任务新增
   *
   * @param ddo
   * @param evaluateTaskDTO
   */
  private void reExpertPushUser(ThirdInterfaceLogDO ddo, UserPushDTO userPushDTO) {
    try {
      // 向大数据推送用户信息
      UserPushResultDTO pushUserResultDto = userPushServerClient.pushUser(userPushDTO);

      ddo.setReveiceContent(JSONObject.toJSONString(pushUserResultDto));
      ddo.setReveiceTime(new Date());
      if (PushUserStateCodeEnum.SUCCESS.getValue().equals(pushUserResultDto.getCode())) {
        ddo.setIsSendSuccess(1);
      } else {
        ddo.setIsSendSuccess(0);
        ddo.setFailMessage(pushUserResultDto.getMsg());
      }
    } catch (Exception e) {
      ddo.setIsSendSuccess(0);
      ddo.setFailMessage(e.getMessage());
      logger.error("ltci-portal reSend2PushUser 推送用户信息失败：" + e);
    }
    //更新重发次数
    insertInterfaceLog(ddo);
  }
}
