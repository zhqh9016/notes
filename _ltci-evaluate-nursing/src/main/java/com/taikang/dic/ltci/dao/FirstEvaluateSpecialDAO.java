package com.taikang.dic.ltci.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.FirstEvaluateSpecialDO;

@Mapper
public interface FirstEvaluateSpecialDAO extends IGenericDAO<FirstEvaluateSpecialDO, String> {
  List<FirstEvaluateSpecialDO> getFirstEvaluate(Map<String, Object> map);

  Integer countFirstEvaluate(Map<String, Object> map);

  FirstEvaluateSpecialDO getFirstDetail(@Param("firstEvaluateCode") String firstEvaluateCode);
}
