package com.taikang.dic.ltci.evaluate.nursing.service;

import org.springframework.web.bind.annotation.PathVariable;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

public interface FirstEvaluateService {

  PageResultDTO getFirstEvaluate(
      String insuredPersonName,
      String idCard,
      String evaluateOrg,
      String operatedTime,
      int page,
      int pageSize);

  ResultDTO getFirstDetail(String firstEvaluateCode);
}
