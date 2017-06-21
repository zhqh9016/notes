
package com.taikang.dic.ltci.common.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * pushServiceProjectResponse complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="pushServiceProjectResponse">
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
  name = "pushServiceProjectResponse",
  propOrder = {"_return"}
)
public class PushServiceProjectResponse {

  @XmlElement(name = "return")
  protected ErrorReason _return;

  /**
   * ��ȡreturn���Ե�ֵ��
   *
   * @return possible object is {@link ErrorReason }
   */
  public ErrorReason getReturn() {
    return _return;
  }

  /**
   * ����return���Ե�ֵ��
   *
   * @param value allowed object is {@link ErrorReason }
   */
  public void setReturn(ErrorReason value) {
    this._return = value;
  }
}
