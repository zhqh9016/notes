package com.taikang.dic.ltci.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.google.common.collect.Lists;
import com.taikang.dic.ltci.api.model.EvaluateTaskDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.RestResponseDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.EvaluateEnum;
import com.taikang.dic.ltci.common.enumeration.IsReevaluateEnum;
import com.taikang.dic.ltci.common.enumeration.IsTaskDeadline;
import com.taikang.dic.ltci.common.enumeration.IsValidEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.util.DateFormat;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.model.DictionaryDO;
import com.taikang.dic.ltci.model.EvaluateTaskDO;
import com.taikang.dic.ltci.model.EvaluateTaskDeliveryDO;
import com.taikang.dic.ltci.model.EvaluateTaskSpecialDO;
import com.taikang.dic.ltci.serverClient.DictionaryServerClient;
import com.taikang.dic.ltci.service.EvaluateTaskService;

@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class EvaluateTaskController {

  private static final Logger logger = LoggerFactory.getLogger(EvaluateTaskController.class);

  @Autowired private EvaluateTaskService evaluateTaskService;

  @Autowired private DictionaryServerClient dictionaryServerClient;

  @Value(value = "${urgentConfig}")
  private int urgentConfig;

  @Value(value = "${notUrgentConfig}")
  private int notUrgentConfig;

  @RequestMapping(value = "/evaluateTask", method = RequestMethod.PUT)
  public RestResponseDTO sendEvaluateTask(
      @RequestParam(value = "evaluateTaskCodes") String evaluateTaskCodes,
      @RequestParam(value = "operatedBy", defaultValue = "") String operatedBy,
      @RequestParam(value = "operatedOrg", defaultValue = "") String operatedOrg) {
    ResultDTO resultDTO =
        evaluateTaskService.sendEvaluateTaskBatch(evaluateTaskCodes, operatedBy, operatedOrg);
    RestResponseDTO responseDTO = new RestResponseDTO();
    responseDTO.setData(resultDTO);
    return responseDTO;
  }

  /**
   * 新增评估任务
   *
   * @param evaluateTaskDTO
   * @return
   */
  @RequestMapping(value = "/evaluateTask", method = RequestMethod.POST)
  public RestResponseDTO expertTaskAdd(@RequestBody EvaluateTaskDTO evaluateTaskDTO) {
    EvaluateTaskDO evaluateTaskDO = new EvaluateTaskDO();
    BeanUtils.copyProperties(evaluateTaskDTO, evaluateTaskDO);
    if (evaluateTaskDTO.getTaskDeadline() != null) {
      evaluateTaskDO.setTaskDeadline(evaluateTaskDTO.getTaskDeadline());
    }
    evaluateTaskDO.setCreatedTime(new Date());
    evaluateTaskDO.setOperatedTime(new Date());
    evaluateTaskDO.setOperatedOrg(evaluateTaskDTO.getOperatedOrg());
    evaluateTaskDO.setCreatedOrg(evaluateTaskDTO.getCreatedOrg());
    evaluateTaskDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
    evaluateTaskDO.setIsReevaluate(IsReevaluateEnum.NO_REEVALUATE.getValue());
    ResultDTO resultDTO = new ResultDTO();
    evaluateTaskService.createEvaluateTask(evaluateTaskDO);
    resultDTO.setMessage("添加成功");
    resultDTO.setStatus(StatusCodeEnum.CREATED.getValue());

    RestResponseDTO responseDTO = new RestResponseDTO();
    responseDTO.setData(resultDTO);
    return responseDTO;
  }

  /**
   * 评估任务列表查询
   *
   * @param evaluateTaskDTOParam
   * @param page
   * @param pageSize
   * @return
   */
  @RequestMapping(value = "/evaluateTasks", method = RequestMethod.POST)
  @ResponseBody
  public RestResponseDTO evaluateTaskList(
      @RequestBody EvaluateTaskDTO evaluateTaskDTOParam,
      @RequestParam(value = "page", defaultValue = "1") int pageParam,
      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
    logger.info(
        "====EvaluateTaskController类：evaluateTaskList() ======= start:"
            + DateFormat.getLocalDateTime());
    logger.info("参数insuredPersonName:".concat(evaluateTaskDTOParam.getInsuredPersonName()));
    logger.info("参数mobile:".concat(evaluateTaskDTOParam.getMobile()));
    logger.info("参数taskstate:".concat(evaluateTaskDTOParam.getTaskState()));
    logger.info("参数operatedTime:" + evaluateTaskDTOParam.getOperatedTime());
    logger.info("参数page:" + pageParam);
    logger.info("参数pageSize:" + pageSize);

    int page;
    if (pageParam < 1) {
      page = 1;
    } else {
      page = pageParam;
    }

    logger.debug("page:" + page);
    logger.debug("pageSize:" + pageSize);
    List<EvaluateTaskSpecialDO> evaluateTaskDOList =
        evaluateTaskService.queryEvaluateTaskList(
            evaluateTaskDTOParam.getInsuredPersonName(),
            evaluateTaskDTOParam.getMobile(),
            evaluateTaskDTOParam.getOperatedTime(),
            evaluateTaskDTOParam.getTaskState(),
            evaluateTaskDTOParam.getTodoListCode(),
            page - 1,
            pageSize);
    if (evaluateTaskDOList != null) {
      logger.debug("evaluateTaskDOList:" + evaluateTaskDOList.size());
    }
    List<EvaluateTaskDTO> evaluateTaskDTOList = Lists.newArrayList();
    PageResultDTO pageResultDto = new PageResultDTO();

    int totalRecord =
        evaluateTaskService.countEvaluateTaskDOList(
            evaluateTaskDTOParam.getInsuredPersonName(),
            evaluateTaskDTOParam.getMobile(),
            evaluateTaskDTOParam.getOperatedTime(),
            evaluateTaskDTOParam.getTaskState()); //总条数
    int totalPage = (totalRecord + pageSize - 1) / pageSize; //总页数

    //调用数字字典微服务
    ResultDTO resultDTO =
        dictionaryServerClient.getDictionaryDOByCondition("taskDeadLine", "urgentConfig");
    List<DictionaryDO> dictionaryList =
        JSONArray.parseArray(JSONArray.toJSONString(resultDTO.getDatas()), DictionaryDO.class);
    if (!dictionaryList.isEmpty()) {
      String urgentConfigString = dictionaryList.get(0).getValueName();
      urgentConfig = Integer.parseInt(urgentConfigString);
    }

    resultDTO =
        dictionaryServerClient.getDictionaryDOByCondition("taskDeadLine", "notUrgentConfig");
    List<DictionaryDO> notUrgentConfigList =
        JSONArray.parseArray(JSONArray.toJSONString(resultDTO.getDatas()), DictionaryDO.class);
    if (!dictionaryList.isEmpty()) {
      String notUrgentConfigString = notUrgentConfigList.get(0).getValueName();
      notUrgentConfig = Integer.parseInt(notUrgentConfigString);
    }

    logger.info("urgentConfig:" + urgentConfig + "天");
    logger.info("notUrgentConfig:" + notUrgentConfig + "天");
    if (evaluateTaskDOList != null && !evaluateTaskDOList.isEmpty()) {
      evaluateTaskDOList.forEach(
          p ->
              evaluateTaskDTOList.add(
                  evaluateTaskDOToEvaluateTaskDTO(
                      p, Integer.toString(urgentConfig), Integer.toString(notUrgentConfig))));

      pageResultDto.setDatas(evaluateTaskDTOList);
      pageResultDto.setMessage("列表查询成功");
      pageResultDto.setPage(page);
      pageResultDto.setPageSize(pageSize);
      pageResultDto.setStatus(StatusCodeEnum.OK.getValue());
      pageResultDto.setTotalDataNum(totalRecord);
      pageResultDto.setTotalPageNum(totalPage);
    } else {
      pageResultDto.setDatas(evaluateTaskDTOList);
      pageResultDto.setMessage("列表查询成功");
      pageResultDto.setPage(page);
      pageResultDto.setPageSize(pageSize);
      pageResultDto.setStatus(StatusCodeEnum.OK.getValue());
      pageResultDto.setTotalDataNum(totalRecord);
      pageResultDto.setTotalPageNum(totalPage);
    }

    logger.info(
        "====EvaluateTaskController类：evaluateTaskList() ======= end:"
            + DateFormat.getLocalDateTime());
    RestResponseDTO responseDTO = new RestResponseDTO();
    responseDTO.setData(pageResultDto);
    return responseDTO;
  }

  @RequestMapping(value = "/toDoListEvaluateTaskList", method = RequestMethod.GET)
  public RestResponseDTO getToDoListEvaluateTaskList() {
    RestResponseDTO responseDTO = new RestResponseDTO();
    List<EvaluateTaskDTO> evaluateTaskDTOList = Lists.newArrayList();
    List<EvaluateTaskSpecialDO> list = evaluateTaskService.getToDoListEvaluateTaskList();

    //调用数字字典微服务
    ResultDTO resultDTO =
        dictionaryServerClient.getDictionaryDOByCondition("taskDeadLine", "urgentConfig");
    List<DictionaryDO> dictionaryList =
        JSONArray.parseArray(JSONArray.toJSONString(resultDTO.getDatas()), DictionaryDO.class);
    if (!dictionaryList.isEmpty()) {
      String urgentConfigString = dictionaryList.get(0).getValueName();
      urgentConfig = Integer.parseInt(urgentConfigString);
    }

    resultDTO =
        dictionaryServerClient.getDictionaryDOByCondition("taskDeadLine", "notUrgentConfig");
    List<DictionaryDO> notUrgentConfigList =
        JSONArray.parseArray(JSONArray.toJSONString(resultDTO.getDatas()), DictionaryDO.class);
    if (!dictionaryList.isEmpty()) {
      String notUrgentConfigString = notUrgentConfigList.get(0).getValueName();
      notUrgentConfig = Integer.parseInt(notUrgentConfigString);
    }

    if (list != null && !list.isEmpty()) {
      list.forEach(
          p ->
              evaluateTaskDTOList.add(
                  evaluateTaskDOToEvaluateTaskDTO(
                      p, Integer.toString(urgentConfig), Integer.toString(notUrgentConfig))));
    }
    ResultDTO dto = new ResultDTO();
    dto.setStatus(StatusCodeEnum.OK.getValue());
    dto.setDatas(evaluateTaskDTOList);
    responseDTO.setData(dto);
    return responseDTO;
  }

  /**
   * 根据评估任务编号批量修改送达状态
   *
   * @param taskState
   * @param operatedBy
   * @param evaluateTaskCodes
   * @return
   */
  @RequestMapping(
    path = "/evaluateTaskStauts/{taskState}/{operatedBy}/{operatedOrg}/{evaluateTaskCodes}"
  )
  @ResponseBody
  public RestResponseDTO evaluateTaskStautsCase(
      @PathVariable String taskState,
      @PathVariable String operatedBy,
      @PathVariable String operatedOrg,
      @PathVariable String evaluateTaskCodes) {
    ResultDTO resultDto = new ResultDTO();
    try {
      int result =
          evaluateTaskService.batchUpdateEvaluateTaskStatusByEvaluateTaskCodes(
              taskState, operatedBy, operatedOrg, new Date(), evaluateTaskCodes);
      resultDto.setNumber(0);
      if (result > 0) {
        resultDto.setMessage("状态修改成功");
        resultDto.setStatus(StatusCodeEnum.CREATED.getValue());
      } else if (result == -1) {
        resultDto.setMessage("记录已被他人操作，请刷新界面，重新选择数据！");
        resultDto.setStatus(StatusCodeEnum.INSERT_REPEAT.getValue());
      } else {
        resultDto.setMessage("状态修改失败");
        resultDto.setStatus(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
      }
    } catch (Exception e) {
      logger.error("错误信息：" + e);
      resultDto.setMessage(e.getMessage());
      resultDto.setStatus(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
    }
    RestResponseDTO responseDTO = new RestResponseDTO();
    responseDTO.setData(resultDto);
    return responseDTO;
  }

  /**
   * 经办人员重评
   *
   * @param evaluateTaskCode
   * @param reevalueateResult
   * @return
   */
  @RequestMapping(value = "/reviewEvaluateTask", method = RequestMethod.PUT)
  public RestResponseDTO reviewEvaluateTask(
      @RequestParam(value = "evaluateTaskCode") String evaluateTaskCode,
      @RequestParam(value = "reevalueateResult") String reevalueateResult,
      @RequestParam(value = "operatedBy", defaultValue = "") String operatedBy,
      @RequestParam(value = "operatedOrg", defaultValue = "") String operatedOrg) {
    ResultDTO dto =
        evaluateTaskService.reviewEvaluateTask(
            evaluateTaskCode, reevalueateResult, operatedBy, operatedOrg);
    RestResponseDTO responseDTO = new RestResponseDTO();
    responseDTO.setData(dto);
    return responseDTO;
  }

  /**
   * 将EvaluateTaskDO转换成EvaluateTaskDTO
   *
   * @param TreatmentApplicationDo
   * @return MobileTreatApplyDto
   */
  private EvaluateTaskDTO evaluateTaskDOToEvaluateTaskDTO(
      EvaluateTaskSpecialDO evaluateTaskDO, String urgentConfig, String notUrgentConfig) {
    EvaluateTaskDTO dto = new EvaluateTaskDTO();
    dto.setApplicationCode(
        evaluateTaskDO.getApplicationCode() != null ? evaluateTaskDO.getApplicationCode() : "");
    dto.setCreatedBy(evaluateTaskDO.getCreatedBy() != null ? evaluateTaskDO.getCreatedBy() : "");
    dto.setCreatedOrg(evaluateTaskDO.getCreatedOrg() != null ? evaluateTaskDO.getCreatedOrg() : "");
    if (evaluateTaskDO.getCreatedTime() != null)
      dto.setCreatedTime(evaluateTaskDO.getCreatedTime().toString());
    dto.setEvaluateAgencyCode(
        evaluateTaskDO.getEvaluateAgencyCode() != null
            ? evaluateTaskDO.getEvaluateAgencyCode()
            : "");
    dto.setEvaluateAgencyName(
        evaluateTaskDO.getEvaluateAgencyName() != null
            ? evaluateTaskDO.getEvaluateAgencyName()
            : "");
    dto.setEvaluateCode(
        evaluateTaskDO.getEvaluateCode() != null ? evaluateTaskDO.getEvaluateCode() : "");
    dto.setEvaluateTaskCode(
        evaluateTaskDO.getEvaluateTaskCode() != null ? evaluateTaskDO.getEvaluateTaskCode() : "");
    dto.setEvaluateTaskid(
        evaluateTaskDO.getEvaluateTaskid() != null ? evaluateTaskDO.getEvaluateTaskid() : "");
    dto.setInsuredPersonCode(
        evaluateTaskDO.getInsuredPersonCode() != null ? evaluateTaskDO.getInsuredPersonCode() : "");
    dto.setInsuredPersonName(
        evaluateTaskDO.getInsuredPersonName() != null ? evaluateTaskDO.getInsuredPersonName() : "");
    dto.setIsReevaluate(
        evaluateTaskDO.getReevalueateResult() != null ? evaluateTaskDO.getReevalueateResult() : "");
    if (evaluateTaskDO.getIsValid() != null) {
      dto.setIsValid(evaluateTaskDO.getIsValid());
    }
    dto.setMobile(evaluateTaskDO.getMobile() != null ? evaluateTaskDO.getMobile() : "");
    dto.setOperatedBy(evaluateTaskDO.getOperatedBy() != null ? evaluateTaskDO.getOperatedBy() : "");
    dto.setOperatedOrg(
        evaluateTaskDO.getOperatedOrg() != null ? evaluateTaskDO.getOperatedOrg() : "");
    if (evaluateTaskDO.getOperatedTime() != null)
      dto.setOperatedTime(DateFormatUtil.dateToTimeStr(evaluateTaskDO.getOperatedTime()));
    dto.setPrintState(evaluateTaskDO.getPrintState() != null ? evaluateTaskDO.getPrintState() : "");
    dto.setReevaluateParentCode(
        evaluateTaskDO.getReevaluateParentCode() != null
            ? evaluateTaskDO.getReevaluateParentCode()
            : "");
    dto.setReevalueateResult(
        evaluateTaskDO.getReevalueateResult() != null ? evaluateTaskDO.getReevalueateResult() : "");
    dto.setRemark(evaluateTaskDO.getRemark() != null ? evaluateTaskDO.getRemark() : "");
    if (evaluateTaskDO.getSendTime() != null)
      dto.setSendTime(DateFormatUtil.dateToTimeStr(evaluateTaskDO.getSendTime()));
    dto.setSiArea(evaluateTaskDO.getSiArea() != null ? evaluateTaskDO.getSiArea() : "");
    if (evaluateTaskDO.getTaskDeadline() != null) {
      dto.setTaskDeadline(evaluateTaskDO.getTaskDeadline());
      if (IsTaskDeadline.TASKDEADLINE
          .getValue()
          .equals(evaluateTaskDO.getTaskDeadline())) { //02不紧急，01紧急
        dto.setTaskDeadlineDay(urgentConfig + "天(紧急)");
      } else {
        dto.setTaskDeadlineDay(notUrgentConfig + "天");
      }
    } else {
      dto.setTaskDeadline(IsTaskDeadline.NO_TASKDEADLINE.getValue());
      dto.setTaskDeadlineDay(notUrgentConfig + "天");
    }
    dto.setTaskState(evaluateTaskDO.getTaskState() != null ? evaluateTaskDO.getTaskState() : "");
    dto.setAddress(evaluateTaskDO.getAddress() != null ? evaluateTaskDO.getAddress() : "");
    return dto;
  }

  /**
   * 评估结果送达页面列表查询
   *
   * @param insuredPersonName
   * @param idCard
   * @param evaluateOrg
   * @param operatedTime
   * @param taskState
   * @param page
   * @param pageSize
   * @return
   */
  @SuppressWarnings("unchecked")
  @RequestMapping(value = "/evaluateTask/sendMessage", method = RequestMethod.POST)
  public RestResponseDTO listExpertTask(
      String insuredPersonName,
      String idCard,
      String evaluateOrg,
      String operatedTime,
      String taskState,
      @RequestParam(value = "page", defaultValue = "1") int pageParam,
      @RequestParam(value = "pageSize", defaultValue = "15") int pageSize) {
    logger.debug("=======进入评估结果送达页面查询信息===============");
    logger.debug("=======insuredPersonName【" + insuredPersonName + "】=========");
    logger.debug("=======idCard【" + idCard + "】=======");
    logger.debug("=======evaluateOrg【" + evaluateOrg + "】=======");
    logger.debug("=======operatedTime【" + operatedTime + "】======");
    logger.debug("=======taskState【" + taskState + "】=====");

    int page;
    if (pageParam < 1) {
      page = 1;
    } else {
      page = pageParam;
    }

    if ("".equals(taskState) || null == taskState) {
      taskState =
          "'"
              + EvaluateEnum.NO_DELIVERY.getValue()
              + "','"
              + EvaluateEnum.ALREADY_DELIVERY.getValue()
              + "','"
              + EvaluateEnum.ALREADY_RECEIVE.getValue()
              + "'";
    } else {
      if (taskState.indexOf(",") == -1) {
        taskState = "'" + taskState + "'";
      } else {
        taskState = "'" + taskState.replaceAll(",", "','") + "'";
      }
    }

    Map<String, Object> map =
        evaluateTaskService.getExpertTaskList(
            insuredPersonName, idCard, evaluateOrg, operatedTime, taskState, page, pageSize);

    List<EvaluateTaskDeliveryDO> evaluateTaskDeliveryDOs =
        (List<EvaluateTaskDeliveryDO>) map.get("EvaluateTaskDeliveryDOs");
    Integer count = (Integer) map.get("count");
    Integer totalPage = (Integer) map.get("totalPage");
    PageResultDTO pageResultDTO = new PageResultDTO();
    pageResultDTO.setDatas(evaluateTaskDeliveryDOs);
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

  /**
   * 根据评估任务code获取详情信息
   *
   * @param evaluateTaskCode
   * @return
   */
  @RequestMapping(path = "/evaluateTask/{evaluateTaskCode}")
  @ResponseBody
  public RestResponseDTO getEvaluateTask(@PathVariable String evaluateTaskCode) {
    EvaluateTaskSpecialDO valuateTaskSpecialDO =
        evaluateTaskService.getEvaluateTaskSpecialDOByCode(evaluateTaskCode);
    ResultDTO resultDto = new ResultDTO();
    resultDto.setDatas(valuateTaskSpecialDO);
    resultDto.setNumber(Integer.valueOf(1));
    resultDto.setMessage("详细查询成功");
    resultDto.setStatus(StatusCodeEnum.OK.getValue());

    RestResponseDTO restResponseDTO = new RestResponseDTO();
    restResponseDTO.setData(resultDto);
    return restResponseDTO;
  }

  /**
   * 移动端查评估任务表状态 根据evaluateTaskCode查询具体信息
   *
   * @param evaluateTaskCode
   * @return
   */
  @RequestMapping(path = "/evaluateTask/{evaluateTaskCode}/state")
  @ResponseBody
  public RestResponseDTO getEvaluateTaskState(@PathVariable String evaluateTaskCode) {
    logger.debug("====evaluateTaskCode【" + evaluateTaskCode + "】=========");
    EvaluateTaskDeliveryDO valuateTaskSpecialDO =
        evaluateTaskService.getEvaluateTaskSpecialStateByCode(evaluateTaskCode);
    ResultDTO resultDto = new ResultDTO();
    resultDto.setDatas(valuateTaskSpecialDO);
    resultDto.setMessage("详细查询成功");
    resultDto.setStatus(StatusCodeEnum.OK.getValue());

    RestResponseDTO restResponseDTO = new RestResponseDTO();
    restResponseDTO.setData(resultDto);
    restResponseDTO.setBusinessSerialid(UUID.randomUUID().toString().replaceAll("-", ""));
    restResponseDTO.setTimestamp(new Date().getTime() + "");
    return restResponseDTO;
  }

  /**
   * 移动端查评估任务表状态 根据idCard查询多条信息
   *
   * @param idCard
   * @return
   */
  @RequestMapping(path = "/evaluateTask/{idCard}/taskState")
  @ResponseBody
  public RestResponseDTO getEvaluateTaskByIdCard(@PathVariable String idCard) {
    logger.debug("====idCard【" + idCard + "】=========");
    Map<String, Object> map = evaluateTaskService.getEvaluateTaskByIdCard(idCard);

    ResultDTO resultDto = new ResultDTO();
    resultDto.setDatas(map);
    resultDto.setMessage("详细查询成功");
    resultDto.setStatus(StatusCodeEnum.OK.getValue());

    RestResponseDTO restResponseDTO = new RestResponseDTO();
    restResponseDTO.setBusinessSerialid(UUID.randomUUID().toString().replaceAll("-", ""));
    restResponseDTO.setData(resultDto);
    restResponseDTO.setTimestamp(new Date().getTime() + "");
    return restResponseDTO;
  }

  /**
   * 根据图片id查询具体的图片信息
   *
   * @param id
   */
  @RequestMapping(value = "/evaluateTask/mongoDBMessage", method = RequestMethod.POST)
  public RestResponseDTO getMongoDBMessage(String id) {
    logger.debug("=======id【" + id + "】=========");
    String base64 = evaluateTaskService.getMongoDBMessage(id);

    ResultDTO resultDto = new ResultDTO();
    resultDto.setDatas(base64);
    resultDto.setMessage("详细查询成功");
    resultDto.setStatus(StatusCodeEnum.OK.getValue());

    RestResponseDTO restResponseDTO = new RestResponseDTO();
    restResponseDTO.setData(resultDto);
    return restResponseDTO;
  }
}
