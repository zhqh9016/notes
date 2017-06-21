package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.FeeAuditLogDO;
import com.taikang.dic.ltci.model.FeeAuditLogDOExample;

@Mapper
public interface FeeAuditLogDAO extends IGenericDAO<FeeAuditLogDO, String> {
  int countByExample(FeeAuditLogDOExample example);

  int deleteByExample(FeeAuditLogDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(FeeAuditLogDO record);

  int insertSelective(FeeAuditLogDO record);

  List<FeeAuditLogDO> selectByExampleWithBLOBs(FeeAuditLogDOExample example);

  List<FeeAuditLogDO> selectByExample(FeeAuditLogDOExample example);

  FeeAuditLogDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") FeeAuditLogDO record, @Param("example") FeeAuditLogDOExample example);

  int updateByExampleWithBLOBs(
      @Param("record") FeeAuditLogDO record, @Param("example") FeeAuditLogDOExample example);

  int updateByExample(
      @Param("record") FeeAuditLogDO record, @Param("example") FeeAuditLogDOExample example);

  int updateByPrimaryKeySelective(FeeAuditLogDO record);

  int updateByPrimaryKeyWithBLOBs(FeeAuditLogDO record);

  int updateByPrimaryKey(FeeAuditLogDO record);
}
