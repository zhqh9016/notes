package com.taikang.dic.ltci.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.taikang.dic.ltci.model.CheckInDO;
import com.taikang.dic.ltci.model.CheckInSpecialDO;

@Mapper
public interface CheckInSpecialDAO {

  List<CheckInSpecialDO> getCheckIn(Map<String, Object> map);

  Integer countCheckIn(Map<String, Object> map);
}
