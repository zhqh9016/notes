package com.taikang.dic.ltci.treatment.application.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.portal.api.model.DeputyBindingDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.RestResponseDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.restRequestResponse.RestResponseFormat;
import com.taikang.dic.ltci.portal.common.util.UserUtils;
import com.taikang.dic.ltci.treatment.application.serverClient.DeputyBindingServerClient;
import com.taikang.dic.ltci.treatment.application.service.DeputyBindingService;

@Service
public class DeputyBindingServiceImpl implements DeputyBindingService {
  @Autowired private DeputyBindingServerClient deputyBindingServerClient;

  @Value(value = "${spring.application.name}")
  private String systemCode;

  private static final Logger logger = LoggerFactory.getLogger(DeputyBindingServiceImpl.class);

  public PageResultDTO getDeputyBindingChecks(
      String insuredPersonName,
      String idCard,
      String securityNumber,
      String deputyName,
      String deputyIdCard,
      String checkState,
      int page,
      int pageSize) {
    RestResponseDTO restResponseDTO =
        deputyBindingServerClient.getDeputyBindingChecks(
            insuredPersonName,
            idCard,
            securityNumber,
            deputyName,
            deputyIdCard,
            checkState,
            page,
            pageSize,
            systemCode);

    //    if (pageResultDTO.getDatas() == null) {
    //      throw new NotFoundByIdException("查询不到相关信息！");
    //    }
    PageResultDTO pageResultDTO = RestResponseFormat.restResponseDTO2PageResultDTO(restResponseDTO);
    logger.info(JSONObject.toJSONString(pageResultDTO));
    return pageResultDTO;
  }

  @Override
  public ResultDTO getDeputyBindingDTO(String deputyBindingCode) {
    RestResponseDTO restResponseDTO =
        deputyBindingServerClient.getDeputyBindingDTO(deputyBindingCode, systemCode);
    return RestResponseFormat.restResponseDTO2ResultDTO(restResponseDTO);
  }

  @Override
  public ResultDTO updateDeputyBindingDTO(DeputyBindingDTO deputyBindingDTO) {
    UserDTO userDTO = UserUtils.getCurrentUser();
    String operatedBy = "";
    String operatedOrg = "";
    if (userDTO != null) {
      operatedBy = userDTO.getTrueName();
      if (userDTO.getDepartment() != null) {
        operatedOrg = userDTO.getDepartment().getCode();
      }
    }
    deputyBindingDTO.setOperatedBy(operatedBy);
    deputyBindingDTO.setOperatedOrg(operatedOrg);
    RestResponseDTO restResponseDTO =
        deputyBindingServerClient.updateDeputyBindingDTO(deputyBindingDTO, systemCode);
    return RestResponseFormat.restResponseDTO2ResultDTO(restResponseDTO);
  }
}
