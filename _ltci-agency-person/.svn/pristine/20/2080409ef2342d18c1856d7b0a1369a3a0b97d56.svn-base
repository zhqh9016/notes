package com.taikang.dic.ltci.common.enumeration;

public enum AgencyStateEnum {
  STATE_NO_ACCEPT(1, "待受理"),
  STATE_ACCEPT(2, "已受理"),
  STATE_WITHHOLD_ACCEPT(3, "暂不受理"),
  STATE_AUDIT(4, "审核通过"),
  STATE_NO_AUDIT(5, "审核不通过");

  private Integer value;

  private String desc;

  private AgencyStateEnum(Integer value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  public Integer getValue() {
    return value;
  }

  public String getDesc() {
    return desc;
  }

  public boolean isRest() {
    return false;
  }
}
