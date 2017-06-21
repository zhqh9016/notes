package com.taikang.dic.ltci.common.enumeration;

/**
 * 机构类型枚举类
 *
 * @author itw_xuyao
 * @description
 * @createTime 2017年6月20日 上午10:41:44
 */
public enum OrganizationTypeEnum {
  EVALUATE_AGENCY("00", "护理机构"),
  NURSINGTASK_AGENCY("10", "评估机构");

  private String value;

  private String desc;

  private OrganizationTypeEnum(String value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  public String getValue() {
    return value;
  }

  public String getDesc() {
    return desc;
  }
}
