package com.taikang.dic.ltci.common.enumeration;

/** 证件类型枚举类 */
public enum CredentialType {
  ID_CARD(0, "身份证号码");

  private Integer value;

  private String desc;

  private CredentialType(Integer value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  public Integer getValue() {
    return value;
  }

  public String getDesc() {
    return desc;
  }
}
