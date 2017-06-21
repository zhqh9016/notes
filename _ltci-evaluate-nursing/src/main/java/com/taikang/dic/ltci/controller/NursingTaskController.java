package com.taikang.dic.ltci.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;
import com.taikang.dic.ltci.api.model.NursingTaskDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.RestResponseDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.IsValidEnum;
import com.taikang.dic.ltci.common.enumeration.NursingTaskEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.model.NursingTaskDO;
import com.taikang.dic.ltci.model.NursingTaskSpecialDO;
import com.taikang.dic.ltci.service.NursingTaskService;

@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class NursingTaskController {

  private static final Logger logger = LoggerFactory.getLogger(FirstEvaluateController.class);

  @Autowired private NursingTaskService nursingTaskService;

  /**
   * 新增护理任务
   *
   * @param nursingTaskDTO
   * @return
   */
  @RequestMapping(value = "/nursingTask", method = RequestMethod.POST)
  public RestResponseDTO nursingTaskAdd(@RequestBody NursingTaskDTO nursingTaskDTO) {
    NursingTaskDO nursingTaskDO = new NursingTaskDO();
    BeanUtils.copyProperties(nursingTaskDTO, nursingTaskDO);

    ResultDTO resultDTO = new ResultDTO();
    nursingTaskService.createNursingTask(nursingTaskDO);
    resultDTO.setMessage("添加成功");
    resultDTO.setStatus(StatusCodeEnum.CREATED.getValue());

    RestResponseDTO restResponseDTO = new RestResponseDTO();
    restResponseDTO.setData(resultDTO);
    return restResponseDTO;
  }

  /**
   * 批量新增护理任务
   *
   * @param nursingTaskDTO
   * @return
   */
  @RequestMapping(value = "/nursingTaskList", method = RequestMethod.POST)
  public RestResponseDTO nursingTaskListAdd(@RequestBody List<NursingTaskDTO> nursingTaskDTOJsons) {
    List<NursingTaskDTO> nursingTaskDTOs =
        JSONArray.parseArray(JSONArray.toJSONString(nursingTaskDTOJsons), NursingTaskDTO.class);
    List<NursingTaskDO> nursingTaskDOs = Lists.newArrayList();
    if (nursingTaskDTOs != null) {
      for (NursingTaskDTO nursingTaskDTO : nursingTaskDTOs) {
        NursingTaskDO nursingTaskDO = new NursingTaskDO();
        BeanUtils.copyProperties(nursingTaskDTO, nursingTaskDO);
        nursingTaskDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
        nursingTaskDO.setCreatedTime(new Date());
        if (nursingTaskService.getNursingTaskByEvaluateTaskCode(
            nursingTaskDO.getEvaluateTaskCode())) {
          nursingTaskDOs.add(nursingTaskDO);
        }
      }
    }
    ResultDTO resultDTO = new ResultDTO();
    nursingTaskService.insertNursingTaskList(nursingTaskDOs);
    resultDTO.setMessage("添加成功");
    resultDTO.setStatus(StatusCodeEnum.CREATED.getValue());

    RestResponseDTO restResponseDTO = new RestResponseDTO();
    restResponseDTO.setData(resultDTO);
    return restResponseDTO;
  }

  /**
   * 修改意向机构
   *
   * @param nursingTaskCodes
   * @param intentAgencyCodes
   * @param operatedBy
   * @param operatedOrg
   * @return
   */
  @RequestMapping(value = "/nursingTaskIntentAgency", method = RequestMethod.PUT)
  public RestResponseDTO updateNursingTaskIntentAgency(
      @RequestParam(value = "nursingTaskCodes") String nursingTaskCodes,
      @RequestParam(value = "intentAgencyCode") String intentAgencyCode,
      @RequestParam(value = "applyType", defaultValue = "") String applyType,
      @RequestParam(value = "isRelativeCared", defaultValue = "") String isRelativeCared,
      @RequestParam(value = "operatedBy", defaultValue = "") String operatedBy,
      @RequestParam(value = "operatedOrg", defaultValue = "") String operatedOrg) {
    logger.info("-------------------updateNursingTaskIntentAgency------------");
    logger.info("-------------------nursingTaskCodes:" + nursingTaskCodes + "-------------");
    logger.info("-------------------intentAgencyCode:" + intentAgencyCode + "-----------");
    logger.info("-------------------operatedBy:" + operatedBy + "----------");
    logger.info("-------------------operatedOrg:" + operatedOrg + "-------------");

    ResultDTO resultDTO =
        nursingTaskService.updateNursingTaskIntentAgency(
            nursingTaskCodes,
            intentAgencyCode,
            applyType,
            isRelativeCared,
            operatedBy,
            operatedOrg);

    RestResponseDTO restResponseDTO = new RestResponseDTO();
    restResponseDTO.setData(resultDTO);
    return restResponseDTO;
  }

  /**
   * 选择最终护理机构
   *
   * @param nursingTaskCodes
   * @param intentAgencyCodes
   * @param operatedBy
   * @param operatedOrg
   * @return
   */
  @RequestMapping(value = "/nursingTaskFinalAgency", method = RequestMethod.PUT)
  public RestResponseDTO updateNursingTaskFinalAgency(
      @RequestParam(value = "nursingTaskCodes") String nursingTaskCodes,
      @RequestParam(value = "finalAgencyCode") String finalAgencyCode,
      @RequestParam(value = "finalAgencyName") String finalAgencyName,
      @RequestParam(value = "applyType", defaultValue = "") String applyType,
      @RequestParam(value = "isRelativeCared", defaultValue = "") String isRelativeCared,
      @RequestParam(value = "operatedBy", defaultValue = "") String operatedBy,
      @RequestParam(value = "operatedOrg", defaultValue = "") String operatedOrg) {
    logger.info("-------------------updateNursingTaskIntentAgency------------");
    logger.info("-------------------nursingTaskCodes:" + nursingTaskCodes + "----------------");
    logger.info("-------------------finalAgencyCode:" + finalAgencyCode + "--------------");
    logger.info("-------------------applyType:" + applyType + "------------");
    logger.info("-------------------isRelativeCared:" + isRelativeCared + "-----------");
    logger.info("-------------------operatedBy:" + operatedBy + "----------");
    logger.info("-------------------operatedOrg:" + operatedOrg + "---------");

    ResultDTO resultDTO =
        nursingTaskService.updateNursingTaskFinalAgency(
            nursingTaskCodes,
            finalAgencyCode,
            finalAgencyName,
            applyType,
            isRelativeCared,
            operatedBy,
            operatedOrg);

    RestResponseDTO restResponseDTO = new RestResponseDTO();
    restResponseDTO.setData(resultDTO);
    return restResponseDTO;
  }

  /**
   * 护理机构确认页面列表查询
   *
   * @param insuredPersonName
   * @param idCard
   * @param evaluateAgencyName
   * @param operatedTime
   * @param state
   * @param page
   * @param pageSize
   * @return
   */
  @SuppressWarnings("unchecked")
  @RequestMapping(value = "/nursingTasks", method = RequestMethod.POST)
  public RestResponseDTO listNursingTask(
      String insuredPersonName,
      String idCard,
      String evaluateAgencyName,
      String operatedTime,
      String state,
      @RequestParam(value = "page", defaultValue = "1") int pageParam,
      @RequestParam(value = "pageSize", defaultValue = "15") int pageSize) {
    logger.debug("=======进入评估结果送达页面查询信息===============");
    logger.debug("=======insuredPersonName【" + insuredPersonName + "】========");
    logger.debug("=======idCard【" + idCard + "】========");
    logger.debug("=======evaluateAgencyName【" + evaluateAgencyName + "】=========");
    logger.debug("=======operatedTime【" + operatedTime + "】==========");
    logger.debug("=======taskState【" + state + "】===========");
    logger.debug("=======pageParam【" + pageParam + "】===========");
    logger.debug("=======pageSize【" + pageSize + "】===========");

    int page;
    if (pageParam < 1) {
      page = 1;
    } else {
      page = pageParam;
    }
    //传入状态为全部的时候暂时写死
    String newState = "";
    if (StringUtils.isEmpty(state) || "全部".equals(state)) {
      newState =
          NursingTaskEnum.NO_INTENT_AGENCY.getValue()
              + ","
              + NursingTaskEnum.ALREADY_INTENT_AGENCY.getValue()
              + ","
              + NursingTaskEnum.ALREADY_FINAL_AGENCY.getValue();
    } else {
      newState = state;
    }

    Map<String, Object> map =
        nursingTaskService.getNursingTaskList(
            insuredPersonName, idCard, evaluateAgencyName, operatedTime, newState, page, pageSize);

    List<NursingTaskSpecialDO> nursingTaskSpecialDOs =
        (List<NursingTaskSpecialDO>) map.get("nursingTaskSpecialDOs");
    Integer count = (Integer) map.get("count");
    Integer totalPage = (Integer) map.get("totalPage");
    PageResultDTO pageResultDTO = new PageResultDTO();
    pageResultDTO.setDatas(nursingTaskSpecialDOs);
    pageResultDTO.setMessage("查询成功");
    pageResultDTO.setPage(page);
    pageResultDTO.setPageSize(pageSize);
    pageResultDTO.setTotalDataNum(count);
    pageResultDTO.setTotalPageNum(totalPage);
    pageResultDTO.setStatus(StatusCodeEnum.OK.getValue());
    logger.debug("=======进入初评结果查询接口结束===============");
    RestResponseDTO restResponseDTO = new RestResponseDTO();
    restResponseDTO.setData(pageResultDTO);
    return restResponseDTO;
  }
}
