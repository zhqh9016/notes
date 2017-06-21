
package com.taikang.dic.ltci.common.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * response complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType name="response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="errorReasonCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="errorReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactionNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cycleNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
  name = "response",
  propOrder = {"errorReasonCode", "errorReason", "transactionNum", "cycleNum"}
)
@XmlSeeAlso({
  TreatmentState.class,
  PersonCostAccount.class,
  ErrorReason.class,
  SsCard.class,
  NurseAmountDetail.class,
  InsuredInfo.class
})
public abstract class Response {

  protected String errorReasonCode;
  protected String errorReason;
  protected String transactionNum;
  protected String cycleNum;

  /**
   * 获取errorReasonCode属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getErrorReasonCode() {
    return errorReasonCode;
  }

  /**
   * 设置errorReasonCode属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setErrorReasonCode(String value) {
    this.errorReasonCode = value;
  }

  /**
   * 获取errorReason属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getErrorReason() {
    return errorReason;
  }

  /**
   * 设置errorReason属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setErrorReason(String value) {
    this.errorReason = value;
  }

  /**
   * 获取transactionNum属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getTransactionNum() {
    return transactionNum;
  }

  /**
   * 设置transactionNum属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setTransactionNum(String value) {
    this.transactionNum = value;
  }

  /**
   * 获取cycleNum属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getCycleNum() {
    return cycleNum;
  }

  /**
   * 设置cycleNum属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setCycleNum(String value) {
    this.cycleNum = value;
  }
}
