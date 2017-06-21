package com.taikang.dic.ltci.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * 系统域模型基类
 *
 * @author longfei04
 * @version 创建时间：2017年3月30日 下午7:00:00
 */
public class BaseModel implements Serializable {

  public static String DEFAULT_ORG_CODE = "99999";

  private static final long serialVersionUID = 1L;

  public static enum IsValid {
    VALID(1), // 有效
    INVALID(0); // 无效
    private Integer value;

    private IsValid(Integer value) {
      this.value = value;
    }

    public Integer getValue() {
      return value;
    }
  }

  public static String getUUID() {
    return UUID.randomUUID().toString().replace("-", "");
  }

  // 模型唯一标识
  private String id;

  // 修改人
  private String operatedBy;

  // 修改机构
  private String operatedOrg;
  // 修改时间
  private Date operatedTime;

  // 创建人
  private String createdBy;

  // 创建机构
  private String createdOrg;

  // 创建时间
  private Date createdTime;

  // 当前页
  private Integer currentPage = 1;

  // 分页用记录开始位置
  private Integer startPos;

  // 每页大小,默认为15
  private Integer pageSize = 25;

  // 排序列,默认为添加时间
  private String orderBy = "addTime";

  // 排序类型,默认为倒序
  private String orderType = "desc";

  private Integer isValid = 1; // 0无效  1有效

  public Integer getIsValid() {
    return isValid;
  }

  public void setIsValid(Integer isValid) {
    this.isValid = isValid;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Integer getCurrentPage() {
    return currentPage;
  }

  public void setCurrentPage(Integer currentPage) {
    this.currentPage = currentPage;
  }

  public Integer getStartPos() {
    return startPos;
  }

  public void setStartPos(Integer startPos) {
    this.startPos = startPos;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public String getOrderBy() {
    return orderBy;
  }

  public void setOrderBy(String orderBy) {
    this.orderBy = orderBy;
  }

  public String getOrderType() {
    return orderType;
  }

  public void setOrderType(String orderType) {
    this.orderType = orderType;
  }

  public String getOperatedBy() {
    return operatedBy;
  }

  public void setOperatedBy(String operatedBy) {
    this.operatedBy = operatedBy;
  }

  public String getOperatedOrg() {
    return operatedOrg;
  }

  public void setOperatedOrg(String operatedOrg) {
    this.operatedOrg = operatedOrg;
  }

  public Date getOperatedTime() {
    return operatedTime;
  }

  public void setOperatedTime(Date operatedTime) {
    this.operatedTime = operatedTime;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getCreatedOrg() {
    return createdOrg;
  }

  public void setCreatedOrg(String createdOrg) {
    this.createdOrg = createdOrg;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }
}
