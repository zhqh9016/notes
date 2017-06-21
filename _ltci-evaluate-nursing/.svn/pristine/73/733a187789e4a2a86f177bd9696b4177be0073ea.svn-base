package com.taikang.dic.ltci.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.NursingTaskDO;
import com.taikang.dic.ltci.model.NursingTaskDOExample;

@Mapper
public interface NursingTaskDAO extends IGenericDAO<NursingTaskDO, String> {
  int countByExample(NursingTaskDOExample example);

  int deleteByExample(NursingTaskDOExample example);

  int deleteByPrimaryKey(String nursingTaskid);

  int insert(NursingTaskDO record);

  int insertSelective(NursingTaskDO record);

  List<NursingTaskDO> selectByExample(NursingTaskDOExample example);

  NursingTaskDO selectByPrimaryKey(String nursingTaskid);

  int updateByExampleSelective(
      @Param("record") NursingTaskDO record, @Param("example") NursingTaskDOExample example);

  int updateByExample(
      @Param("record") NursingTaskDO record, @Param("example") NursingTaskDOExample example);

  int updateByPrimaryKeySelective(NursingTaskDO record);

  int updateByPrimaryKey(NursingTaskDO record);
}
