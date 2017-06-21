package com.taikang.dic.ltci.portal.common.enumeration;

/**
 * 评估任务状态枚举类
 *
 * @author itw_xuxf
 * @version 2017年4月14日上午11:03:56
 */
public enum EvaluateTaskStatusEnum {
  NOT_SEND("00", "未发送"),
  HAS_BEEN_SENT("01", "已发送"),
  PRELIMINARY_ASSESSMENT("02", "结果已接收(初评已反馈)"),
  UNDELIVERED("03", "未送达（专家已评定）"),
  SERVED("04", "已送达");
  private String value;

  private String desc;

  private EvaluateTaskStatusEnum(String value, String desc) {
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
