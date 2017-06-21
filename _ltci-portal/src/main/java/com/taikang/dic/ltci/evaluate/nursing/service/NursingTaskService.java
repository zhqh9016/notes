package com.taikang.dic.ltci.evaluate.nursing.service;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

public interface NursingTaskService {

  public ResultDTO updateNursingTaskIntentAgency(
      String nursingTaskCodes, String intentAgencyCode, String applyType, String isRelativeCared);

  public PageResultDTO getNursingTaskList(
      String insuredPersonName,
      String idCard,
      String evaluateAgencyName,
      String operatedTime,
      String state,
      int page,
      int pageSize);

  public ResultDTO updateNursingTaskFinalAgency(
      String nursingTaskCodes,
      String finalAgencyCode,
      String finalAgencyName,
      String applyType,
      String isRelativeCared);
}
