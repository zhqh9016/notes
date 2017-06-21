package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.DaySetPerDO;
import com.taikang.dic.ltci.model.DaySetPerDOExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DaySetPerDAO extends IGenericDAO<DaySetPerDO, String> {
  int countByExample(DaySetPerDOExample example);

  int deleteByExample(DaySetPerDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(DaySetPerDO record);

  int insertSelective(DaySetPerDO record);

  List<DaySetPerDO> selectByExample(DaySetPerDOExample example);

  DaySetPerDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") DaySetPerDO record, @Param("example") DaySetPerDOExample example);

  int updateByExample(
      @Param("record") DaySetPerDO record, @Param("example") DaySetPerDOExample example);

  int updateByPrimaryKeySelective(DaySetPerDO record);

  int updateByPrimaryKey(DaySetPerDO record);
}
