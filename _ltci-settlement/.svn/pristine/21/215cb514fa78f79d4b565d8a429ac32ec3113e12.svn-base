package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.NurseDetailLogDO;
import com.taikang.dic.ltci.model.NurseDetailLogDOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface INurseDetailLogDAO extends IGenericDAO<NurseDetailLogDO, String> {

  int countByExample(NurseDetailLogDOExample example);

  int deleteByExample(NurseDetailLogDOExample example);

  List<NurseDetailLogDO> selectByExample(NurseDetailLogDOExample example);

  int updateByExampleSelective(
      @Param("record") NurseDetailLogDO record, @Param("example") NurseDetailLogDOExample example);

  int updateByExample(
      @Param("record") NurseDetailLogDO record, @Param("example") NurseDetailLogDOExample example);
}
