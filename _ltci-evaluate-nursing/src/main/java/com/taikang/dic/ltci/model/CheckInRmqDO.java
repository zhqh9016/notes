package com.taikang.dic.ltci.model;

import java.util.Date;

public class CheckInRmqDO extends BaseModel {
  private String inRecorduuid; //长护登记流水号（UUID）",
  private String orgCode; //定点护理机构编号",
  private String evaluateAgencyCode; //":"机构编号",
  private String orgName; //":"定点护理机构名称",
  private String medicalType; //":"医疗类别31 全日居家护理32 非全日居家护理33 养老机构护理34 医疗机构护理",

  private String socSecNum; //"://入院"社会保障号码",
  private String securityNumber; //"://出院 "参保人个人社保卡",

  private String beCarePersonCardNum; //"://入院"护理对象证件号码",
  private String idCard; //"://出院"参保人身份证号 ",

  private String cardType; //":"证件类型",
  private String sCardNo; //":"卡号（卡里）",
  private String psamCardNo; //":"PSAM卡卡号",
  private String securityCardType; //新卡老卡类型

  private String beCarePersonName; //"://入院"护理对象姓名即参保人姓名
  private String insuredPersonName; //"://出院 "参保人姓名",

  private String beCarePersonGender; //":"护理对象性别",
  private Date agreInDate; //":"协议入院日期",
  private Date agreOutDate; //":"协议出院日期",
  private Date realInDate; //":"实际入院日期",
  private Date realOutDate; //":"实际出院日期",
  private String diseaseCode; //":"诊断疾病编码",
  private String diseaseName; //":"诊断疾病名称",
  private String medicalRecord; //":"病历信息",
  private String isRelativeCare; //":"是否亲属照护",
  private String department; //":"科室名称",

  private String bedNum; //":"床位号",
  private String operator; //":"经办人",
  private String allOwnExpenseFlag; //":"全自费标志",
  private String encounterState; //":"护理状态(暂停、恢复)",
  private String signOutReason; //":"退出原因编码",
  private String otherReason; //":"其它原因说明",
  private String direction; //":"去向",
  private String outFrom; //":"退出来源（1:经办、2:专业服务）"

  public String getInRecorduuid() {
    return inRecorduuid;
  }

  public void setInRecorduuid(String inRecorduuid) {
    this.inRecorduuid = inRecorduuid;
  }

  public String getOrgCode() {
    return orgCode;
  }

  public void setOrgCode(String orgCode) {
    this.orgCode = orgCode;
  }

  public String getEvaluateAgencyCode() {
    return evaluateAgencyCode;
  }

  public void setEvaluateAgencyCode(String evaluateAgencyCode) {
    this.evaluateAgencyCode = evaluateAgencyCode;
  }

  public String getOrgName() {
    return orgName;
  }

  public void setOrgName(String orgName) {
    this.orgName = orgName;
  }

  public String getMedicalType() {
    return medicalType;
  }

  public void setMedicalType(String medicalType) {
    this.medicalType = medicalType;
  }

  public String getSocSecNum() {
    return socSecNum;
  }

  public void setSocSecNum(String socSecNum) {
    this.socSecNum = socSecNum;
  }

  public String getSecurityNumber() {
    return securityNumber;
  }

  public void setSecurityNumber(String securityNumber) {
    this.securityNumber = securityNumber;
  }

  public String getBeCarePersonCardNum() {
    return beCarePersonCardNum;
  }

  public void setBeCarePersonCardNum(String beCarePersonCardNum) {
    this.beCarePersonCardNum = beCarePersonCardNum;
  }

  public String getIdCard() {
    return idCard;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard;
  }

  public String getCardType() {
    return cardType;
  }

  public void setCardType(String cardType) {
    this.cardType = cardType;
  }

  public String getsCardNo() {
    return sCardNo;
  }

  public void setsCardNo(String sCardNo) {
    this.sCardNo = sCardNo;
  }

  public String getPsamCardNo() {
    return psamCardNo;
  }

  public void setPsamCardNo(String psamCardNo) {
    this.psamCardNo = psamCardNo;
  }

  public String getBeCarePersonName() {
    return beCarePersonName;
  }

  public void setBeCarePersonName(String beCarePersonName) {
    this.beCarePersonName = beCarePersonName;
  }

  public String getInsuredPersonName() {
    return insuredPersonName;
  }

  public void setInsuredPersonName(String insuredPersonName) {
    this.insuredPersonName = insuredPersonName;
  }

  public String getBeCarePersonGender() {
    return beCarePersonGender;
  }

  public void setBeCarePersonGender(String beCarePersonGender) {
    this.beCarePersonGender = beCarePersonGender;
  }

  public Date getAgreInDate() {
    return agreInDate;
  }

  public void setAgreInDate(Date agreInDate) {
    this.agreInDate = agreInDate;
  }

  public Date getAgreOutDate() {
    return agreOutDate;
  }

  public void setAgreOutDate(Date agreOutDate) {
    this.agreOutDate = agreOutDate;
  }

  public Date getRealInDate() {
    return realInDate;
  }

  public void setRealInDate(Date realInDate) {
    this.realInDate = realInDate;
  }

  public Date getRealOutDate() {
    return realOutDate;
  }

  public void setRealOutDate(Date realOutDate) {
    this.realOutDate = realOutDate;
  }

  public String getDiseaseCode() {
    return diseaseCode;
  }

  public void setDiseaseCode(String diseaseCode) {
    this.diseaseCode = diseaseCode;
  }

  public String getDiseaseName() {
    return diseaseName;
  }

  public void setDiseaseName(String diseaseName) {
    this.diseaseName = diseaseName;
  }

  public String getMedicalRecord() {
    return medicalRecord;
  }

  public void setMedicalRecord(String medicalRecord) {
    this.medicalRecord = medicalRecord;
  }

  public String getIsRelativeCare() {
    return isRelativeCare;
  }

  public void setIsRelativeCare(String isRelativeCare) {
    this.isRelativeCare = isRelativeCare;
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

  public String getAllOwnExpenseFlag() {
    return allOwnExpenseFlag;
  }

  public void setAllOwnExpenseFlag(String allOwnExpenseFlag) {
    this.allOwnExpenseFlag = allOwnExpenseFlag;
  }

  public String getEncounterState() {
    return encounterState;
  }

  public void setEncounterState(String encounterState) {
    this.encounterState = encounterState;
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

  public String getSecurityCardType() {
    return securityCardType;
  }

  public void setSecurityCardType(String securityCardType) {
    this.securityCardType = securityCardType;
  }
}
