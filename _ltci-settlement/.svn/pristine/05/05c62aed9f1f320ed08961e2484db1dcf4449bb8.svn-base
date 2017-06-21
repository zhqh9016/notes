package com.taikang.dic.ltci.service;

import com.taikang.dic.ltci.common.ws.InsuredInfo;
import com.taikang.dic.ltci.common.ws.TreatmentState;
import com.taikang.dic.ltci.model.NurseDetailDO;
import com.taikang.dic.ltci.model.ServiceItemDO;

/**
 * 第三方（社保）服务接口
 *
 * @author huodd
 * @date 创建时间：2017年4月14日
 */
public interface WSService {

  /**
   * 参保人信息查询
   *
   * @param idCardNum 身份证号码
   * @param insuredPersonName 姓名
   * @return
   */
  public InsuredInfo selectInsuredInfo(String idCardNum, String insuredPersonName);

  /**
   * 长护待遇状态查询
   *
   * @param idCardNum 身份证号码
   * @param insuredPersonName 姓名
   * @return
   */
  public TreatmentState selectApplicationStatus(String idCardNum, String insuredPersonName);

  /**
   * 护理费用明细与日结算结果查询
   *
   * @param nurseAmount
   * @return
   */
  public NurseDetailDO getNurseFeeDetailAndCalaResult(NurseDetailDO detail);

  /**
   * 服务项目推送接口
   *
   * @param serviceProject
   * @return
   */
  public boolean pushServiceProject(ServiceItemDO serviceItem);

  /** 居家/入住护理机构登记信息交易 */
}
