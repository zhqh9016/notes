package com.taikang.dic.ltci.evaluate.nursing.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.evaluate.nursing.service.ExpertEvaluateService;
import com.taikang.dic.ltci.evaluate.nursing.serviceClient.ExpertEvaluateServerClient;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.RestResponseDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.restRequestResponse.RestResponseFormat;
import com.taikang.dic.ltci.portal.common.util.UserUtils;

@Service
public class ExpertEvaluateServiceImpl implements ExpertEvaluateService {

  @Autowired private ExpertEvaluateServerClient expertEvaluateServerClient;

  @Value(value = "${spring.application.name}")
  private String systemCode;

  @Override
  public PageResultDTO getExpertEvaluateList(
      String insuredPersonName,
      String idCard,
      String evaluateAgencyName,
      String operatedStartTime,
      String operatedEndTime,
      int page,
      int pageSize) {
    RestResponseDTO restResponseDTO =
        expertEvaluateServerClient.getExpertEvaluate(
            insuredPersonName,
            idCard,
            evaluateAgencyName,
            operatedStartTime,
            operatedEndTime,
            page,
            pageSize,
            operatedEndTime);
    return RestResponseFormat.restResponseDTO2PageResultDTO(restResponseDTO);
  }

  @Override
  public ResultDTO getExpertEvaluateScan(String expertEvaluateCode) {
    RestResponseDTO restResponseDTO =
        expertEvaluateServerClient.getExpertEvaluateScan(expertEvaluateCode);
    return RestResponseFormat.restResponseDTO2ResultDTO(restResponseDTO);
  }

  @Override
  public ResultDTO putExpertEvaluate(
      String expertEvaluateCode,
      String accessoryAddress,
      String evaluateContent,
      int fraction,
      String opinion) {
    UserDTO currentUser = UserUtils.getCurrentUser();
    String operatedBy = null;
    String operatedOrg = null;

    if (currentUser == null) {
      operatedBy = "";
      operatedOrg = "";
    } else {
      operatedBy = currentUser.getTrueName();
      if (currentUser.getDepartment() != null) {
        operatedOrg = currentUser.getDepartment().getCode();
      }
    }
    RestResponseDTO restResponseDTO =
        expertEvaluateServerClient.putExpertEvaluate(
            expertEvaluateCode,
            accessoryAddress,
            evaluateContent,
            fraction,
            opinion,
            operatedBy,
            operatedBy,
            operatedOrg);
    return RestResponseFormat.restResponseDTO2ResultDTO(restResponseDTO);
  }
}
