package com.taikang.dic.ltci.evaluate.nursing.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.evaluate.nursing.service.FirstEvaluateService;
import com.taikang.dic.ltci.evaluate.nursing.serviceClient.FirstEvaluateServerClient;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.RestResponseDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.common.restRequestResponse.RestResponseFormat;

@Service
public class FirstEvaluateServiceImpl implements FirstEvaluateService {
  private Logger logger = LoggerFactory.getLogger(FirstEvaluateServiceImpl.class);

  @Autowired private FirstEvaluateServerClient firstEvaluateServerClient;

  public PageResultDTO getFirstEvaluate(
      String insuredPersonName,
      String idCard,
      String evaluateOrg,
      String operatedTime,
      int page,
      int pageSize) {
    logger.info("=========进入中间层开始查询初评信息==========");
    RestResponseDTO restResponseDTO =
        firstEvaluateServerClient.getFirstEvaluate(
            insuredPersonName, idCard, evaluateOrg, operatedTime, page, pageSize);
    return RestResponseFormat.restResponseDTO2PageResultDTO(restResponseDTO);
  }

  @Override
  public ResultDTO getFirstDetail(String firstEvaluateCode) {
    return firstEvaluateServerClient.getFirstDetail(firstEvaluateCode);
  }
}
