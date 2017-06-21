package com.taikang.dic.ltci.treatment.application.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.evaluate.nursing.serviceClient.EvaluateTaskServerClient;
import com.taikang.dic.ltci.portal.api.model.ApplicationLogDTO;
import com.taikang.dic.ltci.portal.api.model.AttachmentDTO;
import com.taikang.dic.ltci.portal.api.model.EvaluateTaskDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.RestResponseDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.TreatApplyDTO;
import com.taikang.dic.ltci.portal.api.model.TreatmentApplicationDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.enumeration.ApplicationStatusEnum;
import com.taikang.dic.ltci.portal.common.enumeration.EvaluateTaskStatusEnum;
import com.taikang.dic.ltci.portal.common.enumeration.FileTypeEnum;
import com.taikang.dic.ltci.portal.common.enumeration.IsReevaluateEnum;
import com.taikang.dic.ltci.portal.common.enumeration.IsValidEnum;
import com.taikang.dic.ltci.portal.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.portal.common.enumeration.ThirdInterfaceLogEnum;
import com.taikang.dic.ltci.portal.common.restRequestResponse.RestResponseFormat;
import com.taikang.dic.ltci.portal.common.util.Encodes;
import com.taikang.dic.ltci.portal.common.util.FileTypeDecideUtil;
import com.taikang.dic.ltci.portal.common.util.UserUtils;
import com.taikang.dic.ltci.portal.model.ThirdInterfaceLogDO;
import com.taikang.dic.ltci.portal.serverClient.AttachmentServiceClient;
import com.taikang.dic.ltci.portal.service.impl.ScheduleServiceImpl;
import com.taikang.dic.ltci.treatment.application.common.ThrowsException;
import com.taikang.dic.ltci.treatment.application.model.ApplicationSpecialDO;
import com.taikang.dic.ltci.treatment.application.serverClient.TreatmentApplicationServerClient;
import com.taikang.dic.ltci.treatment.application.service.TreatmentApplicationService;

/**
 * @author itw_xuxf
 * @version 2017年3月31日下午3:21:33 待遇申请状态处理 feign请求
 */
@Service
public class TreatmentApplicationServiceImpl implements TreatmentApplicationService {

  private static final Logger logger =
      LoggerFactory.getLogger(TreatmentApplicationServiceImpl.class);

  @Autowired private TreatmentApplicationServerClient treatmentApplicationServerClient;

  @Autowired private EvaluateTaskServerClient evaluateTaskServerClient;

  @Autowired private ScheduleServiceImpl scheduleExecuteServiceImpl;

  @Autowired private AttachmentServiceClient attachmentServiceClient;

  @Value(value = "${spring.application.name}")
  private String systemCode;

  /**
   * 待遇申请状态处理
   *
   * @param logDto 待遇申请入参DTO
   * @return
   */
  @Override
  public ResultDTO caseTreatmentApplicationStauts(ApplicationLogDTO logDto) {
    UserDTO userDTO = UserUtils.getCurrentUser();
    if (userDTO != null) {
      logDto.setOperatedBy(userDTO.getTrueName());
      if (userDTO.getDepartment() != null) {
        logDto.setOperatedOrg(userDTO.getDepartment().getCode());
      }
    } else {
      logDto.setOperatedBy("system");
    }
    RestResponseDTO restResponseDTO =
        treatmentApplicationServerClient.treatmentApplicationCase(logDto, systemCode);

    ResultDTO caseResult = RestResponseFormat.restResponseDTO2ResultDTO(restResponseDTO);

    if (StatusCodeEnum.CREATED.getValue().equals(caseResult.getStatus())) {
      //需要创建一个评估发送任务--通过评估护理微服务接口调用
      RestResponseDTO restResponseDTOLog =
          treatmentApplicationServerClient.getTreatmentApplication(
              logDto.getApplicationCode(), systemCode);
      ResultDTO resultDTO = RestResponseFormat.restResponseDTO2ResultDTO(restResponseDTOLog);

      if (ApplicationStatusEnum.PASS_ACCEPT.getValue().equals(logDto.getApplicationStatus())) {
        TreatApplyDTO treatApplyDTO =
            JSONObject.parseObject(
                JSONObject.toJSONString(resultDTO.getDatas()), TreatApplyDTO.class);

        evaluateTaskAdd(userDTO, treatApplyDTO, logDto);
      }
    }
    return caseResult;
  }

