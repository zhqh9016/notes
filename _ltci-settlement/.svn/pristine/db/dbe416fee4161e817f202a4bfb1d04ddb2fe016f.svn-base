package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.WhiteListDO;
import com.taikang.dic.ltci.model.WhiteListDOExample;

@Mapper
public interface WhiteListDAO extends IGenericDAO<WhiteListDO, String> {
  int countByExample(WhiteListDOExample example);

  int deleteByExample(WhiteListDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(WhiteListDO record);

  int insertSelective(WhiteListDO record);

  List<WhiteListDO> selectByExample(WhiteListDOExample example);

  WhiteListDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") WhiteListDO record, @Param("example") WhiteListDOExample example);

  int updateByExample(
      @Param("record") WhiteListDO record, @Param("example") WhiteListDOExample example);

  int updateByPrimaryKeySelective(WhiteListDO record);

  int updateByPrimaryKey(WhiteListDO record);
}
