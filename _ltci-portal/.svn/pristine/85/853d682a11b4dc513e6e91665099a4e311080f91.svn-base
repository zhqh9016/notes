package com.taikang.dic.ltci.evaluate.nursing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.evaluate.nursing.service.NursingTaskService;
import com.taikang.dic.ltci.evaluate.nursing.serviceClient.NursingTaskServerClient;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.RestResponseDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.restRequestResponse.RestResponseFormat;
import com.taikang.dic.ltci.portal.common.util.UserUtils;

@Service
public class NursingTaskServiceImpl implements NursingTaskService {

  @Autowired private NursingTaskServerClient nursingTaskServerClient;

  @Value(value = "${spring.application.name}")
  private String systemCode;
  /** 修改意向选择机构 */
  @Override
  public ResultDTO updateNursingTaskIntentAgency(
      String nursingTaskCodes, String intentAgencyCode, String applyType, String isRelativeCared) {
    String operatedBy = "";
    String operatedOrg = "";
    UserDTO userDTO = UserUtils.getCurrentUser();
    if (userDTO != null) {
      operatedBy = userDTO.getTrueName();
      if (userDTO.getDepartment() != null) {
        operatedOrg = userDTO.getDepartment().getCode();
      }
    }
    RestResponseDTO restResponseDTO =
        nursingTaskServerClient.updateNursingTaskIntentAgency(
            nursingTaskCodes,
            intentAgencyCode,
            applyType,
            isRelativeCared,
            operatedBy,
            operatedOrg,
            systemCode);
    return RestResponseFormat.restResponseDTO2ResultDTO(restResponseDTO);
  }

  @Override
  public PageResultDTO getNursingTaskList(
      String insuredPersonName,
      String idCard,
      String evaluateAgencyName,
      String operatedTime,
      String state,
      int page,
      int pageSize) {
    RestResponseDTO restResponseDTO =
        nursingTaskServerClient.getNursingTaskList(
            insuredPersonName, idCard, evaluateAgencyName, operatedTime, state, page, pageSize);
    return RestResponseFormat.restResponseDTO2PageResultDTO(restResponseDTO);
  }

  @Override
  public ResultDTO updateNursingTaskFinalAgency(
      String nursingTaskCodes,
      String finalAgencyCode,
      String finalAgencyName,
      String applyType,
      String isRelativeCared) {
    String operatedBy = "";
    String operatedOrg = "";
    UserDTO userDTO = UserUtils.getCurrentUser();
    if (userDTO != null) {
      operatedBy = userDTO.getTrueName();
      if (userDTO.getDepartment() != null) {
        operatedOrg = userDTO.getDepartment().getCode();
      }
    }
    RestResponseDTO restResponseDTO =
        nursingTaskServerClient.updateNursingTaskFinalAgency(
            nursingTaskCodes,
            finalAgencyCode,
            finalAgencyName,
            applyType,
            isRelativeCared,
            operatedBy,
            operatedOrg,
            systemCode);
    return RestResponseFormat.restResponseDTO2ResultDTO(restResponseDTO);
  }
}
