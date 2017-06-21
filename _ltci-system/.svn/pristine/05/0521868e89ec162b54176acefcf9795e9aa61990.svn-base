package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.DictionaryDO;
import com.taikang.dic.ltci.model.DiseaseDO;
import com.taikang.dic.ltci.model.DiseaseDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DiseaseDAO extends IGenericDAO<DiseaseDO, String> {
  int countByExample(DiseaseDOExample example);

  int deleteByExample(DiseaseDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(DiseaseDO record);

  int insertSelective(DiseaseDO record);

  List<DiseaseDO> selectByExample(DiseaseDOExample example);

  DiseaseDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") DiseaseDO record, @Param("example") DiseaseDOExample example);

  int updateByExample(
      @Param("record") DiseaseDO record, @Param("example") DiseaseDOExample example);

  int updateByPrimaryKeySelective(DiseaseDO record);

  int updateByPrimaryKey(DiseaseDO record);
}
