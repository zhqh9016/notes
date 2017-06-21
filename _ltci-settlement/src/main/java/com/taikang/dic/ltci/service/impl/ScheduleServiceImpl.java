package com.taikang.dic.ltci.service.impl;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.IsValidEnum;
import com.taikang.dic.ltci.common.enumeration.ExecutionScheduleEnum;
import com.taikang.dic.ltci.common.enumeration.ExecutionStatusEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.enumeration.ThirdInterfaceLogEnum;
import com.taikang.dic.ltci.common.util.IPUtil;
import com.taikang.dic.ltci.dao.INurseDetailDAO;
import com.taikang.dic.ltci.dao.ScheduleDAO;
import com.taikang.dic.ltci.dao.ServiceItemDAO;
import com.taikang.dic.ltci.dao.ThirdInterfaceLogDAO;
import com.taikang.dic.ltci.model.NurseDetailDO;
import com.taikang.dic.ltci.model.NurseDetailDOExample;
import com.taikang.dic.ltci.model.ScheduleDO;
import com.taikang.dic.ltci.model.ScheduleDOExample;
import com.taikang.dic.ltci.model.ServiceItemDO;
import com.taikang.dic.ltci.model.ThirdInterfaceLogDO;
import com.taikang.dic.ltci.model.ThirdInterfaceLogDOExample;
import com.taikang.dic.ltci.service.INurseDetailService;
import com.taikang.dic.ltci.service.ScheduleService;
import com.taikang.dic.ltci.service.WSService;

