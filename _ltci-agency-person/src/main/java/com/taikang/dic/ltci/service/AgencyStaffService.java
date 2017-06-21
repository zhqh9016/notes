package com.taikang.dic.ltci.service;

import com.taikang.dic.ltci.api.model.ResultDTO;

public interface AgencyStaffService {

  boolean insertAgency(String path) throws Exception;

  boolean insertStaff(String path) throws Exception;

  ResultDTO getStaff(String staffCode);

  ResultDTO staffDetail(String serialNo);

  /** 给质控的接口 */
  ResultDTO queryStaff(String name);
  /** 给质控的接口 */
  ResultDTO queryAgency(String name);
  /** 给质控的接口 通过staff的code */
  ResultDTO getAgencyByStaff(String code);

  ResultDTO getAgencyByAgencyCode(String code);

  ResultDTO getStaffByStaffCode(String code);
}
