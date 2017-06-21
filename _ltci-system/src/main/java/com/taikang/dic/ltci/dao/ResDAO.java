package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.ResDO;
import com.taikang.dic.ltci.model.ResDOExample;

@Mapper
public interface ResDAO extends IGenericDAO<ResDO, String> {
  int countByExample(ResDOExample example);

  int deleteByExample(ResDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(ResDO record);

  int insertSelective(ResDO record);

  List<ResDO> selectByExample(ResDOExample example);

  ResDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") ResDO record, @Param("example") ResDOExample example);

  int updateByExample(@Param("record") ResDO record, @Param("example") ResDOExample example);

  int updateByPrimaryKeySelective(ResDO record);

  int updateByPrimaryKey(ResDO record);
}
