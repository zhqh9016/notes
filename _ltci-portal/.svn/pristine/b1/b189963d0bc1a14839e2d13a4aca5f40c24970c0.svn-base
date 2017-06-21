package com.taikang.dic.ltci.quality.control.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taikang.dic.ltci.portal.api.model.EvaluateTaskProfessionDTO;
import com.taikang.dic.ltci.portal.api.model.NursingTaskProfessionDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.PatrolTaskDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.quality.control.model.PatrolTaskAddDO;

/**
 * @author itw_xuxf
 * @description
 * @version 创建时间：2017年4月28日下午5:37:04
 */
public interface PatrolTaskService {
  //分页查询巡查评估任务列表
  PageResultDTO getEvaluatePatrolTaskList(
      String isCritical,
      String beginTime,
      String endTime,
      String provinceCode,
      String cityCode,
      String areaCode,
      String orgCode,
      int page,
      int pageSize);

  /** 分页查询巡查评估任务列表 */
  PageResultDTO getNursingPatrolTaskList(
      String serviceType,
      String serviceItems,
      String isKinshipCare,
      String isPrivilege,
      String beginTime,
      String endTime,
      String provinceCode,
      String cityCode,
      String areaCode,
      String orgCode,
      int page,
      int pageSize);

  ResultDTO addPatrol(PatrolTaskAddDO patrolTaskAddDO);

  //任务分配列表查询
  PageResultDTO listPatrolTask(PatrolTaskDTO patrolTaskDTO, int page, int pageSize);

  //任务分配
  ResultDTO patrolTaskAllot(
      String patrolTaskId,
      String patrolStaffId,
      String patrolStaffName,
      String operatedBy,
      String operatedOrg);

  ResultDTO expertTaskProfessionAdd(List<EvaluateTaskProfessionDTO> evaluateTaskProfessionDTOs);

  ResultDTO nursingTaskProfessionAdd(List<NursingTaskProfessionDTO> nursingTaskProfessionDTOs);

  ResultDTO patrolTaskDetails(String patrolTaskId);

  ResultDTO isHaveEvaluateOrgTaskId(List<EvaluateTaskProfessionDTO> evaluateTaskProfessionDTOs);

  ResultDTO isHaveNursingOrgTaskId(List<NursingTaskProfessionDTO> nursingTaskProfessionDTOs);

  void getMongoDBMessage(
      String resourceFileName,
      String resourceMaterialInfoScan,
      HttpServletRequest request,
      HttpServletResponse response);
}
