package com.taikang.dic.ltci.model;

import java.util.Date;

public class ScheduleDO {
  private String id;

  private String moudleType;

  private Long version;

  private Integer executionSchedule;

  private Date operatedTime;

  private Integer timeWindow;

  private String ip;

  private Integer executionStatus;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id == null ? null : id.trim();
  }

  public String getMoudleType() {
    return moudleType;
  }

  public void setMoudleType(String moudleType) {
    this.moudleType = moudleType == null ? null : moudleType.trim();
  }

  public Long getVersion() {
    return version;
  }

  public void setVersion(Long version) {
    this.version = version;
  }

  public Integer getExecutionSchedule() {
    return executionSchedule;
  }

  public void setExecutionSchedule(Integer executionSchedule) {
    this.executionSchedule = executionSchedule;
  }

  public Date getOperatedTime() {
    return operatedTime;
  }

  public void setOperatedTime(Date operatedTime) {
    this.operatedTime = operatedTime;
  }

  public Integer getTimeWindow() {
    return timeWindow;
  }

  public void setTimeWindow(Integer timeWindow) {
    this.timeWindow = timeWindow;
  }

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip == null ? null : ip.trim();
  }

  public Integer getExecutionStatus() {
    return executionStatus;
  }

  public void setExecutionStatus(Integer executionStatus) {
    this.executionStatus = executionStatus;
  }
}
