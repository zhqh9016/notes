package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.AgencyAuditHistoryDO;
import com.taikang.dic.ltci.model.AgencyAuditHistoryDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AgencyAuditHistoryDAO extends IGenericDAO<AgencyAuditHistoryDO, String> {
  int countByExample(AgencyAuditHistoryDOExample example);

  int deleteByExample(AgencyAuditHistoryDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(AgencyAuditHistoryDO record);

  int insertSelective(AgencyAuditHistoryDO record);

  List<AgencyAuditHistoryDO> selectByExample(AgencyAuditHistoryDOExample example);

  AgencyAuditHistoryDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") AgencyAuditHistoryDO record,
      @Param("example") AgencyAuditHistoryDOExample example);

  int updateByExample(
      @Param("record") AgencyAuditHistoryDO record,
      @Param("example") AgencyAuditHistoryDOExample example);

  int updateByPrimaryKeySelective(AgencyAuditHistoryDO record);

  int updateByPrimaryKey(AgencyAuditHistoryDO record);
}
