
package com.taikang.dic.ltci.common.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * insuredInfo complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
   * ��ȡinsuredPersonName���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getInsuredPersonName() {
    return insuredPersonName;
  }

  /**
   * ����insuredPersonName���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setInsuredPersonName(String value) {
    this.insuredPersonName = value;
  }

  /**
   * ��ȡsiArea���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getSiArea() {
    return siArea;
  }

  /**
   * ����siArea���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setSiArea(String value) {
    this.siArea = value;
  }

  /**
   * ��ȡsiID���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getSiID() {
    return siID;
  }

  /**
   * ����siID���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setSiID(String value) {
    this.siID = value;
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
   * ��ȡsecurityNum���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getSecurityNum() {
    return securityNum;
  }

  /**
   * ����securityNum���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setSecurityNum(String value) {
    this.securityNum = value;
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
   * ��ȡresidencyProperty���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getResidencyProperty() {
    return residencyProperty;
  }

  /**
   * ����residencyProperty���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setResidencyProperty(String value) {
    this.residencyProperty = value;
  }

  /**
   * ��ȡpersonnelType���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getPersonnelType() {
    return personnelType;
  }

  /**
   * ����personnelType���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setPersonnelType(String value) {
    this.personnelType = value;
  }

  /**
   * ��ȡpersonalIdentity���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getPersonalIdentity() {
    return personalIdentity;
  }

  /**
   * ����personalIdentity���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setPersonalIdentity(String value) {
    this.personalIdentity = value;
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
   * ��ȡorgCode���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getOrgCode() {
    return orgCode;
  }

  /**
   * ����orgCode���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setOrgCode(String value) {
    this.orgCode = value;
  }
}
