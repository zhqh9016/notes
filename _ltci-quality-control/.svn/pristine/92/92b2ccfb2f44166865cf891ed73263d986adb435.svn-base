package com.taikang.dic.ltci.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.AttachmentDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.ExecutionStatusEnum;
import com.taikang.dic.ltci.common.enumeration.IsValidEnum;
import com.taikang.dic.ltci.common.enumeration.MqTypeEnum;
import com.taikang.dic.ltci.common.enumeration.OperationTypeEnum;
import com.taikang.dic.ltci.common.enumeration.PatrolObjectTypeEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.enumeration.TaskCategoryEnum;
import com.taikang.dic.ltci.common.enumeration.TaskLevelEnum;
import com.taikang.dic.ltci.common.enumeration.TaskStateEnum;
import com.taikang.dic.ltci.common.enumeration.TransportTypeEnum;
import com.taikang.dic.ltci.common.exception.InsertRepeatException;
import com.taikang.dic.ltci.common.exception.NotFoundByIdException;
import com.taikang.dic.ltci.common.exception.ThrowsException;
import com.taikang.dic.ltci.common.log.ThreadLocalUtil;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.common.util.FileTypeDecideUtil;
import com.taikang.dic.ltci.common.util.JsonUtils;
import com.taikang.dic.ltci.common.util.SpringContextUtil;
import com.taikang.dic.ltci.common.util.UrlUtil;
import com.taikang.dic.ltci.controller.PatrolTaskController;
import com.taikang.dic.ltci.dao.ComplaintResourceDAO;
import com.taikang.dic.ltci.dao.IExecuteResultDAO;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.IMqFailMessageLogDAO;
import com.taikang.dic.ltci.dao.IPatrolTaskDAO;
import com.taikang.dic.ltci.dao.IPatrolTaskDetailDAO;
import com.taikang.dic.ltci.dao.MqMessageLogDAO;
import com.taikang.dic.ltci.dao.PatrolTaskAllotDetailSpecialDAO;
import com.taikang.dic.ltci.dao.PatrolTaskLogDAO;
import com.taikang.dic.ltci.dao.PatrolTaskSpecialDAO;
import com.taikang.dic.ltci.model.AgencyDO;
import com.taikang.dic.ltci.model.ComplaintResourceDO;
import com.taikang.dic.ltci.model.ComplaintResourceDOExample;
import com.taikang.dic.ltci.model.ExecuteResultDO;
import com.taikang.dic.ltci.model.ExecuteResultDOExample;
import com.taikang.dic.ltci.model.InsuredPersonDO;
import com.taikang.dic.ltci.model.MobileCompliainDO;
import com.taikang.dic.ltci.model.MqFailMessageLogDO;
import com.taikang.dic.ltci.model.MqMessageLogDO;
import com.taikang.dic.ltci.model.MqMessageLogDOExample;
import com.taikang.dic.ltci.model.MqMessageLogDOExample.Criteria;
import com.taikang.dic.ltci.model.PatrolTaskAddDO;
import com.taikang.dic.ltci.model.PatrolTaskAllotDetailSpecialDO;
import com.taikang.dic.ltci.model.PatrolTaskDO;
import com.taikang.dic.ltci.model.PatrolTaskDOExample;
import com.taikang.dic.ltci.model.PatrolTaskDetailDO;
import com.taikang.dic.ltci.model.PatrolTaskDetailDOExample;
import com.taikang.dic.ltci.model.PatrolTaskDetailItemDO;
import com.taikang.dic.ltci.model.PatrolTaskDetailSpecialDO;
import com.taikang.dic.ltci.model.PatrolTaskLogDO;
import com.taikang.dic.ltci.model.PatrolTaskNurseDetailItemDO;
import com.taikang.dic.ltci.model.PatrolTaskSpecialDO;
import com.taikang.dic.ltci.model.StaffSpecialDO;
import com.taikang.dic.ltci.model.ViolationItemDO;
import com.taikang.dic.ltci.mqmodel.MqBaseModel;
import com.taikang.dic.ltci.serverClient.AgencyPersonClient;
import com.taikang.dic.ltci.serverClient.AttachmentServiceClient;
import com.taikang.dic.ltci.serverClient.InsuredPersonServerClient;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.IMqFailMessageLogService;
import com.taikang.dic.ltci.service.PatrolTaskSenderService;
import com.taikang.dic.ltci.service.PatrolTaskService;

