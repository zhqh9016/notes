package com.taikang.dic.ltci.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.util.IPUtil;
import com.taikang.dic.ltci.service.IOrgSettlementService;
import com.taikang.dic.ltci.service.impl.CommonServiceImpl;

/** @author itw_huodd 统一规则：1、接口白名单校验 2、参数有效性校验 3、接口当天调用次数校验 */
@RestController
@RequestMapping(path = "/api/v1/pay", produces = "application/json;charset=utf-8")
public class ClientOrgController {

  private static final Logger logger = LoggerFactory.getLogger(ClientOrgController.class);

  @Autowired private IOrgSettlementService orgSettlementService;

  @Autowired private CommonServiceImpl commonService;

  /**
   * 护理机构支付金额查询
   *
   * @param clientCode 接口调用方的代码
   * @param siArea 多个区号用逗号分隔：123,132
   * @param agencyCode 护理机构代码
   * @throws Exception
   */
  @RequestMapping(path = "/siPayCost", method = RequestMethod.GET)
  public ResultDTO getSiPayCost(
      HttpServletRequest request,
      @RequestParam("clientCode") String clientCode,
      @RequestParam("siArea") String siArea,
      String agencyCode)
      throws Exception {
    logger.debug(
        "____getSiPayCost_clientCode="
            + clientCode
            + "_siArea="
            + siArea
            + "_agencyCode="
            + agencyCode);
    String ip = IPUtil.getRemoteHost(request);
    logger.debug("____getSiPayCost_ip=" + ip);
    ResultDTO dto =
        commonService.checkInterfaceIsValid(
            clientCode, siArea, agencyCode, request, "getSiPayCost");
    if (dto == null) dto = orgSettlementService.getSiPayCost(clientCode, siArea, agencyCode);
    return dto;
  }

  /**
   * 护理机构支付结果接收
   *
   * @param costId 费用唯一编号
   * @param clientCode 接口调用方的代码
   * @param siArea 多个区号用逗号分隔：123,132
   * @param agencyCode 护理机构代码
   * @throws Exception
   */
  @RequestMapping(path = "/reverseResult", method = RequestMethod.PUT)
  public ResultDTO reverseResult(
      HttpServletRequest request,
      @RequestParam("costId") String costId,
      @RequestParam("clientCode") String clientCode,
      @RequestParam("siArea") String siArea,
      String agencyCode)
      throws Exception {
    logger.debug(
        "____getSiPayCost_clientCode="
            + clientCode
            + "_clientCode="
            + clientCode
            + "_siArea="
            + siArea
            + "_agencyCode="
            + agencyCode);

    ResultDTO dto =
        commonService.checkInterfaceIsValid(
            clientCode, siArea, agencyCode, request, "reverseResult");
    if (dto == null) {
      dto = orgSettlementService.updateOrgPaySuccess(costId, clientCode, siArea, agencyCode);
    }
    return dto;
  }
}
