package com.taikang.dic.ltci.service;

import java.util.List;
import java.util.Map;

import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.model.PatrolTaskAddDO;
import com.taikang.dic.ltci.model.PatrolTaskAllotDetailSpecialDO;
import com.taikang.dic.ltci.model.PatrolTaskDO;
import com.taikang.dic.ltci.model.PatrolTaskDetailDO;
import com.taikang.dic.ltci.model.PatrolTaskSpecialDO;

public interface PatrolTaskService extends GenericService<PatrolTaskDO, String> {

  Map<String, Object> listPatrolTask(
      PatrolTaskSpecialDO patrolTaskSpecialDO, int page, int pageSize);

  int expertTaskProfessionBatchAdd(
      List<PatrolTaskDetailDO> patrolTaskDetailDOs, int patrolObjectType);

  ResultDTO addPatrol(PatrolTaskAddDO patrolTaskAddDO);

  Boolean patrolTaskAllot(
      String patrolTaskId,
      String patrolStaffId,
      String patrolStaffName,
      String operatedBy,
      String operatedOrg);

  PatrolTaskSpecialDO patrolTaskDetails(String patrolTaskId);

  List<String> isHaveOrgTaskIdList(List<PatrolTaskDetailDO> patrolTaskDetailDOs);

  ResultDTO insertMqMessageLog(String message);

  PatrolTaskAllotDetailSpecialDO patrolTaskAllotDetails(String patrolTaskId);
}
