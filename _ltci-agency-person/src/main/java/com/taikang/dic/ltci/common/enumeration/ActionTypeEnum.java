package com.taikang.dic.ltci.common.enumeration;

/**
 * 申请、变更操作类型枚举类
 *
 * @author itw_liyh01
 * @createTime 2017年5月10日 下午14:11
 */
public enum ActionTypeEnum {
  CREATE("1", "新增"),
  UPDATE("2", "变更"),
  DELETE("3", "注销");

  private String value;

  private String desc;

  private ActionTypeEnum(String value, String desc) {
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
