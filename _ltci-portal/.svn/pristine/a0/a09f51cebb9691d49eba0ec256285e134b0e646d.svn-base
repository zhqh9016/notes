package com.taikang.dic.ltci.treatment.application.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.DeputyBindingDTO;
import com.taikang.dic.ltci.portal.api.model.RestResponseDTO;

@FeignClient(name = "${feign.treatment.application}", url = "${feignClient}")
public interface DeputyBindingServerClient {

  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/deputy/bindings")
  RestResponseDTO getDeputyBindingChecks(
      @RequestParam(value = "insuredPersonName") String insuredPersonName,
      @RequestParam(value = "idCard") String idCard,
      @RequestParam(value = "securityNumber") String securityNumber,
      @RequestParam(value = "deputyName") String deputyName,
      @RequestParam(value = "deputyIdCard") String deputyIdCard,
      @RequestParam(value = "checkState") String checkState,
      @RequestParam(value = "page") int page,
      @RequestParam(value = "pageSize") int pageSize,
      @RequestParam(value = "systemCode") String systemCode);

  @RequestMapping(method = RequestMethod.GET, value = "/api/v1/deputy/bindings/{deputyBindingCode}")
  RestResponseDTO getDeputyBindingDTO(
      @PathVariable(value = "deputyBindingCode") String deputyBindingCode,
      @RequestParam(value = "systemCode") String systemCode);

  @RequestMapping(
    method = RequestMethod.PUT,
    value = "/api/v1/deputy/bindings/deputyBindingid/checkState"
  )
  RestResponseDTO updateDeputyBindingDTO(
      @RequestBody DeputyBindingDTO deputyBindingDTO,
      @RequestParam(value = "systemCode") String systemCode);
}
