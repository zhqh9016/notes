package com.taikang.dic.ltci.model;

import java.math.BigDecimal;
import java.util.Date;

public class FirstEvaluateSpecialDO extends BaseModel {
  private String firstEvaluateid;

  private String firstEvaluateCode;

  private String evaluateTaskCode;

  private BigDecimal score;

  private String printState;

  private String suggestion;

  private String evaluatorid;

  private String evaluateName;

  private String evaluatorOrg;

  private Date evaluateDate;

  private String remark;

  private String operatedBy;

  private Date operatedTime;

  private String operatedOrg;

  private String createdBy;

  private Date createdTime;

  private String createdOrg;

  private Integer isValid;

  private String siArea;

  private String detailJson;

  private String insuredPersonName;

  private String idCard;

  private String address;

  private String personnelIdentityCode;

  private String personnelIdentityName;

  private String securityNumber;

  private String insuredPersonCode;

  private String applicationCode;

  public String getApplicationCode() {
    return applicationCode;
  }

  public void setApplicationCode(String applicationCode) {
    this.applicationCode = applicationCode;
  }

  public String getInsuredPersonCode() {
    return insuredPersonCode;
  }

  public void setInsuredPersonCode(String insuredPersonCode) {
    this.insuredPersonCode = insuredPersonCode;
  }

  public String getPersonnelIdentityCode() {
    return personnelIdentityCode;
  }

  public void setPersonnelIdentityCode(String personnelIdentityCode) {
    this.personnelIdentityCode = personnelIdentityCode;
  }

  public String getPersonnelIdentityName() {
    return personnelIdentityName;
  }

  public void setPersonnelIdentityName(String personnelIdentityName) {
    this.personnelIdentityName = personnelIdentityName;
  }

  public String getSecurityNumber() {
    return securityNumber;
  }

  public void setSecurityNumber(String securityNumber) {
    this.securityNumber = securityNumber;
  }

  public String getInsuredPersonName() {
    return insuredPersonName;
  }

  public void setInsuredPersonName(String insuredPersonName) {
    this.insuredPersonName = insuredPersonName;
  }

  public String getIdCard() {
    return idCard;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getFirstEvaluateid() {
    return firstEvaluateid;
  }

  public void setFirstEvaluateid(String firstEvaluateid) {
    this.firstEvaluateid = firstEvaluateid == null ? null : firstEvaluateid.trim();
  }

  public String getFirstEvaluateCode() {
    return firstEvaluateCode;
  }

  public void setFirstEvaluateCode(String firstEvaluateCode) {
    this.firstEvaluateCode = firstEvaluateCode == null ? null : firstEvaluateCode.trim();
  }

  public String getEvaluateTaskCode() {
    return evaluateTaskCode;
  }

  public void setEvaluateTaskCode(String evaluateTaskCode) {
    this.evaluateTaskCode = evaluateTaskCode == null ? null : evaluateTaskCode.trim();
  }

  public BigDecimal getScore() {
    return score;
  }

  public void setScore(BigDecimal score) {
    this.score = score;
  }

  public String getPrintState() {
    return printState;
  }

  public void setPrintState(String printState) {
    this.printState = printState == null ? null : printState.trim();
  }

  public String getSuggestion() {
    return suggestion;
  }

  public void setSuggestion(String suggestion) {
    this.suggestion = suggestion == null ? null : suggestion.trim();
  }

  public String getEvaluatorid() {
    return evaluatorid;
  }

  public void setEvaluatorid(String evaluatorid) {
    this.evaluatorid = evaluatorid == null ? null : evaluatorid.trim();
  }

  public String getEvaluateName() {
    return evaluateName;
  }

  public void setEvaluateName(String evaluateName) {
    this.evaluateName = evaluateName == null ? null : evaluateName.trim();
  }

  public String getEvaluatorOrg() {
    return evaluatorOrg;
  }

  public void setEvaluatorOrg(String evaluatorOrg) {
    this.evaluatorOrg = evaluatorOrg == null ? null : evaluatorOrg.trim();
  }

  public Date getEvaluateDate() {
    return evaluateDate;
  }

  public void setEvaluateDate(Date evaluateDate) {
    this.evaluateDate = evaluateDate;
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

  public String getDetailJson() {
    return detailJson;
  }

  public void setDetailJson(String detailJson) {
    this.detailJson = detailJson == null ? null : detailJson.trim();
  }
}
