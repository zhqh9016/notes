package com.taikang.dic.ltci.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.AttachmentDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.ActionTypeEnum;
import com.taikang.dic.ltci.common.enumeration.AgencyStateEnum;
import com.taikang.dic.ltci.common.enumeration.IsValidEnum;
import com.taikang.dic.ltci.common.enumeration.ObjectTypeEnum;
import com.taikang.dic.ltci.common.enumeration.OperationTypeEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.enumeration.TransportTypeEnum;
import com.taikang.dic.ltci.common.exception.ThrowsException;
import com.taikang.dic.ltci.common.util.DateFormat;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.common.util.Encodes;
import com.taikang.dic.ltci.common.util.FileTypeDecideUtil;
import com.taikang.dic.ltci.common.util.IPUtil;
import com.taikang.dic.ltci.common.util.SpringContextUtil;
import com.taikang.dic.ltci.common.util.UUIDUtil;
import com.taikang.dic.ltci.common.util.UrlUtil;
import com.taikang.dic.ltci.controller.StaffHistoryController;
import com.taikang.dic.ltci.dao.AgencyDAO;
import com.taikang.dic.ltci.dao.StaffDAO;
import com.taikang.dic.ltci.dao.StaffHistoryDAO;
import com.taikang.dic.ltci.model.AgencyDO;
import com.taikang.dic.ltci.model.AgencyDOExample;
import com.taikang.dic.ltci.model.AgencyStaffFileRDO;
import com.taikang.dic.ltci.model.BaseModel;
import com.taikang.dic.ltci.model.MqFailMessageLogDO;
import com.taikang.dic.ltci.model.StaffDO;
import com.taikang.dic.ltci.model.StaffDOExample;
import com.taikang.dic.ltci.model.StaffFieldConstant;
import com.taikang.dic.ltci.model.StaffHistoryDO;
import com.taikang.dic.ltci.model.StaffHistoryDOExample;
import com.taikang.dic.ltci.model.StaffHistoryDOExample.Criteria;
import com.taikang.dic.ltci.mqmodel.MqBaseModel;
import com.taikang.dic.ltci.serverClient.AttachmentServiceClient;
import com.taikang.dic.ltci.service.IAgencyStaffFileService;
import com.taikang.dic.ltci.service.IMqFailMessageLogService;
import com.taikang.dic.ltci.service.IMqMessageLogService;
import com.taikang.dic.ltci.service.IStaffInterfaceService;

/**
 * 人员信息监听及发送接口
 *
 * @author itw_zhangqh
 */
@Service
public class StaffInterfaceServiceImpl implements IStaffInterfaceService {

  private static char[] org = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

  private Logger logger = LoggerFactory.getLogger(StaffInterfaceServiceImpl.class);

  @Autowired private IMqMessageLogService messageLogService;
  @Autowired private IMqFailMessageLogService failMessageLogService;
  @Autowired private UrlUtil urlUtil;
  @Autowired private StaffHistoryDAO staffHistoryDAO;
  @Autowired private SpringContextUtil springContextUtil;
  @Autowired private AgencyDAO agencyDAO;
  @Autowired private AttachmentServiceClient attachmentServiceClient;
  @Autowired private IAgencyStaffFileService agencyStaffFileService;
  @Autowired private StaffDAO staffDAO;

  @Autowired private AmqpTemplate rabbitTemplate;

  private static final String ROUTING_KEY = "jingmen";

  @Value("${systemCode}")
  private String systemCode;

  @Value("${systemCharset}")
  private String systemCharset;

  //人员信息申请和变更接口编码
  @Value("${ltci.personApply.messageCode}")
  private String personApplyMessageCode;

  @Value("${ltci.personApply.queue}")
  private String personApplyQueueName;

  //人员信息受理告知接口
  @Value("${ltci.personAcceptResult.queue}")
  private String personAcceptResultQueueName;

  @Value("${ltci.personAcceptResult.exechange}")
  private String personAcceptResultExechange;

  @Value("${ltci.personAcceptResult.messageCode}")
  private String personAcceptResultMessageCode;

