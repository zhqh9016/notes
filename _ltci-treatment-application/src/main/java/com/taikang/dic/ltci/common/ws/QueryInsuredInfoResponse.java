
package com.taikang.dic.ltci.common.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * queryInsuredInfoResponse complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType name="queryInsuredInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://server.esb.iengine.medata.com/}insuredInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
  name = "queryInsuredInfoResponse",
  propOrder = {"_return"}
)
public class QueryInsuredInfoResponse {

  @XmlElement(name = "return")
  protected InsuredInfo _return;

  /**
   * 获取return属性的值。
   *
   * @return possible object is {@link InsuredInfo }
   */
  public InsuredInfo getReturn() {
    return _return;
  }

  /**
   * 设置return属性的值。
   *
   * @param value allowed object is {@link InsuredInfo }
   */
  public void setReturn(InsuredInfo value) {
    this._return = value;
  }
}
