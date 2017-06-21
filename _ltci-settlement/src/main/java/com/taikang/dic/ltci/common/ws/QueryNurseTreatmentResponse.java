
package com.taikang.dic.ltci.common.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * queryNurseTreatmentResponse complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="queryNurseTreatmentResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://server.esb.iengine.medata.com/}treatmentState" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
  name = "queryNurseTreatmentResponse",
  propOrder = {"_return"}
)
public class QueryNurseTreatmentResponse {

  @XmlElement(name = "return")
  protected TreatmentState _return;

  /**
   * ��ȡreturn���Ե�ֵ��
   *
   * @return possible object is {@link TreatmentState }
   */
  public TreatmentState getReturn() {
    return _return;
  }

  /**
   * ����return���Ե�ֵ��
   *
   * @param value allowed object is {@link TreatmentState }
   */
  public void setReturn(TreatmentState value) {
    this._return = value;
  }
}