  //人员信息审核告知接口
  @Value("${ltci.personApproveResult.queue}")
  private String personApproveResultQueueName;

  @Value("${ltci.personApproveResult.exechange}")
  private String personApproveResultExechange;

  @Value("${ltci.personApproveResult.messageCode}")
  private String personApproveResultMessageCode;

  //人员信息变更告知接口
  @Value("${ltci.personChangeApproveResult.queue}")
  private String personChangeApproveResultQueueName;

  @Value("${ltci.personChangeApproveResult.exechange}")
  private String personChangeApproveResultExechange;

  @Value("${ltci.personChangeApproveResult.messageCode}")
  private String personChangeApproveResultMessageCode;
  /*
   *
   * 监听人员信息申请及变更消息
   */
  @RabbitListener(queues = "${ltci.personApply.queue}")
  @Override
  public void receiveStaff(byte[] bytes) {
    logger.info("=======进入StaffInterfaceServiceImpl getReconsiderReceive方法=========");
    String message = null;
    try {
      message = new String(bytes, systemCharset);
    } catch (UnsupportedEncodingException e) {
      logger.error(e.getMessage(), e);
      return;
    }
    //    logger.info("=======mq消息队列监听到的消息Message【" + message + "】=========");
    //调用处理逻辑
    parseMessage(message);
  }

  /**
   * 处理rmq接收到的消息
   *
   * @param message
   */
  @Override
  public void parseMessage(String message) {
    //转成格式为MqBaseModel
    MqBaseModel mqBaseModel = JSONObject.parseObject(message, MqBaseModel.class);
    try {

      //通过messageCode判断是否为人员信息申请及变更消息
      if (personApplyMessageCode.equals(mqBaseModel.getMessageCode())) {

        //首先通过id和type到日志表中查询数据 避免消息重复消费
        boolean has = messageLogService.isHas(mqBaseModel.getBusinessSerialid());
        if (has) {
          logger.info("======此id【" + mqBaseModel.getBusinessSerialid() + "】信息已经监听处理=============");
          return;
        }

        //获取人员申请或变更信息
        JSONObject data = JSONObject.parseObject(String.valueOf(mqBaseModel.getData()));

        StaffHistoryDO staffHistory = data2StaffHistory(data);
        staffHistory.setIsValid(IsValidEnum.NO_DELETE.getValue());

        //====填充机构名称====
        String agencyName = null;
        String agencyCode = staffHistory.getAgencyCode();
        agencyName = getAgencyNameByCode(agencyCode);
        staffHistory.setAgencyName(agencyName);

        //====根据不同的操作类型做处理(1.申请,2.变更,3.注销)
        String actionType = staffHistory.getActionType();
        if (StringUtils.isBlank(actionType)
            || StringUtils.isBlank(staffHistory.getCredentialNumber())) {
          throw new RuntimeException("操作类型和证件号码不能为空");
        }

        StaffInterfaceServiceImpl bean =
            springContextUtil.getApplicationContext().getBean(StaffInterfaceServiceImpl.class);

        //===新增人员的逻辑
        if (ActionTypeEnum.CREATE.getValue().equals(actionType)) {

          //新增人员需要判断该人员是否为重复申请,判断依据是该用户(以身份证为依据)是否存在申请流程未结束的申请记录(即处于待受理和待审核的记录)
          if (checkStaffAuditState(staffHistory)) {
            staffHistory.setAuditState(AgencyStateEnum.STATE_NO_ACCEPT.getValue());
            staffHistory.setCreatedTime(new Date());
            staffHistory.setOperatedTime(new Date());
            staffHistory.setStaffCode(generateStaffCode(staffHistory));
            //向人员历史表和消息历史表中插入数据,并保存附件信息
            bean.saveStaffHistory4Add(
                mqBaseModel.getBusinessSerialid(), staffHistory, message, data);
          }
        }
        //===修改人员的逻辑
        if (ActionTypeEnum.UPDATE.getValue().equals(actionType)) {
          staffHistory.setAuditState(AgencyStateEnum.STATE_ACCEPT.getValue());
          bean.saveStaffHistory4Update(
              mqBaseModel.getBusinessSerialid(), staffHistory, message, data);
        }

        //===注销人员的逻辑
        if (ActionTypeEnum.DELETE.getValue().equals(actionType)) {
          staffHistory.setAuditState(AgencyStateEnum.STATE_AUDIT.getValue());
          staffHistory.setOperatedTime(new Date());
          //直接删除
          bean.saveStaffHistory4Delete(mqBaseModel.getBusinessSerialid(), staffHistory, message);
        }

        logger.info("=====监听mq人员申请/变更信息完成==========");
      }
    } catch (Exception e) {
      //存储异常日志
      logger.error("===监听mq人员申请/变更信息异常===", e);
      if (StringUtils.isNotBlank(mqBaseModel.getBusinessSerialid())) {
        MqFailMessageLogDO failLog = new MqFailMessageLogDO();
        failLog.setId(mqBaseModel.getBusinessSerialid());
        failLog.setTransportType(TransportTypeEnum.ASYNCHRONIZE.getValue()); //交互方式：异步
        failLog.setOperationType(OperationTypeEnum.RECEIVE.getValue()); //发送接收类型
        failLog.setQueryName(personApplyQueueName);
        failLog.setContent(message);
        failLog.setErrorMessage(e.getMessage());
        failLog.setCreateTime(new Date());
        failLog.setHttpAction(HttpMethod.POST.name());
        // 添加重试url
        failLog.setRetryUrl(urlUtil.getBaseUrl() + StaffHistoryController.RETRY_URL);
        failMessageLogService.saveOrUpdateFailLog(failLog);
      }
    }
  }

