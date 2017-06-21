package com.taikang.dic.ltci.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.taikang.dic.ltci.api.model.ApplicationLogDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.RestResponseDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.api.model.TreatApplyDTO;
import com.taikang.dic.ltci.api.model.TreatmentApplicationDTO;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.exception.ThrowsException;
import com.taikang.dic.ltci.common.log.ThreadLocalUtil;
import com.taikang.dic.ltci.common.utils.DateFormat;
import com.taikang.dic.ltci.common.utils.DateFormatUtil;
import com.taikang.dic.ltci.model.TreatmentApplicationDO;
import com.taikang.dic.ltci.service.MobileTreatmentApplicationService;

/**
 * @author itw_xuxf
 * @description 移动端待遇申请
 * @version 创建时间：2017年3月30日上午8:15:51
 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class MobileTreatmentApplicationController {
  private Logger logger = LoggerFactory.getLogger(MobileTreatmentApplicationController.class);
  @Autowired private MobileTreatmentApplicationService mobileTreatmentApplicationService;
  /**
   * 移动端待遇受理分页查询
   *
   * @param insuredPersonName 参保人姓名
   * @param idCard 参保人身份证
   * @param securityNumber 参保人社保卡号
   * @param disease 疾病
   * @param operatedTime 经办时间
   * @param page 页数
   * @param size 条数 pageIndex; //页数 pageStart; //从第几条 pageStart = pageIndex*pageSize orderFieldStr;
   *     //排序字段 orderDirectionStr; //排序方向 count; //总条数
   * @return
   */
  @RequestMapping(value = "/mobileTreatmentApplications", method = RequestMethod.POST)
  @ResponseBody
  public RestResponseDTO mobileTreatmentApplicationList(
      @RequestBody TreatApplyDTO treatApplyDTOParam,
      @RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
    logger.info(
        "====MobileTreatmentApplicationController类：mobileTreatmentApplicationList() ======= start:"
            + DateFormat.getLocalDateTime());
    logger.info("参数insuredPersonName:".concat(treatApplyDTOParam.getInsuredPersonName()));
    logger.info("参数idCard:".concat(treatApplyDTOParam.getIdCard()));
    logger.info("参数securityNumber:".concat(treatApplyDTOParam.getSecurityNumber()));
    logger.info("参数disease:".concat(treatApplyDTOParam.getDisease()));
    logger.info("参数operatedTime:" + treatApplyDTOParam.getOperatedTime());
    logger.info("参数page:" + page);
    logger.info("参数pageSize:" + pageSize);
    logger.info("参数applicationStatus:" + treatApplyDTOParam.getApplicationStatus());

    if (page < 1) page = 1;

    List<TreatmentApplicationDO> treatmentApplicationDOList =
        mobileTreatmentApplicationService.mobileTreatmentApplicationList(
            treatApplyDTOParam.getInsuredPersonName(),
            treatApplyDTOParam.getIdCard(),
            treatApplyDTOParam.getSecurityNumber(),
            treatApplyDTOParam.getDisease(),
            treatApplyDTOParam.getOperatedTime(),
            page - 1,
            pageSize,
            treatApplyDTOParam.getApplicationStatus());
    List<TreatApplyDTO> mobileTreatApplyDTOList = Lists.newArrayList();
    PageResultDTO pageResultDto = new PageResultDTO();

    int totalRecord =
        mobileTreatmentApplicationService.countTreatmentApplicationList(
            treatApplyDTOParam.getInsuredPersonName(),
            treatApplyDTOParam.getIdCard(),
            treatApplyDTOParam.getSecurityNumber(),
            treatApplyDTOParam.getDisease(),
            treatApplyDTOParam.getOperatedTime(),
            treatApplyDTOParam.getApplicationStatus()); //总条数
    int totalPage = (totalRecord + pageSize - 1) / pageSize; //总页数

    if (treatmentApplicationDOList != null && !treatmentApplicationDOList.isEmpty()) {
      treatmentApplicationDOList.forEach(
          p -> mobileTreatApplyDTOList.add(treatmentApplicationDoToMobileTreatApplyDto(p)));

      pageResultDto.setDatas(mobileTreatApplyDTOList);
      pageResultDto.setMessage("列表查询成功");
      pageResultDto.setPage(page);
      pageResultDto.setPageSize(pageSize);
      pageResultDto.setStatus(StatusCodeEnum.OK.getValue());
      pageResultDto.setTotalDataNum(totalRecord);
      pageResultDto.setTotalPageNum(totalPage);
    } else {
      pageResultDto.setDatas(mobileTreatApplyDTOList);
      pageResultDto.setMessage("列表查询成功");
      pageResultDto.setPage(page);
      pageResultDto.setPageSize(pageSize);
      pageResultDto.setStatus(StatusCodeEnum.OK.getValue());
      pageResultDto.setTotalDataNum(totalRecord);
      pageResultDto.setTotalPageNum(totalPage);
    }

    logger.info(
        "====MobileTreatmentApplicationController类：mobileTreatmentApplicationList() ======= end:"
            + DateFormat.getLocalDateTime());

    RestResponseDTO restResponseDTO = new RestResponseDTO();
    restResponseDTO.setData(pageResultDto);
    return restResponseDTO;
  }

  /**
   * 根据待遇申请编号获取待遇申请详情信息
   *
   * @param applicationCode 待遇申请编号
   * @return
   */
  @RequestMapping(path = "/mobileTreatmentApplication/{applicationCode}")
  @ResponseBody
  public RestResponseDTO getTreatmentApplication(@PathVariable String applicationCode) {
    TreatmentApplicationDO treatmentApplicationDO =
        mobileTreatmentApplicationService.getTreatmentApplication(applicationCode);
    TreatApplyDTO dto = treatmentApplicationDoToMobileTreatApplyDto(treatmentApplicationDO);
    ResultDTO resultDto = new ResultDTO();
    resultDto.setDatas(dto);
    resultDto.setNumber(Integer.valueOf(1));
    resultDto.setMessage("详细查询成功");
    resultDto.setStatus(StatusCodeEnum.OK.getValue());
    RestResponseDTO restResponseDTO = new RestResponseDTO();
    restResponseDTO.setData(resultDto);
    return restResponseDTO;
  }

  /**
   * 根据待遇申请编号修改待遇申请状态
   *
   * @param applicationCode 待遇申请编号
   * @return
   */
  @RequestMapping(
    value =
        "/mobileTreatmentApplicationCase/applicationCode/applicationStatus/applicationReason/createdBy",
    method = RequestMethod.POST
  )
  @ResponseBody
  public RestResponseDTO treatmentApplicationCase(@RequestBody ApplicationLogDTO logDto) {
    ResultDTO resultDto = new ResultDTO();
    resultDto.setNumber(0);
    try {
      int result = mobileTreatmentApplicationService.treatmentApplicationCase(logDto);

      if (result > 0) {
        resultDto.setMessage("状态修改成功");
        resultDto.setStatus(StatusCodeEnum.CREATED.getValue());
      } else {
        resultDto.setMessage("状态修改失败");
        resultDto.setStatus(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
      }
    } catch (Exception e) {
      logger.error("treatmentApplicationCase 待遇申请状态修改出错" + e);
      resultDto.setMessage(e.getMessage());
      resultDto.setStatus(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
    }

    RestResponseDTO restResponseDTO = new RestResponseDTO();
    restResponseDTO.setData(resultDto);
    return restResponseDTO;
  }

  /**
   * 将TreatmentApplicationDo转换成MobileTreatApplyDto
   *
   * @param TreatmentApplicationDo
   * @return MobileTreatApplyDto
   */
  private TreatApplyDTO treatmentApplicationDoToMobileTreatApplyDto(
      TreatmentApplicationDO treatmentApplicationDo) {
    TreatApplyDTO dto = new TreatApplyDTO();

    dto.setInsuredPersonName(treatmentApplicationDo.getInsuredPersonName()); //参保人姓名
    dto.setInsuredPersonCode(treatmentApplicationDo.getInsuredPersonCode()); //参保人编号
    dto.setInsuredPersonGender(treatmentApplicationDo.getInsuredPersonGender()); //参保人性别
    dto.setSecurityPersonalNumber(treatmentApplicationDo.getSecurityPersonalNumber()); //参保人个人编号
    dto.setSecurityNumber(treatmentApplicationDo.getSecurityNumber()); //社保卡号
    dto.setIdCard(treatmentApplicationDo.getIdCard()); //身份证号
    dto.setVersion(treatmentApplicationDo.getVersion());
    dto.setMobile(
        treatmentApplicationDo.getMobile() != null
            ? treatmentApplicationDo.getMobile()
            : ""); //联系方式
    //    dto.setAddress(
    //        treatmentApplicationDo.getProvinceCode()
    //            + treatmentApplicationDo.getCityCode()
    //            + treatmentApplicationDo.getAreaCode()
    //            + treatmentApplicationDo.getAddress()); //现住地址
    dto.setAddress(
        treatmentApplicationDo.getAddress() != null ? treatmentApplicationDo.getAddress() : "");

    dto.setApplicationid(treatmentApplicationDo.getApplicationid()); //待遇申请id
    dto.setApplicationCode(treatmentApplicationDo.getApplicationCode()); //待遇申请编号

    dto.setDeputyMobile(
        treatmentApplicationDo.getDeputyMobile() != null
            ? treatmentApplicationDo.getDeputyMobile()
            : ""); //代理人联系方式
    dto.setDeputyAddress(
        treatmentApplicationDo.getDeputyAddress() != null
            ? treatmentApplicationDo.getDeputyAddress()
            : ""); //代理人地址
    dto.setDisease(
        treatmentApplicationDo.getDisease() != null
            ? treatmentApplicationDo.getDisease()
            : ""); //疾病
    dto.setDeputyIdCard(
        treatmentApplicationDo.getDeputyIdCard() != null
            ? treatmentApplicationDo.getDeputyIdCard()
            : ""); //代理人证件号
    dto.setDeputyIdCardScan(
        treatmentApplicationDo.getDeputyIdCardScan() != null
            ? treatmentApplicationDo.getDeputyIdCardScan()
            : ""); //代理人身份证附件
    dto.setSecurityNumberScan(
        treatmentApplicationDo.getSecurityNumberScan() != null
            ? treatmentApplicationDo.getSecurityNumberScan()
            : ""); //社保卡扫描件
    dto.setIdCardScan(
        treatmentApplicationDo.getIdCardScan() != null
            ? treatmentApplicationDo.getIdCardScan()
            : ""); //身份证扫描件
    dto.setCaseHistoryScan(
        treatmentApplicationDo.getCaseHistoryScan() != null
            ? treatmentApplicationDo.getCaseHistoryScan()
            : ""); //病例扫描件
    dto.setApplicationFormScan(
        treatmentApplicationDo.getApplicationFormScan() != null
            ? treatmentApplicationDo.getApplicationFormScan()
            : ""); //长护待遇申请表
    dto.setApplicationStatus(treatmentApplicationDo.getApplicationStatus()); //待遇申请编号
    dto.setApplicationReason(
        treatmentApplicationDo.getApplicationReason() != null
            ? treatmentApplicationDo.getApplicationReason()
            : "");
    dto.setOperatedBy(
        treatmentApplicationDo.getOperatedBy() != null
            ? treatmentApplicationDo.getOperatedBy()
            : "");
    dto.setOperatedTime(DateFormatUtil.DateToTimeStr(treatmentApplicationDo.getOperatedTime()));
    dto.setIsTaskDeadline(
        treatmentApplicationDo.getIsTaskDeadline() != null
            ? treatmentApplicationDo.getIsTaskDeadline()
            : "");

    dto.setNation(
        treatmentApplicationDo.getNation() != null ? treatmentApplicationDo.getNation() : "");
    dto.setBidType(
        treatmentApplicationDo.getBidType() != null ? treatmentApplicationDo.getBidType() : "");
    if (treatmentApplicationDo.getBirthday() != null) {
      dto.setAge(DateFormat.getAgeByBirthDay(treatmentApplicationDo.getBirthday()));
    } else {
      dto.setAge("");
    }
    return dto;
  }

  /**
   * 新增PC端待遇申请信息，无附件提交
   *
   * @param dto
   */
  @RequestMapping(path = "/treatmentApplication", method = RequestMethod.POST)
  @ResponseBody
  public RestResponseDTO createTreatmentApplication(@RequestBody TreatmentApplicationDTO dto) {
    logger.info("-------------createTreatmentApplication:-------------");
    logger.info("-------------TreatmentApplicationDTO:" + dto + "--------------");
    //String createdOrg = ThreadLocalUtil.threadLocal.get().getOperatedOrg();
    //dto.setCreatedOrg(createdOrg);
    mobileTreatmentApplicationService.createTreatmentApplication(dto);
    RestResponseDTO responseDTO = new RestResponseDTO();
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());
    resultDTO.setMessage("新增成功");
    responseDTO.setData(resultDTO);
    return responseDTO;
  }

  /**
   * 新增移动端待遇申请信息，有附件提交
   *
   * @param dto
   */
  @RequestMapping(path = "/mobileTreatmentApplication", method = RequestMethod.POST)
  @ResponseBody
  public RestResponseDTO createMobileTreatmentApplication(
      @RequestBody TreatmentApplicationDTO treatmentApplicationDTO) {
    if (treatmentApplicationDTO == null) {
      throw new ThrowsException("移动端请求信息错误,参数为空！");
    }
    TreatmentApplicationDO treatmentApplicationDO = new TreatmentApplicationDO();
    BeanUtils.copyProperties(treatmentApplicationDTO, treatmentApplicationDO);

    if (StringUtils.isNotBlank(treatmentApplicationDTO.getBirthday())) {
      try {
        treatmentApplicationDO.setBirthday(
            DateFormatUtil.StrToDate(
                treatmentApplicationDTO.getBirthday(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      } catch (Exception e) {
        logger.error("移动端解析待遇申请出生日期参数出错：", e);
        throw new ThrowsException("请求待遇申请出生日期参数转换错误！");
      }
    }

    ResultDTO resultDTO =
        mobileTreatmentApplicationService.createMobileTreatmentApplication(treatmentApplicationDO);
    RestResponseDTO baseModel = new RestResponseDTO();
    baseModel.setData(resultDTO);
    return baseModel;
  }

  /** 批量处理待遇申请 */
  /** 根据待遇申请编号批量修改待遇申请状态 */
  @RequestMapping(value = "/batchTreatmentApplicationCase", method = RequestMethod.PUT)
  @ResponseBody
  public RestResponseDTO batchTreatmentApplicationCase(String applicationSpecialDO) {
    logger.debug(applicationSpecialDO);

    logger.debug("封装完成");
    RestResponseDTO baseModel = new RestResponseDTO();
    baseModel.setData(
        mobileTreatmentApplicationService.batchTreatmentApplicationCase(applicationSpecialDO));
    return baseModel;
  }
}
