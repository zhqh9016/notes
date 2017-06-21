package com.taikang.dic.ltci.model;

import java.util.Date;

public class NursingTaskSpecialDO {
  private String nursingTaskid;

  private String nursingTaskCode;

  private String evaluateTaskCode;

  private String intentAgency;

  private String insuredPersonCode;

  private String finalAgencyCode;

  private String finalAgencyName;

  private String state; //确认状态

  private String applyType;

  private String isRelativeCared; //是否亲属照顾

  private String remark;

  private String operatedBy;

  private String operatedTime;

  private String operatedOrg;

  private String createdBy;

  private Date createdTime;

  private String createdOrg;

  private Integer isValid;

  private String siArea;

  private String insuredPersonName; //申请人姓名

  private String idCard; //申请人身份证

  private String address; //申请人现住址

  private String evaluateName; //评估员姓名

  private String score; //初评得分

  private String fraction; //专家评定得分

  private String evaluateContent; //专家评估意见详情 json

  private String detailJson; //初评详情 json

  private String accessoryAddress; //专家评估意见ID 专家评定专家意见扫描件id

  private String opinion; //专家评估意见

  private String isReevaluate; //是否重评

  private String reevalueateResult; //重评结果

  private String evaluateAgencyName; //评估机构名称

  private String bidType; //申辦類型

  private String applicationCode;

  private String firstEvaluateCode;

  public String getFirstEvaluateCode() {
    return firstEvaluateCode;
  }

  public void setFirstEvaluateCode(String firstEvaluateCode) {
    this.firstEvaluateCode = firstEvaluateCode;
  }

  public String getApplicationCode() {
    return applicationCode;
  }

  public void setApplicationCode(String applicationCode) {
    this.applicationCode = applicationCode;
  }

  public String getBidType() {
    return bidType;
  }

  public void setBidType(String bidType) {
    this.bidType = bidType;
  }

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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEvaluateName() {
    return evaluateName;
  }

  public void setEvaluateName(String evaluateName) {
    this.evaluateName = evaluateName;
  }

  public String getScore() {
    return score;
  }

  public void setScore(String score) {
    this.score = score;
  }

  public String getFraction() {
    return fraction;
  }

  public void setFraction(String fraction) {
    this.fraction = fraction;
  }

  public String getEvaluateContent() {
    return evaluateContent;
  }

  public void setEvaluateContent(String evaluateContent) {
    this.evaluateContent = evaluateContent;
  }

  public String getDetailJson() {
    return detailJson;
  }

  public void setDetailJson(String detailJson) {
    this.detailJson = detailJson;
  }

  public String getAccessoryAddress() {
    return accessoryAddress;
  }

  public void setAccessoryAddress(String accessoryAddress) {
    this.accessoryAddress = accessoryAddress;
  }

  public String getOpinion() {
    return opinion;
  }

  public void setOpinion(String opinion) {
    this.opinion = opinion;
  }

  public String getIsReevaluate() {
    return isReevaluate;
  }

  public void setIsReevaluate(String isReevaluate) {
    this.isReevaluate = isReevaluate;
  }

  public String getReevalueateResult() {
    return reevalueateResult;
  }

  public void setReevalueateResult(String reevalueateResult) {
    this.reevalueateResult = reevalueateResult;
  }

  public String getEvaluateAgencyName() {
    return evaluateAgencyName;
  }

  public void setEvaluateAgencyName(String evaluateAgencyName) {
    this.evaluateAgencyName = evaluateAgencyName;
  }

  public String getNursingTaskid() {
    return nursingTaskid;
  }

  public void setNursingTaskid(String nursingTaskid) {
    this.nursingTaskid = nursingTaskid == null ? null : nursingTaskid.trim();
  }

  public String getNursingTaskCode() {
    return nursingTaskCode;
  }

  public void setNursingTaskCode(String nursingTaskCode) {
    this.nursingTaskCode = nursingTaskCode == null ? null : nursingTaskCode.trim();
  }

  public String getEvaluateTaskCode() {
    return evaluateTaskCode;
  }

  public void setEvaluateTaskCode(String evaluateTaskCode) {
    this.evaluateTaskCode = evaluateTaskCode == null ? null : evaluateTaskCode.trim();
  }

  public String getIntentAgency() {
    return intentAgency;
  }

  public void setIntentAgency(String intentAgency) {
    this.intentAgency = intentAgency == null ? null : intentAgency.trim();
  }

  public String getInsuredPersonCode() {
    return insuredPersonCode;
  }

  public void setInsuredPersonCode(String insuredPersonCode) {
    this.insuredPersonCode = insuredPersonCode == null ? null : insuredPersonCode.trim();
  }

  public String getFinalAgencyCode() {
    return finalAgencyCode;
  }

  public void setFinalAgencyCode(String finalAgencyCode) {
    this.finalAgencyCode = finalAgencyCode == null ? null : finalAgencyCode.trim();
  }

  public String getFinalAgencyName() {
    return finalAgencyName;
  }

  public void setFinalAgencyName(String finalAgencyName) {
    this.finalAgencyName = finalAgencyName == null ? null : finalAgencyName.trim();
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state == null ? null : state.trim();
  }

  public String getApplyType() {
    return applyType;
  }

  public void setApplyType(String applyType) {
    this.applyType = applyType == null ? null : applyType.trim();
  }

  public String getIsRelativeCared() {
    return isRelativeCared;
  }

  public void setIsRelativeCared(String isRelativeCared) {
    this.isRelativeCared = isRelativeCared == null ? null : isRelativeCared.trim();
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark == null ? null : remark.trim();
  }

  public String getOperatedBy() {
    return operatedBy;
  }

  public void setOperatedBy(String operatedBy) {
    this.operatedBy = operatedBy == null ? null : operatedBy.trim();
  }

  public String getOperatedTime() {
    return operatedTime;
  }

  public void setOperatedTime(String operatedTime) {
    this.operatedTime = operatedTime;
  }

  public String getOperatedOrg() {
    return operatedOrg;
  }

  public void setOperatedOrg(String operatedOrg) {
    this.operatedOrg = operatedOrg == null ? null : operatedOrg.trim();
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

  public Integer getIsValid() {
    return isValid;
  }

  public void setIsValid(Integer isValid) {
    this.isValid = isValid;
  }

  public String getSiArea() {
    return siArea;
  }

  public void setSiArea(String siArea) {
    this.siArea = siArea == null ? null : siArea.trim();
  }
}
