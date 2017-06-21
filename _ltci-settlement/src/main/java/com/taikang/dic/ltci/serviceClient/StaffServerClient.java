package com.taikang.dic.ltci.serviceClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${feign.agency.person.client}", url = "${feign.agency.person.url}")
public interface StaffServerClient {

  /** 查询人员详情 */
  @RequestMapping(path = "/api/v1/staff/state/{staffCode}", method = RequestMethod.GET)
  String getStaffState(@PathVariable(value = "staffCode") String staffCode);
}
