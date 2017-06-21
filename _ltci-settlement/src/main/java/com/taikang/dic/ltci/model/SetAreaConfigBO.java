package com.taikang.dic.ltci.model;

public class SetAreaConfigBO extends BaseModel {
  private static final long serialVersionUID = 1L;

  private String id;

  private String siArea;

  private Integer isPackage;

  private Integer isValid;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id == null ? null : id.trim();
  }

  public String getSiArea() {
    return siArea;
  }

  public void setSiArea(String siArea) {
    this.siArea = siArea == null ? null : siArea.trim();
  }

  public Integer getIsPackage() {
    return isPackage;
  }

  public void setIsPackage(Integer isPackage) {
    this.isPackage = isPackage;
  }

  public Integer getIsValid() {
    return isValid;
  }

  public void setIsValid(Integer isValid) {
    this.isValid = isValid;
  }
}
