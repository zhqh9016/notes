package com.taikang.dic.ltci.dao;

import com.taikang.dic.ltci.model.DeputyBindingResultDO;
import com.taikang.dic.ltci.model.DeputyBindingSpecialDO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DeputyBindingSpecialDAO {
  List<DeputyBindingSpecialDO> queryDeputyBinding(
      @Param("insuredPersonName") String insuredPersonName,
      @Param("idCard") String idCard,
      @Param("securityNumber") String securityNumber,
      @Param("deputyName") String deputyName,
      @Param("deputyIdCard") String deputyIdCard,
      @Param("checkState") String checkState,
      @Param("operatedOrg") String operatedOrg,
      @Param("page") int page,
      @Param("pageSize") int pageSize);

  //代理人绑定状态查询接口
  DeputyBindingSpecialDO getDeputyBindingDOState(
      @Param("idCard") String idCard,
      @Param("securityNumber") String securityNumber,
      @Param("deputyIdCard") String deputyIdCard);
  //查询数量
  Integer countDeputyBinding(
      @Param("insuredPersonName") String insuredPersonName,
      @Param("idCard") String idCard,
      @Param("securityNumber") String securityNumber,
      @Param("deputyName") String deputyName,
      @Param("deputyIdCard") String deputyIdCard,
      @Param("checkState") String checkState,
      @Param("operatedOrg") String operatedOrg);

  //查询代办绑定信息
  DeputyBindingSpecialDO getDeputyBindSpecialDO(
      @Param("deputyBindingCode") String deputyBindingCode);

  List<DeputyBindingResultDO> getDeputyBindingListQuery(@Param("deputyIdCard") String deputyIdCard);
}
