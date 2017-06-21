package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.StaffAuditHistoryDO;
import com.taikang.dic.ltci.model.StaffAuditHistoryDOExample;

@Mapper
public interface StaffAuditHistoryDAO extends IGenericDAO<StaffAuditHistoryDO, String> {
  int countByExample(StaffAuditHistoryDOExample example);

  int deleteByExample(StaffAuditHistoryDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(StaffAuditHistoryDO record);

  int insertSelective(StaffAuditHistoryDO record);

  List<StaffAuditHistoryDO> selectByExample(StaffAuditHistoryDOExample example);

  StaffAuditHistoryDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") StaffAuditHistoryDO record,
      @Param("example") StaffAuditHistoryDOExample example);

  int updateByExample(
      @Param("record") StaffAuditHistoryDO record,
      @Param("example") StaffAuditHistoryDOExample example);

  int updateByPrimaryKeySelective(StaffAuditHistoryDO record);

  int updateByPrimaryKey(StaffAuditHistoryDO record);
}
