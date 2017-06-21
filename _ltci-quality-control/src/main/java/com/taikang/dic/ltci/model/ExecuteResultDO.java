package com.taikang.dic.ltci.model;

import java.util.Date;

public class ExecuteResultDO extends BaseModel {

  private static final long serialVersionUID = 1L;

  private String executeResultId;

  private String patrolTaskId;

  private Date partolTime;

  private Date receiveResultTime;

  private Integer resultType;

  private String resultDesc;

  private Integer auditState;

  private String rejectionReason;

  private String auditor;

  private String auditorPhone;

  private Integer resultInformState;

  private String violationItem;

  private Integer isValid;

  private String siArea;

  private String operatedBy;

  private String operatedOrg;

  private Date operatedTime;

  private String createdBy;

  private String createdOrg;

  private Date createdTime;

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

  public Date getPartolTime() {
    return partolTime;
  }

  public void setPartolTime(Date partolTime) {
    this.partolTime = partolTime;
  }

  public Date getReceiveResultTime() {
    return receiveResultTime;
  }

  public void setReceiveResultTime(Date receiveResultTime) {
    this.receiveResultTime = receiveResultTime;
  }

  public Integer getResultType() {
    return resultType;
  }

  public void setResultType(Integer resultType) {
    this.resultType = resultType;
  }

  public String getResultDesc() {
    return resultDesc;
  }

  public void setResultDesc(String resultDesc) {
    this.resultDesc = resultDesc == null ? null : resultDesc.trim();
  }

  public Integer getAuditState() {
    return auditState;
  }

  public void setAuditState(Integer auditState) {
    this.auditState = auditState;
  }

  public String getRejectionReason() {
    return rejectionReason;
  }

  public void setRejectionReason(String rejectionReason) {
    this.rejectionReason = rejectionReason == null ? null : rejectionReason.trim();
  }

  public String getAuditor() {
    return auditor;
  }

  public void setAuditor(String auditor) {
    this.auditor = auditor == null ? null : auditor.trim();
  }

  public String getAuditorPhone() {
    return auditorPhone;
  }

  public void setAuditorPhone(String auditorPhone) {
    this.auditorPhone = auditorPhone == null ? null : auditorPhone.trim();
  }

  public Integer getResultInformState() {
    return resultInformState;
  }

  public void setResultInformState(Integer resultInformState) {
    this.resultInformState = resultInformState;
  }

  public String getViolationItem() {
    return violationItem;
  }

  public void setViolationItem(String violationItem) {
    this.violationItem = violationItem;
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
