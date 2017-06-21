package com.taikang.dic.ltci.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.TaskStatusEnum;
import com.taikang.dic.ltci.common.exception.ParametersIsNullException;
import com.taikang.dic.ltci.service.MobileService;

/** @author itw_caoxy 移动端相关接口列表 */
@Controller
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class MobileController {
  private Logger logger = LoggerFactory.getLogger(MobileController.class);
  @Autowired private MobileService mobileService;

  @RequestMapping(path = "/mobile/patrolTasks/{patrolTaskId}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO getPatrolTask(@PathVariable String patrolTaskId) {
    if (patrolTaskId == null || "".equals(patrolTaskId)) {
      throw new ParametersIsNullException("输入类型不能为空");
    }

    return mobileService.getPatrolTask(patrolTaskId);
  }

  @RequestMapping(path = "/mobile/patrolTasks/list/{idCard}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO getPatrolTaskList(@PathVariable String idCard) {
    if (idCard == null || "".equals(idCard)) {
      throw new ParametersIsNullException("输入类型不能为空");
    }

    return mobileService.getPatrolTaskList(idCard);
  }

  @RequestMapping(value = "/mobile/patrolTask/todo", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO getTodoPatrolTask(String taskStatus, String patrolStaffId) {
    if (patrolStaffId == null || "".equals(patrolStaffId)) {
      throw new ParametersIsNullException("输入参数不能为空");
    }
    logger.debug("taskStatus:" + taskStatus + "--patrolStaffId:" + patrolStaffId);
    List<String> states = new ArrayList<String>();
    if (TaskStatusEnum.COMPLETE.getValue().equals(taskStatus)) {
      //代表是完成
      states.add("3");
      states.add("4");
      states.add("5");
      states.add("6");
      states.add("7");
    } else if (TaskStatusEnum.NOT_COMPLETE.getValue().equals(taskStatus)) {
      //代表未完成
      states.add("1");
      states.add("2");
    } else if (taskStatus == null || "".equals(taskStatus)) {
      //代表查询所有
      states.add("3");
      states.add("4");
      states.add("5");
      states.add("6");
      states.add("7");
      states.add("1");
      states.add("2");
    } else {
      throw new ParametersIsNullException("输入参数不正确");
    }
    return mobileService.getTodoPatrolTask(patrolStaffId, states);
  }
}
