package com.taikang.dic.ltci.service.impl;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.AgencyDTO;
import com.taikang.dic.ltci.api.model.AgencyHistoryDTO;
import com.taikang.dic.ltci.api.model.AttachmentDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.ActionTypeEnum;
import com.taikang.dic.ltci.common.enumeration.AgencyStateEnum;
import com.taikang.dic.ltci.common.enumeration.ExecutionStatusEnum;
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
import com.taikang.dic.ltci.common.util.UrlUtil;
import com.taikang.dic.ltci.controller.AgencyHistoryController;
import com.taikang.dic.ltci.dao.AgencyHistoryDAO;
import com.taikang.dic.ltci.dao.AgencyStaffFileRDAO;
import com.taikang.dic.ltci.model.AgencyHistoryDO;
import com.taikang.dic.ltci.model.AgencyHistoryDOExample;
import com.taikang.dic.ltci.model.AgencyHistoryDOExample.Criteria;
import com.taikang.dic.ltci.model.AgencyStaffFileRDO;
import com.taikang.dic.ltci.model.BaseModel;
import com.taikang.dic.ltci.model.MqFailMessageLogDO;
import com.taikang.dic.ltci.mqmodel.AgencyInterfaceParam;
import com.taikang.dic.ltci.mqmodel.MqBaseModel;
import com.taikang.dic.ltci.serverClient.AttachmentServiceClient;
import com.taikang.dic.ltci.service.IAgencyInterfaceService;
import com.taikang.dic.ltci.service.IMqFailMessageLogService;
import com.taikang.dic.ltci.service.IMqMessageLogService;
/**
 * 机构 和专业系统接口service ，有申请、变更、受理通知、审核通知、变更审核通知
 *
 * @author itw_muwg
 */
@Service
public class AgencyInterfaceServiceImpl implements IAgencyInterfaceService {

  private Logger logger = LoggerFactory.getLogger(AgencyInterfaceServiceImpl.class);

  @Autowired private RabbitTemplate rabbitTemplate;
  @Autowired private AgencyHistoryDAO agencyHistoryDao;
  @Autowired private AgencyStaffFileRDAO agencyStaffFileRDAO;
  @Autowired private IMqMessageLogService messageLogService;
  @Autowired private IMqFailMessageLogService failMessageLogService;
  @Autowired private UrlUtil urlUtil;
  @Autowired private AttachmentServiceClient attachmentServiceClient;
  @Autowired private SpringContextUtil springContextUtil;
  private static char[] org = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
  private static final String ROUTING_KEY = "jingmen";

  @Value("${systemCharset}")
  private String systemCharset;

  @Value("${systemCode}")
  private String systemCode;

  //机构新增、变更query
  @Value("${ltci.orgApplication.queue}")
  private String orgApplicationQueueName;
  //机构新增、变更消息编码
  @Value("${ltci.orgApplication.messageCode}")
  private String orgApplicationMessageCode;

  //机构申请受理告知exchange
  @Value("${ltci.orgAcceptResult.exchange}")
  private String orgAcceptResultExchange;
  //机构申请受理告知消息编码
  @Value("${ltci.orgAcceptResult.messageCode}")
  private String orgAcceptResultMessageCode;

  //机构申请审核告知exchange
  @Value("${ltci.orgApproveResult.exchange}")
  private String orgApproveResultExchange;
  //机构申请审核告知消息编码
  @Value("${ltci.orgApproveResult.messageCode}")
  private String orgApproveResultMessageCode;

  //机构变更审核告知exchange
  @Value("${ltci.orgChangeResult.exchange}")
  private String orgChangeResultExchange;
  //机构变更审核告知消息编码
  @Value("${ltci.orgChangeResult.messageCode}")
  private String orgChangeResultMessageCode;

  /**
   * 机构申请、变更mq接收（专业服务->经办） mq监听
   *
   * @author itw_muwg
   */
  @RabbitListener(queues = "${ltci.orgApplication.queue}")
  @Override
  public void getorgApplication(byte[] bytes) {
    logger.debug("=======进入ReconsiderServiceImpl getReconsiderReceive方法=========");
    String message = null;
    try {
      message = new String(bytes, systemCharset);
    } catch (UnsupportedEncodingException e) {
      logger.error(e.getMessage(), e);
      return;
    }
    logger.info("=======mq " + orgApplicationQueueName + "消息队列监听到的消息=========");
    //调用处理逻辑
    parseMessage(message);
  }

