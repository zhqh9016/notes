package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.MobileComplaintListDO;
import com.taikang.dic.ltci.model.MobileResourceDO;
import com.taikang.dic.ltci.model.PatrolStaffListDO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MobileDAO {
  List<MobileComplaintListDO> getPatrolTaskList(String idCard);

  MobileComplaintListDO getPatrolTask(String patrolTaskId);

  List<MobileResourceDO> getMobileResource(String patrolTaskId);

  List<PatrolStaffListDO> getTodoPatrolTask(
      @Param("patrolStaffId") String patrolStaffId, @Param("taskStatus") List<String> taskStatus);
}
