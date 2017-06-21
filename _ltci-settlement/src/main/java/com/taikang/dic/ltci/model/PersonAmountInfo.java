package com.taikang.dic.ltci.model;

/**
 * 个人费用预结算/结算个人基本信息入参
 *
 * @author itw_zhangqh
 */
public class PersonAmountInfo {
  protected String balanceDate;
  private String inRecorduuid;
  private String isAccountUse;
  private String isbBalance;
  private String operator;
  private String receiptNum;
  private String reimbType;
  private String uniqueNumber;

  public String getBalanceDate() {
    return balanceDate;
  }

  public void setBalanceDate(String balanceDate) {
    this.balanceDate = balanceDate;
  }

  public String getInRecorduuid() {
    return inRecorduuid;
  }

  public void setInRecorduuid(String inRecorduuid) {
    this.inRecorduuid = inRecorduuid;
  }

  public String getIsAccountUse() {
    return isAccountUse;
  }

  public void setIsAccountUse(String isAccountUse) {
    this.isAccountUse = isAccountUse;
  }

  public String getIsbBalance() {
    return isbBalance;
  }

  public void setIsbBalance(String isbBalance) {
    this.isbBalance = isbBalance;
  }

  public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }

  public String getReceiptNum() {
    return receiptNum;
  }

  public void setReceiptNum(String receiptNum) {
    this.receiptNum = receiptNum;
  }

  public String getReimbType() {
    return reimbType;
  }

  public void setReimbType(String reimbType) {
    this.reimbType = reimbType;
  }

  public String getUniqueNumber() {
    return uniqueNumber;
  }

  public void setUniqueNumber(String uniqueNumber) {
    this.uniqueNumber = uniqueNumber;
  }
}
