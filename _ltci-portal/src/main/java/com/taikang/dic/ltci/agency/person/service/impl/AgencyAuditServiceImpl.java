package com.taikang.dic.ltci.agency.person.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.agency.person.serverClient.AgencyAuditServerClient;
import com.taikang.dic.ltci.agency.person.service.AgencyAuditService;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

@Service
public class AgencyAuditServiceImpl implements AgencyAuditService {

  @Autowired private AgencyAuditServerClient agencyAuditServerClient;

  @Value(value = "${spring.application.name}")
  private String systemCode;

  @Override
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
    return agencyAuditServerClient.listAgencyAudit(
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

  @Override
  public ResultDTO getAgencyDetail(String serialNum) {
    return agencyAuditServerClient.getAgencyDetail(serialNum);
  }

  @Override
  public PageResultDTO listAgency(String agencyName, String agencyType, String agencyCode) {
    return agencyAuditServerClient.listAgency(agencyName, agencyType, agencyCode);
  }

  @Override
  public ResultDTO getKeyTime(String serialNum) {
    return agencyAuditServerClient.getKeyTime(serialNum);
  }
}