  /**
   * 处理获取的数据
   *
   * @param message
   */
  @Override
  public int parseMessage(String message) {
    //转成格式为MqBaseModel
    MqBaseModel mqBaseModel = JSONObject.parseObject(message, MqBaseModel.class);
    try {
      //通过判断messageCode筛选信息
      if (orgApplicationMessageCode.equals(mqBaseModel.getMessageCode())) {
        //首先通过id和type到日志表中查询数据 判重复
        boolean has = messageLogService.isHas(mqBaseModel.getBusinessSerialid());
        if (has) {
          logger.info("======此id【" + mqBaseModel.getBusinessSerialid() + "】信息已经监听处理=============");
          return ExecutionStatusEnum.SUCCESS.getValue();
        }
        //存储申请信息
        JSONObject data = JSONObject.parseObject(String.valueOf(mqBaseModel.getData()));
        String areaCode = getAreaCode(data);
        if (ActionTypeEnum.CREATE
                .getValue()
                .equals(data.getString(AgencyInterfaceParam.ACTION_TYPE))
            && StringUtils.isBlank(areaCode)) {
          logger.info(
              "======此id【" + mqBaseModel.getBusinessSerialid() + "】机构参数没有所在区域信息=============");
          return ExecutionStatusEnum.SUCCESS.getValue();
        }
        //转成机构申请DO
        AgencyHistoryDO agencyHistoryDO = data2AgencyHistoryDO(data);
        //查询机构临时表中是否已经有该条数据
        AgencyHistoryDOExample example = new AgencyHistoryDOExample();
        Criteria criteria = example.createCriteria();
        criteria.andOrgCodeEqualTo(agencyHistoryDO.getOrgCode());
        List<Integer> states = new ArrayList<>();
        states.add(AgencyStateEnum.STATE_NO_ACCEPT.getValue());
        states.add(AgencyStateEnum.STATE_ACCEPT.getValue());
        criteria.andAgencyStateIn(states);
        List<AgencyHistoryDO> list = agencyHistoryDao.selectByExample(example);
        //通过spring获得代理bean，事务正常执行
        AgencyInterfaceServiceImpl bean =
            springContextUtil.getApplicationContext().getBean(AgencyInterfaceServiceImpl.class);
        //存储基础信息
        if (list != null && list.isEmpty()) {
          //存储基础信息
          bean.saveOrg(mqBaseModel.getBusinessSerialid(), data, agencyHistoryDO, message);
        }

        logger.info("=====监听mq接收 机构申请、变更 信息完成==========");
      }
      return ExecutionStatusEnum.SUCCESS.getValue();
    } catch (Exception e) {
      //存储异常日志
      logger.error("===监听mq接收机构申请、变更信息异常===", e);
      if (StringUtils.isNotBlank(mqBaseModel.getBusinessSerialid())) {
        MqFailMessageLogDO failLog = new MqFailMessageLogDO();
        failLog.setId(mqBaseModel.getBusinessSerialid());
        failLog.setTransportType(TransportTypeEnum.ASYNCHRONIZE.getValue()); //交互方式：异步
        failLog.setOperationType(OperationTypeEnum.RECEIVE.getValue()); //发送接收类型
        failLog.setQueryName(orgApplicationQueueName);
        failLog.setContent(message);
        failLog.setErrorMessage(e.getMessage());
        failLog.setCreateTime(new Date());
        failLog.setHttpAction(HttpMethod.POST.name());
        // 添加重试url
        failLog.setRetryUrl(urlUtil.getBaseUrl() + AgencyHistoryController.RETRY_URL);
        failMessageLogService.saveOrUpdateFailLog(failLog);
      }
      return ExecutionStatusEnum.FAILD.getValue();
    }
  }

