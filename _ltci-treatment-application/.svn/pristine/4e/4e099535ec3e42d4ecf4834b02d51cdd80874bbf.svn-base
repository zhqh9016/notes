package com.taikang.dic.ltci.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.taikang.dic.ltci.api.model.ApplicationLogDTO;
import com.taikang.dic.ltci.api.model.AttachmentDTO;
import com.taikang.dic.ltci.api.model.InsuredPersonDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.api.model.TodoListDTO;
import com.taikang.dic.ltci.api.model.TreatmentApplicationDTO;
import com.taikang.dic.ltci.common.IPUtil;
import com.taikang.dic.ltci.common.enumeration.ApplicationStatusEnum;
import com.taikang.dic.ltci.common.enumeration.FileTypeEnum;
import com.taikang.dic.ltci.common.enumeration.IsRelativeCaredEnum;
import com.taikang.dic.ltci.common.enumeration.IsTaskDeadline;
import com.taikang.dic.ltci.common.enumeration.IsValidEnum;
import com.taikang.dic.ltci.common.enumeration.MqTypeEnum;
import com.taikang.dic.ltci.common.enumeration.OperationTypeEnum;
import com.taikang.dic.ltci.common.enumeration.SourcesEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.enumeration.ToDoListEnum;
import com.taikang.dic.ltci.common.enumeration.ToDoListTypeEnum;
import com.taikang.dic.ltci.common.enumeration.TransportTypeEnum;
import com.taikang.dic.ltci.common.exception.InsertRepeatException;
import com.taikang.dic.ltci.common.exception.NotFoundByIdException;
import com.taikang.dic.ltci.common.exception.ParametersIsNullException;
import com.taikang.dic.ltci.common.exception.ThrowsException;
import com.taikang.dic.ltci.common.log.ThreadLocalUtil;
import com.taikang.dic.ltci.common.utils.DateFormat;
import com.taikang.dic.ltci.common.utils.DateFormatUtil;
import com.taikang.dic.ltci.dao.ApplicationDAO;
import com.taikang.dic.ltci.dao.DeputyBindingDAO;
import com.taikang.dic.ltci.dao.IMqFailMessageLogDAO;
import com.taikang.dic.ltci.dao.MQMessageLogDAO;
import com.taikang.dic.ltci.dao.TreatmentApplicationDAO;
import com.taikang.dic.ltci.model.ApplicationDO;
import com.taikang.dic.ltci.model.ApplicationDOExample;
import com.taikang.dic.ltci.model.ApplicationLogDO;
import com.taikang.dic.ltci.model.ApplicationSpecialDO;
import com.taikang.dic.ltci.model.DeputyBindingDO;
import com.taikang.dic.ltci.model.InsuredPersonDO;
import com.taikang.dic.ltci.model.MQMessageLogDO;
import com.taikang.dic.ltci.model.MqBaseModel;
import com.taikang.dic.ltci.model.MqFailMessageLogDO;
import com.taikang.dic.ltci.model.OrganizationDO;
import com.taikang.dic.ltci.model.TreatmentApplicationDO;
import com.taikang.dic.ltci.serverClient.AttachmentServiceClient;
import com.taikang.dic.ltci.serverClient.OrganizationServerClient;
import com.taikang.dic.ltci.serverClient.TodoListServerClient;
import com.taikang.dic.ltci.service.ApplicationLogService;
import com.taikang.dic.ltci.service.ApplicationService;
import com.taikang.dic.ltci.service.InsuredPersonService;
import com.taikang.dic.ltci.service.MobileTreatmentApplicationSenderService;
import com.taikang.dic.ltci.service.MobileTreatmentApplicationService;

/**
 * @author itw_xuxf
 * @description 移动端待遇申请受理业务服务
 * @version 创建时间：2017年3月30日上午8:29:58
 */
@Service
public class MobileTreatmentApplicationServiceImpl implements MobileTreatmentApplicationService {
  private static final Logger logger =
      LoggerFactory.getLogger(MobileTreatmentApplicationServiceImpl.class);

  @Autowired private TreatmentApplicationDAO treatmentApplicationDAO;
  @Autowired private MQMessageLogDAO mqMessageLogDAO;
  @Autowired private MobileTreatmentApplicationSenderService sender;

  @Autowired private InsuredPersonService insuredPersonService;

  @Autowired private ApplicationService applicationService;
  @Autowired private ApplicationDAO applicationDAO;
  @Autowired private ApplicationLogService applicationLogService;

  @Autowired private AttachmentServiceClient attachmentServiceClient;
  @Autowired private TodoListServerClient todoListServerClient;
  @Autowired private OrganizationServerClient organizationServerClient;
  @Autowired private DeputyBindingDAO deputyBindingDAO;
  @Autowired private IMqFailMessageLogDAO mqFailMessageLogDAO;

  @Value("${systemCode}")
  protected String systemCode;

  @Value("${ltci.treatmentApplicationCase.exchange}")
  private String exchangeName;

  @Value("${ltci.treatmentApplicationCase.queue}")
  private String routingKey;

  @Value("${ltci.treatmentApplicationCase.messageCode1}")
  private String messageCode1;

  @Value("${ltci.treatmentApplicationCase.messageCode2}")
  private String messageCode2;
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
  public List<TreatmentApplicationDO> mobileTreatmentApplicationList(
      String insuredPersonName,
      String idCard,
      String securityNumber,
      String disease,
      String operatedTime,
      int page,
      int pageSize,
      String applicationStatus) {
    Map<String, Object> map = new HashMap<>();
    map.put("insuredPersonName", insuredPersonName);
    map.put("idCard", idCard);
    map.put("securityNumber", securityNumber);
    map.put("disease", disease);
    if (StringUtils.isNotBlank(applicationStatus)) {
      String[] arr = applicationStatus.split(",");
      map.put("applicationStatus", arr);
    }
    if (null != operatedTime && !"".equals(operatedTime)) {
      map.put("operatedTimeStart", DateFormatUtil.getDayFirstTime(operatedTime));
      map.put("operatedTimeEnd", DateFormatUtil.getDayLastTime(operatedTime));
    }
    map.put("operatedOrg", ThreadLocalUtil.threadLocal.get().getOperatedOrg());
    map.put("pageStart", page * pageSize);
    map.put("pageSize", pageSize);
    map.put("orderDirectionStr", Sort.Direction.DESC);

    return treatmentApplicationDAO.findTreatmentApplicationList(map);
  }

