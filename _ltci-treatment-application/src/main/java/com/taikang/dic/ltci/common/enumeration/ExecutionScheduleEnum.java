package com.taikang.dic.ltci.common.enumeration;

/**
 * 定时任务执行进度
 *
 * @author itw_liuxy
 */
public enum ExecutionScheduleEnum {
  ON(1, "执行开始"),
  OFF(0, "执行结束");
  private int value;
  private String desc;

  private ExecutionScheduleEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
}
