package com.taikang.dic.ltci.evaluate.nursing.serviceClient;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.NursingTaskDTO;
import com.taikang.dic.ltci.portal.api.model.RestResponseDTO;

@FeignClient(name = "${feign.evaluate.nursing.client}", url = "${feign.evaluate.nursing.url}")
public interface NursingTaskServerClient {
  /**
   * 评估任务新增
   *
   * @param evaluateTaskDTO
   * @param systemCode
   * @return
   */
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/nursingTask")
  RestResponseDTO nursingTaskAdd(
      @RequestBody NursingTaskDTO nursingTaskDTO,
      @RequestParam(value = "systemCode") String systemCode);

  /**
   * 评估任务新增
   *
   * @param evaluateTaskDTO
   * @param systemCode
   * @return
   */
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/nursingTaskList")
  RestResponseDTO nursingTaskListAdd(
      @RequestBody List<NursingTaskDTO> nursingTaskDTOs,
      @RequestParam(value = "systemCode") String systemCode);
  /**
   * 修改意向机构
   *
   * @param nursingTaskCodes
   * @param intentAgencyCodes
   * @param operatedBy
   * @param operatedOrg
   * @return
   */
  @RequestMapping(value = "/api/v1/nursingTaskIntentAgency", method = RequestMethod.PUT)
  public RestResponseDTO updateNursingTaskIntentAgency(
      @RequestParam(value = "nursingTaskCodes") String nursingTaskCodes,
      @RequestParam(value = "intentAgencyCode") String intentAgencyCode,
      @RequestParam(value = "applyType") String applyType,
      @RequestParam(value = "isRelativeCared") String isRelativeCared,
      @RequestParam(value = "operatedBy") String operatedBy,
      @RequestParam(value = "operatedOrg") String operatedOrg,
      @RequestParam(value = "systemCode") String systemCode);

  @RequestMapping(value = "/api/v1/nursingTasks", method = RequestMethod.POST)
  public RestResponseDTO getNursingTaskList(
      @RequestParam(value = "insuredPersonName") String insuredPersonName,
      @RequestParam(value = "idCard") String idCard,
      @RequestParam(value = "evaluateAgencyName") String evaluateAgencyName,
      @RequestParam(value = "operatedTime") String operatedTime,
      @RequestParam(value = "state") String state,
      @RequestParam(value = "page") int page,
      @RequestParam(value = "pageSize") int pageSize);

  @RequestMapping(value = "/api/v1/nursingTaskFinalAgency", method = RequestMethod.PUT)
  RestResponseDTO updateNursingTaskFinalAgency(
      @RequestParam(value = "nursingTaskCodes") String nursingTaskCodes,
      @RequestParam(value = "finalAgencyCode") String finalAgencyCode,
      @RequestParam(value = "finalAgencyName") String finalAgencyName,
      @RequestParam(value = "applyType") String applyType,
      @RequestParam(value = "isRelativeCared") String isRelativeCared,
      @RequestParam(value = "operatedBy") String operatedBy,
      @RequestParam(value = "operatedOrg") String operatedOrg,
      @RequestParam(value = "systemCode") String systemCode);
}