  /** 人员注销保存 */
  @Override
  @Transactional
  public void saveStaffHistory4Delete(
      String businessSerialid, StaffHistoryDO staffHistory, String message) {

    //保存消息日志
    messageLogService.receiveMqMessageLog(businessSerialid, personApplyQueueName, message);
    String staffCode = staffHistory.getStaffCode();
    //如果对端没有传staffCode,直接返回,不做任何处理
    if (StringUtils.isBlank(staffCode)) {
      return;
    }

    //根据人员编码更新人员信息表中的有效字段为无效
    StaffDO record = new StaffDO();
    record.setIsValid(IsValidEnum.ALREADY_DELETE.getValue());

    StaffDOExample example = new StaffDOExample();
    com.taikang.dic.ltci.model.StaffDOExample.Criteria createCriteria = example.createCriteria();
    createCriteria.andStaffCodeEqualTo(staffCode);
    staffDAO.updateByExampleSelective(record, example);

    //向人员历史表中插入一条记录
    List<StaffDO> selectByExample = staffDAO.selectByExample(example);
    if (!CollectionUtils.isEmpty(selectByExample)) {
      StaffDO staffDO = selectByExample.get(0);

      String jsonString = JSONObject.toJSONString(staffDO);
      StaffHistoryDO parseObject = JSONObject.parseObject(jsonString, StaffHistoryDO.class);

      parseObject.setActionType(staffHistory.getActionType());
      parseObject.setCreatedBy(staffHistory.getCreatedBy());
      parseObject.setCreatedTime(staffHistory.getCreatedTime());
      parseObject.setAuditState(staffHistory.getAuditState());
      //向人员历史记录中插入一条信息
      parseObject.setSerialNo(UUIDUtil.getUUID());
      staffHistoryDAO.insert(parseObject);
    }
  }

