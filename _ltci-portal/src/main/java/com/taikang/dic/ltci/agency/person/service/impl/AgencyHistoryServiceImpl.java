package com.taikang.dic.ltci.agency.person.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.agency.person.serverClient.AgencyHistoryServerClient;
import com.taikang.dic.ltci.agency.person.service.AgencyHistoryService;
import com.taikang.dic.ltci.portal.api.model.AgencyHistoryDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.util.UserUtils;

@Service
public class AgencyHistoryServiceImpl implements AgencyHistoryService {

  @Autowired private AgencyHistoryServerClient agencyHistoryServerClient;

  @Value(value = "${spring.application.name}")
  private String systemCode;

  @Override
  public PageResultDTO getAgencyApplyList(
      String agencyName,
      String dsignatedAgencyLevel,
      String dsignatedAgencyType,
      String agencyType,
      String acceptState,
      String applyBeginDate,
      String applyEndDate,
      Integer page,
      Integer pageSize) {
    return agencyHistoryServerClient.getAgencyApplyList(
        agencyName,
        dsignatedAgencyLevel,
        dsignatedAgencyType,
        agencyType,
        acceptState,
        applyBeginDate,
        applyEndDate,
        page,
        pageSize,
        systemCode);
  }

  @Override
  public ResultDTO getAgencyHistory(String id) {
    return agencyHistoryServerClient.getAgencyHistory(id, systemCode);
  }

  @Override
  public ResultDTO updateAgencyState(AgencyHistoryDTO agencyHisDto) {
    UserDTO userInfo = UserUtils.getCurrentUser();
    if (userInfo != null) {
      agencyHisDto.setCreatedBy(userInfo.getTrueName());
      agencyHisDto.setCreatedOrg(userInfo.getDepartment().getCode());
      agencyHisDto.setOperatedBy(userInfo.getTrueName());
      agencyHisDto.setOperatedOrg(userInfo.getDepartment().getCode());
    }
    return agencyHistoryServerClient.updateAgencyState(agencyHisDto, systemCode);
  }
}
