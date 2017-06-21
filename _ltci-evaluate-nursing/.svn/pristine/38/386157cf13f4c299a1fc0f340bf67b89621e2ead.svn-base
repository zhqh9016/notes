package com.taikang.dic.ltci.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.taikang.dic.ltci.api.model.AttachmentDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.api.model.TodoListDTO;
import com.taikang.dic.ltci.common.enumeration.EvaluateEnum;
import com.taikang.dic.ltci.common.enumeration.FileTypeEnum;
import com.taikang.dic.ltci.common.enumeration.IsReevaluateEnum;
import com.taikang.dic.ltci.common.enumeration.IsTaskDeadline;
import com.taikang.dic.ltci.common.enumeration.IsValidEnum;
import com.taikang.dic.ltci.common.enumeration.ModuleCodeEnum;
import com.taikang.dic.ltci.common.enumeration.MqTypeEnum;
import com.taikang.dic.ltci.common.enumeration.NursingTaskEnum;
import com.taikang.dic.ltci.common.enumeration.OperationTypeEnum;
import com.taikang.dic.ltci.common.enumeration.OrganizationTypeEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.enumeration.ToDoListEnum;
import com.taikang.dic.ltci.common.enumeration.TransportTypeEnum;
import com.taikang.dic.ltci.common.exception.InsertRepeatException;
import com.taikang.dic.ltci.common.exception.NotFoundByIdException;
import com.taikang.dic.ltci.common.exception.ParametersIsNullException;
import com.taikang.dic.ltci.common.exception.ThrowsException;
import com.taikang.dic.ltci.common.log.ThreadLocalUtil;
import com.taikang.dic.ltci.common.util.DateFormat;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.common.util.IPUtil;
import com.taikang.dic.ltci.common.util.JsonUtils;
import com.taikang.dic.ltci.common.util.MediaFileUtils;
import com.taikang.dic.ltci.dao.EvaluateTaskDAO;
import com.taikang.dic.ltci.dao.EvaluateTaskLogDAO;
import com.taikang.dic.ltci.dao.EvaluateTaskSpecialDAO;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.MQMessageLogDAO;
import com.taikang.dic.ltci.model.ApplicationComplexDO;
import com.taikang.dic.ltci.model.ApplicationSimpleDO;
import com.taikang.dic.ltci.model.DictionaryDO;
import com.taikang.dic.ltci.model.EvaluateTaskDO;
import com.taikang.dic.ltci.model.EvaluateTaskDOExample;
import com.taikang.dic.ltci.model.EvaluateTaskDOExample.Criteria;
import com.taikang.dic.ltci.model.EvaluateTaskDeliveryDO;
import com.taikang.dic.ltci.model.EvaluateTaskLogDO;
import com.taikang.dic.ltci.model.EvaluateTaskSpecialDO;
import com.taikang.dic.ltci.model.InsuredPersonDO;
import com.taikang.dic.ltci.model.MQMessageLogDO;
import com.taikang.dic.ltci.model.MqBaseModel;
import com.taikang.dic.ltci.model.MqFailMessageLogDO;
import com.taikang.dic.ltci.model.NursingTaskDO;
import com.taikang.dic.ltci.model.OrganizationDO;
import com.taikang.dic.ltci.serverClient.AttachmentServiceClient;
import com.taikang.dic.ltci.serverClient.DictionaryServerClient;
import com.taikang.dic.ltci.serverClient.InsuredPersonServerClient;
import com.taikang.dic.ltci.serverClient.OrganizationServerClient;
import com.taikang.dic.ltci.serverClient.TodoListServerClient;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.EvaluateTaskService;
import com.taikang.dic.ltci.service.NursingTaskService;