  /** 人员变更保存 */
  @Override
  @Transactional
  public void saveStaffHistory4Update(
      String businessSerialid, StaffHistoryDO staffHistory, String message, JSONObject data) {
    //保存消息日志
    messageLogService.receiveMqMessageLog(businessSerialid, personApplyQueueName, message);

    //向人员历史记录中插入一条信息
    staffHistory.setSerialNo(UUIDUtil.getUUID());
    staffHistoryDAO.insert(staffHistory);
    //收到变更申请后立即给专业端发送人员变更受理告知
    String jsonString = JSONObject.toJSONString(staffHistory);
    StaffHistoryDO parseObject = JSONObject.parseObject(jsonString, StaffHistoryDO.class);
    parseObject.setAuditState(AgencyStateEnum.STATE_ACCEPT.getValue());
    parseObject.setOperatedTime(new Date());
    sendAcceptResult(parseObject);
  }
  /** 人员申请保存 */
  @Transactional
  @Override
  public void saveStaffHistory4Add(
      String businessSerialid, StaffHistoryDO staffHistory, String message, JSONObject data) {
    //保存消息日志
    messageLogService.receiveMqMessageLog(businessSerialid, personApplyQueueName, message);

    //向人员历史记录中插入一条信息
    staffHistory.setSerialNo(UUIDUtil.getUUID());
    staffHistoryDAO.insert(staffHistory);

    //保存附件信息
    saveAdditional(data, staffHistory.getStaffCode(), staffHistory.getSerialNo());
  }
  /**
   * 根据机构编码获取机构名称
   *
   * @param agencyCode
   * @return
   */
  private String getAgencyNameByCode(String agencyCode) {
    AgencyDOExample agencyExample = new AgencyDOExample();
    com.taikang.dic.ltci.model.AgencyDOExample.Criteria agencyCriteria =
        agencyExample.createCriteria();
    agencyCriteria.andAgencyCodeEqualTo(agencyCode);
    List<AgencyDO> agencyList = agencyDAO.selectByExample(agencyExample);
    if (!CollectionUtils.isEmpty(agencyList)) {
      AgencyDO agencyDO = agencyList.get(0);
      return agencyDO.getAgencyName();
    }
    return null;
  }

  /**
   * 生成一个人员编码,规则是机构编码+4位随机数, 但生成之前先去库里面查看该人员是否已经有编码存在, 如果有,使用原来的编码
   *
   * @param staffHistory
   * @return
   */
  private String generateStaffCode(StaffHistoryDO staffHistory) {
    //先去库中查询该用户是否已经存在
    StaffHistoryDOExample example = new StaffHistoryDOExample();
    Criteria criteria = example.createCriteria();
    //身份证
    criteria.andCredentialNumberEqualTo(staffHistory.getCredentialNumber());

    List<StaffHistoryDO> staffHistoryList = staffHistoryDAO.selectByExample(example);
    if (!CollectionUtils.isEmpty(staffHistoryList)) {
      return staffHistoryList.get(0).getStaffCode();
    }

    //如果不存在,生成一个人员编码
    String agencyCode = staffHistory.getAgencyCode();
    String regionCode = "";
    if (StringUtils.isNotBlank(agencyCode) && agencyCode.length() > 6) {
      regionCode = agencyCode.substring(0, 6);
    }
    String randomCode = generateRandomCode(regionCode);
    while (true) {
      StaffHistoryDOExample _example = new StaffHistoryDOExample();
      Criteria _criteria = _example.createCriteria();
      _criteria.andStaffCodeEqualTo(randomCode);
      List<StaffHistoryDO> selectByExample = staffHistoryDAO.selectByExample(_example);
      if (CollectionUtils.isEmpty(selectByExample)) {
        break;
      }
      randomCode = generateRandomCode(regionCode);
    }

    return randomCode;
  }

  private String generateRandomCode(String prefix) {
    StringBuffer sb = new StringBuffer(prefix);
    SecureRandom random = new SecureRandom();
    for (int i = 0; i < 4; i++) {
      sb.append(org[random.nextInt(org.length)]);
    }
    return sb.toString();
  }

