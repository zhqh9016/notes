package com.taikang.dic.ltci.service;

import java.util.Map;

import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.model.FirstEvaluateDO;
import com.taikang.dic.ltci.model.FirstEvaluateSpecialDO;

public interface FirstEvaluateService extends GenericService<FirstEvaluateDO, String> {

  void getEvaluateReceive(byte[] message);

  Map<String, Object> getFirstEvaluate(
      String insuredPersonName,
      String idCard,
      String evaluateOrg,
      String operatedTime,
      int page,
      int pageSize,
      String operatedOrg);

  ResultDTO insertMqMessageLog(String message);

  FirstEvaluateSpecialDO getFirstDetail(String firstEvaluateCode) throws Exception;
}
