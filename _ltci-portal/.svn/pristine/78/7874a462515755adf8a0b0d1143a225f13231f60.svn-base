package com.taikang.dic.ltci.evaluate.nursing.serviceClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.RestResponseDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

@FeignClient(name = "${feign.evaluate.nursing.client}", url = "${feign.evaluate.nursing.url}")
public interface FirstEvaluateServerClient {

  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/firstEvaluate")
  RestResponseDTO getFirstEvaluate(
      @RequestParam(value = "insuredPersonName") String insuredPersonName,
      @RequestParam(value = "idCard") String idCard,
      @RequestParam(value = "evaluateOrg") String evaluateOrg,
      @RequestParam(value = "operatedTime") String operatedTime,
      @RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "pageSize", defaultValue = "15") int pageSize);

  @RequestMapping(method = RequestMethod.GET, value = "/api/v1/firstEvaluate/{firstEvaluateCode}")
  ResultDTO getFirstDetail(@RequestParam(value = "firstEvaluateCode") String firstEvaluateCode);
}
