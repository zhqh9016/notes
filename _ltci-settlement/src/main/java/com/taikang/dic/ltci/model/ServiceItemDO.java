package com.taikang.dic.ltci.model;

import java.math.BigDecimal;
import java.util.Date;

public class ServiceItemDO extends BaseModel {

  private static final long serialVersionUID = 1L;

  private String serviceCode;

  private Integer serviceType;

  private String serviceName;

  private String frequency;

  private String taskTime;

  private String description;

  private Integer payType;

  private String chargeType;

  private String chargeLevel;

  private Date startTime;

  private Date endTime;

  private BigDecimal limitPrice;

  private BigDecimal price;

  private String siArea;

  public String getServiceCode() {
    return serviceCode;
  }

  public void setServiceCode(String serviceCode) {
    this.serviceCode = serviceCode == null ? null : serviceCode.trim();
  }

  public Integer getServiceType() {
    return serviceType;
  }

  public void setServiceType(Integer serviceType) {
    this.serviceType = serviceType;
  }

  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName == null ? null : serviceName.trim();
  }

  public String getFrequency() {
    return frequency;
  }

  public void setFrequency(String frequency) {
    this.frequency = frequency == null ? null : frequency.trim();
  }

  public String getTaskTime() {
    return taskTime;
  }

  public void setTaskTime(String taskTime) {
    this.taskTime = taskTime == null ? null : taskTime.trim();
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description == null ? null : description.trim();
  }

  public Integer getPayType() {
    return payType;
  }

  public void setPayType(Integer payType) {
    this.payType = payType;
  }

  public String getChargeType() {
    return chargeType;
  }

  public void setChargeType(String chargeType) {
    this.chargeType = chargeType == null ? null : chargeType.trim();
  }

  public String getChargeLevel() {
    return chargeLevel;
  }

  public void setChargeLevel(String chargeLevel) {
    this.chargeLevel = chargeLevel == null ? null : chargeLevel.trim();
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public BigDecimal getLimitPrice() {
    return limitPrice;
  }

  public void setLimitPrice(BigDecimal limitPrice) {
    this.limitPrice = limitPrice;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public String getSiArea() {
    return siArea;
  }

  public void setSiArea(String siArea) {
    this.siArea = siArea == null ? null : siArea.trim();
  }
}
