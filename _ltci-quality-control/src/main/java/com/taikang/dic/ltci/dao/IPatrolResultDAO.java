package com.taikang.dic.ltci.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IPatrolResultDAO {

  Map<String, Object> getPatrolResult(@Param("patrolTaskId") String patrolTaskId);

  List<Map<String, Object>> getOrgTaskId(@Param("patrolTaskId") String patrolTaskId);

  List<Map<String, Object>> getExecuteFile(@Param("patrolTaskId") String patrolTaskId);

  List<Map<String, Object>> getComplaintResource(@Param("patrolTaskId") String patrolTaskId);

  int updatePatrolTask(
      @Param("patrolTaskId") String patrolTaskId, @Param("auditState") int auditState);

  int updateExecuteResult(
      @Param("patrolTaskId") String patrolTaskId,
      @Param("auditState") int auditState,
      @Param("rejectionReason") String rejectionReason);
}
