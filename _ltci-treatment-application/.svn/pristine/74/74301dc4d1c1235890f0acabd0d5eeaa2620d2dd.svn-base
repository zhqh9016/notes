package com.taikang.dic.ltci.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.api.model.ResultDTO;

@FeignClient(name = "${feign.system}", url = "${feign.system.url}")
public interface OrganizationServerClient {

  /** 根据社保机构编码精确查询 */
  @RequestMapping(value = "/api/v1/organization/getBySocOrgCode", method = RequestMethod.GET)
  public ResultDTO getBySocOrgCode(@RequestParam("socOrgCode") String socOrgCode);
}
