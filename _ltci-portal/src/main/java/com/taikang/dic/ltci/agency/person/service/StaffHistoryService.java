package com.taikang.dic.ltci.agency.person.service;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.StaffHistoryDTO;

public interface StaffHistoryService {

  PageResultDTO getStaffApplyList(
      String actionType,
      String agencyName,
      String staffName,
      String dsignatedAgencyLevel,
      String dsignatedAgencyType,
      String agencyType,
      String acceptState,
      String applyBeginDate,
      String applyEndDate,
      String jobScope,
      Integer page,
      Integer pageSize);

  ResultDTO staffHistoryDetailById(String staffId);

  ResultDTO staffHistoryStateCase(StaffHistoryDTO staffHistoryDto);

  ResultDTO staffDetail(String serialNo);
}
