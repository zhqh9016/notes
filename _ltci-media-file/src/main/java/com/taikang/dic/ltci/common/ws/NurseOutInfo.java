
package com.taikang.dic.ltci.common.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * nurseOutInfo complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType name="nurseOutInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://server.esb.iengine.medata.com/}changhuInput">
 *       &lt;sequence>
 *         &lt;element name="bedNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="careType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="department" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inRecorduuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="outReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="realOutDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rxInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
  name = "nurseOutInfo",
  propOrder = {
    "bedNum",
    "careType",
    "department",
    "inRecorduuid",
    "operator",
    "outReason",
    "realOutDate",
    "rxInfo"
  }
)
public class NurseOutInfo extends ChanghuInput {

  protected String bedNum;
  protected String careType;
  protected String department;
  protected String inRecorduuid;
  protected String operator;
  protected String outReason;
  protected String realOutDate;
  protected String rxInfo;

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
   * 获取careType属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getCareType() {
    return careType;
  }

  /**
   * 设置careType属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setCareType(String value) {
    this.careType = value;
  }

  /**
   * 获取department属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getDepartment() {
    return department;
  }

  /**
   * 设置department属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setDepartment(String value) {
    this.department = value;
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
   * 获取outReason属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getOutReason() {
    return outReason;
  }

  /**
   * 设置outReason属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setOutReason(String value) {
    this.outReason = value;
  }

  /**
   * 获取realOutDate属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getRealOutDate() {
    return realOutDate;
  }

  /**
   * 设置realOutDate属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setRealOutDate(String value) {
    this.realOutDate = value;
  }

  /**
   * 获取rxInfo属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getRxInfo() {
    return rxInfo;
  }

  /**
   * 设置rxInfo属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setRxInfo(String value) {
    this.rxInfo = value;
  }
}
