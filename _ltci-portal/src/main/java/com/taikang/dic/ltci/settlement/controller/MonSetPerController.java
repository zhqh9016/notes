package com.taikang.dic.ltci.settlement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.portal.api.model.MonSetPerDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.settlement.service.MonSetPerService;

@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class MonSetPerController {

  @Autowired private MonSetPerService monSetPerService;

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
   * @return 个人月结算信息列表
   */
  @RequestMapping(path = "/monSetPer/list", method = RequestMethod.POST)
  @ResponseBody
  public PageResultDTO listMonSetPer(
      String name,
      String idCard,
      String startDate,
      String endDate,
      String orgCode,
      Double unrFee,
      Integer page,
      Integer pageSize,
      String operateOrgCode) {
    return monSetPerService.listMonSetPer(
        name, idCard, startDate, endDate, orgCode, unrFee, page, pageSize, operateOrgCode);
  }

  /**
   * 不合理费用录入
   *
   * @param daySetPerDto
   * @return
   */
  @RequestMapping(path = "/monSetPer", method = RequestMethod.PUT)
  @ResponseBody
  public ResultDTO enterUniFee(MonSetPerDTO monSetPerDto) {
    return monSetPerService.enterUnrFee(monSetPerDto);
  }
}
