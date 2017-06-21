package com.taikang.dic.ltci.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.service.AgencyStaffService;
import com.taikang.dic.ltci.service.IStaffHistoryService;

/** @author itw_caoxy 对人员表的一些crud 操作 给portal、或其它项目提供微服务 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class StaffController {
  private static final Logger logger = LoggerFactory.getLogger(StaffController.class);

  @Autowired private AgencyStaffService agencyStaffService;
  /** 通过人员code 获取人员表里人员的详细信息 */
  @RequestMapping(value = "/staff/{staffCode}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO getStaff(@PathVariable String staffCode) {
    logger.debug("查询人员信息");
    return agencyStaffService.getStaff(staffCode);
  }

  /** 通过serial_no 获取人员详细信息 */
  @RequestMapping(value = "/staffDetial/{serialNo}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO staffDetial(@PathVariable String serialNo) {
    logger.debug("查询人员信息通过serialNo");
    return agencyStaffService.staffDetail(serialNo);
  }
}
