package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.FirstEvaluateDO;
import com.taikang.dic.ltci.model.FirstEvaluateDOExample;

@Mapper
public interface FirstEvaluateDAO extends IGenericDAO<FirstEvaluateDO, String> {
  int countByExample(FirstEvaluateDOExample example);

  int deleteByExample(FirstEvaluateDOExample example);

  int deleteByPrimaryKey(String firstEvaluateid);

  int insert(FirstEvaluateDO record);

  int insertSelective(FirstEvaluateDO record);

  List<FirstEvaluateDO> selectByExampleWithBLOBs(FirstEvaluateDOExample example);

  List<FirstEvaluateDO> selectByExample(FirstEvaluateDOExample example);

  FirstEvaluateDO selectByPrimaryKey(String firstEvaluateid);

  int updateByExampleSelective(
      @Param("record") FirstEvaluateDO record, @Param("example") FirstEvaluateDOExample example);

  int updateByExampleWithBLOBs(
      @Param("record") FirstEvaluateDO record, @Param("example") FirstEvaluateDOExample example);

  int updateByExample(
      @Param("record") FirstEvaluateDO record, @Param("example") FirstEvaluateDOExample example);

  int updateByPrimaryKeySelective(FirstEvaluateDO record);

  int updateByPrimaryKeyWithBLOBs(FirstEvaluateDO record);

  int updateByPrimaryKey(FirstEvaluateDO record);
}
