package com.taikang.dic.ltci.service;

import java.util.Map;

import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.model.ExpertEvaluateDO;

public interface ExpertEvaluateService extends GenericService<ExpertEvaluateDO, String> {
  PageResultDTO getExpertEvaluateList(
      String insuredPersonName,
      String idCard,
      String evaluateAgencyName,
      String operatedStartTime,
      String operatedEndTime,
      int page,
      int pageSize);

  Map<String, Object> getExpertEvaluateScan(String expertEvaluateCode);

  ResultDTO putExpertEvaluate(
      String expertEvaluateCode,
      String accessoryAddress,
      String evaluateContent,
      int fraction,
      String opinion,
      String operatedBy,
      String operatedOrg);
}
