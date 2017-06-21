package com.taikang.dic.ltci.treatment.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.portal.api.model.DeputyBindingDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.treatment.application.service.DeputyBindingService;

/** @author itw_caoxy 用于处理代理人绑定的处理类 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class DeputyBindingController {
  private Logger logger = LoggerFactory.getLogger(DeputyBindingController.class);
  @Autowired private DeputyBindingService deputyBindingService;

  @RequestMapping(value = "/deputy/bindings", method = RequestMethod.POST)
  @ResponseBody
  public PageResultDTO getDeputyBindingQuery(
      String insuredPersonName,
      String idCard,
      String securityNumber,
      String deputyName,
      String deputyIdCard,
      String checkState,
      @RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {

    logger.info("insuredPersonName:" + insuredPersonName);
    logger.info("idCard:" + idCard);
    logger.info("securityNumber:" + securityNumber);
    logger.info("deputyName:" + deputyName);
    logger.info("deputyIdCard:" + deputyIdCard);
    logger.info("checkState:" + checkState);

    return deputyBindingService.getDeputyBindingChecks(
        insuredPersonName,
        idCard,
        securityNumber,
        deputyName,
        deputyIdCard,
        checkState,
        page,
        pageSize);
  }

  /**
   * @author itw_xuyao 前段点击前往跳转代理人绑定人工审核详细页面 通过url中审核表中id查询所有信息
   * @return DeputyBindingDTO
   */
  @RequestMapping(value = "/deputy/bindings/{deputyBindingCode}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO getDeputyBindingDTO(@PathVariable String deputyBindingCode) {
    logger.debug("deputyBindingCode:" + deputyBindingCode);
    return deputyBindingService.getDeputyBindingDTO(deputyBindingCode);
  }

  /**
   * @author itw_xuyao 审核代理人绑定信息
   * @return DeputyBindingDTO
   */
  @RequestMapping(value = "/deputy/bindings/deputyBindingid/checkState", method = RequestMethod.PUT)
  @ResponseBody
  public ResultDTO updateDeputyBindingDTO(DeputyBindingDTO deputyBindingDTO) {
    return deputyBindingService.updateDeputyBindingDTO(deputyBindingDTO);
  }
}
