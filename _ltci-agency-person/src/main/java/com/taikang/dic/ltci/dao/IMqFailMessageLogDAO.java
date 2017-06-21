package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.MqFailMessageLogDO;
import com.taikang.dic.ltci.model.MqFailMessageLogDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IMqFailMessageLogDAO {
  int countByExample(MqFailMessageLogDOExample example);

  int deleteByExample(MqFailMessageLogDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(MqFailMessageLogDO record);

  int insertSelective(MqFailMessageLogDO record);

  List<MqFailMessageLogDO> selectByExampleWithBLOBs(MqFailMessageLogDOExample example);

  List<MqFailMessageLogDO> selectByExample(MqFailMessageLogDOExample example);

  MqFailMessageLogDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") MqFailMessageLogDO record,
      @Param("example") MqFailMessageLogDOExample example);

  int updateByExampleWithBLOBs(
      @Param("record") MqFailMessageLogDO record,
      @Param("example") MqFailMessageLogDOExample example);

  int updateByExample(
      @Param("record") MqFailMessageLogDO record,
      @Param("example") MqFailMessageLogDOExample example);

  int updateByPrimaryKeySelective(MqFailMessageLogDO record);

  int updateByPrimaryKeyWithBLOBs(MqFailMessageLogDO record);

  int updateByPrimaryKey(MqFailMessageLogDO record);
}
