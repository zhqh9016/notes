package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.RExecuteFileDO;
import com.taikang.dic.ltci.model.RExecuteFileDOExample;

@Mapper
public interface IRExecuteFileDAO extends IGenericDAO<RExecuteFileDO, String> {
  int countByExample(RExecuteFileDOExample example);

  int deleteByExample(RExecuteFileDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(RExecuteFileDO record);

  int insertSelective(RExecuteFileDO record);

  List<RExecuteFileDO> selectByExample(RExecuteFileDOExample example);

  RExecuteFileDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") RExecuteFileDO record, @Param("example") RExecuteFileDOExample example);

  int updateByExample(
      @Param("record") RExecuteFileDO record, @Param("example") RExecuteFileDOExample example);

  int updateByPrimaryKeySelective(RExecuteFileDO record);

  int updateByPrimaryKey(RExecuteFileDO record);
}
