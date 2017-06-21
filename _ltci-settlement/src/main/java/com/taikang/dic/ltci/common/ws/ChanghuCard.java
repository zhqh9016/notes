
package com.taikang.dic.ltci.common.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * changhuCard complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="changhuCard">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="PSAMCardNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sCardNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sCardType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sIDNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
  name = "changhuCard",
  propOrder = {"psamCardNum", "sCardNo", "sCardType", "sidNo", "sName"}
)
public class ChanghuCard {

  @XmlElement(name = "PSAMCardNum")
  protected String psamCardNum;

  protected String sCardNo;
  protected String sCardType;

  @XmlElement(name = "sIDNo")
  protected String sidNo;

  protected String sName;

  /**
   * ��ȡpsamCardNum���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getPSAMCardNum() {
    return psamCardNum;
  }

  /**
   * ����psamCardNum���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setPSAMCardNum(String value) {
    this.psamCardNum = value;
  }

  /**
   * ��ȡsCardNo���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getSCardNo() {
    return sCardNo;
  }

  /**
   * ����sCardNo���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setSCardNo(String value) {
    this.sCardNo = value;
  }

  /**
   * ��ȡsCardType���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getSCardType() {
    return sCardType;
  }

  /**
   * ����sCardType���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setSCardType(String value) {
    this.sCardType = value;
  }

  /**
   * ��ȡsidNo���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getSIDNo() {
    return sidNo;
  }

  /**
   * ����sidNo���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setSIDNo(String value) {
    this.sidNo = value;
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
}
