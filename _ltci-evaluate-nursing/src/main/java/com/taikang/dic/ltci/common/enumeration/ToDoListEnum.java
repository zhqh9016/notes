package com.taikang.dic.ltci.common.enumeration;

/**
 * @author itw_liuxy
 * @description
 * @createTime 2017年4月14日 上午9:45:34
 */
public enum ToDoListEnum {
  MOBILE_APPLY_DETAILS("01", "移动端待遇申请受理详情mobileApplyDetails.html"),
  APPLY_ACCEPT_DETAILS("02", "待遇申请详情applyAcceptDetails.html"),
  BIND_MSG_DETAILS("03", "代理人绑定审核详情bindMsgDetails.html"),
  ASSESSMENT_TASK_SEND("04", "评估任务发送提醒列表assessmentTimeout.html"),
  RECEIVE_INITIAL_RESULT("05", "评估结果接收提醒列表receiveInitialResult.html");

  private String value;

  private String desc;

  private ToDoListEnum(String value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  public String getValue() {
    return value;
  }

  public String getDesc() {
    return desc;
  }

  public boolean isRest() {
    return false;
  }
}
