package com.taikang.dic.ltci.model;

public class RRoleResDO extends BaseModel {
  private static final long serialVersionUID = 1L;

  private String roleId;

  private String resId;

  public String getRoleId() {
    return roleId;
  }

  public void setRoleId(String roleId) {
    this.roleId = roleId == null ? null : roleId.trim();
  }

  public String getResId() {
    return resId;
  }

  public void setResId(String resId) {
    this.resId = resId == null ? null : resId.trim();
  }
}
