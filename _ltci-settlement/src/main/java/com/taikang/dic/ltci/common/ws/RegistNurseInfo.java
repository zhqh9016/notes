
package com.taikang.dic.ltci.common.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * registNurseInfo complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="registNurseInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="registRequest" type="{http://server.esb.iengine.medata.com/}nurseInInfo" minOccurs="0"/>
 *         &lt;element name="changhuCard" type="{http://server.esb.iengine.medata.com/}changhuCard" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
  name = "registNurseInfo",
  propOrder = {"registRequest", "changhuCard"}
)
public class RegistNurseInfo {

  protected NurseInInfo registRequest;
  protected ChanghuCard changhuCard;

  /**
   * ��ȡregistRequest���Ե�ֵ��
   *
   * @return possible object is {@link NurseInInfo }
   */
  public NurseInInfo getRegistRequest() {
    return registRequest;
  }

  /**
   * ����registRequest���Ե�ֵ��
   *
   * @param value allowed object is {@link NurseInInfo }
   */
  public void setRegistRequest(NurseInInfo value) {
    this.registRequest = value;
  }

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
}
