package com.taikang.dic.ltci.model;

import java.util.Date;

public class OrganizationDO extends BaseModel {

  private static final long serialVersionUID = 1L;

  private String id;

  private String createdBy;

  private String operatedBy;

  private Date createdTime;

  private Date operatedTime;

  private Integer isOrg;

  private Integer isValid;

  private String parentid;

  private String code;

  private String socOrgCode;

  private String name;

  private String description;

  private String street;

  private String provinceid;

  private String provinceName;

  private String cityid;

  private String cityName;

  private String countyid;

  private String countyName;

  private String phone;

  private Integer sequence;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id == null ? null : id.trim();
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

  public Integer getIsOrg() {
    return isOrg;
  }

  public void setIsOrg(Integer isOrg) {
    this.isOrg = isOrg;
  }

  public Integer getIsValid() {
    return isValid;
  }

  public void setIsValid(Integer isValid) {
    this.isValid = isValid;
  }

  public String getParentid() {
    return parentid;
  }

  public void setParentid(String parentid) {
    this.parentid = parentid == null ? null : parentid.trim();
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code == null ? null : code.trim();
  }

  public String getSocOrgCode() {
    return socOrgCode;
  }

  public void setSocOrgCode(String socOrgCode) {
    this.socOrgCode = socOrgCode == null ? null : socOrgCode.trim();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name == null ? null : name.trim();
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description == null ? null : description.trim();
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street == null ? null : street.trim();
  }

  public String getProvinceid() {
    return provinceid;
  }

  public void setProvinceid(String provinceid) {
    this.provinceid = provinceid == null ? null : provinceid.trim();
  }

  public String getProvinceName() {
    return provinceName;
  }

  public void setProvinceName(String provinceName) {
    this.provinceName = provinceName == null ? null : provinceName.trim();
  }

  public String getCityid() {
    return cityid;
  }

  public void setCityid(String cityid) {
    this.cityid = cityid == null ? null : cityid.trim();
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName == null ? null : cityName.trim();
  }

  public String getCountyid() {
    return countyid;
  }

  public void setCountyid(String countyid) {
    this.countyid = countyid == null ? null : countyid.trim();
  }

  public String getCountyName() {
    return countyName;
  }

  public void setCountyName(String countyName) {
    this.countyName = countyName == null ? null : countyName.trim();
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone == null ? null : phone.trim();
  }

  public Integer getSequence() {
    return sequence;
  }

  public void setSequence(Integer sequence) {
    this.sequence = sequence;
  }
}
