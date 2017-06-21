package com.taikang.dic.ltci.common.enumeration;

/**
 * 是否亲属照顾枚举
 *
 * @author itw_liuxy
 */
public enum IsRelativeCaredEnum {
  YES("1", "是"),
  NO("0", "否");
  private String value;

  private String desc;

  private IsRelativeCaredEnum(String value, String desc) {
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
