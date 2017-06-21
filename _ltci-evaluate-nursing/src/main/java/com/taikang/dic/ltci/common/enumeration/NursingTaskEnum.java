package com.taikang.dic.ltci.common.enumeration;

/**
 * 护理任务状态码
 *
 * @author itw_liuxy
 * @description
 * @createTime 2017年4月15日 下午12:13:35
 */
public enum NursingTaskEnum {
  NO_INTENT_AGENCY("00", "未选择意向机构"),
  ALREADY_INTENT_AGENCY("01", "已选择意向机构"),
  ALREADY_FINAL_AGENCY("02", "已确认最终机构");
  private String value;

  private String desc;

  private NursingTaskEnum(String value, String desc) {
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
