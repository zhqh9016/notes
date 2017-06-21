package com.taikang.dic.ltci.common.enumeration;

public enum ProfessionTypeEnum {
  DOCTOR_CODE(1, "医师"),
  NURSE_CODE(2, "护士"),
  CARER_CODE(3, "护理员"),
  MISC_CODE(4, "其他");
  private int value;

  private String desc;

  private ProfessionTypeEnum(int value, String desc) {
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
