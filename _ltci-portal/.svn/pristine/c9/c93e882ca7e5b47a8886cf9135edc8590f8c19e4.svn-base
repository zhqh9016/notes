package com.taikang.dic.ltci.agency.person.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.AgencyHistoryDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

@FeignClient(name = "${feign.agency.person.client}", url = "${feign.agency.person.url}")
public interface AgencyHistoryServerClient {

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
  @RequestMapping(method = RequestMethod.GET, value = "/api/v1/agencyHistory/list")
  PageResultDTO getAgencyApplyList(
      @RequestParam(value = "agencyName") String agencyName,
      @RequestParam(value = "dsignatedAgencyLevel") String dsignatedAgencyLevel,
      @RequestParam(value = "dsignatedAgencyType") String dsignatedAgencyType,
      @RequestParam(value = "agencyType") String agencyType,
      @RequestParam(value = "acceptState") String acceptState,
      @RequestParam(value = "applyBeginDate") String applyBeginDate,
      @RequestParam(value = "applyEndDate") String applyEndDate,
      @RequestParam(value = "page") Integer page,
      @RequestParam(value = "pageSize") Integer pageSize,
      @RequestParam(value = "systemCode") String systemCode);

  /**
   * 机构申请信息
   *
   * @param id
   * @return
   */
  @RequestMapping(method = RequestMethod.GET, value = "/api/v1/agencyHistory/{id}")
  ResultDTO getAgencyHistory(
      @PathVariable(value = "id") String id, @RequestParam(value = "systemCode") String systemCode);

  /**
   * 机构申请受理/暂不受理或审核/审核不通过
   *
   * @param agencyHisDto
   * @param systemCode
   * @return
   */
  @RequestMapping(method = RequestMethod.PUT, value = "/api/v1/agencyHistory")
  ResultDTO updateAgencyState(
      @RequestBody AgencyHistoryDTO agencyHisDto,
      @RequestParam(value = "systemCode") String systemCode);
}
