package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.InsuredInfoDO;
import com.taikang.dic.ltci.model.InsuredInfoDOExample;
import com.taikang.dic.ltci.model.InsuredPersonDO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface InsuredInfoDAO extends IGenericDAO<InsuredInfoDO, String> {
  int countByExample(InsuredInfoDOExample example);

  int deleteByExample(InsuredInfoDOExample example);

  int deleteByPrimaryKey(Long insuredPersonid);

  int insert(InsuredInfoDO record);

  int insertSelective(InsuredInfoDO record);

  List<InsuredInfoDO> selectByExample(InsuredInfoDOExample example);

  InsuredInfoDO selectByPrimaryKey(Long insuredPersonid);

  int updateByExampleSelective(
      @Param("record") InsuredInfoDO record, @Param("example") InsuredInfoDOExample example);

  int updateByExample(
      @Param("record") InsuredInfoDO record, @Param("example") InsuredInfoDOExample example);

  int updateByPrimaryKeySelective(InsuredInfoDO record);

  int updateByPrimaryKey(InsuredInfoDO record);
}
