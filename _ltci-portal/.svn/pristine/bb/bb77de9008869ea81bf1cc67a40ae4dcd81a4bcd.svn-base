package com.taikang.dic.ltci.agency.person.service;

import com.taikang.dic.ltci.portal.api.model.AgencyHistoryDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

public interface AgencyHistoryService {

  PageResultDTO getAgencyApplyList(
      String agencyName,
      String dsignatedAgencyLevel,
      String dsignatedAgencyType,
      String agencyType,
      String acceptState,
      String applyBeginDate,
      String applyEndDate,
      Integer page,
      Integer pageSize);

  ResultDTO getAgencyHistory(String id);

  ResultDTO updateAgencyState(AgencyHistoryDTO agencyHisDto);
}
