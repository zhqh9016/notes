package com.taikang.dic.ltci.evaluate.nursing.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.evaluate.nursing.service.CheckInService;
import com.taikang.dic.ltci.evaluate.nursing.serviceClient.CheckInServerClient;
import com.taikang.dic.ltci.portal.api.model.CheckInDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.RestResponseDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.restRequestResponse.RestResponseFormat;
import com.taikang.dic.ltci.portal.common.util.UserUtils;

/**
 * @author itw_xuxf
 * @version 2017年3月31日下午3:21:33 待遇申请状态处理 feign请求
 */
@Service
public class CheckInServiceImpl implements CheckInService {

  private static final Logger logger = LoggerFactory.getLogger(CheckInServiceImpl.class);

  @Autowired private CheckInServerClient checkInServerClient;

  @Value(value = "${spring.application.name}")
  private String systemCode;

  @Override
  public ResultDTO checkInProtocolExit(CheckInDTO checkInDTO) {
    UserDTO userDTO = UserUtils.getCurrentUser();
    if (userDTO != null) {
      checkInDTO.setOperatedBy(userDTO.getTrueName());
    }
    RestResponseDTO restResponseDTO =
        checkInServerClient.checkInProtocolExit(checkInDTO, systemCode);
    return RestResponseFormat.restResponseDTO2ResultDTO(restResponseDTO);
  }

  @Override
  public PageResultDTO getCheckIn(
      String beCarePersonName,
      String beCarePersonCard,
      String orgName,
      String operatedTime,
      String inHospState,
      int page,
      int pageSize) {
    RestResponseDTO restResponseDTO =
        checkInServerClient.getCheckIn(
            beCarePersonName,
            beCarePersonCard,
            orgName,
            operatedTime,
            inHospState,
            page,
            pageSize,
            systemCode);
    return RestResponseFormat.restResponseDTO2PageResultDTO(restResponseDTO);
  }
}
