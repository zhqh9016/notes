package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.ReconsiderDO;
import com.taikang.dic.ltci.model.ReconsiderDOExample;

@Mapper
public interface IReconsiderDAO extends IGenericDAO<ReconsiderDO, String> {
  int countByExample(ReconsiderDOExample example);

  int deleteByExample(ReconsiderDOExample example);

  int deleteByPrimaryKey(String reconsiderid);

  int insert(ReconsiderDO record);

  int insertSelective(ReconsiderDO record);

  List<ReconsiderDO> selectByExample(ReconsiderDOExample example);

  ReconsiderDO selectByPrimaryKey(String reconsiderid);

  int updateByExampleSelective(
      @Param("record") ReconsiderDO record, @Param("example") ReconsiderDOExample example);

  int updateByExample(
      @Param("record") ReconsiderDO record, @Param("example") ReconsiderDOExample example);

  int updateByPrimaryKeySelective(ReconsiderDO record);

  int updateByPrimaryKey(ReconsiderDO record);
}
