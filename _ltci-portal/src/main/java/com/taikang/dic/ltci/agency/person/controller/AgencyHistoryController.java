package com.taikang.dic.ltci.agency.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.agency.person.service.AgencyHistoryService;
import com.taikang.dic.ltci.portal.api.model.AgencyHistoryDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class AgencyHistoryController {

  @Autowired private AgencyHistoryService agencyHistoryService;

  /**
   * 查询申请机构信息
   *
   * @param agencyName 机构名称
   * @param dsignatedAgencyLevel 定点机构类别
   * @param dsignatedAgencyType 定点服务机构类型
   * @param agencyType 机构类型
   * @param acceptState 受理状态
   * @param applyBeginDate 申请开始时间
   * @param applyEndDate 申请结束时间
   * @param page 页码
   * @param pageSize 每页显示件数
   * @return
   */
  @RequestMapping(value = "/agencyHistory/list", method = RequestMethod.GET)
  @ResponseBody
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
    return agencyHistoryService.getAgencyApplyList(
        agencyName,
        dsignatedAgencyLevel,
        dsignatedAgencyType,
        agencyType,
        acceptState,
        applyBeginDate,
        applyEndDate,
        page,
        pageSize);
  }

  /**
   * 机构申请信息
   *
   * @param id 主键
   * @return
   */
  @RequestMapping(path = "/agencyHistory/{id}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO getAgencyHistory(@PathVariable String id) {
    return agencyHistoryService.getAgencyHistory(id);
  }

  /**
   * 机构申请受理/暂不受理或审核/审核不通过
   *
   * @param agencyHisDto
   * @return
   */
  @RequestMapping(path = "/agencyHistory", method = RequestMethod.PUT)
  @ResponseBody
  public ResultDTO updateAgencyState(AgencyHistoryDTO agencyHisDto) {
    return agencyHistoryService.updateAgencyState(agencyHisDto);
  }
}
