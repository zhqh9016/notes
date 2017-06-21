package com.taikang.dic.ltci.common.enumeration;

/**
 * ModuleCode枚举类
 *
 * @author itw_liuxy
 * @description
 * @createTime 2017年4月18日 下午1:48:22
 */
public enum ModuleCodeEnum {
  SEND_EVALUATE_TASK("SEND_EVALUATE_TASK", "发送评估任务的MQ"),

  SEND_NURSING_TASK("SEND_NURSING_TASK", "发送护理对象的MQ"),

  SEND_CHECKIN("SEND_CHECKIN", "居家/入住"),

  SEND_CHECKOUT("SEND_CHECKOUT", "出院");

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
