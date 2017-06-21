package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.InsuredPersonDO;
import com.taikang.dic.ltci.model.InsuredPersonDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InsuredPersonDAO extends IGenericDAO<InsuredPersonDO, String> {
  int countByExample(InsuredPersonDOExample example);

  int deleteByExample(InsuredPersonDOExample example);

  int deleteByPrimaryKey(String insuredPersonid);

  int insert(InsuredPersonDO record);

  int insertSelective(InsuredPersonDO record);

  List<InsuredPersonDO> selectByExample(InsuredPersonDOExample example);

  InsuredPersonDO selectByPrimaryKey(String insuredPersonid);

  int updateByExampleSelective(
      @Param("record") InsuredPersonDO record, @Param("example") InsuredPersonDOExample example);

  int updateByExample(
      @Param("record") InsuredPersonDO record, @Param("example") InsuredPersonDOExample example);

  int updateByPrimaryKeySelective(InsuredPersonDO record);

  int updateByPrimaryKey(InsuredPersonDO record);
}
