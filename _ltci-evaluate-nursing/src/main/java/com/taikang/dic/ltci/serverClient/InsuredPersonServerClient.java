package com.taikang.dic.ltci.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.api.model.ResultDTO;

/** @author itw_cxy */
@FeignClient(name = "${feign.treatment.client}", url = "${feign.treatment.url}")
public interface InsuredPersonServerClient {

  @RequestMapping(method = RequestMethod.GET, value = "/api/v1/insuredPerson/{insuredPersonCode}")
  public ResultDTO getInsuredPersonMessage(
      @RequestParam(value = "insuredPersonCode") String insuredPersonCode);

  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/simple/application")
  public ResultDTO getApplicationSimple(
      @RequestParam(value = "applicationCodes") String applicationCodes);

  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/complex/application")
  public ResultDTO getApplicationComplex(
      @RequestParam(value = "applicationCodes") String applicationCodes);

  @RequestMapping(method = RequestMethod.GET, value = "/api/v1/insuredPersonDetails")
  public ResultDTO getInsuredPersonDetail(
      @RequestParam(value = "insuredPersonCode") String insuredPersonCode,
      @RequestParam(value = "idCard") String idCard,
      @RequestParam(value = "securityNumber") String securityNumber);
}
