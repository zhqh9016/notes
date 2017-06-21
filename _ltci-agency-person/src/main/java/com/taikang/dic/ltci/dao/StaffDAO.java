package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.StaffDO;
import com.taikang.dic.ltci.model.StaffDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StaffDAO extends IGenericDAO<StaffDO, String> {
  int countByExample(StaffDOExample example);

  int deleteByExample(StaffDOExample example);

  int deleteByPrimaryKey(String staffid);

  int insert(StaffDO record);

  int insertSelective(StaffDO record);

  List<StaffDO> selectByExample(StaffDOExample example);

  StaffDO selectByPrimaryKey(String staffid);

  int updateByExampleSelective(
      @Param("record") StaffDO record, @Param("example") StaffDOExample example);

  int updateByExample(@Param("record") StaffDO record, @Param("example") StaffDOExample example);

  int updateByPrimaryKeySelective(StaffDO record);

  int updateByPrimaryKey(StaffDO record);
}
