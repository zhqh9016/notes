package com.taikang.dic.ltci.model;

public class RReconsiderFileDO extends BaseModel {
  private String id;

  private String reconsiderid;

  private String fileId;

  private String fileType;

  private String fileName;

  private String lcpsFileId;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id == null ? null : id.trim();
  }

  public String getReconsiderid() {
    return reconsiderid;
  }

  public void setReconsiderid(String reconsiderid) {
    this.reconsiderid = reconsiderid == null ? null : reconsiderid.trim();
  }

  public String getFileId() {
    return fileId;
  }

  public void setFileId(String fileId) {
    this.fileId = fileId == null ? null : fileId.trim();
  }

  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType == null ? null : fileType.trim();
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName == null ? null : fileName.trim();
  }

  public String getLcpsFileId() {
    return lcpsFileId;
  }

  public void setLcpsFileId(String lcpsFileId) {
    this.lcpsFileId = lcpsFileId == null ? null : lcpsFileId.trim();
  }
}
