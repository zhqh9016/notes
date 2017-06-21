package com.taikang.dic.ltci.treatment.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.common.util.Encodes;
import com.taikang.dic.ltci.treatment.application.service.InsuredPersonService;

/**
 * @author itw_liuxy
 * @description 前端对参保人进行查，增，改操作的Controller
 * @createTime 2017年3月31日 下午2:04:06
 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class InsuredPersonController {

  private static final Logger logger = LoggerFactory.getLogger(InsuredPersonController.class);

  @Autowired private InsuredPersonService insuredPersonService;

  /**
   * 根据姓名和身份证号查询参保人信息
   *
   * @param idCard
   * @param insuredPersonName
   * @return
   */
  @RequestMapping(
    path = "/insuredPerson/{idCard}/and/{insuredPersonName}",
    method = RequestMethod.GET
  )
  public ResultDTO getInsuredPerson(
      @PathVariable String idCard, @PathVariable String insuredPersonName) {
    insuredPersonName = getDecodeInputData(insuredPersonName);
    logger.debug(
        "getInsuredPerson - idCard: " + idCard + " insuredPersonName:" + insuredPersonName);
    return insuredPersonService.getInsuredPerson(idCard, insuredPersonName);
  }

  /**
   * 根据参保人编号或身份证号或社保卡号查询对应的参保人信息
   *
   * @param insuredPersonCode
   * @param idCard
   * @param securityNum
   * @return
   */
  @RequestMapping(
    path = "/insuredPerson/{insuredPersonCode}/or/{idCard}/or/{securityNum}",
    method = RequestMethod.GET
  )
  public ResultDTO getInsuredPersonDetail(
      @PathVariable String insuredPersonCode,
      @PathVariable String idCard,
      @PathVariable String securityNum) {
    return insuredPersonService.getInsuredPersonDetail(insuredPersonCode, idCard, securityNum);
  }

  /**
   * 判断前端是否存在编码
   *
   * @param inputData
   * @return
   */
  private String getDecodeInputData(String inputData) {
    if (StringUtils.isBlank(inputData)) {
      return inputData;
    }
    String decodeInputData = Encodes.urlDecode(inputData);
    if (inputData.equals(decodeInputData)) {
      return inputData;
    } else {
      return decodeInputData;
    }
  }

  /** 参保人批量上传模板下载 */
  @RequestMapping(path = "/insuredPersonExcel", method = RequestMethod.GET)
  public void getInsuredPersonExcel(HttpServletRequest request, HttpServletResponse response) {
    logger.info("====Controller层：getInsuredPersonExcel方法========");

    insuredPersonService.getInsuredPersonExcel(request, response);
  }
}
