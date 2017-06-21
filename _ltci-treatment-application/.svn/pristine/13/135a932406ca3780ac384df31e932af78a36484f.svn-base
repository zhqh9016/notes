package com.taikang.dic.ltci.model;

import java.io.Serializable;
import java.sql.Timestamp;
/**
 * MQ消息发送封装Model
 *
 * @author itw_liuxy
 * @description
 * @createTime 2017年4月18日 上午10:41:22
 */
public class MqBaseModel implements Serializable {

  private static final long serialVersionUID = 1L;
  /** 交易流水:发送方系统分配的UUID */
  private String businessSerialid;
  /** 消息发送时间 */
  private Timestamp timestamp;
  /** 系统编码 */
  private String systemCode;
  /** 发送方模块编码 */
  private String moduleCode;
  /** 消息编码，业务判断使用这个字段 */
  private String messageCode;
  /** 微服务IP */
  private String nodeIP;
  /** body 内容 */
  private Object data;

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public String getBusinessSerialid() {
    return businessSerialid;
  }

  public void setBusinessSerialid(String businessSerialid) {
    this.businessSerialid = businessSerialid;
  }

  public String getNodeIP() {
    return nodeIP;
  }

  public void setNodeIP(String nodeIP) {
    this.nodeIP = nodeIP;
  }

  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }

  public String getSystemCode() {
    return systemCode;
  }

  public void setSystemCode(String systemCode) {
    this.systemCode = systemCode;
  }

  public String getModuleCode() {
    return moduleCode;
  }

  public void setModuleCode(String moduleCode) {
    this.moduleCode = moduleCode;
  }

  public String getMessageCode() {
    return messageCode;
  }

  public void setMessageCode(String messageCode) {
    this.messageCode = messageCode;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
