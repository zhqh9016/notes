package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.RUserRoleDO;
import com.taikang.dic.ltci.model.RUserRoleDOExample;

@Mapper
public interface RUserRoleDAO extends IGenericDAO<RUserRoleDO, String> {
  int countByExample(RUserRoleDOExample example);

  int deleteByExample(RUserRoleDOExample example);

  int insert(RUserRoleDO record);

  int insertSelective(RUserRoleDO record);

  List<RUserRoleDO> selectByExample(RUserRoleDOExample example);

  int updateByExampleSelective(
      @Param("record") RUserRoleDO record, @Param("example") RUserRoleDOExample example);

  int updateByExample(
      @Param("record") RUserRoleDO record, @Param("example") RUserRoleDOExample example);
}