  /**
   * 判断当前人员是否存在未结束的申请流程
   *
   * @param staffHistory
   * @return
   */
  public boolean checkStaffAuditState(StaffHistoryDO staffHistory) {
    StaffHistoryDOExample example = new StaffHistoryDOExample();
    Criteria criteria = example.createCriteria();
    //身份证
    criteria.andCredentialNumberEqualTo(staffHistory.getCredentialNumber());
    //审核状态
    List<Integer> values = new ArrayList<>();
    values.add(AgencyStateEnum.STATE_NO_ACCEPT.getValue());
    values.add(AgencyStateEnum.STATE_ACCEPT.getValue());
    criteria.andAuditStateIn(values);

    List<StaffHistoryDO> staffHistoryList = staffHistoryDAO.selectByExample(example);
    if (CollectionUtils.isEmpty(staffHistoryList)) {
      return true;
    }
    return false;
  }

  private StaffHistoryDO data2StaffHistory(JSONObject data) {
    StaffHistoryDO staffHistory = new StaffHistoryDO();

    staffHistory.setActionType(data.getString(StaffFieldConstant.ACTIONTYPE));
    staffHistory.setEmpCode(data.getString(StaffFieldConstant.EMPCODE));
    staffHistory.setStaffCode(data.getString(StaffFieldConstant.UNIQUENUMBER));
    staffHistory.setStaffName(data.getString(StaffFieldConstant.EMPNAME));
    staffHistory.setAgencyCode(data.getString(StaffFieldConstant.ORGCODE));
    staffHistory.setCredentialType(data.getInteger(StaffFieldConstant.CARDTYPE));
    staffHistory.setCredentialNumber(data.getString(StaffFieldConstant.CARDNUMBER));
    staffHistory.setStaffGender(data.getInteger(StaffFieldConstant.GENDER));
    staffHistory.setStaffPhone(data.getString(StaffFieldConstant.STAFF_PHONE));
    staffHistory.setDiplomaDate(data.getDate(StaffFieldConstant.DIPLOMA_DATE));
    staffHistory.setDegreeDate(data.getDate(StaffFieldConstant.DEGREE_DATE));
    staffHistory.setHighestEducation(data.getString(StaffFieldConstant.HIGHESTEDUCATION));
    staffHistory.setAcquireDegree(data.getString(StaffFieldConstant.ACQUIREDDEGREE));
    staffHistory.setStaffLevel(data.getString("staffLevel"));
    staffHistory.setCategory(data.getString("category"));
    staffHistory.setJobScope(data.getString(StaffFieldConstant.JOBSCOPE));
    staffHistory.setRemark(data.getString(StaffFieldConstant.COMMENT));
    staffHistory.setCreatedBy(data.getString(StaffFieldConstant.OPERATOR));
    staffHistory.setCreatedTime(data.getDate(StaffFieldConstant.OPERATINGTIME));

    return staffHistory;
  }

