package com.taikang.dic.ltci.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.model.PatrolTaskAddDO;
import com.taikang.dic.ltci.service.PatrolTaskService;

/** @author itw_caoxy 协议管理查询列表 */
@Controller
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class PatrolController {
  private Logger logger = LoggerFactory.getLogger(PatrolController.class);

  @Autowired private PatrolTaskService patrolTaskService;

  @RequestMapping(value = "/patrol", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO addPatrol(@RequestBody PatrolTaskAddDO patrolTaskAddDO) {
    logger.debug("patrolTaskAddDO为：" + JSONObject.toJSONString(patrolTaskAddDO));
    return patrolTaskService.addPatrol(patrolTaskAddDO);
  }
}
