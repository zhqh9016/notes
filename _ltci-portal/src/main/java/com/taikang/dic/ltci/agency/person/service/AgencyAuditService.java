package com.taikang.dic.ltci.agency.person.service;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

public interface AgencyAuditService {

  PageResultDTO listAgencyAudit(
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
      int pageSize);

  ResultDTO getAgencyDetail(String serialNum);

  PageResultDTO listAgency(String agencyName, String agencyType, String agencyCode);

  ResultDTO getKeyTime(String serialNum);
}
