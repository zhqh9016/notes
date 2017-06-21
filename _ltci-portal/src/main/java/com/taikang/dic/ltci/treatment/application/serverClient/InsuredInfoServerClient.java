package com.taikang.dic.ltci.treatment.application.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.dic.ltci.portal.api.model.InsuredPersonDTO;
import com.taikang.dic.ltci.portal.api.model.RestResponseDTO;
import com.taikang.dic.ltci.treatment.application.model.InsuredInfoSpeDO;

/**
 * @author itw_liuxy
 * @description
 * @createTime 2017年3月31日 下午3:36:12
 */
@FeignClient(name = "${feign.treatment.application}", url = "${feignClient}")
public interface InsuredInfoServerClient {

  @RequestMapping(path = "/api/v1/insuredInfos", method = RequestMethod.GET)
  public RestResponseDTO getInsuredInfo(
      @RequestParam(value = "idCard", required = false) String idCard,
      @RequestParam(value = "insuredPersonName", required = false) String insuredPersonName,
      @RequestParam(value = "securityNumber", required = false) String securityNumber,
      @RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize);

  @RequestMapping(path = "/api/v1/new/insuredInfo", method = RequestMethod.POST)
  public RestResponseDTO createInsuredInfo(@ModelAttribute InsuredInfoSpeDO InsuredInfoSpeDO);

  @RequestMapping(path = "/api/v1/diff/insuredInfo", method = RequestMethod.PUT)
  public RestResponseDTO updateInsuredInfo(@ModelAttribute InsuredInfoSpeDO InsuredInfoSpeDO);
}
