
package com.taikang.dic.ltci.common.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * ssCard complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
   * ��ȡindividualNo���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getIndividualNo() {
    return individualNo;
  }

  /**
   * ����individualNo���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setIndividualNo(String value) {
    this.individualNo = value;
  }

  /**
   * ��ȡorgNo���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getOrgNo() {
    return orgNo;
  }

  /**
   * ����orgNo���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setOrgNo(String value) {
    this.orgNo = value;
  }

  /**
   * ��ȡidCard���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getIdCard() {
    return idCard;
  }

  /**
   * ����idCard���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setIdCard(String value) {
    this.idCard = value;
  }

  /**
   * ��ȡsName���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getSName() {
    return sName;
  }

  /**
   * ����sName���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setSName(String value) {
    this.sName = value;
  }

  /**
   * ��ȡgender���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getGender() {
    return gender;
  }

  /**
   * ����gender���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setGender(String value) {
    this.gender = value;
  }

  /**
   * ��ȡnation���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getNation() {
    return nation;
  }

  /**
   * ����nation���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setNation(String value) {
    this.nation = value;
  }

  /**
   * ��ȡbirthday���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getBirthday() {
    return birthday;
  }

  /**
   * ����birthday���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setBirthday(String value) {
    this.birthday = value;
  }

  /**
   * ��ȡssCardNo���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getSsCardNo() {
    return ssCardNo;
  }

  /**
   * ����ssCardNo���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setSsCardNo(String value) {
    this.ssCardNo = value;
  }

  /**
   * ��ȡmedicalType���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getMedicalType() {
    return medicalType;
  }

  /**
   * ����medicalType���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setMedicalType(String value) {
    this.medicalType = value;
  }

  /**
   * ��ȡmcNo���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getMcNo() {
    return mcNo;
  }

  /**
   * ����mcNo���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setMcNo(String value) {
    this.mcNo = value;
  }

  /**
   * ��ȡpersonnelState���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getPersonnelState() {
    return personnelState;
  }

  /**
   * ����personnelState���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setPersonnelState(String value) {
    this.personnelState = value;
  }

  /**
   * ��ȡinsuredState���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getInsuredState() {
    return insuredState;
  }

  /**
   * ����insuredState���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setInsuredState(String value) {
    this.insuredState = value;
  }

  /**
   * ��ȡssCardPwd���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getSsCardPwd() {
    return ssCardPwd;
  }

  /**
   * ����ssCardPwd���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setSsCardPwd(String value) {
    this.ssCardPwd = value;
  }

  /**
   * ��ȡmedicalPlanning���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getMedicalPlanning() {
    return medicalPlanning;
  }

  /**
   * ����medicalPlanning���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setMedicalPlanning(String value) {
    this.medicalPlanning = value;
  }

  /**
   * ��ȡorgType���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getOrgType() {
    return orgType;
  }

  /**
   * ����orgType���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setOrgType(String value) {
    this.orgType = value;
  }

  /**
   * ��ȡisPoorEnterprise���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getIsPoorEnterprise() {
    return isPoorEnterprise;
  }

  /**
   * ����isPoorEnterprise���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setIsPoorEnterprise(String value) {
    this.isPoorEnterprise = value;
  }

  /** ��ȡaccountBalance���Ե�ֵ�� */
  public double getAccountBalance() {
    return accountBalance;
  }

  /** ����accountBalance���Ե�ֵ�� */
  public void setAccountBalance(double value) {
    this.accountBalance = value;
  }

  /**
   * ��ȡinhosState���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getInhosState() {
    return inhosState;
  }

  /**
   * ����inhosState���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setInhosState(String value) {
    this.inhosState = value;
  }

  /**
   * ��ȡblockadeReason���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getBlockadeReason() {
    return blockadeReason;
  }

  /**
   * ����blockadeReason���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setBlockadeReason(String value) {
    this.blockadeReason = value;
  }
}
