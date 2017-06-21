package com.taikang.dic.ltci.model;

import java.math.BigDecimal;
import java.util.Date;

public class DaySetPerDO extends BaseModel {
  /** */
  private static final long serialVersionUID = 8285237959660573897L;

  private String id;

  private String feeSetCode;

  private String orgSetCode;

  private String inRecorduuid;

  private String invoiceNum;

  private String socSecNum;

  private String beCarePersonCard;

  private Integer cardType;

  private String beCarePersonName;

  private Integer beCarePersonSex;

  private Date feeDate;

  private Date nurseTime;

  private Integer nurseStyle;

  private String orgCode;

  private String orgName;

  private BigDecimal nurseTotalAmount;

  private BigDecimal siPay;

  private BigDecimal paySelf;

  private BigDecimal expenseSelf;

  private BigDecimal accountPay;

  private BigDecimal bankCardPay;

  private BigDecimal unrFee;

  private String chargeLevel;

  private BigDecimal overCost;

  private Integer pubPayStatus;

  private Integer perPayStatus;

  private Integer auditState;

  private Integer isValid;

  private String operatedBy;

  private Date operatedTime;

  private String createdBy;

  private Date createdTime;

  private String createdOrg;

  private String operatedOrg;

  private String siArea;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id == null ? null : id.trim();
  }

  public String getFeeSetCode() {
    return feeSetCode;
  }

  public void setFeeSetCode(String feeSetCode) {
    this.feeSetCode = feeSetCode == null ? null : feeSetCode.trim();
  }

  public String getOrgSetCode() {
    return orgSetCode;
  }

  public void setOrgSetCode(String orgSetCode) {
    this.orgSetCode = orgSetCode == null ? null : orgSetCode.trim();
  }

  public String getInRecorduuid() {
    return inRecorduuid;
  }

  public void setInRecorduuid(String inRecorduuid) {
    this.inRecorduuid = inRecorduuid == null ? null : inRecorduuid.trim();
  }

  public String getInvoiceNum() {
    return invoiceNum;
  }

  public void setInvoiceNum(String invoiceNum) {
    this.invoiceNum = invoiceNum == null ? null : invoiceNum.trim();
  }

  public String getSocSecNum() {
    return socSecNum;
  }

  public void setSocSecNum(String socSecNum) {
    this.socSecNum = socSecNum == null ? null : socSecNum.trim();
  }

  public String getBeCarePersonCard() {
    return beCarePersonCard;
  }

  public void setBeCarePersonCard(String beCarePersonCard) {
    this.beCarePersonCard = beCarePersonCard == null ? null : beCarePersonCard.trim();
  }

  public Integer getCardType() {
    return cardType;
  }

  public void setCardType(Integer cardType) {
    this.cardType = cardType;
  }

  public String getBeCarePersonName() {
    return beCarePersonName;
  }

  public void setBeCarePersonName(String beCarePersonName) {
    this.beCarePersonName = beCarePersonName == null ? null : beCarePersonName.trim();
  }

  public Integer getBeCarePersonSex() {
    return beCarePersonSex;
  }

  public void setBeCarePersonSex(Integer beCarePersonSex) {
    this.beCarePersonSex = beCarePersonSex;
  }

  public Date getFeeDate() {
    return feeDate;
  }

  public void setFeeDate(Date feeDate) {
    this.feeDate = feeDate;
  }

  public Date getNurseTime() {
    return nurseTime;
  }

  public void setNurseTime(Date nurseTime) {
    this.nurseTime = nurseTime;
  }

  public Integer getNurseStyle() {
    return nurseStyle;
  }

  public void setNurseStyle(Integer nurseStyle) {
    this.nurseStyle = nurseStyle;
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

  public String getChargeLevel() {
    return chargeLevel;
  }

  public void setChargeLevel(String chargeLevel) {
    this.chargeLevel = chargeLevel == null ? null : chargeLevel.trim();
  }

  public BigDecimal getOverCost() {
    return overCost;
  }

  public void setOverCost(BigDecimal overCost) {
    this.overCost = overCost;
  }

  public Integer getPubPayStatus() {
    return pubPayStatus;
  }

  public void setPubPayStatus(Integer pubPayStatus) {
    this.pubPayStatus = pubPayStatus;
  }

  public Integer getPerPayStatus() {
    return perPayStatus;
  }

  public void setPerPayStatus(Integer perPayStatus) {
    this.perPayStatus = perPayStatus;
  }

  public Integer getAuditState() {
    return auditState;
  }

  public void setAuditState(Integer auditState) {
    this.auditState = auditState;
  }

  public Integer getIsValid() {
    return isValid;
  }

  public void setIsValid(Integer isValid) {
    this.isValid = isValid;
  }

  public String getOperatedBy() {
    return operatedBy;
  }

  public void setOperatedBy(String operatedBy) {
    this.operatedBy = operatedBy == null ? null : operatedBy.trim();
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

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public String getCreatedOrg() {
    return createdOrg;
  }

  public void setCreatedOrg(String createdOrg) {
    this.createdOrg = createdOrg == null ? null : createdOrg.trim();
  }

  public String getOperatedOrg() {
    return operatedOrg;
  }

  public void setOperatedOrg(String operatedOrg) {
    this.operatedOrg = operatedOrg == null ? null : operatedOrg.trim();
  }

  public String getSiArea() {
    return siArea;
  }

  public void setSiArea(String siArea) {
    this.siArea = siArea == null ? null : siArea.trim();
  }
}
