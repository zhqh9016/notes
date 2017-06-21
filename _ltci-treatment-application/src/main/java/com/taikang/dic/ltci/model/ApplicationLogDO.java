package com.taikang.dic.ltci.model;

public class ApplicationLogDO extends BaseModel {
  /** */
  private static final long serialVersionUID = 1L;

  private String applicationLogid;

  private String applicationCode;

  private String securityNumber;

  private String securityPersonalNumber;

  private String deputyIdCard;

  private String applicationStatus;

  private String applicationReason;

  public String getApplicationLogid() {
    return applicationLogid;
  }

  public void setApplicationLogid(String applicationLogid) {
    this.applicationLogid = applicationLogid == null ? null : applicationLogid.trim();
  }

  public String getApplicationCode() {
    return applicationCode;
  }

  public void setApplicationCode(String applicationCode) {
    this.applicationCode = applicationCode == null ? null : applicationCode.trim();
  }

  public String getSecurityNumber() {
    return securityNumber;
  }

  public void setSecurityNumber(String securityNumber) {
    this.securityNumber = securityNumber == null ? null : securityNumber.trim();
  }

  public String getSecurityPersonalNumber() {
    return securityPersonalNumber;
  }

  public void setSecurityPersonalNumber(String securityPersonalNumber) {
    this.securityPersonalNumber =
        securityPersonalNumber == null ? null : securityPersonalNumber.trim();
  }

  public String getDeputyIdCard() {
    return deputyIdCard;
  }

  public void setDeputyIdCard(String deputyIdCard) {
    this.deputyIdCard = deputyIdCard == null ? null : deputyIdCard.trim();
  }

  public String getApplicationStatus() {
    return applicationStatus;
  }

  public void setApplicationStatus(String applicationStatus) {
    this.applicationStatus = applicationStatus == null ? null : applicationStatus.trim();
  }

  public String getApplicationReason() {
    return applicationReason;
  }

  public void setApplicationReason(String applicationReason) {
    this.applicationReason = applicationReason == null ? null : applicationReason.trim();
  }
}
