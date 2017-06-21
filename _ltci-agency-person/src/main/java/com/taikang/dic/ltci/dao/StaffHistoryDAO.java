package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.StaffHistoryDO;
import com.taikang.dic.ltci.model.StaffHistoryDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StaffHistoryDAO {
  int countByExample(StaffHistoryDOExample example);

  int deleteByExample(StaffHistoryDOExample example);

  int deleteByPrimaryKey(String serialNo);

  int insert(StaffHistoryDO record);

  int insertSelective(StaffHistoryDO record);

  List<StaffHistoryDO> selectByExample(StaffHistoryDOExample example);

  StaffHistoryDO selectByPrimaryKey(String serialNo);

  int updateByExampleSelective(
      @Param("record") StaffHistoryDO record, @Param("example") StaffHistoryDOExample example);

  int updateByExample(
      @Param("record") StaffHistoryDO record, @Param("example") StaffHistoryDOExample example);

  int updateByPrimaryKeySelective(StaffHistoryDO record);

  int updateByPrimaryKey(StaffHistoryDO record);
}
