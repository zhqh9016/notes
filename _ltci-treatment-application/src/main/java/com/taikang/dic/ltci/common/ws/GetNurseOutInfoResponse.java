
package com.taikang.dic.ltci.common.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * getNurseOutInfoResponse complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType name="getNurseOutInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://server.esb.iengine.medata.com/}errorReason" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
  name = "getNurseOutInfoResponse",
  propOrder = {"_return"}
)
public class GetNurseOutInfoResponse {

  @XmlElement(name = "return")
  protected ErrorReason _return;

  /**
   * 获取return属性的值。
   *
   * @return possible object is {@link ErrorReason }
   */
  public ErrorReason getReturn() {
    return _return;
  }

  /**
   * 设置return属性的值。
   *
   * @param value allowed object is {@link ErrorReason }
   */
  public void setReturn(ErrorReason value) {
    this._return = value;
  }
}
