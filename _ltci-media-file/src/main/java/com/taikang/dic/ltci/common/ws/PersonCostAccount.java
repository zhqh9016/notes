
package com.taikang.dic.ltci.common.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * personCostAccount complex type的 Java 类。
 *
 * <p>以下模式片段指定包含在此类中的预期内容。
 *
 * <pre>
 * &lt;complexType name="personCostAccount">
 *   &lt;complexContent>
 *     &lt;extension base="{http://server.esb.iengine.medata.com/}response">
 *       &lt;sequence>
 *         &lt;element name="nurseTotalAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="siPay" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="paySelf" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="expenseSelf" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="mediAccountExpense" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="cashExpense" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
  name = "personCostAccount",
  propOrder = {
    "nurseTotalAmount",
    "siPay",
    "paySelf",
    "expenseSelf",
    "mediAccountExpense",
    "cashExpense",
    "startDate",
    "endDate"
  }
)
public class PersonCostAccount extends Response {

  protected double nurseTotalAmount;
  protected double siPay;
  protected double paySelf;
  protected double expenseSelf;
  protected double mediAccountExpense;
  protected double cashExpense;
  protected String startDate;
  protected String endDate;

  /** 获取nurseTotalAmount属性的值。 */
  public double getNurseTotalAmount() {
    return nurseTotalAmount;
  }

  /** 设置nurseTotalAmount属性的值。 */
  public void setNurseTotalAmount(double value) {
    this.nurseTotalAmount = value;
  }

  /** 获取siPay属性的值。 */
  public double getSiPay() {
    return siPay;
  }

  /** 设置siPay属性的值。 */
  public void setSiPay(double value) {
    this.siPay = value;
  }

  /** 获取paySelf属性的值。 */
  public double getPaySelf() {
    return paySelf;
  }

  /** 设置paySelf属性的值。 */
  public void setPaySelf(double value) {
    this.paySelf = value;
  }

  /** 获取expenseSelf属性的值。 */
  public double getExpenseSelf() {
    return expenseSelf;
  }

  /** 设置expenseSelf属性的值。 */
  public void setExpenseSelf(double value) {
    this.expenseSelf = value;
  }

  /** 获取mediAccountExpense属性的值。 */
  public double getMediAccountExpense() {
    return mediAccountExpense;
  }

  /** 设置mediAccountExpense属性的值。 */
  public void setMediAccountExpense(double value) {
    this.mediAccountExpense = value;
  }

  /** 获取cashExpense属性的值。 */
  public double getCashExpense() {
    return cashExpense;
  }

  /** 设置cashExpense属性的值。 */
  public void setCashExpense(double value) {
    this.cashExpense = value;
  }

  /**
   * 获取startDate属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getStartDate() {
    return startDate;
  }

  /**
   * 设置startDate属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setStartDate(String value) {
    this.startDate = value;
  }

  /**
   * 获取endDate属性的值。
   *
   * @return possible object is {@link String }
   */
  public String getEndDate() {
    return endDate;
  }

  /**
   * 设置endDate属性的值。
   *
   * @param value allowed object is {@link String }
   */
  public void setEndDate(String value) {
    this.endDate = value;
  }
}
