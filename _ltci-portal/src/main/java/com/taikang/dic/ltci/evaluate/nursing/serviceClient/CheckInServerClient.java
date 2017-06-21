package com.taikang.dic.ltci.evaluate.nursing.serviceClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.CheckInDTO;
import com.taikang.dic.ltci.portal.api.model.RestResponseDTO;

/**
 * @author itw_xuxf
 * @version 2017年4月15日下午6:45:33 待遇申请 feign请求
 */
@FeignClient(name = "${feign.evaluate.nursing.client}", url = "${feign.evaluate.nursing.url}")
public interface CheckInServerClient {
  /**
   * 协议退出
   *
   * @param exitFrom
   * @param exitReason
   * @param exitReasonDetial
   * @param inHospState
   * @param agreOutDate
   * @param operatedBy
   * @param checkInCode
   * @param systemCode
   * @return
   */
  @RequestMapping(method = RequestMethod.PUT, value = "/api/v1/checkInOut")
  RestResponseDTO checkInProtocolExit(
      @RequestBody CheckInDTO checkInDTO, @RequestParam(value = "systemCode") String systemCode);

  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/checkIn")
  RestResponseDTO getCheckIn(
      @RequestParam(value = "beCarePersonName") String beCarePersonName,
      @RequestParam(value = "beCarePersonCard") String beCarePersonCard,
      @RequestParam(value = "orgName") String orgName,
      @RequestParam(value = "operatedTime") String operatedTime,
      @RequestParam(value = "inHospState") String inHospState,
      @RequestParam(value = "page") int page,
      @RequestParam(value = "pageSize") int pageSize,
      @RequestParam(value = "systemCode") String systemCode);
}
