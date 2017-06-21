package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.DictionaryDO;
import com.taikang.dic.ltci.model.DictionaryDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DictionaryDAO extends IGenericDAO<DictionaryDO, String> {
  int countByExample(DictionaryDOExample example);

  int deleteByExample(DictionaryDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(DictionaryDO record);

  int insertSelective(DictionaryDO record);

  List<DictionaryDO> selectByExample(DictionaryDOExample example);

  DictionaryDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") DictionaryDO record, @Param("example") DictionaryDOExample example);

  int updateByExample(
      @Param("record") DictionaryDO record, @Param("example") DictionaryDOExample example);

  int updateByPrimaryKeySelective(DictionaryDO record);

  int updateByPrimaryKey(DictionaryDO record);
}