@Service
@Component
public class PatrolTaskServiceImpl extends AbstractGenericService<PatrolTaskDO, String>
    implements PatrolTaskService {
  private Logger logger = LoggerFactory.getLogger(PatrolTaskServiceImpl.class);
  @Autowired private PatrolTaskSpecialDAO patrolTaskSpecialDAO;
  @Autowired private IPatrolTaskDAO patrolTaskDAO;
  @Autowired private MqMessageLogDAO mqMessageLogDAO;
  @Autowired private IPatrolTaskDetailDAO patrolTaskDetailDAO;
  @Autowired private IPatrolTaskDetailDAO iPatrolTaskDetailDAO;
  @Autowired private PatrolTaskLogDAO patrolTaskLogDAO;
  @Autowired private AttachmentServiceClient attachmentServiceClient;
  @Autowired private ComplaintResourceDAO complaintResourceDAO;
  @Autowired private IMqFailMessageLogService failMessageLogService;
  @Autowired private IMqFailMessageLogDAO failMessageLogDAO;
  @Autowired private UrlUtil urlUtil;
  @Autowired private IExecuteResultDAO iExecuteResultDAO;
  @Autowired private SpringContextUtil springContextUtil;
  @Autowired private PatrolTaskSenderService patrolTaskSenderService;
  @Autowired private PatrolTaskAllotDetailSpecialDAO patrolTaskAllotDetailSpecialDAO;
  @Autowired private AgencyPersonClient agencyPersonClient;
  @Autowired private InsuredPersonServerClient insuredPersonServerClient;

  @Value(value = "${ltci.mobileCompliain.queue}")
  private String mobileCompliain;

  @Value("${restBasePath}")
  private String restBasePath;

  @Override
  public Map<String, Object> listPatrolTask(
      PatrolTaskSpecialDO patrolTaskSpecialDO, int page, int pageSize) {

    Map<String, Object> mapForSelect = new HashMap<>();
    String patrolObjectName = patrolTaskSpecialDO.getPatrolObjectName();
    String patrolObjectType = patrolTaskSpecialDO.getPatrolObjectType();
    String patrolObjectId = patrolTaskSpecialDO.getPatrolObjectId();
    String patrolObjectPhone = patrolTaskSpecialDO.getPatrolObjectPhone();
    String operatedTime = patrolTaskSpecialDO.getOperatedTime();
    String taskState = patrolTaskSpecialDO.getTaskState();
    String patrolStaffName = patrolTaskSpecialDO.getPatrolStaffName();
    String taskLevel = patrolTaskSpecialDO.getTaskLevel();

    //将类别进行处理
    //    if (patrolObjectType.indexOf(",") == -1) {
    //      patrolObjectType = "'" + patrolObjectType + "'";
    //    } else {
    //      patrolObjectType = "'" + patrolObjectType.replaceAll(",", "','") + "'";
    //    }
    if (StringUtils.isNotBlank(patrolObjectType)) {
      String[] arr = patrolObjectType.split(",");
      mapForSelect.put("patrolObjectType", arr);
    }
    //将任务状态进行处理
    //    if (taskState.indexOf(",") == -1) {
    //      taskState = "'" + taskState + "'";
    //    } else {
    //      taskState = "'" + taskState.replaceAll(",", "','") + "'";
    //    }
    if (StringUtils.isNotBlank(taskState)) {
      String[] arr = taskState.split(",");
      mapForSelect.put("taskState", arr);
    }
    //将任务级别进行处理
    //    if (taskLevel.indexOf(",") == -1) {
    //      taskLevel = "'" + taskLevel + "'";
    //    } else {
    //      taskLevel = "'" + taskLevel.replaceAll(",", "','") + "'";
    //    }
    if (StringUtils.isNotBlank(taskLevel)) {
      String[] arr = taskLevel.split(",");
      mapForSelect.put("taskLevel", arr);
    }
    //对时间进行处理
    if (null != operatedTime && !"".equals(operatedTime)) {
      mapForSelect.put("operatedTimeStart", Timestamp.valueOf(operatedTime.concat(" 00:00:00")));
      mapForSelect.put("operatedTimeEnd", Timestamp.valueOf(operatedTime.concat(" 23:59:59")));
    }
    mapForSelect.put("patrolObjectName", patrolObjectName);
    //    mapForSelect.put("patrolObjectType", patrolObjectType);
    mapForSelect.put("patrolObjectId", patrolObjectId);
    mapForSelect.put("patrolObjectPhone", patrolObjectPhone);
    //    mapForSelect.put("taskState", taskState);
    mapForSelect.put("patrolStaffName", patrolStaffName);
    //    mapForSelect.put("taskLevel", taskLevel);
    mapForSelect.put("operatedOrg", ThreadLocalUtil.threadLocal.get().getOperatedOrg());
    mapForSelect.put("page", (page - 1) * pageSize);
    mapForSelect.put("pageSize", pageSize);

    abLogger.debug(
        "=======查询的条件为mapForSelect【" + JSONObject.toJSONString(mapForSelect) + "】========");

    List<PatrolTaskSpecialDO> patrolTaskSpecialDOs =
        patrolTaskSpecialDAO.listPatrolTask(mapForSelect);
    for (PatrolTaskSpecialDO patrolTaskSpecialDO2 : patrolTaskSpecialDOs) {
      ExecuteResultDOExample doExample = new ExecuteResultDOExample();
      com.taikang.dic.ltci.model.ExecuteResultDOExample.Criteria criteria =
          doExample.createCriteria();
      criteria.andPatrolTaskIdEqualTo(patrolTaskSpecialDO2.getPatrolTaskId());

      List<ExecuteResultDO> executeResultDOList = iExecuteResultDAO.selectByExample(doExample);
      if (!executeResultDOList.isEmpty()) {
        patrolTaskSpecialDO2.setRejectionReason(executeResultDOList.get(0).getRejectionReason());
      } else {
        patrolTaskSpecialDO2.setRejectionReason("");
      }
    }
    Integer count = patrolTaskSpecialDAO.countPatrolTaskList(mapForSelect);
    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;

    Map<String, Object> map = new HashMap<>();
    map.put("patrolTaskSpecialDOs", patrolTaskSpecialDOs);
    map.put("page", page);
    map.put("pageSize", pageSize);
    map.put("count", count);
    map.put("totalPage", totalPage);
    abLogger.debug(
        "====getFirstEvaluate返回的map【" + JsonUtils.makeJsonForObject(map) + "】==========");

    return map;
  }

  /**
   * 监听移动端投诉信息接口
   *
   * @param bytes
   */
  @RabbitListener(queues = "${ltci.mobileCompliain.queue}")
  public void getMobileCompliain(byte[] bytes) {
    String message = "";
    MqBaseModel mqBaseModel = null;
    try {
      //1.按照UTF-8转化byte[]
      message = new String(bytes, systemCharset);
      abLogger.info("------" + message + "------");
      mqBaseModel = JSONObject.parseObject(message, MqBaseModel.class);

      //2.判断监听数据是否重复
      MqMessageLogDOExample doExample = new MqMessageLogDOExample();
      Criteria criteria = doExample.createCriteria();
      criteria.andTypeEqualTo(MqTypeEnum.RECEIVE.getValue());
      if (StringUtils.isNotBlank(mqBaseModel.getBusinessSerialid())) {
        mqBaseModel.setBusinessSerialid(mqBaseModel.getBusinessSerialid().replaceAll("-", ""));
      }
      criteria.andIdEqualTo(mqBaseModel.getBusinessSerialid());

      List<MqMessageLogDO> mqMessageLogDOs = mqMessageLogDAO.selectByExample(doExample);
      if (!mqMessageLogDOs.isEmpty()) {
        abLogger.debug("======此id【" + mqBaseModel.getBusinessSerialid() + "】信息已经监听处理=============");
        return;
      }
      //在这个方法中做事务处理
      PatrolTaskServiceImpl bean =
          springContextUtil.getApplicationContext().getBean(PatrolTaskServiceImpl.class);
      bean.insertMqMessageLog(message);
    } catch (Exception e) {
      abLogger.error("监听移动端投诉接口异常：", e);
      if (mqBaseModel != null && StringUtils.isNotBlank(mqBaseModel.getBusinessSerialid())) {
        MqFailMessageLogDO failLog = new MqFailMessageLogDO();
        failLog.setId(mqBaseModel.getBusinessSerialid().replaceAll("-", ""));
        failLog.setTransportType(TransportTypeEnum.ASYNCHRONIZE.getValue()); //交互方式：异步
        failLog.setOperationType(OperationTypeEnum.RECEIVE.getValue()); //发送接收类型
        failLog.setQueryName(mobileCompliain);
        failLog.setContent(message);
        failLog.setErrorMessage(e.getMessage());
        failLog.setCreateTime(new Date());
        failLog.setHttpAction(HttpMethod.POST.name());
        // 添加重试url
        failLog.setRetryUrl(urlUtil.getBaseUrl() + PatrolTaskController.RETRY_URL);
        failMessageLogService.saveOrUpdateFailLog(failLog);
      }
    }
  }
  /**
   * 3.新增MQ日志信息表 4.添加巡查任务信息表 5.添加巡查任务日志表 6.添加任务明细表 7.添加资源信息表
   *
   * @param mqBaseModel
   */
  @Override
  @Transactional
  public ResultDTO insertMqMessageLog(String message) {
    MqBaseModel mqBaseModel = JSONObject.parseObject(message, MqBaseModel.class);

    MobileCompliainDO mobileCompliainDO = null;
    try {
      mobileCompliainDO =
          JSONObject.parseObject(
              JSONObject.toJSONString(mqBaseModel.getData()), MobileCompliainDO.class);
    } catch (Exception e) {
      abLogger.error("监听移动端投诉信息数据格式转换错误：", e);
      throw new ThrowsException("监听移动端投诉信息数据转换错误");
    }

    MqMessageLogDO mqMessageLogDO = new MqMessageLogDO();
    mqMessageLogDO.setId(mqBaseModel.getBusinessSerialid().replaceAll("-", ""));
    mqMessageLogDO.setType(MqTypeEnum.RECEIVE.getValue());
    mqMessageLogDO.setSendContent("");
    //发送状态暂时写1
    mqMessageLogDO.setSendState("1");
    mqMessageLogDO.setCreateTime(new Date());
    mqMessageLogDO.setQueueName(mobileCompliain);
    mqMessageLogDAO.insert(mqMessageLogDO);
    abLogger.info("mobileCompliainDO:【" + mobileCompliainDO + "】");
    //4.添加巡查任务,5.添加巡查任务日志表,6.添加任务明细表,7.添加资源信息表
    insertPatrolTask(mobileCompliainDO);
    //8.删除错误表数据
    failMessageLogDAO.deleteByPrimaryKey(mqBaseModel.getBusinessSerialid().replaceAll("-", ""));

    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(ExecutionStatusEnum.SUCCESS.getValue());
    return resultDTO;
  }

  /**
   * @param mobileCompliainDO
   * @return
   */
  private void insertPatrolTask(MobileCompliainDO mobileCompliainDO) {

    if (mobileCompliainDO == null || StringUtils.isBlank(mobileCompliainDO.getTaskNumber())) {
      throw new ThrowsException("移动端投诉数据信息错误，未传递任务编码taskNumber！");
    }

    PatrolTaskDOExample doExample = new PatrolTaskDOExample();
    com.taikang.dic.ltci.model.PatrolTaskDOExample.Criteria patrolTaskCriteria =
        doExample.createCriteria();
    patrolTaskCriteria.andTaskNumberEqualTo(mobileCompliainDO.getTaskNumber());
    patrolTaskCriteria.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());
    List<PatrolTaskDO> patrolTaskList = patrolTaskDAO.selectByExample(doExample);
    if (!patrolTaskList.isEmpty()) {
      return;
    }
    PatrolTaskDO patrolTaskDO = new PatrolTaskDO();
    patrolTaskDO.setPatrolTaskId(UUID.randomUUID().toString().replaceAll("-", ""));
    //默认为未分配状态
    patrolTaskDO.setTaskState(TaskStateEnum.NO_ALLOCATION.getValue());
    //投诉人类型

    patrolTaskDO.setComplaintObjectId(mobileCompliainDO.getComplaintObjectId());
    patrolTaskDO.setComplainantObjectType(mobileCompliainDO.getComplainantType());

    patrolTaskDO.setComplainantId(mobileCompliainDO.getComplainantId());
    patrolTaskDO.setComplaintContent(mobileCompliainDO.getComplaintContent());

    patrolTaskDO.setComplaintTime(mobileCompliainDO.getComplaintTime());
    //被投诉对象类型
    patrolTaskDO.setPatrolObjectType((int) mobileCompliainDO.getComplaintObjectType());
    //投诉人id
    patrolTaskDO.setComplainantId(mobileCompliainDO.getComplainantId());
    //1.获取被投诉对象信息
    if (mobileCompliainDO.getComplaintObjectType() == PatrolObjectTypeEnum.NURSE_STAFF.getValue()) {
      //1.1如果是护理人员，查询护理人员信息
      ResultDTO resultDTO =
          agencyPersonClient.getStaffByStaffCode(mobileCompliainDO.getComplaintObjectId());
      if (!StatusCodeEnum.OK.getValue().equals(resultDTO.getStatus())) {
        throw new NotFoundByIdException(resultDTO.getMessage());
      }
      StaffSpecialDO staffSpecialDO =
          JSONObject.parseObject(
              JSONObject.toJSONString(resultDTO.getDatas()), StaffSpecialDO.class);

      patrolTaskDO.setAgencyCode(staffSpecialDO.getAgencyCode());
      patrolTaskDO.setAgencyName(staffSpecialDO.getAgencyName());
      patrolTaskDO.setPatrolObjectId(staffSpecialDO.getStaffCode());
      patrolTaskDO.setPatrolObjectName(staffSpecialDO.getStaffName());
      patrolTaskDO.setPatrolObjectPhone(staffSpecialDO.getStaffPhone());
      patrolTaskDO.setIdCard(staffSpecialDO.getCredentialNumber());
      patrolTaskDO.setPatrolObjectAddr(staffSpecialDO.getAgencyAddressDetail());
    } else if (mobileCompliainDO.getComplaintObjectType()
        == PatrolObjectTypeEnum.NURSE_ORGANIZATION.getValue()) {
      //1.2如果是护理机构，查询护理机构信息
      ResultDTO resultDTO =
          agencyPersonClient.getAgencyByAgencyCode(mobileCompliainDO.getComplaintObjectId());
      if (!StatusCodeEnum.OK.getValue().equals(resultDTO.getStatus())) {
        throw new NotFoundByIdException(resultDTO.getMessage());
      }
      AgencyDO agencyDO =
          JSONObject.parseObject(JSONObject.toJSONString(resultDTO.getDatas()), AgencyDO.class);

      patrolTaskDO.setAgencyCode(agencyDO.getAgencyCode());
      patrolTaskDO.setAgencyName(agencyDO.getAgencyName());
      patrolTaskDO.setPatrolObjectId(agencyDO.getAgencyCode());
      patrolTaskDO.setPatrolObjectName(agencyDO.getAgencyName());
      patrolTaskDO.setPatrolObjectPhone(agencyDO.getAgencyContactPhone());
      patrolTaskDO.setIdCard("");
      patrolTaskDO.setPatrolObjectAddr(agencyDO.getAgencyAddressDetail());
    }
    //2.设置基本信息
    patrolTaskDO.setTaskCategory(TaskCategoryEnum.COMPLAINT.getValue());
    patrolTaskDO.setTaskLevel(TaskLevelEnum.SPECIAL.getValue());

    patrolTaskDO.setInsuredPersonCard(mobileCompliainDO.getIdCard());
    patrolTaskDO.setTaskNumber(mobileCompliainDO.getTaskNumber());

    patrolTaskDO.setViolationItem(mobileCompliainDO.getItem());

    //查询基础微服务，查询参保人对应经办机构
    ResultDTO resultDTO =
        insuredPersonServerClient.getInsuredPersonDetail("", mobileCompliainDO.getIdCard(), "");
    if (resultDTO == null || !StatusCodeEnum.OK.getValue().equals(resultDTO.getStatus())) {
      throw new ThrowsException(
          "质控项目投诉接口根据IDCard:" + mobileCompliainDO.getIdCard() + "查询参保人详细信息失败！");
    }
    InsuredPersonDO insuredPersonDO =
        JSONObject.parseObject(
            JSONObject.toJSONString(resultDTO.getDatas()), InsuredPersonDO.class);

    //默认为未分配状态
    //patrolTaskDO.setExecuteMessageState(0);
    patrolTaskDO.setSiArea(insuredPersonDO.getSiArea());
    patrolTaskDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
    patrolTaskDO.setCreatedBy("");
    patrolTaskDO.setCreatedTime(new Date());
    patrolTaskDO.setCreatedOrg(insuredPersonDO.getCreatedOrg());

    patrolTaskDO.setOperatedBy("");
    patrolTaskDO.setOperatedTime(patrolTaskDO.getCreatedTime());
    patrolTaskDO.setOperatedOrg(insuredPersonDO.getCreatedOrg());

    patrolTaskDO.setDeputyName(mobileCompliainDO.getComplainantName());
    patrolTaskDO.setComplainantId(mobileCompliainDO.getComplainantId());
    patrolTaskDO.setDeputyMobile(mobileCompliainDO.getComplainantMobile());

    patrolTaskDAO.insertSelective(patrolTaskDO);

    //添加巡查任务日志表
    PatrolTaskLogDO patrolTaskLogDO = new PatrolTaskLogDO();
    patrolTaskLogDO.setPatrolTaskLogid(UUID.randomUUID().toString().replaceAll("-", ""));
    patrolTaskLogDO.setPatrolTaskId(patrolTaskDO.getPatrolTaskId());
    patrolTaskLogDO.setTaskState(TaskStateEnum.NO_ALLOCATION.getValue());
    patrolTaskLogDO.setTaskLevel(patrolTaskDO.getTaskLevel());
    patrolTaskLogDO.setTaskCategory(patrolTaskDO.getTaskCategory());
    patrolTaskLogDO.setOperatedTime(patrolTaskDO.getOperatedTime());
    patrolTaskLogDAO.insert(patrolTaskLogDO);

    //添加巡查任务明细表
    insertPatrolTaskDetail(mobileCompliainDO, patrolTaskDO.getPatrolTaskId());
    //添加投诉资料信息表
    insertComplaintResource(mobileCompliainDO, patrolTaskDO.getPatrolTaskId());
  }

  /**
   * 添加投诉附件信息
   *
   * @param mobileCompliainDO
   * @param patrolTaskId
   */
  private void insertComplaintResource(MobileCompliainDO mobileCompliainDO, String patrolTaskId) {
    List<Map<String, String>> fileList = mobileCompliainDO.getFileList();
    for (Map<String, String> map : fileList) {
      abLogger.debug("map:" + JSONObject.toJSONString(map));
      ComplaintResourceDO complaintResourceDO = new ComplaintResourceDO();
      complaintResourceDO.setResourceId(UUID.randomUUID().toString().replaceAll("-", ""));
      complaintResourceDO.setPatrolTaskId(patrolTaskId);
      complaintResourceDO.setResourceMaterialId(map.get("materialId"));
      complaintResourceDO.setResourceMaterialType(map.get("materialType"));
      complaintResourceDO.setResourceFileName(map.get("materialFileName"));
      complaintResourceDO.setResourceFileType(
          FileTypeDecideUtil.getFileType(map.get("materialType")));
      abLogger.debug("complaintResourceDO:" + JSONObject.toJSONString(complaintResourceDO));
      //保存到MySql中，获取到id
      String materialinfoScan = getFileID(map);
      complaintResourceDO.setResourceMaterialInfoScan(materialinfoScan);
      complaintResourceDAO.insert(complaintResourceDO);
    }
  }

  /**
   * 保存到MySQL中
   *
   * @param map
   * @return
   */
  private String getFileID(Map<String, String> map) {
    AttachmentDTO dto = new AttachmentDTO();
    dto.setContent(map.get("materialInfo"));
    String fileName =
        map.get("materialFileName") != null
            ? map.get("materialFileName")
            : UUID.randomUUID().toString().replaceAll("-", "");
    dto.setFileName(fileName);
    dto.setFileType(FileTypeDecideUtil.getFileType(map.get("materialType")));
    dto.setSuffix(map.get("materialType"));
    abLogger.debug("=====dto:" + JSONObject.toJSONString(dto));
    ResultDTO resultDTO = attachmentServiceClient.addAttachment(dto);
    if (resultDTO == null || !resultDTO.getStatus().equals(StatusCodeEnum.CREATED.getValue())) {
      throw new ThrowsException("调用媒体文件微服务端保存文件失败！");
    }
    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(resultDTO.getDatas()));
    return jsonObject.getString("attachmentid");
  }

  /**
   * 添加巡查任务详情信息
   *
   * @param mobileCompliainDO
   * @param patrolTaskId
   */
  private void insertPatrolTaskDetail(MobileCompliainDO mobileCompliainDO, String patrolTaskId) {
    PatrolTaskDetailDO patrolTaskDetailDO = new PatrolTaskDetailDO();
    patrolTaskDetailDO.setTaskDetailId(UUID.randomUUID().toString().replaceAll("-", ""));
    patrolTaskDetailDO.setPatrolTaskId(patrolTaskId);
    patrolTaskDetailDO.setOrgTaskId(mobileCompliainDO.getTaskNumber());
    patrolTaskDetailDO.setAgencyCode(mobileCompliainDO.getAgencyCode());
    patrolTaskDetailDO.setPersonCode(mobileCompliainDO.getPersonCode());
    patrolTaskDetailDO.setInsuranceName(mobileCompliainDO.getInsuredPersonName());
    patrolTaskDetailDO.setInsurancePapersNo(mobileCompliainDO.getIdCard());
    patrolTaskDetailDO.setInsurancePhone(mobileCompliainDO.getMobile());
    patrolTaskDetailDO.setInsuranceAddress(mobileCompliainDO.getAddress());

    patrolTaskDetailDO.setCreatedTime(new Date());

    patrolTaskDetailDAO.insertSelective(patrolTaskDetailDO);
  }

  @Override
  public IGenericDAO<PatrolTaskDO, String> getDao() {
    return patrolTaskDAO;
  }

  /** 添加专项巡查任务 */
  @Transactional
  @Override
  public ResultDTO addPatrol(PatrolTaskAddDO patrolTaskAddDO) {

    PatrolTaskDO patrolTaskDO = new PatrolTaskDO();

    BeanUtils.copyProperties(patrolTaskAddDO, patrolTaskDO);
    abLogger.debug(JSONObject.toJSONString(patrolTaskDO));

    patrolTaskDO.setCreatedTime(new Date());

    patrolTaskDO.setTaskState(TaskStateEnum.NO_ALLOCATION.getValue());
    patrolTaskDO.setTaskLevel(TaskLevelEnum.SPECIAL.getValue());
    patrolTaskDO.setPatrolTaskId(UUID.randomUUID().toString().replaceAll("-", ""));
    patrolTaskDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
    patrolTaskDO.setTaskCategory(TaskCategoryEnum.SYSTEM_HANDING.getValue());

    //将经办机构/时间/人和创建保持一直
    patrolTaskDO.setOperatedBy(patrolTaskDO.getCreatedBy());
    patrolTaskDO.setOperatedOrg(patrolTaskDO.getCreatedOrg());
    patrolTaskDO.setOperatedTime(patrolTaskDO.getCreatedTime());

    //需求变更， 将保存字段的patrol_remark 改成 remark

    patrolTaskDO.setRemark(patrolTaskDO.getPatrolRemark());

    patrolTaskDO.setPatrolRemark("");

    //代表是机构
    if (PatrolObjectTypeEnum.EVALUATE_ORGANIZATION.getValue() == patrolTaskDO.getPatrolObjectType()
        || PatrolObjectTypeEnum.NURSE_ORGANIZATION.getValue()
            == patrolTaskDO.getPatrolObjectType()) {
      patrolTaskDO.setAgencyCode(patrolTaskDO.getPatrolObjectId());
      patrolTaskDO.setAgencyName(patrolTaskDO.getPatrolObjectName());
    } else {
      //代表是查询的人员
      //      StaffSpecialDO staffSpecialDO =
      //          staffSpecialDAO.getAgencyByStaff(
      //              patrolTaskDO.getPatrolObjectName(), patrolTaskDO.getComplainantId());
      //      if (staffSpecialDO != null) {
      //        patrolTaskDO.setAgencyCode(staffSpecialDO.getAgencyCode());
      //        patrolTaskDO.setAgencyName(staffSpecialDO.getAgencyName());
      //      }
      logger.debug("staffcode为" + patrolTaskAddDO.getPatrolObjectId());
      ResultDTO agencyResult =
          agencyPersonClient.getAgencyByStaff(patrolTaskAddDO.getPatrolObjectId());
      if (agencyResult != null) {

        String resultString = JSONObject.toJSONString(agencyResult.getDatas());

        StaffSpecialDO staffSpecialDO = JSONObject.parseObject(resultString, StaffSpecialDO.class);
        patrolTaskDO.setAgencyCode(staffSpecialDO.getAgencyCode());
        patrolTaskDO.setAgencyName(staffSpecialDO.getAgencyName());
      }
    }
    patrolTaskDAO.insertSelective(patrolTaskDO);
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());

    resultDTO.setMessage("添加成功");
    return resultDTO;
  }

  @Override
  @Transactional
  public Boolean patrolTaskAllot(
      String patrolTaskId,
      String patrolStaffId,
      String patrolStaffName,
      String operatedBy,
      String operatedOrg) {
    String[] patrolTaskIds = patrolTaskId.split(",");
    //    String operatedOrg = ThreadLocalUtil.threadLocal.get().getOperatedOrg();

    for (String patrolTaskIdStr : patrolTaskIds) {
      PatrolTaskDO patrolTaskDO = new PatrolTaskDO();
      patrolTaskDO.setPatrolTaskId(patrolTaskIdStr);
      patrolTaskDO.setPatrolStaffId(patrolStaffId);
      patrolTaskDO.setPatrolStaffName(patrolStaffName);
      patrolTaskDO.setTaskState(TaskStateEnum.ALREDY_ALLOCATION.getValue());
      patrolTaskDO.setOperatedTime(new Date());
      patrolTaskDO.setOperatedOrg(operatedOrg);
      patrolTaskDO.setOperatedBy(operatedBy);

      PatrolTaskDO patrolTaskDOLog = patrolTaskDAO.selectByPrimaryKey(patrolTaskIdStr);
      if (patrolTaskDOLog == null) {
        throw new InsertRepeatException("传入id未查询到信息，分配失败");
      } else {
        if (patrolTaskDOLog.getTaskState() != null
            && TaskStateEnum.ALREDY_ALLOCATION.getValue()
                == patrolTaskDOLog.getTaskState().intValue()) {
          throw new InsertRepeatException("记录已被他人操作，请刷新页面，重新选择数据");
        }
      }
      PatrolTaskLogDO patrolTaskLog = new PatrolTaskLogDO();
      patrolTaskLog.setPatrolTaskId(patrolTaskIdStr);
      patrolTaskLog.setTaskCategory(patrolTaskDOLog.getTaskCategory());
      patrolTaskLog.setTaskLevel(patrolTaskDOLog.getTaskLevel());
      patrolTaskLog.setTaskState(TaskStateEnum.ALREDY_ALLOCATION.getValue());
      patrolTaskLog.setOperatedBy(operatedBy);
      patrolTaskLog.setOperatedOrg(operatedOrg);
      patrolTaskLog.setOperatedTime(new Date());
      patrolTaskLog.setPatrolTaskLogid(UUID.randomUUID().toString().replaceAll("-", ""));

      patrolTaskLogDAO.insert(patrolTaskLog);

      //修改条件增加状态
      PatrolTaskDOExample patrolTaskDOExample = new PatrolTaskDOExample();
      com.taikang.dic.ltci.model.PatrolTaskDOExample.Criteria createCriteria =
          patrolTaskDOExample.createCriteria();
      createCriteria.andTaskStateEqualTo(TaskStateEnum.NO_ALLOCATION.getValue());
      createCriteria.andPatrolTaskIdEqualTo(patrolTaskIdStr);
      createCriteria.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());

      int i = patrolTaskDAO.updateByExampleSelective(patrolTaskDO, patrolTaskDOExample);
      if (i <= 0) {
        throw new InsertRepeatException("记录已被他人操作，请刷新页面，重新选择数据");
      }
    }

    //循环调用发送mq
    abLogger.debug("====任务分配开始发送mq=========");
    for (String patrolTaskIdStrMq : patrolTaskIds) {
      patrolTaskSenderService.sendPatrolTask(patrolTaskIdStrMq);
    }
    abLogger.debug("====任务分配发送mq结束=========");

    return true;
  }

  /** 新增巡查 评估任务 对应机构 */
  @Override
  @Transactional
  public int expertTaskProfessionBatchAdd(
      List<PatrolTaskDetailDO> patrolTaskDetailDOs, int patrolObjectType) {
    int result = 0;
    if (patrolTaskDetailDOs != null && !patrolTaskDetailDOs.isEmpty()) {
      Map<String, PatrolTaskDO> map = new HashMap<>();
      List<PatrolTaskDetailDO> patrolTaskDetailDOList = new ArrayList<>();
      String patrolTaskId = "";
      for (PatrolTaskDetailDO patrolTaskDetailDO : patrolTaskDetailDOs) {
        //如果map中有可以，则不添加
        if (map.get(patrolTaskDetailDO.getAgencyCode()) == null) {
          PatrolTaskDO patrolTaskDO = new PatrolTaskDO();
          patrolTaskDO.setAgencyCode(patrolTaskDetailDO.getAgencyCode());
          patrolTaskDO.setAgencyName(patrolTaskDetailDO.getAgencyName());
          patrolTaskDO.setPatrolTaskId(patrolTaskId);
          //评估\护理机构
          patrolTaskDO.setPatrolObjectType(patrolObjectType);
          //被巡查对象编号
          patrolTaskDO.setPatrolObjectId(patrolTaskDetailDO.getAgencyCode());
          //被巡查对象名称
          patrolTaskDO.setPatrolObjectName(patrolTaskDetailDO.getAgencyName());
          //被巡查对象联系方式
          patrolTaskDO.setPatrolObjectPhone(patrolTaskDetailDO.getPatrolObjectPhone());
          patrolTaskDO.setPatrolObjectAddr(patrolTaskDetailDO.getPatrolObjectAddr());
          patrolTaskDO.setTaskCategory(TaskCategoryEnum.SYSTEM_HANDING.getValue());
          patrolTaskDO.setTaskLevel(TaskLevelEnum.COMMON.getValue());
          patrolTaskDO.setTaskState(TaskStateEnum.NO_ALLOCATION.getValue());
          patrolTaskDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
          patrolTaskDO.setCreatedBy(patrolTaskDetailDO.getCreatedBy());
          patrolTaskDO.setCreatedOrg(patrolTaskDetailDO.getCreatedOrg());
          patrolTaskDO.setCreatedTime(new Date());
          patrolTaskDO.setOperatedBy(patrolTaskDetailDO.getCreatedBy());
          patrolTaskDO.setOperatedOrg(patrolTaskDetailDO.getCreatedOrg());
          patrolTaskDO.setOperatedTime(new Date());

          patrolTaskId = UUID.randomUUID().toString().replaceAll("-", "");
          patrolTaskDO.setPatrolTaskId(patrolTaskId);
          map.put(patrolTaskDetailDO.getAgencyCode(), patrolTaskDO);
          /////////////////////////////////////////////////////////////////////////////
          patrolTaskDetailDO.setPatrolTaskId(patrolTaskId); //添加巡查任务主表字段

        } else {
          patrolTaskDetailDO.setPatrolTaskId(
              map.get(patrolTaskDetailDO.getAgencyCode()).getPatrolTaskId()); //添加巡查任务主表字段
        }
        patrolTaskDetailDO.setTaskDetailId(UUID.randomUUID().toString().replaceAll("-", ""));
        patrolTaskDetailDO.setIsValid(IsValidEnum.ALREADY_DELETE.getValue());
        patrolTaskDetailDO.setCreatedTime(new Date());
        patrolTaskDetailDO.setOperatedBy(patrolTaskDetailDO.getCreatedBy());
        patrolTaskDetailDO.setOperatedOrg(patrolTaskDetailDO.getCreatedOrg());
        patrolTaskDetailDO.setOperatedTime(new Date());

        patrolTaskDetailDOList.add(patrolTaskDetailDO);
      }
      //新增巡查任务主表
      map.forEach(
          (k, v) -> {
            patrolTaskDAO.insertSelective(v);
          });
      //新增巡查任务子表
      for (PatrolTaskDetailDO patrolTaskDetailDO : patrolTaskDetailDOList) {
        result = patrolTaskDetailDAO.insertSelective(patrolTaskDetailDO);
      }
    }

    return result;
  }

  @Override
  public PatrolTaskSpecialDO patrolTaskDetails(String patrolTaskId) {
    //首先根据id查询巡查任务表中信息 根据taskLevel区分专项还是普通
    PatrolTaskDO patrolTaskDO = patrolTaskDAO.selectByPrimaryKey(patrolTaskId);
    int taskLevel = patrolTaskDO.getTaskLevel();
    abLogger.debug("====详情列表taskLevel【" + taskLevel + "】=========");
    PatrolTaskSpecialDO patrolTaskSpecialDO;

    if (TaskLevelEnum.SPECIAL.getValue() == taskLevel) {
      abLogger.debug("==详情列表查询专项任务==");
      patrolTaskSpecialDO = patrolTaskSpecialDAO.selectByPrimaryKey(patrolTaskId);

      ComplaintResourceDOExample doExample = new ComplaintResourceDOExample();
      com.taikang.dic.ltci.model.ComplaintResourceDOExample.Criteria criteria =
          doExample.createCriteria();
      criteria.andPatrolTaskIdEqualTo(patrolTaskId);

      List<ComplaintResourceDO> selectByExample = complaintResourceDAO.selectByExample(doExample);
      if (!selectByExample.isEmpty()) {
        //判断字段是否为空 如果为null返回空字符串
        for (ComplaintResourceDO complaintResourceDO : selectByExample) {
          String resourceId = complaintResourceDO.getResourceId();
          String resourceMaterialType = complaintResourceDO.getResourceMaterialType();
          String resourceMaterialId = complaintResourceDO.getResourceMaterialId();
          String resourceMaterialInfoScan = complaintResourceDO.getResourceMaterialInfoScan();
          String patrolTaskIdForSet = complaintResourceDO.getPatrolTaskId();
          String resourceFileName = complaintResourceDO.getResourceFileName();
          String resourceFileType = complaintResourceDO.getResourceFileType();

          resourceId = this.strIsEmpty(resourceId);
          resourceMaterialType = this.strIsEmpty(resourceMaterialType);
          resourceMaterialId = this.strIsEmpty(resourceMaterialId);
          resourceMaterialInfoScan = this.strIsEmpty(resourceMaterialInfoScan);
          patrolTaskIdForSet = this.strIsEmpty(patrolTaskIdForSet);
          resourceFileName = this.strIsEmpty(resourceFileName);
          resourceFileType = this.strIsEmpty(resourceFileType);

          complaintResourceDO.setResourceId(resourceId);
          complaintResourceDO.setResourceMaterialType(resourceMaterialType);
          complaintResourceDO.setResourceMaterialId(resourceMaterialId);
          complaintResourceDO.setResourceMaterialInfoScan(resourceMaterialInfoScan);
          complaintResourceDO.setPatrolTaskId(patrolTaskIdForSet);
          complaintResourceDO.setResourceFileName(resourceFileName);
          complaintResourceDO.setResourceFileType(resourceFileType);
        }
        patrolTaskSpecialDO.setComplaintResourceDOList(selectByExample);
      } else {
        List<ComplaintResourceDO> complaintResourceDOs = new ArrayList<>();
        patrolTaskSpecialDO.setComplaintResourceDOList(complaintResourceDOs);
      }

      //处理违规项
      if (!StringUtils.isEmpty(patrolTaskSpecialDO.getViolationItem())) {
        String violationItem = patrolTaskSpecialDO.getViolationItem();
        List<ViolationItemDO> parseArray =
            JSONArray.parseArray(violationItem, ViolationItemDO.class);
        String itemName = "";
        for (ViolationItemDO violationItemDO : parseArray) {
          itemName += violationItemDO.getItemName();
          itemName += ",";
        }
        itemName = itemName.substring(0, itemName.length() - 1);
        patrolTaskSpecialDO.setViolationItem(itemName);
      }

    } else {
      abLogger.debug("==详情列表查询普通任务==");
      patrolTaskSpecialDO = patrolTaskSpecialDAO.selectByPrimaryKey(patrolTaskId);

      PatrolTaskDetailDOExample doExample = new PatrolTaskDetailDOExample();
      com.taikang.dic.ltci.model.PatrolTaskDetailDOExample.Criteria criteria =
          doExample.createCriteria();
      criteria.andPatrolTaskIdEqualTo(patrolTaskId);

      List<PatrolTaskDetailDO> selectByExample = iPatrolTaskDetailDAO.selectByExample(doExample);

      if (!selectByExample.isEmpty()) {
        List<PatrolTaskDetailSpecialDO> PatrolTaskDetailSpecialDOList = new ArrayList<>();
        for (PatrolTaskDetailDO patrolTaskDetailDO : selectByExample) {
          PatrolTaskDetailSpecialDO patrolTaskDetailSpecialDO =
              this.PatrolTaskDetailDOToSpecial(patrolTaskDetailDO);
          PatrolTaskDetailSpecialDOList.add(patrolTaskDetailSpecialDO);
        }
        patrolTaskSpecialDO.setPatrolTaskDetailDOList(PatrolTaskDetailSpecialDOList);
      } else {
        List<PatrolTaskDetailSpecialDO> PatrolTaskDetailSpecialDOs = new ArrayList<>();
        patrolTaskSpecialDO.setPatrolTaskDetailDOList(PatrolTaskDetailSpecialDOs);
      }
    }

    abLogger.debug(
        "====查询出patrolTaskSpecialDO【"
            + JSONObject.toJSONString(patrolTaskSpecialDO)
            + "】==========");
    return patrolTaskSpecialDO;
  }

  /** 确定能够查询到已新增的任务 */
  @Override
  public List<String> isHaveOrgTaskIdList(List<PatrolTaskDetailDO> patrolTaskDetailDOs) {
    List<String> taskIdList = new ArrayList<>();
    for (PatrolTaskDetailDO patrolTaskDetailDO : patrolTaskDetailDOs) {
      PatrolTaskDetailDOExample doExample = new PatrolTaskDetailDOExample();
      com.taikang.dic.ltci.model.PatrolTaskDetailDOExample.Criteria criteria =
          doExample.createCriteria();
      criteria.andOrgTaskIdEqualTo(patrolTaskDetailDO.getOrgTaskId());
      List<PatrolTaskDetailDO> selectByExample = iPatrolTaskDetailDAO.selectByExample(doExample);
      if (!selectByExample.isEmpty()) {
        taskIdList.add(patrolTaskDetailDO.getOrgTaskId());
      }
    }
    return taskIdList;
  }

  @Override
  public PatrolTaskAllotDetailSpecialDO patrolTaskAllotDetails(String patrolTaskId) {
    PatrolTaskAllotDetailSpecialDO patrolTaskAllotDetailSpecialDO =
        patrolTaskAllotDetailSpecialDAO.selectPatrolTaskByPatrolTaskId(patrolTaskId);
    abLogger.debug(
        "=========patrolTaskAllotDetailSpecialDO【"
            + JSONObject.toJSONString(patrolTaskAllotDetailSpecialDO)
            + "】==============");

    //数据库json格式有转移字符  替换
    //    if (!StringUtils.isEmpty(patrolTaskAllotDetailSpecialDO.getComplainItems())) {
    //      String complainItems = patrolTaskAllotDetailSpecialDO.getComplainItems();
    //      //List<Map> list = JSONArray.parseArray(complainItems, Map.class);
    //      complainItems = complainItems.replaceAll("\\\\", "");
    //      abLogger.debug("====complainItems【"+complainItems+"】=======");
    //      patrolTaskAllotDetailSpecialDO.setComplainItems(complainItems);
    //    }

    PatrolTaskDetailDOExample paTaskDetailDOExample = new PatrolTaskDetailDOExample();
    com.taikang.dic.ltci.model.PatrolTaskDetailDOExample.Criteria criteria =
        paTaskDetailDOExample.createCriteria();
    criteria.andPatrolTaskIdEqualTo(patrolTaskId);

    List<PatrolTaskDetailDO> PatrolTaskDetailDOs =
        patrolTaskDetailDAO.selectByExample(paTaskDetailDOExample);
    abLogger.debug(
        "=====PatrolTaskDetailDOs【"
            + JSONObject.toJSONString(PatrolTaskDetailDOs)
            + "】=============");

    ComplaintResourceDOExample complaintResourceDOExample = new ComplaintResourceDOExample();
    com.taikang.dic.ltci.model.ComplaintResourceDOExample.Criteria createCriteria =
        complaintResourceDOExample.createCriteria();
    createCriteria.andPatrolTaskIdEqualTo(patrolTaskId);

    List<ComplaintResourceDO> ComplaintResourceDOs =
        complaintResourceDAO.selectByExample(complaintResourceDOExample);
    abLogger.debug(
        "=====ComplaintResourceDOs【"
            + JSONObject.toJSONString(ComplaintResourceDOs)
            + "】=============");

    //根据人员还是机构将数据set到id_card字段
    if (patrolTaskAllotDetailSpecialDO
            .getPatrolObjectType()
            .equals(PatrolObjectTypeEnum.NURSE_ORGANIZATION.getValue())
        || patrolTaskAllotDetailSpecialDO
            .getPatrolObjectType()
            .equals(PatrolObjectTypeEnum.EVALUATE_ORGANIZATION.getValue())) {
      patrolTaskAllotDetailSpecialDO.setIdCard(patrolTaskAllotDetailSpecialDO.getAgencyCode());
      patrolTaskAllotDetailSpecialDO.setAgencyCode("");
    } else if (patrolTaskAllotDetailSpecialDO
            .getPatrolObjectType()
            .equals(PatrolObjectTypeEnum.NURSE_STAFF.getValue())
        || patrolTaskAllotDetailSpecialDO
            .getPatrolObjectType()
            .equals(PatrolObjectTypeEnum.EVALUATE_STAFF.getValue())) {
      patrolTaskAllotDetailSpecialDO.setAgencyCode("");
    }

    //投诉任务查询信息表中数据和具体的附件信息
    String taskCategory = patrolTaskAllotDetailSpecialDO.getTaskCategory();
    int task = Integer.parseInt(taskCategory);
    if (task == TaskCategoryEnum.COMPLAINT.getValue()) {
      abLogger.debug("=====来源为投诉=============");
      if (!PatrolTaskDetailDOs.isEmpty()) {
        String checkType = this.intIsEmpty(PatrolTaskDetailDOs.get(0).getServiceType());
        String recognizeeMan = this.strIsEmpty(PatrolTaskDetailDOs.get(0).getInsuranceName());
        String recognizeeManCode = this.strIsEmpty(PatrolTaskDetailDOs.get(0).getInsuranceCode());
        String recognizeeManIdType =
            this.intIsEmpty(PatrolTaskDetailDOs.get(0).getInsurancePapersType());
        String recognizeeManIdNo =
            this.strIsEmpty(PatrolTaskDetailDOs.get(0).getInsurancePapersNo());
        String recognizeeManPhone = this.strIsEmpty(PatrolTaskDetailDOs.get(0).getInsurancePhone());
        String recognizeeManAddr =
            this.strIsEmpty(PatrolTaskDetailDOs.get(0).getInsuranceAddress());
        String longitude = this.strIsEmpty(PatrolTaskDetailDOs.get(0).getLongitude());
        String latitude = this.strIsEmpty(PatrolTaskDetailDOs.get(0).getLatitude());

        patrolTaskAllotDetailSpecialDO.setCheckType(checkType);
        patrolTaskAllotDetailSpecialDO.setRecognizeeMan(recognizeeMan);
        patrolTaskAllotDetailSpecialDO.setRecognizeeManCode(recognizeeManCode);
        patrolTaskAllotDetailSpecialDO.setRecognizeeManIdType(recognizeeManIdType);
        patrolTaskAllotDetailSpecialDO.setRecognizeeManIdNo(recognizeeManIdNo);
        patrolTaskAllotDetailSpecialDO.setRecognizeeManPhone(recognizeeManPhone);
        patrolTaskAllotDetailSpecialDO.setRecognizeeManAddr(recognizeeManAddr);
        patrolTaskAllotDetailSpecialDO.setLongitude(longitude);
        patrolTaskAllotDetailSpecialDO.setLatitude(latitude);
      }
      if (!ComplaintResourceDOs.isEmpty()) {
        patrolTaskAllotDetailSpecialDO.setMaterial(ComplaintResourceDOs);
      }
    }

    //普通任务 评估任务
    String patrolObjectType = patrolTaskAllotDetailSpecialDO.getPatrolObjectType();
    int patrol = Integer.parseInt(patrolObjectType);
    if (patrol == PatrolObjectTypeEnum.EVALUATE_ORGANIZATION.getValue()
        || patrol == PatrolObjectTypeEnum.EVALUATE_STAFF.getValue()) {
      abLogger.debug("=====评估普通任务=========");
      List<PatrolTaskDetailItemDO> patrolTaskDetailItemDOs = new ArrayList<>();
      if (!PatrolTaskDetailDOs.isEmpty()) {
        for (PatrolTaskDetailDO patrolTaskDetailDO : PatrolTaskDetailDOs) {
          String executorName = this.strIsEmpty(patrolTaskDetailDO.getPersonName());
          String executorMobile = this.strIsEmpty(patrolTaskDetailDO.getPersonPhone());
          String executorOrgName = this.strIsEmpty(patrolTaskAllotDetailSpecialDO.getAgencyName());
          String name = this.strIsEmpty(patrolTaskDetailDO.getInsuranceName());
          String mobile = this.strIsEmpty(patrolTaskDetailDO.getInsurancePhone());
          String evaluateTime = this.dateIsEmpty(patrolTaskDetailDO.getPreevaluateDate());
          String taskDeadline = this.intIsEmpty(patrolTaskDetailDO.getIsCritical());

          PatrolTaskDetailItemDO patrolTaskDetailItemDO = new PatrolTaskDetailItemDO();
          patrolTaskDetailItemDO.setExecutorName(executorName);
          patrolTaskDetailItemDO.setExecutorMobile(executorMobile);
          patrolTaskDetailItemDO.setExecutorOrgName(executorOrgName);
          patrolTaskDetailItemDO.setName(name);
          patrolTaskDetailItemDO.setMobile(mobile);
          patrolTaskDetailItemDO.setEvaluateTime(evaluateTime);
          patrolTaskDetailItemDO.setTaskDeadline(taskDeadline);
          patrolTaskDetailItemDOs.add(patrolTaskDetailItemDO);
        }
      }
      patrolTaskAllotDetailSpecialDO.setDetailItems(patrolTaskDetailItemDOs);
    }

    //普通任务 护理任务
    if (patrol == PatrolObjectTypeEnum.NURSE_ORGANIZATION.getValue()
        || patrol == PatrolObjectTypeEnum.NURSE_STAFF.getValue()) {
      abLogger.debug("=====护理普通任务=========");
      List<PatrolTaskNurseDetailItemDO> patrolTaskNurseDetailItemDOs = new ArrayList<>();
      if (!PatrolTaskDetailDOs.isEmpty()) {
        for (PatrolTaskDetailDO patrolTaskDetailDO : PatrolTaskDetailDOs) {
          String isKinshipCare = this.intIsEmpty(patrolTaskDetailDO.getIsKinshipCare());
          String isPrivilege = this.intIsEmpty(patrolTaskDetailDO.getIsPrivilege());
          String checkType = this.intIsEmpty(patrolTaskDetailDO.getServiceType());
          String serviceItems = this.strIsEmpty(patrolTaskDetailDO.getServiceItems());
          String nurseTime = this.dateIsEmpty(patrolTaskDetailDO.getPreevaluateDate());
          String nurseCd = this.strIsEmpty(patrolTaskDetailDO.getPersonName());
          String nurseMobile = this.strIsEmpty(patrolTaskDetailDO.getPersonPhone());
          String nurseOrgName = this.strIsEmpty(patrolTaskAllotDetailSpecialDO.getAgencyName());
          String name = this.strIsEmpty(patrolTaskDetailDO.getInsuranceName());
          String mobile = this.strIsEmpty(patrolTaskDetailDO.getInsurancePhone());
          String addr = this.strIsEmpty(patrolTaskDetailDO.getInsuranceAddress());

          PatrolTaskNurseDetailItemDO patrolTaskNurseDetailItemDO =
              new PatrolTaskNurseDetailItemDO();
          patrolTaskNurseDetailItemDO.setIsKinshipCare(isKinshipCare);
          patrolTaskNurseDetailItemDO.setIsPrivilege(isPrivilege);
          patrolTaskNurseDetailItemDO.setCheckType(checkType);
          patrolTaskNurseDetailItemDO.setServiceItems(serviceItems);
          patrolTaskNurseDetailItemDO.setNurseTime(nurseTime);
          patrolTaskNurseDetailItemDO.setNurseCd(nurseCd);
          patrolTaskNurseDetailItemDO.setNurseMobile(nurseMobile);
          patrolTaskNurseDetailItemDO.setNurseOrgName(nurseOrgName);
          patrolTaskNurseDetailItemDO.setName(name);
          patrolTaskNurseDetailItemDO.setMobile(mobile);
          patrolTaskNurseDetailItemDO.setAddr(addr);
          patrolTaskNurseDetailItemDOs.add(patrolTaskNurseDetailItemDO);
        }
      }
      patrolTaskAllotDetailSpecialDO.setNurseDetailItems(patrolTaskNurseDetailItemDOs);
    }

    abLogger.debug(
        "=====返回的patrolTaskAllotDetailSpecialDO【"
            + JSONObject.toJSONString(patrolTaskAllotDetailSpecialDO)
            + "】==========");
    return patrolTaskAllotDetailSpecialDO;
  }

  private String strIsEmpty(String str) {
    String returStr = str != null ? str : "";
    return returStr;
  }

  private String intIsEmpty(Integer str) {
    String returStr = str != null ? str.toString() : "";
    return returStr;
  }

  private String dateIsEmpty(Date str) {
    String returStr =
        str != null
            ? DateFormatUtil.dateToStr(str, DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS)
            : "";
    return returStr;
  }

  private PatrolTaskDetailSpecialDO PatrolTaskDetailDOToSpecial(
      PatrolTaskDetailDO patrolTaskDetailDO) {
    PatrolTaskDetailSpecialDO patrolTaskDetailSpecialDO = new PatrolTaskDetailSpecialDO();

    String taskDetailId = patrolTaskDetailDO.getTaskDetailId();
    String patrolTaskId = patrolTaskDetailDO.getPatrolTaskId();
    String orgTaskId = patrolTaskDetailDO.getOrgTaskId();
    String personName = patrolTaskDetailDO.getPersonName();
    String personCode = patrolTaskDetailDO.getPersonCode();
    String agencyCode = patrolTaskDetailDO.getAgencyCode();
    Date preevaluateDate = patrolTaskDetailDO.getPreevaluateDate();
    String insuranceCode = patrolTaskDetailDO.getInsuranceCode();
    String insuranceName = patrolTaskDetailDO.getInsuranceName();
    Integer insurancePapersType = patrolTaskDetailDO.getInsurancePapersType();
    String insurancePapersNo = patrolTaskDetailDO.getInsurancePapersNo();
    String insurancePhone = patrolTaskDetailDO.getInsurancePhone();
    String insuranceAddress = patrolTaskDetailDO.getInsuranceAddress();
    String longitude = patrolTaskDetailDO.getLongitude();
    String latitude = patrolTaskDetailDO.getLatitude();
    String remark = patrolTaskDetailDO.getRemark();
    Integer serviceType = patrolTaskDetailDO.getServiceType();
    String serviceItems = patrolTaskDetailDO.getServiceItems();
    String createdBy = patrolTaskDetailDO.getCreatedBy();
    String createdOrg = patrolTaskDetailDO.getCreatedOrg();
    Date createdTime = patrolTaskDetailDO.getCreatedTime();
    Integer isCritical = patrolTaskDetailDO.getIsCritical();
    Integer isKinshipCare = patrolTaskDetailDO.getIsKinshipCare();
    Integer isPrivilege = patrolTaskDetailDO.getIsPrivilege();
    String personPhone = patrolTaskDetailDO.getPersonPhone();
    String agencyName = patrolTaskDetailDO.getAgencyName();
    String patrolObjectPhone = patrolTaskDetailDO.getPatrolObjectPhone();
    String patrolObjectAddr = patrolTaskDetailDO.getPatrolObjectAddr();

    patrolTaskDetailSpecialDO.setTaskDetailId(taskDetailId);
    patrolTaskDetailSpecialDO.setPatrolTaskId(patrolTaskId);
    patrolTaskDetailSpecialDO.setOrgTaskId(orgTaskId);
    patrolTaskDetailSpecialDO.setPersonName(personName);
    patrolTaskDetailSpecialDO.setPersonCode(personCode);
    patrolTaskDetailSpecialDO.setAgencyCode(agencyCode);
    if (preevaluateDate != null) {
      patrolTaskDetailSpecialDO.setPreevaluateDate(
          DateFormatUtil.dateToStr(
              preevaluateDate, DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS));
    } else {
      patrolTaskDetailSpecialDO.setPreevaluateDate("");
    }
    patrolTaskDetailSpecialDO.setInsuranceCode(insuranceCode);
    patrolTaskDetailSpecialDO.setInsuranceName(insuranceName);
    patrolTaskDetailSpecialDO.setInsurancePapersType(insurancePapersType);
    patrolTaskDetailSpecialDO.setInsurancePapersNo(insurancePapersNo);
    patrolTaskDetailSpecialDO.setInsurancePhone(insurancePhone);
    patrolTaskDetailSpecialDO.setInsuranceAddress(insuranceAddress);
    patrolTaskDetailSpecialDO.setLongitude(longitude);
    patrolTaskDetailSpecialDO.setLatitude(latitude);
    patrolTaskDetailSpecialDO.setRemark(remark);
    patrolTaskDetailSpecialDO.setServiceType(serviceType);
    patrolTaskDetailSpecialDO.setServiceItems(serviceItems);
    patrolTaskDetailSpecialDO.setCreatedBy(createdBy);
    patrolTaskDetailSpecialDO.setCreatedOrg(createdOrg);
    if (createdTime != null) {
      patrolTaskDetailSpecialDO.setCreatedTime(
          DateFormatUtil.dateToStr(createdTime, DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS));
    } else {
      patrolTaskDetailSpecialDO.setCreatedTime("");
    }
    patrolTaskDetailSpecialDO.setIsCritical(isCritical);
    patrolTaskDetailSpecialDO.setIsKinshipCare(isKinshipCare);
    patrolTaskDetailSpecialDO.setIsPrivilege(isPrivilege);
    patrolTaskDetailSpecialDO.setPersonPhone(personPhone);
    patrolTaskDetailSpecialDO.setAgencyName(agencyName);
    patrolTaskDetailSpecialDO.setPatrolObjectPhone(patrolObjectPhone);
    patrolTaskDetailSpecialDO.setPatrolObjectAddr(patrolObjectAddr);

    return patrolTaskDetailSpecialDO;
  }
}
