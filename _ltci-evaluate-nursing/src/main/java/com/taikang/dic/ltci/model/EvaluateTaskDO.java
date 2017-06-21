package com.taikang.dic.ltci.model;

import java.util.Date;

public class EvaluateTaskDO extends BaseModel {
  private String evaluateTaskid;

  private String evaluateTaskCode;

  private String applicationCode;

  private String insuredPersonCode;

  private String mobile;

  private String insuredPersonName;

  private String idCard;

  private String taskState;

  private String taskDeadline;

  private String evaluateAgencyCode;

  private String evaluateAgencyName;

  private String evaluateCode;

  private Date sendTime;

  private String printState;

  private String isReevaluate;

  private String reevalueateResult;

  private String reevaluateParentCode;

  private String operatedBy;

  private Date operatedTime;

  private String operatedOrg;

  private String createdBy;

  private Date createdTime;

  private String createdOrg;

  private Integer isValid;

  private String siArea;

  private String remark;

  public String getEvaluateTaskid() {
    return evaluateTaskid;
  }

  public void setEvaluateTaskid(String evaluateTaskid) {
    this.evaluateTaskid = evaluateTaskid == null ? null : evaluateTaskid.trim();
  }

  public String getEvaluateTaskCode() {
    return evaluateTaskCode;
  }

  public void setEvaluateTaskCode(String evaluateTaskCode) {
    this.evaluateTaskCode = evaluateTaskCode == null ? null : evaluateTaskCode.trim();
  }

  public String getApplicationCode() {
    return applicationCode;
  }

  public void setApplicationCode(String applicationCode) {
    this.applicationCode = applicationCode == null ? null : applicationCode.trim();
  }

  public String getInsuredPersonCode() {
    return insuredPersonCode;
  }

  public void setInsuredPersonCode(String insuredPersonCode) {
    this.insuredPersonCode = insuredPersonCode == null ? null : insuredPersonCode.trim();
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile == null ? null : mobile.trim();
  }

  public String getInsuredPersonName() {
    return insuredPersonName;
  }

  public void setInsuredPersonName(String insuredPersonName) {
    this.insuredPersonName = insuredPersonName == null ? null : insuredPersonName.trim();
  }

  public String getIdCard() {
    return idCard;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard == null ? null : idCard.trim();
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

  public String getEvaluateCode() {
    return evaluateCode;
  }

  public void setEvaluateCode(String evaluateCode) {
    this.evaluateCode = evaluateCode == null ? null : evaluateCode.trim();
  }

  public Date getSendTime() {
    return sendTime;
  }

  public void setSendTime(Date sendTime) {
    this.sendTime = sendTime;
  }

  public String getPrintState() {
    return printState;
  }

  public void setPrintState(String printState) {
    this.printState = printState == null ? null : printState.trim();
  }

  public String getIsReevaluate() {
    return isReevaluate;
  }

  public void setIsReevaluate(String isReevaluate) {
    this.isReevaluate = isReevaluate == null ? null : isReevaluate.trim();
  }

  public String getReevalueateResult() {
    return reevalueateResult;
  }

  public void setReevalueateResult(String reevalueateResult) {
    this.reevalueateResult = reevalueateResult == null ? null : reevalueateResult.trim();
  }

  public String getReevaluateParentCode() {
    return reevaluateParentCode;
  }

  public void setReevaluateParentCode(String reevaluateParentCode) {
    this.reevaluateParentCode = reevaluateParentCode == null ? null : reevaluateParentCode.trim();
  }

  public String getOperatedBy() {
    return operatedBy;
  }

  public void setOperatedBy(String operatedBy) {
    this.operatedBy = operatedBy == null ? null : operatedBy.trim();
  }

  public Date getOperatedTime() {
    return operatedTime;
  }

  public void setOperatedTime(Date operatedTime) {
    this.operatedTime = operatedTime;
  }

  public String getOperatedOrg() {
    return operatedOrg;
  }

  public void setOperatedOrg(String operatedOrg) {
    this.operatedOrg = operatedOrg == null ? null : operatedOrg.trim();
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

  public String getCreatedOrg() {
    return createdOrg;
  }

  public void setCreatedOrg(String createdOrg) {
    this.createdOrg = createdOrg == null ? null : createdOrg.trim();
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

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark == null ? null : remark.trim();
  }
}