  @Override
  public int countTreatmentApplicationList(
      String insuredPersonName,
      String idCard,
      String securityNumber,
      String disease,
      String operatedTime,
      String applicationStatus) {
    Map<String, Object> map = new HashMap<>();
    map.put("insuredPersonName", insuredPersonName);
    map.put("idCard", idCard);
    map.put("securityNumber", securityNumber);
    map.put("disease", disease);
    map.put("operatedOrg", ThreadLocalUtil.threadLocal.get().getOperatedOrg());

    if (StringUtils.isNotBlank(applicationStatus)) {
      String[] arr = applicationStatus.split(",");
      map.put("applicationStatus", arr);
    }

    if (null != operatedTime && !"".equals(operatedTime)) {
      map.put("operatedTimeStart", DateFormatUtil.getDayFirstTime(operatedTime));
      map.put("operatedTimeEnd", DateFormatUtil.getDayLastTime(operatedTime));
    }
    return treatmentApplicationDAO.countTreatmentApplicationList(map);
  }
  /**
   * 根据待遇申请编号获取待遇申请详情信息
   *
   * @param applicationCode 待遇申请编号
   * @return
   */
  @Override
  @HystrixCommand
  public TreatmentApplicationDO getTreatmentApplication(String applicationCode) {
    TreatmentApplicationDO treatmentApplicationDo =
        treatmentApplicationDAO.findByTreatmentApplicationCode(applicationCode);

    if (treatmentApplicationDo == null) {
      throw new NotFoundByIdException("待遇申请编号[" + applicationCode + "]不存在对应待遇申请编号。");
    }
    //代理人身份证扫描件 deputyIdCardScan
    //    String deputyIdCardScan = treatmentApplicationDo.getDeputyIdCardScan();
    //    deputyIdCardScan = mongodbUtils.scanIdStrToJsonStr(deputyIdCardScan);
    //    treatmentApplicationDo.setDeputyIdCardScan(deputyIdCardScan);
    //社保卡扫描件 securityNumberScan
    //    String securityNumberScan = treatmentApplicationDo.getSecurityNumberScan();
    //    securityNumberScan = mongodbUtils.scanIdStrToJsonStr(securityNumberScan);
    //    treatmentApplicationDo.setSecurityNumberScan(securityNumberScan);
    //身份证扫描件  idCardScan
    //    String idCardScan = treatmentApplicationDo.getIdCardScan();
    //    idCardScan = mongodbUtils.scanIdStrToJsonStr(idCardScan);
    //    treatmentApplicationDo.setIdCardScan(idCardScan);
    //病例扫描件  caseHistoryScan
    //    String caseHistoryScan = treatmentApplicationDo.getCaseHistoryScan();
    //    caseHistoryScan = mongodbUtils.scanIdStrToJsonStr(caseHistoryScan);
    //    treatmentApplicationDo.setCaseHistoryScan(caseHistoryScan);
    //长护待遇申请表  applicationFormScan
    //    String applicationFormScan = treatmentApplicationDo.getApplicationFormScan();
    //    applicationFormScan = mongodbUtils.scanIdStrToJsonStr(applicationFormScan);
    //    treatmentApplicationDo.setApplicationFormScan(applicationFormScan);

    return treatmentApplicationDo;
  }

  /** 根据待遇申请 1、ApplicationLogDTO修改申请状态，记录日志表 2、发送mq--生成代办 */
  @Transactional
  @Override
  public int treatmentApplicationCase(ApplicationLogDTO logDto) {
    int updateResult = treatmentApplicationUpdate(logDto);
    if (updateResult > 0) {
      //代表待遇申请状态修改成功
      //发送mq
      //查询当前的申请状态
      TreatmentApplicationDO treatmentApplicationDo =
          treatmentApplicationDAO.findByTreatmentApplicationCode(logDto.getApplicationCode());
      treatmentApplicationCaseTodoAndRMQ(treatmentApplicationDo, logDto);
    }
    return updateResult;
  }

  /**
   * 根据待遇申请编号修改待遇申请状态
   *
   * @param applicationCode 待遇申请编号
   * @param applicationStatus 待遇申请状态
   * @return
   */
  @Override
  @Transactional
  public int treatmentApplicationUpdate(ApplicationLogDTO logDto) {
    logger.info(
        "====MobileTreatmentApplicationServiceImpl类：treatmentApplicationCase() ======= start:"
            + DateFormat.getLocalDateTime());
    if ("".equals(logDto.getApplicationCode()) || "".equals(logDto.getApplicationStatus())) {
      throw new ParametersIsNullException("请求参数不能为空！");
    }
    logger.info("参数:" + JSONObject.toJSONString(logDto));

    Map<String, Object> map = new HashMap<>();
    map.put("applicationCode", logDto.getApplicationCode());
    map.put("applicationStatus", logDto.getApplicationStatus());
    map.put("applicationReason", logDto.getApplicationReason());
    map.put("operatedBy", logDto.getOperatedBy());
    map.put("operatedTime", new Date());
    map.put("operatedOrg", logDto.getOperatedOrg());
    map.put("versionNow", logDto.getVersion());
    map.put("versionAfter", logDto.getVersion() + 1);

    //查询当前的申请状态
    TreatmentApplicationDO treatmentApplicationDo =
        treatmentApplicationDAO.findByTreatmentApplicationCode(logDto.getApplicationCode());
    if (treatmentApplicationDo == null) {
      throw new NotFoundByIdException("数据库中没有与待遇申请编号对应的待遇申请信息");
    }
    if (logDto.getApplicationStatus().equals(treatmentApplicationDo.getApplicationStatus())) {
      throw new NotFoundByIdException("此信息已经进行此操作，请勿重复操作!");
    } else if (ApplicationStatusEnum.ALREADY_ACCEPT
            .getValue()
            .equals(logDto.getApplicationStatus()) //修改的状态为受理
        && (ApplicationStatusEnum.PASS_ACCEPT
                .getValue()
                .equals(treatmentApplicationDo.getApplicationStatus()) //审核通过，受理不可以操作
            || ApplicationStatusEnum.NOT_PASS_ACCEPT
                .getValue()
                .equals(treatmentApplicationDo.getApplicationStatus()) //审核不通过，受理不可以操作
        )) {
      throw new NotFoundByIdException("此信息已经进行操作，请勿重复操作!");
    } else if (ApplicationStatusEnum.PASS_ACCEPT
            .getValue()
            .equals(logDto.getApplicationStatus()) //修改的状态为审核通过时
        && ApplicationStatusEnum.NOT_PASS_ACCEPT
            .getValue()
            .equals(treatmentApplicationDo.getApplicationStatus()) //审核不通过
    ) {
      throw new NotFoundByIdException("此信息已经进行审核不通过操作，请勿重复操作!");
    } else if (ApplicationStatusEnum.NOT_PASS_ACCEPT
            .getValue()
            .equals(logDto.getApplicationStatus()) //修改的状态为审核不通过时
        && ApplicationStatusEnum.PASS_ACCEPT
            .getValue()
            .equals(treatmentApplicationDo.getApplicationStatus()) //审核通过
    ) {
      throw new NotFoundByIdException("此信息已经进行审核通过操作，请勿重复操作!");
    }
    //修改待遇申请状态
    int result = treatmentApplicationDAO.updateApplicationStatusByApplicationCode(map);
    if (result > 0) {
      //插入待遇申请日志
      ApplicationLogDO applicationLogDO = new ApplicationLogDO();
      BeanUtils.copyProperties(logDto, applicationLogDO);
      applicationLogService.createApplicationLog(applicationLogDO);

      //若审核通过，则插入代理人绑定审核通过  默认代理人与参保人已绑定
      if (!StringUtils.isEmpty(treatmentApplicationDo.getSources())
          && SourcesEnum.MOBILE.getValue().equals(treatmentApplicationDo.getSources())
          && ApplicationStatusEnum.PASS_ACCEPT
              .getValue()
              .equals(treatmentApplicationDo.getApplicationStatus())) { //审核通过时
        insertDeputyBinding(treatmentApplicationDo);
      }
    } else {
      //代表没有修改成功，通过version并发控制住了
      throw new InsertRepeatException("记录已被他人操作，请刷新界面，重新选择数据！");
    }
    return result;
  }

