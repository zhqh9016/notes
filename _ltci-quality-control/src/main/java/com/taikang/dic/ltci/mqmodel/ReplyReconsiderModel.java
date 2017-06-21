package com.taikang.dic.ltci.mqmodel;

/**
 * MQ消息发送封装Model
 *
 * @author itw_muwg
 * @description 申诉复议意见告知类
 */
public class ReplyReconsiderModel {

  /** 交易流水:发送方系统分配的UUID */
  private String serialNumber;
  /** 任务id，经办系统的任务id */
  private String patrolTaskId;
  /** 反馈人 */
  private String contact;
  /** 反馈人联系电话 */
  private String contactPhone;
  /** 反馈意见内容 */
  private String feedbackContent;
  /** 复议申请时间 */
  private String feedbackDate;

  public String getSerialNumber() {
    return serialNumber;
  }

  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  public String getPatrolTaskId() {
    return patrolTaskId;
  }

  public void setPatrolTaskId(String patrolTaskId) {
    this.patrolTaskId = patrolTaskId;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public String getContactPhone() {
    return contactPhone;
  }

  public void setContactPhone(String contactPhone) {
    this.contactPhone = contactPhone;
  }

  public String getFeedbackContent() {
    return feedbackContent;
  }

  public void setFeedbackContent(String feedbackContent) {
    this.feedbackContent = feedbackContent;
  }

  public String getFeedbackDate() {
    return feedbackDate;
  }

  public void setFeedbackDate(String feedbackDate) {
    this.feedbackDate = feedbackDate;
  }

  public ReplyReconsiderModel() {
    super();
  }

  public ReplyReconsiderModel(
      String serialNumber,
      String patrolTaskId,
      String contact,
      String contactPhone,
      String feebackContent,
      String feebackDate) {
    super();
    this.serialNumber = serialNumber;
    this.patrolTaskId = patrolTaskId;
    this.contact = contact;
    this.contactPhone = contactPhone;
    this.feedbackContent = feebackContent;
    this.feedbackDate = feebackDate;
  }
}
