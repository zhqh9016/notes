package com.taikang.dic.ltci.model;

import java.util.Date;

public class CheckOutDO {
  //长护登记流水号
  private String inRecorduuid;
  //医疗类别
  private String careType;
  //病历信息
  private String rxInfo;
  //科室名称
  private String department;
  //床位号
  private String bedNum;
  //经办人
  private String operator;
  //参保人姓名
  private String insuredPersonName;
  //参保人身份证号
  private String idCard;
  //参保人社保卡号
  private String securityNumber;
  //机构编号
  private String evaluateAgencyCode;
  //退出原因编码,出院原因
  private String signOutReason;
  //其它原因说明
  private String otherReason;
  //退出时间，出院时间 signOutTime东软
  private Date realOutDate;
  //去向
  private String direction;
  //退出来源（经办、专业服务）
  private String outFrom;

  private String operatedBy;
  private Date operatedTime;

  public String getInsuredPersonName() {
    return insuredPersonName;
  }

  public void setInsuredPersonName(String insuredPersonName) {
    this.insuredPersonName = insuredPersonName;
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

  public String getEvaluateAgencyCode() {
    return evaluateAgencyCode;
  }

  public void setEvaluateAgencyCode(String evaluateAgencyCode) {
    this.evaluateAgencyCode = evaluateAgencyCode;
  }

  public String getSignOutReason() {
    return signOutReason;
  }

  public void setSignOutReason(String signOutReason) {
    this.signOutReason = signOutReason;
  }

  public String getOtherReason() {
    return otherReason;
  }

  public void setOtherReason(String otherReason) {
    this.otherReason = otherReason;
  }

  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public String getOutFrom() {
    return outFrom;
  }

  public void setOutFrom(String outFrom) {
    this.outFrom = outFrom;
  }

  public String getInRecorduuid() {
    return inRecorduuid;
  }

  public void setInRecorduuid(String inRecorduuid) {
    this.inRecorduuid = inRecorduuid;
  }

  public String getCareType() {
    return careType;
  }

  public void setCareType(String careType) {
    this.careType = careType;
  }

  public String getRxInfo() {
    return rxInfo;
  }

  public void setRxInfo(String rxInfo) {
    this.rxInfo = rxInfo;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getBedNum() {
    return bedNum;
  }

  public void setBedNum(String bedNum) {
    this.bedNum = bedNum;
  }

  public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }

  public Date getRealOutDate() {
    return realOutDate;
  }

  public void setRealOutDate(Date realOutDate) {
    this.realOutDate = realOutDate;
  }

  public String getOperatedBy() {
    return operatedBy;
  }

  public void setOperatedBy(String operatedBy) {
    this.operatedBy = operatedBy;
  }

  public Date getOperatedTime() {
    return operatedTime;
  }

  public void setOperatedTime(Date operatedTime) {
    this.operatedTime = operatedTime;
  }
}
