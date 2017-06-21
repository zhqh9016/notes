
package com.taikang.dic.ltci.common.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * readSSCard complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="readSSCard">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="changhuCard" type="{http://server.esb.iengine.medata.com/}changhuCard" minOccurs="0"/>
 *         &lt;element name="uniqueNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
  name = "readSSCard",
  propOrder = {"changhuCard", "uniqueNumber", "operator"}
)
public class ReadSSCard {

  protected ChanghuCard changhuCard;
  protected String uniqueNumber;
  protected String operator;

  /**
   * ��ȡchanghuCard���Ե�ֵ��
   *
   * @return possible object is {@link ChanghuCard }
   */
  public ChanghuCard getChanghuCard() {
    return changhuCard;
  }

  /**
   * ����changhuCard���Ե�ֵ��
   *
   * @param value allowed object is {@link ChanghuCard }
   */
  public void setChanghuCard(ChanghuCard value) {
    this.changhuCard = value;
  }

  /**
   * ��ȡuniqueNumber���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getUniqueNumber() {
    return uniqueNumber;
  }

  /**
   * ����uniqueNumber���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setUniqueNumber(String value) {
    this.uniqueNumber = value;
  }

  /**
   * ��ȡoperator���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getOperator() {
    return operator;
  }

  /**
   * ����operator���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setOperator(String value) {
    this.operator = value;
  }
}
