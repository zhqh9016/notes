package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.NurseDetailDO;
import com.taikang.dic.ltci.model.NurseDetailDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface INurseDetailDAO extends IGenericDAO<NurseDetailDO, String> {
  int countByExample(NurseDetailDOExample example);

  int deleteByExample(NurseDetailDOExample example);

  int deleteByPrimaryKey(String id);

  int insert(NurseDetailDO record);

  int insertSelective(NurseDetailDO record);

  List<NurseDetailDO> selectByExample(NurseDetailDOExample example);

  NurseDetailDO selectByPrimaryKey(String id);

  int updateByExampleSelective(
      @Param("record") NurseDetailDO record, @Param("example") NurseDetailDOExample example);

  int updateByExample(
      @Param("record") NurseDetailDO record, @Param("example") NurseDetailDOExample example);

  int updateByPrimaryKeySelective(NurseDetailDO record);

  int updateByPrimaryKey(NurseDetailDO record);
}
