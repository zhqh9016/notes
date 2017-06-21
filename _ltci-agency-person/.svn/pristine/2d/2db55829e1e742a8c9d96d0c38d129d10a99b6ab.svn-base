package com.taikang.dic.ltci.service;

import java.util.List;
import java.util.Map;

import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.model.AgencyDO;
import com.taikang.dic.ltci.model.AgencyHistoryDO;

public interface IAgencyAuditService extends GenericService<AgencyHistoryDO, String> {

  Map<String, Object> listAgencyAudit(
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

  Map<String, Object> listAgency(
      String agencyName, String agencyType, String agencyCode, int page, int pageSize);

  ResultDTO getAgencyDetail(String serialNum);

  public List<AgencyDO> getKeyTime(String serialNum);
}
