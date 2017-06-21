
package com.taikang.dic.ltci.common.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * getCostAccountResponse complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
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
   * 获取return属性的值。
   *
   * @return possible object is {@link PersonCostAccount }
   */
  public PersonCostAccount getReturn() {
    return _return;
  }

  /**
   * 设置return属性的值。
   *
   * @param value allowed object is {@link PersonCostAccount }
   */
  public void setReturn(PersonCostAccount value) {
    this._return = value;
  }
}
