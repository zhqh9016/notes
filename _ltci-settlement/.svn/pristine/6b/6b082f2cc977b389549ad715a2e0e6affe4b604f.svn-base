package com.taikang.dic.ltci.serviceClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.api.model.ResultDTO;

@FeignClient(name = "${feign.system}", url = "${feign.system.url}")
public interface OrgnizationServerClient {

  /** 根据组织编码精确查询 */
  @RequestMapping(value = "/api/v1/organization/getByCode", method = RequestMethod.GET)
  public ResultDTO getByCode(@RequestParam("code") String code);
}
