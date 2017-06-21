package com.taikang.dic.ltci.common.enumeration;

/**
 * 任务状态
 *
 * @author itw_xuyao
 */
public enum TaskStateEnum {
  NO_ALLOCATION(0, "未分配"),
  ALREDY_ALLOCATION(1, "已分配"),
  IN_EXECUTE(2, "执行中"),
  ALREDY_EXECUTE(3, "已执行"),
  ALREDY_PASS(4, "通过"),
  NO_PASS(5, "不通过"),
  IN_APPEAL(6, "申诉中"),
  IN_RECONSIDER(7, "复议中");
  private int value;

  private String desc;

  private TaskStateEnum(int value, String desc) {
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
