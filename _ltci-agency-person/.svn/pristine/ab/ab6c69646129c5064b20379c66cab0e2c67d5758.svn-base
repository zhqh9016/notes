package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.StaffRankDO;
import com.taikang.dic.ltci.model.StaffRankDOExample;

@Mapper
public interface StaffRankDAO extends IGenericDAO<StaffRankDO, String> {
  int countByExample(StaffRankDOExample example);

  int deleteByExample(StaffRankDOExample example);

  int deleteByPrimaryKey(String rankid);

  int insert(StaffRankDO record);

  int insertSelective(StaffRankDO record);

  List<StaffRankDO> selectByExample(StaffRankDOExample example);

  StaffRankDO selectByPrimaryKey(String rankid);

  int updateByExampleSelective(
      @Param("record") StaffRankDO record, @Param("example") StaffRankDOExample example);

  int updateByExample(
      @Param("record") StaffRankDO record, @Param("example") StaffRankDOExample example);

  int updateByPrimaryKeySelective(StaffRankDO record);

  int updateByPrimaryKey(StaffRankDO record);
}
