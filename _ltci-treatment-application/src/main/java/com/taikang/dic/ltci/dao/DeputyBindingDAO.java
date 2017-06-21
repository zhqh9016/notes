package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.DeputyBindingDO;
import com.taikang.dic.ltci.model.DeputyBindingDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DeputyBindingDAO extends IGenericDAO<DeputyBindingDO, String> {
  int countByExample(DeputyBindingDOExample example);

  int deleteByExample(DeputyBindingDOExample example);

  int deleteByPrimaryKey(String deputyBindingid);

  int insert(DeputyBindingDO record);

  int insertSelective(DeputyBindingDO record);

  List<DeputyBindingDO> selectByExample(DeputyBindingDOExample example);

  DeputyBindingDO selectByPrimaryKey(String deputyBindingid);

  int updateByExampleSelective(
      @Param("record") DeputyBindingDO record, @Param("example") DeputyBindingDOExample example);

  int updateByExample(
      @Param("record") DeputyBindingDO record, @Param("example") DeputyBindingDOExample example);

  int updateByPrimaryKeySelective(DeputyBindingDO record);

  int updateByPrimaryKey(DeputyBindingDO record);
}
