package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.RoleDO;
import com.taikang.dic.ltci.model.RoleDOExample;

@Mapper
public interface RoleDAO extends IGenericDAO<RoleDO, String> {
  int countByExample(RoleDOExample example);

  int deleteByExample(RoleDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(RoleDO record);

  int insertSelective(RoleDO record);

  List<RoleDO> selectByExample(RoleDOExample example);

  RoleDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") RoleDO record, @Param("example") RoleDOExample example);

  int updateByExample(@Param("record") RoleDO record, @Param("example") RoleDOExample example);

  int updateByPrimaryKeySelective(RoleDO record);

  int updateByPrimaryKey(RoleDO record);
}
