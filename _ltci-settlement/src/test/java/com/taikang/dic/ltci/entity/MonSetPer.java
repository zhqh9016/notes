package com.taikang.dic.ltci.entity;

import java.math.BigDecimal;
import java.util.Date;

public class MonSetPer {

  private String perSetCode;

  private String inRecorduuid;

  private String receiptNum;

  private String setDate;

  private String reimbType;

  private String isAccountUse;

  private String orgCode;

  private String orgName;

  private String socSecNum;

  private String beCarePersonCardNum;

  private Integer cardType;

  private String nurseObjName;

  private Integer nurseObjSex;

  private Date nurseStarttime;

  private Date nurseEndtime;

  private BigDecimal nurseTotalAmount;

  private BigDecimal siPay;

  private BigDecimal paySelf;

  private BigDecimal expenseSelf;

  private BigDecimal accountPay;

  private BigDecimal bankCardPay;

  private BigDecimal unrFee;

  private BigDecimal overLimitFee;

  private String siArea;

  public String getPerSetCode() {
    return perSetCode;
  }

  public void setPerSetCode(String perSetCode) {
    this.perSetCode = perSetCode == null ? null : perSetCode.trim();
  }

  public String getInRecorduuid() {
    return inRecorduuid;
  }

  public void setInRecorduuid(String inRecorduuid) {
    this.inRecorduuid = inRecorduuid == null ? null : inRecorduuid.trim();
  }

  public String getReceiptNum() {
    return receiptNum;
  }

  public void setReceiptNum(String receiptNum) {
    this.receiptNum = receiptNum == null ? null : receiptNum.trim();
  }

  public String getSetDate() {
    return setDate;
  }

  public void setSetDate(String setDate) {
    this.setDate = setDate == null ? null : setDate.trim();
  }

  public String getReimbType() {
    return reimbType;
  }

  public void setReimbType(String reimbType) {
    this.reimbType = reimbType == null ? null : reimbType.trim();
  }

  public String getIsAccountUse() {
    return isAccountUse;
  }

  public void setIsAccountUse(String isAccountUse) {
    this.isAccountUse = isAccountUse == null ? null : isAccountUse.trim();
  }

  public String getOrgCode() {
    return orgCode;
  }

  public void setOrgCode(String orgCode) {
    this.orgCode = orgCode == null ? null : orgCode.trim();
  }

  public String getOrgName() {
    return orgName;
  }

  public void setOrgName(String orgName) {
    this.orgName = orgName == null ? null : orgName.trim();
  }

  public String getSocSecNum() {
    return socSecNum;
  }

  public void setSocSecNum(String socSecNum) {
    this.socSecNum = socSecNum == null ? null : socSecNum.trim();
  }

  public String getBeCarePersonCardNum() {
    return beCarePersonCardNum;
  }

  public void setBeCarePersonCardNum(String beCarePersonCardNum) {
    this.beCarePersonCardNum = beCarePersonCardNum == null ? null : beCarePersonCardNum.trim();
  }

  public Integer getCardType() {
    return cardType;
  }

  public void setCardType(Integer cardType) {
    this.cardType = cardType;
  }

  public String getNurseObjName() {
    return nurseObjName;
  }

  public void setNurseObjName(String nurseObjName) {
    this.nurseObjName = nurseObjName == null ? null : nurseObjName.trim();
  }

  public Integer getNurseObjSex() {
    return nurseObjSex;
  }

  public void setNurseObjSex(Integer nurseObjSex) {
    this.nurseObjSex = nurseObjSex;
  }

  public Date getNurseStarttime() {
    return nurseStarttime;
  }

  public void setNurseStarttime(Date nurseStarttime) {
    this.nurseStarttime = nurseStarttime;
  }

  public Date getNurseEndtime() {
    return nurseEndtime;
  }

  public void setNurseEndtime(Date nurseEndtime) {
    this.nurseEndtime = nurseEndtime;
  }

  public BigDecimal getNurseTotalAmount() {
    return nurseTotalAmount;
  }

  public void setNurseTotalAmount(BigDecimal nurseTotalAmount) {
    this.nurseTotalAmount = nurseTotalAmount;
  }

  public BigDecimal getSiPay() {
    return siPay;
  }

  public void setSiPay(BigDecimal siPay) {
    this.siPay = siPay;
  }

  public BigDecimal getPaySelf() {
    return paySelf;
  }

  public void setPaySelf(BigDecimal paySelf) {
    this.paySelf = paySelf;
  }

  public BigDecimal getExpenseSelf() {
    return expenseSelf;
  }

  public void setExpenseSelf(BigDecimal expenseSelf) {
    this.expenseSelf = expenseSelf;
  }

  public BigDecimal getAccountPay() {
    return accountPay;
  }

  public void setAccountPay(BigDecimal accountPay) {
    this.accountPay = accountPay;
  }

  public BigDecimal getBankCardPay() {
    return bankCardPay;
  }

  public void setBankCardPay(BigDecimal bankCardPay) {
    this.bankCardPay = bankCardPay;
  }

  public BigDecimal getUnrFee() {
    return unrFee;
  }

  public void setUnrFee(BigDecimal unrFee) {
    this.unrFee = unrFee;
  }

  public BigDecimal getOverLimitFee() {
    return overLimitFee;
  }

  public void setOverLimitFee(BigDecimal overLimitFee) {
    this.overLimitFee = overLimitFee;
  }

  public String getSiArea() {
    return siArea;
  }

  public void setSiArea(String siArea) {
    this.siArea = siArea == null ? null : siArea.trim();
  }
}
