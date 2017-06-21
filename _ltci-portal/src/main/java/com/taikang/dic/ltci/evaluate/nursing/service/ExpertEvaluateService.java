package com.taikang.dic.ltci.evaluate.nursing.service;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

public interface ExpertEvaluateService {

  PageResultDTO getExpertEvaluateList(
      String insuredPersonName,
      String idCard,
      String evaluateAgencyName,
      String operatedStartTime,
      String operatedEndTime,
      int page,
      int pageSize);

  ResultDTO getExpertEvaluateScan(String expertEvaluateCode);

  ResultDTO putExpertEvaluate(
      String expertEvaluateCode,
      String accessoryAddress,
      String evaluateContent,
      int fraction,
      String opinion);
}
