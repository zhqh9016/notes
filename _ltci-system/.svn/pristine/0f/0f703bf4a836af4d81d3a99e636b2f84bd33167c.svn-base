package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.UserDO;
import com.taikang.dic.ltci.model.UserDOExample;

@Mapper
public interface UserDAO extends IGenericDAO<UserDO, String> {
  int countByExample(UserDOExample example);

  int deleteByExample(UserDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(UserDO record);

  int insertSelective(UserDO record);

  List<UserDO> selectByExample(UserDOExample example);

  int updateByExampleSelective(
      @Param("record") UserDO record, @Param("example") UserDOExample example);

  int updateByExample(@Param("record") UserDO record, @Param("example") UserDOExample example);

  int updateByPrimaryKeySelective(UserDO record);

  int updateByPrimaryKey(UserDO record);
}
