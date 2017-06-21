
package com.taikang.dic.ltci.common.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * registNurseInfo complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
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
   * 获取registRequest属性的值。
   *
   * @return possible object is {@link NurseInInfo }
   */
  public NurseInInfo getRegistRequest() {
    return registRequest;
  }

  /**
   * 设置registRequest属性的值。
   *
   * @param value allowed object is {@link NurseInInfo }
   */
  public void setRegistRequest(NurseInInfo value) {
    this.registRequest = value;
  }

  /**
   * 获取changhuCard属性的值。
   *
   * @return possible object is {@link ChanghuCard }
   */
  public ChanghuCard getChanghuCard() {
    return changhuCard;
  }

  /**
   * 设置changhuCard属性的值。
   *
   * @param value allowed object is {@link ChanghuCard }
   */
  public void setChanghuCard(ChanghuCard value) {
    this.changhuCard = value;
  }
}
