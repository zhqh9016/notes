package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.RClientorgSiAreaDO;
import com.taikang.dic.ltci.model.RClientorgSiAreaDOExample;

@Mapper
public interface RClientorgSiAreaDAO extends IGenericDAO<RClientorgSiAreaDO, String> {
  int countByExample(RClientorgSiAreaDOExample example);

  int deleteByExample(RClientorgSiAreaDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(RClientorgSiAreaDO record);

  int insertSelective(RClientorgSiAreaDO record);

  List<RClientorgSiAreaDO> selectByExample(RClientorgSiAreaDOExample example);

  RClientorgSiAreaDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") RClientorgSiAreaDO record,
      @Param("example") RClientorgSiAreaDOExample example);

  int updateByExample(
      @Param("record") RClientorgSiAreaDO record,
      @Param("example") RClientorgSiAreaDOExample example);

  int updateByPrimaryKeySelective(RClientorgSiAreaDO record);

  int updateByPrimaryKey(RClientorgSiAreaDO record);
}
