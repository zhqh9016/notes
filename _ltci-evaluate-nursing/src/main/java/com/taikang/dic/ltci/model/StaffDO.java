package com.taikang.dic.ltci.model;

import java.util.Date;

public class StaffDO extends BaseModel {
  private String staffid;

  private String staffCode;

  private String staffName;

  private String agencyCode;

  private String staffPhone;

  private Integer credentialType;

  private String credentialNumber;

  private Date credentialValidityDate;

  private Integer staffGender;

  private String highestEducation;

  private String acquireDegree;

  private Date certificateDate;

  private String jobScope;

  private String certificateNumber;

  private String practiceNumbe;

  private Integer practiceLevel;

  private Date credentialBeginDate;

  private Date credentialEndDate;

  private Integer qualificationLevel;

  private String comment;

  private String superviseApproveId;

  private Integer staffAuditState;

  private Integer isValid;

  private String siArea;

  private String operatedBy;

  private String operatedOrg;

  private Date operatedTime;

  private String createdBy;

  private String createdOrg;

  private Date createTime;

  public String getStaffid() {
    return staffid;
  }

  public void setStaffid(String staffid) {
    this.staffid = staffid == null ? null : staffid.trim();
  }

  public String getStaffCode() {
    return staffCode;
  }

  public void setStaffCode(String staffCode) {
    this.staffCode = staffCode == null ? null : staffCode.trim();
  }

  public String getStaffName() {
    return staffName;
  }

  public void setStaffName(String staffName) {
    this.staffName = staffName == null ? null : staffName.trim();
  }

  public String getAgencyCode() {
    return agencyCode;
  }

  public void setAgencyCode(String agencyCode) {
    this.agencyCode = agencyCode == null ? null : agencyCode.trim();
  }

  public String getStaffPhone() {
    return staffPhone;
  }

  public void setStaffPhone(String staffPhone) {
    this.staffPhone = staffPhone == null ? null : staffPhone.trim();
  }

  public Integer getCredentialType() {
    return credentialType;
  }

  public void setCredentialType(Integer credentialType) {
    this.credentialType = credentialType;
  }

  public String getCredentialNumber() {
    return credentialNumber;
  }

  public void setCredentialNumber(String credentialNumber) {
    this.credentialNumber = credentialNumber == null ? null : credentialNumber.trim();
  }

  public Date getCredentialValidityDate() {
    return credentialValidityDate;
  }

  public void setCredentialValidityDate(Date credentialValidityDate) {
    this.credentialValidityDate = credentialValidityDate;
  }

  public Integer getStaffGender() {
    return staffGender;
  }

  public void setStaffGender(Integer staffGender) {
    this.staffGender = staffGender;
  }

  public String getHighestEducation() {
    return highestEducation;
  }

  public void setHighestEducation(String highestEducation) {
    this.highestEducation = highestEducation == null ? null : highestEducation.trim();
  }

  public String getAcquireDegree() {
    return acquireDegree;
  }

  public void setAcquireDegree(String acquireDegree) {
    this.acquireDegree = acquireDegree == null ? null : acquireDegree.trim();
  }

  public Date getCertificateDate() {
    return certificateDate;
  }

  public void setCertificateDate(Date certificateDate) {
    this.certificateDate = certificateDate;
  }

  public String getJobScope() {
    return jobScope;
  }

  public void setJobScope(String jobScope) {
    this.jobScope = jobScope == null ? null : jobScope.trim();
  }

  public String getCertificateNumber() {
    return certificateNumber;
  }

  public void setCertificateNumber(String certificateNumber) {
    this.certificateNumber = certificateNumber == null ? null : certificateNumber.trim();
  }

  public String getPracticeNumbe() {
    return practiceNumbe;
  }

  public void setPracticeNumbe(String practiceNumbe) {
    this.practiceNumbe = practiceNumbe == null ? null : practiceNumbe.trim();
  }

  public Integer getPracticeLevel() {
    return practiceLevel;
  }

  public void setPracticeLevel(Integer practiceLevel) {
    this.practiceLevel = practiceLevel;
  }

  public Date getCredentialBeginDate() {
    return credentialBeginDate;
  }

  public void setCredentialBeginDate(Date credentialBeginDate) {
    this.credentialBeginDate = credentialBeginDate;
  }

  public Date getCredentialEndDate() {
    return credentialEndDate;
  }

  public void setCredentialEndDate(Date credentialEndDate) {
    this.credentialEndDate = credentialEndDate;
  }

  public Integer getQualificationLevel() {
    return qualificationLevel;
  }

  public void setQualificationLevel(Integer qualificationLevel) {
    this.qualificationLevel = qualificationLevel;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment == null ? null : comment.trim();
  }

  public String getSuperviseApproveId() {
    return superviseApproveId;
  }

  public void setSuperviseApproveId(String superviseApproveId) {
    this.superviseApproveId = superviseApproveId == null ? null : superviseApproveId.trim();
  }

  public Integer getStaffAuditState() {
    return staffAuditState;
  }

  public void setStaffAuditState(Integer staffAuditState) {
    this.staffAuditState = staffAuditState;
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
