package com.taikang.dic.ltci.agency.person.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.agency.person.serverClient.StaffHistoryServerClient;
import com.taikang.dic.ltci.agency.person.service.StaffHistoryService;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.StaffHistoryDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.util.UserUtils;

@Service
public class StaffHistoryServiceImpl implements StaffHistoryService {

  @Autowired private StaffHistoryServerClient staffHistoryServerClient;

  @Value(value = "${spring.application.name}")
  private String systemCode;

  @Override
  public PageResultDTO getStaffApplyList(
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
      Integer pageSize) {
    return staffHistoryServerClient.getStaffApplyList(
        actionType,
        agencyName,
        staffName,
        dsignatedAgencyLevel,
        dsignatedAgencyType,
        agencyType,
        acceptState,
        applyBeginDate,
        applyEndDate,
        jobScope,
        page,
        pageSize,
        systemCode);
  }

  @Override
  public ResultDTO staffHistoryDetailById(String staffId) {
    return staffHistoryServerClient.getStaffHistoryDetailById(staffId, systemCode);
  }

  @Override
  public ResultDTO staffHistoryStateCase(StaffHistoryDTO staffHistoryDto) {
    UserDTO userDTO = UserUtils.getCurrentUser();
    if (userDTO != null) {
      staffHistoryDto.setOperatedBy(userDTO.getTrueName());
      if (userDTO.getDepartment() != null) {
        staffHistoryDto.setOperatedOrg(userDTO.getDepartment().getCode());
      }
    }
    return staffHistoryServerClient.staffHistoryStateCase(staffHistoryDto, systemCode);
  }

  @Override
  public ResultDTO staffDetail(String serialNo) {

    return staffHistoryServerClient.staffDetial(serialNo);
  }
}
