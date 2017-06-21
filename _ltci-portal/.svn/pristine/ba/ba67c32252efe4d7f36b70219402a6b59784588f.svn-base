package com.taikang.dic.ltci.treatment.application.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.dic.ltci.portal.api.model.InsuredPersonDTO;
import com.taikang.dic.ltci.portal.api.model.RestResponseDTO;

/**
 * @author itw_liuxy
 * @description
 * @createTime 2017年3月31日 下午3:36:12
 */
@FeignClient(name = "${feign.treatment.application}", url = "${feignClient}")
public interface InsuredPersonServerClient {

  @RequestMapping(
    method = RequestMethod.GET,
    value = "/api/v1/insuredPerson/{idCard}/and/{insuredPersonName}/{uniqueNumber}/{operator}"
  )
  @ResponseBody
  RestResponseDTO getInsuredPerson(
      @PathVariable(value = "idCard") String idCard,
      @PathVariable(value = "insuredPersonName") String insuredPersonName,
      @PathVariable(value = "uniqueNumber") String uniqueNumber,
      @PathVariable(value = "operator") String operator,
      @RequestParam(value = "systemCode") String systemCode);

  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/insuredPerson")
  @ResponseBody
  RestResponseDTO createInsuredPerson(
      @RequestBody InsuredPersonDTO insuredPersonDTO,
      @RequestParam(value = "systemCode") String systemCode);

  @RequestMapping(method = RequestMethod.PUT, value = "/api/v1/insuredPerson")
  @ResponseBody
  RestResponseDTO updateInsuredPerson(
      @RequestBody InsuredPersonDTO insuredPersonDTO,
      @RequestParam(value = "systemCode") String systemCode);

  @RequestMapping(
    method = RequestMethod.GET,
    value = "/api/v1/insuredPerson/{insuredPersonCode}/or/{idCard}/or/{securityNum}"
  )
  @ResponseBody
  RestResponseDTO getInsuredPersonDetail(
      @PathVariable(value = "insuredPersonCode") String insuredPersonCode,
      @PathVariable(value = "idCard") String idCard,
      @PathVariable(value = "securityNum") String securityNum);
}