  //新增评估任务
  private void evaluateTaskAdd(
      UserDTO userDTO, TreatApplyDTO treatApplyDTO, ApplicationLogDTO logDto) {
    ////////////////////////////////////////////////////////////
    long begin = System.currentTimeMillis();
    ThirdInterfaceLogDO log = new ThirdInterfaceLogDO();
    log.setType(ThirdInterfaceLogEnum.TYPE_EVALUATE_NURSING.getValue());
    log.setBusiType(ThirdInterfaceLogEnum.BUSI_TYPE_03.getValue());
    ////////////////////////////////////////////////////////////////////////
    EvaluateTaskDTO evaluateTaskDTO = new EvaluateTaskDTO();
    evaluateTaskDTO.setApplicationCode(logDto.getApplicationCode());

    if (userDTO != null) {
      evaluateTaskDTO.setCreatedBy(userDTO.getTrueName());
      evaluateTaskDTO.setOperatedBy(userDTO.getTrueName());
      if (userDTO.getDepartment() != null) {
        evaluateTaskDTO.setCreatedOrg(userDTO.getDepartment().getCode());
        evaluateTaskDTO.setOperatedOrg(userDTO.getDepartment().getCode());
      }
    }
    evaluateTaskDTO.setEvaluateTaskid(UUID.randomUUID().toString().replaceAll("-", ""));
    evaluateTaskDTO.setEvaluateTaskCode(UUID.randomUUID().toString().replaceAll("-", ""));
    evaluateTaskDTO.setInsuredPersonCode(treatApplyDTO.getInsuredPersonCode());
    evaluateTaskDTO.setInsuredPersonName(treatApplyDTO.getInsuredPersonName());
    evaluateTaskDTO.setIdCard(treatApplyDTO.getIdCard());
    evaluateTaskDTO.setMobile(treatApplyDTO.getMobile());
    evaluateTaskDTO.setIsReevaluate(IsReevaluateEnum.NO_REEVALUATE.getValue());
    evaluateTaskDTO.setReevaluateParentCode("0"); //默认为0
    evaluateTaskDTO.setTaskDeadline(treatApplyDTO.getIsTaskDeadline());
    evaluateTaskDTO.setTaskState(EvaluateTaskStatusEnum.NOT_SEND.getValue());
    evaluateTaskDTO.setIsValid(Integer.toString(IsValidEnum.NO_DELETE.getValue()));
    evaluateTaskDTO.setSiArea(treatApplyDTO.getSiArea());
    try {
      ////////////////////////////////////////////////////////////////////////////////////////
      log.setBusiDataId(evaluateTaskDTO.getEvaluateTaskCode());
      log.setSendContent(JSONObject.toJSONString(evaluateTaskDTO));
      log.setSendTime(new Date());
      ////////新增评估任务//////////////////////////////////////////////////////////////////////////////////////
      RestResponseDTO evaluateTaskRestResponseDTO =
          evaluateTaskServerClient.expertTaskAdd(evaluateTaskDTO, systemCode);
      ResultDTO resultDTO =
          RestResponseFormat.restResponseDTO2ResultDTO(evaluateTaskRestResponseDTO);

      log.setReveiceContent(JSONObject.toJSONString(resultDTO));
      log.setReveiceTime(new Date());
      if (StatusCodeEnum.CREATED.getValue().equals(resultDTO.getStatus())) {
        log.setIsSendSuccess(1);
      } else {
        log.setIsSendSuccess(0);
        log.setFailMessage(resultDTO.getMessage());
      }
    } catch (Exception e) {
      log.setIsSendSuccess(0);
      log.setFailMessage(e.getMessage());
      logger.error(
          "ltci-portal TreatmentApplicationServiceImpl caseTreatmentApplicationStauts 审核通过，创建评估任务失败："
              + e);
    } finally {
      scheduleExecuteServiceImpl.insertInterfaceLog(log);
      logger.debug(
          "_____evaluateTaskServerClient >>>>>> expertTaskAdd__耗时S:"
              + ((System.currentTimeMillis()) - begin) / 1000);
    }
  }

