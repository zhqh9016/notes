package com.taikang.dic.ltci.model;

import java.math.BigDecimal;
import java.util.Date;

public class NurseDetailDO extends BaseModel {
  private String id;

  private String inRecorduuid;

  private String feeSetCode;

  private String orgCode;

  private String orgName;

  private String socSecNum;

  private String beCarePersonCard;

  private Integer cardType;

  private String beCarePersonName;

  private String buildingNo;

  private String roomNo;

  private String diseaseArea;

  private String bedNum;

  private String tradeNum;

  private Integer traType;

  private String refundNum;

  private Integer chargeLevel;

  private String medicalType;

  private Integer isRelativeCare;

  private String medicareCode;

  private String careOrgServiceCode;

  private String medicareName;

  private String careOrgServiceName;

  private String chargeType;

  private Date feeDate;

  private Double count;

  private BigDecimal price;

  private BigDecimal amount;

  private Integer manHour;

  private String nurseCode;

  private String nurseName;

  private Date nurseTime;

  private BigDecimal unrFee;

  private Integer isSynForSocial;

  private Integer isSysForOrg;

  private String chargePersonCd;

  private String chargePersonName;

  private String chargeDeptCd;

  private Integer approveFlag;

  private Integer isValid;

  private String operatedBy;

  private Date operatedTime;

  private String operatedOrg;

  private String createdBy;

  private Date createdTime;

  private String createdOrg;

  private String siArea;

  private BigDecimal overCost;

  private BigDecimal nurseTotalAmount;

  private BigDecimal siPay;

  private BigDecimal paySelf;

  private BigDecimal expenseSelf;

  private String transactionNum;

  private String cycleNum;

  private String projectType;

  private String countType;

