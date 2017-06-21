package com.taikang.dic.ltci.common.enumeration;

/**
 * ModuleCode枚举类
 *
 * @author itw_liuxy
 * @description
 * @createTime 2017年4月18日 下午1:48:22
 */
public enum ModuleCodeEnum {
  SEND_APPEAL_RESULT("SEND_APPEAL_RESULT", "申诉复议意见告知"),
  SEND_PATROL_TASK("SEND_PATROL_TASK", "任务分配消息");

  private String value;

  private String desc;

  private ModuleCodeEnum(String value, String desc) {
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
