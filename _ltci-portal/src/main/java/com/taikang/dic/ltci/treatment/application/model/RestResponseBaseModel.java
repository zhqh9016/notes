package com.taikang.dic.ltci.treatment.application.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class RestResponseBaseModel implements Serializable {

  private static final long serialVersionUID = 1L;
  /** 交易流水:发送方系统分配的UUID */
  private String businessSerialid;
  /** 消息发送时间 */
  private Timestamp timestamp;
  /** body 内容 */
  private Object data;

  public String getBusinessSerialid() {
    return businessSerialid;
  }

  public void setBusinessSerialid(String businessSerialid) {
    this.businessSerialid = businessSerialid;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }
}
