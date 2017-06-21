package com.taikang.dic.ltci.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.ApplicationComplexDO;
import com.taikang.dic.ltci.model.ApplicationDO;
import com.taikang.dic.ltci.model.ApplicationSimpleDO;
import com.taikang.dic.ltci.model.TreatmentApplicationDO;

@Mapper
public interface TreatmentApplicationDAO {
  TreatmentApplicationDO findByTreatmentApplicationCode(String applicationCode);

  /**
   * 分页查询待遇申请记录
   *
   * @param map
   * @return
   */
  List<TreatmentApplicationDO> findTreatmentApplicationList(Map<String, Object> map);

  int countTreatmentApplicationList(Map<String, Object> map);

  ApplicationDO getApplicationState(
      @Param("idCard") String idCard,
      @Param("securityNumber") String securityNumber,
      @Param("insuredPersonName") String insuredPersonName,
      @Param("deputyIdCard") String deputyIdCard);

  /**
   * 根据待遇申请编号修改待遇申请状态
   *
   * @param map 待遇申请状态、待遇申请编号
   * @return
   */
  int updateApplicationStatusByApplicationCode(Map<String, Object> map);

  List<ApplicationSimpleDO> getApplicationSimple(
      @Param(value = "applicationSimples") List<String> applicationSimples);

  List<ApplicationComplexDO> getApplicationComplex(
      @Param(value = "applicationCodes") String applicationCodes);
}
