package com.taikang.dic.ltci.model;

import java.util.Date;

public class ExpertEvaluateDO extends BaseModel {
  private String expertEvaluateid;

  private String expertEvaluateCode;

  private String firstEvaluateCode;

  private String accessoryAddress;

  private String printState;

  private Integer fraction;

  private String opinion;

  private String remark;

  private String operatedBy;

  private Date operatedTime;

  private String operatedOrg;

  private String createdBy;

  private Date createdTime;

  private String createdOrg;

  private Integer isValid;

  private String siArea;

  private String evaluateContent;

  public String getExpertEvaluateid() {
    return expertEvaluateid;
  }

  public void setExpertEvaluateid(String expertEvaluateid) {
    this.expertEvaluateid = expertEvaluateid == null ? null : expertEvaluateid.trim();
  }

  public String getExpertEvaluateCode() {
    return expertEvaluateCode;
  }

  public void setExpertEvaluateCode(String expertEvaluateCode) {
    this.expertEvaluateCode = expertEvaluateCode == null ? null : expertEvaluateCode.trim();
  }

  public String getFirstEvaluateCode() {
    return firstEvaluateCode;
  }

  public void setFirstEvaluateCode(String firstEvaluateCode) {
    this.firstEvaluateCode = firstEvaluateCode == null ? null : firstEvaluateCode.trim();
  }

  public String getAccessoryAddress() {
    return accessoryAddress;
  }

  public void setAccessoryAddress(String accessoryAddress) {
    this.accessoryAddress = accessoryAddress == null ? null : accessoryAddress.trim();
  }

  public String getPrintState() {
    return printState;
  }

  public void setPrintState(String printState) {
    this.printState = printState == null ? null : printState.trim();
  }

  public Integer getFraction() {
    return fraction;
  }

  public void setFraction(Integer fraction) {
    this.fraction = fraction;
  }

  public String getOpinion() {
    return opinion;
  }

  public void setOpinion(String opinion) {
    this.opinion = opinion == null ? null : opinion.trim();
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark == null ? null : remark.trim();
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

  public String getEvaluateContent() {
    return evaluateContent;
  }

  public void setEvaluateContent(String evaluateContent) {
    this.evaluateContent = evaluateContent == null ? null : evaluateContent.trim();
  }
}
