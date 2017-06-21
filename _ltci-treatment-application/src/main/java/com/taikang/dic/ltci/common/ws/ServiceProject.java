
package com.taikang.dic.ltci.common.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * serviceProject complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType name="serviceProject">
 *   &lt;complexContent>
 *     &lt;extension base="{http://server.esb.iengine.medata.com/}changhuInput">
 *       &lt;sequence>
 *         &lt;element name="chargeLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chargeType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maximumPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="medicareCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="medicareHours" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="medicareName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="medicareType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="medicarecontent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operatorDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serviceFrequency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unitPrice" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="validEndDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="validStartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
  name = "serviceProject",
  propOrder = {
    "chargeLevel",
    "chargeType",
    "maximumPrice",
    "medicareCode",
    "medicareHours",
    "medicareName",
    "medicareType",
    "medicarecontent",
    "operator",
    "operatorDate",
    "serviceFrequency",
    "unitPrice",
    "validEndDate",
    "validStartDate"
  }
)
public class ServiceProject extends ChanghuInput {

  protected String chargeLevel;
  protected String chargeType;
  protected String maximumPrice;
  protected String medicareCode;
  protected String medicareHours;
  protected String medicareName;
  protected String medicareType;
  protected String medicarecontent;
  protected String operator;
  protected String operatorDate;
  protected String serviceFrequency;
  protected String unitPrice;
  protected String validEndDate;
  protected String validStartDate;

  /**
   * 获取chargeLevel属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getChargeLevel() {
    return chargeLevel;
  }

  /**
   * 设置chargeLevel属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setChargeLevel(String value) {
    this.chargeLevel = value;
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
   * 获取maximumPrice属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getMaximumPrice() {
    return maximumPrice;
  }

  /**
   * 设置maximumPrice属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setMaximumPrice(String value) {
    this.maximumPrice = value;
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
   * 获取medicareHours属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getMedicareHours() {
    return medicareHours;
  }

  /**
   * 设置medicareHours属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setMedicareHours(String value) {
    this.medicareHours = value;
  }

  /**
   * 获取medicareName属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getMedicareName() {
    return medicareName;
  }

  /**
   * 设置medicareName属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setMedicareName(String value) {
    this.medicareName = value;
  }

  /**
   * 获取medicareType属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getMedicareType() {
    return medicareType;
  }

  /**
   * 设置medicareType属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setMedicareType(String value) {
    this.medicareType = value;
  }

  /**
   * 获取medicarecontent属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getMedicarecontent() {
    return medicarecontent;
  }

  /**
   * 设置medicarecontent属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setMedicarecontent(String value) {
    this.medicarecontent = value;
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
   * 获取operatorDate属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getOperatorDate() {
    return operatorDate;
  }

  /**
   * 设置operatorDate属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setOperatorDate(String value) {
    this.operatorDate = value;
  }

  /**
   * 获取serviceFrequency属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getServiceFrequency() {
    return serviceFrequency;
  }

  /**
   * 设置serviceFrequency属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setServiceFrequency(String value) {
    this.serviceFrequency = value;
  }

  /**
   * 获取unitPrice属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getUnitPrice() {
    return unitPrice;
  }

  /**
   * 设置unitPrice属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setUnitPrice(String value) {
    this.unitPrice = value;
  }

  /**
   * 获取validEndDate属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getValidEndDate() {
    return validEndDate;
  }

  /**
   * 设置validEndDate属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setValidEndDate(String value) {
    this.validEndDate = value;
  }

  /**
   * 获取validStartDate属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getValidStartDate() {
    return validStartDate;
  }

  /**
   * 设置validStartDate属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setValidStartDate(String value) {
    this.validStartDate = value;
  }
}
