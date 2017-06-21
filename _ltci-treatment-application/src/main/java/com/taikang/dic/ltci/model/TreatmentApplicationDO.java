package com.taikang.dic.ltci.model;

import java.util.Date;

/**
 * @author itw_xuxf
 * @description
 * @version 创建时间：2017年3月30日上午9:26:46
 */
public class TreatmentApplicationDO extends BaseModel {
  /** */
  private static final long serialVersionUID = 1L;

  //待遇申请人名称
  private String insuredPersonName;
  //参保人编号
  private String insuredPersonCode;

  private String nation;
  //参保人性别
  private String insuredPersonGender;
  //出生日期
  private Date birthday;
  //社保卡号
  private String securityNumber;

  private String securityPersonalNumber;
  //身份证号
  private String idCard;

  private String personnelIdentityCode;

  private String personnelIdentityName;

  private String email;

  private String orgName;

  private String married;

  private String educationid;

  private String politicsid;

  private String occupationid;
  //待遇申请ID
  private String applicationid;
  //待遇申请编号
  private String applicationCode;

  private String mobile;
  //省份
  private String provinceCode;
  //城市
  private String cityCode;
  //地区、县
  private String areaCode;
  //现住地址
  private String address;
  //身份类型
  private String deputyName;

  private String deputyIdType;

  private String deputyIdCard;

  private String deputyAddress;

  private String deputyMobile;
  //代理人身份证扫描件
  private String deputyIdCardScan;

  private String bidType;

  private String disease;

  private String isTaskDeadline;

  private String isRelativeCared;

  private String diseaseCause;
  //社保卡扫描件
  private String securityNumberScan;
  //身份证扫描件
  private String idCardScan;
  //病例扫描件
  private String caseHistoryScan;
  //长护待遇申请表
  private String applicationFormScan;
  //来源
  private String sources;
  //申请状态
  private String applicationStatus;

  private String applicationReason;

  private String remark;
  //统筹区
  private String siArea;

  private Long version;

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public String getInsuredPersonName() {
    return insuredPersonName;
  }

  public void setInsuredPersonName(String insuredPersonName) {
    this.insuredPersonName = insuredPersonName;
  }

  public String getInsuredPersonCode() {
    return insuredPersonCode;
  }

  public void setInsuredPersonCode(String insuredPersonCode) {
    this.insuredPersonCode = insuredPersonCode;
  }

  public String getNation() {
    return nation;
  }

  public void setNation(String nation) {
    this.nation = nation;
  }

  public String getInsuredPersonGender() {
    return insuredPersonGender;
  }

