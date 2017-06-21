package com.taikang.dic.ltci.agency.person.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.StaffHistoryDTO;

@FeignClient(name = "${feign.agency.person.client}", url = "${feign.agency.person.url}")
public interface StaffHistoryServerClient {

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
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/staffHistory/list")
  PageResultDTO getStaffApplyList(
      @RequestParam(value = "actionType") String actionType,
      @RequestParam(value = "agencyName") String agencyName,
      @RequestParam(value = "staffName") String staffName,
      @RequestParam(value = "dsignatedAgencyLevel") String dsignatedAgencyLevel,
      @RequestParam(value = "dsignatedAgencyType") String dsignatedAgencyType,
      @RequestParam(value = "agencyType") String agencyType,
      @RequestParam(value = "acceptState") String acceptState,
      @RequestParam(value = "applyBeginDate") String applyBeginDate,
      @RequestParam(value = "applyEndDate") String applyEndDate,
      @RequestParam(value = "jobScope") String jobScope,
      @RequestParam(value = "page") Integer page,
      @RequestParam(value = "pageSize") Integer pageSize,
      @RequestParam(value = "systemCode") String systemCode);

  /**
   * 查询人员历史详情
   *
   * @param staffId
   * @param systemCode
   * @return
   */
  @RequestMapping(path = "/api/v1/staffHistory/{staffId}", method = RequestMethod.GET)
  ResultDTO getStaffHistoryDetailById(
      @PathVariable(value = "staffId") String staffId,
      @RequestParam(value = "systemCode") String systemCode);

  /**
   * 根据人员历史流水号处理对应状态
   *
   * @param staffId
   * @param auditState
   * @param cause
   * @param systemCode
   * @return
   */
  @RequestMapping(value = "/api/v1/staffHistoryStateCase", method = RequestMethod.PUT)
  public ResultDTO staffHistoryStateCase(
      @RequestBody StaffHistoryDTO staffHistoryDto,
      @RequestParam(value = "systemCode") String systemCode);

  @RequestMapping(value = "/api/v1/staffDetial/{serialNo}", method = RequestMethod.GET)
  ResultDTO staffDetial(@PathVariable("serialNo") String serialNo);
}
