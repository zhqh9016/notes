package com.taikang.dic.ltci.common.enumeration;

/**
 * 服务发送、接收类型
 *
 * @author itw_muwg
 * @description
 */
public enum OperationTypeEnum {
  RECEIVE(0, "接收"),
  SEND(1, "发送");

  private Integer value;

  private String desc;

  private OperationTypeEnum(Integer value, String desc) {
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
