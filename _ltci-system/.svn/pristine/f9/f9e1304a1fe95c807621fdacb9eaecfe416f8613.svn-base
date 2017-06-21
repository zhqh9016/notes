package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.RRoleResDO;
import com.taikang.dic.ltci.model.RRoleResDOExample;

@Mapper
public interface RRoleResDAO extends IGenericDAO<RRoleResDO, String> {
  int countByExample(RRoleResDOExample example);

  int deleteByExample(RRoleResDOExample example);

  int insert(RRoleResDO record);

  int insertSelective(RRoleResDO record);

  List<RRoleResDO> selectByExample(RRoleResDOExample example);

  int updateByExampleSelective(
      @Param("record") RRoleResDO record, @Param("example") RRoleResDOExample example);

  int updateByExample(
      @Param("record") RRoleResDO record, @Param("example") RRoleResDOExample example);
}
