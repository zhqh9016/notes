package com.taikang.dic.ltci.model;

import java.util.Date;

public class MQMessageLogDO extends BaseModel {
  /**
   * @author itw_xuxf
   * @version 2017年4月5日下午6:49:13
   */
  private static final long serialVersionUID = 1L;

  private String id;

  private String type;

  private String sendState;

  private Date sendTime;

  private Date createTime;

  private Long reSendNum;

  private String failMessage;

  private String exchangeName;

  private String queueName;

  private String sendContent;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id == null ? null : id.trim();
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type == null ? null : type.trim();
  }

  public String getSendState() {
    return sendState;
  }

  public void setSendState(String sendState) {
    this.sendState = sendState == null ? null : sendState.trim();
  }

  public Date getSendTime() {
    return sendTime;
  }

  public void setSendTime(Date sendTime) {
    this.sendTime = sendTime;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Long getReSendNum() {
    return reSendNum;
  }

  public void setReSendNum(Long reSendNum) {
    this.reSendNum = reSendNum;
  }

  public String getFailMessage() {
    return failMessage;
  }

  public void setFailMessage(String failMessage) {
    this.failMessage = failMessage == null ? null : failMessage.trim();
  }

  public String getExchangeName() {
    return exchangeName;
  }

  public void setExchangeName(String exchangeName) {
    this.exchangeName = exchangeName == null ? null : exchangeName.trim();
  }

  public String getQueueName() {
    return queueName;
  }

  public void setQueueName(String queueName) {
    this.queueName = queueName == null ? null : queueName.trim();
  }

  public String getSendContent() {
    return sendContent;
  }

  public void setSendContent(String sendContent) {
    this.sendContent = sendContent == null ? null : sendContent.trim();
  }
}