  @Transactional
  public void saveOrg(
      String businessSerialid, JSONObject data, AgencyHistoryDO agencyHistoryDO, String message) {
    //先将监听到的数据存入日志表
    messageLogService.receiveMqMessageLog(businessSerialid, orgApplicationQueueName, message);
    agencyHistoryDao.insertSelective(agencyHistoryDO);
    //如果是新增申请，存储附件信息
    if (ActionTypeEnum.CREATE.getValue().equals(data.getString(AgencyInterfaceParam.ACTION_TYPE))
        && data.getJSONArray(AgencyInterfaceParam.ACCESSORY) != null) {
      saveAccessory(data, agencyHistoryDO);
    }
    if (ActionTypeEnum.UPDATE.getValue().equals(data.getString(AgencyInterfaceParam.ACTION_TYPE))) {
      //是变更，直接发送 已受理结果给专业
      AgencyHistoryDTO agencyHistory = new AgencyHistoryDTO();
      agencyHistory.setOrgCode(agencyHistoryDO.getOrgCode());
      agencyHistory.setOperatedTime(DateFormatUtil.dateToTimeStr(new Date()));
      agencyHistory.setAgencyState(AgencyStateEnum.STATE_ACCEPT.getValue());
      sendOrgAcceptResult(agencyHistory);
    }
  }

