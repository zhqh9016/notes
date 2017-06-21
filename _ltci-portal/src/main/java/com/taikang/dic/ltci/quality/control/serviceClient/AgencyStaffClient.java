package com.taikang.dic.ltci.quality.control.serviceClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.ResultDTO;

@FeignClient(name = "${feign.agency.person.client}", url = "${feign.agency.person.url}")
public interface AgencyStaffClient {
  @RequestMapping(value = "/api/v1/staff/agency", method = RequestMethod.POST)
  ResultDTO getAgencyStaff(
      @RequestParam(value = "type") String type, @RequestParam(value = "name") String name);
}
