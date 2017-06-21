package com.taikang.dic.ltci.common.enumeration;

/**
 * 状态码枚举类
 *
 * @author itw_xuyao
 * @description
 * @createTime 2017年4月6日 上午10:41:44
 */
public enum EvaluateEnum {
  NO_SEND("00", "未发送"),
  ALREADY_SEND("01", "已发送"),
  ALREADY_RECEIVE("02", "已接收"),
  NO_DELIVERY("03", "未送达"),
  ALREADY_DELIVERY("04", "已送达");
  private String value;

  private String desc;

  private EvaluateEnum(String value, String desc) {
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