  private void saveAccessory(JSONObject data, AgencyHistoryDO agencyHistoryDO) {

    JSONArray jsonArray = data.getJSONArray(AgencyInterfaceParam.ACCESSORY);
    for (int i = 0; i < jsonArray.size(); i++) {
      JSONObject json = jsonArray.getJSONObject(i);
      String fileType =
          FileTypeDecideUtil.getFileType(json.getString(AgencyInterfaceParam.FILE_TYPE));

      AttachmentDTO dto = new AttachmentDTO();
      dto.setContent(Encodes.encodeBase64(json.getBytes(AgencyInterfaceParam.ACCESSORY_INFO)));
      dto.setFileName(json.getString(AgencyInterfaceParam.FILE_NAME));
      dto.setSuffix(json.getString(AgencyInterfaceParam.FILE_TYPE));
      dto.setFileType(fileType);

      ResultDTO resultDTO = attachmentServiceClient.addAttachment(dto);
      if (resultDTO == null || !resultDTO.getStatus().equals(StatusCodeEnum.CREATED.getValue())) {
        throw new ThrowsException("调用媒体文件微服务端保存文件失败！");
      }
      JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(resultDTO.getDatas()));
      String fileId = jsonObject.getString("attachmentid");
      AgencyStaffFileRDO agencyStaffFile = new AgencyStaffFileRDO();
      agencyStaffFile.setId(BaseModel.getUUID());
      agencyStaffFile.setAccessoryType(json.getString(AgencyInterfaceParam.ACCESSORY_TYPE));
      agencyStaffFile.setObjType(ObjectTypeEnum.ORG.getValue());
      agencyStaffFile.setCode(agencyHistoryDO.getAgencyCode());
      agencyStaffFile.setHistoryId(agencyHistoryDO.getSerialNum());
      agencyStaffFile.setFileId(fileId);
      agencyStaffFile.setFileName(json.getString(AgencyInterfaceParam.FILE_NAME));
      agencyStaffFile.setFileType(json.getString(AgencyInterfaceParam.FILE_TYPE));
      agencyStaffFile.setIsValid(IsValidEnum.NO_DELETE.getValue());
      agencyStaffFileRDAO.insertSelective(agencyStaffFile);
    }
  }

  private String getAreaCode(JSONObject data) {
    String areaCode = data.getString(AgencyInterfaceParam.AREA_CODE);
    if (StringUtils.isBlank(areaCode)) {
      areaCode = data.getString(AgencyInterfaceParam.CITY_CODE);
    }
    if (StringUtils.isBlank(areaCode)) {
      areaCode = data.getString(AgencyInterfaceParam.PROVINCE_CODE);
    }
    return areaCode;
  }

  private AgencyHistoryDO data2AgencyHistoryDO(JSONObject data) {
    AgencyHistoryDO agencyHistory = new AgencyHistoryDO();
    /** 操作类型（1:新增、2:变更；变更时只传有变化的项目值) */
    agencyHistory.setActionType(data.getString(AgencyInterfaceParam.ACTION_TYPE));
    /** 机构编号（专业服务系统内部编号) */
    agencyHistory.setOrgCode(data.getString(AgencyInterfaceParam.ORG_CODE));
    /** 监管唯一认证ID，由经办生成，新增时为空,变更时必传 */
    agencyHistory.setAgencyCode(data.getString(AgencyInterfaceParam.UNIQUE_NUMBER));
    /** 机构名称 */
    agencyHistory.setAgencyName(data.getString(AgencyInterfaceParam.ORG_NAME));
    /** 所在省份编码 */
    agencyHistory.setProvinceCode(data.getString(AgencyInterfaceParam.PROVINCE_CODE));
    /** 所在城市编码 */
    agencyHistory.setCityCode(data.getString(AgencyInterfaceParam.CITY_CODE));
    /** 所在区县编码 */
    agencyHistory.setAreaCode(data.getString(AgencyInterfaceParam.AREA_CODE));
    /** 机构详细地址 */
    agencyHistory.setAgencyAddressDetail(
        data.getString(AgencyInterfaceParam.AGENCY_ADDRESSD_DETAIL));
    /** 机构类别（单选）(1、一级及以上医疗机构;2、养老、护理机构;3、社区卫生服务中心;4、乡镇卫生院;99、其他) */
    agencyHistory.setAgencyLevel(data.getInteger(AgencyInterfaceParam.ORG_LEVEL));
    /** 机构类型(00、护理;10、评估) */
    agencyHistory.setAgencyType(data.getString(AgencyInterfaceParam.ORG_TYPE));
    /** 定点服务机构类型(多选)(1、居家护理;2、养老机构护理;3、医院护理) 因专业选择评估时不传，所以自己判断加上4、评估 */
    if (data.getString(AgencyInterfaceParam.ORG_TYPE) != null
        && data.getString(AgencyInterfaceParam.ORG_TYPE).contains("10")) {
      agencyHistory.setAgencyServiceType(
          data.getString(AgencyInterfaceParam.ORG_SERVICE_TYPE) == null
              ? "4"
              : data.getString(AgencyInterfaceParam.ORG_SERVICE_TYPE) + ",4");
    } else {
      agencyHistory.setAgencyServiceType(data.getString(AgencyInterfaceParam.ORG_SERVICE_TYPE));
    }
    /** 长期护理服务业务负责人 */
    agencyHistory.setAgencyServiceContact(data.getString(AgencyInterfaceParam.ORG_SERVICE_CONTACT));
    /** 长期护理联系人电话 */
    agencyHistory.setAgencyContactPhone(data.getString(AgencyInterfaceParam.ORG_CONTACT_PHONE));
    /** 长期护理联系人邮箱 */
    agencyHistory.setAgencyContactEmail(data.getString(AgencyInterfaceParam.ORG_CONTACT_EMAIL));
    /** 执业许可证号 */
    agencyHistory.setPracticeLicense(data.getString(AgencyInterfaceParam.PRACTICE_LICENSE));
    /** 所有制形式（1、国有企业;2、中外合资企业;3、外商独资企业;4、合伙企业;5、有限责任公司;6、有限股份公司;7、个人企业） */
    agencyHistory.setOwnershipForm(data.getInteger(AgencyInterfaceParam.OWNERSHIP_FORM));
    /** 法人代表 */
    agencyHistory.setLegalRepresentative(data.getString(AgencyInterfaceParam.LEGAL_REPRESENTATIVE));
    /** 法人电话 */
    agencyHistory.setLegalPhoneNo(data.getString(AgencyInterfaceParam.LEGAL_PHONE));
    /** 法人身份证号 */
    agencyHistory.setLegalIdCard(data.getString(AgencyInterfaceParam.LEGAL_ID_CARD));
    /** 长护区建筑面积 */
    agencyHistory.setConstructionArea(data.getDouble(AgencyInterfaceParam.CONSTRUCTION_AREA));
    /** 床位数 */
    agencyHistory.setAgencyBedNum(data.getInteger(AgencyInterfaceParam.ORG_BED_NUM));
    /** 高级执业医师数 */
    agencyHistory.setAdvancedDoctorNum(data.getInteger(AgencyInterfaceParam.ADVANCED_DOCTOR_NUM));
    /** 中级执业医师数 */
    agencyHistory.setIntermediateDoctorNum(
        data.getInteger(AgencyInterfaceParam.INTERMEDIATE_DOCTOR_NUM));
    /** 初级执业医师数 */
    agencyHistory.setPrimaryDoctorNum(data.getInteger(AgencyInterfaceParam.PRIMARY_DOCTOR_NUM));
    /** 无职级医师数 */
    agencyHistory.setNoDoctorNum(data.getInteger(AgencyInterfaceParam.NO_DOCTOR_NUM));
    /** 高级执业护士数 */
    agencyHistory.setAdvancedNurseNum(data.getInteger(AgencyInterfaceParam.ADVANCED_NURSE_NUM));
    /** 中级执业护士数 */
    agencyHistory.setIntermediateNurseNum(
        data.getInteger(AgencyInterfaceParam.INTERMEDIATE_NURSE_NUM));
    /** 初级执业护士数 */
    agencyHistory.setPrimaryNurseNum(data.getInteger(AgencyInterfaceParam.PRIMARY_NURSE_NUM));
    /** 无职级护士数 */
    agencyHistory.setNoNurseNum(data.getInteger(AgencyInterfaceParam.NO_NURSE_NUM));
    /** 高级执业护理员数 */
    agencyHistory.setAdvancedCarerNum(data.getInteger(AgencyInterfaceParam.ADVANCED_CARER_NUM));
    /** 中级执业护理员数 */
    agencyHistory.setIntermediateCarerNum(
        data.getInteger(AgencyInterfaceParam.INTERMEDIATE_CARER_NUM));
    /** 初级执业护理员数 */
    agencyHistory.setPrimaryCarerNum(data.getInteger(AgencyInterfaceParam.PRIMARY_CARER_NUM));
    /** 无职级护理员数 */
    agencyHistory.setNoCarerNum(data.getInteger(AgencyInterfaceParam.NO_CARER_NUM));
    /** 高级其他人员数 */
    agencyHistory.setAdvancedMiscNum(data.getInteger(AgencyInterfaceParam.ADVANCED_MISC_NUM));
    /** 中级其他人员数 */
    agencyHistory.setIntermediateMiscNum(
        data.getInteger(AgencyInterfaceParam.INTERMEDIATE_MISC_NUM));
    /** 初级其他人员数 */
    agencyHistory.setPrimaryMiscNum(data.getInteger(AgencyInterfaceParam.PRIMARY_MISC_NUM));
    /** 无职级其他人员数 */
    agencyHistory.setNoMiscNum(data.getInteger(AgencyInterfaceParam.NO_MISC_NUM));
    /** 申请人 */
    agencyHistory.setAgencyApplicat(data.getString(AgencyInterfaceParam.OPERATOR));
    /** 申请日期 */
    agencyHistory.setAgencyApplyDate(data.getDate(AgencyInterfaceParam.OPERATING_TIME));

    agencyHistory.setSerialNum(BaseModel.getUUID());
    agencyHistory.setValidState(IsValidEnum.NO_DELETE.getValue());
    agencyHistory.setCreatedTime(new Date());
    agencyHistory.setOperatedTime(new Date());
    //如果是新增，则生成机构编码
    if (ActionTypeEnum.CREATE.getValue().equals(data.getString(AgencyInterfaceParam.ACTION_TYPE))) {
      String areaCode = getAreaCode(data);
      String agencyCode = getAgencyCode(areaCode);
      //防止orgCode重复,自动生成后先去数据库查重
      while (true) {
        AgencyHistoryDOExample example = new AgencyHistoryDOExample();
        Criteria criteria = example.createCriteria();
        criteria.andOrgCodeEqualTo(agencyCode);
        List<AgencyHistoryDO> list = agencyHistoryDao.selectByExample(example);
        if (list.isEmpty()) {
          //查询出数据为空 证明code值没有重复 不用重复生成
          break;
        }
        agencyCode = getAgencyCode(areaCode);
      }
      agencyHistory.setAgencyCode(agencyCode);

      agencyHistory.setAgencyState(AgencyStateEnum.STATE_NO_ACCEPT.getValue());
    } else {
      agencyHistory.setAgencyState(AgencyStateEnum.STATE_ACCEPT.getValue());
    }

    return agencyHistory;
  }

  private static String getAgencyCode(String areaCode) {
    StringBuffer sb = new StringBuffer(areaCode);
    SecureRandom random = new SecureRandom();
    for (int i = 0; i < 6; i++) {
      sb.append(org[random.nextInt(org.length)]);
    }
    return sb.toString();
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
  /** 机构受理结果告知 */
  @Override
  public void sendOrgAcceptResult(AgencyHistoryDTO agency) {
    Map<String, String> map = new HashMap<>();
    map.put(AgencyInterfaceParam.ORG_CODE, agency.getOrgCode());
    map.put(AgencyInterfaceParam.ACCEPT_DATE, agency.getOperatedTime());
    map.put(AgencyInterfaceParam.STATE, agency.getAgencyState().toString());
    if (AgencyStateEnum.STATE_WITHHOLD_ACCEPT.getValue().equals(agency.getAgencyState())) {
      map.put(AgencyInterfaceParam.REASON, agency.getCause());
    }

    MqBaseModel mqBaseModel = getMqBaseModel();
    mqBaseModel.setMessageCode(orgAcceptResultMessageCode);
    mqBaseModel.setData(map);
    String jsonString = JSONObject.toJSONString(mqBaseModel);
    //记录日志
    messageLogService.sendMqMessageLog(0L, "0", jsonString, orgAcceptResultExchange, null);
    //发送至mq routingKey 是 “jingmen”,不是queryName
    sendMessage(orgAcceptResultExchange, ROUTING_KEY, jsonString);
  }
  /** 机构审核结果告知 */
  @Override
  public void sendOrgApproveResult(AgencyDTO agency) {
    Map<String, String> map = new HashMap<>();
    map.put(AgencyInterfaceParam.ORG_CODE, agency.getOrgCode());
    map.put(AgencyInterfaceParam.CHECK_DATE, agency.getOperatedTime());
    map.put(AgencyInterfaceParam.STATE, agency.getAgencyState().toString());
    if (AgencyStateEnum.STATE_NO_AUDIT.getValue().equals(agency.getAgencyState())) {
      //审核不通过
      map.put(AgencyInterfaceParam.REJECTION_REASON, agency.getRejectionReason());
    } else {
      map.put(AgencyInterfaceParam.AGENCY_CODE, agency.getAgencyCode());
      map.put(AgencyInterfaceParam.SECRET_KEY, agency.getSecretKey());
      map.put(AgencyInterfaceParam.KEY_BEGIN_DATE, agency.getKeyBeginDate());
      map.put(AgencyInterfaceParam.KEY_END_DATE, agency.getKeyEndDate());
    }
    MqBaseModel mqBaseModel = getMqBaseModel();
    mqBaseModel.setMessageCode(orgApproveResultMessageCode);
    mqBaseModel.setData(map);
    String jsonString = JSONObject.toJSONString(mqBaseModel);
    //记录日志
    messageLogService.sendMqMessageLog(0L, "0", jsonString, orgApproveResultExchange, null);
    //发送至mq routingKey 是 “jingmen”,不是queryName
    sendMessage(orgApproveResultExchange, ROUTING_KEY, jsonString);
  }

  /** 机构变更审核结果告知 */
  @Override
  public void sendOrgChangeResult(AgencyDTO agency) {
    Map<String, String> map = new HashMap<>();
    map.put(AgencyInterfaceParam.ORG_CODE, agency.getOrgCode());
    map.put(AgencyInterfaceParam.CHECK_DATE, agency.getOperatedTime());
    map.put(AgencyInterfaceParam.STATE, agency.getAgencyState().toString());
    map.put(AgencyInterfaceParam.AGENCY_CODE, agency.getAgencyCode());
    if (AgencyStateEnum.STATE_NO_AUDIT.getValue().equals(agency.getAgencyState())) {
      map.put(AgencyInterfaceParam.REJECTION_REASON, agency.getRejectionReason());
    }
    MqBaseModel mqBaseModel = getMqBaseModel();
    mqBaseModel.setMessageCode(orgChangeResultMessageCode);
    mqBaseModel.setData(map);
    String jsonString = JSONObject.toJSONString(mqBaseModel);
    //记录日志
    messageLogService.sendMqMessageLog(0L, "0", jsonString, orgChangeResultExchange, null);
    //发送至mq routingKey 是 “jingmen”,不是queryName
    sendMessage(orgChangeResultExchange, ROUTING_KEY, jsonString);
  }

  public void sendMessage(String exchangeName, String routingKey, String message) {
    try {
      byte[] bytes = message.getBytes(systemCharset);
      rabbitTemplate.convertAndSend(exchangeName, routingKey, bytes);
      logger.info("发送消息至MQ, exchangeName: " + exchangeName + "--message: " + message);
    } catch (UnsupportedEncodingException e) {
      logger.error("MQ发送：", e);
      throw new ThrowsException("发送MQ解析String为byte[]时出错");
    }
  }
}
