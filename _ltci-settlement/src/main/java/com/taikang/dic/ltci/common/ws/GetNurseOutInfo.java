
package com.taikang.dic.ltci.common.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * getNurseOutInfo complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="getNurseOutInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="outInfo" type="{http://server.esb.iengine.medata.com/}nurseOutInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
  name = "getNurseOutInfo",
  propOrder = {"outInfo"}
)
public class GetNurseOutInfo {

  protected NurseOutInfo outInfo;

  /**
   * ��ȡoutInfo���Ե�ֵ��
   *
   * @return possible object is {@link NurseOutInfo }
   */
  public NurseOutInfo getOutInfo() {
    return outInfo;
  }

  /**
   * ����outInfo���Ե�ֵ��
   *
   * @param value allowed object is {@link NurseOutInfo }
   */
  public void setOutInfo(NurseOutInfo value) {
    this.outInfo = value;
  }
}
