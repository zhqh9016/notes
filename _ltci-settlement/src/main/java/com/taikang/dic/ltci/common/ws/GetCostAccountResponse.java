
package com.taikang.dic.ltci.common.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * getCostAccountResponse complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="getCostAccountResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://server.esb.iengine.medata.com/}personCostAccount" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
  name = "getCostAccountResponse",
  propOrder = {"_return"}
)
public class GetCostAccountResponse {

  @XmlElement(name = "return")
  protected PersonCostAccount _return;

  /**
   * ��ȡreturn���Ե�ֵ��
   *
   * @return possible object is {@link PersonCostAccount }
   */
  public PersonCostAccount getReturn() {
    return _return;
  }

  /**
   * ����return���Ե�ֵ��
   *
   * @param value allowed object is {@link PersonCostAccount }
   */
  public void setReturn(PersonCostAccount value) {
    this._return = value;
  }
}
