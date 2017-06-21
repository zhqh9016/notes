package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.ApplicationLogDO;
import com.taikang.dic.ltci.model.ApplicationLogDOExample;

@Mapper
public interface ApplicationLogDAO extends IGenericDAO<ApplicationLogDO, String> {
  int countByExample(ApplicationLogDOExample example);

  int deleteByExample(ApplicationLogDOExample example);

  int deleteByPrimaryKey(String applicationLogid);

  int insert(ApplicationLogDO record);

  int insertSelective(ApplicationLogDO record);

  List<ApplicationLogDO> selectByExample(ApplicationLogDOExample example);

  ApplicationLogDO selectByPrimaryKey(String applicationLogid);

  int updateByExampleSelective(
      @Param("record") ApplicationLogDO record, @Param("example") ApplicationLogDOExample example);

  int updateByExample(
      @Param("record") ApplicationLogDO record, @Param("example") ApplicationLogDOExample example);

  int updateByPrimaryKeySelective(ApplicationLogDO record);

  int updateByPrimaryKey(ApplicationLogDO record);
}
