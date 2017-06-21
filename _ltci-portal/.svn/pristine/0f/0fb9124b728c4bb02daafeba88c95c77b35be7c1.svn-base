package com.taikang.dic.ltci.treatment.application.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.ApplicationDTO;
import com.taikang.dic.ltci.portal.api.model.ApplicationLogDTO;
import com.taikang.dic.ltci.portal.api.model.RestResponseDTO;
import com.taikang.dic.ltci.portal.api.model.TreatApplyDTO;
import com.taikang.dic.ltci.portal.api.model.TreatmentApplicationDTO;

/**
 * @author itw_xuxf
 * @version 2017年3月31日下午3:21:33 待遇申请 feign请求
 */
@FeignClient(name = "${feign.treatment.application}", url = "${feignClient}")
public interface TreatmentApplicationServerClient {
  /**
   * 待遇申请状态修改
   *
   * @param applicationCode 待遇申请编号
   * @param applicationStatus 待遇申请状态
   * @return
   */
  @RequestMapping(
    method = RequestMethod.POST,
    value =
        "/api/v1/mobileTreatmentApplicationCase/applicationCode/applicationStatus/applicationReason/createdBy"
  )
  RestResponseDTO treatmentApplicationCase(
      @RequestBody ApplicationLogDTO logDto, @RequestParam(value = "systemCode") String systemCode);

  /**
   * 批量申请状态修改
   *
   * @param applicationCode 待遇申请编号
   * @param applicationStatus 待遇申请状态
   * @return
   */
  @RequestMapping(method = RequestMethod.PUT, value = "/api/v1/batchTreatmentApplicationCase")
  RestResponseDTO batchTreatmentApplicationCase(
      @RequestParam(value = "applicationSpecialDO") String applicationSpecialDO,
      @RequestParam(value = "systemCode") String systemCode);

  /**
   * 根据待遇申请编号查询详情
   *
   * @param applicationCode 待遇申请编号
   * @return
   */
  @RequestMapping(
    method = RequestMethod.GET,
    value = "/api/v1/mobileTreatmentApplication/{applicationCode}"
  )
  RestResponseDTO getTreatmentApplication(
      @PathVariable(value = "applicationCode") String applicationCode,
      @RequestParam(value = "systemCode") String systemCode);

  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/application")
  RestResponseDTO createApplication(
      @RequestBody ApplicationDTO applicationDTO,
      @RequestParam(value = "systemCode") String systemCode);

  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/treatmentApplicationAttachement")
  RestResponseDTO uploadTreatmentApplicationAttachement(
      @RequestBody String base64, @RequestParam(value = "systemCode") String systemCode);

  @RequestMapping(
    method = RequestMethod.DELETE,
    value = "/api/v1/treatmentApplicationAttachement/{attachmentid}"
  )
  RestResponseDTO deleteTreatmentApplicationAttachement(
      @PathVariable(value = "attachmentid") String attachmentid,
      @RequestParam(value = "systemCode") String systemCode);

  /**
   * 移动端待遇受理分页查询
   *
   * @param insuredPersonName 参保人姓名
   * @param idCard 参保人身份证
   * @param securityNumber 参保人社保卡号
   * @param disease 疾病
   * @param operatedTime 经办时间
   * @param page 页数
   * @param size 条数
   * @return
   */
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/mobileTreatmentApplications")
  public RestResponseDTO mobileTreatmentApplicationList(
      @RequestBody TreatApplyDTO treatApplyDTOParam,
      @RequestParam(value = "page") int page,
      @RequestParam(value = "pageSize") int pageSize,
      @RequestParam(value = "systemCode") String systemCode);

  @RequestMapping(path = "/api/v1/treatmentApplication", method = RequestMethod.POST)
  public RestResponseDTO createTreatmentApplication(
      @RequestBody TreatmentApplicationDTO dto,
      @RequestParam(value = "systemCode") String systemCode);
}
