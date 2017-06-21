package com.taikang.dic.ltci.model;

import java.util.Date;

public class AgencyStaffFileRDO extends BaseModel {
  /** */
  private static final long serialVersionUID = -8957468997248348781L;

  private String id;

  private Integer objType;

  private String code;

  private String accessoryType;

  private String fileId;

  private String fileName;

  private String fileType;

  private Integer isValid;

  private String credentialName;

  private String credentialLevel;

  private Date credentialDate;

  private String credentialCode;

  private String historyId;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id == null ? null : id.trim();
  }

  public Integer getObjType() {
    return objType;
  }

  public void setObjType(Integer objType) {
    this.objType = objType;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code == null ? null : code.trim();
  }

  public String getAccessoryType() {
    return accessoryType;
  }

  public void setAccessoryType(String accessoryType) {
    this.accessoryType = accessoryType == null ? null : accessoryType.trim();
  }

  public String getFileId() {
    return fileId;
  }

  public void setFileId(String fileId) {
    this.fileId = fileId == null ? null : fileId.trim();
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName == null ? null : fileName.trim();
  }

  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType == null ? null : fileType.trim();
  }

  public Integer getIsValid() {
    return isValid;
  }

  public void setIsValid(Integer isValid) {
    this.isValid = isValid;
  }

  public String getCredentialName() {
    return credentialName;
  }

  public void setCredentialName(String credentialName) {
    this.credentialName = credentialName == null ? null : credentialName.trim();
  }

  public String getCredentialLevel() {
    return credentialLevel;
  }

  public void setCredentialLevel(String credentialLevel) {
    this.credentialLevel = credentialLevel == null ? null : credentialLevel.trim();
  }

  public Date getCredentialDate() {
    return credentialDate;
  }

  public void setCredentialDate(Date credentialDate) {
    this.credentialDate = credentialDate;
  }

  public String getCredentialCode() {
    return credentialCode;
  }

  public void setCredentialCode(String credentialCode) {
    this.credentialCode = credentialCode == null ? null : credentialCode.trim();
  }

  public String getHistoryId() {
    return historyId;
  }

  public void setHistoryId(String historyId) {
    this.historyId = historyId == null ? null : historyId.trim();
  }
}
