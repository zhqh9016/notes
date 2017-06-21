package com.taikang.dic.ltci.common.enumeration;

/**
 * 定时任务执行结果状态
 *
 * @author itw_liuxy
 */
public enum ExecutionStatusEnum {
  SUCCESS(1, "执行成功"),
  FAILD(0, "执行失败");
  private int value;
  private String desc;

  private ExecutionStatusEnum(int value, String desc) {
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
