package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.AgencyHistoryDO;
import com.taikang.dic.ltci.model.AgencyHistoryDOExample;

@Mapper
public interface AgencyHistoryDAO extends IGenericDAO<AgencyHistoryDO, String> {
  int countByExample(AgencyHistoryDOExample example);

  int deleteByExample(AgencyHistoryDOExample example);

  int deleteByPrimaryKey(String serialNum);

  int insert(AgencyHistoryDO record);

  int insertSelective(AgencyHistoryDO record);

  List<AgencyHistoryDO> selectByExample(AgencyHistoryDOExample example);

  AgencyHistoryDO selectByPrimaryKey(String serialNum);

  int updateByExampleSelective(
      @Param("record") AgencyHistoryDO record, @Param("example") AgencyHistoryDOExample example);

  int updateByExample(
      @Param("record") AgencyHistoryDO record, @Param("example") AgencyHistoryDOExample example);

  int updateByPrimaryKeySelective(AgencyHistoryDO record);

  int updateByPrimaryKey(AgencyHistoryDO record);
}
