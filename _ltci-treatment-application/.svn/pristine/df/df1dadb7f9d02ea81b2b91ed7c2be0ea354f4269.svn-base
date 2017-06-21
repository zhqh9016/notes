package com.taikang.dic.ltci.service;

import java.util.List;

import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.model.ApplicationDO;

public interface ApplicationService extends GenericService<ApplicationDO, String> {

  String createApplication(ApplicationDO applicationDO);

  ResultDTO getApplicationState(
      String idCard, String securityNumber, String insuredPersonName, String deputyIdCard);

  ResultDTO getApplicationSimple(List<String> applicationSimples);

  ResultDTO getApplicationComplex(String applicationCodes);
}