  @Transactional
  public void insertDeputyBinding(TreatmentApplicationDO treatmentApplicationDo) {
    DeputyBindingDO deputyBindingDO = new DeputyBindingDO();

    //将文件存入mongoDB 返回id
    //获取代理人身份证扫描件id
    deputyBindingDO.setDeputyIdCardScan(treatmentApplicationDo.getDeputyIdCardScan());
    //获取社保卡扫描件附件id
    deputyBindingDO.setSecurityNumberScan(treatmentApplicationDo.getSecurityNumberScan());
    //获取身份证扫描件id
    deputyBindingDO.setIdCardScan(treatmentApplicationDo.getIdCardScan());
    //获取病例扫描件附件id
    deputyBindingDO.setCaseHistoryScan(treatmentApplicationDo.getCaseHistoryScan());
    //获取长护待遇申请表附件id
    deputyBindingDO.setApplicationFormScan(treatmentApplicationDo.getApplicationFormScan());

    //主键id
    deputyBindingDO.setDeputyBindingid(UUID.randomUUID().toString().replaceAll("-", ""));
    //参保人code
    deputyBindingDO.setIdCard(treatmentApplicationDo.getIdCard());
    deputyBindingDO.setSecurityNumber(treatmentApplicationDo.getSecurityNumber());
    deputyBindingDO.setDeputyIdCard(treatmentApplicationDo.getDeputyIdCard());
    deputyBindingDO.setDeputyMobile(treatmentApplicationDo.getDeputyMobile());
    deputyBindingDO.setDeputyName(treatmentApplicationDo.getDeputyName());
    deputyBindingDO.setInsuredPersonCode(treatmentApplicationDo.getInsuredPersonCode());
    //绑定审核表编号暂时写死
    deputyBindingDO.setDeputyBindingCode(UUID.randomUUID().toString().replaceAll("-", ""));
    // 待审核状态待审核 02 审核不通过01 审核通过03
    deputyBindingDO.setCheckState("03");
    //将参保人机构信息存入绑定表创建机构字段
    deputyBindingDO.setCreatedOrg(treatmentApplicationDo.getOperatedOrg());
    deputyBindingDO.setCreatedTime(new Date());
    //将参保人机构信息存入绑定表经办机构字段
    deputyBindingDO.setOperatedOrg(treatmentApplicationDo.getOperatedOrg());
    deputyBindingDO.setOperatedTime(new Date());
    deputyBindingDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
    deputyBindingDAO.insert(deputyBindingDO);
  }

  /**
   * 将待遇申请受理或审核通过则需要代办任务和发送消息，不需要实现事务处理
   *
   * @param treatmentApplicationDo
   * @param logDto
   */
  private void treatmentApplicationCaseTodoAndRMQ(
      TreatmentApplicationDO treatmentApplicationDo, ApplicationLogDTO logDto) {
    //给移动端发送更改待遇申请状态的消息
    treatmentApplicationCaseRMQ(
        treatmentApplicationDo,
        logDto.getApplicationStatus(),
        logDto.getApplicationCode(),
        logDto.getApplicationReason());
    //进入待办任务
    treatmentApplicationCaseTodo(
        treatmentApplicationDo, logDto.getApplicationStatus(), logDto.getApplicationCode());
  }