@Service
public class ScheduleServiceImpl implements ScheduleService {
  private static final Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);

  @Autowired ScheduleDAO scheduleDAO;

  @Autowired ThirdInterfaceLogDAO thirdInterfaceLogDAO;

  @Autowired INurseDetailService nurseDetailService;

  @Autowired INurseDetailDAO nerseDetailDAO;

  @Autowired WSService wSService;

  @Autowired ServiceItemDAO serviceItemDAO;
  /**
   * 定时重发到第三方接口（护理费用明细及日结算交易） 业务规则：第三方接口（社保）调用失败，会记录错误信息到第三方日志表
   * 本定时任务，扫描第三方日志表，对失败数据进行重新发送，如果成则更新为成功； 如果失败，则更新重发次数，失败超过三次则放弃重发
   *
   * @return
   */
  @Scheduled(cron = "${scheduled.cron.reSend2ThirdOfNurseFeeDetail}") //每一小时执行一次
  public ResultDTO reSend2ThirdOfNurseFeeDetail() {
    logger.info("____begin reSend2ThirdOfNurseFeeDetail____");
    long begin = System.currentTimeMillis();
    ResultDTO resultDTO = new ResultDTO();
    try {
      if (!getLock("reSend2ThirdOfNurseFeeDetail")) {
        resultDTO.setStatus(StatusCodeEnum.OK.getValue());
        resultDTO.setMessage("其他服务器正在执行[reSend2ThirdOfServiceProject]的业务操作！");
        return resultDTO;
      }

      ThirdInterfaceLogDOExample doe = new ThirdInterfaceLogDOExample();
      doe.createCriteria()
          .andBusiTypeEqualTo(ThirdInterfaceLogEnum.BUSI_TYPE_01.getValue())
          .andTypeEqualTo(ThirdInterfaceLogEnum.TYPE_SB.getValue())
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
          String id = ddo.getBusiDataId();
          NurseDetailDOExample nde = new NurseDetailDOExample();
          nde.createCriteria().andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue()).andIdEqualTo(id);
          List<NurseDetailDO> list = nerseDetailDAO.selectByExample(nde);
          if (!list.isEmpty()) {
            //开始重发
            nurseDetailService.uploadDetailToThirdParty(list);
          }
        }
      }
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    } finally {
      releaseLock("reSend2ThirdOfNurseFeeDetail");
    }
    logger.info(
        "____end reSend2ThirdOfNurseFeeDetail___耗时S:"
            + ((System.currentTimeMillis()) - begin) / 1000);
    return resultDTO;
  }

  /**
   * 定时重发到第三方接口（服务项目推送） 业务规则：第三方接口（社保）调用失败，会记录错误信息到第三方日志表 本定时任务，扫描第三方日志表，对失败数据进行重新发送，如果成则更新为成功；
   * 如果失败，则更新重发次数，失败超过三次则放弃重发
   *
   * @return
   */
  @Scheduled(cron = "${scheduled.cron.reSend2ThirdOfServiceProject}") //每一小时执行一次
  public ResultDTO reSend2ThirdOfServiceProject() {
    logger.info("____begin reSend2ThirdOfServiceProject____");
    long begin = System.currentTimeMillis();
    ResultDTO resultDTO = new ResultDTO();
    try {
      if (!getLock("reSend2ThirdOfServiceProject")) {
        resultDTO.setStatus(StatusCodeEnum.OK.getValue());
        resultDTO.setMessage("其他服务器正在执行[reSend2ThirdOfServiceProject]的业务操作！");
        return resultDTO;
      }

      ThirdInterfaceLogDOExample doe = new ThirdInterfaceLogDOExample();
      doe.createCriteria()
          .andBusiTypeEqualTo(ThirdInterfaceLogEnum.BUSI_TYPE_02.getValue())
          .andTypeEqualTo(ThirdInterfaceLogEnum.TYPE_SB.getValue())
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
          String id = ddo.getBusiDataId();
          ServiceItemDO ido = serviceItemDAO.selectByPrimaryKey(id);
          //开始重发
          wSService.pushServiceProject(ido);
        }
      }
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
    } finally {
      releaseLock("reSend2ThirdOfServiceProject");
    }
    logger.info(
        "____end reSend2ThirdOfServiceProject___耗时S:"
            + ((System.currentTimeMillis()) - begin) / 1000);
    return resultDTO;
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
    com.taikang.dic.ltci.model.ScheduleDOExample.Criteria criteria = doExample.createCriteria();
    criteria.andMoudleTypeEqualTo(moudleType);
    List<ScheduleDO> list = scheduleDAO.selectByExample(doExample);
    if (list.isEmpty()) {
      //如果没有这个类型，则添加一个
      ScheduleDO scheduleDO = new ScheduleDO();
      scheduleDO.setId(UUID.randomUUID().toString().replaceAll("-", ""));
      scheduleDO.setExecutionSchedule(ExecutionScheduleEnum.OFF.getValue());
      scheduleDO.setVersion(0L);
      scheduleDO.setOperatedTime(new Date());
      scheduleDO.setExecutionStatus(ExecutionStatusEnum.SUCCESS.getValue());
      scheduleDO.setMoudleType(moudleType);
      scheduleDO.setTimeWindow(0);
      scheduleDO.setIp(ip);
      scheduleDAO.insertSelective(scheduleDO);
      return getLock(moudleType);
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
        logger.info("其他服务器正在执行[" + moudleType + "]的业务操作，" + ip + " 服务器停止执行");
        return false;
      }
      logger.info("服务器" + ip + "开始执行[" + moudleType + "]的业务操作");
    } else {
      //未超期，但是现在状态为执行状态
      if (scheduleDO.getExecutionSchedule() == ExecutionScheduleEnum.ON.getValue()) {
        logger.info("其他服务器在执行[" + moudleType + "]的业务操作，" + ip + "服务器停止执行");
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
          logger.info("其他服务器在执行[" + moudleType + "]的业务操作，" + ip + "服务器停止执行");
          return false;
        }
        logger.info("服务器" + ip + "开始执行[" + moudleType + "]的业务操作");
      }
    }
    return true;
  }

  /** 重置状态锁 */
  public void releaseLock(String moudleType) {
    ScheduleDO scheduleDO = new ScheduleDO();
    ScheduleDOExample doExample = new ScheduleDOExample();
    com.taikang.dic.ltci.model.ScheduleDOExample.Criteria criteria = doExample.createCriteria();
    criteria.andMoudleTypeEqualTo(moudleType);

    scheduleDO.setExecutionSchedule(ExecutionScheduleEnum.OFF.getValue());
    scheduleDO.setExecutionStatus(ExecutionStatusEnum.SUCCESS.getValue());
    scheduleDAO.updateByExampleSelective(scheduleDO, doExample);
  }
}
