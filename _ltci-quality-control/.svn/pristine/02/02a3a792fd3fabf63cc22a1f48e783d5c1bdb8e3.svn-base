package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.RReconsiderFileDO;
import com.taikang.dic.ltci.model.RReconsiderFileDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IRReconsiderFileDAO extends IGenericDAO<RReconsiderFileDO, String> {
  int countByExample(RReconsiderFileDOExample example);

  int deleteByExample(RReconsiderFileDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(RReconsiderFileDO record);

  int insertSelective(RReconsiderFileDO record);

  List<RReconsiderFileDO> selectByExample(RReconsiderFileDOExample example);

  RReconsiderFileDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") RReconsiderFileDO record,
      @Param("example") RReconsiderFileDOExample example);

  int updateByExample(
      @Param("record") RReconsiderFileDO record,
      @Param("example") RReconsiderFileDOExample example);

  int updateByPrimaryKeySelective(RReconsiderFileDO record);

  int updateByPrimaryKey(RReconsiderFileDO record);
}
