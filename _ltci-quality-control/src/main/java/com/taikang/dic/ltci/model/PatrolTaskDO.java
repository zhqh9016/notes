package com.taikang.dic.ltci.model;

import java.util.Date;

public class PatrolTaskDO extends BaseModel {

  private static final long serialVersionUID = 1L;

  private String patrolTaskId;

  private Integer patrolObjectType;

  private String patrolObjectId;

  private String patrolObjectName;

  private String patrolObjectPhone;

  private String idCard;

  private String agencyCode;

  private String agencyName;

  private String patrolObjectAddr;

  private String patrolRemark;

  private String remark;

  private Integer taskCategory;

  private Integer taskLevel;

  private Integer patrolsType;

  private Integer taskState;

  private String taskNumber;

  private String complaintObjectId;

  private Integer complainantObjectType;

  private Integer complaintType;

  private Date complaintTime;

  private String complainantId;

  private String violationItem;

  private String complaintContent;

  private String deputyName;

  private String deputyMobile;

  private String insuredPersonCard;

  private String complainantCard;

  private Integer complaintObjectType;

  private String patrolStaffId;

  private String patrolStaffName;

  private Integer executeMessageState;

  private Integer isValid;

  private String siArea;

  private String operatedBy;

  private String operatedOrg;

  private Date operatedTime;

  private String createdBy;

  private String createdOrg;

  private Date createdTime;

  public String getPatrolTaskId() {
    return patrolTaskId;
  }

  public void setPatrolTaskId(String patrolTaskId) {
    this.patrolTaskId = patrolTaskId == null ? null : patrolTaskId.trim();
  }

  public Integer getPatrolObjectType() {
    return patrolObjectType;
  }

  public void setPatrolObjectType(Integer patrolObjectType) {
    this.patrolObjectType = patrolObjectType;
  }

  public String getPatrolObjectId() {
    return patrolObjectId;
  }

  public void setPatrolObjectId(String patrolObjectId) {
    this.patrolObjectId = patrolObjectId == null ? null : patrolObjectId.trim();
  }

  public String getPatrolObjectName() {
    return patrolObjectName;
  }

  public void setPatrolObjectName(String patrolObjectName) {
    this.patrolObjectName = patrolObjectName == null ? null : patrolObjectName.trim();
  }

  public String getPatrolObjectPhone() {
    return patrolObjectPhone;
  }

  public void setPatrolObjectPhone(String patrolObjectPhone) {
    this.patrolObjectPhone = patrolObjectPhone == null ? null : patrolObjectPhone.trim();
  }

  public String getIdCard() {
    return idCard;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard == null ? null : idCard.trim();
  }

  public String getAgencyCode() {
    return agencyCode;
  }

  public void setAgencyCode(String agencyCode) {
    this.agencyCode = agencyCode == null ? null : agencyCode.trim();
  }

  public String getAgencyName() {
    return agencyName;
  }

  public void setAgencyName(String agencyName) {
    this.agencyName = agencyName == null ? null : agencyName.trim();
  }

  public String getPatrolObjectAddr() {
    return patrolObjectAddr;
  }

  public void setPatrolObjectAddr(String patrolObjectAddr) {
    this.patrolObjectAddr = patrolObjectAddr == null ? null : patrolObjectAddr.trim();
  }

  public String getPatrolRemark() {
    return patrolRemark;
  }

  public void setPatrolRemark(String patrolRemark) {
    this.patrolRemark = patrolRemark == null ? null : patrolRemark.trim();
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark == null ? null : remark.trim();
  }

  public Integer getTaskCategory() {
    return taskCategory;
  }

  public void setTaskCategory(Integer taskCategory) {
    this.taskCategory = taskCategory;
  }

  public Integer getTaskLevel() {
    return taskLevel;
  }

  public void setTaskLevel(Integer taskLevel) {
    this.taskLevel = taskLevel;
  }

  public Integer getPatrolsType() {
    return patrolsType;
  }

  public void setPatrolsType(Integer patrolsType) {
    this.patrolsType = patrolsType;
  }

  public Integer getTaskState() {
    return taskState;
  }

  public void setTaskState(Integer taskState) {
    this.taskState = taskState;
  }

  public String getTaskNumber() {
    return taskNumber;
  }

  public void setTaskNumber(String taskNumber) {
    this.taskNumber = taskNumber == null ? null : taskNumber.trim();
  }

  public String getComplaintObjectId() {
    return complaintObjectId;
  }

  public void setComplaintObjectId(String complaintObjectId) {
    this.complaintObjectId = complaintObjectId == null ? null : complaintObjectId.trim();
  }

  public Integer getComplainantObjectType() {
    return complainantObjectType;
  }

  public void setComplainantObjectType(Integer complainantObjectType) {
    this.complainantObjectType = complainantObjectType;
  }

  public Integer getComplaintType() {
    return complaintType;
  }

  public void setComplaintType(Integer complaintType) {
    this.complaintType = complaintType;
  }

  public Date getComplaintTime() {
    return complaintTime;
  }

  public void setComplaintTime(Date complaintTime) {
    this.complaintTime = complaintTime;
  }

  public String getComplainantId() {
    return complainantId;
  }

  public void setComplainantId(String complainantId) {
    this.complainantId = complainantId == null ? null : complainantId.trim();
  }

  public String getViolationItem() {
    return violationItem;
  }

  public void setViolationItem(String violationItem) {
    this.violationItem = violationItem == null ? null : violationItem.trim();
  }

  public String getComplaintContent() {
    return complaintContent;
  }

  public void setComplaintContent(String complaintContent) {
    this.complaintContent = complaintContent == null ? null : complaintContent.trim();
  }

  public String getDeputyName() {
    return deputyName;
  }

  public void setDeputyName(String deputyName) {
    this.deputyName = deputyName == null ? null : deputyName.trim();
  }

  public String getDeputyMobile() {
    return deputyMobile;
  }

  public void setDeputyMobile(String deputyMobile) {
    this.deputyMobile = deputyMobile == null ? null : deputyMobile.trim();
  }

  public String getInsuredPersonCard() {
    return insuredPersonCard;
  }

  public void setInsuredPersonCard(String insuredPersonCard) {
    this.insuredPersonCard = insuredPersonCard == null ? null : insuredPersonCard.trim();
  }

  public String getComplainantCard() {
    return complainantCard;
  }

  public void setComplainantCard(String complainantCard) {
    this.complainantCard = complainantCard == null ? null : complainantCard.trim();
  }

  public Integer getComplaintObjectType() {
    return complaintObjectType;
  }

  public void setComplaintObjectType(Integer complaintObjectType) {
    this.complaintObjectType = complaintObjectType;
  }

  public String getPatrolStaffId() {
    return patrolStaffId;
  }

  public void setPatrolStaffId(String patrolStaffId) {
    this.patrolStaffId = patrolStaffId == null ? null : patrolStaffId.trim();
  }

  public String getPatrolStaffName() {
    return patrolStaffName;
  }

  public void setPatrolStaffName(String patrolStaffName) {
    this.patrolStaffName = patrolStaffName == null ? null : patrolStaffName.trim();
  }

  public Integer getExecuteMessageState() {
    return executeMessageState;
  }

  public void setExecuteMessageState(Integer executeMessageState) {
    this.executeMessageState = executeMessageState;
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

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }
}
