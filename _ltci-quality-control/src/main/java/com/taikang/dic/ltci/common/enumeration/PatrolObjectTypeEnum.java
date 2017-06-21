package com.taikang.dic.ltci.common.enumeration;

/**
 * 类别枚举
 *
 * @author itw_xuyao
 */
public enum PatrolObjectTypeEnum {
  NURSE_ORGANIZATION(0, "护理机构"),
  EVALUATE_ORGANIZATION(1, "评估机构"),
  NURSE_STAFF(2, "护理人员"),
  EVALUATE_STAFF(3, "评估人员"),
  GINSENG_STAFF(4, "参保人");
  private int value;

  private String desc;

  private PatrolObjectTypeEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  public int getValue() {
    return value;
  }

  public String getDesc() {
    return desc;
  }

  public boolean isRest() {
    return false;
  }
}
