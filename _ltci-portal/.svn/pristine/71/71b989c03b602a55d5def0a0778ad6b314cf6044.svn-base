package com.taikang.dic.ltci.settlement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.portal.api.model.MonSetPerDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.util.UserUtils;
import com.taikang.dic.ltci.settlement.serverClient.MonSetPerServerClient;
import com.taikang.dic.ltci.settlement.service.MonSetPerService;

@Service
public class MonSetPerServiceImpl implements MonSetPerService {

  @Autowired private MonSetPerServerClient monSetPerServerClient;

  @Value(value = "${spring.application.name}")
  private String systemCode;

  /** 按条件分页查询个人月结算信息 */
  @Override
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
    return monSetPerServerClient.listMonSetPer(
        name,
        idCard,
        startDate,
        endDate,
        orgCode,
        unrFee,
        page,
        pageSize,
        operateOrgCode,
        systemCode);
  }

  /** 不合理费用录入 */
  @Override
  public ResultDTO enterUnrFee(MonSetPerDTO monSetPerDto) {
    // 判断录入的不合理费用是否大于统筹支出
    if (monSetPerDto.getSiPay() != null
        && monSetPerDto.getSiPay() != 0
        && monSetPerDto.getUnrFee().compareTo(monSetPerDto.getSiPay()) > 0) {
      ResultDTO resultDto = new ResultDTO();
      resultDto.setStatus(500);
      resultDto.setMessage("不合理费用不能大于统筹支出");
      return resultDto;
    }
    // 获取当前登录用户信息
    UserDTO userInfo = UserUtils.getCurrentUser();
    if (userInfo != null) {
      // 经办人
      monSetPerDto.setOperatedBy(userInfo.getTrueName());
    }
    return monSetPerServerClient.enterUnrFee(monSetPerDto, systemCode);
  }
}
