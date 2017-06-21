package com.taikang.dic.ltci.model;
/** C端投诉进度列表查询(移动端->经办) */
public class MobileComplaintListDO {
  private String patrolTaskId;
  private String taskState;
  private String auditState;
  private String complaintTime;
  private String acceptTime;
  private String receiveResultTime;
  private String complaintContent;
  private String violationItem;
  private String taskNumber;
  private String complaintType;
  private String patrolViolationItem;

  public String getPatrolViolationItem() {
    return patrolViolationItem;
  }

  public void setPatrolViolationItem(String patrolViolationItem) {
    this.patrolViolationItem = patrolViolationItem;
  }

  public String getPatrolTaskId() {
    return patrolTaskId;
  }

  public void setPatrolTaskId(String patrolTaskId) {
    this.patrolTaskId = patrolTaskId;
  }

  public String getTaskState() {
    return taskState;
  }

  public void setTaskState(String taskState) {
    this.taskState = taskState;
  }

  public String getAuditState() {
    return auditState;
  }

  public void setAuditState(String auditState) {
    this.auditState = auditState;
  }

  public String getComplaintTime() {
    return complaintTime;
  }

  public void setComplaintTime(String complaintTime) {
    this.complaintTime = complaintTime;
  }

  public String getAcceptTime() {
    return acceptTime;
  }

  public void setAcceptTime(String acceptTime) {
    this.acceptTime = acceptTime;
  }

  public String getReceiveResultTime() {
    return receiveResultTime;
  }

  public void setReceiveResultTime(String receiveResultTime) {
    this.receiveResultTime = receiveResultTime;
  }

  public String getComplaintContent() {
    return complaintContent;
  }

  public void setComplaintContent(String complaintContent) {
    this.complaintContent = complaintContent;
  }

  public String getViolationItem() {
    return violationItem;
  }

  public void setViolationItem(String violationItem) {
    this.violationItem = violationItem;
  }

  public String getTaskNumber() {
    return taskNumber;
  }

  public void setTaskNumber(String taskNumber) {
    this.taskNumber = taskNumber;
  }

  public String getComplaintType() {
    return complaintType;
  }

  public void setComplaintType(String complaintType) {
    this.complaintType = complaintType;
  }
}