  /**
   * 待遇申请受理成功或审核通过后进入待办任务
   *
   * @param treatmentApplicationDo
   * @param applicationStatus
   * @param applicationCode
   */
  private void treatmentApplicationCaseTodo(
      TreatmentApplicationDO treatmentApplicationDo,
      String applicationStatus,
      String applicationCode) {
    // 调用新增待办提醒接口 创建代办信息
    if (ApplicationStatusEnum.ALREADY_ACCEPT.getValue().equals(applicationStatus)) {
      //待遇申请受理成功后，需要创建一个审核待办任务
      //首先删除申请受理代办任务
      TodoListDTO todoListDTOForDelete = new TodoListDTO();
      todoListDTOForDelete.setBusinessCode(applicationCode);
      todoListDTOForDelete.setBusinessType(ToDoListEnum.MOBILE_APPLY_DETAILS.getValue());
      todoListDTOForDelete.setCreatedOrg(treatmentApplicationDo.getCreatedOrg());
      todoListServerClient.deleteTodoList(todoListDTOForDelete);

      //创建审核代办任务
      TodoListDTO todoListDTO = new TodoListDTO();
      todoListDTO.setTitle(
          "参保人"
              + treatmentApplicationDo.getInsuredPersonName()
              + "待遇申请审核，待遇申请编号："
              + applicationCode);
      //url暂时未定 记得要拼接审核表id
      String ip = null;
      try {
        ip = IPUtil.getLocalIp();
      } catch (Exception e) {
        throw new ThrowsException("获取本地IP失败！" + e);
      }
      String port = "8090";
      String uri = "ltci-front-page/html/treatmentApply/dy_shenhe.html";
      String url = "http://" + ip + ":8090/ltci-front-page/html/treatmentApply/dy_shenhe.html";
      todoListDTO.setIp(ip);
      todoListDTO.setPort(port);
      todoListDTO.setUri(uri);
      todoListDTO.setUrl(url);
      todoListDTO.setBusinessCode(applicationCode);
      // 待遇申请审核类型
      todoListDTO.setBusinessType(ToDoListEnum.APPLY_ACCEPT_DETAILS.getValue());
      //类型 暂时写成代办01 提醒02
      todoListDTO.setType(ToDoListTypeEnum.TASK.getValue());
      // 讨论后暂时不要接收角色
      //todoListDO.setReceiveCharactar(deputyBindingDO.getOperatedBy());
      //创建人
      todoListDTO.setCreatedBy(treatmentApplicationDo.getCreatedBy());
      //创建机构
      todoListDTO.setCreatedOrg(treatmentApplicationDo.getCreatedOrg());
      //创建时间
      todoListDTO.setCreatedTime(
          DateFormatUtil.DateToStr(new Date(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS));
      // 跳转方式 新窗口中打开
      todoListDTO.setJumpWay("_blank");
      //行政区域暂时未存入
      logger.debug(
          "======将要生成代办信息todoListDO【" + JSONObject.toJSONString(todoListDTO) + "】=========");
      try {
        todoListServerClient.createTodoList(todoListDTO);
      } catch (Exception e) {
        logger.error("treatmentApplicationCaseTodo:待遇申请编号修改申请状态，创建待办任务失败。======= message:" + e);
      }
    } else if (ApplicationStatusEnum.PASS_ACCEPT.getValue().equals(applicationStatus)
        || ApplicationStatusEnum.NOT_PASS_ACCEPT.getValue().equals(applicationStatus)) {
      //      TodoListDOExample doExample = new TodoListDOExample();
      //      com.taikang.dic.ltci.model.TodoListDOExample.Criteria criteria = doExample.createCriteria();
      //      criteria.andBusinessCodeEqualTo(applicationCode);
      //      criteria.andBusinessTypeEqualTo(ToDoListEnum.APPLY_ACCEPT_DETAILS.getValue());
      //
      //      TodoListDO newTodoListDO = new TodoListDO();
      //      newTodoListDO.setIsValid(IsValidEnum.ALREADY_DELETE.getValue());
      TodoListDTO todoListDTO = new TodoListDTO();
      todoListDTO.setBusinessCode(applicationCode);
      todoListDTO.setBusinessType(ToDoListEnum.APPLY_ACCEPT_DETAILS.getValue());
      todoListDTO.setCreatedOrg(treatmentApplicationDo.getCreatedOrg());
      try {
        todoListServerClient.deleteTodoList(todoListDTO);
      } catch (Exception e) {
        logger.error("treatmentApplicationCaseTodo:待遇申请编号审核通过或不通过，逻辑删除待办任务失败。======= message:" + e);
      }
    }
  }

  /**
   * 待遇申请受理或审核后，则需要mq消息通知移动端
   *
   * @param treatmentApplicationDo
   * @param applicationStatus
   * @param applicationCode
   * @param applicationReason
   */
  private void treatmentApplicationCaseRMQ(
      TreatmentApplicationDO treatmentApplicationDo,
      String applicationStatus,
      String applicationCode,
      String applicationReason) {
    //新增rmq日志
    Map<String, Object> contentMap = new HashMap<>();
    contentMap.put("idCard", treatmentApplicationDo.getIdCard());
    contentMap.put("insuredPersonName", treatmentApplicationDo.getInsuredPersonName());
    contentMap.put("securityNumber", treatmentApplicationDo.getSecurityNumber());
    contentMap.put("deputyIdCard", treatmentApplicationDo.getDeputyIdCard());
    contentMap.put("deputyName", treatmentApplicationDo.getDeputyName());
    contentMap.put("applicationCode", treatmentApplicationDo.getApplicationCode());
    contentMap.put("applicationStatus", applicationStatus);
    contentMap.put("applicationReason", applicationReason);
    contentMap.put("operatedTime", System.currentTimeMillis());

    MQMessageLogDO mqLogDo = new MQMessageLogDO();
    mqLogDo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
    mqLogDo.setType(MqTypeEnum.SEND.getValue());
    mqLogDo.setSendTime(new Date());
    mqLogDo.setCreateTime(new Date());
    mqLogDo.setReSendNum(0L);
    mqLogDo.setSendState("0"); //成功
    mqLogDo.setExchangeName(exchangeName);
    mqLogDo.setQueueName(routingKey);

    MqBaseModel mqBaseModel = new MqBaseModel();
    mqBaseModel.setBusinessSerialid(UUID.randomUUID().toString());
    try {
      mqBaseModel.setNodeIP(IPUtil.getLocalIp());
    } catch (Exception e) {
      logger.error("错误信息：" + e);
      throw new ThrowsException("获取本地IP失败！");
    }
    mqBaseModel.setSystemCode(systemCode); //系统编码
    mqBaseModel.setData(contentMap);
    mqBaseModel.setModuleCode("treatmentApplicationCase"); //模块编码
    try {
      //发送rmq
      if (ApplicationStatusEnum.ALREADY_ACCEPT.getValue().equals(applicationStatus)
          || ApplicationStatusEnum.SUSPEND_ACCEPT.getValue().equals(applicationStatus)) {
        mqBaseModel.setMessageCode(messageCode1);
      } else if (ApplicationStatusEnum.PASS_ACCEPT.getValue().equals(applicationStatus)
          || ApplicationStatusEnum.NOT_PASS_ACCEPT.getValue().equals(applicationStatus)) {
        mqBaseModel.setMessageCode(messageCode2);
      }

      mqBaseModel.setTimestamp(DateFormat.getLocalDateTime());

      logger.debug(
          "====MobileTreatmentApplicationSenderServiceImpl send() ======= start:"
              + DateFormat.getLocalDateTime());
      /*sender.send(
      JSON.toJSONBytes(
          JSONObject.toJSONString(mqBaseModel), SerializerFeature.WriteMapNullValue));*/
      sender.send(JSON.toJSONBytes(mqBaseModel, SerializerFeature.WriteMapNullValue));
      logger.debug(
          "====MobileTreatmentApplicationSenderServiceImpl send() ======= end:"
              + DateFormat.getLocalDateTime());

      mqLogDo.setSendContent(JSON.toJSONString(mqBaseModel));
      logger.info("====MQMessageLogDO insert() ======= start:" + DateFormat.getLocalDateTime());
      mqMessageLogDAO.insert(mqLogDo);
      logger.info("====MQMessageLogDO insert() ======= end:" + DateFormat.getLocalDateTime());

    } catch (Exception e) {
      logger.error(
          "treatmentApplicationCase:待遇申请编号修改申请状态，消息通知移动端失败。======= end:"
              + DateFormat.getLocalDateTime());
      logger.error("treatmentApplicationCase:待遇申请编号修改申请状态，消息通知移动端失败。======= message:" + e);
      MqFailMessageLogDO failLog = new MqFailMessageLogDO();
      failLog.setId(mqBaseModel.getBusinessSerialid().replaceAll("-", ""));
      failLog.setTransportType(TransportTypeEnum.ASYNCHRONIZE.getValue()); //交互方式：异步
      failLog.setOperationType(OperationTypeEnum.SEND.getValue()); //发送类型
      failLog.setContent(JSONObject.toJSONString(mqBaseModel));
      failLog.setErrorMessage(e.getMessage());
      failLog.setCreateTime(new Date());
      failLog.setExchangeName(exchangeName);
      mqFailMessageLogDAO.insertSelective(failLog);
    }
  }

  @Override
  @Transactional
  public void createTreatmentApplication(TreatmentApplicationDTO dto) {
    String strInsuredPersonCode;
    //新增参保人信息
    InsuredPersonDO insuredPersonDO = getInsuredPersonDO(dto);

    String createdOrg = "";
    if (StringUtils.isNotBlank(dto.getCreatedOrg()) && dto.getCreatedOrg().length() > 6) {
      createdOrg = dto.getCreatedOrg().substring(6);
    }
    ResultDTO resultDTO =
        insuredPersonService.getInsuredPerson(
            dto.getIdCard(), dto.getInsuredPersonName(), createdOrg, dto.getCreatedBy());
    if (!StatusCodeEnum.OK.getValue().equals(resultDTO.getStatus())) {
      logger.debug(resultDTO.getMessage());
      throw new ThrowsException(resultDTO.getMessage());
    }
    InsuredPersonDTO insuredPerson = null;
    //状态是OK代表有这个参保人，状态不是OK代表没有这个参保人，需要新增
    if (resultDTO.getStatus().equals(StatusCodeEnum.OK.getValue())) {
      insuredPerson =
          JSONObject.parseObject(
              JSONObject.toJSONString(resultDTO.getDatas()), InsuredPersonDTO.class);
    }
    if (insuredPerson == null || StringUtils.isBlank(insuredPerson.getInsuredPersonCode())) {
      //为空的话代表没有当前参保人信息，需要新增
      String orgCode = "";
      if (insuredPerson != null) {
        orgCode = insuredPerson.getOrgCode();
      }
      if (StringUtils.isBlank(orgCode)) {
        throw new ThrowsException("参保人机构代码orgCode为空！");
      }
      ResultDTO organizationResultDTO = organizationServerClient.getBySocOrgCode(orgCode);
      if (organizationResultDTO == null
          || !StatusCodeEnum.OK.getValue().equals(organizationResultDTO.getStatus())
          || organizationResultDTO.getDatas() == null) {
        throw new ThrowsException("调用基础服务查询机构代码失败，未查询到对应机构编码！");
      }
      OrganizationDO organizationDO =
          JSONObject.parseObject(
              JSONObject.toJSONString(organizationResultDTO.getDatas()), OrganizationDO.class);

      insuredPersonDO.setOperatedOrg(organizationDO.getCode());
      dto.setOperatedOrg(organizationDO.getCode());
      strInsuredPersonCode = insuredPersonService.createInsuredPerson(insuredPersonDO);
      if (StringUtils.isBlank(strInsuredPersonCode)) {
        logger.debug("createTreatmentApplication：新增参保人过程出错，未返回参保人Code！");
        throw new NotFoundByIdException("新增参保人过程出错，未返回参保人Code！");
      }
    } else {
      //不为空则根据主键进行更新
      insuredPersonDO.setInsuredPersonid(insuredPerson.getInsuredPersonid());
      insuredPersonDO.setInsuredPersonCode(insuredPerson.getInsuredPersonCode());
      insuredPersonDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
      insuredPersonDO.setOperatedOrg(insuredPerson.getOperatedOrg());

      dto.setOperatedOrg(insuredPerson.getOperatedOrg());

      strInsuredPersonCode = insuredPersonService.updateInsuredPerson(insuredPersonDO);
      if (StringUtils.isBlank(strInsuredPersonCode)) {
        logger.debug("createTreatmentApplication：修改参保人过程出错，未返回参保人Code！");
        throw new NotFoundByIdException("修改参保人过程出错，未返回参保人Code！");
      }
    }

    //新增待遇申请表信息
    ApplicationDO applicationDO = getApplicationDO(dto);
    applicationDO.setInsuredPersonCode(strInsuredPersonCode);

    applicationDO.setSources(SourcesEnum.AGENCY.getValue());
    applicationDO.setApplicationStatus(ApplicationStatusEnum.ALREADY_ACCEPT.getValue());

    applicationDO.setIsValid(IsValidEnum.NO_DELETE.getValue());

    String strApplicationCode = applicationService.createApplication(applicationDO);
    if (StringUtils.isBlank(strApplicationCode)) {
      logger.debug("createTreatmentApplication：新增待遇申请过程出错，未返回待遇申请表Code！");
      throw new NotFoundByIdException("新增待遇申请过程出错，未返回待遇申请表Code！");
    }

    //新增待遇申请日志表信息
    ApplicationLogDO applicationLogDO = getApplicationLogDO(dto);
    applicationLogDO.setApplicationCode(strApplicationCode);
    applicationLogDO.setApplicationStatus(ApplicationStatusEnum.ALREADY_ACCEPT.getValue());
    applicationLogService.createApplicationLog(applicationLogDO);

    // 调用新增待办提醒接口 创建代办信息
    createToDoList(
        insuredPersonDO.getInsuredPersonName(),
        strApplicationCode,
        dto.getCreatedBy(),
        dto.getCreatedOrg());
  }

  private void createToDoList(
      String insuredPersonName, String strApplicationCode, String createdBy, String createdOrg) {
    // 调用新增待办提醒接口 创建代办信息
    TodoListDTO todoListDTO = new TodoListDTO();
    todoListDTO.setTitle("参保人" + insuredPersonName + "提交了一条待遇申请，请及时处理！");
    //url暂时未定 记得要拼接审核表id
    String ip = null;
    try {
      ip = IPUtil.getLocalIp();
    } catch (Exception e) {
      logger.error("错误信息：" + e);
      throw new ThrowsException("获取本地IP失败！");
    }
    todoListDTO.setIp(ip);
    todoListDTO.setPort("");
    todoListDTO.setUri("");
    todoListDTO.setUrl("");
    todoListDTO.setBusinessCode(strApplicationCode);
    //PC端传递过来的业务类型暂时写死
    todoListDTO.setBusinessType(ToDoListEnum.APPLY_ACCEPT_DETAILS.getValue());
    //类型 暂时写成代办01 提醒02
    todoListDTO.setType(ToDoListTypeEnum.TASK.getValue());
    //讨论后暂时不要接收角色
    //todoListDO.setReceiveCharactar(deputyBindingDO.getOperatedBy());
    //创建人
    todoListDTO.setCreatedBy(createdBy);
    //创建机构
    todoListDTO.setCreatedOrg(createdOrg);
    // 跳转方式 新窗口中打开
    todoListDTO.setJumpWay("_blank");
    //行政区域暂时未存入
    logger.debug("======将要生成代办信息todoListDO【" + JSONObject.toJSONString(todoListDTO) + "】=========");

    todoListServerClient.createTodoList(todoListDTO);
  }

  /**
   * 将待遇申请多字段DTO转换为ApplicationDTO
   *
   * @param dto
   * @return
   */
  private ApplicationLogDO getApplicationLogDO(TreatmentApplicationDTO dto) {
    ApplicationLogDO applicationLogDO = new ApplicationLogDO();

    applicationLogDO.setSecurityNumber(dto.getSecurityNumber());
    applicationLogDO.setSecurityPersonalNumber(dto.getSecurityPersonalNumber());
    applicationLogDO.setDeputyIdCard(dto.getDeputyIdCard());
    applicationLogDO.setApplicationStatus(dto.getApplicationStatus());

    applicationLogDO.setCreatedBy(dto.getCreatedBy());
    applicationLogDO.setCreatedOrg(dto.getCreatedOrg());

    applicationLogDO.setOperatedBy(dto.getCreatedBy());
    applicationLogDO.setOperatedOrg(dto.getCreatedOrg());

    applicationLogDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
    return applicationLogDO;
  }

  /**
   * 将待遇申请多字段DTO转换为ApplicationDTO
   *
   * @param dto
   * @return
   */
  private ApplicationDO getApplicationDO(TreatmentApplicationDTO dto) {
    ApplicationDO applicationDO = new ApplicationDO();

    applicationDO.setMobile(dto.getMobile());
    applicationDO.setAddress(dto.getAddress());

    applicationDO.setDeputyName(dto.getDeputyName());
    applicationDO.setDeputyIdType(dto.getDeputyIdType());
    applicationDO.setDeputyIdCard(dto.getDeputyIdCard());
    applicationDO.setDeputyIdCardScan(dto.getDeputyIdCardScan());
    applicationDO.setDeputyMobile(dto.getDeputyMobile());
    applicationDO.setDeputyAddress(dto.getDeputyAddress());

    applicationDO.setBidType(dto.getBidType());
    applicationDO.setDisease(dto.getDisease());
    applicationDO.setIsTaskDeadline(dto.getIsTaskDeadline());
    applicationDO.setIsRelativeCared(dto.getIsRelativeCared());
    applicationDO.setDiseaseCause(dto.getDiseaseCause());

    applicationDO.setSecurityNumberScan(dto.getSecurityNumberScan());
    applicationDO.setIdCardScan(dto.getIdCardScan());
    applicationDO.setCaseHistoryScan(dto.getCaseHistoryScan());
    applicationDO.setApplicationFormScan(dto.getApplicationFormScan());
    applicationDO.setSources(dto.getSources());

    applicationDO.setApplicationStatus(ApplicationStatusEnum.ALREADY_ACCEPT.getValue());

    applicationDO.setRemark(dto.getRemark());
    applicationDO.setCreatedBy(dto.getCreatedBy());
    applicationDO.setCreatedOrg(dto.getCreatedOrg());
    applicationDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
    applicationDO.setSiArea(dto.getSiArea());

    applicationDO.setOperatedBy(dto.getCreatedBy());
    applicationDO.setOperatedOrg(dto.getCreatedOrg());

    return applicationDO;
  }

  /**
   * 将待遇申请多字段DTO转换为InsuredPersonDTO
   *
   * @param dto
   * @return
   */
  private InsuredPersonDO getInsuredPersonDO(TreatmentApplicationDTO dto) {
    InsuredPersonDO personDO = new InsuredPersonDO();

    personDO.setInsuredPersonName(dto.getInsuredPersonName());
    personDO.setInsuredPersonGender(dto.getInsuredPersonGender());
    personDO.setNation(dto.getNation());

    personDO.setBirthday(
        DateFormatUtil.StrToDate(dto.getBirthday(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
    personDO.setSecurityNumber(dto.getSecurityNumber());
    personDO.setSecurityPersonalNumber(dto.getSecurityPersonalNumber());
    personDO.setIdCard(dto.getIdCard());
    personDO.setPersonnelIdentityCode(dto.getPersonnelIdentityCode());
    personDO.setPersonnelIdentityName(dto.getPersonnelIdentityName());

    personDO.setMobile(dto.getMobile());
    personDO.setAddress(dto.getAddress());
    personDO.setEmail(dto.getEmail());
    personDO.setOrgName(dto.getOrgName());
    personDO.setMarried(dto.getMarried());
    personDO.setEducationid(dto.getEducationid());

    personDO.setPoliticsid(dto.getPoliticsid());
    personDO.setOccupationid(dto.getOccupationid());
    personDO.setProvinceCode(dto.getProvinceCode());
    personDO.setCityCode(dto.getCityCode());
    personDO.setAreaCode(dto.getAreaCode());
    personDO.setOrgCode(dto.getOrgCode());
    personDO.setSiArea(dto.getSiArea());

    personDO.setOperatedBy(dto.getCreatedBy());
    personDO.setOperatedOrg(dto.getCreatedOrg());

    personDO.setCreatedBy(dto.getCreatedBy());
    personDO.setCreatedOrg(dto.getCreatedOrg());

    personDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
    return personDO;
  }

  @Override
  @Transactional
  public ResultDTO createMobileTreatmentApplication(TreatmentApplicationDO treatmentApplicationDO) {
    Map<String, Object> map = new HashMap<>();
    ResultDTO resultDTO = new ResultDTO();
    if (StringUtils.isNotBlank(treatmentApplicationDO.getApplicationCode())) {

      logger.info("start:代理人身份证号附件deputyIdCardScanList：");
      List<String> deputyIdCardScanList =
          JSONObject.parseArray(treatmentApplicationDO.getDeputyIdCardScan(), String.class);
      String deputyIdCardScan = getMediaFileIDsByList(deputyIdCardScanList);

      logger.info("start:社保卡编号附件securityNumberScanList：");
      List<String> securityNumberScanList =
          JSONObject.parseArray(treatmentApplicationDO.getSecurityNumberScan(), String.class);
      String securityNumberScan = getMediaFileIDsByList(securityNumberScanList);

      logger.info("start:参保人身份证附件idCardScanList：");
      List<String> idCardScanList =
          JSONObject.parseArray(treatmentApplicationDO.getIdCardScan(), String.class);
      String idCardScan = getMediaFileIDsByList(idCardScanList);

      logger.info("start:病例附件caseHistoryScanList：");
      List<String> caseHistoryScanList =
          JSONObject.parseArray(treatmentApplicationDO.getCaseHistoryScan(), String.class);
      String caseHistoryScan = getMediaFileIDsByList(caseHistoryScanList);

      //修改待遇申请表信息
      ApplicationDO applicationDO = new ApplicationDO();
      applicationDO.setDeputyIdCardScan(deputyIdCardScan);
      applicationDO.setIdCardScan(idCardScan);
      applicationDO.setCaseHistoryScan(caseHistoryScan);
      applicationDO.setSecurityNumberScan(securityNumberScan);

      applicationDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
      logger.info("移动端待遇申请附件上传实体：" + JSONObject.toJSONString(applicationDO));

      ApplicationDOExample doExample = new ApplicationDOExample();
      com.taikang.dic.ltci.model.ApplicationDOExample.Criteria criteria =
          doExample.createCriteria();
      criteria.andApplicationCodeEqualTo(treatmentApplicationDO.getApplicationCode());

      int size = applicationDAO.updateByExampleSelective(applicationDO, doExample);

      if (size > 0) {
        map.put("applicationCode", treatmentApplicationDO.getApplicationCode());
        resultDTO.setStatus(StatusCodeEnum.CREATED.getValue());
        resultDTO.setDatas(map);
        return resultDTO;
      } else {
        resultDTO.setStatus(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
        resultDTO.setMessage("附件信息保存失败，没有与附件对应的待遇申请信息！");
        return resultDTO;
      }
    }

    String uniqueNumber = "99999";
    String operator = "mobile";
    if (StringUtils.isNotEmpty(treatmentApplicationDO.getOperatedOrg())
        && treatmentApplicationDO.getOperatedOrg().length() > 6) {
      uniqueNumber = treatmentApplicationDO.getOperatedOrg().substring(6);
    }
    if (StringUtils.isNotEmpty(treatmentApplicationDO.getOperatedBy())) {
      operator = treatmentApplicationDO.getOperatedBy();
    }

    resultDTO =
        insuredPersonService.getInsuredPerson(
            treatmentApplicationDO.getIdCard(),
            treatmentApplicationDO.getInsuredPersonName(),
            uniqueNumber,
            operator);
    if (resultDTO == null) {
      logger.debug("createTreatmentApplication：调用待遇申请微服务查询参保人过程出错！");
      throw new ThrowsException("调用待遇申请微服务查询参保人过程出错！");
    }

    String strInsuredPersonCode;
    InsuredPersonDTO insuredPersonDTO = null;
    //新增参保人信息
    InsuredPersonDO insuredPersonDO = getInsuredPersonDO(treatmentApplicationDO);

    //状态是OK代表有这个参保人，状态不是OK代表没有这个参保人，需要新增
    if (resultDTO.getStatus().equals(StatusCodeEnum.OK.getValue())) {
      insuredPersonDTO =
          JSONObject.parseObject(
              JSONObject.toJSONString(resultDTO.getDatas()), InsuredPersonDTO.class);
    }
    if (insuredPersonDTO == null) {
      throw new NotFoundByIdException("查询社保局接口获取数据为空！");
    } else if (StringUtils.isBlank(insuredPersonDTO.getInsuredPersonCode())) {
      //经办机构或创建机构为空的时候查询机构人员微服务
      if (StringUtils.isBlank(insuredPersonDTO.getOrgCode())) {
        throw new ThrowsException("参保人机构代码orgCode为空！");
      }
      ResultDTO organizationResultDTO =
          organizationServerClient.getBySocOrgCode(insuredPersonDTO.getOrgCode());
      if (organizationResultDTO == null
          || !StatusCodeEnum.OK.getValue().equals(organizationResultDTO.getStatus())
          || organizationResultDTO.getDatas() == null) {
        throw new ThrowsException("调用基础服务查询机构代码失败，未查询到对应机构编码！");
      }

      OrganizationDO organizationDO =
          JSONObject.parseObject(
              JSONObject.toJSONString(organizationResultDTO.getDatas()), OrganizationDO.class);

      //为空的话代表没有当前参保人信息，需要新增
      insuredPersonDO.setSecurityNumber(insuredPersonDTO.getSecurityNumber());
      insuredPersonDO.setBirthday(
          DateFormatUtil.StrToDate(
              insuredPersonDTO.getBirthday(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      insuredPersonDO.setNation(insuredPersonDTO.getNation());
      insuredPersonDO.setSiArea(insuredPersonDTO.getSiArea());
      insuredPersonDO.setOrgCode(insuredPersonDTO.getOrgCode());
      insuredPersonDO.setSecurityPersonalNumber(insuredPersonDTO.getSecurityPersonalNumber());

      insuredPersonDO.setCreatedOrg(organizationDO.getCode());
      insuredPersonDO.setOperatedOrg(organizationDO.getCode());

      insuredPersonDTO.setCreatedOrg(organizationDO.getCode());
      insuredPersonDTO.setOperatedOrg(organizationDO.getCode());

      treatmentApplicationDO.setSiArea(insuredPersonDTO.getSiArea());

      strInsuredPersonCode = insuredPersonService.createInsuredPerson(insuredPersonDO);
      if (StringUtils.isBlank(strInsuredPersonCode)) {
        logger.debug("createTreatmentApplication：新增参保人过程出错，未返回参保人Code！");
        throw new NotFoundByIdException("新增参保人过程出错，未返回参保人Code！");
      }
    } else {
      //不为空则根据主键进行更新
      insuredPersonDO.setInsuredPersonid(insuredPersonDTO.getInsuredPersonid());
      insuredPersonDO.setInsuredPersonCode(insuredPersonDTO.getInsuredPersonCode());
      insuredPersonDO.setIsValid(IsValidEnum.NO_DELETE.getValue());

      insuredPersonDO.setOperatedOrg(insuredPersonDTO.getOperatedOrg());

      treatmentApplicationDO.setSiArea(insuredPersonDTO.getSiArea());

      strInsuredPersonCode = insuredPersonService.updateInsuredPerson(insuredPersonDO);
      if (StringUtils.isBlank(strInsuredPersonCode)) {
        logger.debug("createTreatmentApplication：修改参保人过程出错，未返回参保人Code！");
        throw new NotFoundByIdException("修改参保人过程出错，未返回参保人Code！");
      }
    }

    //新增待遇申请表信息
    ApplicationDO applicationDO = getApplicationDO(treatmentApplicationDO);
    applicationDO.setInsuredPersonCode(strInsuredPersonCode);
    applicationDO.setApplicationFormScan("");

    applicationDO.setSources(SourcesEnum.MOBILE.getValue());
    applicationDO.setApplicationStatus(ApplicationStatusEnum.NO_ACCEPT.getValue());

    //创建机构存入参保人所在机构
    applicationDO.setCreatedBy(insuredPersonDTO.getCreatedBy());
    applicationDO.setCreatedOrg(insuredPersonDTO.getCreatedOrg());

    applicationDO.setOperatedBy(insuredPersonDTO.getOperatedBy());
    applicationDO.setOperatedOrg(insuredPersonDTO.getOperatedOrg());
    //统筹区
    applicationDO.setSiArea(treatmentApplicationDO.getSiArea());

    applicationDO.setIsValid(IsValidEnum.ALREADY_DELETE.getValue());

    String strApplicationCode = applicationService.createApplication(applicationDO);

    //新增待遇申请日志表信息
    ApplicationLogDO applicationLogDO = getApplicationLogDO(treatmentApplicationDO);
    applicationLogDO.setApplicationCode(strApplicationCode);
    applicationLogDO.setApplicationStatus(ApplicationStatusEnum.NO_ACCEPT.getValue());
    applicationLogService.createApplicationLog(applicationLogDO);

    // 调用新增待办提醒接口 创建代办信息
    TodoListDTO todoListDTO = new TodoListDTO();
    todoListDTO.setTitle(
        "参保人"
            + insuredPersonDO.getInsuredPersonName()
            + "与代理人"
            + applicationDO.getDeputyName()
            + "绑定审批");
    //url暂时未定 记得要拼接审核表id
    String ip = null;
    try {
      ip = IPUtil.getLocalIp();
    } catch (Exception e) {
      throw new ThrowsException("获取本地IP失败！" + e);
    }
    String port = "8090";
    String uri = "ltci-front-page/html/treatmentApply/dy_shenhe.html";
    String url = "http://" + ip + ":8090/ltci-front-page/html/treatmentApply/dy_shenhe.html";
    todoListDTO.setIp(ip);
    todoListDTO.setPort(port);
    todoListDTO.setUri(uri);
    todoListDTO.setUrl(url);
    todoListDTO.setBusinessCode(strApplicationCode);
    // 移动端传递过来的业务类型暂时写死
    todoListDTO.setBusinessType(ToDoListEnum.MOBILE_APPLY_DETAILS.getValue());
    //类型 暂时写成代办01 提醒02
    todoListDTO.setType(ToDoListTypeEnum.TASK.getValue());
    // 讨论后暂时不要接收角色
    //todoListDO.setReceiveCharactar(deputyBindingDO.getOperatedBy());
    //创建人
    todoListDTO.setCreatedBy(insuredPersonDTO.getCreatedBy());
    //创建机构 参保人所在机构跟 跟application表中创建机构一致
    todoListDTO.setCreatedOrg(insuredPersonDTO.getCreatedOrg());
    //创建时间
    todoListDTO.setCreatedTime(
        DateFormatUtil.DateToStr(new Date(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS));
    // 跳转方式 新窗口中打开
    todoListDTO.setJumpWay("_blank");
    //行政区域暂时未存入
    logger.debug("======将要生成代办信息todoListDO【" + JSONObject.toJSONString(todoListDTO) + "】=========");

    todoListServerClient.createTodoList(todoListDTO);

    map.put("applicationCode", strApplicationCode);
    resultDTO.setStatus(StatusCodeEnum.CREATED.getValue());
    resultDTO.setDatas(map);
    return resultDTO;
  }

  /**
   * 调用mediaFile的接口，存储文件流
   *
   * @return
   */
  private String uploadToMediaFile(String base64) {
    if (StringUtils.isBlank(base64)) {
      return "";
    }
    AttachmentDTO dto = new AttachmentDTO();
    dto.setFileName("");
    dto.setSuffix("");
    dto.setFileType(FileTypeEnum.PICTURE.getValue());
    dto.setContent(base64);
    ResultDTO resultDTO = attachmentServiceClient.addAttachment(dto);
    if (resultDTO == null || !StatusCodeEnum.CREATED.getValue().equals(resultDTO.getStatus())) {
      throw new ThrowsException("新增附件失败，新增附件微服务报错！");
    }
    JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(resultDTO.getDatas()));
    return jsonObject.getString("attachmentid");
  }

  /**
   * 调用mediaFile的接口，存储文件，获取全部ID
   *
   * @return
   */
  private String getMediaFileIDsByList(List<String> list) {
    StringBuilder sb = new StringBuilder();
    String strFileIds = "";
    if (list == null || list.isEmpty()) {
      logger.info("End 附件listSize为空！");
      return strFileIds;
    }
    logger.info("End 附件listSize为" + list.size() + "！");
    for (String base64 : list) {
      if (StringUtils.isBlank(base64)) {
        continue;
      }
      sb.append("," + uploadToMediaFile(base64));
    }
    if (sb.length() > 0) {
      strFileIds = sb.substring(1);
    }
    return strFileIds;
  }

  /**
   * 将待遇申请多字段DTO转换为ApplicationDTO
   *
   * @param dto
   * @return
   */
  private ApplicationLogDO getApplicationLogDO(TreatmentApplicationDO treatmentApplicationDO) {
    ApplicationLogDO applicationLogDO = new ApplicationLogDO();

    applicationLogDO.setSecurityNumber(treatmentApplicationDO.getSecurityNumber());
    applicationLogDO.setSecurityPersonalNumber(treatmentApplicationDO.getSecurityPersonalNumber());
    applicationLogDO.setDeputyIdCard(treatmentApplicationDO.getDeputyIdCard());

    applicationLogDO.setApplicationStatus(treatmentApplicationDO.getApplicationStatus());

    applicationLogDO.setCreatedBy(treatmentApplicationDO.getCreatedBy());

    return applicationLogDO;
  }

  /**
   * 将待遇申请多字段DTO转换为ApplicationDTO
   *
   * @param dto
   * @return
   */
  private ApplicationDO getApplicationDO(TreatmentApplicationDO treatmentApplicationDO) {
    ApplicationDO applicationDO = new ApplicationDO();

    if (StringUtils.isBlank(treatmentApplicationDO.getDeputyName())) {
      applicationDO.setDeputyName(treatmentApplicationDO.getInsuredPersonName());
      applicationDO.setDeputyIdType("");
      applicationDO.setDeputyIdCard(treatmentApplicationDO.getIdCard());
      applicationDO.setDeputyMobile(treatmentApplicationDO.getMobile());
    } else {
      applicationDO.setDeputyName(treatmentApplicationDO.getDeputyName());
      applicationDO.setDeputyIdType(treatmentApplicationDO.getDeputyIdType());
      applicationDO.setDeputyIdCard(treatmentApplicationDO.getDeputyIdCard());
      applicationDO.setDeputyMobile(treatmentApplicationDO.getDeputyMobile());
      applicationDO.setDeputyAddress(treatmentApplicationDO.getDeputyAddress());
    }
    applicationDO.setMobile(treatmentApplicationDO.getMobile());
    applicationDO.setAddress(treatmentApplicationDO.getAddress());

    applicationDO.setBidType(treatmentApplicationDO.getBidType());
    applicationDO.setDisease(treatmentApplicationDO.getDisease());

    if (StringUtils.isBlank(treatmentApplicationDO.getIsTaskDeadline())) {
      applicationDO.setIsTaskDeadline(IsTaskDeadline.NO_TASKDEADLINE.getValue());
    } else {
      applicationDO.setIsTaskDeadline(treatmentApplicationDO.getIsTaskDeadline());
    }

    if (StringUtils.isBlank(treatmentApplicationDO.getIsRelativeCared())) {
      applicationDO.setIsRelativeCared(IsRelativeCaredEnum.NO.getValue());
    } else {
      applicationDO.setIsRelativeCared(treatmentApplicationDO.getIsRelativeCared());
    }

    applicationDO.setDiseaseCause(treatmentApplicationDO.getDiseaseCause());

    applicationDO.setCreatedBy(treatmentApplicationDO.getCreatedBy());
    applicationDO.setCreatedOrg(treatmentApplicationDO.getCreatedOrg());

    applicationDO.setSiArea(treatmentApplicationDO.getSiArea());
    applicationDO.setOperatedBy(treatmentApplicationDO.getOperatedBy());
    applicationDO.setOperatedOrg(treatmentApplicationDO.getOperatedOrg());

    return applicationDO;
  }

  /**
   * 将待遇申请多字段DTO转换为InsuredPersonDTO
   *
   * @param dto
   * @return
   */
  private InsuredPersonDO getInsuredPersonDO(TreatmentApplicationDO treatmentApplicationDO) {
    InsuredPersonDO personDO = new InsuredPersonDO();

    personDO.setInsuredPersonName(treatmentApplicationDO.getInsuredPersonName());
    personDO.setInsuredPersonGender(treatmentApplicationDO.getInsuredPersonGender());
    personDO.setNation(treatmentApplicationDO.getNation());

    personDO.setBirthday(treatmentApplicationDO.getBirthday());
    personDO.setSecurityNumber(treatmentApplicationDO.getSecurityNumber());
    personDO.setSecurityPersonalNumber(treatmentApplicationDO.getSecurityPersonalNumber());
    personDO.setIdCard(treatmentApplicationDO.getIdCard());
    personDO.setPersonnelIdentityCode(treatmentApplicationDO.getPersonnelIdentityCode());
    personDO.setPersonnelIdentityName(treatmentApplicationDO.getPersonnelIdentityName());

    personDO.setMobile(treatmentApplicationDO.getMobile());
    personDO.setAddress(treatmentApplicationDO.getAddress());
    personDO.setEmail(treatmentApplicationDO.getEmail());
    personDO.setOrgName(treatmentApplicationDO.getOrgName());
    personDO.setMarried(treatmentApplicationDO.getMarried());
    personDO.setEducationid(treatmentApplicationDO.getEducationid());

    personDO.setPoliticsid(treatmentApplicationDO.getPoliticsid());
    personDO.setOccupationid(treatmentApplicationDO.getOccupationid());
    personDO.setProvinceCode(treatmentApplicationDO.getProvinceCode());
    personDO.setCityCode(treatmentApplicationDO.getCityCode());
    personDO.setAreaCode(treatmentApplicationDO.getAreaCode());

    return personDO;
  }

  /** 批量受理 */
  @Transactional
  @Override
  public ResultDTO batchTreatmentApplicationCase(String applicationSpecialDO) {
    logger.debug(applicationSpecialDO);

    List<ApplicationSpecialDO> dtos = new ArrayList<ApplicationSpecialDO>();
    dtos = JSONArray.parseArray(applicationSpecialDO, ApplicationSpecialDO.class);

    logger.debug("封装完成");
    //1、循环调用修改状态和记录日志表
    for (ApplicationSpecialDO dto : dtos) {
      ApplicationLogDTO applicationLogDTO = new ApplicationLogDTO();
      BeanUtils.copyProperties(dto, applicationLogDTO);
      treatmentApplicationUpdate(applicationLogDTO);
    }
    //2、循环调用和发送mq
    for (ApplicationSpecialDO dto : dtos) {
      ApplicationLogDTO applicationLogDTO = new ApplicationLogDTO();
      BeanUtils.copyProperties(dto, applicationLogDTO);
      TreatmentApplicationDO treatmentApplicationDo =
          treatmentApplicationDAO.findByTreatmentApplicationCode(dto.getApplicationCode());
      treatmentApplicationCaseTodoAndRMQ(treatmentApplicationDo, applicationLogDTO);
    }
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());
    resultDTO.setMessage("批量审核成功！");
    return resultDTO;
  }
}
