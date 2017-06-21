package com.taikang.dic.ltci.service;

import java.util.Map;

import com.taikang.dic.ltci.model.StaffHistoryDO;

public interface IStaffHistoryService {
  /**
   * 查询人员申请的受理、审核状态
   *
   * @param staffId
   * @return
   */
  StaffHistoryDO getStaffHistoryDetailByStaffId(String staffId);
  /**
   * 查询申请/变更人员信息
   *
   * @param actionType 申请/变更枚举
   * @param staffName 人员名称
   * @param agencyName 机构名称
   * @param auditState 受理\审核状态
   * @param dsignatedAgencyLevel 定点机构类别--
   * @param dsignatedAgencyType 定点服务机构类型--
   * @param agencyType 机构类型--
   * @param applyBeginDate 申请开始时间
   * @param applyEndDate 申请结束时间
   * @param jobScope
   * @param page 页码
   * @param pageSize 每页显示件数
   * @return
   */
  Map<String, Object> getStaffApplyOrModifyList(
      String actionType,
      String staffName,
      String agencyName,
      String auditState,
      String dsignatedAgencyLevel,
      String dsignatedAgencyType,
      String agencyType,
      String applyBeginDate,
      String applyEndDate,
      String jobScope,
      Integer page,
      Integer pageSize);
  /**
   * 修改人员申请的受理、审核状态
   *
   * @param staffId
   * @param auditState
   * @param cause
   * @return
   */
  int staffHistoryStateCase(StaffHistoryDO staffHistoryDO);
}
