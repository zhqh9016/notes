package com.taikang.dic.ltci.service;

import com.taikang.dic.ltci.common.ws.InsuredInfo;
import com.taikang.dic.ltci.common.ws.TreatmentState;

/**
 * 调用社保局接口查询参保人信息
 *
 * @author itw_liuxy
 * @description
 * @createTime 2017年4月17日 下午6:11:17
 */
public interface WSService {

  /**
   * 参保人信息查询
   *
   * @param idCardNum 身份证号码
   * @param insuredPersonName 姓名
   * @param uniqueNumber 经办机构
   * @param operator 经办人
   * @return
   */
  InsuredInfo selectInsuredInfo(
      String idCardNum, String insuredPersonName, String uniqueNumber, String operator);

  /**
   * 长护待遇状态查询
   *
   * @param idCardNum 身份证号码
   * @param insuredPersonName 姓名
   * @param uniqueNumber 经办机构
   * @param operator 经办人
   * @return
   */
  public TreatmentState selectApplicationStatus(
      String idCardNum, String insuredPersonName, String uniqueNumber, String operator);
}
