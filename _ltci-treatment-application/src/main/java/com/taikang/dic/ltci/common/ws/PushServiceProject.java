
package com.taikang.dic.ltci.common.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * pushServiceProject complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType name="pushServiceProject">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="medicareCode" type="{http://server.esb.iengine.medata.com/}serviceProject" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
  name = "pushServiceProject",
  propOrder = {"medicareCode"}
)
public class PushServiceProject {

  protected ServiceProject medicareCode;

  /**
   * 获取medicareCode属性的值。
   *
   * @return possible object is {@link ServiceProject }
   */
  public ServiceProject getMedicareCode() {
    return medicareCode;
  }

  /**
   * 设置medicareCode属性的值。
   *
   * @param value allowed object is {@link ServiceProject }
   */
  public void setMedicareCode(ServiceProject value) {
    this.medicareCode = value;
  }
}
