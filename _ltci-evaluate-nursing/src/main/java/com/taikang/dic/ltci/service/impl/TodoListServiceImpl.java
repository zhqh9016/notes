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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.api.model.TodoListDTO;
import com.taikang.dic.ltci.common.enumeration.ExecutionScheduleEnum;
import com.taikang.dic.ltci.common.enumeration.ExecutionStatusEnum;
import com.taikang.dic.ltci.common.enumeration.IsValidEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.enumeration.ToDoListEnum;
import com.taikang.dic.ltci.common.enumeration.ToDoListTypeEnum;
import com.taikang.dic.ltci.common.exception.ThrowsException;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.common.util.IPUtil;
import com.taikang.dic.ltci.dao.ScheduleDAO;
import com.taikang.dic.ltci.model.BaseModel;
import com.taikang.dic.ltci.model.DictionaryDO;
import com.taikang.dic.ltci.model.ScheduleDO;
import com.taikang.dic.ltci.model.ScheduleDOExample;
import com.taikang.dic.ltci.model.TodoListDO;
import com.taikang.dic.ltci.serverClient.DictionaryServerClient;
import com.taikang.dic.ltci.serverClient.TodoListServerClient;
import com.taikang.dic.ltci.service.EvaluateTaskService;
import com.taikang.dic.ltci.service.TodoListService;

/** @author itw_xuyao 对代办任务表进行操作 */
@Service
public class TodoListServiceImpl implements TodoListService {

  @Autowired private EvaluateTaskService evaluateTaskService;

  @Value(value = "${urgentConfig}")
  private int urgentConfig;

  @Value(value = "${notUrgentConfig}")
  private int notUrgentConfig;

  @Autowired private DictionaryServerClient dictionaryServerClient;

  @Autowired private ScheduleDAO scheduleDAO;
  @Autowired private TodoListServerClient todoListServerClient;

  private static final Logger logger = LoggerFactory.getLogger(TodoListServiceImpl.class);

