package com.taikang.dic.ltci.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MobileCompliainDO extends BaseModel {

  private static final long serialVersionUID = 1L;
  //投诉类型
  private int complainantType;
  //投诉时间
  private Date complaintTime;
  //投诉人ID,代理人身份证号
  private String complainantId;
  //投诉人姓名
  private String complainantName;
  //投诉人电话
  private String complainantMobile;
  //参保人身份证号
  private String idCard;
  private String insuredPersonName;
  private String mobile;
  private String address;
  private String securityNumber;
  //被投诉对象类型
  private long complaintObjectType;
  //被投诉对象ID,机构人员身份证号或机构名称
  private String complaintObjectId;
  //违规项
  private String item;
  //投诉内容
  private String complaintContent;
  //投诉资料（id，类型描述）
  private Object complaintMaterial;

  private String agencyCode;
  private String personCode;

  private String taskNumber;

  private String materialId;
  private String materialType;
  private String materialInfo;

  private String complaintAgencyName;
  private String complaintPersonName;

  private List<Map<String, String>> fileList = new ArrayList<>();

  public Date getComplaintTime() {
    return complaintTime;
  }

  public void setComplaintTime(Date complaintTime) {
    this.complaintTime = complaintTime;
  }

  public String getComplainantName() {
    return complainantName;
  }

  public void setComplainantName(String complainantName) {
    this.complainantName = complainantName;
  }

  public String getComplainantMobile() {
    return complainantMobile;
  }

  public void setComplainantMobile(String complainantMobile) {
    this.complainantMobile = complainantMobile;
  }

  public String getIdCard() {
    return idCard;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard;
  }

  public String getInsuredPersonName() {
    return insuredPersonName;
  }

  public void setInsuredPersonName(String insuredPersonName) {
    this.insuredPersonName = insuredPersonName;
  }

  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getSecurityNumber() {
    return securityNumber;
  }

  public void setSecurityNumber(String securityNumber) {
    this.securityNumber = securityNumber;
  }

  public String getAgencyCode() {
    return agencyCode;
  }

  public void setAgencyCode(String agencyCode) {
    this.agencyCode = agencyCode;
  }

  public String getPersonCode() {
    return personCode;
  }

  public void setPersonCode(String personCode) {
    this.personCode = personCode;
  }

  public String getTaskNumber() {
    return taskNumber;
  }

  public void setTaskNumber(String taskNumber) {
    this.taskNumber = taskNumber;
  }

  public String getMaterialId() {
    return materialId;
  }

  public void setMaterialId(String materialId) {
    this.materialId = materialId;
  }

  public String getMaterialType() {
    return materialType;
  }

  public void setMaterialType(String materialType) {
    this.materialType = materialType;
  }

  public String getMaterialInfo() {
    return materialInfo;
  }

  public void setMaterialInfo(String materialInfo) {
    this.materialInfo = materialInfo;
  }

  public String getComplaintAgencyName() {
    return complaintAgencyName;
  }

  public void setComplaintAgencyName(String complaintAgencyName) {
    this.complaintAgencyName = complaintAgencyName;
  }

  public String getComplaintPersonName() {
    return complaintPersonName;
  }

  public void setComplaintPersonName(String complaintPersonName) {
    this.complaintPersonName = complaintPersonName;
  }

  public List<Map<String, String>> getFileList() {
    return fileList;
  }

  public void setFileList(List<Map<String, String>> fileList) {
    this.fileList = fileList;
  }

  public int getComplainantType() {
    return complainantType;
  }

  public void setComplainantType(int complainantType) {
    this.complainantType = complainantType;
  }

  public String getComplainantId() {
    return complainantId;
  }

  public void setComplainantId(String complainantId) {
    this.complainantId = complainantId;
  }

  public long getComplaintObjectType() {
    return complaintObjectType;
  }

  public void setComplaintObjectType(long complaintObjectType) {
    this.complaintObjectType = complaintObjectType;
  }

  public String getComplaintObjectId() {
    return complaintObjectId;
  }

  public void setComplaintObjectId(String complaintObjectId) {
    this.complaintObjectId = complaintObjectId;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public String getComplaintContent() {
    return complaintContent;
  }

  public void setComplaintContent(String complaintContent) {
    this.complaintContent = complaintContent;
  }

  public Object getComplaintMaterial() {
    return complaintMaterial;
  }

  public void setComplaintMaterial(Object complaintMaterial) {
    this.complaintMaterial = complaintMaterial;
  }

  @Override
  public String toString() {
    return "MobileCompliainDO [complainantType="
        + complainantType
        + ", complaintTime="
        + complaintTime
        + ", complainantId="
        + complainantId
        + ", complainantName="
        + complainantName
        + ", complainantMobile="
        + complainantMobile
        + ", idCard="
        + idCard
        + ", insuredPersonName="
        + insuredPersonName
        + ", mobile="
        + mobile
        + ", address="
        + address
        + ", securityNumber="
        + securityNumber
        + ", complaintObjectType="
        + complaintObjectType
        + ", complaintObjectId="
        + complaintObjectId
        + ", item="
        + item
        + ", complaintContent="
        + complaintContent
        + ", complaintMaterial="
        + complaintMaterial
        + ", agencyCode="
        + agencyCode
        + ", personCode="
        + personCode
        + ", taskNumber="
        + taskNumber
        + ", materialId="
        + materialId
        + ", materialType="
        + materialType
        + ", materialInfo="
        + materialInfo
        + ", complaintAgencyName="
        + complaintAgencyName
        + ", complaintPersonName="
        + complaintPersonName
        + ", fileList="
        + fileList
        + "]";
  }
}
