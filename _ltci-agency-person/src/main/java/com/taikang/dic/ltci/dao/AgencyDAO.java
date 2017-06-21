package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.AgencyDO;
import com.taikang.dic.ltci.model.AgencyDOExample;

@Mapper
public interface AgencyDAO extends IGenericDAO<AgencyDO, String> {
  int countByExample(AgencyDOExample example);

  int deleteByExample(AgencyDOExample example);

  int deleteByPrimaryKey(String agencyid);

  int insert(AgencyDO record);

  int insertSelective(AgencyDO record);

  List<AgencyDO> selectByExample(AgencyDOExample example);

  AgencyDO selectByPrimaryKey(String agencyid);

  int updateByExampleSelective(
      @Param("record") AgencyDO record, @Param("example") AgencyDOExample example);

  int updateByExample(@Param("record") AgencyDO record, @Param("example") AgencyDOExample example);

  int updateByPrimaryKeySelective(AgencyDO record);

  int updateByPrimaryKey(AgencyDO record);
}
