
package com.taikang.dic.ltci.common.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * treatmentState complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="treatmentState">
 *   &lt;complexContent>
 *     &lt;extension base="{http://server.esb.iengine.medata.com/}response">
 *       &lt;sequence>
 *         &lt;element name="treatment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noRreatmentReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
  name = "treatmentState",
  propOrder = {"treatment", "noRreatmentReason"}
)
public class TreatmentState extends Response {

  protected String treatment;
  protected String noRreatmentReason;

  /**
   * ��ȡtreatment���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getTreatment() {
    return treatment;
  }

  /**
   * ����treatment���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setTreatment(String value) {
    this.treatment = value;
  }

  /**
   * ��ȡnoRreatmentReason���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getNoRreatmentReason() {
    return noRreatmentReason;
  }

  /**
   * ����noRreatmentReason���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setNoRreatmentReason(String value) {
    this.noRreatmentReason = value;
  }
}
