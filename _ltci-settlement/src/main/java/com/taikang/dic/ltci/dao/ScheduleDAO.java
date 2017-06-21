package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.ScheduleDO;
import com.taikang.dic.ltci.model.ScheduleDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ScheduleDAO {
  int countByExample(ScheduleDOExample example);

  int deleteByExample(ScheduleDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(ScheduleDO record);

  int insertSelective(ScheduleDO record);

  List<ScheduleDO> selectByExample(ScheduleDOExample example);

  ScheduleDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") ScheduleDO record, @Param("example") ScheduleDOExample example);

  int updateByExample(
      @Param("record") ScheduleDO record, @Param("example") ScheduleDOExample example);

  int updateByPrimaryKeySelective(ScheduleDO record);

  int updateByPrimaryKey(ScheduleDO record);
}
