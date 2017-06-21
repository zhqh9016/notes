package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.SetCheckConfigBO;
import com.taikang.dic.ltci.model.SetCheckConfigBOExample;

@Mapper
public interface ISetCheckConfigDAO extends IGenericDAO<SetCheckConfigBO, String> {
  int countByExample(SetCheckConfigBOExample example);

  int deleteByExample(SetCheckConfigBOExample example);

  int deleteByPrimaryKey(String id);

  int insert(SetCheckConfigBO record);

  int insertSelective(SetCheckConfigBO record);

  List<SetCheckConfigBO> selectByExample(SetCheckConfigBOExample example);

  SetCheckConfigBO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") SetCheckConfigBO record, @Param("example") SetCheckConfigBOExample example);

  int updateByExample(
      @Param("record") SetCheckConfigBO record, @Param("example") SetCheckConfigBOExample example);

  int updateByPrimaryKeySelective(SetCheckConfigBO record);

  int updateByPrimaryKey(SetCheckConfigBO record);
}
