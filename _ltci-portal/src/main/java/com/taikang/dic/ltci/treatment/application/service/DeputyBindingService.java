package com.taikang.dic.ltci.treatment.application.service;

import com.taikang.dic.ltci.portal.api.model.DeputyBindingDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

public interface DeputyBindingService {

  PageResultDTO getDeputyBindingChecks(
      String insuredPersonName,
      String idCard,
      String securityNumber,
      String deputyName,
      String deputyIdCard,
      String checkState,
      int page,
      int pageSize);

  ResultDTO getDeputyBindingDTO(String deputyBindingid);

  ResultDTO updateDeputyBindingDTO(DeputyBindingDTO deputyBindingDTO);
}
