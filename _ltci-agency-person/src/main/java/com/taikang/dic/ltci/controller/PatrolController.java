package com.taikang.dic.ltci.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.exception.ParametersIsNullException;
import com.taikang.dic.ltci.service.AgencyStaffService;

/** @author itw_caoxy 给质控提供的一些查询接口 */
@Controller
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class PatrolController {

  private Logger logger = LoggerFactory.getLogger(PatrolController.class);

  @Autowired private AgencyStaffService agencyStaffService;

  @RequestMapping(path = "/staff/agency", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO getAgencyStaff(@RequestParam String type, String name) {
    if (type == null || "".equals(type)) {
      throw new ParametersIsNullException("输入类型不能为空");
    }

    ResultDTO resultDTO = new ResultDTO();
    if ("0".equals(type)) {
      //代表查询人员
      resultDTO = agencyStaffService.queryStaff(name);
    } else if ("1".equals(type)) {
      //代表查询机构
      resultDTO = agencyStaffService.queryAgency(name);
    }

    return resultDTO;
  }

  @RequestMapping(path = "/agency/{code}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO getAgencyByStaff(@PathVariable("code") String code) {
    return agencyStaffService.getAgencyByStaff(code);
  }

  @RequestMapping(path = "/agencyCode/{code}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO getAgencyByAgencyCode(@PathVariable("code") String code) {
    return agencyStaffService.getAgencyByAgencyCode(code);
  }

  @RequestMapping(path = "/staffCode/{code}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO getStaffByStaffCode(@PathVariable("code") String code) {
    return agencyStaffService.getStaffByStaffCode(code);
  }
}
