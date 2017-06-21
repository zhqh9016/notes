package com.taikang.dic.ltci.common;

/**
 * 常量类
 *
 * @author itw_liyh01
 */
public class ConstantUtil {

  /** 删除成功 */
  public static final String DELETE_SUCCESS = "删除成功";
  /** 删除条数为0 */
  public static final String DELETE_NO_ITEM = "请求删除的条目不存在";
  /** 删除请求中没有指定ID值 */
  public static final String DELETE_NO_ID = "删除请求必须指定ID";

  public static final String DELETE_LOWER_ORG = "请先删除下级组织";

  public static final String NOT_DELETE_USER_ORG = "不能删除有用户组织";

  public static final String OPERATION_SUCCESS = "操作成功";

  public static final String OPERATION_FAILED = "操作失败";

  /** 数据库操作成功 */
  public static final int DB_OPERATION_SUCCEED = 1;

  /** 数据库操作失败 */
  public static final int DB_OPERATION_FAILED = 0;

  //****************状态码********************
  public static final String SERVER_ERROR_CODE = "500";

  //*********费用审核状态************************
  public static final Integer WAITING_PROCESS = 1; //待处理
  public static final Integer ALREADY_AUDIT = 2; //已审核
  public static final Integer RECHECK_PASS = 3; //复核通过
  public static final Integer RECHECK_NOT_PASS = 4; //复核不通过
  public static final Integer ALREADY_SETTLED = 5; //已结算
  public static final Integer ALREADY_PAY = 6; //支付

  //*********护理费用明细常量*************************
  //长护登记流水号
  public static final String RECORD_UUID = "inRecorduuid";
  //交易流水号 发送方分配的UUID
  public static final String BUSINESS_SERIALID = "businessSerialid";
  //发送方系统编码
  public static final String SYS_CODE = "sysCode";
  //发送方模块编码
  public static final String MODULE_CODE = "moduleCode";
  //发送方节点IP
  public static final String NODE_IP = "nodeIP";
  //消息编码
  public static final String MESSAGE_CODE = "messageCode";
  //消息体
  public static final String DATA = "data";
  //定点机构编号
  public static final String ORG_CODE = "orgCode";
  //定点机构名称
  public static final String ORG_NAME = "orgName";
  //发送时间(时间戳)
  public static final String SEND_TIME = "sendTimestamp";
  //费用明细条数
  public static final String DETAIL_COUNT = "detailCount";
  //费用明细集合
  public static final String NURSING_DETAILS = "nursingDetails";
  //社会保障号
  public static final String SOC_SEC_NUM = "socSecNum";
  //护理对象姓名
  public static final String BE_CARE_PERSON_NAME = "beCarePersonName";
  //护理对象身份证号码
  public static final String BE_CARE_PERSON_CARD = "beCarePersonCard";
  //楼号
  public static final String BUILDING_NO = "buildingNo";
  //房间号
  public static final String ROOM_NO = "roomNo";
  //病区
  public static final String DISEASE_AREA = "diseaseArea";
  //床位号
  public static final String BED_NUM = "bedNum";
  //项目类别 1药品 2诊疗项目 3服务设施 4 护理项目
  public static final String PROJECT_TYPE = "projectType";

  //费用类别
  public static final String CHARGE_TYPE = "chargeType";
  //医疗类别
  public static final String MEDICAL_TYPE = "medicalType";
  //是否亲属照护
  public static final String IS_RELATIVE_CARE = "isRelativeCare";
  //交易流水号
  public static final String TRADE_NUM = "tradeNum";

