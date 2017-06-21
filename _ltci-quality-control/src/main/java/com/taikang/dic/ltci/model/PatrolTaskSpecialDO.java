package com.taikang.dic.ltci.model;

import java.io.Serializable;
import java.util.List;

public class PatrolTaskSpecialDO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String patrolTaskId;

  private String patrolObjectType;

  private String patrolObjectId;

  private String patrolObjectName;

  private String patrolObjectPhone;

  private String idCard;

  private String patrolObjectAddr;

  private String patrolRemark;

  private Integer taskCategory;

  private String taskLevel;

  private String taskState;

  private String complaintObjectId;

  private Integer complainantObjectType;

  private Integer complaintType;

  private String complaintTime;

  private String complainantId;

  private String violationItem;

  private String complaintContent;

  private String remark;

  private String patrolStaffId;

  private String patrolStaffName;

  private Integer executeMessageState;

  private Integer isValid;

  private String siArea;

  private String operatedBy;

  private String operatedOrg;

  private String operatedTime;

  private String operatedTime1;

  private String createdBy;

  private String createdOrg;

  private String createdTime;

  private String agencyName;

  private Integer complaintObjectType;

  private String deputyName;

  private String deputyMobile;

  private String deputyIdCard;

  private String rejectionReason;

  private List<ComplaintResourceDO> complaintResourceDOList;

  private List<PatrolTaskDetailSpecialDO> patrolTaskDetailDOList;

  public List<PatrolTaskDetailSpecialDO> getPatrolTaskDetailDOList() {
    return patrolTaskDetailDOList;
  }

  public void setPatrolTaskDetailDOList(List<PatrolTaskDetailSpecialDO> patrolTaskDetailDOList) {
    this.patrolTaskDetailDOList = patrolTaskDetailDOList;
  }

  public String getRejectionReason() {
    return rejectionReason;
  }

  public void setRejectionReason(String rejectionReason) {
    this.rejectionReason = rejectionReason;
  }

  public String getOperatedTime1() {
    return operatedTime1;
  }

  public void setOperatedTime1(String operatedTime1) {
    this.operatedTime1 = operatedTime1;
  }

  public Integer getComplaintObjectType() {
    return complaintObjectType;
  }

  public void setComplaintObjectType(Integer complaintObjectType) {
    this.complaintObjectType = complaintObjectType;
  }

  public String getDeputyName() {
    return deputyName;
  }

  public void setDeputyName(String deputyName) {
    this.deputyName = deputyName;
  }

  public String getDeputyMobile() {
    return deputyMobile;
  }

  public void setDeputyMobile(String deputyMobile) {
    this.deputyMobile = deputyMobile;
  }

  public String getDeputyIdCard() {
    return deputyIdCard;
  }

  public void setDeputyIdCard(String deputyIdCard) {
    this.deputyIdCard = deputyIdCard;
  }

  public List<ComplaintResourceDO> getComplaintResourceDOList() {
    return complaintResourceDOList;
  }

  public void setComplaintResourceDOList(List<ComplaintResourceDO> complaintResourceDOList) {
    this.complaintResourceDOList = complaintResourceDOList;
  }

  public String getAgencyName() {
    return agencyName;
  }

  public void setAgencyName(String agencyName) {
    this.agencyName = agencyName;
  }

  public String getComplaintTime() {
    return complaintTime;
  }

  public void setComplaintTime(String complaintTime) {
    this.complaintTime = complaintTime;
  }

  public String getOperatedTime() {
    return operatedTime;
  }

  public void setOperatedTime(String operatedTime) {
    this.operatedTime = operatedTime;
  }

  public String getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(String createdTime) {
    this.createdTime = createdTime;
  }

  public String getPatrolTaskId() {
    return patrolTaskId;
  }

  public void setPatrolTaskId(String patrolTaskId) {
    this.patrolTaskId = patrolTaskId == null ? null : patrolTaskId.trim();
  }

  public String getPatrolObjectType() {
    return patrolObjectType;
  }

  public void setPatrolObjectType(String patrolObjectType) {
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

  public Integer getTaskCategory() {
    return taskCategory;
  }

  public void setTaskCategory(Integer taskCategory) {
    this.taskCategory = taskCategory;
  }

  public String getTaskLevel() {
    return taskLevel;
  }

  public void setTaskLevel(String taskLevel) {
    this.taskLevel = taskLevel;
  }

  public String getTaskState() {
    return taskState;
  }

  public void setTaskState(String taskState) {
    this.taskState = taskState;
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

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark == null ? null : remark.trim();
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
}
