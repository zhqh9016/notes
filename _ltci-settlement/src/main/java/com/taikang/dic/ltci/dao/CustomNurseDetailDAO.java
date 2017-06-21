package com.taikang.dic.ltci.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.taikang.dic.ltci.model.DaySetPerDO;
import com.taikang.dic.ltci.model.PersonCostAccount;

@Mapper
public interface CustomNurseDetailDAO {

  public List<DaySetPerDO> countDaySetPer(Map<String, String> parameters);

  public List<String> getUnSynForSocialPers(Map<String, String> parameters);
  /**
   * 入参有两个inRecorduuid和feeDate,都是必传的
   *
   * @param parameters
   * @return
   */
  public PersonCostAccount settleForPerson(Map<String, String> parameters);

  /**
   * 查看个人结算费用开始时间
   *
   * @param parameters
   * @return
   */
  public Date queryStartFeeDate(Map<String, String> parameters);

  /**
   * 查看个人结算费用结束时间
   *
   * @param parameters
   * @return
   */
  public Date queryEndFeeDate(Map<String, String> parameters);
}
