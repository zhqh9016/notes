package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.ExpertEvaluateDO;
import com.taikang.dic.ltci.model.ExpertEvaluateDOExample;

@Mapper
public interface ExpertEvaluateDAO extends IGenericDAO<ExpertEvaluateDO, String> {
  int countByExample(ExpertEvaluateDOExample example);

  int deleteByExample(ExpertEvaluateDOExample example);

  int deleteByPrimaryKey(String expertEvaluateid);

  int insert(ExpertEvaluateDO record);

  int insertSelective(ExpertEvaluateDO record);

  List<ExpertEvaluateDO> selectByExampleWithBLOBs(ExpertEvaluateDOExample example);

  List<ExpertEvaluateDO> selectByExample(ExpertEvaluateDOExample example);

  ExpertEvaluateDO selectByPrimaryKey(String expertEvaluateid);

  int updateByExampleSelective(
      @Param("record") ExpertEvaluateDO record, @Param("example") ExpertEvaluateDOExample example);

  int updateByExampleWithBLOBs(
      @Param("record") ExpertEvaluateDO record, @Param("example") ExpertEvaluateDOExample example);

  int updateByExample(
      @Param("record") ExpertEvaluateDO record, @Param("example") ExpertEvaluateDOExample example);

  int updateByPrimaryKeySelective(ExpertEvaluateDO record);

  int updateByPrimaryKeyWithBLOBs(ExpertEvaluateDO record);

  int updateByPrimaryKey(ExpertEvaluateDO record);
}
