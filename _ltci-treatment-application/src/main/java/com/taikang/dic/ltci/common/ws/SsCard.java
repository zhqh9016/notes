
package com.taikang.dic.ltci.common.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * ssCard complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType name="ssCard">
 *   &lt;complexContent>
 *     &lt;extension base="{http://server.esb.iengine.medata.com/}response">
 *       &lt;sequence>
 *         &lt;element name="individualNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idCard" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="birthday" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ssCardNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="medicalType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mcNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="personnelState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="insuredState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ssCardPwd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="medicalPlanning" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orgType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isPoorEnterprise" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AccountBalance" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="inhosState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="blockadeReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
  name = "ssCard",
  propOrder = {
    "individualNo",
    "orgNo",
    "idCard",
    "sName",
    "gender",
    "nation",
    "birthday",
    "ssCardNo",
    "medicalType",
    "mcNo",
    "personnelState",
    "insuredState",
    "ssCardPwd",
    "medicalPlanning",
    "orgType",
    "isPoorEnterprise",
    "accountBalance",
    "inhosState",
    "blockadeReason"
  }
)
public class SsCard extends Response {

  protected String individualNo;
  protected String orgNo;
  protected String idCard;
  protected String sName;
  protected String gender;
  protected String nation;
  protected String birthday;
  protected String ssCardNo;
  protected String medicalType;
  protected String mcNo;
  protected String personnelState;
  protected String insuredState;
  protected String ssCardPwd;
  protected String medicalPlanning;
  protected String orgType;
  protected String isPoorEnterprise;

  @XmlElement(name = "AccountBalance")
  protected double accountBalance;

  protected String inhosState;
  protected String blockadeReason;

  /**
   * 获取individualNo属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getIndividualNo() {
    return individualNo;
  }

  /**
   * 设置individualNo属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setIndividualNo(String value) {
    this.individualNo = value;
  }

  /**
   * 获取orgNo属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getOrgNo() {
    return orgNo;
  }

  /**
   * 设置orgNo属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setOrgNo(String value) {
    this.orgNo = value;
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
   * 获取sName属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getSName() {
    return sName;
  }

  /**
   * 设置sName属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setSName(String value) {
    this.sName = value;
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
   * 获取ssCardNo属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getSsCardNo() {
    return ssCardNo;
  }

  /**
   * 设置ssCardNo属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setSsCardNo(String value) {
    this.ssCardNo = value;
  }

  /**
   * 获取medicalType属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getMedicalType() {
    return medicalType;
  }

  /**
   * 设置medicalType属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setMedicalType(String value) {
    this.medicalType = value;
  }

  /**
   * 获取mcNo属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getMcNo() {
    return mcNo;
  }

  /**
   * 设置mcNo属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setMcNo(String value) {
    this.mcNo = value;
  }

  /**
   * 获取personnelState属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getPersonnelState() {
    return personnelState;
  }

  /**
   * 设置personnelState属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setPersonnelState(String value) {
    this.personnelState = value;
  }

  /**
   * 获取insuredState属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getInsuredState() {
    return insuredState;
  }

  /**
   * 设置insuredState属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setInsuredState(String value) {
    this.insuredState = value;
  }

  /**
   * 获取ssCardPwd属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getSsCardPwd() {
    return ssCardPwd;
  }

  /**
   * 设置ssCardPwd属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setSsCardPwd(String value) {
    this.ssCardPwd = value;
  }

  /**
   * 获取medicalPlanning属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getMedicalPlanning() {
    return medicalPlanning;
  }

  /**
   * 设置medicalPlanning属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setMedicalPlanning(String value) {
    this.medicalPlanning = value;
  }

  /**
   * 获取orgType属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getOrgType() {
    return orgType;
  }

  /**
   * 设置orgType属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setOrgType(String value) {
    this.orgType = value;
  }

  /**
   * 获取isPoorEnterprise属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getIsPoorEnterprise() {
    return isPoorEnterprise;
  }

  /**
   * 设置isPoorEnterprise属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setIsPoorEnterprise(String value) {
    this.isPoorEnterprise = value;
  }

  /** 获取accountBalance属性的值。 */
  public double getAccountBalance() {
    return accountBalance;
  }

  /** 设置accountBalance属性的值。 */
  public void setAccountBalance(double value) {
    this.accountBalance = value;
  }

  /**
   * 获取inhosState属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getInhosState() {
    return inhosState;
  }

  /**
   * 设置inhosState属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setInhosState(String value) {
    this.inhosState = value;
  }

  /**
   * 获取blockadeReason属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getBlockadeReason() {
    return blockadeReason;
  }

  /**
   * 设置blockadeReason属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setBlockadeReason(String value) {
    this.blockadeReason = value;
  }
}
