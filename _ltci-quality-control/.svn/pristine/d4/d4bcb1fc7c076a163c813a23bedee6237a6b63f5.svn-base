package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.PatrolTaskDetailDO;
import com.taikang.dic.ltci.model.PatrolTaskDetailDOExample;

@Mapper
public interface IPatrolTaskDetailDAO extends IGenericDAO<PatrolTaskDetailDO, String> {
  int countByExample(PatrolTaskDetailDOExample example);

  int deleteByExample(PatrolTaskDetailDOExample example);

  int deleteByPrimaryKey(String taskDetailId);

  int insert(PatrolTaskDetailDO record);

  int insertSelective(PatrolTaskDetailDO record);

  List<PatrolTaskDetailDO> selectByExample(PatrolTaskDetailDOExample example);

  PatrolTaskDetailDO selectByPrimaryKey(String taskDetailId);

  int updateByExampleSelective(
      @Param("record") PatrolTaskDetailDO record,
      @Param("example") PatrolTaskDetailDOExample example);

  int updateByExample(
      @Param("record") PatrolTaskDetailDO record,
      @Param("example") PatrolTaskDetailDOExample example);

  int updateByPrimaryKeySelective(PatrolTaskDetailDO record);

  int updateByPrimaryKey(PatrolTaskDetailDO record);
}
