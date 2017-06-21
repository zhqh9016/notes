package com.taikang.dic.ltci.common.enumeration;

/**
 * @author itw_liuxy
 * @description
 * @createTime 2017年4月14日 上午9:45:34
 */
public enum ToDoListTypeEnum {
  TASK("01", "待办任务"),
  REMIND("02", "代办提醒");

  private String value;

  private String desc;

  private ToDoListTypeEnum(String value, String desc) {
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