  //医保服务项目编码
  public static final String MEDICARE_CODE = "medicareCode";
  //医保服务项目名称
  public static final String MEDICARE_NAME = "medicareName";
  //护理机构服务项目编码
  public static final String CARE_ORG_SERVICE_CODE = "careOrgServiceCode";
  //护理机构服务项目名称
  public static final String CARE_ORG_SERVICE_NAME = "careOrgServiceName";
  //费用发生日期
  public static final String FEE_DATE = "feeDate";
  //单价
  public static final String PRICE = "price";
  //数量
  public static final String COUNT = "count";
  //金额
  public static final String AMOUNT = "amount";
  //工时
  public static final String MAN_HOUR = "manHour";
  //护理人员编码
  public static final String NURSE_CODE = "nurseCode";
  //护理人员名称
  public static final String NURSE_NAME = "nurseName";
  //护理日期
  public static final String NURSE_TIME = "nurseTime";
  //上帐人编码
  public static final String CHARGE_PERSON_CODE = "chargePersonCd";
  //上帐人名称
  public static final String CHARGE_PERSON_NAME = "chargePersonName";
  //上帐科室编码
  public static final String CHARGE_DEPT_CODE = "chargeDeptCd";
  public static final String PARSE_MESSAGE_ERROR = "护理明细消息解析异常";
  //消息异常标识  1异常 0正常
  public static final Integer IS_EXCEPTION = 1;
  public static final Integer IS_NOT_EXCEPTION = 0;
  //消息头发送时间戳
  public static final String TIMESTAMP = "TIMESTAMP";

  //****************护理费用明细：是否同步状态码********************
  /** 待同步 */
  public static final Integer IS_SYSN_PENDING = 0;
  /** 同步完成 */
  public static final Integer IS_SYSN_FINISHED = 1;
  /** 同步中 */
  public static final Integer IS_SYSN_PROCESSING = 2;
  /** 同步失败 */
  public static final Integer IS_SYSN_FAIL = 3;

  //*******支付状态码*******
  public static final Integer PUB_PAY_STATUS_YES = 1; //对公支付完成
  public static final Integer PUB_PAY_STATUS_NO = 0; //对公支付未完成
  public static final Integer PER_PAY_STATUS_YES = 1; //个人支付完成
  public static final Integer PER_PAY_STATUS_NO = 0; //个人支付未完成
  //更新审核状态时,指定的参数不全时的提示信息
  public static final String UPDATE_AUDIT_STATE_PARAM_ERROR = "机构编码、费用开始时间、费用结束之间、审核状态必须指定";

  /** 个人月结接收MQ消息重试链接地址 */
  public static final String RETRY_URL_MON_SET_PER = "/monSetPer/receive/retry";

  //*************费用计算校验项**************
  /** 参保人是否在院 */
  public static final String INSURED_PERSON_IN_HOSPITAL = "INSURED_PERSON_IN_HOSPITAL";
  /** 参保人是否享受待遇 */
  public static final String INSURED_PERSON_TREATMENT = "INSURED_PERSON_TREATMENT";
  /** 服务目录是否有效 */
  public static final String SERVICE_ITEM = "SERVICE_ITEM";
  /** 护理机构是否有效 */
  public static final String NURSE_AGENCY = "NURSE_AGENCY";
  /** 护理人员是否有效 */
  public static final String NURSE_PERSON = "NURSE_PERSON";

  //专业个人费用预结算、结算返回状态码
  public static final String PERSON_SETTLE_RESPONSE_CODE_SUCESS = "0";
  public static final String PERSON_SETTLE_RESPONSE_CODE_ERROR = "-1";
  
  //明细计算返回状态码
  public static final String COUNT_DETAIL_RESPONSE_CODE_SUCESS = "0";
  public static final String COUNT_DETAIL_RESPONSE_CODE_ERROR = "-1";
  //明细计算校验结果常量
  public static final String FLAG = "flag";
  public static final String NURSE_AMOUNT = "nurseAmount";

  //专业是否使用账户支付的标识
  public static final String PERSON_SETTLE_USE_ACCOUNT = "1";
  public static final String PERSON_SETTLE_NOT_USE_ACCOUNT = "0";

  //专业预结算标识
  public static final String PERSON_SETTLE_PRE_BALANCE = "1"; //预结算
  public static final String PERSON_SETTLE_BALANCE = "2"; //结算
}
