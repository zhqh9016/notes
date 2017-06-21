package com.taikang.dic.ltci.quality.control.serviceClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.ResultDTO;

@FeignClient(name = "${feign.quality.control.client}", url = "${feign.quality.control.url}")
public interface PatrolResultServiceClient {

  @RequestMapping(value = "/api/v1/patrol/result/state", method = RequestMethod.PUT)
  ResultDTO updateAuditState(
      @RequestParam(value = "patrolTaskId") String patrolTaskId,
      @RequestParam(value = "auditState") int auditState,
      @RequestParam(value = "rejectionReason") String rejectionReason);
}
