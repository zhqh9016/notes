package com.taikang.dic.ltci.serviceClient;

import java.util.Date;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${feign.agency.person.client}", url = "${feign.agency.person.url}")
public interface AgencyServerClient {

  @RequestMapping(method = RequestMethod.GET, value = "/api/v1/agency/state/code")
  String getAgencyState(
      @RequestParam(value = "agencyCode") String agencyCode,
      @RequestParam(value = "date") Date date);
}
