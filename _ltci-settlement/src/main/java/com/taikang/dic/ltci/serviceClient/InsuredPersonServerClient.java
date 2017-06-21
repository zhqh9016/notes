package com.taikang.dic.ltci.serviceClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.model.TreatmentState;

@FeignClient(name = "${feign.insured.person.client}", url = "${feign.insured.person.url}")
public interface InsuredPersonServerClient {

  /**
   * 根据参保人编号或身份证号或社保卡号查询对应的参保人信息
   *
   * @param insuredPersonCode 参保人编号
   * @param idCard 身份证号
   * @param securityNum 社保卡号
   * @return
   */
  @RequestMapping(method = RequestMethod.GET, value = "/api/v1/insuredPersonDetails")
  ResultDTO getInsuredPersonDetail(
      @RequestParam(value = "insuredPersonCode") String insuredPersonCode,
      @RequestParam(value = "idCard") String idCard,
      @RequestParam(value = "securityNumber") String securityNumber);

  @RequestMapping(path = "/queryNurseTreatment", method = RequestMethod.POST)
  @ResponseBody
  public TreatmentState queryNurseTreatment(String insuredInfo);
}
