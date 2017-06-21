package com.taikang.dic.ltci.quality.control.serviceClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taikang.dic.ltci.portal.api.model.ReconsiderDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

@FeignClient(name = "${feign.quality.control.client}", url = "${feign.quality.control.url}")
public interface ReconsiderServiceClient {

  @RequestMapping(value = "/api/v1/reconsiders/{patrolTaskId}", method = RequestMethod.GET)
  public ResultDTO getReconsiderListByPatrolTaskId(
      @PathVariable("patrolTaskId") String patrolTaskId);

  @RequestMapping(value = "/api/v1/reconsiders", method = RequestMethod.POST)
  public ResultDTO saveReconsider(@RequestBody ReconsiderDTO reconsider);
}
