package com.taikang.dic.ltci.model;

import java.util.Date;

public class AgencyDO extends BaseModel {

  private static final long serialVersionUID = -211742395659036083L;
  private String agencyid;

  private String agencyCode;

  private String orgCode;

  private String agencyName;

  private String provinceCode;

  private String cityCode;

  private String areaCode;

  private String agencyAddressDetail;

  private String agencyType;

  private Integer agencyLevel;

  private Integer agencyState;

  private String agencyServiceType;

  private Integer ownershipForm;

  private String practiceLicense;

  private String legalRepresentative;

  private String legalPapersType;

  private String legalIdCard;

  private String legalPhoneNo;

  private String agencyServiceContact;

  private String agencyContactPhone;

  private String agencyContactEmail;

  private Integer agencyBedNum;

  private Double constructionArea;

  private String remark;

  private String agencyCoordinates;

  private String operatedBy;

  private String operatedOrg;

  private Date operatedTime;

  private String createdBy;

  private String createdOrg;

  private Date createdTime;

  private String secretKey;

  private Integer isValid;

  private Date keyBeginDate;

  private Date keyEndDate;

  public String getAgencyid() {
    return agencyid;
  }

  public void setAgencyid(String agencyid) {
    this.agencyid = agencyid == null ? null : agencyid.trim();
  }

  public String getAgencyCode() {
    return agencyCode;
  }

  public void setAgencyCode(String agencyCode) {
    this.agencyCode = agencyCode == null ? null : agencyCode.trim();
  }

  public String getOrgCode() {
    return orgCode;
  }

  public void setOrgCode(String orgCode) {
    this.orgCode = orgCode == null ? null : orgCode.trim();
  }

  public String getAgencyName() {
    return agencyName;
  }

  public void setAgencyName(String agencyName) {
    this.agencyName = agencyName == null ? null : agencyName.trim();
  }

  public String getProvinceCode() {
    return provinceCode;
  }

  public void setProvinceCode(String provinceCode) {
    this.provinceCode = provinceCode == null ? null : provinceCode.trim();
  }

  public String getCityCode() {
    return cityCode;
  }

  public void setCityCode(String cityCode) {
    this.cityCode = cityCode == null ? null : cityCode.trim();
  }

  public String getAreaCode() {
    return areaCode;
  }

  public void setAreaCode(String areaCode) {
    this.areaCode = areaCode == null ? null : areaCode.trim();
  }

  public String getAgencyAddressDetail() {
    return agencyAddressDetail;
  }

  public void setAgencyAddressDetail(String agencyAddressDetail) {
    this.agencyAddressDetail = agencyAddressDetail == null ? null : agencyAddressDetail.trim();
  }

  public String getAgencyType() {
    return agencyType;
  }

  public void setAgencyType(String agencyType) {
    this.agencyType = agencyType == null ? null : agencyType.trim();
  }

  public Integer getAgencyLevel() {
    return agencyLevel;
  }

  public void setAgencyLevel(Integer agencyLevel) {
    this.agencyLevel = agencyLevel;
  }

  public Integer getAgencyState() {
    return agencyState;
  }

  public void setAgencyState(Integer agencyState) {
    this.agencyState = agencyState;
  }

  public String getAgencyServiceType() {
    return agencyServiceType;
  }

  public void setAgencyServiceType(String agencyServiceType) {
    this.agencyServiceType = agencyServiceType == null ? null : agencyServiceType.trim();
  }

  public Integer getOwnershipForm() {
    return ownershipForm;
  }

  public void setOwnershipForm(Integer ownershipForm) {
    this.ownershipForm = ownershipForm;
  }

  public String getPracticeLicense() {
    return practiceLicense;
  }

  public void setPracticeLicense(String practiceLicense) {
    this.practiceLicense = practiceLicense == null ? null : practiceLicense.trim();
  }

  public String getLegalRepresentative() {
    return legalRepresentative;
  }

  public void setLegalRepresentative(String legalRepresentative) {
    this.legalRepresentative = legalRepresentative == null ? null : legalRepresentative.trim();
  }

  public String getLegalPapersType() {
    return legalPapersType;
  }

  public void setLegalPapersType(String legalPapersType) {
    this.legalPapersType = legalPapersType == null ? null : legalPapersType.trim();
  }

  public String getLegalIdCard() {
    return legalIdCard;
  }

  public void setLegalIdCard(String legalIdCard) {
    this.legalIdCard = legalIdCard == null ? null : legalIdCard.trim();
  }

  public String getLegalPhoneNo() {
    return legalPhoneNo;
  }

  public void setLegalPhoneNo(String legalPhoneNo) {
    this.legalPhoneNo = legalPhoneNo == null ? null : legalPhoneNo.trim();
  }

  public String getAgencyServiceContact() {
    return agencyServiceContact;
  }

  public void setAgencyServiceContact(String agencyServiceContact) {
    this.agencyServiceContact = agencyServiceContact == null ? null : agencyServiceContact.trim();
  }

  public String getAgencyContactPhone() {
    return agencyContactPhone;
  }

  public void setAgencyContactPhone(String agencyContactPhone) {
    this.agencyContactPhone = agencyContactPhone == null ? null : agencyContactPhone.trim();
  }

  public String getAgencyContactEmail() {
    return agencyContactEmail;
  }

  public void setAgencyContactEmail(String agencyContactEmail) {
    this.agencyContactEmail = agencyContactEmail == null ? null : agencyContactEmail.trim();
  }

  public Integer getAgencyBedNum() {
    return agencyBedNum;
  }

  public void setAgencyBedNum(Integer agencyBedNum) {
    this.agencyBedNum = agencyBedNum;
  }

  public Double getConstructionArea() {
    return constructionArea;
  }

  public void setConstructionArea(Double constructionArea) {
    this.constructionArea = constructionArea;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark == null ? null : remark.trim();
  }

  public String getAgencyCoordinates() {
    return agencyCoordinates;
  }

  public void setAgencyCoordinates(String agencyCoordinates) {
    this.agencyCoordinates = agencyCoordinates == null ? null : agencyCoordinates.trim();
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

  public String getSecretKey() {
    return secretKey;
  }

  public void setSecretKey(String secretKey) {
    this.secretKey = secretKey == null ? null : secretKey.trim();
  }

  public Integer getIsValid() {
    return isValid;
  }

  public void setIsValid(Integer isValid) {
    this.isValid = isValid;
  }

  public Date getKeyBeginDate() {
    return keyBeginDate;
  }

  public void setKeyBeginDate(Date keyBeginDate) {
    this.keyBeginDate = keyBeginDate;
  }

  public Date getKeyEndDate() {
    return keyEndDate;
  }

  public void setKeyEndDate(Date keyEndDate) {
    this.keyEndDate = keyEndDate;
  }
}
