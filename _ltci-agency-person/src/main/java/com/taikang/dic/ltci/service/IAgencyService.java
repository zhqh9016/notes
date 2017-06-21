package com.taikang.dic.ltci.service;

import java.util.List;

import com.taikang.dic.ltci.model.AgencyDO;

public interface IAgencyService {

  /**
   * 查询是否存在有效机构信息
   *
   * @param agencyCode
   * @return
   */
  List<AgencyDO> getAgencyByOrgCode(String orgCode);

  /**
   * 根据经办系统生成的机构编号查询是否存在机构信息
   *
   * @param agencyCode
   * @return
   */
  List<AgencyDO> getAgencyByAgencyCode(String agencyCode, String orgCode);
}
