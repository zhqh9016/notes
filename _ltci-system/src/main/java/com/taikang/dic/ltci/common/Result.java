package com.taikang.dic.ltci.common;

/** @author itw_caoxy 接口返回给结果类 */
public class Result {
  private Integer status; //状态码
  private Object datas; //数据
  private String message; //状态描述

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Object getDatas() {
    return datas;
  }

  public void setDatas(Object datas) {
    this.datas = datas;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
