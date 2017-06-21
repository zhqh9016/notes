package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.EvaluateTaskLogDO;
import com.taikang.dic.ltci.model.EvaluateTaskLogDOExample;

@Mapper
public interface EvaluateTaskLogDAO extends IGenericDAO<EvaluateTaskLogDO, String> {
  int countByExample(EvaluateTaskLogDOExample example);

  int deleteByExample(EvaluateTaskLogDOExample example);

  int deleteByPrimaryKey(String evaluateTaskLogid);

  int insert(EvaluateTaskLogDO record);

  int insertSelective(EvaluateTaskLogDO record);

  List<EvaluateTaskLogDO> selectByExample(EvaluateTaskLogDOExample example);

  EvaluateTaskLogDO selectByPrimaryKey(String evaluateTaskLogid);

  int updateByExampleSelective(
      @Param("record") EvaluateTaskLogDO record,
      @Param("example") EvaluateTaskLogDOExample example);

  int updateByExample(
      @Param("record") EvaluateTaskLogDO record,
      @Param("example") EvaluateTaskLogDOExample example);

  int updateByPrimaryKeySelective(EvaluateTaskLogDO record);

  int updateByPrimaryKey(EvaluateTaskLogDO record);
}
