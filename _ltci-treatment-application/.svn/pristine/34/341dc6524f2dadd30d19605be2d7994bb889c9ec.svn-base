package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.MQMessageLogDO;
import com.taikang.dic.ltci.model.MQMessageLogDOExample;

@Mapper
public interface MQMessageLogDAO extends IGenericDAO<MQMessageLogDO, String> {
  int countByExample(MQMessageLogDOExample example);

  int deleteByExample(MQMessageLogDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(MQMessageLogDO record);

  int insertSelective(MQMessageLogDO record);

  List<MQMessageLogDO> selectByExampleWithBLOBs(MQMessageLogDOExample example);

  List<MQMessageLogDO> selectByExample(MQMessageLogDOExample example);

  MQMessageLogDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") MQMessageLogDO record, @Param("example") MQMessageLogDOExample example);

  int updateByExampleWithBLOBs(
      @Param("record") MQMessageLogDO record, @Param("example") MQMessageLogDOExample example);

  int updateByExample(
      @Param("record") MQMessageLogDO record, @Param("example") MQMessageLogDOExample example);

  int updateByPrimaryKeySelective(MQMessageLogDO record);

  int updateByPrimaryKeyWithBLOBs(MQMessageLogDO record);

  int updateByPrimaryKey(MQMessageLogDO record);
}
