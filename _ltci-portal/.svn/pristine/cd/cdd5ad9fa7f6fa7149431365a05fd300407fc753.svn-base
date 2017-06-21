package com.taikang.dic.ltci.treatment.application.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taikang.dic.ltci.portal.api.model.ResultDTO;

public interface InsuredPersonService {

  ResultDTO getInsuredPerson(String idCard, String insuredPersonName);

  ResultDTO getInsuredPersonDetail(String insuredPersonCode, String idCard, String securityNum);

  void getInsuredPersonExcel(HttpServletRequest request, HttpServletResponse response);
}
