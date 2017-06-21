package com.taikang.dic.ltci.common.enumeration;

/**
 * 第三方接口日志枚举
 *
 * @author itw_huodd
 * @description
 * @createTime 2017年4月21日
 */
public enum ThirdInterfaceLogEnum {
  TYPE_SB("0", "社保"),
  TYPE_EVALUATE_NURSING("1", "评估护理服务"),
  TYPE_CHECK_IN("2", "专业协议入住"),
  TYPE_CHECK_OUT("3", "专业协议退出"),
  TYPE_CHECK_OUT_JINGBAN("4", "经办协议退出"),
  BUSI_TYPE_01("getNurseAmountDetail", "护理费用明细上传社保"),
  BUSI_TYPE_02("pushServiceProject", "服务项目推送"),
  BUSI_TYPE_03("reSend2ExpertTaskAdd", "评估任务新增"),
  BUSI_TYPE_04("reCheckInAndToDR", "专业协议入住"),
  BUSI_TYPE_05("reCheckOutAndToDR", "专业协议退出"),
  BUSI_TYPE_06("reUpdateCheckInAndToDR", "经办协议退出");

  private String value;

  private String desc;

  private ThirdInterfaceLogEnum(String value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  public String getValue() {
    return value;
  }

  public String getDesc() {
    return desc;
  }

  public boolean isRest() {
    return false;
  }
}
