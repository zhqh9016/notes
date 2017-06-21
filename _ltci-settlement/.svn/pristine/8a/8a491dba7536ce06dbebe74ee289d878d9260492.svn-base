package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.ServiceItemDO;
import com.taikang.dic.ltci.model.ServiceItemDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ServiceItemDAO extends IGenericDAO<ServiceItemDO, String> {
  int countByExample(ServiceItemDOExample example);

  int deleteByExample(ServiceItemDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(ServiceItemDO record);

  int insertSelective(ServiceItemDO record);

  List<ServiceItemDO> selectByExample(ServiceItemDOExample example);

  ServiceItemDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") ServiceItemDO record, @Param("example") ServiceItemDOExample example);

  int updateByExample(
      @Param("record") ServiceItemDO record, @Param("example") ServiceItemDOExample example);

  int updateByPrimaryKeySelective(ServiceItemDO record);

  int updateByPrimaryKey(ServiceItemDO record);
}
