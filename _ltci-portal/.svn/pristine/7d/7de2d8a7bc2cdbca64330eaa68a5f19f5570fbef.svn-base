package com.taikang.dic.ltci.settlement.service;

import com.taikang.dic.ltci.portal.api.model.OrgSettlementDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

public interface IOrgSettlementService {

  /** 统计机构月结信息 */
  public PageResultDTO countOrgData(
      OrgSettlementDTO orgSettlementDTO, Integer page, Integer pageSize);
  /** 保存审核通过的机构月结信息 */
  public ResultDTO saveOrgData(OrgSettlementDTO orgSettlementDTO);

  public PageResultDTO listMonSetOrgForCheckReview(
      String orgName,
      String orgCode,
      String checkFlag,
      String startDate,
      String endDate,
      Integer page,
      Integer pageSize);

  public ResultDTO selectById(String id);

  public ResultDTO updateAuditState(OrgSettlementDTO orgSet);

  public ResultDTO settleForOrg(OrgSettlementDTO orgSet);
}
