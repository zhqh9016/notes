package com.taikang.dic.ltci.model;

import java.util.Date;

public class AgencyDO extends BaseModel {
  private String agencyid;

  private String agencyCode;

  private String agencyName;

  private String agencyPhone;

  private String provinceCode;

  private String cityCode;

  private String areaCode;

  private String agencyAddressDetail;

  private Integer isDesignatedAgency;

  private Integer isNursingAgency;

  private Integer agencyType;

  private Integer agencyLevel;

  private Integer agencyRank;

  private String dsignatedAgencyType;

  private Date agencyBeginDate;

  private Date agenctEndDate;

  private Integer ownershipForm;

  private String practiceLicense;

  private String legalRepresentative;

  private String legalPapersType;

  private String legalIdCard;

  private Date legalPapersValidityDate;

  private String legalPhoneNo;

  private String agencyServiceContac;

  private String agencyContactPhone;

  private String agencyContactEmail;

  private Integer agencyBedNum;

  private Double constructionArea;

  private String remark;

  private String secretKey;

  private Date keyBeginDate;

  private Date keyEndDate;

  private String agencyCoordinates;

  private Integer agencyAuditState;

  private Integer isValid;

  private Integer siArea;

  private String operatedBy;

  private String operatedOrg;

  private Date operatedTime;

  private String createdBy;

  private String createdOrg;

  private Date createTime;

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

  public String getAgencyName() {
    return agencyName;
  }

  public void setAgencyName(String agencyName) {
    this.agencyName = agencyName == null ? null : agencyName.trim();
  }

  public String getAgencyPhone() {
    return agencyPhone;
  }

  public void setAgencyPhone(String agencyPhone) {
    this.agencyPhone = agencyPhone == null ? null : agencyPhone.trim();
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

  public Integer getIsDesignatedAgency() {
    return isDesignatedAgency;
  }

  public void setIsDesignatedAgency(Integer isDesignatedAgency) {
    this.isDesignatedAgency = isDesignatedAgency;
  }

  public Integer getIsNursingAgency() {
    return isNursingAgency;
  }

  public void setIsNursingAgency(Integer isNursingAgency) {
    this.isNursingAgency = isNursingAgency;
  }

  public Integer getAgencyType() {
    return agencyType;
  }

  public void setAgencyType(Integer agencyType) {
    this.agencyType = agencyType;
  }

  public Integer getAgencyLevel() {
    return agencyLevel;
  }

  public void setAgencyLevel(Integer agencyLevel) {
    this.agencyLevel = agencyLevel;
  }

  public Integer getAgencyRank() {
    return agencyRank;
  }

  public void setAgencyRank(Integer agencyRank) {
    this.agencyRank = agencyRank;
  }

  public String getDsignatedAgencyType() {
    return dsignatedAgencyType;
  }

  public void setDsignatedAgencyType(String dsignatedAgencyType) {
    this.dsignatedAgencyType = dsignatedAgencyType == null ? null : dsignatedAgencyType.trim();
  }

  public Date getAgencyBeginDate() {
    return agencyBeginDate;
  }

  public void setAgencyBeginDate(Date agencyBeginDate) {
    this.agencyBeginDate = agencyBeginDate;
  }

  public Date getAgenctEndDate() {
    return agenctEndDate;
  }

  public void setAgenctEndDate(Date agenctEndDate) {
    this.agenctEndDate = agenctEndDate;
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

  public Date getLegalPapersValidityDate() {
    return legalPapersValidityDate;
  }

  public void setLegalPapersValidityDate(Date legalPapersValidityDate) {
    this.legalPapersValidityDate = legalPapersValidityDate;
  }

  public String getLegalPhoneNo() {
    return legalPhoneNo;
  }

  public void setLegalPhoneNo(String legalPhoneNo) {
    this.legalPhoneNo = legalPhoneNo == null ? null : legalPhoneNo.trim();
  }

  public String getAgencyServiceContac() {
    return agencyServiceContac;
  }

  public void setAgencyServiceContac(String agencyServiceContac) {
    this.agencyServiceContac = agencyServiceContac == null ? null : agencyServiceContac.trim();
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

  public String getSecretKey() {
    return secretKey;
  }

  public void setSecretKey(String secretKey) {
    this.secretKey = secretKey == null ? null : secretKey.trim();
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

  public String getAgencyCoordinates() {
    return agencyCoordinates;
  }

  public void setAgencyCoordinates(String agencyCoordinates) {
    this.agencyCoordinates = agencyCoordinates == null ? null : agencyCoordinates.trim();
  }

  public Integer getAgencyAuditState() {
    return agencyAuditState;
  }

  public void setAgencyAuditState(Integer agencyAuditState) {
    this.agencyAuditState = agencyAuditState;
  }

  public Integer getIsValid() {
    return isValid;
  }

  public void setIsValid(Integer isValid) {
    this.isValid = isValid;
  }

  public Integer getSiArea() {
    return siArea;
  }

  public void setSiArea(Integer siArea) {
    this.siArea = siArea;
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
