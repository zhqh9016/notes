package com.taikang.dic.ltci.agency.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.agency.person.service.StaffHistoryService;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.StaffHistoryDTO;

@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class StaffHistoryController {

  @Autowired private StaffHistoryService staffHistoryService;

  /**
   * 查询申请/审核人员信息
   *
   * @param actionType 申请、审核
   * @param staffName 人员名称
   * @param agencyName 机构名称
   * @param dsignatedAgencyLevel 定点机构类别
   * @param dsignatedAgencyType 定点服务机构类型
   * @param agencyType 机构类型
   * @param acceptState 受理状态
   * @param applyBeginDate 申请开始时间
   * @param applyEndDate 申请结束时间
   * @param jobScope
   * @param page 页码
   * @param pageSize 每页显示件数
   * @return
   */
  @RequestMapping(value = "/staffHistory/list", method = RequestMethod.POST)
  @ResponseBody
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
    return staffHistoryService.getStaffApplyList(
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
        pageSize);
  }

  @RequestMapping(path = "/staffHistory/{staffId}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO staffHistoryDetailById(@PathVariable String staffId) {
    return staffHistoryService.staffHistoryDetailById(staffId);
  }

  /**
   * 根据人员流水ID，修改审核状态
   *
   * @param staffId 人员流水id
   * @param auditState 处理的状态
   * @param cause 处理意见
   * @return
   */
  @RequestMapping(value = "/staffHistoryStateCase", method = RequestMethod.PUT)
  public ResultDTO staffHistoryStateCase(StaffHistoryDTO staffHistoryDto) {
    return staffHistoryService.staffHistoryStateCase(staffHistoryDto);
  }

  /** 通过serial_no 获取人员详细信息 */
  @RequestMapping(value = "/staffDetial/{serialNo}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO staffDetial(@PathVariable String serialNo) {
    return staffHistoryService.staffDetail(serialNo);
  }
}
