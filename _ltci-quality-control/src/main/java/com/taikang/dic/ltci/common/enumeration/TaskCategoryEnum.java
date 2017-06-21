package com.taikang.dic.ltci.common.enumeration;

/**
 * 任务状态
 *
 * @author itw_xuyao
 */
public enum TaskCategoryEnum {
  COMPLAINT(0, "投诉"),
  SYSTEM_HANDING(1, "经办人发起");

  private int value;
  private String desc;

  private TaskCategoryEnum(int value, String desc) {
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
