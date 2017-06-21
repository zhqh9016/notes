package com.taikang.dic.ltci.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.taikang.dic.ltci.model.NursingTaskDO;
import com.taikang.dic.ltci.model.NursingTaskSpecialDO;

@Mapper
public interface NursingTaskSpecialDAO {
  List<NursingTaskSpecialDO> getNursingTaskList(Map<String, Object> mapForSelect);

  Integer countNursingTaskList(Map<String, Object> mapForSelect);

  int insertNursingTaskList(List<NursingTaskDO> list);
}
