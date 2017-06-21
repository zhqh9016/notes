package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.ExecuteResultDO;
import com.taikang.dic.ltci.model.ExecuteResultDOExample;

@Mapper
public interface IExecuteResultDAO extends IGenericDAO<ExecuteResultDO, String> {
  int countByExample(ExecuteResultDOExample example);

  int deleteByExample(ExecuteResultDOExample example);

  int deleteByPrimaryKey(String executeResultId);

  int insert(ExecuteResultDO record);

  int insertSelective(ExecuteResultDO record);

  List<ExecuteResultDO> selectByExample(ExecuteResultDOExample example);

  ExecuteResultDO selectByPrimaryKey(String executeResultId);

  int updateByExampleSelective(
      @Param("record") ExecuteResultDO record, @Param("example") ExecuteResultDOExample example);

  int updateByExample(
      @Param("record") ExecuteResultDO record, @Param("example") ExecuteResultDOExample example);

  int updateByPrimaryKeySelective(ExecuteResultDO record);

  int updateByPrimaryKey(ExecuteResultDO record);
}
