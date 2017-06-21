package com.taikang.dic.ltci.common.enumeration;

/**
 * ModuleCode枚举类
 *
 * @author itw_liyh
 * @description
 * @createTime 2017年4月18日 下午1:48:22
 */
public enum ModuleCodeEnum {
  SEND_SERVICE_ITEM("SEND_SERVICE_ITEM", "发送护理目录的MQ"),
  SEND_NURSE_DETAIL_RESULT("SEND_NURSE_DETAIL_RESULT", "同步护理费用明细结果到专业系统");

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
