package com.taikang.dic.ltci.model;

import java.util.Date;

public class AreaDO extends BaseModel {
  private static final long serialVersionUID = 1L;

  private String id;

  private Date createdTime;

  private Date operatedTime;

  private String createdBy;

  private String operatedBy;

  private Integer isValid;

  private String areaName;

  private Integer level;

  private Integer sequence;

  private String parentid;

  private Integer common;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id == null ? null : id.trim();
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
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

  public String getOperatedBy() {
    return operatedBy;
  }

  public void setOperatedBy(String operatedBy) {
    this.operatedBy = operatedBy == null ? null : operatedBy.trim();
  }

  public Integer getIsValid() {
    return isValid;
  }

  public void setIsValid(Integer isValid) {
    this.isValid = isValid;
  }

  public String getAreaName() {
    return areaName;
  }

  public void setAreaName(String areaName) {
    this.areaName = areaName == null ? null : areaName.trim();
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public Integer getSequence() {
    return sequence;
  }

  public void setSequence(Integer sequence) {
    this.sequence = sequence;
  }

  public String getParentid() {
    return parentid;
  }

  public void setParentid(String parentid) {
    this.parentid = parentid == null ? null : parentid.trim();
  }

  public Integer getCommon() {
    return common;
  }

  public void setCommon(Integer common) {
    this.common = common;
  }
}
