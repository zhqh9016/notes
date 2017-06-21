package com.taikang.dic.ltci.common.enumeration;

/**
 * 是否紧急枚举
 *
 * @author itw_liuxy
 */
public enum IsAppication {
  YES("1", "可以"),
  NO("0", "不可以");
  private String value;

  private String desc;

  private IsAppication(String value, String desc) {
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
