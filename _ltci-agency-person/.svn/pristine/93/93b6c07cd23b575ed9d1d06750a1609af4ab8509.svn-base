package com.taikang.dic.ltci.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.service.AgencyStaffService;

/** @author itw_xuyao */
@Controller
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class AgencyStaffController {
  private Logger logger = LoggerFactory.getLogger(AgencyStaffController.class);
  @Autowired private AgencyStaffService agencyStaffService;

  @RequestMapping(value = "/agency", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO saveAgency(@RequestParam(value = "path") String path) {

    logger.debug("path:" + path);
    boolean b;
    ResultDTO resultDTO = new ResultDTO();
    try {
      b = agencyStaffService.insertAgency(path);
      if (b) {
        resultDTO.setDatas(StatusCodeEnum.OK);
        resultDTO.setMessage("插入成功");
      } else {
        resultDTO.setDatas(StatusCodeEnum.NOT_FOUND);
        resultDTO.setMessage("插入失败");
      }
    } catch (Exception e) {
      logger.error("=====插入失败=======", e);
      resultDTO.setDatas(StatusCodeEnum.NOT_FOUND);
      resultDTO.setMessage("插入失败");
    }

    return resultDTO;
  }

  @RequestMapping(value = "/staff", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO saveStaff(@RequestParam(value = "path") String path) {

    logger.debug("path:" + path);
    boolean b;
    ResultDTO resultDTO = new ResultDTO();
    try {
      b = agencyStaffService.insertStaff(path);
      if (b) {
        resultDTO.setDatas(StatusCodeEnum.OK);
        resultDTO.setMessage("插入成功");
      } else {
        resultDTO.setDatas(StatusCodeEnum.NOT_FOUND);
        resultDTO.setMessage("插入失败");
      }
    } catch (Exception e) {
      logger.error("=====插入失败=======", e);
      resultDTO.setDatas(StatusCodeEnum.NOT_FOUND);
      resultDTO.setMessage("插入失败");
    }

    return resultDTO;
  }
}
