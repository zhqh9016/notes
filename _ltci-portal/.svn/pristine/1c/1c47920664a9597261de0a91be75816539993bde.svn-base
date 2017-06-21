package com.taikang.dic.ltci.evaluate.nursing.serviceClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.RestResponseDTO;

@FeignClient(name = "${feign.evaluate.nursing.client}", url = "${feign.evaluate.nursing.url}")
public interface ExpertEvaluateServerClient {

  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/expertEvaluate")
  RestResponseDTO getExpertEvaluate(
      @RequestParam(value = "insuredPersonName") String insuredPersonName,
      @RequestParam(value = "idCard") String idCard,
      @RequestParam(value = "evaluateAgencyName") String evaluateAgencyName,
      @RequestParam(value = "operatedStartTime") String operatedStartTime,
      @RequestParam(value = "operatedEndTime") String operatedEndTime,
      @RequestParam(value = "page") int page,
      @RequestParam(value = "pageSize") int pageSize,
      @RequestParam(value = "systemCode") String systemCode);

  @RequestMapping(method = RequestMethod.GET, value = "/api/v1/expertEvaluat/{expertEvaluateCode}")
  RestResponseDTO getExpertEvaluateScan(
      @RequestParam(value = "expertEvaluateCode") String expertEvaluateCode);

  @RequestMapping(method = RequestMethod.PUT, value = "/api/v1/expertEvaluat/detial")
  RestResponseDTO putExpertEvaluate(
      @RequestParam(value = "expertEvaluateCode") String expertEvaluateCode,
      @RequestParam(value = "accessoryAddress") String accessoryAddress,
      @RequestParam(value = "evaluateContent") String evaluateContent,
      @RequestParam(value = "fraction") int fraction,
      @RequestParam(value = "opinion") String opinion,
      @RequestParam(value = "operatedBy") String operatedBy,
      @RequestParam(value = "operatedOrg") String operatedOrg,
      @RequestParam(value = "systemCode") String systemCode);
}
