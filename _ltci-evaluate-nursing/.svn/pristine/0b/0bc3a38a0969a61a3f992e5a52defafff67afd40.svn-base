package com.taikang.dic.ltci.service;

import java.util.List;
import java.util.Map;

import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.model.NursingTaskDO;

public interface NursingTaskService extends GenericService<NursingTaskDO, String> {

  int createNursingTask(NursingTaskDO uursingTaskDO);

  public ResultDTO updateNursingTaskIntentAgency(
      String nursingTaskCodes,
      String intentAgencyCode,
      String applyType,
      String isRelativeCared,
      String operatedBy,
      String operatedOrg);

  public ResultDTO updateNursingTaskFinalAgency(
      String nursingTaskCodes,
      String finalAgencyCode,
      String finalAgencyName,
      String applyType,
      String isRelativeCared,
      String operatedBy,
      String operatedOrg);

  public Map<String, Object> getNursingTaskList(
      String insuredPersonName,
      String idCard,
      String evaluateAgencyName,
      String operatedTime,
      String state,
      int page,
      int pageSize);

  int insertNursingTaskList(List<NursingTaskDO> list);

  boolean getNursingTaskByEvaluateTaskCode(String evaluateTaskCode);
}
