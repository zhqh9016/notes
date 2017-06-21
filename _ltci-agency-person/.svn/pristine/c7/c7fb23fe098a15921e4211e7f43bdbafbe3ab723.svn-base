package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.AgencyStaffFileRDO;
import com.taikang.dic.ltci.model.AgencyStaffFileRDOExample;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AgencyStaffFileRDAO extends IGenericDAO<AgencyStaffFileRDO, String> {
  int countByExample(AgencyStaffFileRDOExample example);

  int deleteByExample(AgencyStaffFileRDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(AgencyStaffFileRDO record);

  int insertSelective(AgencyStaffFileRDO record);

  List<AgencyStaffFileRDO> selectByExample(AgencyStaffFileRDOExample example);

  AgencyStaffFileRDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") AgencyStaffFileRDO record,
      @Param("example") AgencyStaffFileRDOExample example);

  int updateByExample(
      @Param("record") AgencyStaffFileRDO record,
      @Param("example") AgencyStaffFileRDOExample example);

  int updateByPrimaryKeySelective(AgencyStaffFileRDO record);

  int updateByPrimaryKey(AgencyStaffFileRDO record);
}
