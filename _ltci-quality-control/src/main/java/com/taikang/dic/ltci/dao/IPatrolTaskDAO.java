package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.PatrolTaskDO;
import com.taikang.dic.ltci.model.PatrolTaskDOExample;

@Mapper
public interface IPatrolTaskDAO extends IGenericDAO<PatrolTaskDO, String> {
  int countByExample(PatrolTaskDOExample example);

  int deleteByExample(PatrolTaskDOExample example);

  int deleteByPrimaryKey(String patrolTaskId);

  int insert(PatrolTaskDO record);

  int insertSelective(PatrolTaskDO record);

  List<PatrolTaskDO> selectByExample(PatrolTaskDOExample example);

  PatrolTaskDO selectByPrimaryKey(String patrolTaskId);

  int updateByExampleSelective(
      @Param("record") PatrolTaskDO record, @Param("example") PatrolTaskDOExample example);

  int updateByExample(
      @Param("record") PatrolTaskDO record, @Param("example") PatrolTaskDOExample example);

  int updateByPrimaryKeySelective(PatrolTaskDO record);

  int updateByPrimaryKey(PatrolTaskDO record);
}
