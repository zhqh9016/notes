package com.taikang.dic.ltci.model;

import java.util.Date;

public class ResDO extends BaseModel {
  private String id;

  private String parentId;

  private String resName;

  private String description;

  private String url;

  private String sequence;

  private Integer isMenu;

  private Integer isValid;

  private Date createTime;

  private Date updateTime;

  private String createBy;

  private String updateBy;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id == null ? null : id.trim();
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId == null ? null : parentId.trim();
  }

  public String getResName() {
    return resName;
  }

  public void setResName(String resName) {
    this.resName = resName == null ? null : resName.trim();
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description == null ? null : description.trim();
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url == null ? null : url.trim();
  }

  public String getSequence() {
    return sequence;
  }

  public void setSequence(String sequence) {
    this.sequence = sequence == null ? null : sequence.trim();
  }

  public Integer getIsMenu() {
    return isMenu;
  }

  public void setIsMenu(Integer isMenu) {
    this.isMenu = isMenu;
  }

  public Integer getIsValid() {
    return isValid;
  }

  public void setIsValid(Integer isValid) {
    this.isValid = isValid;
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
}
