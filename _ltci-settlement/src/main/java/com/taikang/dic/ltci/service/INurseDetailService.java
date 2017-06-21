package com.taikang.dic.ltci.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.taikang.dic.ltci.model.NurseDetailDO;

/**
 * 费用明细service
 *
 * @author longfei04 E-mail:
 * @version 创建时间：2017年4月13日 下午2:15:17
 */
public interface INurseDetailService extends GenericService<NurseDetailDO, String> {

  /**
   * step 1: 获取AMQ中的费用明细信息 step 2: 解析AMQ中的费用信息 ①
   * 将头部信息存储在消息日志表中，如果在处理过程中出现错误，或者总的消息条数和消息头中的消息总数不符，需要记录 错误日志，并将完整的消息以json形式记录 ② 将消息实体存储费用明细表
   */
  public void receiveMessage(byte[] b);

  public int putNurseDetailMessage(String message);

  /** 个人护理费用明细 */
  Map<String, Object> listPersonNurseDetail(
      String orgCode,
      String inRecorduuid,
      String beCarePersonCard,
      String feeBeginDate,
      String feeEndDate,
      int page,
      int pageSize);

  /**
   * 根据编码,日期汇总人的明细信息
   *
   * @param socSecNum 个人社会保障号
   * @param feeDate 费用产生日期
   * @param orgCode 机构编码
   * @return
   */
  public void countDaySetPer(String socSecNum, Date feeDate, String orgCode);

  /**
   * 1、默认查询前一天（对应字段：费用日期）且待上传(IsSynForSocial待上传到第三方社保)的明细（也可以指定某一天待上传的明细） 2、逐条上传到第三方（社保）
   * 3、根据逐条返回的结果更新明细数据状态 4、容错处理机制：如果有一条明细失败出现三次，这记录失败日志；本次；待人工进行处理；
   *
   * <p>5、调用个人日结算接口，参数个人标识、费用日期，都非必传 6、调用数据同步到专业服务系统
   *
   * @param feiDate 费用日期
   * @param sysnStatus 同步状态：只能是0,3
   * @param orgCode 机构编码
   */
  public void uploadDetailToThirdParty(String feiDate, Integer sysnStatus, String orgCode);

  /**
   * 同步费用明细到第三方
   *
   * @param nerseDetails 费用明细
   */
  public void uploadDetailToThirdParty(List<NurseDetailDO> nerseDetails);

  /**
   * 1、默认查询前一天（对应字段：费用日期）且待上传的明细（也可以指定某一天待上传的明细） 2、打包一并上传到专业服务系统MQ
   *
   * @param feiDate 费用日期
   * @param sysnStatus 同步状态：只能是0,3
   * @param orgCode 机构编码
   */
  public void uploadDetailToOrg(String feiDate, Integer sysnStatus, String orgCode);
}
