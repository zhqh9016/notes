package com.taikang.dic.ltci.common.enumeration;

/**
 * MQ发送或接收类型枚举类
 *
 * @author itw_liuxy
 * @description
 * @createTime 2017年4月18日 上午10:57:47
 */
public enum MqTypeEnum {
  SEND("01", "发送"),
  RECEIVE("02", "接收");

  private String value;

  private String desc;

  private MqTypeEnum(String value, String desc) {
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
