package com.taikang.dic.ltci.service;

import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.model.InsuredInfoDO;
import com.taikang.dic.ltci.model.InsuredPersonDO;

public interface InsuredPersonService extends GenericService<InsuredPersonDO, String> {

  ResultDTO getInsuredPerson(
      String idCard, String insuredPersonName, String uniqueNumber, String operator);

  String updateInsuredPerson(InsuredPersonDO insuredPersonDO);

  String createInsuredPerson(InsuredPersonDO insuredPersonDO);

  ResultDTO getInsuredPersonMessage(String insuredPersonCode);

  ResultDTO getInsuredPersonDetail(String insuredPersonCode, String idCard, String securityNum);

  InsuredInfoDO getInsuredInfo(String idCard, String insuredPersonName);
}
