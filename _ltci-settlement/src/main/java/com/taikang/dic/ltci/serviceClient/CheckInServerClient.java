package com.taikang.dic.ltci.serviceClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.api.model.ResultDTO;

@FeignClient(name = "${feign.evaluate.nursing.client}", url = "${feign.evaluate.nursing.url}")
public interface CheckInServerClient {

  @RequestMapping(path = "/api/v1/getInHospStat4Check", method = RequestMethod.GET)
  public ResultDTO getInHostStat4Check(@RequestParam("inRecordUuid") String inRecordUuid);
}