  /**
   * 判断是否紧急的时候减去配置时间
   *
   * @param day
   * @return
   */
  private String getFormatDateBySubtraction(int day) {
    Calendar urgentCalendar = Calendar.getInstance();
    urgentCalendar.add(Calendar.DAY_OF_MONTH, -1 * day);
    return DateFormatUtil.dateToStr(
        urgentCalendar.getTime(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
  }

  /**
   * 判断是否可以获取锁，返回true表示拿到锁，可以继续执行，返回false表示锁定状态，不可以继续执行
   *
   * @return
   */
  private boolean getLock(String moudleType) {
    ScheduleDOExample doExample = new ScheduleDOExample();
    com.taikang.dic.ltci.model.ScheduleDOExample.Criteria criteria = doExample.createCriteria();
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
      scheduleDO.setTimeWindow(2160); //窗口期 60分钟
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
    com.taikang.dic.ltci.model.ScheduleDOExample.Criteria criteria = doExample.createCriteria();
    criteria.andMoudleTypeEqualTo(moudleType);

    scheduleDO.setExecutionSchedule(ExecutionScheduleEnum.OFF.getValue());
    scheduleDO.setExecutionStatus(ExecutionStatusEnum.SUCCESS.getValue());
    scheduleDAO.updateByExampleSelective(scheduleDO, doExample);
  }

  /**
   * 新增待办提醒接口
   *
   * @param TodoListDto
   * @return
   */
  @Override
  @Transactional
  public ResultDTO createTodoListTiming() {
    ResultDTO resultDTO = new ResultDTO();
    if (!getLock("toDoListTiming")) {
      resultDTO.setStatus(StatusCodeEnum.OK.getValue());
      resultDTO.setMessage("其他服务器正在执行评估任务提醒的定时任务的业务操作！");
      return resultDTO;
    }

    //调用数字字典微服务
    resultDTO = dictionaryServerClient.getDictionaryDOByCondition("taskDeadLine", "urgentConfig");
    List<DictionaryDO> dictionaryList =
        JSONArray.parseArray(JSONArray.toJSONString(resultDTO.getDatas()), DictionaryDO.class);
    if (!dictionaryList.isEmpty()) {
      String urgentConfigString = dictionaryList.get(0).getValueName();
      urgentConfig = Integer.parseInt(urgentConfigString);
    }

    resultDTO =
        dictionaryServerClient.getDictionaryDOByCondition("taskDeadLine", "notUrgentConfig");
    List<DictionaryDO> notUrgentConfigList =
        JSONArray.parseArray(JSONArray.toJSONString(resultDTO.getDatas()), DictionaryDO.class);
    if (!dictionaryList.isEmpty()) {
      String notUrgentConfigString = notUrgentConfigList.get(0).getValueName();
      notUrgentConfig = Integer.parseInt(notUrgentConfigString);
    }

    String urgentDateTime = getFormatDateBySubtraction(urgentConfig);
    String notUrgentDateTime = getFormatDateBySubtraction(notUrgentConfig);

    //判断是否产生待办任务
    List<String> createdOrgList =
        evaluateTaskService.checkEvaluateTaskUrgent(
            urgentConfig, urgentDateTime, notUrgentConfig, notUrgentDateTime);
    //如果查询数据大于0，则产生待办提醒
    if (!createdOrgList.isEmpty()) {
      //循环createdOrgList生成不同机构的不同代办信息
      for (String createdOrg : createdOrgList) {
        ResultDTO resultDTOReturn =
            todoListServerClient.getTodoListByBusinessType(
                ToDoListEnum.ASSESSMENT_TASK_SEND.getValue(), createdOrg);
        List<TodoListDO> list =
            JSONArray.parseArray(
                JSONArray.toJSONString(resultDTOReturn.getDatas()), TodoListDO.class);
        logger.debug("=======todoListDOs【" + JSONObject.toJSONString(list) + "】===========");

        logger.debug("===进入TodoListServiceImpl createTodoListTiming方法开始===");
        if (list.isEmpty()) {
          TodoListDTO todoListDTO = new TodoListDTO();
          //主键id
          todoListDTO.setTodoListid(UUID.randomUUID().toString().replaceAll("-", ""));
          //待办任务编号
          todoListDTO.setTodoListCode(UUID.randomUUID().toString().replaceAll("-", ""));
          todoListDTO.setIsValid(IsValidEnum.NO_DELETE.getValue());
          todoListDTO.setBusinessCode(ToDoListEnum.ASSESSMENT_TASK_SEND.getValue());
          //配置待办路径对应的类型
          todoListDTO.setBusinessType(ToDoListEnum.ASSESSMENT_TASK_SEND.getValue());
          //提醒标题
          todoListDTO.setTitle("评估任务超期提醒！");
          //任务还是提醒的类型
          todoListDTO.setType(ToDoListTypeEnum.REMIND.getValue());

          todoListDTO.setUri("");
          todoListDTO.setUrl("");
          todoListDTO.setIp("");
          todoListDTO.setPort("");
          todoListDTO.setJumpWay("_blank");
          todoListDTO.setCreatedTime(
              DateFormatUtil.dateToStr(new Date(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS));
          //创建机构 同evaluateTask表中createdOrg
          todoListDTO.setCreatedOrg(createdOrg);

          ResultDTO resultDTOAfterInsert = todoListServerClient.createTodoList(todoListDTO);
          if (!resultDTOAfterInsert.getStatus().equals(StatusCodeEnum.CREATED.getValue())) {
            throw new ThrowsException("新增待办提醒失败！");
          }
          resultDTO.setStatus(StatusCodeEnum.CREATED.getValue());
          resultDTO.setMessage("产生待办提醒成功！");
        } else {
          resultDTO.setStatus(StatusCodeEnum.OK.getValue());
          resultDTO.setMessage("已存在评估任务的待办提醒，不用重新生成！");
        }
      }

    } else {
      resultDTO.setStatus(StatusCodeEnum.CREATED.getValue());
      resultDTO.setMessage("未找到超时未发送的评估任务，无需产生待办提醒！");
    }
    //业务执行完毕，重置锁状态
    releaseLock("toDoListTiming");
    logger.debug("===进入TodoListServiceImpl createTodoListTiming方法结束===");
    return resultDTO;
  }
}
