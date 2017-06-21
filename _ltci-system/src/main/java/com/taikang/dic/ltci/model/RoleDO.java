package com.taikang.dic.ltci.model;

import java.util.Date;

public class RoleDO extends BaseModel {
  private String id;

  private String createBy;

  private String updateBy;

  private Integer isValid;

  private String roleDescribe;

  private String roleCode;

  private String roleName;

  private Integer sequence;

  private Date createTime;

  private Date updateTime;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id == null ? null : id.trim();
  }

  public String getCreateBy() {
    return createBy;
  }

  public void setCreateBy(String createBy) {
    this.createBy = createBy == null ? null : createBy.trim();
  }

  public String getUpdateBy() {
    return updateBy;
  }

  public void setUpdateBy(String updateBy) {
    this.updateBy = updateBy == null ? null : updateBy.trim();
  }

  public Integer getIsValid() {
    return isValid;
  }

  public void setIsValid(Integer isValid) {
    this.isValid = isValid;
  }

  public String getRoleDescribe() {
    return roleDescribe;
  }

  public void setRoleDescribe(String roleDescribe) {
    this.roleDescribe = roleDescribe == null ? null : roleDescribe.trim();
  }

  public String getRoleCode() {
    return roleCode;
  }

  public void setRoleCode(String roleCode) {
    this.roleCode = roleCode == null ? null : roleCode.trim();
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName == null ? null : roleName.trim();
  }

  public Integer getSequence() {
    return sequence;
  }

  public void setSequence(Integer sequence) {
    this.sequence = sequence;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }
}
