package com.taikang.dic.ltci.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taikang.dic.ltci.api.model.ResultDTO;

@FeignClient(name = "${feign.system}", url = "${feign.system.url}")
public interface DictionaryServerClient {

  @RequestMapping(value = "/api/v1/dictionary/{type}/and{value}", method = RequestMethod.GET)
  public ResultDTO getDictionaryDOByCondition(
      @PathVariable(value = "type") String type, @PathVariable(value = "value") String value);
}
