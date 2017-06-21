package com.taikang.dic.ltci.common.enumeration;
/**
 * @author itw_xuxf
 * @description 东软结果返回的 ErrorReasonCode
 * @version 创建时间：2017年5月9日上午8:41:08
 */
public enum ErrorReasonStateEnum {
  IS_SUCCESS("0", "成功"),
  IS_FAIL("1", "失败");

  private String value;

  private String desc;

  private ErrorReasonStateEnum(String value, String desc) {
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
