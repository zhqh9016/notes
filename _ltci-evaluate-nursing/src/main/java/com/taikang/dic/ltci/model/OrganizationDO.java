package com.taikang.dic.ltci.model;

public class OrganizationDO {

  // 机构编号
  private String agencyCode;
  // 机构名称
  private String agencyName;
  // 机构地址
  private String agencyAddressDetail;
  // 服务能力
  private String serviceability;
  // 机构类型(护理/评估)
  private String agencyType;
  // 服务范围编码（逗号分隔
  private String serviceContentList;
  // 机构可用床位数
  private Integer agencyBedsNum;
  // 距离（暂时不提供）
  private String distance;

  public String getAgencyCode() {
    return agencyCode;
  }

  public void setAgencyCode(String agencyCode) {
    this.agencyCode = agencyCode;
  }

  public String getAgencyName() {
    return agencyName;
  }

  public void setAgencyName(String agencyName) {
    this.agencyName = agencyName;
  }

  public String getAgencyAddressDetail() {
    return agencyAddressDetail;
  }

  public void setAgencyAddressDetail(String agencyAddressDetail) {
    this.agencyAddressDetail = agencyAddressDetail;
  }

  public String getServiceability() {
    return serviceability;
  }

  public void setServiceability(String serviceability) {
    this.serviceability = serviceability;
  }

  public String getAgencyType() {
    return agencyType;
  }

  public void setAgencyType(String agencyType) {
    this.agencyType = agencyType;
  }

  public String getServiceContentList() {
    return serviceContentList;
  }

  public void setServiceContentList(String serviceContentList) {
    this.serviceContentList = serviceContentList;
  }

  public Integer getAgencyBedsNum() {
    return agencyBedsNum;
  }

  public void setAgencyBedsNum(Integer agencyBedsNum) {
    this.agencyBedsNum = agencyBedsNum;
  }

  public String getDistance() {
    return distance;
  }

  public void setDistance(String distance) {
    this.distance = distance;
  }

  @Override
  public String toString() {
    return "OrganizationDO [agencyCode="
        + agencyCode
        + ", agencyName="
        + agencyName
        + ", agencyAddressDetail="
        + agencyAddressDetail
        + ", serviceability="
        + serviceability
        + ", agencyType="
        + agencyType
        + ", serviceContentList="
        + serviceContentList
        + ", agencyBedsNum="
        + agencyBedsNum
        + ", distance="
        + distance
        + "]";
  }

  public OrganizationDO() {
    super();
  }

  public OrganizationDO(
      String agencyCode,
      String agencyName,
      String agencyAddressDetail,
      String serviceability,
      String agencyType,
      String serviceContentList,
      Integer agencyBedsNum,
      String distance) {
    super();
    this.agencyCode = agencyCode;
    this.agencyName = agencyName;
    this.agencyAddressDetail = agencyAddressDetail;
    this.serviceability = serviceability;
    this.agencyType = agencyType;
    this.serviceContentList = serviceContentList;
    this.agencyBedsNum = agencyBedsNum;
    this.distance = distance;
  }
}
