package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.PatrolTaskLogDO;
import com.taikang.dic.ltci.model.PatrolTaskLogDOExample;

@Mapper
public interface PatrolTaskLogDAO extends IGenericDAO<PatrolTaskLogDO, String> {
  int countByExample(PatrolTaskLogDOExample example);

  int deleteByExample(PatrolTaskLogDOExample example);

  int deleteByPrimaryKey(String patrolTaskId);

  int insert(PatrolTaskLogDO record);

  int insertSelective(PatrolTaskLogDO record);

  List<PatrolTaskLogDO> selectByExample(PatrolTaskLogDOExample example);

  PatrolTaskLogDO selectByPrimaryKey(String patrolTaskId);

  int updateByExampleSelective(
      @Param("record") PatrolTaskLogDO record, @Param("example") PatrolTaskLogDOExample example);

  int updateByExample(
      @Param("record") PatrolTaskLogDO record, @Param("example") PatrolTaskLogDOExample example);

  int updateByPrimaryKeySelective(PatrolTaskLogDO record);

  int updateByPrimaryKey(PatrolTaskLogDO record);
}
