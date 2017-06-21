package com.taikang.dic.ltci.common.enumeration;

/**
 * 服务调用交互方式
 *
 * @author itw_muwg
 * @description
 */
public enum TransportTypeEnum {
  SYNCHRONIZE(0, "同步"),
  ASYNCHRONIZE(1, "异步");

  private Integer value;

  private String desc;

  private TransportTypeEnum(Integer value, String desc) {
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
