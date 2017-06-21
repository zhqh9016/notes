package com.taikang.dic.ltci.quality.control.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.quality.control.service.AgencyStaffService;
import com.taikang.dic.ltci.quality.control.serviceClient.AgencyStaffClient;

@Service
public class AgencyStaffClientImpl implements AgencyStaffService {

  @Autowired AgencyStaffClient agencyStaffClient;

  @Override
  public ResultDTO queryStaffAgency(String type, String name) {
    return agencyStaffClient.getAgencyStaff(type, name);
  }
}
