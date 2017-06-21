package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.SetConfigBO;
import com.taikang.dic.ltci.model.SetConfigBOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ISetConfigDAO extends IGenericDAO<SetConfigBO, String> {
  int countByExample(SetConfigBOExample example);

  int deleteByExample(SetConfigBOExample example);

  int deleteByPrimaryKey(String id);

  int insert(SetConfigBO record);

  int insertSelective(SetConfigBO record);

  List<SetConfigBO> selectByExample(SetConfigBOExample example);

  SetConfigBO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") SetConfigBO record, @Param("example") SetConfigBOExample example);

  int updateByExample(
      @Param("record") SetConfigBO record, @Param("example") SetConfigBOExample example);

  int updateByPrimaryKeySelective(SetConfigBO record);

  int updateByPrimaryKey(SetConfigBO record);
}
