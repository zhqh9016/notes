package com.taikang.dic.ltci.settlement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.settlement.service.PersonalNurseDetailService;

/**
 * 个人费用护理明细Controller
 *
 * @author itw_liuzy 2017-04-14
 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class PersonalNurseDetailController {
  private Logger logger = LoggerFactory.getLogger(PersonalNurseDetailController.class);

  @Autowired PersonalNurseDetailService personalNurseDetailService;

  /**
   * 按条件分页查询个人费用护理明细列表
   *
   * @param personalNurseDetailDTO 查询条件
   * @param page 当前页码
   * @param pageSize 每页显示件数
   * @return 个人费用护理明细信息列表
   */
  @RequestMapping(path = "/personal/nurse/detail/list", method = RequestMethod.POST)
  @ResponseBody
  public PageResultDTO listPersonNurseDetail(
      @RequestParam String orgCode,
      @RequestParam String inRecorduuid,
      @RequestParam String beCarePersonCard,
      @RequestParam String feeBeginDate,
      @RequestParam String feeEndDate,
      @RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "pageSize", defaultValue = "100") int pageSize) {
    logger.debug(
        "_listPersonNurseDetail___orgCode="
            + orgCode
            + "___page="
            + beCarePersonCard
            + "___beCarePersonCard="
            + feeBeginDate
            + "___feeDate="
            + page
            + "___pageSize="
            + pageSize);
    return personalNurseDetailService.listPersonNurseDetail(
        orgCode, inRecorduuid, beCarePersonCard, feeBeginDate, feeEndDate, page, pageSize);
  }
}
