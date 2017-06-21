package com.taikang.dic.ltci.treatment.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.portal.api.model.ApplicationLogDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.TreatmentApplicationDTO;
import com.taikang.dic.ltci.treatment.application.service.TreatmentApplicationService;

/**
 * @author itw_xuxf
 * @description 移动端待遇申请
 * @version 创建时间：2017年3月30日上午8:15:51
 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class TreatmentApplicationController {
  @Autowired private TreatmentApplicationService treatmentApplicationImpl;
  private Logger logger = LoggerFactory.getLogger(TreatmentApplicationController.class);
  /**
   * 根据待遇申请编号修改待遇申请状态
   *
   * @param applicationCode 待遇申请编号
   * @return
   */
  @RequestMapping(path = "/treatmentApplicationCase")
  @ResponseBody
  public ResultDTO treatmentApplicationCase(ApplicationLogDTO dto) {
    logger.debug("请求参数为：" + JSONObject.toJSONString(dto));
    return treatmentApplicationImpl.caseTreatmentApplicationStauts(dto);
  }

  /**
   * 根据待遇申请编号获取待遇申请详情信息
   *
   * @param applicationCode 待遇申请编号
   * @return
   */
  @RequestMapping(path = "/treatmentApplication/{applicationCode}")
  @ResponseBody
  public ResultDTO treatmentApplicationGet(@PathVariable String applicationCode) {
    return treatmentApplicationImpl.getTreatmentApplicationInfo(applicationCode);
  }

  /**
   * 新增待遇申请信息，无附件提交
   *
   * @param dto
   */
  @RequestMapping(path = "/treatmentApplication", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO createTreatmentApplication(TreatmentApplicationDTO dto) {
    logger.info("-------------createTreatmentApplication:-------------");
    logger.info("-------------TreatmentApplicationDTO:" + dto + "--------------");
    return treatmentApplicationImpl.createTreatmentApplication(dto);
  }

  /**
   * 附件提交
   *
   * @param file
   * @return
   */
  @RequestMapping(
    value = "/treatmentApplicationAttachement",
    method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  @ResponseBody
  public ResultDTO uploadTreatmentApplicationAttachement(
      @RequestParam(value = "attachment", required = true) MultipartFile file) {
    return treatmentApplicationImpl.uploadTreatmentApplicationAttachement(file);
  }

  /**
   * 附件提交base64格式
   *
   * @param file
   * @return
   */
  @RequestMapping(value = "/treatmentApplicationImgBase64", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO uploadTreatmentApplicationImgBase64(
      @RequestParam(value = "imgBase64", required = true) String imgBase64) {
    return treatmentApplicationImpl.uploadTreatmentApplicationAttachement(imgBase64);
  }

  /**
   * 附件提交
   *
   * @param file
   * @return
   */
  @RequestMapping(
    value = "/treatmentApplicationAttachement/{attachmentid}",
    method = RequestMethod.DELETE
  )
  @ResponseBody
  public ResultDTO deleteTreatmentApplicationAttachement(@PathVariable String attachmentid) {
    ResultDTO dto = treatmentApplicationImpl.deleteTreatmentApplicationAttachement(attachmentid);
    return dto;
  }

  /**
   * 移动端待遇受理分页查询
   *
   * @param insuredPersonName 参保人姓名
   * @param idCard 参保人身份证
   * @param securityNumber 参保人社保卡号
   * @param disease 疾病
   * @param operatedTime 经办时间
   * @param page 页数
   * @param size 条数
   * @return
   */
  @RequestMapping(value = "/mobileTreatmentApplications", method = RequestMethod.POST)
  @ResponseBody
  public PageResultDTO mobileTreatmentApplicationList(
      @RequestParam(value = "insuredPersonName", defaultValue = "") String insuredPersonName,
      @RequestParam(value = "idCard", defaultValue = "") String idCard,
      @RequestParam(value = "securityNumber", defaultValue = "") String securityNumber,
      @RequestParam(value = "disease", defaultValue = "") String disease,
      @RequestParam(value = "operatedTime", defaultValue = "") String operatedTime,
      @RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
      @RequestParam(value = "applicationStatus", defaultValue = "") String applicationStatus) {
    return treatmentApplicationImpl.mobileTreatmentApplicationList(
        insuredPersonName,
        idCard,
        securityNumber,
        disease,
        operatedTime,
        page,
        pageSize,
        applicationStatus);
  }

  /** 批量待遇神清申请操作 */
  @RequestMapping(value = "v2/batchTreatmentApplicationCase", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO batchTreatmentApplicationCase(@RequestParam String applicationLogDTOs) {
    logger.debug(applicationLogDTOs);
    //	  List<ApplicationLogDTO> dtos = new ArrayList<ApplicationLogDTO>();
    //	  dtos=(List<ApplicationLogDTO>) JSONObject.parse(applicationLogDTOs);

    List<ApplicationLogDTO> dtos =
        JSONArray.parseArray(applicationLogDTOs, ApplicationLogDTO.class);

    List<ResultDTO> results = new ArrayList<ResultDTO>();

    for (ApplicationLogDTO dto : dtos) {
      ResultDTO result = treatmentApplicationImpl.caseTreatmentApplicationStauts(dto);
      result.setDatas(dto.getApplicationCode());
      results.add(result);
    }

    ResultDTO resultDTO = new ResultDTO();
    resultDTO.datas(results);
    resultDTO.setStatus(200);

    return resultDTO;
  }

  /** 批量待遇神清申请操作 修改版本 */
  @RequestMapping(value = "batchTreatmentApplicationCase", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO allTreatmentApplicationCase(@RequestParam String applicationLogDTOs) {
    String applicationSpecialDO = applicationLogDTOs;
    logger.debug("请求的参数是+" + applicationSpecialDO);

    //    List<ApplicationSpecialDO> dtos =
    //        JSONArray.parseArray(applicationSpecialDO, ApplicationSpecialDO.class);

    return treatmentApplicationImpl.batchTreatmentApplicationCase(applicationSpecialDO);
  }
}
