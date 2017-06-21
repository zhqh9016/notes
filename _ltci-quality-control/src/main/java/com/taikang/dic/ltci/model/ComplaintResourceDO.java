package com.taikang.dic.ltci.model;

public class ComplaintResourceDO extends BaseModel {

  private static final long serialVersionUID = 1L;

  private String resourceId;

  private String resourceMaterialType;

  private String resourceMaterialId;

  private String resourceMaterialInfoScan;

  private String patrolTaskId;

  private String resourceFileName;

  private String resourceFileType;

  public String getResourceId() {
    return resourceId;
  }

  public void setResourceId(String resourceId) {
    this.resourceId = resourceId == null ? null : resourceId.trim();
  }

  public String getResourceMaterialType() {
    return resourceMaterialType;
  }

  public void setResourceMaterialType(String resourceMaterialType) {
    this.resourceMaterialType = resourceMaterialType == null ? null : resourceMaterialType.trim();
  }

  public String getResourceMaterialId() {
    return resourceMaterialId;
  }

  public void setResourceMaterialId(String resourceMaterialId) {
    this.resourceMaterialId = resourceMaterialId == null ? null : resourceMaterialId.trim();
  }

  public String getResourceMaterialInfoScan() {
    return resourceMaterialInfoScan;
  }

  public void setResourceMaterialInfoScan(String resourceMaterialInfoScan) {
    this.resourceMaterialInfoScan =
        resourceMaterialInfoScan == null ? null : resourceMaterialInfoScan.trim();
  }

  public String getPatrolTaskId() {
    return patrolTaskId;
  }

  public void setPatrolTaskId(String patrolTaskId) {
    this.patrolTaskId = patrolTaskId == null ? null : patrolTaskId.trim();
  }

  public String getResourceFileName() {
    return resourceFileName;
  }

  public void setResourceFileName(String resourceFileName) {
    this.resourceFileName = resourceFileName == null ? null : resourceFileName.trim();
  }

  public String getResourceFileType() {
    return resourceFileType;
  }

  public void setResourceFileType(String resourceFileType) {
    this.resourceFileType = resourceFileType == null ? null : resourceFileType.trim();
  }
}
