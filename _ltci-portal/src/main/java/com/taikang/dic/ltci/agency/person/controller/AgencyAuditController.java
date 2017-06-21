package com.taikang.dic.ltci.agency.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.agency.person.service.AgencyAuditService;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class AgencyAuditController {

  @Autowired private AgencyAuditService agencyAuditService;

  @RequestMapping(value = "/agency/audit/list", method = RequestMethod.GET)
  @ResponseBody
  public PageResultDTO listAgencyAudit(
      String agencyName,
      String agencyLevel,
      String agencyServiceType,
      String agencyType,
      String agencyState,
      String operatedBeginDate,
      String operatedEndDate,
      String applyBeginDate,
      String applyEndDate,
      String actionType,
      int page,
      int pageSize) {
    return agencyAuditService.listAgencyAudit(
        agencyName,
        agencyLevel,
        agencyServiceType,
        agencyType,
        agencyState,
        operatedBeginDate,
        operatedEndDate,
        applyBeginDate,
        applyEndDate,
        actionType,
        page,
        pageSize);
  }

  @RequestMapping(path = "/agency/update", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO getAgencyDetail(String serialNum) {
    return agencyAuditService.getAgencyDetail(serialNum);
  }

  @RequestMapping(path = "/agency/list", method = RequestMethod.POST)
  @ResponseBody
  public PageResultDTO listAgency(String agencyName, String agencyType, String agencyCode) {
    return agencyAuditService.listAgency(agencyName, agencyType, agencyCode);
  }

  /**
   * 查询机构秘钥时间
   *
   * @param serialNum 流水号
   * @return AgencyDTO
   */
  @RequestMapping(path = "/agency/key/time", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO getKeyTime(String serialNum) {
    return agencyAuditService.getKeyTime(serialNum);
  }
}
