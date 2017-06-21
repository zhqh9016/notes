package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.OrganizationDO;
import com.taikang.dic.ltci.model.OrganizationDOExample;

@Mapper
public interface IOrganizationDAO extends IGenericDAO<OrganizationDO, String> {
  int countByExample(OrganizationDOExample example);

  int deleteByExample(OrganizationDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(OrganizationDO record);

  int insertSelective(OrganizationDO record);

  List<OrganizationDO> selectByExample(OrganizationDOExample example);

  OrganizationDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") OrganizationDO record, @Param("example") OrganizationDOExample example);

  int updateByExample(
      @Param("record") OrganizationDO record, @Param("example") OrganizationDOExample example);

  int updateByPrimaryKeySelective(OrganizationDO record);

  int updateByPrimaryKey(OrganizationDO record);
}
