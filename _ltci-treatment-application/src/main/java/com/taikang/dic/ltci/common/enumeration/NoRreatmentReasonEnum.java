package com.taikang.dic.ltci.common.enumeration;

/**
 * 状态码枚举类
 *
 * @author itw_liuxy
 * @description
 * @createTime 2017年4月6日 上午10:41:44
 */
public enum NoRreatmentReasonEnum {
  ABNORMAL("1", "非正常参保"),
  IN_HOSPITAL("2", "医保在院"),
  BLOCKADE("3", "长护待遇封锁");

  private String value;

  private String desc;

  private NoRreatmentReasonEnum(String value, String desc) {
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
