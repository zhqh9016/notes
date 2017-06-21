package com.taikang.dic.ltci.mqmodel;

/**
 * MQ消息发送封装Model
 *
 * @author itw_muwg
 * @description 申诉复议接收参数
 */
public class AppealReconsiderModel {

  /** 交易流水:发送方系统分配的UUID */
  public static final String SER_NUM = "serialNumber";
  /** 任务id，经办系统的任务id */
  public static final String PATROL_TASK_ID = "patrolTaskId";
  /** 复议申请人 */
  public static final String RECON_APPLICANT = "reconsiderationApplicant";
  /** 复议申请人联系电话 */
  public static final String RECON_APPLICANT_PHONE = "reconsiderationApplicantPhone";
  /** 复议申请内容 */
  public static final String RECON_CONTENT = "reconsiderationContent";
  /** 复议申请时间 */
  public static final String RECON_DATE = "reconsiderationDate";
  /** 附件list */
  public static final String ADDITIONS = "additions";
  /** 附件内容 */
  public static final String ADDITION_INFO = "additionalInfo";
  /** 附件类型 */
  public static final String ADDITION_TYPE = "additionalInfoType";
  /** 专业系统附件ID */
  public static final String ADDITION_INFO_ID = "additionalInfoID";

  private AppealReconsiderModel() {}
}
