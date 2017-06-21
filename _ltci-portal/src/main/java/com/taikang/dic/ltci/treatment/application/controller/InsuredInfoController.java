package com.taikang.dic.ltci.treatment.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.treatment.application.model.InsuredInfoSpeDO;
import com.taikang.dic.ltci.treatment.application.service.InsuredInfoService;

/** @author itw_caoxy 社保相关参保人表查，增，改操作 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class InsuredInfoController {
  private static final Logger logger = LoggerFactory.getLogger(InsuredInfoController.class);

  @Autowired private InsuredInfoService insuredInfoService;
  /** 查询参保人的列表 */
  @RequestMapping(path = "/insuredInfos", method = RequestMethod.GET)
  public PageResultDTO getInsuredInfo(
      @RequestParam(value = "idCard", required = false) String idCard,
      @RequestParam(value = "insuredPersonName", required = false) String insuredPersonName,
      @RequestParam(value = "securityNumber", required = false) String securityNumber,
      @RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
    PageResultDTO resultDTO =
        insuredInfoService.getInsuredInfo(
            idCard, insuredPersonName, securityNumber, page, pageSize);
    return resultDTO;
  }

  /** 新增参保人 */
  @RequestMapping(path = "/new/insuredInfo", method = RequestMethod.POST)
  public ResultDTO createInsuredInfo(@ModelAttribute InsuredInfoSpeDO InsuredInfoSpeDO) {
    logger.info("传入数据为" + JSONObject.toJSONString(InsuredInfoSpeDO));
    ResultDTO resultDTO = insuredInfoService.createInsuredInfo(InsuredInfoSpeDO);
    return resultDTO;
  }
  /** 新增参保人 */
  @RequestMapping(path = "/diff/insuredInfo", method = RequestMethod.PUT)
  public ResultDTO updateInsuredInfo(@ModelAttribute InsuredInfoSpeDO InsuredInfoSpeDO) {
    logger.info("传入数据为" + JSONObject.toJSONString(InsuredInfoSpeDO));
    ResultDTO resultDTO = insuredInfoService.updateInsuredInfo(InsuredInfoSpeDO);
    return resultDTO;
  }
}
