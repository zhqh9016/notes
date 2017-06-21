package com.taikang.dic.ltci.mqmodel;

import java.math.BigDecimal;
import java.util.Date;

public class MQServiceItemModel {
  private String id;

  private String provinceCode;

  private String medicareCode;

  private Integer medicareType;

  private String medicareName;

  private String chargeType;

  private String chargeLevel;

  private String serviceFrequency;

  private String medicareHours;

  private String medicarecontent;

  private Date validStartDate;

  private Date validEndDate;

  private BigDecimal unitPrice;

  private BigDecimal maximumPrice;

  private String siArea;

  private String operator;

  private Date operatorDate;

  private Integer valid;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getProvinceCode() {
    return provinceCode;
  }

  public void setProvinceCode(String provinceCode) {
    this.provinceCode = provinceCode;
  }

  public String getMedicareCode() {
    return medicareCode;
  }

  public void setMedicareCode(String medicareCode) {
    this.medicareCode = medicareCode;
  }

  public Integer getMedicareType() {
    return medicareType;
  }

  public void setMedicareType(Integer medicareType) {
    this.medicareType = medicareType;
  }

  public String getMedicareName() {
    return medicareName;
  }

  public void setMedicareName(String medicareName) {
    this.medicareName = medicareName;
  }

  public String getChargeType() {
    return chargeType;
  }

  public void setChargeType(String chargeType) {
    this.chargeType = chargeType;
  }

  public String getChargeLevel() {
    return chargeLevel;
  }

  public void setChargeLevel(String chargeLevel) {
    this.chargeLevel = chargeLevel;
  }

  public String getServiceFrequency() {
    return serviceFrequency;
  }

  public void setServiceFrequency(String serviceFrequency) {
    this.serviceFrequency = serviceFrequency;
  }

  public String getMedicareHours() {
    return medicareHours;
  }

  public void setMedicareHours(String medicareHours) {
    this.medicareHours = medicareHours;
  }

  public String getMedicarecontent() {
    return medicarecontent;
  }

  public void setMedicarecontent(String medicarecontent) {
    this.medicarecontent = medicarecontent;
  }

  public Date getValidStartDate() {
    return validStartDate;
  }

  public void setValidStartDate(Date validStartDate) {
    this.validStartDate = validStartDate;
  }

  public Date getValidEndDate() {
    return validEndDate;
  }

  public void setValidEndDate(Date validEndDate) {
    this.validEndDate = validEndDate;
  }

  public BigDecimal getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(BigDecimal unitPrice) {
    this.unitPrice = unitPrice;
  }

  public BigDecimal getMaximumPrice() {
    return maximumPrice;
  }

  public void setMaximumPrice(BigDecimal maximumPrice) {
    this.maximumPrice = maximumPrice;
  }

  public String getSiArea() {
    return siArea;
  }

  public void setSiArea(String siArea) {
    this.siArea = siArea;
  }

  public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }

  public Date getOperatorDate() {
    return operatorDate;
  }

  public void setOperatorDate(Date operatorDate) {
    this.operatorDate = operatorDate;
  }

  public Integer getValid() {
    return valid;
  }

  public void setValid(Integer valid) {
    this.valid = valid;
  }
}
