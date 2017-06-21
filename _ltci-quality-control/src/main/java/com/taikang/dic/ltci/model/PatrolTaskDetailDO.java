package com.taikang.dic.ltci.model;

import java.util.Date;

public class PatrolTaskDetailDO extends BaseModel {

  private static final long serialVersionUID = 1L;

  private String taskDetailId;

  private String patrolTaskId;

  private String orgTaskId;

  private String personName;

  private String personCode;

  private String agencyCode;

  private Date preevaluateDate;

  private String insuranceCode;

  private String insuranceName;

  private Integer insurancePapersType;

  private String insurancePapersNo;

  private String insurancePhone;

  private String insuranceAddress;

  private String longitude;

  private String latitude;

  private String remark;

  private Integer serviceType;

  private String serviceItems;

  private String createdBy;

  private String createdOrg;

  private Date createdTime;

  private Integer isCritical;

  private Integer isKinshipCare;

  private Integer isPrivilege;

  private String personPhone;

  private String agencyName;

  private String patrolObjectPhone;

  private String patrolObjectAddr;

  public String getTaskDetailId() {
    return taskDetailId;
  }

  public void setTaskDetailId(String taskDetailId) {
    this.taskDetailId = taskDetailId == null ? null : taskDetailId.trim();
  }

  public String getPatrolTaskId() {
    return patrolTaskId;
  }

  public void setPatrolTaskId(String patrolTaskId) {
    this.patrolTaskId = patrolTaskId == null ? null : patrolTaskId.trim();
  }

  public String getOrgTaskId() {
    return orgTaskId;
  }

  public void setOrgTaskId(String orgTaskId) {
    this.orgTaskId = orgTaskId == null ? null : orgTaskId.trim();
  }

  public String getPersonName() {
    return personName;
  }

  public void setPersonName(String personName) {
    this.personName = personName == null ? null : personName.trim();
  }

  public String getPersonCode() {
    return personCode;
  }

  public void setPersonCode(String personCode) {
    this.personCode = personCode == null ? null : personCode.trim();
  }

  public String getAgencyCode() {
    return agencyCode;
  }

  public void setAgencyCode(String agencyCode) {
    this.agencyCode = agencyCode == null ? null : agencyCode.trim();
  }

  public Date getPreevaluateDate() {
    return preevaluateDate;
  }

  public void setPreevaluateDate(Date preevaluateDate) {
    this.preevaluateDate = preevaluateDate;
  }

  public String getInsuranceCode() {
    return insuranceCode;
  }

  public void setInsuranceCode(String insuranceCode) {
    this.insuranceCode = insuranceCode == null ? null : insuranceCode.trim();
  }

  public String getInsuranceName() {
    return insuranceName;
  }

  public void setInsuranceName(String insuranceName) {
    this.insuranceName = insuranceName == null ? null : insuranceName.trim();
  }

  public Integer getInsurancePapersType() {
    return insurancePapersType;
  }

  public void setInsurancePapersType(Integer insurancePapersType) {
    this.insurancePapersType = insurancePapersType;
  }

  public String getInsurancePapersNo() {
    return insurancePapersNo;
  }

  public void setInsurancePapersNo(String insurancePapersNo) {
    this.insurancePapersNo = insurancePapersNo == null ? null : insurancePapersNo.trim();
  }

  public String getInsurancePhone() {
    return insurancePhone;
  }

  public void setInsurancePhone(String insurancePhone) {
    this.insurancePhone = insurancePhone == null ? null : insurancePhone.trim();
  }

  public String getInsuranceAddress() {
    return insuranceAddress;
  }

  public void setInsuranceAddress(String insuranceAddress) {
    this.insuranceAddress = insuranceAddress == null ? null : insuranceAddress.trim();
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude == null ? null : longitude.trim();
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude == null ? null : latitude.trim();
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark == null ? null : remark.trim();
  }

  public Integer getServiceType() {
    return serviceType;
  }

  public void setServiceType(Integer serviceType) {
    this.serviceType = serviceType;
  }

  public String getServiceItems() {
    return serviceItems;
  }

  public void setServiceItems(String serviceItems) {
    this.serviceItems = serviceItems == null ? null : serviceItems.trim();
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

  public Integer getIsCritical() {
    return isCritical;
  }

  public void setIsCritical(Integer isCritical) {
    this.isCritical = isCritical;
  }

  public Integer getIsKinshipCare() {
    return isKinshipCare;
  }

  public void setIsKinshipCare(Integer isKinshipCare) {
    this.isKinshipCare = isKinshipCare;
  }

  public Integer getIsPrivilege() {
    return isPrivilege;
  }

  public void setIsPrivilege(Integer isPrivilege) {
    this.isPrivilege = isPrivilege;
  }

  public String getPersonPhone() {
    return personPhone;
  }

  public void setPersonPhone(String personPhone) {
    this.personPhone = personPhone == null ? null : personPhone.trim();
  }

  public String getAgencyName() {
    return agencyName;
  }

  public void setAgencyName(String agencyName) {
    this.agencyName = agencyName;
  }

  public String getPatrolObjectPhone() {
    return patrolObjectPhone;
  }

  public void setPatrolObjectPhone(String patrolObjectPhone) {
    this.patrolObjectPhone = patrolObjectPhone;
  }

  public String getPatrolObjectAddr() {
    return patrolObjectAddr;
  }

  public void setPatrolObjectAddr(String patrolObjectAddr) {
    this.patrolObjectAddr = patrolObjectAddr;
  }
}