  /**
   * 根据待遇编号查询待遇申请详情
   *
   * @param applicationCode 待遇申请编号
   * @return
   */
  @Override
  public ResultDTO getTreatmentApplicationInfo(String applicationCode) {
    RestResponseDTO restResponseDTO =
        treatmentApplicationServerClient.getTreatmentApplication(applicationCode, systemCode);
    return RestResponseFormat.restResponseDTO2ResultDTO(restResponseDTO);
  }

  /**
   * 新增待遇申请，无附件信息的具体业务处理。
   *
   * @param dto
   */
  @Override
  public ResultDTO createTreatmentApplication(TreatmentApplicationDTO dto) {
    String operatedBy = "";
    String operatedOrg = "";
    UserDTO userDTO = UserUtils.getCurrentUser();
    if (userDTO != null) {
      operatedBy = userDTO.getTrueName();
      if (userDTO.getDepartment() != null) {
        operatedOrg = userDTO.getDepartment().getCode();
      }
    }
    dto.setCreatedBy(operatedBy);
    dto.setCreatedOrg(operatedOrg);
    RestResponseDTO restResponseDTO =
        treatmentApplicationServerClient.createTreatmentApplication(dto, systemCode);
    return RestResponseFormat.restResponseDTO2ResultDTO(restResponseDTO);
  }

  @Override
  public ResultDTO uploadTreatmentApplicationAttachement(MultipartFile file) {
    ResultDTO resultDTO = null;
    try {
      String fileName = file.getOriginalFilename();
      logger.debug("上传附件文件名为：" + fileName);
      if (file.isEmpty()) {
        throw new ThrowsException("上传失败：附件信息不能为空！");
      }
      long size = file.getSize();
      if (size > 1024 * 1024) {
        throw new ThrowsException("上传失败：附件大小不能超过1MB！");
      }
      AttachmentDTO dto = new AttachmentDTO();
      //将File文件转换为Base64字符串
      byte[] byteFile = file.getBytes();
      String base64 = Encodes.encodeBase64(byteFile);
      if (StringUtils.isNoneBlank(fileName) && fileName.indexOf(".") != -1) {
        dto.setFileName(fileName);
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        String fileType = FileTypeDecideUtil.getFileType(suffix);
        if (StringUtils.isBlank(fileType)) {
          throw new ThrowsException("上传失败：暂不支持上传" + suffix + "类型的附件！");
        }
        dto.setSuffix(suffix);
      }
      dto.setFileType(FileTypeEnum.PICTURE.getValue());
      dto.setContent(base64);
      resultDTO = attachmentServiceClient.addAttachment(dto);
      if (resultDTO == null || !resultDTO.getStatus().equals(StatusCodeEnum.CREATED.getValue())) {
        throw new ThrowsException("调用媒体文件微服务端保存文件失败！");
      }
    } catch (IOException e) {
      logger.error("错误信息： " + e);
      throw new ThrowsException("上传失败：文件转换为Bytes失败！");
    }
    return resultDTO;
  }

  @Override
  public ResultDTO uploadTreatmentApplicationAttachement(String base64) {
    AttachmentDTO dto = new AttachmentDTO();
    //将File文件转换为Base64字符串
    dto.setFileName("");
    dto.setSuffix("");
    dto.setFileType(FileTypeEnum.PICTURE.getValue());
    dto.setContent(base64);
    ResultDTO resultDTO = attachmentServiceClient.addAttachment(dto);
    if (resultDTO == null || !resultDTO.getStatus().equals(StatusCodeEnum.CREATED.getValue())) {
      throw new ThrowsException("调用媒体文件微服务端保存文件失败！");
    }
    return resultDTO;
  }

  @Override
  public ResultDTO deleteTreatmentApplicationAttachement(String attachmentid) {
    ResultDTO resultDTO =
        attachmentServiceClient.deleteAttachment(attachmentid, FileTypeEnum.PICTURE.getValue());
    if (resultDTO == null) {
      throw new ThrowsException("待遇申请微服务端删除图片附件失败！");
    }
    return resultDTO;
  }