  /** 受理结果告知 */
  @Override
  public void sendAcceptResult(StaffHistoryDO staffHistory) {
    SimpleDateFormat format = new SimpleDateFormat(DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
    Map<String, String> map = new HashMap<>();
    map.put(StaffFieldConstant.EMPCODE, staffHistory.getEmpCode());
    map.put(StaffFieldConstant.EMPNAME, staffHistory.getStaffName());
    map.put(StaffFieldConstant.GENDER, staffHistory.getStaffGender().toString());
    map.put(StaffFieldConstant.CARDTYPE, staffHistory.getCredentialType().toString());
    map.put(StaffFieldConstant.CARDNUMBER, staffHistory.getCredentialNumber());
    map.put(StaffFieldConstant.ACCEPT_DATE, format.format(staffHistory.getOperatedTime()));
    map.put(StaffFieldConstant.STATE, staffHistory.getAuditState().toString());
    map.put(StaffFieldConstant.REASON, staffHistory.getCause());

    MqBaseModel mqBaseModel = getMqBaseModel();
    mqBaseModel.setMessageCode(personAcceptResultMessageCode);
    mqBaseModel.setData(map);
    String jsonString = JSONObject.toJSONString(mqBaseModel);
    //记录日志
    messageLogService.sendMqMessageLog(0L, "0", jsonString, personAcceptResultExechange, null);
    //发送至mq routingKey 是 “jingmen”,不是queryName
    try {
      rabbitTemplate.convertAndSend(
          personAcceptResultExechange, ROUTING_KEY, jsonString.getBytes(systemCharset));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
      logger.error("指定的编码格式不支持", e);
    }
  }

  /** 申请审核结果告知 如果审核不通过,不传经办端生成的人员ID */
  @Override
  public void sendApproveResult(StaffHistoryDO staffHistory) {
    SimpleDateFormat format = new SimpleDateFormat(DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
    Map<String, String> map = new HashMap<>();
    map.put(StaffFieldConstant.EMPCODE, staffHistory.getEmpCode());
    map.put(StaffFieldConstant.EMPNAME, staffHistory.getStaffName());
    map.put(StaffFieldConstant.GENDER, staffHistory.getStaffGender().toString());
    map.put(StaffFieldConstant.CARDTYPE, staffHistory.getCredentialType().toString());
    map.put(StaffFieldConstant.CARD_NUM, staffHistory.getCredentialNumber());
    map.put(StaffFieldConstant.CHECK_DATE, format.format(staffHistory.getOperatedTime()));
    map.put(StaffFieldConstant.AUDIT_STATE, staffHistory.getAuditState().toString());
    map.put(StaffFieldConstant.REJECTION_REASON, staffHistory.getCause());

    //如果审核通过,设置经办端生成的人员编号
    if (AgencyStateEnum.STATE_AUDIT.getValue().equals(staffHistory.getAuditState())) {
      map.put(StaffFieldConstant.SUPERVISEDID, staffHistory.getStaffCode());
    }

    MqBaseModel mqBaseModel = getMqBaseModel();
    mqBaseModel.setMessageCode(personApproveResultMessageCode);
    mqBaseModel.setData(map);
    String jsonString = JSONObject.toJSONString(mqBaseModel);
    //记录日志
    messageLogService.sendMqMessageLog(0L, "0", jsonString, personApproveResultExechange, null);
    //发送至mq routingKey 是 “jingmen”,不是queryName
    try {
      rabbitTemplate.convertAndSend(
          personApproveResultExechange, ROUTING_KEY, jsonString.getBytes(systemCharset));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
      logger.error("指定的编码格式不支持", e);
    }
  }

  /** 变更审核结果告知 */
  @Override
  public void sendChangeApproveResult(StaffHistoryDO staffHistory) {
    SimpleDateFormat format = new SimpleDateFormat(DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
    Map<String, String> map = new HashMap<>();
    map.put(StaffFieldConstant.EMPCODE, staffHistory.getEmpCode());
    map.put(StaffFieldConstant.CHECK_DATE, format.format(staffHistory.getOperatedTime()));
    map.put(StaffFieldConstant.STATE, staffHistory.getAuditState().toString());
    map.put(StaffFieldConstant.REJECTION_REASON, staffHistory.getCause());

    MqBaseModel mqBaseModel = getMqBaseModel();
    mqBaseModel.setMessageCode(personChangeApproveResultMessageCode);
    mqBaseModel.setData(map);
    String jsonString = JSONObject.toJSONString(mqBaseModel);
    //记录日志
    messageLogService.sendMqMessageLog(
        0L, "0", jsonString, personChangeApproveResultExechange, null);
    //发送至mq routingKey 是 “jingmen”,不是queryName
    try {
      rabbitTemplate.convertAndSend(
          personChangeApproveResultExechange, ROUTING_KEY, jsonString.getBytes(systemCharset));
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
      logger.error("指定的编码格式不支持", e);
    }
  }

  private MqBaseModel getMqBaseModel() {
    MqBaseModel mqBaseModel = new MqBaseModel();
    mqBaseModel.setBusinessSerialid(BaseModel.getUUID());
    mqBaseModel.setTimestamp(DateFormat.getLocalDateTime());
    try {
      mqBaseModel.setNodeIP(IPUtil.getLocalIp());
    } catch (Exception e) {
      logger.error("获取本地IP失败：" + e);
    }
    mqBaseModel.setSystemCode(systemCode);
    return mqBaseModel;
  }
  //存储附件
  private void saveAdditional(JSONObject data, String staffCode, String staffHistoryId) {
    JSONArray jsonArray = data.getJSONArray(StaffFieldConstant.CREDENTIALS);
    if (jsonArray != null) {

      //遍历每一个证书
      for (int i = 0; i < jsonArray.size(); i++) {
        JSONObject json = jsonArray.getJSONObject(i);
        Integer obj_type = ObjectTypeEnum.STAFF.getValue(); //机构还是人员
        String code = staffCode; //人员编号
        StringBuffer file_ids = new StringBuffer(); //资源表id
        Integer is_valid = IsValidEnum.NO_DELETE.getValue(); //是否有效
        String accessory_type = json.getString(StaffFieldConstant.CREDENTIAL_TYPE); //证书类型
        String credential_name = json.getString(StaffFieldConstant.CREDENTIAL_NAME); //证书名称
        String credential_level = json.getString(StaffFieldConstant.CREDENTIAL_LEVEL); //证书等级
        Date credential_date = json.getDate(StaffFieldConstant.CREDENTIAL_DATE); //发证日期
        String credential_code = json.getString(StaffFieldConstant.CREDENTIAL_CODE); //证书编码
        JSONArray files = json.getJSONArray(StaffFieldConstant.FILE);
        if (files != null) {
          //保存证书的附件,比如身份证可能有多个附件,所以这里需要进行遍历.
          for (int j = 0; j < files.size(); j++) {
            JSONObject fileJson = files.getJSONObject(j);

            String fileType =
                FileTypeDecideUtil.getFileType(
                    fileJson.getString(StaffFieldConstant.FILE_TYPE)); //文件类型(音频/视频/图片)
            String file_name = fileJson.getString(StaffFieldConstant.FILE_NAME); //文件名
            String file_suffix = fileJson.getString(StaffFieldConstant.FILE_TYPE); //文件格式
            //将附件保存到文件微服务器中.
            AttachmentDTO attachmentDTO = new AttachmentDTO();
            attachmentDTO.setFileType(fileType);
            attachmentDTO.setFileName(file_name);
            attachmentDTO.setSuffix(file_suffix);
            attachmentDTO.setContent(
                Encodes.encodeBase64(fileJson.getBytes(StaffFieldConstant.ACCESSORY_INFO)));
            ResultDTO result = attachmentServiceClient.addAttachment(attachmentDTO);
            if (result == null || !result.getStatus().equals(StatusCodeEnum.CREATED.getValue())) {
              throw new ThrowsException("调用媒体文件微服务端保存文件失败！");
            }
            JSONObject jsonObject =
                JSONObject.parseObject(JSONObject.toJSONString(result.getDatas()));
            String file_id = jsonObject.getString("attachmentid");
            file_ids.append(",").append(file_id); //.append("_").append(file_suffix);
          }
        }

        //将文件id字符串中第一个逗号去掉
        String string = file_ids.toString();
        String replaceFirst = "";
        if (string.startsWith(",")) {
          replaceFirst = string.replaceFirst(",", "");
        } else {
          replaceFirst = file_ids.toString();
        }

        //向机构人员附件表中插入数据
        AgencyStaffFileRDO agencyStaffFileRDO = new AgencyStaffFileRDO();

        agencyStaffFileRDO.setAccessoryType(accessory_type);
        agencyStaffFileRDO.setCredentialCode(credential_code);
        agencyStaffFileRDO.setCredentialLevel(credential_level);
        agencyStaffFileRDO.setCredentialDate(credential_date);
        agencyStaffFileRDO.setCredentialName(credential_name);
        agencyStaffFileRDO.setCode(code);
        agencyStaffFileRDO.setFileId(replaceFirst);
        agencyStaffFileRDO.setIsValid(is_valid);
        agencyStaffFileRDO.setObjType(obj_type);
        agencyStaffFileRDO.setId(UUIDUtil.getUUID());
        agencyStaffFileRDO.setHistoryId(staffHistoryId);

        agencyStaffFileService.insertAgencyStaffFile(agencyStaffFileRDO);
      }
    }
  }
}
