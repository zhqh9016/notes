
package com.taikang.dic.ltci.common.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * nurseAmount complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType name="nurseAmount">
 *   &lt;complexContent>
 *     &lt;extension base="{http://server.esb.iengine.medata.com/}changhuInput">
 *       &lt;sequence>
 *         &lt;element name="bedNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="buildingNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="careOrgServiceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="careOrgServiceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chargeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="count" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="diseaseArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inRecorduuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isRelativeCare" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="medicareCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nurseName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nurseTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="projectType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roomNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rxDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rxNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sendTimestamp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uniqueNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
  name = "nurseAmount",
  propOrder = {
    "bedNum",
    "buildingNo",
    "careOrgServiceCode",
    "careOrgServiceName",
    "chargeType",
    "count",
    "diseaseArea",
    "inRecorduuid",
    "isRelativeCare",
    "medicareCode",
    "nurseName",
    "nurseTime",
    "operator",
    "price",
    "projectType",
    "roomNo",
    "rxDate",
    "rxNum",
    "sendTimestamp",
    "uniqueNumber"
  }
)
public class NurseAmount extends ChanghuInput {

  protected String bedNum;
  protected String buildingNo;
  protected String careOrgServiceCode;
  protected String careOrgServiceName;
  protected String chargeType;
  protected String count;
  protected String diseaseArea;
  protected String inRecorduuid;
  protected String isRelativeCare;
  protected String medicareCode;
  protected String nurseName;
  protected String nurseTime;
  protected String operator;
  protected String price;
  protected String projectType;
  protected String roomNo;
  protected String rxDate;
  protected String rxNum;
  protected String sendTimestamp;
  protected String uniqueNumber;

  /**
   * 获取bedNum属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getBedNum() {
    return bedNum;
  }

  /**
   * 设置bedNum属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setBedNum(String value) {
    this.bedNum = value;
  }

  /**
   * 获取buildingNo属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getBuildingNo() {
    return buildingNo;
  }

  /**
   * 设置buildingNo属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setBuildingNo(String value) {
    this.buildingNo = value;
  }

  /**
   * 获取careOrgServiceCode属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getCareOrgServiceCode() {
    return careOrgServiceCode;
  }

  /**
   * 设置careOrgServiceCode属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setCareOrgServiceCode(String value) {
    this.careOrgServiceCode = value;
  }

  /**
   * 获取careOrgServiceName属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getCareOrgServiceName() {
    return careOrgServiceName;
  }

  /**
   * 设置careOrgServiceName属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setCareOrgServiceName(String value) {
    this.careOrgServiceName = value;
  }

  /**
   * 获取chargeType属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getChargeType() {
    return chargeType;
  }

  /**
   * 设置chargeType属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setChargeType(String value) {
    this.chargeType = value;
  }

  /**
   * 获取count属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getCount() {
    return count;
  }

  /**
   * 设置count属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setCount(String value) {
    this.count = value;
  }

  /**
   * 获取diseaseArea属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getDiseaseArea() {
    return diseaseArea;
  }

  /**
   * 设置diseaseArea属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setDiseaseArea(String value) {
    this.diseaseArea = value;
  }

  /**
   * 获取inRecorduuid属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getInRecorduuid() {
    return inRecorduuid;
  }

  /**
   * 设置inRecorduuid属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setInRecorduuid(String value) {
    this.inRecorduuid = value;
  }

  /**
   * 获取isRelativeCare属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getIsRelativeCare() {
    return isRelativeCare;
  }

  /**
   * 设置isRelativeCare属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setIsRelativeCare(String value) {
    this.isRelativeCare = value;
  }

  /**
   * 获取medicareCode属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getMedicareCode() {
    return medicareCode;
  }

  /**
   * 设置medicareCode属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setMedicareCode(String value) {
    this.medicareCode = value;
  }

  /**
   * 获取nurseName属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getNurseName() {
    return nurseName;
  }

  /**
   * 设置nurseName属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setNurseName(String value) {
    this.nurseName = value;
  }

  /**
   * 获取nurseTime属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getNurseTime() {
    return nurseTime;
  }

  /**
   * 设置nurseTime属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setNurseTime(String value) {
    this.nurseTime = value;
  }

  /**
   * 获取operator属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getOperator() {
    return operator;
  }

  /**
   * 设置operator属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setOperator(String value) {
    this.operator = value;
  }

  /**
   * 获取price属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getPrice() {
    return price;
  }

  /**
   * 设置price属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setPrice(String value) {
    this.price = value;
  }

  /**
   * 获取projectType属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getProjectType() {
    return projectType;
  }

  /**
   * 设置projectType属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setProjectType(String value) {
    this.projectType = value;
  }

  /**
   * 获取roomNo属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getRoomNo() {
    return roomNo;
  }

  /**
   * 设置roomNo属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setRoomNo(String value) {
    this.roomNo = value;
  }

  /**
   * 获取rxDate属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getRxDate() {
    return rxDate;
  }

  /**
   * 设置rxDate属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setRxDate(String value) {
    this.rxDate = value;
  }

  /**
   * 获取rxNum属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getRxNum() {
    return rxNum;
  }

  /**
   * 设置rxNum属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setRxNum(String value) {
    this.rxNum = value;
  }

  /**
   * 获取sendTimestamp属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getSendTimestamp() {
    return sendTimestamp;
  }

  /**
   * 设置sendTimestamp属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setSendTimestamp(String value) {
    this.sendTimestamp = value;
  }

  /**
   * 获取uniqueNumber属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getUniqueNumber() {
    return uniqueNumber;
  }

  /**
   * 设置uniqueNumber属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setUniqueNumber(String value) {
    this.uniqueNumber = value;
  }
}
