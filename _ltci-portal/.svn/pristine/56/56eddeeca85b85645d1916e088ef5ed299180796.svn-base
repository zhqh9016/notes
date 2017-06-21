package com.taikang.dic.ltci.agency.person.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

@FeignClient(name = "${feign.agency.person.client}", url = "${feign.agency.person.url}")
public interface AgencyAuditServerClient {

  @RequestMapping(method = RequestMethod.GET, value = "/api/v1/agency/audit/list")
  PageResultDTO listAgencyAudit(
      @RequestParam(value = "agencyName") String agencyName,
      @RequestParam(value = "agencyLevel") String agencyLevel,
      @RequestParam(value = "agencyServiceType") String agencyServiceType,
      @RequestParam(value = "agencyType") String agencyType,
      @RequestParam(value = "agencyState") String agencyState,
      @RequestParam(value = "operatedBeginDate") String operatedBeginDate,
      @RequestParam(value = "operatedEndDate") String operatedEndDate,
      @RequestParam(value = "applyBeginDate") String applyBeginDate,
      @RequestParam(value = "applyEndDate") String applyEndDate,
      @RequestParam(value = "actionType") String actionType,
      @RequestParam(value = "page") int page,
      @RequestParam(value = "pageSize") int pageSize);

  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/agency/update")
  ResultDTO getAgencyDetail(@RequestParam(value = "serialNum") String serialNum);

  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/agency/list")
  PageResultDTO listAgency(
      @RequestParam(value = "agencyName") String agencyName,
      @RequestParam(value = "agencyType") String agencyType,
      @RequestParam(value = "agencyCode") String agencyCode);

  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/agency/key/time")
  ResultDTO getKeyTime(@RequestParam(value = "serialNum") String serialNum);
}
