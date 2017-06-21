
package com.taikang.dic.ltci.common.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * insuredInfo complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType name="insuredInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://server.esb.iengine.medata.com/}response">
 *       &lt;sequence>
 *         &lt;element name="insuredPersonName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="siArea" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="siID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idCard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="securityNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="birthday" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="residencyProperty" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="personnelType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="personalIdentity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
  name = "insuredInfo",
  propOrder = {
    "insuredPersonName",
    "siArea",
    "siID",
    "nation",
    "idCard",
    "securityNum",
    "birthday",
    "residencyProperty",
    "personnelType",
    "personalIdentity",
    "gender",
    "orgCode"
  }
)
public class InsuredInfo extends Response {

  protected String insuredPersonName;
  protected String siArea;
  protected String siID;
  protected String nation;
  protected String idCard;
  protected String securityNum;
  protected String birthday;
  protected String residencyProperty;
  protected String personnelType;
  protected String personalIdentity;
  protected String gender;
  protected String orgCode;

  /**
   * 获取insuredPersonName属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getInsuredPersonName() {
    return insuredPersonName;
  }

  /**
   * 设置insuredPersonName属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setInsuredPersonName(String value) {
    this.insuredPersonName = value;
  }

  /**
   * 获取siArea属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getSiArea() {
    return siArea;
  }

  /**
   * 设置siArea属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setSiArea(String value) {
    this.siArea = value;
  }

  /**
   * 获取siID属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getSiID() {
    return siID;
  }

  /**
   * 设置siID属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setSiID(String value) {
    this.siID = value;
  }

  /**
   * 获取nation属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getNation() {
    return nation;
  }

  /**
   * 设置nation属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setNation(String value) {
    this.nation = value;
  }

  /**
   * 获取idCard属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getIdCard() {
    return idCard;
  }

  /**
   * 设置idCard属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setIdCard(String value) {
    this.idCard = value;
  }

  /**
   * 获取securityNum属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getSecurityNum() {
    return securityNum;
  }

  /**
   * 设置securityNum属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setSecurityNum(String value) {
    this.securityNum = value;
  }

  /**
   * 获取birthday属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getBirthday() {
    return birthday;
  }

  /**
   * 设置birthday属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setBirthday(String value) {
    this.birthday = value;
  }

  /**
   * 获取residencyProperty属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getResidencyProperty() {
    return residencyProperty;
  }

  /**
   * 设置residencyProperty属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setResidencyProperty(String value) {
    this.residencyProperty = value;
  }

  /**
   * 获取personnelType属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getPersonnelType() {
    return personnelType;
  }

  /**
   * 设置personnelType属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setPersonnelType(String value) {
    this.personnelType = value;
  }

  /**
   * 获取personalIdentity属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getPersonalIdentity() {
    return personalIdentity;
  }

  /**
   * 设置personalIdentity属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setPersonalIdentity(String value) {
    this.personalIdentity = value;
  }

  /**
   * 获取gender属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getGender() {
    return gender;
  }

  /**
   * 设置gender属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setGender(String value) {
    this.gender = value;
  }

  /**
   * 获取orgCode属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getOrgCode() {
    return orgCode;
  }

  /**
   * 设置orgCode属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setOrgCode(String value) {
    this.orgCode = value;
  }
}
