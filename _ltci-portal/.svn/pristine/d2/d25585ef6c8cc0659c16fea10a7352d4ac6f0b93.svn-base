package com.taikang.dic.ltci.settlement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.settlement.serverClient.PersonalNurseDetailServerClient;
import com.taikang.dic.ltci.settlement.service.PersonalNurseDetailService;

@Service
public class PersonalNurseDetailServiceImpl implements PersonalNurseDetailService {
  @Autowired private PersonalNurseDetailServerClient personalNurseDetailServerClient;

  /**
   * 按条件分页查询个人费用护理明细列表
   *
   * @param personalNurseDetailDTO 查询条件
   * @param page 当前页码
   * @param pageSize 每页显示件数
   * @return 个人费用护理明细信息列表
   */
  @Override
  public PageResultDTO listPersonNurseDetail(
      String orgCode,
      String inRecorduuid,
      String beCarePersonCard,
      String feeBeginDate,
      String feeEndDate,
      int page,
      int pageSize) {
    return personalNurseDetailServerClient.listPersonNurseDetail(
        orgCode, inRecorduuid, beCarePersonCard, feeBeginDate, feeEndDate, page, pageSize);
  }
}
