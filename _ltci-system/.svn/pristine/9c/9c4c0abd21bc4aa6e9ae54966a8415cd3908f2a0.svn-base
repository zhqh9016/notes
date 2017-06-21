package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.AreaDO;
import com.taikang.dic.ltci.model.AreaDOExample;

@Mapper
public interface AreaDAO extends IGenericDAO<AreaDO, String> {
  int countByExample(AreaDOExample example);

  int deleteByExample(AreaDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(AreaDO record);

  int insertSelective(AreaDO record);

  List<AreaDO> selectByExample(AreaDOExample example);

  AreaDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") AreaDO record, @Param("example") AreaDOExample example);

  int updateByExample(@Param("record") AreaDO record, @Param("example") AreaDOExample example);

  int updateByPrimaryKeySelective(AreaDO record);

  int updateByPrimaryKey(AreaDO record);
}
