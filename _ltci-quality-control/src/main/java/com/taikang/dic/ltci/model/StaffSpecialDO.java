package com.taikang.dic.ltci.model;

public class StaffSpecialDO {
  private String staffCode;

  private String staffName;

  private String agencyCode;
  private String agencyName;

  private String staffPhone;
  private Integer credentialType;

  private String credentialNumber;

  private String agencyAddressDetail;

  public String getAgencyName() {
    return agencyName;
  }

  public void setAgencyName(String agencyName) {
    this.agencyName = agencyName;
  }

  public String getStaffCode() {
    return staffCode;
  }

  public void setStaffCode(String staffCode) {
    this.staffCode = staffCode;
  }

  public String getStaffName() {
    return staffName;
  }

  public void setStaffName(String staffName) {
    this.staffName = staffName;
  }

  public String getAgencyCode() {
    return agencyCode;
  }

  public void setAgencyCode(String agencyCode) {
    this.agencyCode = agencyCode;
  }

  public String getStaffPhone() {
    return staffPhone;
  }

  public void setStaffPhone(String staffPhone) {
    this.staffPhone = staffPhone;
  }

  public Integer getCredentialType() {
    return credentialType;
  }

  public void setCredentialType(Integer credentialType) {
    this.credentialType = credentialType;
  }

  public String getCredentialNumber() {
    return credentialNumber;
  }

  public void setCredentialNumber(String credentialNumber) {
    this.credentialNumber = credentialNumber;
  }

  public String getAgencyAddressDetail() {
    return agencyAddressDetail;
  }

  public void setAgencyAddressDetail(String agencyAddressDetail) {
    this.agencyAddressDetail = agencyAddressDetail;
  }
}
