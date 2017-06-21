package com.taikang.dic.ltci.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.dic.ltci.api.model.ResultDTO;

@FeignClient(name = "${feign.agency.person.client}", url = "${feign.agency.person.url}")
public interface AgencyPersonClient {

  @RequestMapping(path = "/api/v1/agency/{code}", method = RequestMethod.GET)
  public ResultDTO getAgencyByStaff(@PathVariable("code") String code);

  @RequestMapping(path = "/api/v1/agencyCode/{code}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO getAgencyByAgencyCode(@PathVariable("code") String code);

  @RequestMapping(path = "/api/v1/staffCode/{code}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO getStaffByStaffCode(@PathVariable("code") String code);
}
