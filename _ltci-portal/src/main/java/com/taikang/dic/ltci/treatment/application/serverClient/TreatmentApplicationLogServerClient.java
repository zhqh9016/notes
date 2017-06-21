package com.taikang.dic.ltci.treatment.application.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.ApplicationLogDTO;
import com.taikang.dic.ltci.portal.api.model.RestResponseDTO;

/**
 * @author itw_xuxf
 * @version 2017年3月31日下午3:21:33 待遇申请状态处理 feign请求
 */
@FeignClient(name = "${feign.treatment.application}", url = "${feignClient}")
public interface TreatmentApplicationLogServerClient {
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/applicationLog")
  RestResponseDTO createApplicationLog(
      @RequestBody ApplicationLogDTO applicationLogDTO,
      @RequestParam(value = "systemCode") String systemCode);
}
