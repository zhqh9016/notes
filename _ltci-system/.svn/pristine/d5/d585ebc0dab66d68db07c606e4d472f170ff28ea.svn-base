package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.taikang.dic.ltci.model.CustomResDO;
import com.taikang.dic.ltci.model.ResDO;

@Mapper
public interface CustomResDAO extends IGenericDAO<ResDO, String> {
  List<CustomResDO> selectResValid();

  List<CustomResDO> selectResByUserId(String userId);
}
