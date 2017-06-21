
package com.taikang.dic.ltci.common.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * queryNurseTreatment complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType name="queryNurseTreatment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idCardNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="insuredPersonName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
  name = "queryNurseTreatment",
  propOrder = {"idCardNum", "insuredPersonName"}
)
public class QueryNurseTreatment {

  protected String idCardNum;
  protected String insuredPersonName;

  /**
   * 获取idCardNum属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getIdCardNum() {
    return idCardNum;
  }

  /**
   * 设置idCardNum属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setIdCardNum(String value) {
    this.idCardNum = value;
  }

  /**
   * 获取insuredPersonName属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getInsuredPersonName() {
    return insuredPersonName;
  }

  /**
   * 设置insuredPersonName属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setInsuredPersonName(String value) {
    this.insuredPersonName = value;
  }
}
