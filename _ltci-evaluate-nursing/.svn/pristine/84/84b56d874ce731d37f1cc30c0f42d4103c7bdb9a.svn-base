package com.taikang.dic.ltci.service.impl;

import java.sql.Timestamp;
import java.time.Year;
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.CheckInDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.ConstantUtil;
import com.taikang.dic.ltci.common.enumeration.ErrorReasonStateEnum;
import com.taikang.dic.ltci.common.enumeration.EvaluateEnum;
import com.taikang.dic.ltci.common.enumeration.InHospStateEnum;
import com.taikang.dic.ltci.common.enumeration.IsRelativeCaredEnum;
import com.taikang.dic.ltci.common.enumeration.IsValidEnum;
import com.taikang.dic.ltci.common.enumeration.ModuleCodeEnum;
import com.taikang.dic.ltci.common.enumeration.MqTypeEnum;
import com.taikang.dic.ltci.common.enumeration.OperationTypeEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.enumeration.ThirdInterfaceLogEnum;
import com.taikang.dic.ltci.common.enumeration.TransportTypeEnum;
import com.taikang.dic.ltci.common.exception.NotFoundByIdException;
import com.taikang.dic.ltci.common.exception.ThrowsException;
import com.taikang.dic.ltci.common.log.ThreadLocalUtil;
import com.taikang.dic.ltci.common.util.DateFormat;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.common.util.IPUtil;
import com.taikang.dic.ltci.common.util.SpringContextUtil;
import com.taikang.dic.ltci.common.util.UrlUtil;
import com.taikang.dic.ltci.common.ws.ChanghuCard;
import com.taikang.dic.ltci.common.ws.ErrorReason;
import com.taikang.dic.ltci.common.ws.NurseInInfo;
import com.taikang.dic.ltci.common.ws.NurseOutInfo;
import com.taikang.dic.ltci.dao.CheckInDAO;
import com.taikang.dic.ltci.dao.CheckInSpecialDAO;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.MQMessageLogDAO;
import com.taikang.dic.ltci.dao.ThirdInterfaceLogDAO;
import com.taikang.dic.ltci.model.CheckInDO;
import com.taikang.dic.ltci.model.CheckInDOExample;
import com.taikang.dic.ltci.model.CheckInDOExample.Criteria;
import com.taikang.dic.ltci.serverClient.InsuredPersonServerClient;
import com.taikang.dic.ltci.model.CheckInRmqDO;
import com.taikang.dic.ltci.model.CheckInSpecialDO;
import com.taikang.dic.ltci.model.CheckOutDO;
import com.taikang.dic.ltci.model.EvaluateTaskDO;
import com.taikang.dic.ltci.model.EvaluateTaskDOExample;
import com.taikang.dic.ltci.model.InsuredPersonDO;
import com.taikang.dic.ltci.model.MQMessageLogDO;
import com.taikang.dic.ltci.model.MQMessageLogDOExample;
import com.taikang.dic.ltci.model.MqBaseModel;
import com.taikang.dic.ltci.model.MqFailMessageLogDO;
import com.taikang.dic.ltci.model.ThirdInterfaceLogDO;
import com.taikang.dic.ltci.model.ThirdInterfaceLogDOExample;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.CheckInService;
import com.taikang.dic.ltci.service.IMqFailMessageLogService;
import com.taikang.dic.ltci.service.WSService;