  private String perSettleFalg;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id == null ? null : id.trim();
  }

  public String getInRecorduuid() {
    return inRecorduuid;
  }

  public void setInRecorduuid(String inRecorduuid) {
    this.inRecorduuid = inRecorduuid == null ? null : inRecorduuid.trim();
  }

  public String getFeeSetCode() {
    return feeSetCode;
  }

  public void setFeeSetCode(String feeSetCode) {
    this.feeSetCode = feeSetCode == null ? null : feeSetCode.trim();
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

  public String getBuildingNo() {
    return buildingNo;
  }

  public void setBuildingNo(String buildingNo) {
    this.buildingNo = buildingNo == null ? null : buildingNo.trim();
  }

  public String getRoomNo() {
    return roomNo;
  }

  public void setRoomNo(String roomNo) {
    this.roomNo = roomNo == null ? null : roomNo.trim();
  }

  public String getDiseaseArea() {
    return diseaseArea;
  }

  public void setDiseaseArea(String diseaseArea) {
    this.diseaseArea = diseaseArea == null ? null : diseaseArea.trim();
  }

  public String getBedNum() {
    return bedNum;
  }

  public void setBedNum(String bedNum) {
    this.bedNum = bedNum == null ? null : bedNum.trim();
  }

  public String getTradeNum() {
    return tradeNum;
  }

  public void setTradeNum(String tradeNum) {
    this.tradeNum = tradeNum == null ? null : tradeNum.trim();
  }

  public Integer getTraType() {
    return traType;
  }

  public void setTraType(Integer traType) {
    this.traType = traType;
  }

  public String getRefundNum() {
    return refundNum;
  }

  public void setRefundNum(String refundNum) {
    this.refundNum = refundNum == null ? null : refundNum.trim();
  }

  public Integer getChargeLevel() {
    return chargeLevel;
  }

  public void setChargeLevel(Integer chargeLevel) {
    this.chargeLevel = chargeLevel;
  }

  public String getMedicalType() {
    return medicalType;
  }

  public void setMedicalType(String medicalType) {
    this.medicalType = medicalType == null ? null : medicalType.trim();
  }

  public Integer getIsRelativeCare() {
    return isRelativeCare;
  }

  public void setIsRelativeCare(Integer isRelativeCare) {
    this.isRelativeCare = isRelativeCare;
  }

  public String getMedicareCode() {
    return medicareCode;
  }

  public void setMedicareCode(String medicareCode) {
    this.medicareCode = medicareCode == null ? null : medicareCode.trim();
  }

  public String getCareOrgServiceCode() {
    return careOrgServiceCode;
  }

  public void setCareOrgServiceCode(String careOrgServiceCode) {
    this.careOrgServiceCode = careOrgServiceCode == null ? null : careOrgServiceCode.trim();
  }

  public String getMedicareName() {
    return medicareName;
  }

  public void setMedicareName(String medicareName) {
    this.medicareName = medicareName == null ? null : medicareName.trim();
  }

  public String getCareOrgServiceName() {
    return careOrgServiceName;
  }

  public void setCareOrgServiceName(String careOrgServiceName) {
    this.careOrgServiceName = careOrgServiceName == null ? null : careOrgServiceName.trim();
  }

  public String getChargeType() {
    return chargeType;
  }

  public void setChargeType(String chargeType) {
    this.chargeType = chargeType == null ? null : chargeType.trim();
  }

  public Date getFeeDate() {
    return feeDate;
  }

  public void setFeeDate(Date feeDate) {
    this.feeDate = feeDate;
  }

  public Double getCount() {
    return count;
  }

  public void setCount(Double count) {
    this.count = count;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public Integer getManHour() {
    return manHour;
  }

  public void setManHour(Integer manHour) {
    this.manHour = manHour;
  }

  public String getNurseCode() {
    return nurseCode;
  }

  public void setNurseCode(String nurseCode) {
    this.nurseCode = nurseCode == null ? null : nurseCode.trim();
  }

  public String getNurseName() {
    return nurseName;
  }

  public void setNurseName(String nurseName) {
    this.nurseName = nurseName == null ? null : nurseName.trim();
  }

  public Date getNurseTime() {
    return nurseTime;
  }

  public void setNurseTime(Date nurseTime) {
    this.nurseTime = nurseTime;
  }

  public BigDecimal getUnrFee() {
    return unrFee;
  }

  public void setUnrFee(BigDecimal unrFee) {
    this.unrFee = unrFee;
  }

  public Integer getIsSynForSocial() {
    return isSynForSocial;
  }

  public void setIsSynForSocial(Integer isSynForSocial) {
    this.isSynForSocial = isSynForSocial;
  }

  public Integer getIsSysForOrg() {
    return isSysForOrg;
  }

  public void setIsSysForOrg(Integer isSysForOrg) {
    this.isSysForOrg = isSysForOrg;
  }

  public String getChargePersonCd() {
    return chargePersonCd;
  }

  public void setChargePersonCd(String chargePersonCd) {
    this.chargePersonCd = chargePersonCd == null ? null : chargePersonCd.trim();
  }

  public String getChargePersonName() {
    return chargePersonName;
  }

  public void setChargePersonName(String chargePersonName) {
    this.chargePersonName = chargePersonName == null ? null : chargePersonName.trim();
  }

  public String getChargeDeptCd() {
    return chargeDeptCd;
  }

  public void setChargeDeptCd(String chargeDeptCd) {
    this.chargeDeptCd = chargeDeptCd == null ? null : chargeDeptCd.trim();
  }

  public Integer getApproveFlag() {
    return approveFlag;
  }

  public void setApproveFlag(Integer approveFlag) {
    this.approveFlag = approveFlag;
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

  public String getSiArea() {
    return siArea;
  }

  public void setSiArea(String siArea) {
    this.siArea = siArea == null ? null : siArea.trim();
  }

  public BigDecimal getOverCost() {
    return overCost;
  }

  public void setOverCost(BigDecimal overCost) {
    this.overCost = overCost;
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

  public String getTransactionNum() {
    return transactionNum;
  }

  public void setTransactionNum(String transactionNum) {
    this.transactionNum = transactionNum == null ? null : transactionNum.trim();
  }

  public String getCycleNum() {
    return cycleNum;
  }

  public void setCycleNum(String cycleNum) {
    this.cycleNum = cycleNum == null ? null : cycleNum.trim();
  }

  public String getProjectType() {
    return projectType;
  }

  public void setProjectType(String projectType) {
    this.projectType = projectType == null ? null : projectType.trim();
  }

  public String getCountType() {
    return countType;
  }

  public void setCountType(String countType) {
    this.countType = countType == null ? null : countType.trim();
  }

  public String getPerSettleFalg() {
    return perSettleFalg;
  }

  public void setPerSettleFalg(String perSettleFalg) {
    this.perSettleFalg = perSettleFalg == null ? null : perSettleFalg.trim();
  }
}
