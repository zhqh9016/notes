package com.taikang.dic.ltci.evaluate.nursing.service;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

public interface EvaluateTaskService {

  //分页查询评估任务列表
  PageResultDTO queryEvaluateTaskList(
      String insuredPersonName,
      String mobile,
      String operatedTime,
      String taskState,
      int page,
      int pageSize);

  ResultDTO sendEvaluateTaskBatch(String evaluateTaskCodes);

  ResultDTO getEvaluateDepartments(String areaNum, String organizationType);

  ResultDTO reviewEvaluateTask(String evaluateTaskCode, String reevalueateResult);

  ResultDTO batchTreatmentApplicationCase(
      String taskState, String operatedBy, String evaluateTaskCodes);

  PageResultDTO getExpertTaskList(
      String insuredPersonName,
      String idCard,
      String evaluateOrg,
      String operatedTime,
      String taskState,
      int page,
      int pageSize);

  ResultDTO getMongoDBMessage(String id);

  ResultDTO getToDoListEvaluateTaskList();
}
