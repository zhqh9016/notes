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
  BUSI_TYPE_01("getNurseAmountDetail", "护理费用明细上传社保"),
  BUSI_TYPE_02("pushServiceProject", "服务项目推送");

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
