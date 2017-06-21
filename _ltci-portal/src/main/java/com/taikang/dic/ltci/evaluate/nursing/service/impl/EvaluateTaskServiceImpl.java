package com.taikang.dic.ltci.evaluate.nursing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.evaluate.nursing.service.EvaluateTaskService;
import com.taikang.dic.ltci.evaluate.nursing.serviceClient.EvaluateTaskServerClient;
import com.taikang.dic.ltci.evaluate.nursing.serviceClient.OrganizationServerClient;
import com.taikang.dic.ltci.portal.api.model.AttachmentDTO;
import com.taikang.dic.ltci.portal.api.model.EvaluateTaskDTO;
import com.taikang.dic.ltci.portal.api.model.OrganizationDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.RestResponseDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.enumeration.FileTypeEnum;
import com.taikang.dic.ltci.portal.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.portal.common.restRequestResponse.RestResponseFormat;
import com.taikang.dic.ltci.portal.common.util.UserUtils;
import com.taikang.dic.ltci.portal.serverClient.AttachmentServiceClient;

/**
 * @author itw_xuxf
 * @version 2017年3月31日下午3:21:33 待遇申请状态处理 feign请求
 */
@Service
public class EvaluateTaskServiceImpl implements EvaluateTaskService {

  @Autowired private EvaluateTaskServerClient evaluateTaskServerClient;
  @Autowired private AttachmentServiceClient attachmentServiceClient;
  @Autowired private OrganizationServerClient organizationServerClient;

  @Autowired
  private com.taikang.dic.ltci.system.serverClient.OrganizationServerClient
      systemOrganizationServerClient;

  @Value(value = "${spring.application.name}")
  private String systemCode;
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
  public PageResultDTO queryEvaluateTaskList(
      String insuredPersonName,
      String mobile,
      String operatedTime,
      String taskState,
      int page,
      int pageSize) {

    EvaluateTaskDTO evaluateTaskDTO = new EvaluateTaskDTO();
    evaluateTaskDTO.setInsuredPersonName(insuredPersonName);
    evaluateTaskDTO.setMobile(mobile);
    evaluateTaskDTO.setTaskState(taskState);
    evaluateTaskDTO.setOperatedTime(operatedTime);

    RestResponseDTO restResponseDTO =
        evaluateTaskServerClient.evaluateTaskList(evaluateTaskDTO, page, pageSize, systemCode);
    PageResultDTO pageResultDTO = RestResponseFormat.restResponseDTO2PageResultDTO(restResponseDTO);

    //调用接口将经办机构编码替换成经办机构名称
    if (pageResultDTO.getDatas() != null) {
      List<EvaluateTaskDTO> evaluateTaskDTOList =
          JSONArray.parseArray(
              JSONObject.toJSONString(pageResultDTO.getDatas()), EvaluateTaskDTO.class);
      for (EvaluateTaskDTO evaluateTaskDTO2 : evaluateTaskDTOList) {
        if (evaluateTaskDTO2.getOperatedOrg() != null) {
          String operatedOrg = evaluateTaskDTO2.getOperatedOrg();
          ResultDTO result = systemOrganizationServerClient.getByCode(operatedOrg, systemCode);
          if (result.getDatas() != null) {
            OrganizationDTO organizationDTO =
                JSONObject.parseObject(
                    JSONObject.toJSONString(result.getDatas()), OrganizationDTO.class);
            evaluateTaskDTO2.setOperatedOrg(organizationDTO.getName());
          }
        }
      }
      pageResultDTO.setDatas(evaluateTaskDTOList);
    }

    return pageResultDTO;
  }

  @Override
  public ResultDTO sendEvaluateTaskBatch(String evaluateTaskCodes) {
    UserDTO userDTO = UserUtils.getCurrentUser();
    String operatedBy = "";
    String operatedOrg = "";
    if (userDTO != null) {
      operatedBy = userDTO.getTrueName();
      if (userDTO.getDepartment() != null) {
        operatedOrg = userDTO.getDepartment().getCode();
      }
    }
    RestResponseDTO restResponseDTO =
        evaluateTaskServerClient.sendEvaluateTask(evaluateTaskCodes, operatedBy, operatedOrg);
    return RestResponseFormat.restResponseDTO2ResultDTO(restResponseDTO);
  }

  /** 查询评估机构信息 调用机构人员微服务接口 */
  @Override
  public ResultDTO getEvaluateDepartments(String areaNum, String organizationType) {
    return organizationServerClient.getEvaluateDepartments(areaNum, organizationType);
  }

  /** 重评接口 */
  @Override
  public ResultDTO reviewEvaluateTask(String evaluateTaskCode, String reevalueateResult) {
    UserDTO userDTO = UserUtils.getCurrentUser();
    String operatedBy = "";
    String operatedOrg = "";
    if (userDTO != null) {
      operatedBy = userDTO.getTrueName();
      if (userDTO.getDepartment() != null) {
        operatedOrg = userDTO.getDepartment().getCode();
      }
    }
    RestResponseDTO restResponseDTO =
        evaluateTaskServerClient.reviewEvaluateTask(
            evaluateTaskCode, reevalueateResult, operatedBy, operatedOrg, systemCode);
    return RestResponseFormat.restResponseDTO2ResultDTO(restResponseDTO);
  }
  /** 批量修改送达状态 */
  @Override
  public ResultDTO batchTreatmentApplicationCase(
      String taskState, String operatedBy, String evaluateTaskCodes) {
    UserDTO userDTO = UserUtils.getCurrentUser();
    String createdBy = operatedBy;
    String createdOrg = "";
    if (userDTO != null) {
      createdBy = userDTO.getTrueName();
      if (userDTO.getDepartment() != null) {
        createdOrg = userDTO.getDepartment().getCode();
      }
    }
    RestResponseDTO restResponseDTO =
        evaluateTaskServerClient.batchTreatmentApplicationCase(
            taskState, createdBy, createdOrg, evaluateTaskCodes, evaluateTaskCodes);
    ResultDTO resultDto = RestResponseFormat.restResponseDTO2ResultDTO(restResponseDTO);

    return resultDto;
  }

  @Override
  public PageResultDTO getExpertTaskList(
      String insuredPersonName,
      String idCard,
      String evaluateOrg,
      String operatedTime,
      String taskState,
      int page,
      int pageSize) {
    RestResponseDTO restResponseDTO =
        evaluateTaskServerClient.getExpertTaskList(
            insuredPersonName, idCard, evaluateOrg, operatedTime, taskState, page, pageSize);
    return RestResponseFormat.restResponseDTO2PageResultDTO(restResponseDTO);
  }

  @Override
  public ResultDTO getMongoDBMessage(String id) {
    ResultDTO resultDTO =
        attachmentServiceClient.getAttachmentByID(id, FileTypeEnum.PICTURE.getValue());
    if (resultDTO != null && StatusCodeEnum.OK.getValue().equals(resultDTO.getStatus())) {
      AttachmentDTO dto =
          JSONObject.parseObject(
              JSONObject.toJSONString(resultDTO.getDatas()), AttachmentDTO.class);
      resultDTO.setDatas(dto.getContent());
    }
    return resultDTO;
  }

  @Override
  public ResultDTO getToDoListEvaluateTaskList() {
    RestResponseDTO restResponseDTO = evaluateTaskServerClient.getToDoListEvaluateTaskList();
    return RestResponseFormat.restResponseDTO2ResultDTO(restResponseDTO);
  }
}
