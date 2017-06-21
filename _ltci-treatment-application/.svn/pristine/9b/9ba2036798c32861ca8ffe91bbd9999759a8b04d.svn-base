package com.taikang.dic.ltci.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.taikang.dic.ltci.api.model.ResultDTO;

/** @author itw_cxy */
@FeignClient(name = "${feign.evaluate.nursing.client}", url = "${feign.evaluate.nursing.url}")
public interface CheckInServerClient {

  @RequestMapping(
    method = RequestMethod.GET,
    value = "/api/v1/insuredPerson/{idCard}/{insuredPersonName}/inHospState"
  )
  public ResultDTO getInHospState(
      @PathVariable("idCard") String idCard,
      @PathVariable("insuredPersonName") String insuredPersonName);

  @RequestMapping(
    method = RequestMethod.GET,
    value = "/api/v1/insuredPerson/{idCard}/{insuredPersonName}/checkInHospState"
  )
  public ResultDTO getCheckInHospState(
      @PathVariable("idCard") String idCard,
      @PathVariable("insuredPersonName") String insuredPersonName);
}
