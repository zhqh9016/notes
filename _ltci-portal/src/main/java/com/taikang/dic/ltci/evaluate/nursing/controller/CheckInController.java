package com.taikang.dic.ltci.evaluate.nursing.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.evaluate.nursing.service.CheckInService;
import com.taikang.dic.ltci.portal.api.model.CheckInDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

/**
 * 协议入院出院controller
 *
 * @author itw_xuxf
 * @version 2017年4月15日上午18:50:03
 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class CheckInController {
  @Autowired private CheckInService checkInService;
  private Logger logger = LoggerFactory.getLogger(CheckInController.class);

  /**
   * 协议退出
   *
   * @param exitFrom
   * @param exitReason
   * @param exitReasonDetial
   * @param inHospState
   * @param agreOutDate
   * @param operatedBy
   * @param checkInCode
   * @return
   */
  @RequestMapping(path = "/checkInOut")
  @ResponseBody
  public ResultDTO checkInProtocolExit(CheckInDTO checkInDTO) {
    ResultDTO resultDto = checkInService.checkInProtocolExit(checkInDTO);
    return resultDto;
  }
  /** 协议列表查询 */
  @RequestMapping(value = "/checkIn", method = RequestMethod.POST)
  @ResponseBody
  public PageResultDTO getCheckIn(
      String beCarePersonName,
      String beCarePersonCard,
      String orgName,
      String operatedTime,
      String inHospState,
      @RequestParam(name = "page", defaultValue = "1") int page,
      @RequestParam(name = "pageSize", defaultValue = "15") int pageSize) {
    logger.info("beCarePersonName:" + beCarePersonName);
    logger.info("beCarePersonCard:" + beCarePersonCard);
    logger.info("orgName:" + orgName);
    logger.info("operatedTime:" + operatedTime);
    logger.info("inHospState:" + inHospState);
    logger.info("page:" + page);
    logger.info("pageSize:" + pageSize);
    PageResultDTO pageResultDTO =
        checkInService.getCheckIn(
            beCarePersonName, beCarePersonCard, orgName, operatedTime, inHospState, page, pageSize);
    return pageResultDTO;
  }
}
