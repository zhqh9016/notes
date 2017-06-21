package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.MonSetPerDO;
import com.taikang.dic.ltci.model.MonSetPerDOExample;

@Mapper
public interface MonSetPerDAO extends IGenericDAO<MonSetPerDO, String> {
  int countByExample(MonSetPerDOExample example);

  int deleteByExample(MonSetPerDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(MonSetPerDO record);

  int insertSelective(MonSetPerDO record);

  List<MonSetPerDO> selectByExample(MonSetPerDOExample example);

  MonSetPerDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") MonSetPerDO record, @Param("example") MonSetPerDOExample example);

  int updateByExample(
      @Param("record") MonSetPerDO record, @Param("example") MonSetPerDOExample example);

  int updateByPrimaryKeySelective(MonSetPerDO record);

  int updateByPrimaryKey(MonSetPerDO record);
}
