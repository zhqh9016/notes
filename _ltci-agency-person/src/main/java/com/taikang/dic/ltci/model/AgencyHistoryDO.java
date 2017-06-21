package com.taikang.dic.ltci.model;

import java.util.Date;

public class AgencyHistoryDO extends BaseModel {
  private static final long serialVersionUID = 1L;

  private String serialNum;

  private String actionType;

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

  private Integer validState;

  private Integer ownershipForm;

  private String practiceLicense;

  private String agencyRegistrationNum;

  private String legalRepresentative;

  private String legalPapersType;

  private String legalIdCard;

  private String legalPhoneNo;

  private String agencyServiceContact;

  private String agencyContactPhone;

  private String agencyContactEmail;

  private String serviceContent;

  private Integer agencyBedNum;

  private Integer homeServiceNum;

  private Double constructionArea;

  private String remark;

  private String agencyCoordinates;

  private String agencyApplicat;

  private Date agencyApplyDate;

  private Integer advancedDoctorNum;

  private Integer intermediateDoctorNum;

  private Integer primaryDoctorNum;

  private Integer advancedNurseNum;

  private Integer intermediateNurseNum;

  private Integer primaryNurseNum;

  private Integer advancedCarerNum;

  private Integer intermediateCarerNum;

  private Integer primaryCarerNum;

  private Integer advancedMiscNum;

  private Integer intermediateMiscNum;

  private Integer primaryMiscNum;

  private String operatedBy;

  private String operatedOrg;

  private Date operatedTime;

  private String createdBy;

  private String createdOrg;

  private Date createdTime;

  private String cause;

  private Integer noDoctorNum;

  private Integer noNurseNum;

  private Integer noCarerNum;

  private Integer noMiscNum;

  public String getSerialNum() {
    return serialNum;
  }

  public void setSerialNum(String serialNum) {
    this.serialNum = serialNum == null ? null : serialNum.trim();
  }

  public String getActionType() {
    return actionType;
  }

  public void setActionType(String actionType) {
    this.actionType = actionType == null ? null : actionType.trim();
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

  public Integer getValidState() {
    return validState;
  }

  public void setValidState(Integer validState) {
    this.validState = validState;
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

  public String getAgencyRegistrationNum() {
    return agencyRegistrationNum;
  }

  public void setAgencyRegistrationNum(String agencyRegistrationNum) {
    this.agencyRegistrationNum =
        agencyRegistrationNum == null ? null : agencyRegistrationNum.trim();
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

  public String getServiceContent() {
    return serviceContent;
  }

  public void setServiceContent(String serviceContent) {
    this.serviceContent = serviceContent == null ? null : serviceContent.trim();
  }

  public Integer getAgencyBedNum() {
    return agencyBedNum;
  }

  public void setAgencyBedNum(Integer agencyBedNum) {
    this.agencyBedNum = agencyBedNum;
  }

  public Integer getHomeServiceNum() {
    return homeServiceNum;
  }

  public void setHomeServiceNum(Integer homeServiceNum) {
    this.homeServiceNum = homeServiceNum;
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

  public String getAgencyApplicat() {
    return agencyApplicat;
  }

  public void setAgencyApplicat(String agencyApplicat) {
    this.agencyApplicat = agencyApplicat == null ? null : agencyApplicat.trim();
  }

  public Date getAgencyApplyDate() {
    return agencyApplyDate;
  }

  public void setAgencyApplyDate(Date agencyApplyDate) {
    this.agencyApplyDate = agencyApplyDate;
  }

  public Integer getAdvancedDoctorNum() {
    return advancedDoctorNum;
  }

  public void setAdvancedDoctorNum(Integer advancedDoctorNum) {
    this.advancedDoctorNum = advancedDoctorNum;
  }

  public Integer getIntermediateDoctorNum() {
    return intermediateDoctorNum;
  }

  public void setIntermediateDoctorNum(Integer intermediateDoctorNum) {
    this.intermediateDoctorNum = intermediateDoctorNum;
  }

  public Integer getPrimaryDoctorNum() {
    return primaryDoctorNum;
  }

  public void setPrimaryDoctorNum(Integer primaryDoctorNum) {
    this.primaryDoctorNum = primaryDoctorNum;
  }

  public Integer getAdvancedNurseNum() {
    return advancedNurseNum;
  }

  public void setAdvancedNurseNum(Integer advancedNurseNum) {
    this.advancedNurseNum = advancedNurseNum;
  }

  public Integer getIntermediateNurseNum() {
    return intermediateNurseNum;
  }

  public void setIntermediateNurseNum(Integer intermediateNurseNum) {
    this.intermediateNurseNum = intermediateNurseNum;
  }

  public Integer getPrimaryNurseNum() {
    return primaryNurseNum;
  }

  public void setPrimaryNurseNum(Integer primaryNurseNum) {
    this.primaryNurseNum = primaryNurseNum;
  }

  public Integer getAdvancedCarerNum() {
    return advancedCarerNum;
  }

  public void setAdvancedCarerNum(Integer advancedCarerNum) {
    this.advancedCarerNum = advancedCarerNum;
  }

  public Integer getIntermediateCarerNum() {
    return intermediateCarerNum;
  }

  public void setIntermediateCarerNum(Integer intermediateCarerNum) {
    this.intermediateCarerNum = intermediateCarerNum;
  }

  public Integer getPrimaryCarerNum() {
    return primaryCarerNum;
  }

  public void setPrimaryCarerNum(Integer primaryCarerNum) {
    this.primaryCarerNum = primaryCarerNum;
  }

  public Integer getAdvancedMiscNum() {
    return advancedMiscNum;
  }

  public void setAdvancedMiscNum(Integer advancedMiscNum) {
    this.advancedMiscNum = advancedMiscNum;
  }

  public Integer getIntermediateMiscNum() {
    return intermediateMiscNum;
  }

  public void setIntermediateMiscNum(Integer intermediateMiscNum) {
    this.intermediateMiscNum = intermediateMiscNum;
  }

  public Integer getPrimaryMiscNum() {
    return primaryMiscNum;
  }

  public void setPrimaryMiscNum(Integer primaryMiscNum) {
    this.primaryMiscNum = primaryMiscNum;
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

  public String getCause() {
    return cause;
  }

  public void setCause(String cause) {
    this.cause = cause == null ? null : cause.trim();
  }

  public Integer getNoDoctorNum() {
    return noDoctorNum;
  }

  public void setNoDoctorNum(Integer noDoctorNum) {
    this.noDoctorNum = noDoctorNum;
  }

  public Integer getNoNurseNum() {
    return noNurseNum;
  }

  public void setNoNurseNum(Integer noNurseNum) {
    this.noNurseNum = noNurseNum;
  }

  public Integer getNoCarerNum() {
    return noCarerNum;
  }

  public void setNoCarerNum(Integer noCarerNum) {
    this.noCarerNum = noCarerNum;
  }

  public Integer getNoMiscNum() {
    return noMiscNum;
  }

  public void setNoMiscNum(Integer noMiscNum) {
    this.noMiscNum = noMiscNum;
  }
}
