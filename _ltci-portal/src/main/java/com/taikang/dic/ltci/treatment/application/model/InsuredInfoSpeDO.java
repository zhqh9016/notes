package com.taikang.dic.ltci.treatment.application.model;

import java.util.Date;
/** @author itw_caoxy 用于参保人添加和修改相关接收参数 */
public class InsuredInfoSpeDO {
  private String insuredPersonid;

  private String insuredPersonName;

  private String insuredPersonGender;

  private String nation;

  private String securityNumber;

  private String idCard;

  private String personnelIdentityCode;

  private String personnelIdentityName;

  private String siArea;

  private String residencyProperty;

  private String treatment;

  private String noRreatmentReason;

  private String personnelType;

  private String operatedBy;

  private String operatedOrg;

  private Date operatedTime;

  private String createdBy;

  private Date createdTime;

  private String createdOrg;

  public String getInsuredPersonid() {
    return insuredPersonid;
  }

  public void setInsuredPersonid(String insuredPersonid) {
    this.insuredPersonid = insuredPersonid;
  }

  public String getInsuredPersonName() {
    return insuredPersonName;
  }

  public void setInsuredPersonName(String insuredPersonName) {
    this.insuredPersonName = insuredPersonName == null ? null : insuredPersonName.trim();
  }

  public String getInsuredPersonGender() {
    return insuredPersonGender;
  }

  public void setInsuredPersonGender(String insuredPersonGender) {
    this.insuredPersonGender = insuredPersonGender == null ? null : insuredPersonGender.trim();
  }

  public String getNation() {
    return nation;
  }

  public void setNation(String nation) {
    this.nation = nation == null ? null : nation.trim();
  }

  public String getSecurityNumber() {
    return securityNumber;
  }

  public void setSecurityNumber(String securityNumber) {
    this.securityNumber = securityNumber == null ? null : securityNumber.trim();
  }

  public String getIdCard() {
    return idCard;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard == null ? null : idCard.trim();
  }

  public String getPersonnelIdentityCode() {
    return personnelIdentityCode;
  }

  public void setPersonnelIdentityCode(String personnelIdentityCode) {
    this.personnelIdentityCode =
        personnelIdentityCode == null ? null : personnelIdentityCode.trim();
  }

  public String getPersonnelIdentityName() {
    return personnelIdentityName;
  }

  public void setPersonnelIdentityName(String personnelIdentityName) {
    this.personnelIdentityName =
        personnelIdentityName == null ? null : personnelIdentityName.trim();
  }

  public String getSiArea() {
    return siArea;
  }

  public void setSiArea(String siArea) {
    this.siArea = siArea == null ? null : siArea.trim();
  }

  public String getResidencyProperty() {
    return residencyProperty;
  }

  public void setResidencyProperty(String residencyProperty) {
    this.residencyProperty = residencyProperty == null ? null : residencyProperty.trim();
  }

  public String getTreatment() {
    return treatment;
  }

  public void setTreatment(String treatment) {
    this.treatment = treatment == null ? null : treatment.trim();
  }

  public String getNoRreatmentReason() {
    return noRreatmentReason;
  }

  public void setNoRreatmentReason(String noRreatmentReason) {
    this.noRreatmentReason = noRreatmentReason == null ? null : noRreatmentReason.trim();
  }

  public String getPersonnelType() {
    return personnelType;
  }

  public void setPersonnelType(String personnelType) {
    this.personnelType = personnelType == null ? null : personnelType.trim();
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
}
