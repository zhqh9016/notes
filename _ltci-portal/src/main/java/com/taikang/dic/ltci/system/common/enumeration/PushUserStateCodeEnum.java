package com.taikang.dic.ltci.system.common.enumeration;

public enum PushUserStateCodeEnum {
  SUCCESS("1000", "成功"),
  FAIL("1002", "失败");
  private String value;

  private String desc;

  private PushUserStateCodeEnum(String value, String desc) {
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
