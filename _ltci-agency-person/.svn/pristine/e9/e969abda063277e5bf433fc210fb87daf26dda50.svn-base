package com.taikang.dic.ltci.service;

import java.util.List;

import com.taikang.dic.ltci.model.AgencyStaffFileRDO;

public interface IAgencyStaffFileService {

  /**
   * 根据历史表id查询附件列表信息
   *
   * @param id
   * @param type
   * @return
   */
  List<AgencyStaffFileRDO> getAgencyStaffFileById(String id, Integer type);
  /**
   * 根据机构/人员编号查询附件列表信息
   *
   * @param code
   * @return
   */
  List<AgencyStaffFileRDO> getAgencyStaffFile(String code, Integer type);
  /**
   * 将附件有效状态修改为无效
   *
   * @param file
   * @return
   */
  int updateAgencyStaffFileToIsValid(String code);
  /**
   * 根据历史表id将附件有效状态修改为无效
   *
   * @param file
   * @return
   */
  int updateAgencyStaffFileToIsValidByHisId(String historyId);
  /**
   * 新增机构/人员附件信息
   *
   * @param agencyStaffFileRDO
   */
  void insertAgencyStaffFile(AgencyStaffFileRDO agencyStaffFileRDO);
}
