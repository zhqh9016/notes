package com.taikang.dic.ltci.settlement.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.portal.api.model.OrgSettlementDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.util.UserUtils;
import com.taikang.dic.ltci.settlement.serverClient.OrgSettlementServerClient;
import com.taikang.dic.ltci.settlement.service.IOrgSettlementService;

@Service
public class OrgSettlementServiceImpl implements IOrgSettlementService {
  private Logger logger = LoggerFactory.getLogger(OrgSettlementServiceImpl.class);
  @Autowired private OrgSettlementServerClient orgSettlementServerClient;

  @Override
  public PageResultDTO countOrgData(
      OrgSettlementDTO orgSettlementDTO, Integer page, Integer pageSize) {
    logger.info("====Service层：进入countOrgData方法开始========");
    return orgSettlementServerClient.countOrgData(orgSettlementDTO, page, pageSize);
  }

  @Override
  public ResultDTO saveOrgData(OrgSettlementDTO orgSettlementDTO) {
    logger.info("====Service层：进入saveOrgData方法开始========");
    UserDTO user = UserUtils.getCurrentUser();
    if (user != null) {
      orgSettlementDTO.setOperatedBy(user.getUserName());
      if (user.getDepartment() != null)
        orgSettlementDTO.setOperatedOrg(user.getDepartment().getCode());
    }
    return orgSettlementServerClient.saveOrgData(orgSettlementDTO);
  }

  @Override
  public PageResultDTO listMonSetOrgForCheckReview(
      String orgName,
      String orgCode,
      String auditState,
      String startDate,
      String endDate,
      Integer page,
      Integer pageSize) {
    logger.info("====Service层：进入listMonSetOrgForCheckReview方法开始========");
    PageResultDTO pageResultDTO =
        orgSettlementServerClient.listMonSetOrgForCheckReview(
            orgName, orgCode, auditState, startDate, endDate, page, pageSize);
    return pageResultDTO;
  }

  @Override
  public ResultDTO selectById(String id) {
    logger.info("====Service层：进入selectById方法开始========");
    return orgSettlementServerClient.selectById(id);
  }

  @Override
  public ResultDTO updateAuditState(OrgSettlementDTO orgSet) {
    logger.info("====Service层：进入updateAuditState方法开始========");
    UserDTO user = UserUtils.getCurrentUser();
    if (user != null) {
      orgSet.setOperatedBy(user.getTrueName());
      if (user.getDepartment() != null) orgSet.setOperatedOrg(user.getDepartment().getCode());
    }
    return orgSettlementServerClient.updateAuditState(orgSet);
  }

  @Override
  public ResultDTO settleForOrg(OrgSettlementDTO orgSet) {
    logger.info("====Service层：进入settleForOrg方法开始========");
    UserDTO user = UserUtils.getCurrentUser();
    if (user != null) {
      orgSet.setOperatedBy(user.getTrueName());
      if (user.getDepartment() != null) orgSet.setOperatedOrg(user.getDepartment().getCode());
    }
    return orgSettlementServerClient.settleForOrg(orgSet);
  }
}
