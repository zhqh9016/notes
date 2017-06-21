package com.taikang.dic.ltci.model;

import java.util.Date;
/** @author itw_caoxy 用来添加封装专项巡查查询机构和人员时候的返回 */
public class PatrolTaskQueryDO {

  private String patrolObjectId;

  private String patrolObjectName;

  private String patrolObjectPhone;

  private String idCard;

  private String patrolObjectAddr;

  public String getPatrolObjectId() {
    return patrolObjectId;
  }

  public void setPatrolObjectId(String patrolObjectId) {
    this.patrolObjectId = patrolObjectId;
  }

  public String getPatrolObjectName() {
    return patrolObjectName;
  }

  public void setPatrolObjectName(String patrolObjectName) {
    this.patrolObjectName = patrolObjectName;
  }

  public String getPatrolObjectPhone() {
    return patrolObjectPhone;
  }

  public void setPatrolObjectPhone(String patrolObjectPhone) {
    this.patrolObjectPhone = patrolObjectPhone;
  }

  public String getIdCard() {
    return idCard;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard;
  }

  public String getPatrolObjectAddr() {
    return patrolObjectAddr;
  }

  public void setPatrolObjectAddr(String patrolObjectAddr) {
    this.patrolObjectAddr = patrolObjectAddr;
  }
}
