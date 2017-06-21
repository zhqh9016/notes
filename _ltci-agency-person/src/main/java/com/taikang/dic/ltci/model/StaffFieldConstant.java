package com.taikang.dic.ltci.model;

/**
 * 员工信息申述和变更接口使用的字段常量
 *
 * @author itw_zhangqh
 */
public class StaffFieldConstant {

  public static final String ACTIONTYPE = "actionType"; //操作类型（新增、变更、注销；变更时只传有变化的项目值）
  public static final String EMPCODE = "empCode"; //人员ID(专业系统生成）
  public static final String UNIQUENUMBER = "uniqueNumber"; //监管唯一认证ID注：申请时为空，变更时必传
  public static final String EMPNAME = "empName"; //人员姓名
  public static final String ORGCODE = "orgCode"; //隶属机构(经办端生成的机构编号)
  public static final String CARDTYPE = "cardType"; //证件类型
  public static final String CARDNUMBER = "cardNumber"; //证件号码
  public static final String CARD_NUM = "cardNum"; //证件号码(人员审核结果告知接口使用)
  public static final String GENDER = "gender"; //性别
  public static final String HIGHESTEDUCATION = "highestEducation"; //最高学历
  public static final String ACQUIREDDEGREE = "acquiredDegree"; //获得学位
  public static final String CERTIFICATEDATE = "certificateDate"; //发证日期
  public static final String JOBSCOPE = "jobScope"; //申请从业范围(人员职业：1.评估人员/2.护理人员/3.医疗护士/4.管理人员/5.其他)
  public static final String PRACTICECERTIFICATENUMBER = "practiceCertificateNumber"; //执业证书编号
  public static final String PRACTICELEVEL = "practiceLevel"; //执业级别
  public static final String PRACTICECERTIFICATEDATE = "practiceCertificateDate"; //执业证书有效期(发证日期)
  public static final String QUALIFICATIONCERTIFICATENUMBER =
      "qualificationCertificateNumber"; //资格证书编号
  public static final String QUALIFICATIONLEVEL = "qualificationLevel"; //资格证书级别(1初级职称2中级职称3高级职称)
  public static final String QUALIFICATIONCERTIFICATEDATE =
      "qualificationCertificateDate"; //资格证书有效期(发证日期)
  public static final String COMMENT = "comment"; //备注说明
  public static final String OPERATOR = "operator"; //申请人
  public static final String OPERATINGTIME = "operatingTime"; //申请日期
  public static final String STAFF_PHONE = "staffPhone"; //员工电话
  public static final String DIPLOMA_DATE = "diplomaDate"; //毕业证发证日期
  public static final String DEGREE_DATE = "degreeDate"; //学位证发证日期

  //============================附件相关===================================
  public static final String CREDENTIALS = "credentials"; //证件信息
  public static final String CREDENTIAL_TYPE =
      "credential_type"; //证件类型编码(可选值:idCardFile(身份证),educationFile(学历学位证书),certificateFile(职业资格证书),others(其它))
  public static final String CREDENTIAL_NAME = "credential_name"; //证件名称
  public static final String CREDENTIAL_LEVEL = "credential_level"; //证件等级
  public static final String CREDENTIAL_DATE = "credential_date"; //发证日期
  public static final String CREDENTIAL_CODE = "credential_code"; //证书编码
  public static final String FILE = "file"; //附件
  public static final String ACCESSORY_INFO = "info"; //附件内容byte[]类型
  public static final String FILE_NAME = "file_name"; //文件名
  public static final String FILE_TYPE = "file_type"; //文件格式

  //===========================证件编码===============================
  public static final String IDCARDFILE = "idCardFile"; //身份证附件
  public static final String EDUCATIONFILE = "educationFile"; //学历学位证书附件
  public static final String CERTIFICATEFILE = "certificateFile"; //职业资格证书附件
  public static final String OTHERS = "others"; //其它

  //===========================受理审核===================================
  public static final String ACCEPT_DATE = "acceptDate"; //受理日期
  public static final String CHECK_DATE = "checkDate"; //审核日期

  public static final String STATE = "state"; //受理状态
  public static final String AUDIT_STATE = "auditState"; //审核状态

  public static final String REASON = "reason"; //不受理原因
  public static final String REJECTION_REASON = "rejectionReason"; //审核不通过原因

  public static final String SUPERVISEDID = "supervisedId"; //监管唯一ID
}
