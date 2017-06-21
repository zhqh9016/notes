package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.ApplicationDO;
import com.taikang.dic.ltci.model.ApplicationDOExample;
import com.taikang.dic.ltci.model.DeputyBindingDO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ApplicationDAO extends IGenericDAO<ApplicationDO, String> {
  int countByExample(ApplicationDOExample example);

  int deleteByExample(ApplicationDOExample example);

  int deleteByPrimaryKey(String applicationid);

  int insert(ApplicationDO record);

  int insertSelective(ApplicationDO record);

  List<ApplicationDO> selectByExample(ApplicationDOExample example);

  ApplicationDO selectByPrimaryKey(String applicationid);

  int updateByExampleSelective(
      @Param("record") ApplicationDO record, @Param("example") ApplicationDOExample example);

  int updateByExample(
      @Param("record") ApplicationDO record, @Param("example") ApplicationDOExample example);

  int updateByPrimaryKeySelective(ApplicationDO record);

  int updateByPrimaryKey(ApplicationDO record);
}
