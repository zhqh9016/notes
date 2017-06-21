package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.MqMessageLogDO;
import com.taikang.dic.ltci.model.MqMessageLogDOExample;

@Mapper
public interface MqMessageLogDAO extends IGenericDAO<MqMessageLogDO, String> {
  int countByExample(MqMessageLogDOExample example);

  int deleteByExample(MqMessageLogDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(MqMessageLogDO record);

  int insertSelective(MqMessageLogDO record);

  List<MqMessageLogDO> selectByExampleWithBLOBs(MqMessageLogDOExample example);

  List<MqMessageLogDO> selectByExample(MqMessageLogDOExample example);

  MqMessageLogDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") MqMessageLogDO record, @Param("example") MqMessageLogDOExample example);

  int updateByExampleWithBLOBs(
      @Param("record") MqMessageLogDO record, @Param("example") MqMessageLogDOExample example);

  int updateByExample(
      @Param("record") MqMessageLogDO record, @Param("example") MqMessageLogDOExample example);

  int updateByPrimaryKeySelective(MqMessageLogDO record);

  int updateByPrimaryKeyWithBLOBs(MqMessageLogDO record);

  int updateByPrimaryKey(MqMessageLogDO record);
}
