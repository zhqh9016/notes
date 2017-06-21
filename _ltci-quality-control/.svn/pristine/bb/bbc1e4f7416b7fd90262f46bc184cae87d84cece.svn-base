package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.ComplaintResourceDO;
import com.taikang.dic.ltci.model.ComplaintResourceDOExample;

@Mapper
public interface ComplaintResourceDAO extends IGenericDAO<ComplaintResourceDO, String> {
  int countByExample(ComplaintResourceDOExample example);

  int deleteByExample(ComplaintResourceDOExample example);

  int insert(ComplaintResourceDO record);

  int insertSelective(ComplaintResourceDO record);

  List<ComplaintResourceDO> selectByExample(ComplaintResourceDOExample example);

  int updateByExampleSelective(
      @Param("record") ComplaintResourceDO record,
      @Param("example") ComplaintResourceDOExample example);

  int updateByExample(
      @Param("record") ComplaintResourceDO record,
      @Param("example") ComplaintResourceDOExample example);
}
