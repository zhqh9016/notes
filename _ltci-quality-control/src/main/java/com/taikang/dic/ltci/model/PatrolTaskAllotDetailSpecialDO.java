package com.taikang.dic.ltci.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PatrolTaskAllotDetailSpecialDO {

  private static final long serialVersionUID = 1L;

  private String patrolStaffId;

  private String taskStatus;

  private String patrolStaffName;

  private String patrolTaskId;

  private String taskLevel;

  private String taskCategory;

  private String checkType;

  private String patrolObjectType;

  private String patrolObjectName;

  private String patrolObjectPhone;

  private String idCard;

  private String agencyCode;

  private String agencyName;

  private String patrolObjectAddr;

  private String deputyName;
  private String deputyMobile;
  private String recognizeeMan;
  private String recognizeeManCode;
  private String recognizeeManIdType;
  private String recognizeeManIdNo;
  private String recognizeeManPhone;
  private String recognizeeManAddr;
  private String longitude;
  private String latitude;
  private String complainItems;
  private String complaintContent;
  private String patrolRemark;
  private String complaintTime;
  private List<ComplaintResourceDO> material;
  private List<PatrolTaskDetailItemDO> detailItems;
  private List<PatrolTaskNurseDetailItemDO> nurseDetailItems;
  //  private List<Map<String, String>> complainItemsList = new ArrayList<>();
  //
  //  public List<Map<String, String>> getComplainItemsList() {
  //    return complainItemsList;
  //  }
  //
  //  public void setComplainItemsList(List<Map<String, String>> complainItemsList) {
  //    this.complainItemsList = complainItemsList;
  //  }

  public String getAgencyName() {
    return agencyName;
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

  public String getComplaintTime() {
    return complaintTime;
  }

  public void setComplaintTime(String complaintTime) {
    this.complaintTime = complaintTime;
  }

  public void setAgencyName(String agencyName) {
    this.agencyName = agencyName;
  }

  public String getPatrolStaffId() {
    return patrolStaffId;
  }

  public void setPatrolStaffId(String patrolStaffId) {
    this.patrolStaffId = patrolStaffId;
  }

  public String getTaskStatus() {
    return taskStatus;
  }

  public void setTaskStatus(String taskStatus) {
    this.taskStatus = taskStatus;
  }

  public String getPatrolStaffName() {
    return patrolStaffName;
  }

  public void setPatrolStaffName(String patrolStaffName) {
    this.patrolStaffName = patrolStaffName;
  }

  public String getPatrolTaskId() {
    return patrolTaskId;
  }

  public void setPatrolTaskId(String patrolTaskId) {
    this.patrolTaskId = patrolTaskId;
  }

  public String getTaskLevel() {
    return taskLevel;
  }

  public void setTaskLevel(String taskLevel) {
    this.taskLevel = taskLevel;
  }

  public String getTaskCategory() {
    return taskCategory;
  }

  public void setTaskCategory(String taskCategory) {
    this.taskCategory = taskCategory;
  }

  public String getCheckType() {
    return checkType;
  }

  public void setCheckType(String checkType) {
    this.checkType = checkType;
  }

  public String getPatrolObjectType() {
    return patrolObjectType;
  }

  public void setPatrolObjectType(String patrolObjectType) {
    this.patrolObjectType = patrolObjectType;
  }

  public String getPatrolObjectName() {
    return patrolObjectName;
  }

  public void setPatrolObjectName(String patrolObjectName) {
    this.patrolObjectName = patrolObjectName;
  }

  public String getPatrolObjectPhone() {
    return patrolObjectPhone;
  }

  public void setPatrolObjectPhone(String patrolObjectPhone) {
    this.patrolObjectPhone = patrolObjectPhone;
  }

  public String getIdCard() {
    return idCard;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard;
  }

  public String getAgencyCode() {
    return agencyCode;
  }

  public void setAgencyCode(String agencyCode) {
    this.agencyCode = agencyCode;
  }

  public String getPatrolObjectAddr() {
    return patrolObjectAddr;
  }

  public void setPatrolObjectAddr(String patrolObjectAddr) {
    this.patrolObjectAddr = patrolObjectAddr;
  }

  public String getRecognizeeMan() {
    return recognizeeMan;
  }

  public void setRecognizeeMan(String recognizeeMan) {
    this.recognizeeMan = recognizeeMan;
  }

  public String getRecognizeeManCode() {
    return recognizeeManCode;
  }

  public void setRecognizeeManCode(String recognizeeManCode) {
    this.recognizeeManCode = recognizeeManCode;
  }

  public String getRecognizeeManIdType() {
    return recognizeeManIdType;
  }

  public void setRecognizeeManIdType(String recognizeeManIdType) {
    this.recognizeeManIdType = recognizeeManIdType;
  }

  public String getRecognizeeManIdNo() {
    return recognizeeManIdNo;
  }

  public void setRecognizeeManIdNo(String recognizeeManIdNo) {
    this.recognizeeManIdNo = recognizeeManIdNo;
  }

  public String getRecognizeeManPhone() {
    return recognizeeManPhone;
  }

  public void setRecognizeeManPhone(String recognizeeManPhone) {
    this.recognizeeManPhone = recognizeeManPhone;
  }

  public String getRecognizeeManAddr() {
    return recognizeeManAddr;
  }

  public void setRecognizeeManAddr(String recognizeeManAddr) {
    this.recognizeeManAddr = recognizeeManAddr;
  }

  public String getLongitude() {
    return longitude;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public String getLatitude() {
    return latitude;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  public String getComplainItems() {
    return complainItems;
  }

  public void setComplainItems(String complainItems) {
    this.complainItems = complainItems;
  }

  public String getComplaintContent() {
    return complaintContent;
  }

  public void setComplaintContent(String complaintContent) {
    this.complaintContent = complaintContent;
  }

  public String getPatrolRemark() {
    return patrolRemark;
  }

  public void setPatrolRemark(String patrolRemark) {
    this.patrolRemark = patrolRemark;
  }

  public List<ComplaintResourceDO> getMaterial() {
    return material;
  }

  public void setMaterial(List<ComplaintResourceDO> material) {
    this.material = material;
  }

  public List<PatrolTaskDetailItemDO> getDetailItems() {
    return detailItems;
  }

  public void setDetailItems(List<PatrolTaskDetailItemDO> detailItems) {
    this.detailItems = detailItems;
  }

  public List<PatrolTaskNurseDetailItemDO> getNurseDetailItems() {
    return nurseDetailItems;
  }

  public void setNurseDetailItems(List<PatrolTaskNurseDetailItemDO> nurseDetailItems) {
    this.nurseDetailItems = nurseDetailItems;
  }
}
