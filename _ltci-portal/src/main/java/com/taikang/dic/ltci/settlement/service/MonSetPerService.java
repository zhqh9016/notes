package com.taikang.dic.ltci.settlement.service;

import com.taikang.dic.ltci.portal.api.model.MonSetPerDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

public interface MonSetPerService {

  /**
   * 按条件分页查询个人月结算信息
   *
   * @param name 姓名
   * @param idCard 身份证号码
   * @param startDate 费用开始日期
   * @param endDate 费用终止日期
   * @param orgId 机构编号
   * @param unrFee 不合理费用
   * @param page 当前页
   * @param pageSize 每页显示件数
   * @return 个人日结算信息列表
   */
  PageResultDTO listMonSetPer(
      String name,
      String idCard,
      String startDate,
      String endDate,
      String orgCode,
      Double unrFee,
      Integer page,
      Integer pageSize,
      String operateOrgCode);

  /**
   * 不合理费用录入
   *
   * @param daySetPerDo
   * @return
   */
  ResultDTO enterUnrFee(MonSetPerDTO monSetPerDto);
}
