package com.taikang.dic.ltci.quality.control.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.quality.control.model.PatrolTaskAddDO;
import com.taikang.dic.ltci.quality.control.service.AgencyStaffService;
import com.taikang.dic.ltci.quality.control.service.PatrolTaskService;
import com.taikang.dic.ltci.treatment.application.common.ParametersIsNullException;

@Controller
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class PatrolController {
  private Logger logger = LoggerFactory.getLogger(PatrolController.class);
  @Autowired private AgencyStaffService agencyStaffService;
  @Autowired private PatrolTaskService patrolTaskService;

  @RequestMapping(path = "/staff/agency", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO getAgencyStaff(@RequestParam String type, String name) {
    if (type == null || "".equals(type)) {
      throw new ParametersIsNullException("输入类型不能为空");
    }
    return agencyStaffService.queryStaffAgency(type, name);
  }

  @RequestMapping(path = "/patrol", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO addPatrol(@ModelAttribute PatrolTaskAddDO patrolTaskAddDO) {

    logger.debug("patrolTaskAddDO为：" + patrolTaskAddDO);

    return patrolTaskService.addPatrol(patrolTaskAddDO);
  }
}