@Service
public class EvaluateTaskServiceImpl extends AbstractGenericService<EvaluateTaskDO, String>
    implements EvaluateTaskService {

  @Autowired private EvaluateTaskDAO evaluateTaskDAO;

  @Autowired private EvaluateTaskSpecialDAO evaluateTaskSpecialDAO;

  @Autowired private EvaluateTaskLogDAO evaluateTaskLogDAO;

  @Autowired private InsuredPersonServerClient insuredPersonServerClient;

  @Autowired private MQMessageLogDAO mqMessageLogDAO;

  @Autowired private AttachmentServiceClient attachmentServiceClient;

  @Autowired private MediaFileUtils mediaFileUtils;

  @Autowired private TodoListServerClient todoListServerClient;

  @Autowired private MqFailMessageLogServiceImpl failMessageLogService;

  @Autowired private NursingTaskService nursingTaskService;

  @Value("${ltci.evaluateTask.queue}")
  private String routingKey;

  @Value("${ltci.evaluateTask.exchange}")
  private String exchangeName;

  @Value("${ltci.sendEvaluateTask.messageCode}")
  private String messageCode;

  @Value(value = "${urgentConfig}")
  private int urgentConfig;

  @Value(value = "${notUrgentConfig}")
  private int notUrgentConfig;

  @Autowired private DictionaryServerClient dictionaryServerClient;

  @Autowired private OrganizationServerClient organizationServerClient;

  @Override
  public IGenericDAO<EvaluateTaskDO, String> getDao() {
    return null;
  }

  /** 发送评估任务：批量发送评估任务 */
  @Override
  @Transactional
  public ResultDTO sendEvaluateTaskBatch(
      String evaluateTaskCodes, String operatedBy, String operatedOrg) {

    logger.info("评估任务发送：start" + DateFormatUtil.dateToTimeStr(new Date()));

    if (StringUtils.isBlank(evaluateTaskCodes)) {
      throw new ParametersIsNullException("发送评估任务操作参数不能为空！");
    }
    String[] evaluateTaskCodeArrs = evaluateTaskCodes.split(",");

    for (String evaluateTaskCode : evaluateTaskCodeArrs) {
      int size = updateEvaluateTask(evaluateTaskCode, operatedBy, operatedOrg);
      if (size == 0) {
        throw new InsertRepeatException("记录已被他人操作，请刷新界面，重新选择数据！");
      }
    }

    logger.info("评估任务发送：修改状态结束:" + DateFormatUtil.dateToTimeStr(new Date()));

    for (String evaluateTaskCode : evaluateTaskCodeArrs) {
      sendEvaluateTask(evaluateTaskCode, operatedBy, operatedOrg);
    }
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.CREATED.getValue());
    resultDTO.setMessage("发送成功");

    logger.info("评估任务发送：end" + DateFormatUtil.dateToTimeStr(new Date()));
    return resultDTO;
  }

  /**
   * 单个评估任务发送： 2.MQ发送评估任务 3.记录MQ日志
   *
   * @param evaluateTaskCode
   * @param evaluateAgencyCode
   * @return
   */
  public void sendEvaluateTask(String evaluateTaskCode, String operatedBy, String operatedOrg) {

    Date date = new Date();
    logger.info("sendEvaluateTask：start" + DateFormatUtil.dateToTimeStr(new Date()));
    //1.查询评估任务基本信息
    EvaluateTaskSpecialDO evaluateTaskSpecialDO = getEvaluateTaskSpecialDOByCode(evaluateTaskCode);
    //封装MqBaseModel信息
    //evaluateTaskSpecialDO.setEvaluateAgencyCode(evaluateAgencyCode);
    //evaluateTaskSpecialDO.setEvaluateAgencyName(evaluateAgencyName);
    Map<String, Object> map = getMqDetailsMsg(evaluateTaskSpecialDO, operatedBy, operatedOrg);

    logger.info("sendEvaluateTask：获取附件" + DateFormatUtil.dateToTimeStr(new Date()));
    MqBaseModel mqBaseModel = new MqBaseModel();
    mqBaseModel.setBusinessSerialid(UUID.randomUUID().toString().replaceAll("-", ""));
    mqBaseModel.setTimestamp(DateFormat.getLocalDateTime());

    try {
      mqBaseModel.setNodeIP(IPUtil.getLocalIp());
    } catch (Exception e) {
      logger.error("错误信息：" + e);
      throw new NotFoundByIdException("获取本地IP失败！");
    }
    mqBaseModel.setSystemCode(systemCode);
    mqBaseModel.setModuleCode(ModuleCodeEnum.SEND_EVALUATE_TASK.getValue());
    mqBaseModel.setMessageCode(messageCode);
    mqBaseModel.setData(map);
    String jsonString = JSONObject.toJSONString(mqBaseModel);
    //创建日志基本信息
    MQMessageLogDO mqLogDo = new MQMessageLogDO();
    mqLogDo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
    mqLogDo.setType(MqTypeEnum.SEND.getValue());
    mqLogDo.setSendTime(date);
    mqLogDo.setCreateTime(date);
    mqLogDo.setReSendNum(0L);
    mqLogDo.setSendState("0");
    mqLogDo.setExchangeName(exchangeName);
    mqLogDo.setQueueName(routingKey);
    mqLogDo.setSendContent(jsonString);

    //2.保存日志信息
    mqMessageLogDAO.insert(mqLogDo);
    //3.发送MQ信息
    try {
      sendMessage(exchangeName, routingKey, jsonString);
    } catch (Exception e) {
      logger.info("发送MQ失败错误：", e);
      mqMessageLogDAO.deleteByPrimaryKey(mqLogDo.getId());
      MqFailMessageLogDO failLog = new MqFailMessageLogDO();

      failLog.setId(mqLogDo.getId());
      failLog.setTransportType(TransportTypeEnum.ASYNCHRONIZE.getValue()); //交互方式：异步
      failLog.setOperationType(OperationTypeEnum.SEND.getValue()); //发送接收类型
      failLog.setExchangeName(exchangeName);
      failLog.setQueryName(routingKey);
      failLog.setContent(jsonString);
      failLog.setErrorMessage(e.getMessage());
      failLog.setCreateTime(new Date());
      failLog.setHttpAction(HttpMethod.POST.name());
      // 添加重试url
      failMessageLogService.saveOrUpdateFailLog(failLog);
    }
    logger.debug("====sendEvaluateTask end:" + DateFormatUtil.dateToTimeStr(new Date()));
  }

  /**
   * 单个评估任务发送： 1.查询评估详情 2.修改评估状态 3.新增评估日志
   *
   * @param evaluateTaskCode
   * @param evaluateAgencyCode
   * @return
   */
  public int updateEvaluateTask(String evaluateTaskCode, String operatedBy, String operatedOrg) {

    Date date = new Date();
    logger.info("updateEvaluateTask：start" + DateFormatUtil.dateToTimeStr(new Date()));
    //1.查询评估任务基本信息
    EvaluateTaskSpecialDO evaluateTaskSpecialDO = getEvaluateTaskSpecialDOByCode(evaluateTaskCode);

    if (!EvaluateEnum.NO_SEND.getValue().equals(evaluateTaskSpecialDO.getTaskState())) {
      throw new InsertRepeatException("根据评估任务id:" + evaluateTaskCode + " 查询的评估任务已经发送！");
    }

    String evaluateAgencyCode = null;
    String evaluateAgencyName = null;

    ResultDTO dto =
        organizationServerClient.getEvaluateDepartments(
            evaluateTaskSpecialDO.getAreaCode(), OrganizationTypeEnum.EVALUATE_AGENCY.getValue());

    if (!StatusCodeEnum.OK.getValue().equals(dto.getStatus())) {
      throw new ThrowsException(dto.getMessage());
    }
    List<OrganizationDO> list =
        JSONArray.parseArray(JSONArray.toJSONString(dto.getDatas()), OrganizationDO.class);
    if (list.isEmpty()) {
      dto =
          organizationServerClient.getEvaluateDepartments(
              evaluateTaskSpecialDO.getCityCode(), OrganizationTypeEnum.EVALUATE_AGENCY.getValue());
      if (!StatusCodeEnum.OK.getValue().equals(dto.getStatus())) {
        throw new ThrowsException("评估任务发送失败，该区域未查询到评估机构！");
      }
      list = JSONArray.parseArray(JSONArray.toJSONString(dto.getDatas()), OrganizationDO.class);
      if (list.isEmpty()) {
        throw new ThrowsException("评估任务发送失败，该区域未查询到评估机构！");
      }
    }
    int idx = evaluateTaskCode.hashCode() % list.size();
    OrganizationDO organizationDO = list.get(idx);
    evaluateAgencyCode = organizationDO.getAgencyCode();
    evaluateAgencyName = organizationDO.getAgencyName();

    //4.修改状态和评估机构信息
    EvaluateTaskDO evaluateTaskDO = new EvaluateTaskDO();
    evaluateTaskDO.setEvaluateTaskid(evaluateTaskSpecialDO.getEvaluateTaskid());
    evaluateTaskDO.setOperatedBy(operatedBy);
    evaluateTaskDO.setOperatedOrg(operatedOrg);
    evaluateTaskDO.setSendTime(date);
    evaluateTaskDO.setOperatedTime(date);

    evaluateTaskDO.setTaskState(EvaluateEnum.ALREADY_SEND.getValue());

    evaluateTaskDO.setEvaluateAgencyCode(evaluateAgencyCode);
    evaluateTaskDO.setEvaluateAgencyName(evaluateAgencyName);

    int size = updateEvaluateTask(evaluateTaskDO);
    if (size == 0) {
      return size;
    }
    //5.生成评估任务日志
    EvaluateTaskLogDO taskLogDO = new EvaluateTaskLogDO();

    taskLogDO.setEvaluateTaskLogid(UUID.randomUUID().toString().replaceAll("-", ""));
    taskLogDO.setEvaluateTaskCode(evaluateTaskSpecialDO.getEvaluateTaskCode());
    taskLogDO.setTaskState(EvaluateEnum.ALREADY_SEND.getValue());
    taskLogDO.setTaskDeadline(evaluateTaskSpecialDO.getTaskDeadline());
    taskLogDO.setEvaluateAgencyCode(evaluateAgencyCode);
    taskLogDO.setEvaluateAgencyName(evaluateAgencyName);
    taskLogDO.setSendTime(date);
    taskLogDO.setCreatedBy(operatedBy);
    taskLogDO.setCreatedTime(date);

    evaluateTaskLogDAO.insert(taskLogDO);

    logger.info("updateEvaluateTask：End" + DateFormatUtil.dateToTimeStr(new Date()));
    return size;
  }

  /**
   * 根据护理任务编号查询具体发送信息，拼接为Map发送
   *
   * @param nursingTaskCode
   * @return
   */
  private Map<String, Object> getMqDetailsMsg(
      EvaluateTaskSpecialDO evaluateTaskSpecialDO, String operatedBy, String operatedOrg) {
    Map<String, Object> map = new HashMap<>();

    map.put("address", evaluateTaskSpecialDO.getAddress());
    map.put("areaCode", evaluateTaskSpecialDO.getAreaCode());
    map.put("bidType", evaluateTaskSpecialDO.getBidType());
    map.put(
        "birthday", DateFormatUtil.dateToStr(evaluateTaskSpecialDO.getBirthday(), "yyyy-MM-dd"));
    //获取mongodb附件信息
    String strCaseHistoryScan = evaluateTaskSpecialDO.getCaseHistoryScan();
    map.put("caseHistoryScan", mediaFileUtils.scanIdStrToMapStr(strCaseHistoryScan));

    map.put("cityCode", evaluateTaskSpecialDO.getCityCode());
    map.put("deputyAddress", evaluateTaskSpecialDO.getDeputyAddress());
    map.put("deputyIdCard", evaluateTaskSpecialDO.getDeputyIdCard());
    map.put("deputyMobile", evaluateTaskSpecialDO.getDeputyMobile());
    map.put("deputyName", evaluateTaskSpecialDO.getDeputyName());

    map.put("disease", evaluateTaskSpecialDO.getDisease());
    map.put("educationid", evaluateTaskSpecialDO.getEducationid());
    map.put("evaluateAgencyCode", evaluateTaskSpecialDO.getEvaluateAgencyCode());
    map.put("evaluateAgencyName", evaluateTaskSpecialDO.getEvaluateAgencyName());
    map.put("evaluateTaskCode", evaluateTaskSpecialDO.getEvaluateTaskCode());

    map.put("idCard", evaluateTaskSpecialDO.getIdCard());
    map.put("insuredPersonGender", evaluateTaskSpecialDO.getInsuredPersonGender());
    map.put("insuredPersonName", evaluateTaskSpecialDO.getInsuredPersonName());
    map.put("isRelativeCared", evaluateTaskSpecialDO.getIsRelativeCared());
    map.put("isTaskDeadline", evaluateTaskSpecialDO.getIsTaskDeadline());

    map.put("married", evaluateTaskSpecialDO.getMarried());
    map.put("mobile", evaluateTaskSpecialDO.getMobile());
    map.put("nation", evaluateTaskSpecialDO.getNation());
    map.put("occupationid", evaluateTaskSpecialDO.getOccupationid());
    map.put("operatedBy", operatedBy);

    map.put("operatedOrg", operatedOrg);
    map.put("orgName", evaluateTaskSpecialDO.getOrgName());
    map.put("politicsid", evaluateTaskSpecialDO.getPoliticsid());
    map.put("provinceCode", evaluateTaskSpecialDO.getProvinceCode());
    map.put("securityNumber", evaluateTaskSpecialDO.getSecurityNumber());
    map.put("siArea", evaluateTaskSpecialDO.getSiArea());

    return map;
  }

  /** 修改发送状态 */
  @Override
  public int updateEvaluateTask(EvaluateTaskDO evaluateTaskDO) {
    EvaluateTaskDOExample doExample = new EvaluateTaskDOExample();
    Criteria criteria = doExample.createCriteria();
    criteria.andEvaluateTaskidEqualTo(evaluateTaskDO.getEvaluateTaskid());
    criteria.andTaskStateEqualTo(EvaluateEnum.NO_SEND.getValue());
    criteria.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());
    return evaluateTaskDAO.updateByExampleSelective(evaluateTaskDO, doExample);
  }

  /** 创建评估任务 */
  @Override
  public int createEvaluateTask(EvaluateTaskDO evaluateTaskDO) {
    EvaluateTaskDOExample doExample = new EvaluateTaskDOExample();
    Criteria criteria = doExample.createCriteria();
    criteria.andApplicationCodeEqualTo(evaluateTaskDO.getApplicationCode());
    criteria.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());
    List<EvaluateTaskDO> list = evaluateTaskDAO.selectByExample(doExample);
    if (!list.isEmpty()) {
      return 0;
    }
    //生成评估任务日志
    int result = evaluateTaskDAO.insertSelective(evaluateTaskDO);
    if (result > 0) {
      EvaluateTaskLogDO taskLogDO = new EvaluateTaskLogDO();

      taskLogDO.setEvaluateTaskLogid(UUID.randomUUID().toString().replaceAll("-", ""));
      taskLogDO.setEvaluateTaskCode(evaluateTaskDO.getEvaluateTaskCode());
      taskLogDO.setTaskState(EvaluateEnum.NO_SEND.getValue());
      taskLogDO.setTaskDeadline(String.valueOf(evaluateTaskDO.getTaskDeadline()));
      taskLogDO.setEvaluateAgencyCode(evaluateTaskDO.getEvaluateAgencyCode());
      taskLogDO.setEvaluateAgencyName(evaluateTaskDO.getEvaluateAgencyName());
      taskLogDO.setSendTime(evaluateTaskDO.getCreatedTime());
      taskLogDO.setCreatedBy(evaluateTaskDO.getCreatedBy());
      taskLogDO.setCreatedTime(evaluateTaskDO.getCreatedTime());

      evaluateTaskLogDAO.insert(taskLogDO);
    }
    return result;
  }

  /** 分页查询评估任务 */
  @Override
  public List<EvaluateTaskSpecialDO> queryEvaluateTaskList(
      String insuredPersonName,
      String mobile,
      String operatedTime,
      String taskState,
      String todoListCode,
      int page,
      int pageSize) {
    Map<String, Object> map = new HashMap<>();
    map.put("insuredPersonName", insuredPersonName);
    map.put("mobile", mobile);
    if (StringUtils.isNotBlank(taskState)) {
      String[] arr = taskState.split(",");
      map.put("taskState", arr);
    }
    if (null != operatedTime && !"".equals(operatedTime)) {
      map.put("operatedTimeStart", DateFormatUtil.getDayFirstTime(operatedTime));
      map.put("operatedTimeEnd", DateFormatUtil.getDayLastTime(operatedTime));
    }
    map.put("operatedOrg", ThreadLocalUtil.threadLocal.get().getOperatedOrg());
    map.put("pageStart", page * pageSize);
    map.put("pageSize", pageSize);
    map.put("orderDirectionStr", "desc");

    List<EvaluateTaskSpecialDO> evaluateTaskList =
        evaluateTaskSpecialDAO.queryEvaluateTaskList(map);
    //将evaluateTaskList里的待遇申请code取出，装成一个String串
    List<String> applicationCodeList = new ArrayList<>();
    if (!evaluateTaskList.isEmpty()) {
      for (int i = 0; i < evaluateTaskList.size(); i++) {
        applicationCodeList.add(evaluateTaskList.get(i).getApplicationCode());
      }
      String applicationCodes = JSONArray.toJSONString(applicationCodeList);
      logger.debug(applicationCodes);
      //向待遇申请微服务进行查询，将一些不全的数据补全
      ResultDTO applicationResult =
          insuredPersonServerClient.getApplicationSimple(applicationCodes);
      logger.debug(JSONArray.toJSONString(applicationResult));

      String applicationSimple = JSONObject.toJSONString(applicationResult.getDatas());
      logger.debug(applicationSimple);
      List<ApplicationSimpleDO> applicationSimpleDOs =
          JSONArray.parseArray(applicationSimple, ApplicationSimpleDO.class);

      for (ApplicationSimpleDO applicationSimpleDO : applicationSimpleDOs) {
        for (EvaluateTaskSpecialDO evaluateTask : evaluateTaskList) {
          if (applicationSimpleDO.getApplicationCode().equals(evaluateTask.getApplicationCode())) {
            evaluateTask.setAddress(applicationSimpleDO.getAddress());
          }
        }
      }
    }

    return evaluateTaskList;
  }

  /** 获取评估任务总记录 */
  @Override
  public Integer countEvaluateTaskDOList(
      String insuredPersonName, String mobile, String operatedTime, String taskState) {
    Map<String, Object> map = new HashMap<>();
    map.put("insuredPersonName", insuredPersonName);
    map.put("mobile", mobile);
    if (StringUtils.isNotBlank(taskState)) {
      String[] arr = taskState.split(",");
      map.put("taskState", arr);
    }
    if (null != operatedTime && !"".equals(operatedTime)) {
      map.put("operatedTimeStart", DateFormatUtil.getDayFirstTime(operatedTime));
      map.put("operatedTimeEnd", DateFormatUtil.getDayLastTime(operatedTime));
    }
    map.put("operatedOrg", ThreadLocalUtil.threadLocal.get().getOperatedOrg());
    return evaluateTaskSpecialDAO.countEvaluateTaskDOList(map);
  }

  @Override
  public EvaluateTaskSpecialDO getEvaluateTaskSpecialDOByCode(String evaluateTaskCode) {

    EvaluateTaskSpecialDO evaluateTaskDO =
        evaluateTaskSpecialDAO.getEvaluateTaskSpecialDOByCode(evaluateTaskCode);
    if (evaluateTaskDO == null) {
      throw new NotFoundByIdException("没有与评估任务编号" + evaluateTaskCode + "对应的评估任务信息！");
    }

    List<String> codeList = new ArrayList<>();
    codeList.add(evaluateTaskDO.getApplicationCode());
    ResultDTO resultDTO =
        insuredPersonServerClient.getApplicationComplex(JSONArray.toJSONString(codeList));
    if (resultDTO == null || !StatusCodeEnum.OK.getValue().equals(resultDTO.getStatus())) {
      throw new ThrowsException("调用待遇申请微服务查询待遇申请信息过程出错！");
    }
    List<ApplicationComplexDO> applicationComplexDOList =
        JSONArray.parseArray(
            JSONArray.toJSONString(resultDTO.getDatas()), ApplicationComplexDO.class);
    if (applicationComplexDOList == null || applicationComplexDOList.isEmpty()) {
      throw new NotFoundByIdException(
          "没有与待遇申请编号" + evaluateTaskDO.getApplicationCode() + "对应的待遇申请信息！");
    }
    ApplicationComplexDO complexDO = applicationComplexDOList.get(0);

    EvaluateTaskSpecialDO specialDO = new EvaluateTaskSpecialDO();
    //1
    specialDO.setAddress(complexDO.getAddress());
    specialDO.setApplicationCode(complexDO.getApplicationCode());
    specialDO.setAreaCode(complexDO.getAreaCode());
    specialDO.setBidType(complexDO.getBidType());
    specialDO.setBirthday(complexDO.getBirthday());
    //2
    specialDO.setCaseHistoryScan(complexDO.getCaseHistoryScan());
    specialDO.setCityCode(complexDO.getCityCode());
    specialDO.setCreatedBy(evaluateTaskDO.getCreatedBy());
    specialDO.setCreatedOrg(evaluateTaskDO.getCreatedOrg());
    specialDO.setCreatedTime(evaluateTaskDO.getCreatedTime());
    //3
    specialDO.setDeputyAddress(complexDO.getDeputyAddress());
    specialDO.setDeputyIdCard(complexDO.getDeputyIdCard());
    specialDO.setDeputyIdCardScan(complexDO.getDeputyIdCardScan());
    specialDO.setDeputyMobile(complexDO.getDeputyMobile());
    specialDO.setDeputyName(complexDO.getDeputyName());
    //4
    specialDO.setDisease(complexDO.getDisease());
    specialDO.setEducationid(complexDO.getEducationid());
    specialDO.setEvaluateAgencyCode(evaluateTaskDO.getEvaluateAgencyCode());
    specialDO.setEvaluateAgencyName(evaluateTaskDO.getEvaluateAgencyName());
    specialDO.setEvaluateCode(evaluateTaskDO.getEvaluateCode());
    //5
    specialDO.setEvaluateTaskCode(evaluateTaskCode);
    specialDO.setEvaluateTaskid(evaluateTaskDO.getEvaluateTaskid());
    specialDO.setIdCard(complexDO.getIdCard());
    specialDO.setIdCardScan(complexDO.getIdCardScan());
    specialDO.setInsuredPersonCode(complexDO.getInsuredPersonCode());
    //6
    specialDO.setInsuredPersonGender(complexDO.getInsuredPersonGender());
    specialDO.setInsuredPersonName(complexDO.getInsuredPersonName());
    specialDO.setIsReevaluate(evaluateTaskDO.getIsReevaluate());
    specialDO.setIsRelativeCared(complexDO.getIsRelativeCared());
    specialDO.setIsTaskDeadline(complexDO.getIsTaskDeadline());
    //7
    specialDO.setIsValid(Integer.toString(IsValidEnum.NO_DELETE.getValue()));
    specialDO.setMarried(complexDO.getMarried());
    specialDO.setMobile(complexDO.getMobile());
    specialDO.setNation(complexDO.getNation());
    specialDO.setOccupationid(complexDO.getOccupationid());
    //8
    specialDO.setOperatedBy(evaluateTaskDO.getOperatedBy());
    specialDO.setOperatedOrg(evaluateTaskDO.getOperatedOrg());
    specialDO.setOperatedTime(evaluateTaskDO.getOperatedTime());
    specialDO.setOrgName(complexDO.getOrgName());
    specialDO.setPoliticsid(complexDO.getPoliticsid());
    //9
    specialDO.setPrintState(evaluateTaskDO.getPrintState());
    specialDO.setProvinceCode(complexDO.getProvinceCode());
    specialDO.setReevaluateParentCode(evaluateTaskDO.getReevaluateParentCode());
    specialDO.setReevalueateResult(evaluateTaskDO.getReevalueateResult());
    specialDO.setRemark(evaluateTaskDO.getRemark());
    //10
    specialDO.setSecurityNumber(complexDO.getSecurityNumber());
    specialDO.setSecurityNumberScan(complexDO.getSecurityNumberScan());
    specialDO.setSendTime(evaluateTaskDO.getSendTime());
    specialDO.setSiArea(complexDO.getSiArea());
    specialDO.setTaskDeadline(evaluateTaskDO.getTaskDeadline());
    //11
    specialDO.setTaskState(evaluateTaskDO.getTaskState());

    specialDO.setFraction(evaluateTaskDO.getFraction());
    specialDO.setOpinion(evaluateTaskDO.getOpinion());

    return specialDO;
  }

  /** 判断是否产生提醒 */
  @Override
  public List<String> checkEvaluateTaskUrgent(
      int urgentConfig, String urgentDateTime, int notUrgentConfig, String notUrgentDateTime) {
    Map<String, Object> map = new HashMap<>();
    map.put("urgentConfig", IsTaskDeadline.TASKDEADLINE.getValue());
    map.put("urgentDateTime", urgentDateTime);
    map.put("notUrgentConfig", IsTaskDeadline.NO_TASKDEADLINE.getValue());
    map.put("notUrgentDateTime", notUrgentDateTime);
    map.put("isValid", IsValidEnum.NO_DELETE.getValue());
    map.put("taskState", EvaluateEnum.ALREADY_SEND.getValue());
    return evaluateTaskSpecialDAO.checkEvaluateTaskUrgent(map);
  }

  @Override
  public Map<String, Object> getExpertTaskList(
      String insuredPersonName,
      String idCard,
      String evaluateOrg,
      String operatedTime,
      String taskState,
      int page,
      int pageSize) {
    Map<String, Object> mapForSelect = new HashMap<>();
    mapForSelect.put("insuredPersonName", insuredPersonName);
    mapForSelect.put("idCard", idCard);
    mapForSelect.put("evaluateOrg", evaluateOrg);
    mapForSelect.put("taskState", taskState);
    mapForSelect.put("page", (page - 1) * pageSize);
    mapForSelect.put("pageSize", pageSize);
    if (null != operatedTime && !"".equals(operatedTime)) {
      mapForSelect.put("operatedTimeStart", DateFormatUtil.getDayFirstTime(operatedTime));
      mapForSelect.put("operatedTimeEnd", DateFormatUtil.getDayLastTime(operatedTime));
    }
    mapForSelect.put("operatedOrg", ThreadLocalUtil.threadLocal.get().getOperatedOrg());
    List<EvaluateTaskDeliveryDO> evaluateTaskDeliveryDOs =
        evaluateTaskSpecialDAO.getExpertTaskList(mapForSelect);
    for (EvaluateTaskDeliveryDO evaluateTaskDeliveryDO : evaluateTaskDeliveryDOs) {
      evaluateTaskDeliveryDO.setScore(evaluateTaskDeliveryDO.getScore().split("\\.")[0]);
    }
    //将expertEvaluateList里的待遇申请code取出，装成一个String串
    List<String> applicationCodeList = new ArrayList<>();
    if (!evaluateTaskDeliveryDOs.isEmpty()) {
      for (int i = 0; i < evaluateTaskDeliveryDOs.size(); i++) {
        applicationCodeList.add(evaluateTaskDeliveryDOs.get(i).getApplicationCode());
      }
      String applicationCodes = JSONArray.toJSONString(applicationCodeList);
      logger.debug(applicationCodes);
      //向待遇申请微服务进行查询，将一些不全的数据补全
      ResultDTO applicationResult =
          insuredPersonServerClient.getApplicationSimple(applicationCodes);
      logger.debug(JSONArray.toJSONString(applicationResult));

      String applicationSimple = JSONObject.toJSONString(applicationResult.getDatas());
      logger.debug(applicationSimple);
      List<ApplicationSimpleDO> applicationSimpleDOs =
          JSONArray.parseArray(applicationSimple, ApplicationSimpleDO.class);

      for (ApplicationSimpleDO applicationSimpleDO : applicationSimpleDOs) {
        for (EvaluateTaskDeliveryDO evaluateTaskDeliveryDO : evaluateTaskDeliveryDOs) {
          if (applicationSimpleDO
              .getApplicationCode()
              .equals(evaluateTaskDeliveryDO.getApplicationCode())) {
            evaluateTaskDeliveryDO.setAddress(applicationSimpleDO.getAddress());
          }
        }
      }
    }

    Integer count = evaluateTaskSpecialDAO.countExpertTaskList(mapForSelect);
    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    Map<String, Object> map = new HashMap<>();
    map.put("EvaluateTaskDeliveryDOs", evaluateTaskDeliveryDOs);
    map.put("page", page);
    map.put("pageSize", pageSize);
    map.put("count", count);
    map.put("totalPage", totalPage);
    logger.debug("====getFirstEvaluate返回的map【" + JsonUtils.makeJsonForObject(map) + "】==========");

    return map;
  }

  /** 批量修改评估任务状态 */
  @Override
  @Transactional
  public int batchUpdateEvaluateTaskStatusByEvaluateTaskCodes(
      String taskState,
      String operatedBy,
      String operatedOrg,
      Date operatedTime,
      String evaluateTaskCodes) {
    Map<String, Object> map = new HashMap<>();
    map.put("taskState", taskState);
    map.put("operatedBy", operatedBy);
    map.put("operatedOrg", operatedOrg);
    map.put("operatedTime", operatedTime);
    List<String> array = Lists.newArrayList();
    if (evaluateTaskCodes != null) {
      String[] strs = evaluateTaskCodes.split(",");
      for (String evaluateTaskCode : strs) {
        EvaluateTaskDOExample doExample = new EvaluateTaskDOExample();
        Criteria criteria = doExample.createCriteria();
        criteria.andEvaluateTaskCodeEqualTo(evaluateTaskCode);
        criteria.andTaskStateEqualTo(EvaluateEnum.NO_DELIVERY.getValue());
        List<EvaluateTaskDO> list = evaluateTaskDAO.selectByExample(doExample);
        if (list.isEmpty()) {
          return -1;
        } else {
          array.add(evaluateTaskCode);
        }
      }
      map.put("array", array);
    }
    int result = evaluateTaskSpecialDAO.batchUpdateEvaluateTaskStatusByEvaluateTaskCodes(map);
    logger.debug(
        "====batchUpdateEvaluateTaskStatusByEvaluateTaskCodes修改的评估任务状态的map【"
            + JsonUtils.makeJsonForObject(map)
            + "】==========");

    if (result > 0) {
      for (String arr : array) {
        EvaluateTaskLogDO taskLogDO = new EvaluateTaskLogDO();
        EvaluateTaskSpecialDO evaluateTaskDO =
            evaluateTaskSpecialDAO.getEvaluateTaskSpecialDOByCode(arr);
        taskLogDO.setEvaluateTaskLogid(UUID.randomUUID().toString().replaceAll("-", ""));
        taskLogDO.setEvaluateTaskCode(evaluateTaskDO.getEvaluateTaskCode());
        taskLogDO.setTaskState(EvaluateEnum.ALREADY_DELIVERY.getValue());
        taskLogDO.setTaskDeadline(evaluateTaskDO.getTaskDeadline() + "");
        taskLogDO.setEvaluateAgencyCode(evaluateTaskDO.getEvaluateAgencyCode());
        taskLogDO.setEvaluateAgencyName(evaluateTaskDO.getEvaluateAgencyName());
        taskLogDO.setSendTime(evaluateTaskDO.getCreatedTime());
        taskLogDO.setCreatedBy(operatedBy);
        taskLogDO.setCreatedTime(evaluateTaskDO.getCreatedTime());

        evaluateTaskLogDAO.insert(taskLogDO);
      }
      //新增护理对象任务
      result = nursingTaskListAdd(operatedBy, operatedOrg, evaluateTaskCodes);
    }
    return result;
  }

  /**
   * 新增护理对象任务
   *
   * @param operatedBy
   * @param operatedOrg
   * @param evaluateTaskCodes
   */
  public int nursingTaskListAdd(String operatedBy, String operatedOrg, String evaluateTaskCodes) {
    int result = 0;
    if (evaluateTaskCodes != null) {
      String[] evaluateTaskCodeStrs = evaluateTaskCodes.split(",");
      List<NursingTaskDO> nursingTaskDOs = Lists.newArrayList();
      for (String evaluateTaskCode : evaluateTaskCodeStrs) {

        EvaluateTaskSpecialDO evaluateTaskSpecialDO =
            evaluateTaskSpecialDAO.getEvaluateTaskSpecialDOByCode(evaluateTaskCode);
        logger.debug("evaluateTaskSpecialDO:" + JSONObject.toJSONString(evaluateTaskSpecialDO));
        NursingTaskDO nursingTaskDO = new NursingTaskDO();

        try {
          List<String> applicationCodeList = Lists.newArrayList();
          applicationCodeList.add(evaluateTaskSpecialDO.getApplicationCode());
          String applicationCodes = JSONArray.toJSONString(applicationCodeList);
          ResultDTO applicationResult =
              insuredPersonServerClient.getApplicationComplex(applicationCodes);
          String applicationSimple = JSONObject.toJSONString(applicationResult.getDatas());
          logger.debug(applicationSimple);
          List<ApplicationComplexDO> applicationSimpleDOs =
              JSONArray.parseArray(applicationSimple, ApplicationComplexDO.class);
          if (!applicationSimpleDOs.isEmpty()) {
            nursingTaskDO.setApplyType(applicationSimpleDOs.get(0).getBidType());
          }
        } catch (Exception e) {
          logger.error(
              "EvaluateTaskServiceImpl batchTreatmentApplicationCase nursingTaskListAdd 评估任务批量送达后，"
                  + evaluateTaskSpecialDO.getApplicationCode()
                  + ",查询待遇申请信息失败："
                  + e);
          throw new ThrowsException("评估结果送达后，查询待遇申请信息出错！");
        }

        nursingTaskDO.setCreatedBy(operatedBy);
        nursingTaskDO.setCreatedOrg(operatedOrg);

        nursingTaskDO.setEvaluateTaskCode(evaluateTaskSpecialDO.getEvaluateTaskCode());
        nursingTaskDO.setNursingTaskid(UUID.randomUUID().toString().replaceAll("-", ""));
        nursingTaskDO.setInsuredPersonCode(evaluateTaskSpecialDO.getInsuredPersonCode());
        nursingTaskDO.setIsRelativeCared(evaluateTaskSpecialDO.getIsReevaluate());
        nursingTaskDO.setNursingTaskCode(UUID.randomUUID().toString().replaceAll("-", ""));
        nursingTaskDO.setState(NursingTaskEnum.NO_INTENT_AGENCY.getValue());
        nursingTaskDO.setSiArea(evaluateTaskSpecialDO.getSiArea());

        nursingTaskDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
        nursingTaskDO.setCreatedTime(new Date());
        if (nursingTaskService.getNursingTaskByEvaluateTaskCode(evaluateTaskCode)) {
          nursingTaskDOs.add(nursingTaskDO);
        }
      }
      try {
        logger.debug(
            "====batchUpdateEvaluateTaskStatusByEvaluateTaskCodes新增的护理对象任务的map【"
                + JsonUtils.makeJsonForObject(nursingTaskDOs)
                + "】==========");
        result = nursingTaskService.insertNursingTaskList(nursingTaskDOs);
      } catch (Exception e) {
        logger.error(
            "EvaluateTaskServiceImpl batchTreatmentApplicationCase nursingTaskListAdd 评估任务批量送达后，批量创建护理任务失败："
                + e);
        throw new ThrowsException("评估结果送达后，新增护理任务出错！");
      }
    }
    return result;
  }

  /** 评估任务重评方法 */
  @Override
  public ResultDTO reviewEvaluateTask(
      String evaluateTaskCode, String reevalueateResult, String operatedBy, String operatedOrg) {
    EvaluateTaskDO evaluateTaskDO = new EvaluateTaskDO();
    //设置经办人，经办时间和经办机构
    evaluateTaskDO.setOperatedBy(operatedBy);
    evaluateTaskDO.setOperatedOrg(operatedOrg);
    evaluateTaskDO.setOperatedTime(new Date());

    //重评是否通过
    evaluateTaskDO.setReevalueateResult(reevalueateResult);
    //是否重评，修改为重评
    evaluateTaskDO.setIsReevaluate(IsReevaluateEnum.ALREADY_REEVALUATE.getValue());

    EvaluateTaskDOExample doExample = new EvaluateTaskDOExample();
    Criteria criteria = doExample.createCriteria();
    criteria.andEvaluateTaskCodeEqualTo(evaluateTaskCode);
    criteria.andIsReevaluateEqualTo(IsReevaluateEnum.NO_REEVALUATE.getValue());
    int size = evaluateTaskDAO.updateByExampleSelective(evaluateTaskDO, doExample);
    if (size == 0) {
      throw new ThrowsException("记录已被他人操作，请刷新界面，重新选择数据！");
    }
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.CREATED.getValue());
    resultDTO.setMessage("重评成功！");
    return resultDTO;
  }

  @Override
  public EvaluateTaskDeliveryDO getEvaluateTaskSpecialStateByCode(String evaluateTaskCode) {
    //先到evaluateTask表中查询任务状态
    //    String taskState =
    //        evaluateTaskSpecialDAO.getTaskStateByIdCardOrEvaluateTaskCode("", evaluateTaskCode);
    //    logger.debug("===评估任务状态【" + taskState + "】===========");

    EvaluateTaskDeliveryDO evaluateTaskDeliveryDO =
        evaluateTaskSpecialDAO.getEvaluateTaskSpecialStateByCode(evaluateTaskCode);
    if (null == evaluateTaskDeliveryDO) {
      throw new NotFoundByIdException("未查询出信息！");
    }
    if (evaluateTaskDeliveryDO.getOperatedTime() != null) {
      String operatedTime =
          evaluateTaskDeliveryDO
              .getOperatedTime()
              .substring(0, evaluateTaskDeliveryDO.getOperatedTime().length() - 2);
      evaluateTaskDeliveryDO.setOperatedTime(operatedTime);

      String idCard =
          evaluateTaskDeliveryDO.getIdCard() != null ? evaluateTaskDeliveryDO.getIdCard() : "";
      String insuredPersonName =
          evaluateTaskDeliveryDO.getInsuredPersonName() != null
              ? evaluateTaskDeliveryDO.getInsuredPersonName()
              : "";
      String securityNumber =
          evaluateTaskDeliveryDO.getSecurityNumber() != null
              ? evaluateTaskDeliveryDO.getSecurityNumber()
              : "";
      String score =
          evaluateTaskDeliveryDO.getScore() != null ? evaluateTaskDeliveryDO.getScore() : "";
      String suggestion =
          evaluateTaskDeliveryDO.getSuggestion() != null
              ? evaluateTaskDeliveryDO.getSuggestion()
              : "";
      String fraction =
          evaluateTaskDeliveryDO.getFraction() != null ? evaluateTaskDeliveryDO.getFraction() : "";
      String opinion =
          evaluateTaskDeliveryDO.getOpinion() != null ? evaluateTaskDeliveryDO.getOpinion() : "";
      String isReevaluate =
          evaluateTaskDeliveryDO.getIsReevaluate() != null
              ? evaluateTaskDeliveryDO.getIsReevaluate()
              : "";
      String reevalueateResult =
          evaluateTaskDeliveryDO.getReevalueateResult() != null
              ? evaluateTaskDeliveryDO.getReevalueateResult()
              : "";

      evaluateTaskDeliveryDO.setIdCard(idCard);
      evaluateTaskDeliveryDO.setInsuredPersonName(insuredPersonName);
      evaluateTaskDeliveryDO.setSecurityNumber(securityNumber);
      evaluateTaskDeliveryDO.setScore(score);
      evaluateTaskDeliveryDO.setSuggestion(suggestion);
      evaluateTaskDeliveryDO.setFraction(fraction);
      evaluateTaskDeliveryDO.setOpinion(opinion);
      evaluateTaskDeliveryDO.setIsReevaluate(isReevaluate);
      evaluateTaskDeliveryDO.setReevalueateResult(reevalueateResult);
    }

    //将expertEvaluateList里的待遇申请code取出，装成一个String串
    List<String> applicationCodeList = new ArrayList<>();
    applicationCodeList.add(evaluateTaskDeliveryDO.getApplicationCode());
    String applicationCodes = JSONArray.toJSONString(applicationCodeList);
    logger.debug(applicationCodes);
    //向待遇申请微服务进行查询，将一些不全的数据补全
    ResultDTO applicationResult = insuredPersonServerClient.getApplicationSimple(applicationCodes);
    logger.debug(JSONArray.toJSONString(applicationResult));

    String applicationSimple = JSONObject.toJSONString(applicationResult.getDatas());
    logger.debug(applicationSimple);
    List<ApplicationSimpleDO> applicationSimpleDOs =
        JSONArray.parseArray(applicationSimple, ApplicationSimpleDO.class);

    for (ApplicationSimpleDO applicationSimpleDO : applicationSimpleDOs) {
      if (applicationSimpleDO
          .getApplicationCode()
          .equals(evaluateTaskDeliveryDO.getApplicationCode())) {
        evaluateTaskDeliveryDO.setSecurityNumber(applicationSimpleDO.getSecurityNumber());
      }
    }

    return evaluateTaskDeliveryDO;
  }

  @Override
  public Map<String, Object> getEvaluateTaskByIdCard(String idCard) {
    //    EvaluateTaskDeliveryDO evaluateTaskDeliveryDO =
    //        evaluateTaskSpecialDAO.getInsPersonByIdCard(idCard);
    ResultDTO resultDTO = insuredPersonServerClient.getInsuredPersonDetail("", idCard, "");
    InsuredPersonDO insuredPersonDO =
        JSONObject.parseObject(
            JSONObject.toJSONString(resultDTO.getDatas()), InsuredPersonDO.class);
    if (insuredPersonDO == null) {
      throw new NotFoundByIdException("未查询出信息！");
    }

    //先到evaluateTask表中查询任务状态
    //    String taskState = evaluateTaskSpecialDAO.getTaskStateByIdCardOrEvaluateTaskCode(idCard, "");
    //    logger.debug("===评估任务状态【" + taskState + "】===========");

    List<EvaluateTaskDeliveryDO> evaluateTaskDeliveryDOs =
        evaluateTaskSpecialDAO.getEvaluateTaskByIdCard(idCard);
    for (EvaluateTaskDeliveryDO evaluateTaskDeliveryDO2 : evaluateTaskDeliveryDOs) {
      String opreatedTime = evaluateTaskDeliveryDO2.getOperatedTime();
      evaluateTaskDeliveryDO2.setOperatedTime(opreatedTime.substring(0, opreatedTime.length() - 2));
      String score =
          evaluateTaskDeliveryDO2.getScore() != null ? evaluateTaskDeliveryDO2.getScore() : "";
      String suggestion =
          evaluateTaskDeliveryDO2.getSuggestion() != null
              ? evaluateTaskDeliveryDO2.getSuggestion()
              : "";
      String fraction =
          evaluateTaskDeliveryDO2.getFraction() != null
              ? evaluateTaskDeliveryDO2.getFraction()
              : "";
      String opinion =
          evaluateTaskDeliveryDO2.getOpinion() != null ? evaluateTaskDeliveryDO2.getOpinion() : "";
      String isReevaluate =
          evaluateTaskDeliveryDO2.getIsReevaluate() != null
              ? evaluateTaskDeliveryDO2.getIsReevaluate()
              : "";
      String reevalueateResult =
          evaluateTaskDeliveryDO2.getReevalueateResult() != null
              ? evaluateTaskDeliveryDO2.getReevalueateResult()
              : "";

      evaluateTaskDeliveryDO2.setScore(score);
      evaluateTaskDeliveryDO2.setSuggestion(suggestion);
      evaluateTaskDeliveryDO2.setFraction(fraction);
      evaluateTaskDeliveryDO2.setOpinion(opinion);
      evaluateTaskDeliveryDO2.setIsReevaluate(isReevaluate);
      evaluateTaskDeliveryDO2.setReevalueateResult(reevalueateResult);
    }

    Map<String, Object> map = new HashMap<>();
    map.put("idCard", idCard);
    map.put("insuredPersonName", insuredPersonDO.getInsuredPersonName());
    map.put("securityNumber", insuredPersonDO.getSecurityNumber());
    map.put("evaluateList", evaluateTaskDeliveryDOs);
    logger.debug("====map【" + JSONObject.toJSONString(map) + "】=====");

    return map;
  }

  @Override
  public String getMongoDBMessage(String id) {
    ResultDTO resultDTO =
        attachmentServiceClient.getAttachmentByID(id, FileTypeEnum.PICTURE.getValue());
    if (resultDTO == null || !StatusCodeEnum.OK.getValue().equals(resultDTO.getStatus())) {
      throw new NotFoundByIdException(
          "根据id:" + id + " 和fileType:" + FileTypeEnum.PICTURE.getValue() + " 查询媒体文件微服务出错！");
    }
    AttachmentDTO dto =
        JSONObject.parseObject(JSONObject.toJSONString(resultDTO.getDatas()), AttachmentDTO.class);
    return dto.getContent();
  }

  /** 查询评估发送成功，但是超期之后未返回结果的数据 */
  @Override
  public List<EvaluateTaskSpecialDO> getToDoListEvaluateTaskList() {

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

    String urgentDateTime = getFormatDateBySubtraction(urgentConfig);
    String notUrgentDateTime = getFormatDateBySubtraction(notUrgentConfig);
    String operatedOrg = ThreadLocalUtil.threadLocal.get().getOperatedOrg();

    Map<String, Object> map = new HashMap<>();
    map.put("urgentConfig", IsTaskDeadline.TASKDEADLINE.getValue());
    map.put("urgentDateTime", urgentDateTime);
    map.put("notUrgentConfig", IsTaskDeadline.NO_TASKDEADLINE.getValue());
    map.put("notUrgentDateTime", notUrgentDateTime);
    map.put("isValid", IsValidEnum.NO_DELETE.getValue());
    map.put("taskState", EvaluateEnum.ALREADY_SEND.getValue());
    //从中间层获取权限机构
    map.put("operatedOrg", operatedOrg);

    TodoListDTO todoListDTO = new TodoListDTO();
    todoListDTO.setBusinessCode(ToDoListEnum.ASSESSMENT_TASK_SEND.getValue());
    todoListDTO.setBusinessType(ToDoListEnum.ASSESSMENT_TASK_SEND.getValue());
    todoListDTO.setCreatedOrg(operatedOrg);
    try {
      todoListServerClient.deleteTodoList(todoListDTO);
    } catch (Exception e) {
      logger.error("queryEvaluateTaskList:查询评估任务列表,逻辑删除待办任务失败。======= message:" + e);
    }

    List<EvaluateTaskSpecialDO> evaluateTaskList =
        evaluateTaskSpecialDAO.getToDoListEvaluateTaskList(map);
    //将evaluateTaskList里的待遇申请code取出，装成一个String串
    List<String> applicationCodeList = new ArrayList<>();
    if (!evaluateTaskList.isEmpty()) {
      for (int i = 0; i < evaluateTaskList.size(); i++) {
        applicationCodeList.add(evaluateTaskList.get(i).getApplicationCode());
      }
      String applicationCodes = JSONArray.toJSONString(applicationCodeList);
      logger.debug(applicationCodes);
      //向待遇申请微服务进行查询，将一些不全的数据补全
      ResultDTO applicationResult =
          insuredPersonServerClient.getApplicationSimple(applicationCodes);
      logger.debug(JSONArray.toJSONString(applicationResult));

      String applicationSimple = JSONObject.toJSONString(applicationResult.getDatas());
      logger.debug(applicationSimple);
      List<ApplicationSimpleDO> applicationSimpleDOs =
          JSONArray.parseArray(applicationSimple, ApplicationSimpleDO.class);

      for (ApplicationSimpleDO applicationSimpleDO : applicationSimpleDOs) {
        for (EvaluateTaskSpecialDO evaluateTask : evaluateTaskList) {
          if (applicationSimpleDO.getApplicationCode().equals(evaluateTask.getApplicationCode())) {
            evaluateTask.setAddress(applicationSimpleDO.getAddress());
          }
        }
      }
    }

    return evaluateTaskList;
  }

  /**
   * 判断是否紧急的时候减去配置时间
   *
   * @param day
   * @return
   */
  private String getFormatDateBySubtraction(int day) {
    Calendar urgentCalendar = Calendar.getInstance();
    urgentCalendar.add(Calendar.DAY_OF_MONTH, -1 * day);
    return DateFormatUtil.dateToStr(
        urgentCalendar.getTime(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
  }
}
