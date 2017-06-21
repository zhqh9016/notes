package com.taikang.dic.ltci.model;
/** 页面上的一些数据 因为拆库 供需要通过微服务直接查询调用的 do */
public class ApplicationSimpleDO {
  private String insuredPersonCode;
  private String idCard;
  private String insuredPersonName;
  private String address;
  private String applicationFormScan;
  private String applicationCode;
  private String securityNumber;

  public String getSecurityNumber() {
    return securityNumber;
  }

  public void setSecurityNumber(String securityNumber) {
    this.securityNumber = securityNumber;
  }

  public String getInsuredPersonCode() {
    return insuredPersonCode;
  }

  public void setInsuredPersonCode(String insuredPersonCode) {
    this.insuredPersonCode = insuredPersonCode;
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getApplicationFormScan() {
    return applicationFormScan;
  }

  public void setApplicationFormScan(String applicationFormScan) {
    this.applicationFormScan = applicationFormScan;
  }

  public String getApplicationCode() {
    return applicationCode;
  }

  public void setApplicationCode(String applicationCode) {
    this.applicationCode = applicationCode;
  }
}
