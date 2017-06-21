package com.taikang.dic.ltci.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.api.model.AgencyDTO;
import com.taikang.dic.ltci.api.model.AgencyHistoryDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.model.AgencyDO;
import com.taikang.dic.ltci.model.AgencyHistoryDO;
import com.taikang.dic.ltci.service.IAgencyAuditService;

/**
 * 机构审核RoleController
 *
 * @author itw_liuzy 2017-05-10
 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class AgencyAuditController {
  private Logger logger = LoggerFactory.getLogger(AgencyAuditController.class);

  @Autowired IAgencyAuditService agencyAuditService;
  /**
   * 按条件分页查询机构列表
   *
   * @param agencyHistoryDTO 查询条件
   * @param page 当前页码
   * @param pageSize 每页显示件数
   * @return 已受理机构信息列表
   */
  @RequestMapping(path = "/agency/audit/list", method = RequestMethod.GET)
  @ResponseBody
  public PageResultDTO listAgencyAudit(
      String agencyName,
      String agencyLevel,
      String agencyServiceType,
      String agencyType,
      String agencyState,
      String operatedBeginDate,
      String operatedEndDate,
      String applyBeginDate,
      String applyEndDate,
      String actionType,
      int page,
      int pageSize) {
    logger.debug(
        "_listAgencyAudit___agencyName="
            + agencyName
            + "___page="
            + page
            + "___pageSize="
            + pageSize);

    Map<String, Object> model =
        agencyAuditService.listAgencyAudit(
            agencyName,
            agencyLevel,
            agencyServiceType,
            agencyType,
            agencyState,
            operatedBeginDate,
            operatedEndDate,
            applyBeginDate,
            applyEndDate,
            actionType,
            page,
            pageSize);

    PageResultDTO pageRet = new PageResultDTO();
    pageRet.setPage(page);
    pageRet.setPageSize(pageSize);
    pageRet.setTotalDataNum(Integer.parseInt(model.get("totalDataNum").toString()));
    pageRet.setTotalPageNum(Integer.parseInt(model.get("totalPageNum").toString()));
    @SuppressWarnings("unchecked")
    List<AgencyHistoryDO> agencyAuditList =
        (List<AgencyHistoryDO>) model.get("agencyHistoryDOList");

    List<AgencyHistoryDTO> agencyDtoList = new ArrayList<>();
    for (AgencyHistoryDO agency : agencyAuditList) {
      AgencyHistoryDTO agencyAudit = new AgencyHistoryDTO();
      BeanUtils.copyProperties(agency, agencyAudit);
      if (agency.getAgencyApplyDate() != null) {
        agencyAudit.setAgencyApplyDate(
            DateFormatUtil.dateToStr(
                agency.getAgencyApplyDate(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      }
      if (agency.getOperatedTime() != null) {
        agencyAudit.setOperatedTime(
            DateFormatUtil.dateToStr(
                agency.getOperatedTime(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      }
      agencyDtoList.add(agencyAudit);
    }
    pageRet.setDatas(agencyDtoList);
    pageRet.setStatus(200);
    pageRet.setMessage("查询已受理机构成功");
    return pageRet;
  }

  @RequestMapping(path = "/agency/list", method = RequestMethod.POST)
  @ResponseBody
  public PageResultDTO listAgency(
      String agencyName,
      String agencyType,
      String agencyCode,
      @RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "pageSize", defaultValue = "100") int pageSize) {

    Map<String, Object> model =
        agencyAuditService.listAgency(agencyName, agencyType, agencyCode, page, pageSize);

    PageResultDTO pageRet = new PageResultDTO();
    pageRet.setPage(page);
    pageRet.setPageSize(pageSize);
    pageRet.setTotalDataNum(Integer.parseInt(model.get("totalDataNum").toString()));
    pageRet.setTotalPageNum(Integer.parseInt(model.get("totalPageNum").toString()));
    @SuppressWarnings("unchecked")
    List<AgencyDO> agencyAuditList = (List<AgencyDO>) model.get("agencyDOList");

    List<AgencyDTO> agencyDtoList = new ArrayList<>();
    for (AgencyDO agency : agencyAuditList) {
      AgencyDTO agencyAudit = new AgencyDTO();
      BeanUtils.copyProperties(agency, agencyAudit);
      if (agency.getCreatedTime() != null) {
        agencyAudit.setCreatedTime(
            DateFormatUtil.dateToStr(
                agency.getCreatedTime(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      }
      if (agency.getOperatedTime() != null) {
        agencyAudit.setOperatedTime(
            DateFormatUtil.dateToStr(
                agency.getOperatedTime(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      }
      if (agency.getKeyBeginDate() != null) {
        agencyAudit.setKeyBeginDate(
            DateFormatUtil.dateToStr(
                agency.getKeyBeginDate(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      }
      if (agency.getKeyEndDate() != null) {
        agencyAudit.setKeyEndDate(
            DateFormatUtil.dateToStr(
                agency.getKeyEndDate(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      }
      agencyDtoList.add(agencyAudit);
    }
    pageRet.setDatas(agencyDtoList);
    pageRet.setStatus(200);
    pageRet.setMessage("查询成功");
    return pageRet;
  }

  /**
   * 查询机构变更信息
   *
   * @param serialNum 流水号
   * @return AgencyDTO
   */
  @RequestMapping(path = "/agency/update", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO getAgencyDetail(@RequestParam String serialNum) {
    return agencyAuditService.getAgencyDetail(serialNum);
  }

  /**
   * 查询机构秘钥时间
   *
   * @param serialNum 流水号
   * @return AgencyDTO
   */
  @RequestMapping(path = "/agency/key/time", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO getKeyTime(String serialNum) {

    List<AgencyDO> agencyDOList = agencyAuditService.getKeyTime(serialNum);

    ResultDTO pageRet = new ResultDTO();
    List<AgencyDTO> agencyDtoList = new ArrayList<>();
    for (AgencyDO agency : agencyDOList) {
      AgencyDTO agencyAudit = new AgencyDTO();
      BeanUtils.copyProperties(agency, agencyAudit);
      if (agency.getKeyBeginDate() != null) {
        agencyAudit.setKeyBeginDate(
            DateFormatUtil.dateToStr(
                agency.getKeyBeginDate(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      }
      if (agency.getKeyEndDate() != null) {
        agencyAudit.setKeyEndDate(
            DateFormatUtil.dateToStr(
                agency.getKeyEndDate(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      }
      agencyDtoList.add(agencyAudit);
    }
    pageRet.setDatas(agencyDtoList);
    pageRet.setStatus(200);
    pageRet.setMessage("查询成功");
    return pageRet;
  }
}
