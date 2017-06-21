package com.taikang.dic.ltci.service;

import java.util.List;
import java.util.Map;

import com.taikang.dic.ltci.model.MonSetPerDO;
import com.taikang.dic.ltci.model.PersonCostAccount;

/**
 * 月结算刷卡（个人）service
 *
 * @author itw-huodd E-mail:
 * @date 创建时间：2017年4月13日 下午2:15:17
 */
public interface IMonSetPerService extends GenericService<MonSetPerDO, String> {

  /**
   * step 1: 获取AMQ中的月结算刷卡信息 step 2: 解析AMQ中的费用信息 ①
   * 将头部信息存储在消息日志表中，如果在处理过程中出现错误，或者总的消息条数和消息头中的消息总数不符，需要记录 错误日志，并将完整的消息以json形式记录 ② 将消息实体存储月结算刷卡表
   */
  public void receiveMessage(byte[] b);

  /**
   * 保存个人月结明细数据
   *
   * @param message MQ消息的json串
   */
  public void saveMonSetPerData(String message) throws Exception;

  /**
   * 按条件分页查询个人月结算信息
   *
   * @param name 姓名
   * @param idCard 身份证号码
   * @param startDate 费用开始日期
   * @param endDate 费用终止日期
   * @param orgId 机构编号
   * @param unrFee 不合理费用
   * @param page 当前页
   * @param pageSize 每页显示件数
   * @return 个人月结算信息列表
   */
  Map<String, Object> listMonSetPer(
      String name,
      String idCard,
      String startDate,
      String endDate,
      String orgCode,
      Double unrFee,
      Integer page,
      Integer pageSize,
      String operateOrgCode);

  /**
   * 不合理费用录入
   *
   * @param daySetPerDo
   * @return
   */
  boolean enterUnrFee(MonSetPerDO monSetPerDo) throws ServiceException;

  /**
   * 根据ID和version查询个人月结算信息
   *
   * @param id
   * @param version
   * @return
   */
  List<MonSetPerDO> getMonSetByIdAndVersion(String id, Long version);

  public PersonCostAccount countPersonCost(String personInfo, String cardInfo);
}
