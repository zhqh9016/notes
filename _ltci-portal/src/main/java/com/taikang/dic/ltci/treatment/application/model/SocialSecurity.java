package com.taikang.dic.ltci.treatment.application.model;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class SocialSecurity {

  private String insuredPersonName;
  private String age;
  private String nation;
  private String idCard;
  private String securityNumber;
  private Date birthday;
  private String treatment;
  private String errorReasonCode;
  private String errorReason;

  public String getInsuredPersonName() {
    return insuredPersonName;
  }

  public void setInsuredPersonName(String insuredPersonName) {
    this.insuredPersonName = insuredPersonName;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getNation() {
    return nation;
  }

  public void setNation(String nation) {
    this.nation = nation;
  }

  public String getIdCard() {
    return idCard;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard;
  }

  public String getSecurityNumber() {
    return securityNumber;
  }

  public void setSecurityNumber(String securityNumber) {
    this.securityNumber = securityNumber;
  }

  public LocalDate getBirthday() {
    return date2LocalDate(birthday);
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getTreatment() {
    return treatment;
  }

  public void setTreatment(String treatment) {
    this.treatment = treatment;
  }

  public String getErrorReasonCode() {
    return errorReasonCode;
  }

  public void setErrorReasonCode(String errorReasonCode) {
    this.errorReasonCode = errorReasonCode;
  }

  public String getErrorReason() {
    return errorReason;
  }

  public void setErrorReason(String errorReason) {
    this.errorReason = errorReason;
  }

  @Override
  public String toString() {
    return "SocialSecurity [insuredPersonName="
        + insuredPersonName
        + ", age="
        + age
        + ", nation="
        + nation
        + ", idCard="
        + idCard
        + ", securityNumber="
        + securityNumber
        + ", birthday="
        + birthday
        + ", treatment="
        + treatment
        + ", errorReasonCode="
        + errorReasonCode
        + ", errorReason="
        + errorReason
        + "]";
  }

  public SocialSecurity() {
    super();
    // TODO Auto-generated constructor stub
  }

  public SocialSecurity(
      String insuredPersonName,
      String age,
      String nation,
      String idCard,
      String securityNumber,
      Date birthday,
      String treatment,
      String errorReasonCode,
      String errorReason) {
    super();
    this.insuredPersonName = insuredPersonName;
    this.age = age;
    this.nation = nation;
    this.idCard = idCard;
    this.securityNumber = securityNumber;
    this.birthday = birthday;
    this.treatment = treatment;
    this.errorReasonCode = errorReasonCode;
    this.errorReason = errorReason;
  }

  public LocalDate date2LocalDate(Date inputDate) {
    if (inputDate == null) {
      return null;
    }
    Instant instant = inputDate.toInstant();
    ZoneId zoneId = ZoneId.systemDefault();
    ZonedDateTime zonedDateTime = instant.atZone(zoneId);
    return zonedDateTime.toLocalDate();
  }
}