  public void setInsuredPersonGender(String insuredPersonGender) {
    this.insuredPersonGender = insuredPersonGender;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getSecurityNumber() {
    return securityNumber;
  }

  public void setSecurityNumber(String securityNumber) {
    this.securityNumber = securityNumber;
  }

  public String getSecurityPersonalNumber() {
    return securityPersonalNumber;
  }

  public void setSecurityPersonalNumber(String securityPersonalNumber) {
    this.securityPersonalNumber = securityPersonalNumber;
  }

  public String getIdCard() {
    return idCard;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getOrgName() {
    return orgName;
  }

  public void setOrgName(String orgName) {
    this.orgName = orgName;
  }

  public String getMarried() {
    return married;
  }

  public void setMarried(String married) {
    this.married = married;
  }

  public String getEducationid() {
    return educationid;
  }

  public void setEducationid(String educationid) {
    this.educationid = educationid;
  }

  public String getPoliticsid() {
    return politicsid;
  }

  public void setPoliticsid(String politicsid) {
    this.politicsid = politicsid;
  }

  public String getOccupationid() {
    return occupationid;
  }

  public void setOccupationid(String occupationid) {
    this.occupationid = occupationid;
  }

  public String getProvinceCode() {
    return provinceCode;
  }

  public void setProvinceCode(String provinceCode) {
    this.provinceCode = provinceCode;
  }

  public String getCityCode() {
    return cityCode;
  }

  public void setCityCode(String cityCode) {
    this.cityCode = cityCode;
  }

  public String getAreaCode() {
    return areaCode;
  }

  public void setAreaCode(String areaCode) {
    this.areaCode = areaCode;
  }

  public String getApplicationid() {
    return applicationid;
  }

  public void setApplicationid(String applicationid) {
    this.applicationid = applicationid;
  }

  public String getApplicationCode() {
    return applicationCode;
  }

  public void setApplicationCode(String applicationCode) {
    this.applicationCode = applicationCode;
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

  public String getDeputyName() {
    return deputyName;
  }

  public void setDeputyName(String deputyName) {
    this.deputyName = deputyName;
  }

  public String getDeputyIdType() {
    return deputyIdType;
  }

  public void setDeputyIdType(String deputyIdType) {
    this.deputyIdType = deputyIdType;
  }

  public String getDeputyIdCard() {
    return deputyIdCard;
  }

  public void setDeputyIdCard(String deputyIdCard) {
    this.deputyIdCard = deputyIdCard;
  }

  public String getDeputyAddress() {
    return deputyAddress;
  }

  public void setDeputyAddress(String deputyAddress) {
    this.deputyAddress = deputyAddress;
  }

  public String getDeputyMobile() {
    return deputyMobile;
  }

  public void setDeputyMobile(String deputyMobile) {
    this.deputyMobile = deputyMobile;
  }

  public String getDeputyIdCardScan() {
    return deputyIdCardScan;
  }

  public void setDeputyIdCardScan(String deputyIdCardScan) {
    this.deputyIdCardScan = deputyIdCardScan;
  }

  public String getBidType() {
    return bidType;
  }

  public void setBidType(String bidType) {
    this.bidType = bidType;
  }

  public String getDisease() {
    return disease;
  }

  public void setDisease(String disease) {
    this.disease = disease;
  }

  public String getIsTaskDeadline() {
    return isTaskDeadline;
  }

  public void setIsTaskDeadline(String isTaskDeadline) {
    this.isTaskDeadline = isTaskDeadline;
  }

  public String getIsRelativeCared() {
    return isRelativeCared;
  }

  public void setIsRelativeCared(String isRelativeCared) {
    this.isRelativeCared = isRelativeCared;
  }

  public String getDiseaseCause() {
    return diseaseCause;
  }

  public void setDiseaseCause(String diseaseCause) {
    this.diseaseCause = diseaseCause;
  }

  public String getSecurityNumberScan() {
    return securityNumberScan;
  }

  public void setSecurityNumberScan(String securityNumberScan) {
    this.securityNumberScan = securityNumberScan;
  }

  public String getIdCardScan() {
    return idCardScan;
  }

  public void setIdCardScan(String idCardScan) {
    this.idCardScan = idCardScan;
  }

  public String getCaseHistoryScan() {
    return caseHistoryScan;
  }

  public void setCaseHistoryScan(String caseHistoryScan) {
    this.caseHistoryScan = caseHistoryScan;
  }

  public String getApplicationFormScan() {
    return applicationFormScan;
  }

  public void setApplicationFormScan(String applicationFormScan) {
    this.applicationFormScan = applicationFormScan;
  }

  public String getSources() {
    return sources;
  }

  public void setSources(String sources) {
    this.sources = sources;
  }

  public String getApplicationStatus() {
    return applicationStatus;
  }

  public void setApplicationStatus(String applicationStatus) {
    this.applicationStatus = applicationStatus;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getApplicationReason() {
    return applicationReason;
  }

  public void setApplicationReason(String applicationReason) {
    this.applicationReason = applicationReason;
  }

  public String getSiArea() {
    return siArea;
  }

  public void setSiArea(String siArea) {
    this.siArea = siArea;
  }

  @Override
  public String toString() {
    return "TreatmentApplicationDO [insuredPersonName="
        + insuredPersonName
        + ", insuredPersonCode="
        + insuredPersonCode
        + ", nation="
        + nation
        + ", insuredPersonGender="
        + insuredPersonGender
        + ", birthday="
        + birthday
        + ", securityNumber="
        + securityNumber
        + ", securityPersonalNumber="
        + securityPersonalNumber
        + ", idCard="
        + idCard
        + ", personnelIdentityCode="
        + personnelIdentityCode
        + ", personnelIdentityName="
        + personnelIdentityName
        + ", email="
        + email
        + ", orgName="
        + orgName
        + ", married="
        + married
        + ", educationid="
        + educationid
        + ", politicsid="
        + politicsid
        + ", occupationid="
        + occupationid
        + ", applicationid="
        + applicationid
        + ", applicationCode="
        + applicationCode
        + ", mobile="
        + mobile
        + ", provinceCode="
        + provinceCode
        + ", cityCode="
        + cityCode
        + ", areaCode="
        + areaCode
        + ", address="
        + address
        + ", deputyName="
        + deputyName
        + ", deputyIdType="
        + deputyIdType
        + ", deputyIdCard="
        + deputyIdCard
        + ", deputyAddress="
        + deputyAddress
        + ", deputyMobile="
        + deputyMobile
        + ", deputyIdCardScan="
        + deputyIdCardScan
        + ", bidType="
        + bidType
        + ", disease="
        + disease
        + ", isTaskDeadline="
        + isTaskDeadline
        + ", isRelativeCared="
        + isRelativeCared
        + ", diseaseCause="
        + diseaseCause
        + ", securityNumberScan="
        + securityNumberScan
        + ", idCardScan="
        + idCardScan
        + ", caseHistoryScan="
        + caseHistoryScan
        + ", applicationFormScan="
        + applicationFormScan
        + ", sources="
        + sources
        + ", applicationStatus="
        + applicationStatus
        + ", applicationReason="
        + applicationReason
        + ", remark="
        + remark
        + "]";
  }
}
