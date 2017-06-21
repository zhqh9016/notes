package com.taikang.dic.ltci.service;

import java.util.List;
import java.util.Map;

import com.taikang.dic.ltci.api.model.AgencyHistoryDTO;
import com.taikang.dic.ltci.model.AgencyHistoryDO;

public interface IAgencyHistoryService {

  /**
   * 查询申请机构信息
   *
   * @param agencyName 机构名称
   * @param dsignatedAgencyLevel 定点机构类别
   * @param dsignatedAgencyType 定点服务机构类型
   * @param agencyType 机构类型
   * @param acceptState 受理状态
   * @param applyBeginDate 申请开始时间
   * @param applyEndDate 申请结束时间
   * @return
   */
  Map<String, Object> getAgencyApplyList(
      String agencyName,
      String dsignatedAgencyLevel,
      String dsignatedAgencyType,
      String agencyType,
      String acceptState,
      String applyBeginDate,
      String applyEndDate,
      Integer page,
      Integer pageSize);

  /**
   * 机构申请信息
   *
   * @param id 主键
   * @return
   */
  AgencyHistoryDO getAgencyHistory(String id);

  /**
   * 机构在线申请/变更处理
   *
   * @param agencyHisDto
   * @return
   */
  boolean agencyOnlineApplyUpdate(AgencyHistoryDTO agencyHisDto) throws ServiceException;

  /**
   * 根据主键和受理状态查询机构历史信息
   *
   * @param id
   * @param state
   * @return
   */
  List<AgencyHistoryDO> getAgencyHisByIdAndState(String id, Integer state);
}
