package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.StaffHistoryDO;
import com.taikang.dic.ltci.model.StaffHistoryUnionExample;

@Mapper
public interface AgencyStaffUnionSpecDAO {
  int countByExample(@Param("example") StaffHistoryUnionExample example);

  List<StaffHistoryDO> selectByExample(@Param("example") StaffHistoryUnionExample example);
}
