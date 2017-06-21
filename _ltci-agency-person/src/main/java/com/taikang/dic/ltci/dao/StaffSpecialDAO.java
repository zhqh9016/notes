package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.StaffSpecialDO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StaffSpecialDAO {
  List<StaffSpecialDO> getStaffs(@Param("name") String name);

  StaffSpecialDO getAgencyByStaff(@Param("code") String code);

  StaffSpecialDO getStaffByCredentialNumber(@Param("credentialNumber") String credentialNumber);
}
