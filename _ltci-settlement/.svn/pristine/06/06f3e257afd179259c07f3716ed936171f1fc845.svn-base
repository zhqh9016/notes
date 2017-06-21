package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.SetAreaConfigBO;
import com.taikang.dic.ltci.model.SetAreaConfigBOExample;

@Mapper
public interface ISetAreaConfigDAO extends IGenericDAO<SetAreaConfigBO, String> {
  int countByExample(SetAreaConfigBOExample example);

  int deleteByExample(SetAreaConfigBOExample example);

  int deleteByPrimaryKey(String id);

  int insert(SetAreaConfigBO record);

  int insertSelective(SetAreaConfigBO record);

  List<SetAreaConfigBO> selectByExample(SetAreaConfigBOExample example);

  SetAreaConfigBO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") SetAreaConfigBO record, @Param("example") SetAreaConfigBOExample example);

  int updateByExample(
      @Param("record") SetAreaConfigBO record, @Param("example") SetAreaConfigBOExample example);

  int updateByPrimaryKeySelective(SetAreaConfigBO record);

  int updateByPrimaryKey(SetAreaConfigBO record);
}