  /**
   * 分页查询
   *
   * @param insuredPersonName 参保人姓名
   * @param idCard 身份证号
   * @param securityNumber 社保卡号
   * @param disease 疾病
   * @param operatedTime 经办时间
   * @param page 页数
   * @param pageSize 条数
   * @return
   */
  @Override
  public PageResultDTO mobileTreatmentApplicationList(
      String insuredPersonName,
      String idCard,
      String securityNumber,
      String disease,
      String operatedTime,
      int page,
      int pageSize,
      String applicationStatus) {

    TreatApplyDTO treatApplyDTOParam = new TreatApplyDTO();
    treatApplyDTOParam.setInsuredPersonName(insuredPersonName);
    treatApplyDTOParam.setIdCard(idCard);
    treatApplyDTOParam.setSecurityNumber(securityNumber);
    treatApplyDTOParam.setOperatedTime(operatedTime);
    treatApplyDTOParam.setDisease(disease);
    treatApplyDTOParam.setApplicationStatus(applicationStatus);

    RestResponseDTO restResponseDTO =
        treatmentApplicationServerClient.mobileTreatmentApplicationList(
            treatApplyDTOParam, page, pageSize, systemCode);
    return RestResponseFormat.restResponseDTO2PageResultDTO(restResponseDTO);
  }

  /*
   * 批量待遇申请处理
   * 1、现将json串加上操作人和操作机构，发送给微服务
   * 2、微服务里 做修改状态、记录日志、发送mq
   * 3、如果微服务返回成功，调用评估护理微服务 添加评估任务
   */

  @Override
  public ResultDTO batchTreatmentApplicationCase(String applicationSpecialDO) {
    //1、先在json串里加入操作人和操作机构
    UserDTO currentUser = UserUtils.getCurrentUser();
    String operatedBy = null;
    String operatedOrg = null;

    if (currentUser == null) {
      operatedBy = "";
      operatedOrg = "";
    } else {
      operatedBy = currentUser.getTrueName();
      if (currentUser.getDepartment() != null) {
        operatedOrg = currentUser.getDepartment().getCode();
      }
    }
    List<ApplicationSpecialDO> dtos =
        JSONArray.parseArray(applicationSpecialDO, ApplicationSpecialDO.class);
    for (ApplicationSpecialDO dto : dtos) {
      dto.setOperatedBy(operatedBy);
      dto.setOperatedOrg(operatedOrg);
    }
    //2、微服务里 做修改状态、记录日志、发送mq
    RestResponseDTO restResponseDTO =
        treatmentApplicationServerClient.batchTreatmentApplicationCase(
            JSONObject.toJSONString(dtos), systemCode);
    ResultDTO resultDTO = RestResponseFormat.restResponseDTO2ResultDTO(restResponseDTO);

    logger.info("返回的接口结果为" + JSONObject.toJSONString(resultDTO));

    if (resultDTO.getStatus() != StatusCodeEnum.OK.getValue().intValue()) {

      //代表代表待遇申请微服务处理没有成功
      logger.debug("微服务的批量受理没有成功！");
      return resultDTO;
    }
    //代表待遇申请微服务处理成功了
    //3、如果微服务返回成功，调用评估护理微服务 添加评估任务
    //需要创建一个评估发送任务--通过评估护理微服务接口调用
    for (ApplicationSpecialDO dto : dtos) {
      RestResponseDTO restResponseDTOLog =
          treatmentApplicationServerClient.getTreatmentApplication(
              dto.getApplicationCode(), systemCode);
      //获取比较完整的数据	待遇申请信息
      ResultDTO applicationResult =
          RestResponseFormat.restResponseDTO2ResultDTO(restResponseDTOLog);
      TreatApplyDTO treatApplyDTO =
          JSONObject.parseObject(
              JSONObject.toJSONString(applicationResult.getDatas()), TreatApplyDTO.class);
      ApplicationLogDTO logDto = new ApplicationLogDTO();
      BeanUtils.copyProperties(dto, logDto);
      evaluateTaskAdd(currentUser, treatApplyDTO, logDto);
    }
    return resultDTO;
  }
}
