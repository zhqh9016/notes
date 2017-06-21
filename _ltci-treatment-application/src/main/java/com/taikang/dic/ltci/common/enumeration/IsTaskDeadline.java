package com.taikang.dic.ltci.common.enumeration;

/**
 * 是否紧急枚举
 *
 * @author itw_liuxy
 */
public enum IsTaskDeadline {
  TASKDEADLINE("1", "紧急"),
  NO_TASKDEADLINE("0", "不紧急");
  private String value;

  private String desc;

  private IsTaskDeadline(String value, String desc) {
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
