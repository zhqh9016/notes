package com.taikang.dic.ltci.model;

import java.util.Date;

public class EvaluateTaskLogDO extends BaseModel {

  private static final long serialVersionUID = 1L;

  private String evaluateTaskLogid;

  private String evaluateTaskCode;

  private String taskState;

  private String taskDeadline;

  private String evaluateAgencyCode;

  private String evaluateAgencyName;

  private Date sendTime;

  private String createdBy;

  private Date createdTime;

  public String getEvaluateTaskLogid() {
    return evaluateTaskLogid;
  }

  public void setEvaluateTaskLogid(String evaluateTaskLogid) {
    this.evaluateTaskLogid = evaluateTaskLogid == null ? null : evaluateTaskLogid.trim();
  }

  public String getEvaluateTaskCode() {
    return evaluateTaskCode;
  }

  public void setEvaluateTaskCode(String evaluateTaskCode) {
    this.evaluateTaskCode = evaluateTaskCode == null ? null : evaluateTaskCode.trim();
  }

  public String getTaskState() {
    return taskState;
  }

  public void setTaskState(String taskState) {
    this.taskState = taskState == null ? null : taskState.trim();
  }

  public String getTaskDeadline() {
    return taskDeadline;
  }

  public void setTaskDeadline(String taskDeadline) {
    this.taskDeadline = taskDeadline == null ? null : taskDeadline.trim();
  }

  public String getEvaluateAgencyCode() {
    return evaluateAgencyCode;
  }

  public void setEvaluateAgencyCode(String evaluateAgencyCode) {
    this.evaluateAgencyCode = evaluateAgencyCode == null ? null : evaluateAgencyCode.trim();
  }

  public String getEvaluateAgencyName() {
    return evaluateAgencyName;
  }

  public void setEvaluateAgencyName(String evaluateAgencyName) {
    this.evaluateAgencyName = evaluateAgencyName == null ? null : evaluateAgencyName.trim();
  }

  public Date getSendTime() {
    return sendTime;
  }

  public void setSendTime(Date sendTime) {
    this.sendTime = sendTime;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy == null ? null : createdBy.trim();
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }
}
