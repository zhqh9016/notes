package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.ThirdInterfaceLogDO;
import com.taikang.dic.ltci.model.ThirdInterfaceLogDOExample;

@Mapper
public interface ThirdInterfaceLogDAO extends IGenericDAO<ThirdInterfaceLogDO, String> {
  int countByExample(ThirdInterfaceLogDOExample example);

  int deleteByExample(ThirdInterfaceLogDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(ThirdInterfaceLogDO record);

  int insertSelective(ThirdInterfaceLogDO record);

  List<ThirdInterfaceLogDO> selectByExample(ThirdInterfaceLogDOExample example);

  ThirdInterfaceLogDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") ThirdInterfaceLogDO record,
      @Param("example") ThirdInterfaceLogDOExample example);

  int updateByExample(
      @Param("record") ThirdInterfaceLogDO record,
      @Param("example") ThirdInterfaceLogDOExample example);

  int updateByPrimaryKeySelective(ThirdInterfaceLogDO record);

  int updateByPrimaryKey(ThirdInterfaceLogDO record);
}
