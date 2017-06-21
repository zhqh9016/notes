package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.CheckInDO;
import com.taikang.dic.ltci.model.CheckInDOExample;

@Mapper
public interface CheckInDAO extends IGenericDAO<CheckInDO, String> {
  int countByExample(CheckInDOExample example);

  int deleteByExample(CheckInDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(CheckInDO record);

  int insertSelective(CheckInDO record);

  List<CheckInDO> selectByExampleWithBLOBs(CheckInDOExample example);

  List<CheckInDO> selectByExample(CheckInDOExample example);

  CheckInDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") CheckInDO record, @Param("example") CheckInDOExample example);

  int updateByExampleWithBLOBs(
      @Param("record") CheckInDO record, @Param("example") CheckInDOExample example);

  int updateByExample(
      @Param("record") CheckInDO record, @Param("example") CheckInDOExample example);

  int updateByPrimaryKeySelective(CheckInDO record);

  int updateByPrimaryKeyWithBLOBs(CheckInDO record);

  int updateByPrimaryKey(CheckInDO record);
}
