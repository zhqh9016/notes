package com.taikang.dic.ltci.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.api.model.FileDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.api.model.StaffHistoryDTO;
import com.taikang.dic.ltci.common.enumeration.ObjectTypeEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.model.AgencyStaffFileRDO;
import com.taikang.dic.ltci.model.StaffHistoryDO;
import com.taikang.dic.ltci.service.IAgencyStaffFileService;
import com.taikang.dic.ltci.service.IStaffHistoryService;
import com.taikang.dic.ltci.service.IStaffInterfaceService;

@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class StaffHistoryController {

  private static final Logger logger = LoggerFactory.getLogger(StaffHistoryController.class);

  public static final String RETRY_URL = "/retry/staff";

  @Autowired private IStaffHistoryService staffHistoryService;
  @Autowired private IAgencyStaffFileService fileService;
  @Autowired private IStaffInterfaceService staffInterfaceService;
  /**
   * 查询申请\变更人员信息
   *
   * @param staffName 人员名称
   * @param agencyName 机构名称
   * @param acceptState 受理\审核状态
   * @param dsignatedAgencyLevel 定点机构类别--
   * @param dsignatedAgencyType 定点服务机构类型--
   * @param agencyType 机构类型--
   * @param applyBeginDate 申请开始时间
   * @param applyEndDate 申请结束时间
   * @param jobScope
   * @param page 页码
   * @param pageSize 每页显示件数
   * @return
   */
  @RequestMapping(value = "/staffHistory/list", method = RequestMethod.POST)
  @ResponseBody
  public PageResultDTO getStaffApplyOrModifyList(
      String actionType,
      String staffName,
      String agencyName,
      String acceptState,
      String dsignatedAgencyLevel,
      String dsignatedAgencyType,
      String agencyType,
      String applyBeginDate,
      String applyEndDate,
      String jobScope,
      Integer page,
      Integer pageSize) {
    logger.debug(
        "____getStaffApplyOrModifyList param = actionType="
            + actionType
            + "_staffName="
            + staffName
            + "_agencyName="
            + agencyName
            + "_acceptState="
            + acceptState
            + "_dsignatedAgencyLevel="
            + dsignatedAgencyLevel
            + "_dsignatedAgencyType="
            + dsignatedAgencyType
            + "_agencyType="
            + agencyType
            + "_applyBeginDate="
            + applyBeginDate
            + "_applyEndDate="
            + applyEndDate
            + "_page="
            + page
            + "_pageSize="
            + pageSize);
    Map<String, Object> model =
        staffHistoryService.getStaffApplyOrModifyList(
            actionType,
            staffName,
            agencyName,
            acceptState,
            dsignatedAgencyLevel,
            dsignatedAgencyType,
            agencyType,
            applyBeginDate,
            applyEndDate,
            jobScope,
            page,
            pageSize);
    PageResultDTO pageRet = new PageResultDTO();
    pageRet.setPage(page);
    pageRet.setPageSize(pageSize);
    pageRet.setTotalDataNum(Integer.parseInt(model.get("totalDataNum").toString()));
    pageRet.setTotalPageNum(Integer.parseInt(model.get("totalPageNum").toString()));
    @SuppressWarnings("unchecked")
    List<StaffHistoryDO> staffHistoryList = (List<StaffHistoryDO>) model.get("staffHistoryList");
    List<StaffHistoryDTO> staffDtoList = new ArrayList<>();
    //人员姓名，身份证号码,职称，定点医疗机构名称,申请人,申请日期,受理状态
    for (StaffHistoryDO sdo : staffHistoryList) {
      StaffHistoryDTO dto = new StaffHistoryDTO();
      dto.setSerialNo(sdo.getSerialNo());
      dto.setActionType(sdo.getActionType());
      dto.setStaffCode(sdo.getStaffCode());
      dto.setStaffName(sdo.getStaffName());
      dto.setCredentialNumber(sdo.getCredentialNumber());
      dto.setQualificationLevel(sdo.getQualificationLevel());
      dto.setStaffLevel(sdo.getStaffLevel());
      dto.setAgencyName(sdo.getAgencyName());
      dto.setJobScope(sdo.getJobScope());
      dto.setCreatedBy(sdo.getCreatedBy());
      dto.setCreatedTime(
          DateFormatUtil.dateToStr(sdo.getCreatedTime(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      dto.setAuditState(sdo.getAuditState());
      dto.setCause(sdo.getCause());
      logger.debug("_____" + dto);
      staffDtoList.add(dto);
    }
    pageRet.setStatus(200);
    pageRet.setDatas(staffDtoList);
    return pageRet;
  }

  /**
   * @param staffId
   * @return
   */
  @RequestMapping(path = "/staffHistory/{staffId}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO getStaffHistoryDetailById(@PathVariable String staffId) {
    ResultDTO resultDto = new ResultDTO();
    try {
      //查询人员历史信息
      StaffHistoryDO staffHistoryDO = staffHistoryService.getStaffHistoryDetailByStaffId(staffId);
      StaffHistoryDTO staffHistoryDto = new StaffHistoryDTO();
      BeanUtils.copyProperties(staffHistoryDO, staffHistoryDto);
      if (staffHistoryDO.getCreatedTime() != null) {
        staffHistoryDto.setCreatedTime(
            DateFormatUtil.dateToStr(
                staffHistoryDO.getCreatedTime(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      }
      if (staffHistoryDO.getOperatedTime() != null) {
        staffHistoryDto.setOperatedTime(
            DateFormatUtil.dateToStr(
                staffHistoryDO.getOperatedTime(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      }
      if (staffHistoryDO.getDiplomaDate() != null) {
        staffHistoryDto.setDiplomaDate(
            DateFormatUtil.dateToStr(
                staffHistoryDO.getDiplomaDate(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      }
      if (staffHistoryDO.getDegreeDate() != null) {
        staffHistoryDto.setDegreeDate(
            DateFormatUtil.dateToStr(
                staffHistoryDO.getDegreeDate(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      }
      if (staffHistoryDO.getCredentialValidityDate() != null) {
        staffHistoryDto.setCredentialValidityDate(
            DateFormatUtil.dateToStr(
                staffHistoryDO.getCredentialValidityDate(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      }
      if (staffHistoryDO.getPracticeCertificationDate() != null) {
        staffHistoryDto.setPracticeCertificationDate(
            DateFormatUtil.dateToStr(
                staffHistoryDO.getPracticeCertificationDate(),
                DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      }
      if (staffHistoryDO.getQualificationCertificationDate() != null) {
        staffHistoryDto.setQualificationCertificationDate(
            DateFormatUtil.dateToStr(
                staffHistoryDO.getQualificationCertificationDate(),
                DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      }

      //查询人员对应的附件信息
      List<AgencyStaffFileRDO> fileDoList =
          fileService.getAgencyStaffFileById(
              staffHistoryDO.getSerialNo(), ObjectTypeEnum.STAFF.getValue());
      List<FileDTO> fileDtoList = new ArrayList<>();
      for (AgencyStaffFileRDO fileDo : fileDoList) {
        FileDTO fileDto = new FileDTO();
        BeanUtils.copyProperties(fileDo, fileDto);
        if (fileDo.getCredentialDate() != null) {
          fileDto.setCredentialDate(
              DateFormatUtil.dateToStr(
                  fileDo.getCredentialDate(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
        }
        fileDtoList.add(fileDto);
      }
      //将附件对象 放到 人员历史信息中
      staffHistoryDto.setStaffFiles(fileDtoList);

      resultDto.setDatas(staffHistoryDto);
      resultDto.setMessage("查询成功");
      resultDto.setStatus(StatusCodeEnum.OK.getValue());
    } catch (Exception e) {
      logger.error("错误信息：" + e);
      resultDto.setMessage(e.getMessage());
      resultDto.setStatus(StatusCodeEnum.NOT_FOUND.getValue());
    }
    return resultDto;
  }

  @RequestMapping(value = "/staffHistoryStateCase", method = RequestMethod.PUT)
  @ResponseBody
  public ResultDTO staffHistoryStateCase(@RequestBody StaffHistoryDTO staffHistoryDto) {
    ResultDTO resultDto = new ResultDTO();
    try {
      StaffHistoryDO staffHistoryDO = new StaffHistoryDO();
      BeanUtils.copyProperties(staffHistoryDto, staffHistoryDO);
      int result = staffHistoryService.staffHistoryStateCase(staffHistoryDO);
      if (result > 0) {
        resultDto.setMessage("状态修改成功");
        resultDto.setStatus(StatusCodeEnum.CREATED.getValue());
      } else if (result == -1) {
        resultDto.setMessage("记录已被他人操作，请刷新界面，重新选择数据！");
        resultDto.setStatus(StatusCodeEnum.CREATED.getValue());
      } else {
        resultDto.setMessage("状态修改失败");
        resultDto.setStatus(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
      }
    } catch (Exception e) {
      logger.error("staffHistoryStateCase 人员申请受理修改出错" + e);
      resultDto.setMessage(e.getMessage());
      resultDto.setStatus(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
    }
    return resultDto;
  }

  @RequestMapping(value = RETRY_URL, method = RequestMethod.POST)
  public ResultDTO retryStaffMessageReceive(@RequestParam("message") String message) {
    logger.info("=====重新处理异常的mq消息=====");
    //根据巡查任务id查询申述复议列表
    ResultDTO result = new ResultDTO();
    try {
      staffInterfaceService.parseMessage(message);
      result.setStatus(StatusCodeEnum.OK.getValue());
    } catch (Exception e) {
      result.setStatus(HttpStatus.EXPECTATION_FAILED.value());
      logger.error("retry staff error !", e);
    }
    return result;
  }
}
