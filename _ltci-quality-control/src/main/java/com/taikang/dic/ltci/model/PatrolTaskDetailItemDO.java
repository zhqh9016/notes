package com.taikang.dic.ltci.model;

import java.util.List;

public class PatrolTaskDetailItemDO {

  private static final long serialVersionUID = 1L;

  private String executorName;

  private String executorMobile;

  private String executorOrgName;
  private String name;
  private String mobile;
  private String evaluateTime;
  private String taskDeadline;

  public String getExecutorName() {
    return executorName;
  }

  public void setExecutorName(String executorName) {
    this.executorName = executorName;
  }

  public String getExecutorMobile() {
    return executorMobile;
  }

  public void setExecutorMobile(String executorMobile) {
    this.executorMobile = executorMobile;
  }

  public String getExecutorOrgName() {
    return executorOrgName;
  }

  public void setExecutorOrgName(String executorOrgName) {
    this.executorOrgName = executorOrgName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getEvaluateTime() {
    return evaluateTime;
  }

  public void setEvaluateTime(String evaluateTime) {
    this.evaluateTime = evaluateTime;
  }

  public String getTaskDeadline() {
    return taskDeadline;
  }

  public void setTaskDeadline(String taskDeadline) {
    this.taskDeadline = taskDeadline;
  }
}
