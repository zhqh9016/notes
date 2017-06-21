package com.taikang.dic.ltci.model;

import java.util.Date;

public class ReconsiderDO extends BaseModel {

  private static final long serialVersionUID = 1L;

  private String reconsiderid;

  private String serialNumber;

  private String executeResultId;

  private String patrolTaskId;

  private String appealPerson;

  private String appealPhone;

  private Date appealTime;

  private String applealContent;

  private String replyPerson;

  private String replyPhone;

  private String replyOpinion;

  private Integer isValid;

  private String siArea;

  private String operatedBy;

  private String operatedOrg;

  private Date operatedTime;

  private String createdBy;

  private String createdOrg;

  private Date createTime;

  public String getReconsiderid() {
    return reconsiderid;
  }

  public void setReconsiderid(String reconsiderid) {
    this.reconsiderid = reconsiderid == null ? null : reconsiderid.trim();
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber == null ? null : serialNumber.trim();
  }

  public String getExecuteResultId() {
    return executeResultId;
  }

  public void setExecuteResultId(String executeResultId) {
    this.executeResultId = executeResultId == null ? null : executeResultId.trim();
  }

  public String getPatrolTaskId() {
    return patrolTaskId;
  }

  public void setPatrolTaskId(String patrolTaskId) {
    this.patrolTaskId = patrolTaskId == null ? null : patrolTaskId.trim();
  }

  public String getAppealPerson() {
    return appealPerson;
  }

  public void setAppealPerson(String appealPerson) {
    this.appealPerson = appealPerson == null ? null : appealPerson.trim();
  }

  public String getAppealPhone() {
    return appealPhone;
  }

  public void setAppealPhone(String appealPhone) {
    this.appealPhone = appealPhone == null ? null : appealPhone.trim();
  }

  public Date getAppealTime() {
    return appealTime;
  }

  public void setAppealTime(Date appealTime) {
    this.appealTime = appealTime;
  }

  public String getApplealContent() {
    return applealContent;
  }

  public void setApplealContent(String applealContent) {
    this.applealContent = applealContent == null ? null : applealContent.trim();
  }

  public String getReplyPerson() {
    return replyPerson;
  }

  public void setReplyPerson(String replyPerson) {
    this.replyPerson = replyPerson == null ? null : replyPerson.trim();
  }

  public String getReplyPhone() {
    return replyPhone;
  }

  public void setReplyPhone(String replyPhone) {
    this.replyPhone = replyPhone == null ? null : replyPhone.trim();
  }

  public String getReplyOpinion() {
    return replyOpinion;
  }

  public void setReplyOpinion(String replyOpinion) {
    this.replyOpinion = replyOpinion == null ? null : replyOpinion.trim();
  }

  public Integer getIsValid() {
    return isValid;
  }

  public void setIsValid(Integer isValid) {
    this.isValid = isValid;
  }

  public String getSiArea() {
    return siArea;
  }

  public void setSiArea(String siArea) {
    this.siArea = siArea == null ? null : siArea.trim();
  }

  public String getOperatedBy() {
    return operatedBy;
  }

  public void setOperatedBy(String operatedBy) {
    this.operatedBy = operatedBy == null ? null : operatedBy.trim();
  }

  public String getOperatedOrg() {
    return operatedOrg;
  }

  public void setOperatedOrg(String operatedOrg) {
    this.operatedOrg = operatedOrg == null ? null : operatedOrg.trim();
  }

  public Date getOperatedTime() {
    return operatedTime;
  }

  public void setOperatedTime(Date operatedTime) {
    this.operatedTime = operatedTime;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy == null ? null : createdBy.trim();
  }

  public String getCreatedOrg() {
    return createdOrg;
  }

  public void setCreatedOrg(String createdOrg) {
    this.createdOrg = createdOrg == null ? null : createdOrg.trim();
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
