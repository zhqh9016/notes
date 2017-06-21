package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.EvaluateTaskDO;
import com.taikang.dic.ltci.model.EvaluateTaskDOExample;
import com.taikang.dic.ltci.model.FirstEvaluateDO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EvaluateTaskDAO extends IGenericDAO<EvaluateTaskDO, String> {
  int countByExample(EvaluateTaskDOExample example);

  int deleteByExample(EvaluateTaskDOExample example);

  int deleteByPrimaryKey(String evaluateTaskid);

  int insert(EvaluateTaskDO record);

  int insertSelective(EvaluateTaskDO record);

  List<EvaluateTaskDO> selectByExample(EvaluateTaskDOExample example);

  EvaluateTaskDO selectByPrimaryKey(String evaluateTaskid);

  int updateByExampleSelective(
      @Param("record") EvaluateTaskDO record, @Param("example") EvaluateTaskDOExample example);

  int updateByExample(
      @Param("record") EvaluateTaskDO record, @Param("example") EvaluateTaskDOExample example);

  int updateByPrimaryKeySelective(EvaluateTaskDO record);

  int updateByPrimaryKey(EvaluateTaskDO record);
}
