package com.taikang.dic.ltci.treatment.application.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.RestResponseDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.restRequestResponse.RestResponseFormat;
import com.taikang.dic.ltci.portal.common.util.UserUtils;
import com.taikang.dic.ltci.treatment.application.model.InsuredInfoSpeDO;
import com.taikang.dic.ltci.treatment.application.serverClient.InsuredInfoServerClient;
import com.taikang.dic.ltci.treatment.application.service.InsuredInfoService;

/** @author itw_caoxy 参保人表service层进行查，增，改操作。 */
@Service
public class InsuredInfoServiceImpl implements InsuredInfoService {

  @Autowired InsuredInfoServerClient insuredInfoServerClient;

  @Override
  public PageResultDTO getInsuredInfo(
      String idCard, String insuredPersonName, String securityNumber, int page, int pageSize) {
    RestResponseDTO restResponseDTO =
        insuredInfoServerClient.getInsuredInfo(
            idCard, insuredPersonName, securityNumber, page, pageSize);
    PageResultDTO pageResult = RestResponseFormat.restResponseDTO2PageResultDTO(restResponseDTO);
    return pageResult;
  }

  @Override
  public ResultDTO createInsuredInfo(InsuredInfoSpeDO InsuredInfoSpeDO) {
    UserDTO userDTO = UserUtils.getCurrentUser();
    String operatedBy = "";
    String operatedOrg = "";
    if (userDTO != null) {
      operatedBy = userDTO.getTrueName();
      if (userDTO.getDepartment() != null) {
        operatedOrg = userDTO.getDepartment().getCode();
      }
    }
    InsuredInfoSpeDO.setCreatedBy(operatedBy);
    InsuredInfoSpeDO.setCreatedOrg(operatedOrg);
    RestResponseDTO restResponseDTO = insuredInfoServerClient.createInsuredInfo(InsuredInfoSpeDO);
    ResultDTO resultDTO = RestResponseFormat.restResponseDTO2ResultDTO(restResponseDTO);
    return resultDTO;
  }

  @Override
  public ResultDTO updateInsuredInfo(InsuredInfoSpeDO InsuredInfoSpeDO) {
    UserDTO userDTO = UserUtils.getCurrentUser();
    String operatedBy = "";
    String operatedOrg = "";
    if (userDTO != null) {
      operatedBy = userDTO.getTrueName();
      if (userDTO.getDepartment() != null) {
        operatedOrg = userDTO.getDepartment().getCode();
      }
    }
    InsuredInfoSpeDO.setOperatedBy(operatedBy);
    InsuredInfoSpeDO.setOperatedOrg(operatedOrg);
    RestResponseDTO restResponseDTO = insuredInfoServerClient.updateInsuredInfo(InsuredInfoSpeDO);
    ResultDTO resultDTO = RestResponseFormat.restResponseDTO2ResultDTO(restResponseDTO);
    return resultDTO;
  }
}