@Service
public class CheckInServiceImpl extends AbstractGenericService<CheckInDO, String>
    implements CheckInService {
  private Logger logger = LoggerFactory.getLogger(CheckInServiceImpl.class);
  @Autowired private CheckInDAO checkInDAO;
  @Autowired private CheckInSpecialDAO checkInSpecialDAO;
  @Autowired private MQMessageLogDAO mqMessageLogDAO;
  @Autowired private ThirdInterfaceLogDAO thirdInterfaceLogDAO;
  @Autowired private UrlUtil urlUtil;
  @Autowired private IMqFailMessageLogService failMessageLogService;
  @Autowired private WSService wsService;
  @Autowired private SpringContextUtil springContextUtil;
  @Autowired private InsuredPersonServerClient insuredPersonServerClient;

  @Value("${systemCharset}")
  private String systemCharset;
  //发送给专业
  @Value(value = "${ltci.sendCheckOut.messageCode}")
  private String messageCode;

  @Value("${ltci.sendCheckOut.queue}")
  private String routingKey;

  @Value("${ltci.sendCheckOut.exchange}")
  private String exchangeName;

  //发送给大数据
  @Value(value = "${ltci.sendCheckOutBigData.messageCode}")
  private String messageCodeBigData;

  @Value("${ltci.sendCheckOutBigData.queue}")
  private String routingKeyBigData;

  @Value("${ltci.sendCheckOutBigData.exchange}")
  private String exchangeNameBigData;
  //监听专业的入院
  @Value("${ltci.receiveCheckIn.queue}")
  private String receiveInQueueName;
  //监听专业的出院
  @Value("${ltci.receiveCheckOut.queue}")
  private String receiveOutQueueName;

  @Value("${isWebserviceDebug}")
  private Boolean isWebserviceDebug;

  @Override
  public PageResultDTO getCheckIn(
      String beCarePersonName,
      String beCarePersonCard,
      String orgName,
      String operatedTime,
      String inHospState,
      int page,
      int pageSize) {

    Map<String, Object> map = new HashMap<>();
    map.put("beCarePersonName", beCarePersonName);
    map.put("beCarePersonCard", beCarePersonCard);
    map.put("orgName", orgName);
    map.put("operatedTime", operatedTime);
    map.put("inHospState", inHospState);
    map.put("page", (page - 1) * pageSize);
    map.put("pageSize", pageSize);
    map.put("operatedOrg", ThreadLocalUtil.threadLocal.get().getOperatedOrg());

    List<CheckInSpecialDO> checkIn = checkInSpecialDAO.getCheckIn(map);

    Integer count = checkInSpecialDAO.countCheckIn(map);
    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;

    PageResultDTO pageResultDTO = new PageResultDTO();
    pageResultDTO.setDatas(checkIn);
    pageResultDTO.setPage(page);
    pageResultDTO.setPageSize(pageSize);
    pageResultDTO.setTotalDataNum(count);
    pageResultDTO.setTotalPageNum(totalPage);
    pageResultDTO.setStatus(StatusCodeEnum.OK.getValue());
    return pageResultDTO;
  }

  @Override
  public IGenericDAO<CheckInDO, String> getDao() {
    return checkInDAO;
  }

  /** 经办协议退出 */
  @Override
  @Transactional
  public int updateCheckInByCheckInCode(
      String exitFrom,
      String exitReason,
      String exitReasonDetial,
      String inHospState,
      String realOutDate,
      String checkInCode,
      String operatedBy) {
    CheckInDOExample doExample = new CheckInDOExample();
    Criteria criteria = doExample.createCriteria();
    criteria.andInRecordUuidEqualTo(checkInCode);
    List<CheckInDO> checkInDOs = checkInDAO.selectByExampleWithBLOBs(doExample);

    int updateResult = 0;
    if (checkInDOs != null && !checkInDOs.isEmpty()) {
      CheckInDO checkInDO = new CheckInDO();
      checkInDO = checkInDOs.get(0);
      checkInDO.setExitFrom(exitFrom);
      checkInDO.setExitReason(exitReason);
      checkInDO.setExitReasonDetial(exitReasonDetial);
      if (inHospState != null && !"".equals(inHospState))
        checkInDO.setInHospState(Integer.valueOf(inHospState));
      if (realOutDate != null && !"".equals(realOutDate)) {
        checkInDO.setRealOutDate(Timestamp.valueOf(realOutDate + " 00:00:00"));
      } else {
        checkInDO.setRealOutDate(new Date());
      }
      checkInDO.setOperatedBy(operatedBy);
      checkInDO.setOperatedTime(new Date());
      checkInDO.setInRecordUuid(checkInCode);
      checkInDO.setInHospState(InHospStateEnum.In.getValue());

      CheckInServiceImpl bean =
          springContextUtil.getApplicationContext().getBean(CheckInServiceImpl.class);
      updateResult = bean.updateCheckInAndToDR(checkInDO);
    }
    return updateResult;
  }

  /**
   * 经办协议退出，并且通知东软
   *
   * @param checkInDO
   * @return
   */
  @Transactional
  public int updateCheckInAndToDR(CheckInDO checkInDO) {
    logger.debug("_____经办协议退出CheckInServiceImpl >>>>>> updateCheckInAndToDR(CheckInDO checkInDO))");
    int updateResult = 0;

    ThirdInterfaceLogDO log = new ThirdInterfaceLogDO();
    long begin = System.currentTimeMillis();

    log.setType(ThirdInterfaceLogEnum.TYPE_CHECK_OUT_JINGBAN.getValue());
    log.setBusiType(ThirdInterfaceLogEnum.BUSI_TYPE_05.getValue());

    try {

      CheckInDOExample doExample = new CheckInDOExample();
      Criteria criteriaCheckin = doExample.createCriteria();
      criteriaCheckin.andIdEqualTo(checkInDO.getId());
      criteriaCheckin.andInHospStateEqualTo(InHospStateEnum.out.getValue());
      List<CheckInDO> list = checkInDAO.selectByExample(doExample);
      if (list.isEmpty()) {
        return -1;
      } else {
        updateResult = checkInDAO.updateByPrimaryKeySelective(checkInDO);
      }
      //      CheckInDOExample example = new CheckInDOExample();
      //      Criteria criteriaCheckin = example.createCriteria();
      //      criteriaCheckin.andIdEqualTo(checkInDO.getId());
      //      criteriaCheckin.andInHospStateEqualTo(InHospStateEnum.out.getValue());
      //      updateResult = checkInDAO.updateByExample(checkInDO, example);
      if (updateResult > 0) {

        log.setBusiDataId(checkInDO.getInRecordUuid());
        log.setSendContent(JSONObject.toJSONString(checkInDO));
        log.setSendTime(new Date());
        //发送协议退出信息给东软
        if (!isWebserviceDebug) {
          CheckInServiceImpl bean =
              springContextUtil.getApplicationContext().getBean(CheckInServiceImpl.class);
          ErrorReason errorReason = bean.sendCheckOutToDR(checkInDO);

          if (ErrorReasonStateEnum.IS_SUCCESS
              .getValue()
              .equals(errorReason.getErrorReasonCode())) { //插入东软成功
            log.setIsSendSuccess(1);

            //给东软成功后，发送MQ信息给专业服务和大数据服务
            //一个交换机下有两个队列，只需要忘一个队列发消息，另一个队列也会收到，不需要同时往两个队列发消息
            //正式的时候位置
            checkOutRMQ(checkInDO, exchangeName, routingKey);
          } else { //插入东软失败
            log.setIsSendSuccess(0);
            log.setFailMessage(errorReason.getErrorReason());
            throw new ThrowsException("经办协议退出出错:" + errorReason.getErrorReason());
          }
        } else {
          //给东软成功后，发送MQ信息给专业服务和大数据服务
          checkOutRMQ(checkInDO, exchangeName, routingKey);
        }
      }
    } catch (Exception e) {
      log.setIsSendSuccess(0);
      log.setFailMessage(e.getMessage());
      logger.error("_________updateCheckInByCheckInCode经办协议退出出错：", e);
      throw new ThrowsException("经办协议退出出错");
    } finally {
      insertInterfaceLog(log);
      logger.debug(
          "_____CheckInServiceImpl >>>>>> updateCheckInAndToDR(CheckInDO checkInDO)__耗时S:"
              + ((System.currentTimeMillis()) - begin) / 1000);
    }
    return updateResult;
  }

  /**
   * 调用东软接口 通知协议退出
   *
   * @param checkInDO
   */
  public ErrorReason sendCheckOutToDR(CheckInDO checkInDO) {
    logger.debug("调用东软接口 通知协议退出......start......");
    //调用东软接口 通知协议退出
    NurseOutInfo nurseOutInfo = new NurseOutInfo();
    nurseOutInfo.setBedNum(checkInDO.getBedNum());
    if (checkInDO.getMedicalType() != null) {
      nurseOutInfo.setCareType(checkInDO.getMedicalType());
    } else nurseOutInfo.setCareType("31");
    nurseOutInfo.setDepartment(checkInDO.getDepartment());
    nurseOutInfo.setInRecorduuid(checkInDO.getInRecordUuid());
    nurseOutInfo.setOperator(checkInDO.getOperatedBy());
    //1.死亡 2.复评未通过 3.退保 4.转入院 5.其它
    nurseOutInfo.setOutReason(checkInDO.getExitReason());
    nurseOutInfo.setUniqueNumber(checkInDO.getOrgCode().substring(6));
    if (checkInDO.getRealOutDate() != null) {
      nurseOutInfo.setRealOutDate(
          DateFormatUtil.dateToStr(
              checkInDO.getRealOutDate(), DateFormatUtil.DATE_FORMAT_YYYYMMDDHHMMSS));
    }
    nurseOutInfo.setRxInfo(checkInDO.getMedicalRecord());
    ErrorReason errorReason = new ErrorReason();
    try {
      errorReason = wsService.getNurseOutInfo(nurseOutInfo);
    } catch (Exception e) {
      logger.debug("调用东软接口 通知协议退出失败............" + e);
      throw new ThrowsException("调用东软接口 通知协议退出失败");
    }
    logger.debug("调用东软接口 通知协议退出......end......");
    return errorReason;
  }

  /**
   * 协议退出发送MQ消息
   *
   * @param checkInDO
   * @param exchangeName
   * @param routingKey
   */
  private void checkOutRMQ(CheckInDO checkInDO, String exchangeName, String routingKey) {
    logger.debug(
        "_____经办协议退出CheckInServiceImpl >>>>>> checkOutRMQ(CheckInDO checkInDO, String exchangeName, String routingKey)发送消息start......");
    Date date = new Date();

    CheckOutDO checkOutDO = new CheckOutDO();
    checkOutDO.setOutFrom("1"); //1经办；2：专业
    checkOutDO.setOtherReason(checkInDO.getExitReasonDetial());
    checkOutDO.setDirection("");
    checkOutDO.setIdCard(checkInDO.getBeCarePersonCard());
    checkOutDO.setInsuredPersonName(checkInDO.getBeCarePersonName());
    checkOutDO.setEvaluateAgencyCode(checkInDO.getOrgCode());
    checkOutDO.setRealOutDate(date);
    checkOutDO.setSecurityNumber(checkInDO.getsCardNo());
    //协议退出原因
    checkOutDO.setSignOutReason(checkInDO.getExitReason());
    checkOutDO.setInRecorduuid(checkInDO.getInRecordUuid());
    checkOutDO.setOperatedBy(checkInDO.getOperatedBy());
    checkOutDO.setOperatedTime(checkInDO.getOperatedTime());
    //2.构造MQ基本信息
    MqBaseModel mqBaseModel = new MqBaseModel();
    mqBaseModel.setBusinessSerialid(UUID.randomUUID().toString().replaceAll("-", ""));
    mqBaseModel.setTimestamp(DateFormat.getLocalDateTime());
    try {
      mqBaseModel.setNodeIP(IPUtil.getLocalIp());
    } catch (Exception e) {
      logger.info("获取服务器Ip失败：", e);
    }
    mqBaseModel.setSystemCode(systemCode);
    mqBaseModel.setModuleCode(ModuleCodeEnum.SEND_CHECKOUT.getValue());
    mqBaseModel.setMessageCode(messageCode);
    mqBaseModel.setData(checkOutDO);

    String jsonString = JSON.toJSONString(mqBaseModel);

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

    //3.保存日志信息
    mqMessageLogDAO.insert(mqLogDo);

    logger.debug("====sendEvaluateTask start:" + DateFormatUtil.dateToTimeStr(date));
    //发送MQ信息
    try {
      sendMessage(exchangeName, routingKey, jsonString);
    } catch (Exception e) {
      logger.error("_________checkOutRMQ 方法推送协议退出消息失败：" + e);
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
    logger.debug("====sendEvaluateTask end:" + DateFormatUtil.dateToTimeStr(date));
  }

  /**
   * 监听参保人入院记录
   *
   * @param message
   */
  @RabbitListener(queues = "${ltci.receiveCheckIn.queue}")
  public void checkInBySpecialtySystem(byte[] byteMsg) {
    logger.debug(
        "_____经办监听长护参保人入院记录CheckInServiceImpl >>>>>> checkInBySpecialtySystem(byte[] byteMsg)______start......");
    String message = null;
    MqBaseModel mqBaseModel = null;
    try {
      message = new String(byteMsg, systemCharset);
      //根据发送方节点IP地址 去选取应该接收的消息队列
      //暂时定为true 所有消息都接收
      mqBaseModel = JSONObject.parseObject(message, MqBaseModel.class);
      //判断是否重复接受同一消息
      MQMessageLogDOExample doExample = new MQMessageLogDOExample();
      com.taikang.dic.ltci.model.MQMessageLogDOExample.Criteria criteria =
          doExample.createCriteria();
      criteria.andTypeEqualTo(MqTypeEnum.RECEIVE.getValue());
      criteria.andIdEqualTo(mqBaseModel.getBusinessSerialid());

      List<MQMessageLogDO> mqMessageLogDOs = mqMessageLogDAO.selectByExample(doExample);
      if (!mqMessageLogDOs.isEmpty()) {
        logger.debug("======此id【" + mqBaseModel.getBusinessSerialid() + "】信息已经监听处理=============");
        return;
      }

      //插入协议入住 以及 通知东软
      CheckInServiceImpl bean =
          springContextUtil.getApplicationContext().getBean(CheckInServiceImpl.class);
      bean.checkInAndToDR(mqBaseModel);
      logger.debug(
          "_____经办监听长护参保人入院记录CheckInServiceImpl >>>>>> checkInBySpecialtySystem(byte[] byteMsg)______end......");
    } catch (Exception e) {
      logger.error("协议入住监听异常：", e);
      if (mqBaseModel != null && StringUtils.isNotBlank(mqBaseModel.getBusinessSerialid())) {
        MqFailMessageLogDO failLog = new MqFailMessageLogDO();
        failLog.setId(mqBaseModel.getBusinessSerialid());
        failLog.setTransportType(TransportTypeEnum.ASYNCHRONIZE.getValue()); //交互方式：异步
        failLog.setOperationType(OperationTypeEnum.RECEIVE.getValue()); //发送接收类型
        failLog.setQueryName(receiveInQueueName);
        failLog.setContent(message);
        failLog.setErrorMessage(e.getMessage());
        failLog.setCreateTime(new Date());
        failLog.setHttpAction(HttpMethod.POST.name());
        // 添加重试url
        failLog.setRetryUrl(urlUtil.getBaseUrl() + ConstantUtil.RETRY_URL_CHECK_IN_MQ);
        failMessageLogService.saveOrUpdateFailLog(failLog);
      }
    }
  }

  /**
   * 插入协议入住 以及 通知东软
   *
   * @param mqBaseModel
   */
  @Transactional
  public ErrorReason checkInAndToDR(MqBaseModel mqBaseModel) {
    //将监听到的数据存入日志表
    MQMessageLogDO mqMessageLogDO = new MQMessageLogDO();
    mqMessageLogDO.setId(mqBaseModel.getBusinessSerialid());
    mqMessageLogDO.setType(MqTypeEnum.RECEIVE.getValue());
    mqMessageLogDO.setSendContent(JSONObject.toJSONString(mqBaseModel));
    //发送状态暂时写1
    mqMessageLogDO.setSendState("1");
    mqMessageLogDO.setCreateTime(new Date());
    mqMessageLogDO.setQueueName(receiveInQueueName);
    mqMessageLogDAO.insert(mqMessageLogDO);

    logger.debug(
        "_____经办将参保人入院信息插入协议入住 以及 通知东软CheckInServiceImpl >>>>>> checkInAndToDR(MqBaseModel mqBaseModel)______start......");
    ErrorReason errorReason = new ErrorReason();
    ////////////////////////////////////////////////////////////
    ThirdInterfaceLogDO log = new ThirdInterfaceLogDO();
    long begin = System.currentTimeMillis();
    log.setType(ThirdInterfaceLogEnum.TYPE_CHECK_IN.getValue());
    log.setBusiType(ThirdInterfaceLogEnum.BUSI_TYPE_04.getValue());
    //////////////////////////////////////////////////////////////
    try {
      CheckInRmqDO rmqDO =
          JSONObject.parseObject(
              JSONObject.toJSONString(mqBaseModel.getData()), CheckInRmqDO.class);

      //查询协议表中有无此信息
      CheckInDOExample doExampleCheckin = new CheckInDOExample();
      Criteria criteriaCheckin = doExampleCheckin.createCriteria();
      criteriaCheckin.andInRecordUuidEqualTo(rmqDO.getInRecorduuid());
      List<CheckInDO> checkInDOs = checkInDAO.selectByExampleWithBLOBs(doExampleCheckin);

      if (!checkInDOs.isEmpty()) {
        logger.debug("_____经办将参保人入院信息插入协议入住 通知东软," + rmqDO.getInRecorduuid() + "_____已存在。");
        errorReason.setErrorReasonCode(ErrorReasonStateEnum.IS_FAIL.getValue());
        errorReason.setErrorReasonCode("0");
        errorReason.setErrorReason(rmqDO.getInRecorduuid() + "长护流水号已存在");
        return errorReason;
      }

      CheckInDO checkInDO = checkInRmqDOToCheckInDO(rmqDO);
      checkInDO.setInHospState(InHospStateEnum.out.getValue());
      checkInDO.setId(UUID.randomUUID().toString().replaceAll("-", ""));
      checkInDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
      checkInDO.setOperatedTime(new Date());
      checkInDO.setOperatedOrg(rmqDO.getOrgCode());

      ResultDTO applicationResult =
          insuredPersonServerClient.getInsuredPersonDetail(
              "", checkInDO.getBeCarePersonCard(), checkInDO.getsCardNo());
      InsuredPersonDO insuredPersonDO =
          JSONObject.parseObject(
              JSONObject.toJSONString(applicationResult.getDatas()), InsuredPersonDO.class);
      if (insuredPersonDO != null) {
        checkInDO.setSiArea(insuredPersonDO.getSiArea());
      }
      //插入数据库
      int result = checkInDAO.insert(checkInDO);

      //通知东软系统
      if (result > 0) {
        logger.debug(
            "_____经办将参保人入院信息插入协议入住 通知东软CheckInServiceImpl >>>>>> wsService.registNurseInfo(registRequest, changhuCard)______start......");

        NurseInInfo registRequest = new NurseInInfo();
        registRequest.setBedNum(rmqDO.getBedNum());
        registRequest.setDepartment(rmqDO.getDepartment());
        registRequest.setDiseaseCode(rmqDO.getDiseaseCode());
        registRequest.setDiseaseName(rmqDO.getDiseaseName());
        registRequest.setInRecorduuid(rmqDO.getInRecorduuid());
        registRequest.setMedicalRecord(rmqDO.getMedicalRecord());
        registRequest.setMedicalType(rmqDO.getMedicalType());
        registRequest.setOperator(rmqDO.getOperator());
        registRequest.setUniqueNumber(checkInDO.getOrgCode().substring(6));
        if (rmqDO.getRealInDate() != null) {
          registRequest.setRealInDate(
              DateFormatUtil.dateToStr(
                  checkInDO.getRealInDate(), DateFormatUtil.DATE_FORMAT_YYYYMMDDHHMMSS));
        }

        ChanghuCard changhuCard = new ChanghuCard();
        changhuCard.setPSAMCardNum(rmqDO.getPsamCardNo());
        changhuCard.setSCardNo(rmqDO.getsCardNo());
        changhuCard.setSCardType(rmqDO.getSecurityCardType());
        changhuCard.setSIDNo(rmqDO.getBeCarePersonCardNum());
        changhuCard.setSName(rmqDO.getBeCarePersonName());

        log.setBusiDataId(mqBaseModel.getBusinessSerialid());
        log.setSendContent(JSONObject.toJSONString(mqBaseModel));
        log.setSendTime(new Date());
        //推送协议入住发送信息给东软
        if (!isWebserviceDebug) {
          errorReason = wsService.registNurseInfo(registRequest, changhuCard);
          logger.debug(
              "_____经办将参保人入院信息插入协议入住 通知东软CheckInServiceImpl >>>>>> wsService.registNurseInfo(registRequest, changhuCard)______end......");
          if (ErrorReasonStateEnum.IS_SUCCESS
              .getValue()
              .equals(errorReason.getErrorReasonCode())) { //插入东软成功
            log.setIsSendSuccess(1);
          } else { //插入东软失败
            log.setIsSendSuccess(0);
            log.setFailMessage(errorReason.getErrorReason());
            logger.debug(
                "_____经办将参保人入院信息插入协议入住 通知东软失败______end......:" + errorReason.getErrorReason());
            throw new ThrowsException("经办监听到协议入住新增记录和通知东软出错" + errorReason.getErrorReason());
          }
        }
      }
    } catch (Exception e) {
      log.setIsSendSuccess(0);
      log.setFailMessage(e.getMessage());
      logger.error("_________checkInAndToDR(MqBaseModel mqBaseModel)经办监听到协议入住后新增记录和通知东软出错：", e);
      throw new ThrowsException("经办监听到协议入住新增记录和通知东软出错");
    } finally {
      insertInterfaceLog(log);
      logger.debug(
          "_____CheckInServiceImpl >>>>>> checkInAndToDR(MqBaseModel mqBaseModel)__耗时S:"
              + ((System.currentTimeMillis()) - begin) / 1000);
    }
    return errorReason;
  }

  /**
   * 监听参保人退出协议记录
   *
   * @param message
   */
  @RabbitListener(queues = "${ltci.receiveCheckOut.queue}")
  public void checkOutBySpecialtySystem(byte[] byteMsg) {
    logger.debug(
        "_____经办监听长护参保人入院记录CheckInServiceImpl >>>>>> checkOutBySpecialtySystem(byte[] byteMsg)______start......");
    String message = null;
    MqBaseModel mqBaseModel = null;
    try {
      message = new String(byteMsg, systemCharset);
      //根据发送方节点IP地址 去选取应该接收的消息队列
      //暂时定为true 所有消息都接收
      mqBaseModel = JSONObject.parseObject(message, MqBaseModel.class);

      //判断是否重复接受同一消息
      MQMessageLogDOExample doExample = new MQMessageLogDOExample();
      com.taikang.dic.ltci.model.MQMessageLogDOExample.Criteria criteria =
          doExample.createCriteria();
      criteria.andTypeEqualTo(MqTypeEnum.RECEIVE.getValue());
      criteria.andIdEqualTo(mqBaseModel.getBusinessSerialid());

      List<MQMessageLogDO> mqMessageLogDOs = mqMessageLogDAO.selectByExample(doExample);
      if (!mqMessageLogDOs.isEmpty()) {
        logger.debug("======此id【" + mqBaseModel.getBusinessSerialid() + "】信息已经监听处理=============");
        return;
      }

      //将监听到的数据存入日志表
      MQMessageLogDO mqMessageLogDO = new MQMessageLogDO();
      mqMessageLogDO.setId(mqBaseModel.getBusinessSerialid());
      mqMessageLogDO.setType(MqTypeEnum.RECEIVE.getValue());
      mqMessageLogDO.setSendContent(message);
      // 发送状态暂时写1
      mqMessageLogDO.setSendState("1");
      mqMessageLogDO.setCreateTime(new Date());
      mqMessageLogDO.setQueueName(receiveOutQueueName);
      mqMessageLogDAO.insert(mqMessageLogDO);

      //修改协议退出 以及 通知东软
      CheckInServiceImpl bean =
          springContextUtil.getApplicationContext().getBean(CheckInServiceImpl.class);
      bean.checkOutAndToDR(mqBaseModel);
      logger.debug(
          "_____经办监听长护参保人入院记录CheckInServiceImpl >>>>>> checkOutBySpecialtySystem(byte[] byteMsg)______end......");
    } catch (Exception e) {
      logger.error("协议退出监听异常：" + e);
      if (mqBaseModel != null && StringUtils.isNotBlank(mqBaseModel.getBusinessSerialid())) {
        MqFailMessageLogDO failLog = new MqFailMessageLogDO();
        failLog.setId(mqBaseModel.getBusinessSerialid());
        failLog.setTransportType(TransportTypeEnum.ASYNCHRONIZE.getValue()); //交互方式：异步
        failLog.setOperationType(OperationTypeEnum.RECEIVE.getValue()); //发送接收类型
        failLog.setQueryName(receiveOutQueueName);
        failLog.setContent(message);
        failLog.setErrorMessage(e.getMessage());
        failLog.setCreateTime(new Date());
        failLog.setHttpAction(HttpMethod.POST.name());
        // 添加重试url
        failLog.setRetryUrl(urlUtil.getBaseUrl() + ConstantUtil.RETRY_URL_CHECK_OUT_MQ);
        failMessageLogService.saveOrUpdateFailLog(failLog);
      }
    }
  }

  /**
   * 修改协议退出 以及 通知东软
   *
   * @param mqBaseModel
   */
  @Transactional
  public ErrorReason checkOutAndToDR(MqBaseModel mqBaseModel) {
    logger.debug(
        "_____经办监听长护参保人退出记录 修改协议退出 以及 通知东软CheckInServiceImpl >>>>>> checkOutAndToDR(MqBaseModel mqBaseModel)______start......");
    ErrorReason errorReason = new ErrorReason();
    ////////////////////////////////////////////////////////////
    ThirdInterfaceLogDO log = new ThirdInterfaceLogDO();
    long begin = System.currentTimeMillis();
    log.setType(ThirdInterfaceLogEnum.TYPE_CHECK_OUT.getValue());
    log.setBusiType(ThirdInterfaceLogEnum.BUSI_TYPE_05.getValue());
    //////////////////////////////////////////////////////////////
    try {
      CheckInRmqDO rmqDO =
          JSONObject.parseObject(
              JSONObject.toJSONString(mqBaseModel.getData()), CheckInRmqDO.class);
      CheckInDO checkInDO = checkInRmqDOToCheckInDO(rmqDO);
      checkInDO.setInHospState(InHospStateEnum.In.getValue());
      //修改数据库
      CheckInDOExample doExampleCheckin = new CheckInDOExample();
      Criteria criteriaCheckin = doExampleCheckin.createCriteria();
      criteriaCheckin.andInRecordUuidEqualTo(checkInDO.getInRecordUuid());
      List<CheckInDO> checkInDOs = checkInDAO.selectByExampleWithBLOBs(doExampleCheckin);

      int updateResult = 0;
      CheckInDO checkInDOUpdate = new CheckInDO();
      if (checkInDOs != null && !checkInDOs.isEmpty()) {
        checkInDOUpdate = checkInDOs.get(0);
        checkInDOUpdate.setExitFrom(checkInDO.getExitFrom());
        //协议退出原因
        checkInDOUpdate.setExitReason(checkInDO.getExitReason());
        checkInDOUpdate.setExitReasonDetial(checkInDO.getExitReasonDetial());
        checkInDOUpdate.setInHospState(checkInDO.getInHospState());
        checkInDOUpdate.setRealOutDate(checkInDO.getRealOutDate());
        checkInDOUpdate.setOperatedBy(checkInDO.getOperatedBy());
        checkInDOUpdate.setOperatedTime(checkInDO.getOperatedTime());
        checkInDOUpdate.setInRecordUuid(checkInDO.getInRecordUuid());
        updateResult = checkInDAO.updateByPrimaryKeySelective(checkInDOUpdate);
      }

      if (updateResult > 0) {
        //通知东软系统
        NurseOutInfo nurseOutInfo = new NurseOutInfo();
        nurseOutInfo.setBedNum(checkInDOUpdate.getBedNum());
        if (checkInDOUpdate.getMedicalType() != null) {
          nurseOutInfo.setCareType(checkInDOUpdate.getMedicalType());
        } else {
          nurseOutInfo.setCareType("31");
        }
        nurseOutInfo.setDepartment(checkInDOUpdate.getDepartment());
        nurseOutInfo.setInRecorduuid(checkInDOUpdate.getInRecordUuid());
        nurseOutInfo.setOperator(checkInDOUpdate.getOperatedBy());
        nurseOutInfo.setUniqueNumber(checkInDOUpdate.getOrgCode().substring(6));
        nurseOutInfo.setOutReason(checkInDOUpdate.getExitReason());
        if (checkInDOUpdate.getRealOutDate() != null) {
          nurseOutInfo.setRealOutDate(
              DateFormatUtil.dateToStr(
                  checkInDOUpdate.getRealOutDate(), DateFormatUtil.DATE_FORMAT_YYYYMMDDHHMMSS));
        }
        nurseOutInfo.setRxInfo(checkInDOUpdate.getMedicalRecord());

        log.setBusiDataId(mqBaseModel.getBusinessSerialid());
        log.setSendContent(JSONObject.toJSONString(mqBaseModel));
        log.setSendTime(new Date());
        //推送协议退出发送信息给东软
        if (!isWebserviceDebug) {
          logger.debug(
              "_____经办监听长护参保人退出记录 修改协议退出 通知东软 wsService.getNurseOutInfo(nurseOutInfo)______start......");

          errorReason = wsService.getNurseOutInfo(nurseOutInfo);
          logger.debug(
              "_____经办监听长护参保人退出记录 修改协议退出 通知东软 wsService.getNurseOutInfo(nurseOutInfo)______end......");
          if (ErrorReasonStateEnum.IS_SUCCESS
              .getValue()
              .equals(errorReason.getErrorReasonCode())) { //修改东软成功
            log.setIsSendSuccess(1);
          } else { //修改东软失败
            log.setIsSendSuccess(0);
            log.setFailMessage(errorReason.getErrorReason());
            logger.debug("_____经办监听长护参保人退出记录 修改协议退出 通知东软失败......" + errorReason.getErrorReason());
            throw new ThrowsException("经办监听到协议退出 修改协议退出和通知东软出错" + errorReason.getErrorReason());
          }
        }
      }
    } catch (Exception e) {
      log.setIsSendSuccess(0);
      log.setFailMessage(e.getMessage());
      logger.error("_________checkOutAndToDR(MqBaseModel mqBaseModel)经办监听到协议退出后修改记录和通知东软出错：", e);
      throw new ThrowsException("经办监听到协议退出 修改协议退出和通知东软出错");
    } finally {
      insertInterfaceLog(log);
      logger.debug(
          "_____CheckInServiceImpl >>>>>> checkOutAndToDR(MqBaseModel mqBaseModel)__耗时S:"
              + ((System.currentTimeMillis()) - begin) / 1000);
    }
    return errorReason;
  }

  /**
   * DO转化
   *
   * @param rmqDO
   * @return
   */
  private CheckInDO checkInRmqDOToCheckInDO(CheckInRmqDO rmqDO) {
    CheckInDO checkInDO = new CheckInDO();
    BeanUtils.copyProperties(rmqDO, checkInDO);
    checkInDO.setAgreInDate(rmqDO.getAgreInDate());
    checkInDO.setAgreOutDate(rmqDO.getAgreOutDate());
    checkInDO.setAllOwnExpenseFlag(rmqDO.getAllOwnExpenseFlag());
    checkInDO.setBeCarePersonCard(rmqDO.getBeCarePersonCardNum());
    checkInDO.setBeCarePersonName(rmqDO.getBeCarePersonName());
    if (rmqDO.getBeCarePersonGender() != null && !"".equals(rmqDO.getBeCarePersonGender()))
      checkInDO.setBeCarePersonSex(Integer.valueOf(rmqDO.getBeCarePersonGender()));
    checkInDO.setBedNum(rmqDO.getBedNum());
    if (rmqDO.getCardType() != null && !"".equals(rmqDO.getCardType()))
      checkInDO.setCardType(Integer.valueOf(rmqDO.getCardType()));
    checkInDO.setCreatedBy(rmqDO.getOperator());
    checkInDO.setCreatedOrg(rmqDO.getCreatedOrg());
    checkInDO.setCreatedTime(new Date());
    checkInDO.setOperatedBy(rmqDO.getOperator());
    checkInDO.setDepartment(rmqDO.getDepartment());
    checkInDO.setDirection(rmqDO.getDirection());
    checkInDO.setDiseaseCode(rmqDO.getDiseaseCode());
    checkInDO.setDiseasename(rmqDO.getDiseaseName());
    checkInDO.setExitFrom(rmqDO.getOutFrom());
    checkInDO.setExitReason(rmqDO.getSignOutReason());
    checkInDO.setExitReasonDetial(rmqDO.getDirection());
    checkInDO.setInRecordUuid(rmqDO.getInRecorduuid());
    checkInDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
    if (rmqDO.getIsRelativeCare() != null && !"".equals(rmqDO.getIsRelativeCare())) {
      if ("true".equals(rmqDO.getIsRelativeCare())) {
        checkInDO.setIsRelativeCared(Integer.valueOf(IsRelativeCaredEnum.YES.getValue()));
      } else {
        checkInDO.setIsRelativeCared(Integer.valueOf(IsRelativeCaredEnum.NO.getValue()));
      }
    }
    checkInDO.setRealOutDate(rmqDO.getRealOutDate());
    checkInDO.setRealInDate(rmqDO.getRealInDate());
    checkInDO.setInvoiceNum("");
    checkInDO.setOrgCode(rmqDO.getOrgCode());
    checkInDO.setOrgName(rmqDO.getOrgName());

    return checkInRmqDOToCheckInDO(rmqDO, checkInDO);
  }

  /**
   * DO转换拆分出来的接口
   *
   * @param rmqDO
   * @param checkInDO
   * @return
   */
  private CheckInDO checkInRmqDOToCheckInDO(CheckInRmqDO rmqDO, CheckInDO checkInDO) {
    if (rmqDO.getIsRelativeCare() != null && !"".equals(rmqDO.getIsRelativeCare())) {
      if ("true".equals(rmqDO.getIsRelativeCare())) {
        checkInDO.setIsRelativeCared(Integer.valueOf(IsRelativeCaredEnum.YES.getValue()));
      } else {
        checkInDO.setIsRelativeCared(Integer.valueOf(IsRelativeCaredEnum.NO.getValue()));
      }
    }
    checkInDO.setIsValid(IsValidEnum.ALREADY_DELETE.getValue());
    checkInDO.setMedicalRecord(rmqDO.getMedicalRecord());
    checkInDO.setMedicalType(rmqDO.getMedicalType());
    checkInDO.setNurseState(rmqDO.getEncounterState());
    checkInDO.setOperatedBy(rmqDO.getOperatedBy());
    checkInDO.setOperatedOrg(rmqDO.getOperatedOrg());
    checkInDO.setOperatedTime(rmqDO.getOperatedTime());
    checkInDO.setOrgCode(rmqDO.getOrgCode());
    checkInDO.setOrgName(rmqDO.getOrgName());
    checkInDO.setPsamCardNo(rmqDO.getPsamCardNo());
    checkInDO.setRealInDate(rmqDO.getRealInDate());
    checkInDO.setRealOutDate(rmqDO.getRealOutDate());
    checkInDO.setsCardNo(rmqDO.getsCardNo());
    checkInDO.setSiArea("");
    checkInDO.setSocSecNum(rmqDO.getSocSecNum());
    checkInDO.setYear(Year.now().toString());
    checkInDO.setSecurityCardType(rmqDO.getSecurityCardType());

    return checkInDO;
  }

  /**
   * 保存或更新第三方日志表
   *
   * @param log
   * @return
   */
  public boolean insertInterfaceLog(ThirdInterfaceLogDO log) {
    boolean result = false;
    ThirdInterfaceLogDOExample doe = new ThirdInterfaceLogDOExample();
    try {
      doe.createCriteria()
          .andBusiTypeEqualTo(log.getBusiType())
          .andTypeEqualTo(ThirdInterfaceLogEnum.TYPE_EVALUATE_NURSING.getValue())
          .andBusiDataIdEqualTo(log.getBusiDataId());
      List<ThirdInterfaceLogDO> list = thirdInterfaceLogDAO.selectByExample(doe);
      if (list != null && !list.isEmpty()) {
        //更新失败次数
        ThirdInterfaceLogDO ldo = list.get(0);
        ldo.setSendContent(log.getSendContent());
        ldo.setSendTime(log.getSendTime());
        ldo.setReveiceContent(log.getReveiceContent());
        ldo.setReveiceTime(log.getReveiceTime());
        ldo.setIsSendSuccess(log.getIsSendSuccess());
        ldo.setReSendNum(ldo.getReSendNum() + 1);
        //重试三次记录错误日志表
        result = thirdInterfaceLogDAO.updateByPrimaryKeySelective(ldo) > 0;
      } else if (log.getIsSendSuccess() == 0) {
        ThirdInterfaceLogDO third = new ThirdInterfaceLogDO();
        third.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        third.setType(ThirdInterfaceLogEnum.TYPE_EVALUATE_NURSING.getValue()); //评估护理服务
        third.setBusiType(log.getBusiType());
        third.setBusiDataId(log.getBusiDataId());
        third.setCreateTime(new Date());
        third.setSendContent(log.getSendContent());
        third.setSendTime(log.getSendTime());
        third.setReveiceContent(log.getReveiceContent());
        third.setReveiceTime(log.getReveiceTime());
        result = thirdInterfaceLogDAO.insertSelective(third) > 0;
      } else {
        result = false;
      }
    } catch (Exception e) {
      logger.error("CheckInServiceImpl insertInterfaceLog" + e);
      result = false;
    }
    return result;
  }

  @Override
  public ResultDTO getInHospState(String idCard, String insuredPersonName) {
    //查询checkin表，查询用户的入住记录
    CheckInDOExample example = new CheckInDOExample();
    Criteria criteria = example.createCriteria();
    criteria.andBeCarePersonCardEqualTo(idCard);
    criteria.andBeCarePersonNameEqualTo(insuredPersonName);
    criteria.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());
    example.setOrderByClause(" created_time desc ");
    List<CheckInDO> checkInDoList = checkInDAO.selectByExample(example);
    CheckInDO checkInDo = null;
    String inHospState;
    if (!checkInDoList.isEmpty()) {
      checkInDo = checkInDoList.get(0);
      inHospState = checkInDo.getInHospState().toString();
    } else {
      inHospState = InHospStateEnum.NULL.getValue() + "";
    }
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());
    resultDTO.setDatas(inHospState);
    return resultDTO;
  }

  public ResultDTO getCheckInHospState(String idCard, String insuredPersonName) {
    //查询checkin表，查询用户的入住记录
    CheckInDOExample example = new CheckInDOExample();
    Criteria criteria = example.createCriteria();
    criteria.andBeCarePersonCardEqualTo(idCard);
    criteria.andBeCarePersonNameEqualTo(insuredPersonName);
    criteria.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());
    example.setOrderByClause(" created_time desc ");
    List<CheckInDO> checkInDoList = checkInDAO.selectByExample(example);
    CheckInDO checkInDo = null;
    String inHospState;
    if (!checkInDoList.isEmpty()) {
      checkInDo = checkInDoList.get(0);
    } else {
      checkInDo = new CheckInDO();
      checkInDo.setInHospState(InHospStateEnum.NULL.getValue());
    }
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());
    resultDTO.setDatas(checkInDo);
    return resultDTO;
  }

  /**
   * 协议入住
   *
   * @param jsonString "nurseInfo":"{}"
   */
  @Transactional
  public ErrorReason registNurseInfo(String jsonString) {
    logger.debug(
        "_____经办接受专业 参保人入院记录CheckInServiceImpl >>>>>> registNurseInfo(String jsonString)......"
            + jsonString);
    ErrorReason errorReason = new ErrorReason();
    try {
      JSONObject object = JSONObject.parseObject(jsonString);
      CheckInRmqDO rmqDO =
          JSONObject.parseObject(object.getString("nurseInfo"), CheckInRmqDO.class);
      //查询协议表中有无此信息
      CheckInDOExample doExampleCheckin = new CheckInDOExample();
      Criteria criteriaCheckin = doExampleCheckin.createCriteria();
      criteriaCheckin.andInRecordUuidEqualTo(rmqDO.getInRecorduuid());
      criteriaCheckin.andInHospStateEqualTo(InHospStateEnum.out.getValue());
      List<CheckInDO> checkInDOs = checkInDAO.selectByExampleWithBLOBs(doExampleCheckin);
      if (!checkInDOs.isEmpty()) {
        logger.debug("_____经办将参保人入院信息插入失败," + rmqDO.getInRecorduuid() + "_____已存在。");
        errorReason.setErrorReasonCode(ErrorReasonStateEnum.IS_FAIL.getValue());
        errorReason.setErrorReason(rmqDO.getInRecorduuid() + "协议入住长护流水号已存在");
        return errorReason;
      }

      CheckInDO checkInDO = checkInRmqDOToCheckInDO(rmqDO);
      checkInDO.setInHospState(InHospStateEnum.out.getValue());
      checkInDO.setId(UUID.randomUUID().toString().replaceAll("-", ""));
      checkInDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
      checkInDO.setOperatedTime(new Date());
      checkInDO.setOperatedOrg(rmqDO.getOrgCode());

      //获取参保人的统筹区
      ResultDTO applicationResult =
          insuredPersonServerClient.getInsuredPersonDetail(
              "", checkInDO.getBeCarePersonCard(), checkInDO.getsCardNo());
      InsuredPersonDO insuredPersonDO =
          JSONObject.parseObject(
              JSONObject.toJSONString(applicationResult.getDatas()), InsuredPersonDO.class);
      if (insuredPersonDO != null) {
        checkInDO.setSiArea(insuredPersonDO.getSiArea());
      }
      //插入数据库
      int result = checkInDAO.insert(checkInDO);

      //通知东软系统
      if (result > 0) {
        //推送协议入住发送信息给东软
        if (!isWebserviceDebug) {
          logger.debug(
              "_____经办将参保人入院信息插入协议入住 通知东软CheckInServiceImpl >>>>>> wsService.registNurseInfo(registRequest, changhuCard)______start......");
          NurseInInfo registRequest = new NurseInInfo();
          registRequest.setBedNum(rmqDO.getBedNum());
          registRequest.setDepartment(rmqDO.getDepartment());
          registRequest.setDiseaseCode(rmqDO.getDiseaseCode());
          registRequest.setDiseaseName(rmqDO.getDiseaseName());
          registRequest.setInRecorduuid(rmqDO.getInRecorduuid());
          registRequest.setMedicalRecord(rmqDO.getMedicalRecord());
          registRequest.setMedicalType(rmqDO.getMedicalType());
          registRequest.setOperator(rmqDO.getOperator());
          registRequest.setUniqueNumber(checkInDO.getOrgCode().substring(6));
          if (rmqDO.getRealInDate() != null) {
            registRequest.setRealInDate(
                DateFormatUtil.dateToStr(
                    checkInDO.getRealInDate(), DateFormatUtil.DATE_FORMAT_YYYYMMDDHHMMSS));
          }

          ChanghuCard changhuCard = new ChanghuCard();
          changhuCard.setPSAMCardNum(rmqDO.getPsamCardNo());
          changhuCard.setSCardNo(rmqDO.getsCardNo());
          changhuCard.setSCardType(rmqDO.getSecurityCardType());
          changhuCard.setSIDNo(rmqDO.getBeCarePersonCardNum());
          changhuCard.setSName(rmqDO.getBeCarePersonName());

          errorReason = wsService.registNurseInfo(registRequest, changhuCard);
          if (ErrorReasonStateEnum.IS_FAIL
              .getValue()
              .equals(errorReason.getErrorReasonCode())) { //插入东软成功
            logger.debug(
                "_____经办将参保人入院信息插入协议入住 通知东软失败______end......:" + errorReason.getErrorReason());
            throw new ThrowsException("经办将参保人入院信息插入协议入住 通知东软失败：" + errorReason.getErrorReason());
          }
        }
      }
    } catch (Exception e) {
      errorReason.setErrorReasonCode(ErrorReasonStateEnum.IS_FAIL.getValue());
      errorReason.setErrorReason("参保人协议入住失败");
      logger.error("_________checkInAndToDR(MqBaseModel mqBaseModel)经办监听到协议入住后新增记录和通知东软出错：", e);
      throw new ThrowsException("参保人协议入住失败");
    }
    return errorReason;
  }

  /**
   * 协议退出
   *
   * @param jsonString "nurseOutInfo":"{}"
   */
  @Transactional
  public ErrorReason getNurseOutInfo(String jsonString) {
    ErrorReason errorReason = new ErrorReason();
    try {
      logger.debug(
          "_____经办接受专业服务参保人退出  通知东软CheckInServiceImpl >>>>>> getNurseOutInfo(String jsonString)______start......");
      JSONObject object = JSONObject.parseObject(jsonString);
      CheckInRmqDO rmqDO =
          JSONObject.parseObject(object.getString("nurseOutInfo"), CheckInRmqDO.class);
      CheckInDO checkInDO = checkInRmqDOToCheckInDO(rmqDO);
      checkInDO.setInHospState(InHospStateEnum.In.getValue());
      //查询数据库
      CheckInDOExample doExampleCheckin = new CheckInDOExample();
      Criteria criteriaCheckin = doExampleCheckin.createCriteria();
      criteriaCheckin.andInRecordUuidEqualTo(checkInDO.getInRecordUuid());
      List<CheckInDO> checkInDOs = checkInDAO.selectByExampleWithBLOBs(doExampleCheckin);

      //修改数据库
      int updateResult;
      CheckInDO checkInDOUpdate = new CheckInDO();
      if (checkInDOs != null && !checkInDOs.isEmpty()) {
        checkInDOUpdate = checkInDOs.get(0);
        checkInDOUpdate.setExitFrom(checkInDO.getExitFrom());
        //协议退出原因
        checkInDOUpdate.setExitReason(checkInDO.getExitReason());
        checkInDOUpdate.setExitReasonDetial(checkInDO.getExitReasonDetial());
        checkInDOUpdate.setInHospState(checkInDO.getInHospState());
        checkInDOUpdate.setRealOutDate(checkInDO.getRealOutDate());
        checkInDOUpdate.setOperatedBy(checkInDO.getOperatedBy());
        checkInDOUpdate.setOperatedTime(checkInDO.getOperatedTime());
        checkInDOUpdate.setInRecordUuid(checkInDO.getInRecordUuid());
        updateResult = checkInDAO.updateByPrimaryKeySelective(checkInDOUpdate);
      } else {
        updateResult = 0;
        errorReason.setErrorReasonCode(ErrorReasonStateEnum.IS_FAIL.getValue());
        errorReason.setErrorReason(rmqDO.getInRecorduuid() + "长护协议流水号不存在");
        return errorReason;
      }

      if (updateResult > 0) {
        //通知东软系统
        if (!isWebserviceDebug) {
          logger.debug(
              "_____经办通知东软参保人协议退出 wsService.getNurseOutInfo(nurseOutInfo)______start......");
          NurseOutInfo nurseOutInfo = new NurseOutInfo();
          nurseOutInfo.setBedNum(checkInDOUpdate.getBedNum());
          if (checkInDOUpdate.getMedicalType() != null) {
            nurseOutInfo.setCareType(checkInDOUpdate.getMedicalType());
          } else {
            nurseOutInfo.setCareType("31");
          }
          nurseOutInfo.setDepartment(checkInDOUpdate.getDepartment());
          nurseOutInfo.setInRecorduuid(checkInDOUpdate.getInRecordUuid());
          nurseOutInfo.setOperator(checkInDOUpdate.getOperatedBy());
          nurseOutInfo.setUniqueNumber(checkInDOUpdate.getOrgCode().substring(6));
          nurseOutInfo.setOutReason(checkInDOUpdate.getExitReason());
          if (checkInDOUpdate.getRealOutDate() != null) {
            nurseOutInfo.setRealOutDate(
                DateFormatUtil.dateToStr(
                    checkInDOUpdate.getRealOutDate(), DateFormatUtil.DATE_FORMAT_YYYYMMDDHHMMSS));
          }
          nurseOutInfo.setRxInfo(checkInDOUpdate.getMedicalRecord());

          //推送协议退出发送信息给东软
          errorReason = wsService.getNurseOutInfo(nurseOutInfo);
          if (ErrorReasonStateEnum.IS_FAIL.getValue().equals(errorReason.getErrorReasonCode())) {
            logger.debug("_____经办通知东软协议退出失败......:" + errorReason.getErrorReason());
            throw new ThrowsException("经办通知东软协议退出失败:" + errorReason.getErrorReason());
          }
          logger.debug(
              "_____经办监听长护参保人退出记录 修改协议退出 通知东软 wsService.getNurseOutInfo(nurseOutInfo)______end......");
        }
      }
    } catch (Exception e) {
      logger.error("_________getNurseOutInfo(nurseOutInfo)专业服务协议退出失败：", e);
      throw new ThrowsException("经办专业服务协议退出失败");
    }
    return errorReason;
  }

  /** 根据入住编号获取入住信息 */
  @Override
  public CheckInDTO getCheckInHospStateByInRecordUuid(String inRecordUuid) {

    CheckInDOExample example = new CheckInDOExample();
    Criteria criteria = example.createCriteria();
    criteria.andInRecordUuidEqualTo(inRecordUuid);
    List<CheckInDO> checkInDos = checkInDAO.selectByExample(example);
    if (!CollectionUtils.isEmpty(checkInDos)) {
      CheckInDO checkInDO = checkInDos.get(0);
      String checkInString =
          JSONObject.toJSONStringWithDateFormat(
              checkInDO, DateFormatUtil.DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
      return JSONObject.parseObject(checkInString, CheckInDTO.class);
    }
    return null;
  }
}
