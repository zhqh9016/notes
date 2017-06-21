package com.taikang.dic.ltci.model;

import java.util.Date;

public class MqFailMessageLogDO extends BaseModel {
  private static final long serialVersionUID = 1L;

  private String id;

  private Integer retryNum;

  private Integer transportType;

  private Integer operationType;

  private String retryUrl;

  private String httpAction;

  private String errorMessage;

  private String exchangeName;

  private String queryName;

  private Date createTime;

  private String content;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id == null ? null : id.trim();
  }

  public Integer getRetryNum() {
    return retryNum;
  }

  public void setRetryNum(Integer retryNum) {
    this.retryNum = retryNum;
  }

  public Integer getTransportType() {
    return transportType;
  }

  public void setTransportType(Integer transportType) {
    this.transportType = transportType;
  }

  public Integer getOperationType() {
    return operationType;
  }

  public void setOperationType(Integer operationType) {
    this.operationType = operationType;
  }

  public String getRetryUrl() {
    return retryUrl;
  }

  public void setRetryUrl(String retryUrl) {
    this.retryUrl = retryUrl == null ? null : retryUrl.trim();
  }

  public String getHttpAction() {
    return httpAction;
  }

  public void setHttpAction(String httpAction) {
    this.httpAction = httpAction == null ? null : httpAction.trim();
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage == null ? null : errorMessage.trim();
  }

  public String getExchangeName() {
    return exchangeName;
  }

  public void setExchangeName(String exchangeName) {
    this.exchangeName = exchangeName == null ? null : exchangeName.trim();
  }

  public String getQueryName() {
    return queryName;
  }

  public void setQueryName(String queryName) {
    this.queryName = queryName == null ? null : queryName.trim();
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content == null ? null : content.trim();
  }
}
