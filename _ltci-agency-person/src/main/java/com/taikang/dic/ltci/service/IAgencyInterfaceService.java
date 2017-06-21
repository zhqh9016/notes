package com.taikang.dic.ltci.service;

import com.taikang.dic.ltci.api.model.AgencyDTO;
import com.taikang.dic.ltci.api.model.AgencyHistoryDTO;

public interface IAgencyInterfaceService {

  public int parseMessage(String message);

  public void getorgApplication(byte[] bytes);
  /**
   * 申请受理告知
   *
   * @param agency
   */
  public void sendOrgAcceptResult(AgencyHistoryDTO agency);
  /**
   * 审核结果告知
   *
   * @param agency
   */
  public void sendOrgApproveResult(AgencyDTO agency);
  /**
   * 变更审核结果告知
   *
   * @param agency
   */
  public void sendOrgChangeResult(AgencyDTO agency);
}
