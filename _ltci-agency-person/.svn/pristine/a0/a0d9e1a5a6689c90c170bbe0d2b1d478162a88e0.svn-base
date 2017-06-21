package com.taikang.dic.ltci.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.api.model.AgencyHistoryDTO;
import com.taikang.dic.ltci.api.model.FileDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.ActionTypeEnum;
import com.taikang.dic.ltci.common.enumeration.AgencyStateEnum;
import com.taikang.dic.ltci.common.enumeration.ExecutionStatusEnum;
import com.taikang.dic.ltci.common.enumeration.ObjectTypeEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.model.AgencyDO;
import com.taikang.dic.ltci.model.AgencyHistoryDO;
import com.taikang.dic.ltci.model.AgencyStaffFileRDO;
import com.taikang.dic.ltci.service.IAgencyHistoryService;
import com.taikang.dic.ltci.service.IAgencyInterfaceService;
import com.taikang.dic.ltci.service.IAgencyService;
import com.taikang.dic.ltci.service.IAgencyStaffFileService;
import com.taikang.dic.ltci.service.ServiceException;

@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class AgencyHistoryController {
  private Logger logger = LoggerFactory.getLogger(AgencyHistoryController.class);
  public static final String RETRY_URL = "/retry/agency";

  @Autowired private IAgencyHistoryService agencyHistoryService;

  @Autowired private IAgencyInterfaceService agencyInterfaceService;

  @Autowired private IAgencyStaffFileService fileService;

  @Autowired private IAgencyService agencyService;

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
   * @param page 页码
   * @param pageSize 每页显示件数
   * @return
   */
  @SuppressWarnings("unchecked")
  @RequestMapping(value = "/agencyHistory/list", method = RequestMethod.GET)
  @ResponseBody
  public PageResultDTO getAgencyApplyList(
      String agencyName,
      String dsignatedAgencyLevel,
      String dsignatedAgencyType,
      String agencyType,
      String acceptState,
      String applyBeginDate,
      String applyEndDate,
      Integer page,
      Integer pageSize) {

    Map<String, Object> model =
        agencyHistoryService.getAgencyApplyList(
            agencyName,
            dsignatedAgencyLevel,
            dsignatedAgencyType,
            agencyType,
            acceptState,
            applyBeginDate,
            applyEndDate,
            page,
            pageSize);
    PageResultDTO pageRet = new PageResultDTO();
    pageRet.setPage(page);
    pageRet.setPageSize(pageSize);
    pageRet.setTotalDataNum(Integer.parseInt(model.get("totalDataNum").toString()));
    pageRet.setTotalPageNum(Integer.parseInt(model.get("totalPageNum").toString()));
    List<AgencyHistoryDO> agencyHistoryList =
        (List<AgencyHistoryDO>) model.get("agencyHistoryList");
    List<AgencyHistoryDTO> agencyDtoList = new ArrayList<>();
    for (AgencyHistoryDO agencyHistory : agencyHistoryList) {
      AgencyHistoryDTO agencyDto = new AgencyHistoryDTO();
      BeanUtils.copyProperties(agencyHistory, agencyDto);
      if (agencyHistory.getAgencyApplyDate() != null) {
        agencyDto.setAgencyApplyDate(
            DateFormatUtil.dateToStr(
                agencyHistory.getAgencyApplyDate(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      }
      agencyDtoList.add(agencyDto);
    }
    pageRet.setStatus(StatusCodeEnum.OK.getValue());
    pageRet.setDatas(agencyDtoList);
    return pageRet;
  }

  /**
   * 机构申请信息
   *
   * @param id 主键
   * @return
   */
  @RequestMapping(path = "/agencyHistory/{id}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO getAgencyHistory(@PathVariable String id) {
    ResultDTO resultDto = new ResultDTO();
    // 查询机构信息
    AgencyHistoryDO agencyDo = agencyHistoryService.getAgencyHistory(id);
    AgencyHistoryDTO agencyDto = new AgencyHistoryDTO();
    BeanUtils.copyProperties(agencyDo, agencyDto);
    if (agencyDo.getAgencyApplyDate() != null) {
      agencyDto.setAgencyApplyDate(
          DateFormatUtil.dateToStr(
              agencyDo.getAgencyApplyDate(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
    }
    // 查询机构附件信息
    List<AgencyStaffFileRDO> fileDoList;
    if (AgencyStateEnum.STATE_AUDIT.getValue().equals(agencyDo.getAgencyState())) {
      fileDoList =
          fileService.getAgencyStaffFile(agencyDo.getAgencyCode(), ObjectTypeEnum.ORG.getValue());
    } else {
      fileDoList =
          fileService.getAgencyStaffFileById(
              agencyDo.getSerialNum(), ObjectTypeEnum.ORG.getValue());
    }
    List<FileDTO> fileDtoList = new ArrayList<>();
    for (AgencyStaffFileRDO fileDo : fileDoList) {
      FileDTO fileDto = new FileDTO();
      BeanUtils.copyProperties(fileDo, fileDto);
      fileDtoList.add(fileDto);
    }
    agencyDto.setAgencyFiles(fileDtoList);
    resultDto.setStatus(StatusCodeEnum.OK.getValue());
    resultDto.setDatas(agencyDto);
    return resultDto;
  }

  /**
   * 机构申请受理/暂不受理或审核/审核不通过
   *
   * @param agencyHisDto
   * @return
   */
  @RequestMapping(path = "/agencyHistory", method = RequestMethod.PUT)
  @ResponseBody
  public ResultDTO updateAgencyState(@RequestBody AgencyHistoryDTO agencyHisDto) {
    logger.debug("________agencyHisDto_____" + agencyHisDto);
    ResultDTO resultDto = new ResultDTO();
    resultDto.setStatus(StatusCodeEnum.OK.getValue());
    // 判断机构记录是否已被操作
    // 机构历史信息受理/审核前状态
    Integer agencyStateUp = null;
    if (agencyHisDto.getAgencyState() == AgencyStateEnum.STATE_ACCEPT.getValue()
        || agencyHisDto.getAgencyState() == AgencyStateEnum.STATE_WITHHOLD_ACCEPT.getValue()) {
      agencyStateUp = AgencyStateEnum.STATE_NO_ACCEPT.getValue();
    }
    if (agencyHisDto.getAgencyState() == AgencyStateEnum.STATE_AUDIT.getValue()
        || agencyHisDto.getAgencyState() == AgencyStateEnum.STATE_NO_AUDIT.getValue()) {
      agencyStateUp = AgencyStateEnum.STATE_ACCEPT.getValue();
    }
    List<AgencyHistoryDO> hisList =
        agencyHistoryService.getAgencyHisByIdAndState(agencyHisDto.getSerialNum(), agencyStateUp);
    if (hisList == null || hisList.isEmpty()) {
      resultDto.setDatas(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
      resultDto.setMessage("记录已被他人操作，请刷新界面，重新选择数据！");
      return resultDto;
    }
    if (ActionTypeEnum.CREATE.getValue().equals(agencyHisDto.getActionType())) {
      if (AgencyStateEnum.STATE_ACCEPT.getValue().equals(agencyHisDto.getAgencyState())) {
        List<AgencyDO> agencyList = agencyService.getAgencyByOrgCode(agencyHisDto.getOrgCode());
        if (agencyList != null && !agencyList.isEmpty()) {
          resultDto.setDatas(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
          resultDto.setMessage("该机构存在有效数据，不可再次申请");
          logger.debug("________resultDto_____" + resultDto);
          return resultDto;
        }
      }
      if (AgencyStateEnum.STATE_AUDIT.getValue().equals(agencyHisDto.getAgencyState())
          && !StringUtils.isEmpty(agencyHisDto.getAgencyCodeInput())) {
        List<AgencyDO> agencyList =
            agencyService.getAgencyByAgencyCode(
                agencyHisDto.getAgencyCode().substring(0, 6) + agencyHisDto.getAgencyCodeInput(),
                agencyHisDto.getOrgCode());
        if (agencyList != null && !agencyList.isEmpty()) {
          resultDto.setDatas(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
          resultDto.setMessage("该机构编号已被使用，请填写其他编号");
          logger.debug("________resultDto_____" + resultDto);
          return resultDto;
        }
      }
    }
    try {
      agencyHistoryService.agencyOnlineApplyUpdate(agencyHisDto);
    } catch (ServiceException e) {
      logger.debug("________updateAgencyState_____", e);
      resultDto.setDatas(e.getErrorCode());
      resultDto.setMessage(e.getMessage());
      return resultDto;
    }
    return resultDto;
  }

  @RequestMapping(value = RETRY_URL, method = RequestMethod.POST)
  public ResultDTO retryAgencyMessageReceive(@RequestParam("message") String message) {
    logger.info("=====重新处理异常的mq消息=====");
    //根据巡查任务id查询申述复议列表
    ResultDTO result = new ResultDTO();
    int state = agencyInterfaceService.parseMessage(message);
    result.setStatus(state);
    if (ExecutionStatusEnum.SUCCESS.getValue() == state) {
      result.setMessage("重试成功！");
    } else {
      result.setMessage("重试失败！");
    }
    return result;
  }
}
