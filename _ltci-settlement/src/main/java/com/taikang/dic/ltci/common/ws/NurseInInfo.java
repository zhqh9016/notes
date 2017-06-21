
package com.taikang.dic.ltci.common.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * nurseInInfo complex type�� Java �ࡣ
 *
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 *
 * <pre>
 * &lt;complexType name="nurseInInfo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://server.esb.iengine.medata.com/}changhuInput">
 *       &lt;sequence>
 *         &lt;element name="bedNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="department" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="diseaseCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="diseaseName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inRecorduuid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="medicalRecord" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="medicalType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="realInDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="uniqueNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
  name = "nurseInInfo",
  propOrder = {
    "bedNum",
    "department",
    "diseaseCode",
    "diseaseName",
    "inRecorduuid",
    "medicalRecord",
    "medicalType",
    "operator",
    "realInDate",
    "uniqueNumber"
  }
)
public class NurseInInfo extends ChanghuInput {

  protected String bedNum;
  protected String department;
  protected String diseaseCode;
  protected String diseaseName;
  protected String inRecorduuid;
  protected String medicalRecord;
  protected String medicalType;
  protected String operator;
  protected String realInDate;
  protected String uniqueNumber;

  /**
   * ��ȡbedNum���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getBedNum() {
    return bedNum;
  }

  /**
   * ����bedNum���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setBedNum(String value) {
    this.bedNum = value;
  }

  /**
   * ��ȡdepartment���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getDepartment() {
    return department;
  }

  /**
   * ����department���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setDepartment(String value) {
    this.department = value;
  }

  /**
   * ��ȡdiseaseCode���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getDiseaseCode() {
    return diseaseCode;
  }

  /**
   * ����diseaseCode���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setDiseaseCode(String value) {
    this.diseaseCode = value;
  }

  /**
   * ��ȡdiseaseName���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getDiseaseName() {
    return diseaseName;
  }

  /**
   * ����diseaseName���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setDiseaseName(String value) {
    this.diseaseName = value;
  }

  /**
   * ��ȡinRecorduuid���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getInRecorduuid() {
    return inRecorduuid;
  }

  /**
   * ����inRecorduuid���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setInRecorduuid(String value) {
    this.inRecorduuid = value;
  }

  /**
   * ��ȡmedicalRecord���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getMedicalRecord() {
    return medicalRecord;
  }

  /**
   * ����medicalRecord���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setMedicalRecord(String value) {
    this.medicalRecord = value;
  }

  /**
   * ��ȡmedicalType���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getMedicalType() {
    return medicalType;
  }

  /**
   * ����medicalType���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setMedicalType(String value) {
    this.medicalType = value;
  }

  /**
   * ��ȡoperator���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getOperator() {
    return operator;
  }

  /**
   * ����operator���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setOperator(String value) {
    this.operator = value;
  }

  /**
   * ��ȡrealInDate���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getRealInDate() {
    return realInDate;
  }

  /**
   * ����realInDate���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setRealInDate(String value) {
    this.realInDate = value;
  }

  /**
   * ��ȡuniqueNumber���Ե�ֵ��
   *
   * @return possible object is {@link String }
   */
  public String getUniqueNumber() {
    return uniqueNumber;
  }

  /**
   * ����uniqueNumber���Ե�ֵ��
   *
   * @param value allowed object is {@link String }
   */
  public void setUniqueNumber(String value) {
    this.uniqueNumber = value;
  }
}
