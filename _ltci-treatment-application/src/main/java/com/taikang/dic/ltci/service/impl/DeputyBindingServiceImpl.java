package com.taikang.dic.ltci.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.taikang.dic.ltci.api.model.AttachmentDTO;
import com.taikang.dic.ltci.api.model.DeputyBindingCheckDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.api.model.TodoListDTO;
import com.taikang.dic.ltci.common.JsonUtils;
import com.taikang.dic.ltci.common.Result;
import com.taikang.dic.ltci.common.enumeration.ApplicationStatusEnum;
import com.taikang.dic.ltci.common.enumeration.ExecutionStatusEnum;
import com.taikang.dic.ltci.common.enumeration.FileTypeEnum;
import com.taikang.dic.ltci.common.enumeration.InHospStateEnum;
import com.taikang.dic.ltci.common.enumeration.IsValidEnum;
import com.taikang.dic.ltci.common.enumeration.MqTypeEnum;
import com.taikang.dic.ltci.common.enumeration.OperationTypeEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.enumeration.ToDoListEnum;
import com.taikang.dic.ltci.common.enumeration.ToDoListTypeEnum;
import com.taikang.dic.ltci.common.enumeration.TransportTypeEnum;
import com.taikang.dic.ltci.common.exception.InsertRepeatException;
import com.taikang.dic.ltci.common.exception.NotFoundByIdException;
import com.taikang.dic.ltci.common.exception.ThrowsException;
import com.taikang.dic.ltci.common.log.ThreadLocalUtil;
import com.taikang.dic.ltci.common.utils.SpringContextUtil;
import com.taikang.dic.ltci.common.utils.UrlUtil;
import com.taikang.dic.ltci.controller.DeputyBindingController;
import com.taikang.dic.ltci.dao.ApplicationDAO;
import com.taikang.dic.ltci.dao.DeputyBindingDAO;
import com.taikang.dic.ltci.dao.DeputyBindingSpecialDAO;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.InsuredPersonDAO;
import com.taikang.dic.ltci.dao.MQMessageLogDAO;
import com.taikang.dic.ltci.model.ApplicationDO;
import com.taikang.dic.ltci.model.ApplicationDOExample;
import com.taikang.dic.ltci.model.CheckInDO;
import com.taikang.dic.ltci.model.DeputyBindingDO;
import com.taikang.dic.ltci.model.DeputyBindingDOExample;
import com.taikang.dic.ltci.model.DeputyBindingResultDO;
import com.taikang.dic.ltci.model.DeputyBindingSpecialDO;
import com.taikang.dic.ltci.model.InsuredPersonDO;
import com.taikang.dic.ltci.model.InsuredPersonDOExample;
import com.taikang.dic.ltci.model.InsuredPersonDOExample.Criteria;
import com.taikang.dic.ltci.model.MQMessageLogDO;
import com.taikang.dic.ltci.model.MQMessageLogDOExample;
import com.taikang.dic.ltci.model.MqBaseModel;
import com.taikang.dic.ltci.model.MqFailMessageLogDO;
import com.taikang.dic.ltci.serverClient.AttachmentServiceClient;
import com.taikang.dic.ltci.serverClient.CheckInServerClient;
import com.taikang.dic.ltci.serverClient.TodoListServerClient;
import com.taikang.dic.ltci.service.DeputyBindingService;
import com.taikang.dic.ltci.service.DeputyBingdingSenderService;
import com.taikang.dic.ltci.service.IMqFailMessageLogService;

@Service
@Component
public class DeputyBindingServiceImpl extends AbstractGenericService<DeputyBindingDO, String>
    implements DeputyBindingService {
  private Logger logger = LoggerFactory.getLogger(ApplicationServiceImpl.class);

  @Autowired private DeputyBindingDAO deputyBindingDAO;
  @Autowired private InsuredPersonDAO insuredPersonDAO;
  @Autowired private DeputyBindingSpecialDAO deputyBindingSpecialDAO;
  @Autowired private DeputyBingdingSenderService deputyBingdingSenderService;
  @Autowired private MQMessageLogDAO mqMessageLogDAO;
  @Autowired private AttachmentServiceClient attachmentServiceClient;
  @Autowired private TodoListServerClient todoListServerClient;
  @Autowired private SpringContextUtil springContextUtil;
  @Autowired private IMqFailMessageLogService failMessageLogService;
  @Autowired private UrlUtil urlUtil;
  @Autowired private ApplicationDAO applicationDAO;
  @Autowired private CheckInServerClient checkInServerClient;

  @Value("${ltci.deputyBinding.queue}")
  private String queueName;

  @Value("${systemCharset}")
  private String systemCharset;

  public PageResultDTO queryDeputyBinding(
      String insuredPersonName,
      String idCard,
      String securityNumber,
      String deputyName,
      String deputyIdCard,
      String checkState,
      int page,
      int pageSize) {

    List<DeputyBindingSpecialDO> deputyBindings = null;
    String orgCodeParam = ThreadLocalUtil.threadLocal.get().getOperatedOrg();
    deputyBindings =
        deputyBindingSpecialDAO.queryDeputyBinding(
            insuredPersonName,
            idCard,
            securityNumber,
            deputyName,
            deputyIdCard,
            checkState,
            orgCodeParam,
            (page - 1) * pageSize,
            pageSize);
    logger.debug("deputyBindings：" + JSONObject.toJSONString(deputyBindings));
    //    if (null == deputyBindings || deputyBindings.isEmpty()) {
    //      throw new NotFoundByIdException("无此用户信息！");
    //    }

    Integer count =
        deputyBindingSpecialDAO.countDeputyBinding(
            insuredPersonName,
            idCard,
            securityNumber,
            deputyName,
            deputyIdCard,
            checkState,
            orgCodeParam);
    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;

    List<DeputyBindingCheckDTO> list = new ArrayList<>();
    for (DeputyBindingSpecialDO deputyBinding : deputyBindings) {
      DeputyBindingCheckDTO deputyBindingCheckDTO = new DeputyBindingCheckDTO();
      deputyBindingCheckDTO.setCheckState(deputyBinding.getCheckState());
      deputyBindingCheckDTO.setCheckReason(deputyBinding.getCheckReason());
      deputyBindingCheckDTO.setDeputyIdCard(deputyBinding.getDeputyIdCard());
      deputyBindingCheckDTO.setIdCard(deputyBinding.getIdCard());
      deputyBindingCheckDTO.setInsuredPersonName(deputyBinding.getInsuredPersonName());
      deputyBindingCheckDTO.setSecurityNumber(deputyBinding.getSecurityNumber());
      deputyBindingCheckDTO.setDeputyName(deputyBinding.getDeputyName());
      deputyBindingCheckDTO.setDeputyBindingid(deputyBinding.getDeputyBindingid());
      deputyBindingCheckDTO.setDeputyBindingCode(deputyBinding.getDeputyBindingCode());

      list.add(deputyBindingCheckDTO);
    }

    PageResultDTO pageResultDTO = new PageResultDTO();
    pageResultDTO.setDatas(list);
    pageResultDTO.setStatus(StatusCodeEnum.OK.getValue());
    pageResultDTO.setPage(page);
    pageResultDTO.setPageSize(pageSize);
    pageResultDTO.setTotalDataNum(count);
    pageResultDTO.setTotalPageNum(totalPage);
    pageResultDTO.setStatus(StatusCodeEnum.OK.getValue());
    pageResultDTO.setMessage("查询成功");

    return pageResultDTO;
  }

  private List<InsuredPersonDO> getInsuredPersonDOToDeputyBindingStatus(
      String idCard, String securityNumber) {
    //首先到参保人表中查询是否存在信息
    InsuredPersonDOExample insuredPersonDOExample = new InsuredPersonDOExample();
    Criteria criteria = insuredPersonDOExample.createCriteria();
    criteria.andIdCardEqualTo(idCard);
    criteria.andSecurityNumberEqualTo(securityNumber);

    List<InsuredPersonDO> insuredPersonDOs =
        insuredPersonDAO.selectByExample(insuredPersonDOExample);

    return insuredPersonDOs;
  }

  private List<ApplicationDO> getApplicationDOToDeputyBindingStatus(String insuredPersonCode) {
    ApplicationDOExample applicationDOExample = new ApplicationDOExample();
    com.taikang.dic.ltci.model.ApplicationDOExample.Criteria createCriteria =
        applicationDOExample.createCriteria();
    createCriteria.andInsuredPersonCodeEqualTo(insuredPersonCode);
    createCriteria.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());
    applicationDOExample.setOrderByClause("created_time desc");

    List<ApplicationDO> applicationDOs = applicationDAO.selectByExample(applicationDOExample);
    return applicationDOs;
  }

  @Override
  public Result getDeputyBindingStatus(DeputyBindingSpecialDO deputyBindingSpecialDO) {
    logger.debug("=====进入DeputyBindingService getDeputyBindingStatus方法=======");
    logger.debug(
        "=====deputyBindingSpecialDO【"
            + JSONObject.toJSONString(deputyBindingSpecialDO)
            + "】==========");

    Result result = new Result();
    Map<String, Object> map = new HashMap<>();
    String idCard = deputyBindingSpecialDO.getIdCard();
    String securityNumber = deputyBindingSpecialDO.getSecurityNumber();
    String deputyIdCard = deputyBindingSpecialDO.getDeputyIdCard();

    //首先到代理人绑定表中查询信息 如果已经绑定过不进行绑定 查询最近一条
    DeputyBindingSpecialDO deputyBindingDO =
        deputyBindingSpecialDAO.getDeputyBindingDOState(idCard, securityNumber, deputyIdCard);

    List<InsuredPersonDO> insuredPersonDOs = Lists.newArrayList();
    List<ApplicationDO> applicationDOs = Lists.newArrayList();
    //首先判断是否为空 如果为空进行参保人状态确认
    if (null == deputyBindingDO) {
      //首先到参保人表中查询是否存在信息
      insuredPersonDOs = getInsuredPersonDOToDeputyBindingStatus(idCard, securityNumber);

      if (insuredPersonDOs.isEmpty()) {
        //如果insuredPersonDOs为空 则直接返回没有参保人信息
        result.setStatus(StatusCodeEnum.OK.getValue());
        map.put("result", "1");
        map.put("resultDesc", "未查询到参保人信息，请进行待遇申请！");
        result.setDatas(map);
        result.setMessage("ok");
      }
      if (!insuredPersonDOs.isEmpty()) {
        //如果insuredPersonDOs不为空 查询待遇申请状态
        applicationDOs =
            getApplicationDOToDeputyBindingStatus(insuredPersonDOs.get(0).getInsuredPersonCode());

        if (applicationDOs.isEmpty()) {
          //如果待遇申请表无信息代表没有进行待遇申请
          result.setStatus(StatusCodeEnum.OK.getValue());
          map.put("result", "1");
          map.put("resultDesc", "此参保人未进行待遇申请，不可以进行绑定，请先进行待遇申请！");
          result.setDatas(map);
          result.setMessage("ok");
        }
        if (!applicationDOs.isEmpty()) {
          //如果待遇申请不为空 首先进行代理人身份证号比对
          if (!deputyIdCard.equalsIgnoreCase(applicationDOs.get(0).getDeputyIdCard())) {
            //代理人身份证号不匹配
            result.setStatus(StatusCodeEnum.OK.getValue());
            map.put("result", "1");
            map.put("resultDesc", "代理人身份证号不匹配，请确认！");
            result.setDatas(map);
            result.setMessage("ok");
          }
          if (deputyIdCard.equals(applicationDOs.get(0).getDeputyIdCard())) {
            //代理人身份证匹配
            String applicationStatus = applicationDOs.get(0).getApplicationStatus();
            if (ApplicationStatusEnum.NO_ACCEPT.getValue().equals(applicationStatus)
                || ApplicationStatusEnum.ALREADY_ACCEPT.getValue().equals(applicationStatus)
                || ApplicationStatusEnum.SUSPEND_ACCEPT.getValue().equals(applicationStatus)) {
              //待遇申请状态为未受理 已受理 暂停受理
              result.setStatus(StatusCodeEnum.OK.getValue());
              map.put("result", "1");
              map.put("resultDesc", "待遇申请未进行审核，请等待审核！");
              result.setDatas(map);
              result.setMessage("ok");
            }
            if (ApplicationStatusEnum.NOT_PASS_ACCEPT.getValue().equals(applicationStatus)) {
              //待遇申请状态为审核不通过
              result.setStatus(StatusCodeEnum.OK.getValue());
              map.put("result", "1");
              map.put("resultDesc", "待遇申请审核不通过，请重新进行待遇申请");
              result.setDatas(map);
              result.setMessage("ok");
            }
            if (ApplicationStatusEnum.PASS_ACCEPT.getValue().equals(applicationStatus)) {
              //待遇申请状态为审核通过
              //查询入院状态
              ResultDTO resultCheckIn =
                  checkInServerClient.getCheckInHospState(
                      idCard, insuredPersonDOs.get(0).getInsuredPersonName());

              CheckInDO checkInDO =
                  JSONObject.parseObject(
                      JSONObject.toJSONString(resultCheckIn.getDatas()), CheckInDO.class);
              if (InHospStateEnum.IN
                  .getValue()
                  .equals(String.valueOf(checkInDO.getInHospState()))) {
                //在院状态
                result.setStatus(StatusCodeEnum.OK.getValue());
                map.put("result", "0");
                map.put("resultDesc", "此参保人在院，可以发起绑定申请！");
                result.setDatas(map);
                result.setMessage("ok");
              }
              if (InHospStateEnum.OUT
                  .getValue()
                  .equals(String.valueOf(checkInDO.getInHospState()))) {
                //出院状态
                result.setStatus(StatusCodeEnum.OK.getValue());
                map.put("result", "1");
                map.put("resultDesc", "此参保人已经出院，不可进行绑定");

                if (checkInDO.getRealOutDate().after(applicationDOs.get(0).getOperatedTime())) {
                  map.put("result", "0");
                  map.put("resultDesc", "新待遇申请，可以进行代理人绑定");
                }
                result.setDatas(map);
                result.setMessage("ok");
              }
              if (InHospStateEnum.NULL
                  .getValue()
                  .equals(String.valueOf(checkInDO.getInHospState()))) {
                //无
                result.setStatus(StatusCodeEnum.OK.getValue());
                map.put("result", "0");
                map.put("resultDesc", "此参保人待遇申请审核通过，可以发起绑定申请！");
                result.setDatas(map);
                result.setMessage("ok");
              }
            }
          }
        }
      }
    }
    if (null != deputyBindingDO) {
      if ("01".equals(deputyBindingDO.getCheckState())) {
        //审核不通过 可以重新发送审核
        result.setStatus(StatusCodeEnum.OK.getValue());
        map.put("result", "0");
        map.put("resultDesc", "代理人与参保人未绑定，可以发起绑定申请！");
        result.setDatas(map);
        result.setMessage("ok");
      }
      if ("03".equals(deputyBindingDO.getCheckState())) {
        //绑定审核通过  不可以发送绑定申请
        result.setStatus(StatusCodeEnum.OK.getValue());
        map.put("result", "1");
        map.put("resultDesc", "参保人与代理人已经绑定，不可重复发起绑定申请！");

        if (!insuredPersonDOs.isEmpty() && !applicationDOs.isEmpty()) {
          if (deputyBindingDO.getOperatedTime().after(applicationDOs.get(0).getOperatedTime())) {
            map.put("result", "0");
            map.put("resultDesc", "新的代理人绑定申请，可以进行代理人绑定");
          }
        }
        result.setDatas(map);
        result.setMessage("ok");
      }
      if ("02".equals(deputyBindingDO.getCheckState())) {
        //待审核 不可以发送绑定申请
        result.setStatus(StatusCodeEnum.OK.getValue());
        map.put("result", "1");
        map.put("resultDesc", "参保人与代理人绑定审核中，不可重复发起绑定申请！");
        result.setDatas(map);
        result.setMessage("ok");
      }
    }

    logger.debug("====resultDTO【" + result.toString() + "】=======");
    return result;
  }

  /**
   * 代理人绑定人工审核（移动端->经办） mq监听
   *
   * @author itw_xuyao
   * @param byte[] message
   */
  @RabbitListener(queues = "${ltci.deputyBinding.queue}")
  public void createDeputyBinding(byte[] message) {
    //根据发送方节点IP地址 去选取应该接收的消息队列
    //暂时定为true 所有消息都接收
    logger.debug("=======进入DeputyBindingService createDeputyBinding方法=========");
    String mqMessage = "";
    MqBaseModel mqBaseModel = null;
    try {
      mqMessage = new String(message, systemCharset);
      //logger.debug("=======mq消息队列监听到的消息mqMessage【" + mqMessage + "】=========");

      //转成格式是否为MqBaseModel 待定
      mqBaseModel = JSONObject.parseObject(mqMessage, MqBaseModel.class);
      //logger.debug(
      //    "====转成mqBaseModel【" + JsonUtils.makeJsonForObject(mqBaseModel) + "】=============");

      //首先通过id和type到日志表中查询数据 判重复
      MQMessageLogDOExample doExample = new MQMessageLogDOExample();
      com.taikang.dic.ltci.model.MQMessageLogDOExample.Criteria criteriaMQ =
          doExample.createCriteria();
      criteriaMQ.andTypeEqualTo(MqTypeEnum.RECEIVE.getValue());
      criteriaMQ.andIdEqualTo(mqBaseModel.getBusinessSerialid().replaceAll("-", ""));

      List<MQMessageLogDO> mqMessageLogDOs = mqMessageLogDAO.selectByExample(doExample);
      if (!mqMessageLogDOs.isEmpty()) {
        logger.debug("======此id【" + mqBaseModel.getBusinessSerialid() + "】信息已经监听处理=============");
        return;
      }

      //在这个方法中做事务处理
      DeputyBindingServiceImpl bean =
          springContextUtil.getApplicationContext().getBean(DeputyBindingServiceImpl.class);
      bean.insertMqMessageLog(mqMessage);
      logger.debug("=====监听mq接收移动端生成代理人绑定代办信息完成==========");
    } catch (Exception e) {
      logger.info("监听代理人绑定信息捕获Exception异常", e);
      if (mqBaseModel != null
          && org.apache.commons.lang3.StringUtils.isNotBlank(mqBaseModel.getBusinessSerialid())) {
        MqFailMessageLogDO failLog = new MqFailMessageLogDO();
        failLog.setId(mqBaseModel.getBusinessSerialid().replaceAll("-", ""));
        failLog.setTransportType(TransportTypeEnum.ASYNCHRONIZE.getValue()); //交互方式：异步
        failLog.setOperationType(OperationTypeEnum.RECEIVE.getValue()); //发送接收类型
        failLog.setQueryName(queueName);
        failLog.setContent(mqMessage);
        failLog.setErrorMessage(e.getMessage());
        failLog.setCreateTime(new Date());
        failLog.setHttpAction(HttpMethod.POST.name());
        // 添加重试url
        failLog.setRetryUrl(urlUtil.getBaseUrl() + DeputyBindingController.RETRY_URL);
        failMessageLogService.saveOrUpdateFailLog(failLog);
      }
    }
  };

  @Override
  public DeputyBindingSpecialDO getDeputyBindingDO(String deputyBindingCode) {
    logger.debug("===进入getDeputyBindingDO方法根据deputyBindingid查询审核信息开始=========");
    //    DeputyBindingDOExample doExample = new DeputyBindingDOExample();
    //    com.taikang.dic.ltci.model.DeputyBindingDOExample.Criteria criteria =
    //        doExample.createCriteria();
    //    criteria.andDeputyBindingCodeEqualTo(deputyBindingCode);
    //    //criteria.andReceiveCharactarEqualTo(userId);
    //    List<DeputyBindingDO> deputybindingDOList = deputyBindingDAO.selectByExample(doExample);

    DeputyBindingSpecialDO deputyBindingSpecialDO =
        deputyBindingSpecialDAO.getDeputyBindSpecialDO(deputyBindingCode);
    if (null == deputyBindingSpecialDO) {
      throw new NotFoundByIdException("未查询到此信息");
    }

    //    logger.debug(
    //        "=====查询出的deputybindingDO【"
    //            + JsonUtils.makeJsonForObject(deputyBindingSpecialDO)
    //            + "】======");

    //查询出的文件id到mongodb中查询具体信息然后存入相应字段
    //代理人身份证扫描件
    //    if (!StringUtils.isEmpty(deputyBindingSpecialDO.getDeputyIdCardScan())) {
    //      String deputyIdCardScan = deputyBindingSpecialDO.getDeputyIdCardScan();
    //      String deputyIdCardScanJson = mongodbUtils.scanIdStrToJsonStr(deputyIdCardScan);
    //      deputyBindingSpecialDO.setDeputyIdCardScan(deputyIdCardScanJson);
    //    }
    //    //社保卡扫描件附件
    //    if (!StringUtils.isEmpty(deputyBindingSpecialDO.getSecurityNumberScan())) {
    //      String securityNumberScan = deputyBindingSpecialDO.getSecurityNumberScan();
    //      String securityNumberScanJson = mongodbUtils.scanIdStrToJsonStr(securityNumberScan);
    //      deputyBindingSpecialDO.setSecurityNumberScan(securityNumberScanJson);
    //    }
    //    //身份证扫描件附件
    //    if (!StringUtils.isEmpty(deputyBindingSpecialDO.getIdCardScan())) {
    //      String idCardScan = deputyBindingSpecialDO.getIdCardScan();
    //      String idCardScanJson = mongodbUtils.scanIdStrToJsonStr(idCardScan);
    //      deputyBindingSpecialDO.setIdCardScan(idCardScanJson);
    //    }
    //    //病例扫描件附件
    //    if (!StringUtils.isEmpty(deputyBindingSpecialDO.getCaseHistoryScan())) {
    //      String caseHistoryScan = deputyBindingSpecialDO.getCaseHistoryScan();
    //      String caseHistoryScanJson = mongodbUtils.scanIdStrToJsonStr(caseHistoryScan);
    //      deputyBindingSpecialDO.setCaseHistoryScan(caseHistoryScanJson);
    //    }
    //    //长护待遇申请表附件
    //    if (!StringUtils.isEmpty(deputyBindingSpecialDO.getApplicationFormScan())) {
    //      String applicationFormScan = deputyBindingSpecialDO.getApplicationFormScan();
    //      String applicationFormScanJson = mongodbUtils.scanIdStrToJsonStr(applicationFormScan);
    //      deputyBindingSpecialDO.setApplicationFormScan(applicationFormScanJson);
    //    }

    logger.debug("===进入getDeputyBindingDO方法根据deputyBindingid查询审核信息结束=========");
    return deputyBindingSpecialDO;
  }

  @Override
  @Transactional
  public Result updateDeputyBindingDO(DeputyBindingDO deputyBindingDO) {
    logger.debug("===进入updateDeputyBindingDO方法进行审核信息开始=========");
    String deputyBindingid = deputyBindingDO.getDeputyBindingid();
    String checkState = deputyBindingDO.getCheckState();
    logger.debug(
        "======将要修改的deputybindingDO【"
            + JsonUtils.makeJsonForObject(deputyBindingDO)
            + "】=========");
    DeputyBindingDO beforeDeputybindingDO = deputyBindingDAO.selectByPrimaryKey(deputyBindingid);
    InsuredPersonDOExample insuredPersonDOExample = new InsuredPersonDOExample();
    Criteria criteria = insuredPersonDOExample.createCriteria();
    criteria.andInsuredPersonCodeEqualTo(beforeDeputybindingDO.getInsuredPersonCode());

    List<InsuredPersonDO> selectByExample =
        insuredPersonDAO.selectByExample(insuredPersonDOExample);
    String insuredPersonName = "";
    if (!selectByExample.isEmpty()) {
      insuredPersonName = selectByExample.get(0).getInsuredPersonName();
      //      deputyBindingDO.setCreatedOrg(selectByExample.get(0).getCreatedOrg());
    }
    if (!"02".equals(beforeDeputybindingDO.getCheckState())) {
      throw new InsertRepeatException("记录已被他人操作，请刷新界面，重新选择数据！");
    }
    //添加状态作为修改条件
    DeputyBindingDOExample deputyBindingDOExample = new DeputyBindingDOExample();
    com.taikang.dic.ltci.model.DeputyBindingDOExample.Criteria createCriteria =
        deputyBindingDOExample.createCriteria();
    createCriteria.andCheckStateEqualTo("02");
    createCriteria.andDeputyBindingidEqualTo(deputyBindingDO.getDeputyBindingid());
    createCriteria.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());
    int i = deputyBindingDAO.updateByExampleSelective(deputyBindingDO, deputyBindingDOExample);

    //通过deputyBindingid查询出deputybindingDO 用户mq发送
    DeputyBindingDO sendDeputybindingDO = deputyBindingDAO.selectByPrimaryKey(deputyBindingid);

    logger.debug(
        "======将要mq发送的信息sendDeputybindingDO【"
            + JsonUtils.makeJsonForObject(sendDeputybindingDO)
            + "】==========");
    String serialNumber = sendDeputybindingDO.getSerialNumber();
    String deputyName = sendDeputybindingDO.getDeputyName();
    String deputyIdCard = sendDeputybindingDO.getDeputyIdCard();
    String idCard = sendDeputybindingDO.getIdCard();
    String securityNumber = sendDeputybindingDO.getSecurityNumber();
    String checkReason =
        sendDeputybindingDO.getCheckReason() != null ? sendDeputybindingDO.getCheckReason() : "";

    Result result = new Result();
    if (i > 0) {
      logger.debug("=====审核结束 开始删除代办信息=======");
      TodoListDTO todoListDTO = new TodoListDTO();
      todoListDTO.setBusinessCode(sendDeputybindingDO.getDeputyBindingCode());
      todoListDTO.setBusinessType(ToDoListEnum.BIND_MSG_DETAILS.getValue());
      todoListDTO.setCreatedBy(deputyBindingDO.getCreatedBy());
      todoListDTO.setCreatedOrg(deputyBindingDO.getCreatedOrg());
      try {
        ResultDTO resultDTO = todoListServerClient.deleteTodoList(todoListDTO);
        if (resultDTO.getStatus().equals(StatusCodeEnum.OK.getValue())) {
          result.setStatus(StatusCodeEnum.OK.getValue());
          result.setMessage("审核成功");
          deputyBingdingSenderService.sendDeputyBingdingState(
              serialNumber,
              deputyName,
              deputyIdCard,
              idCard,
              securityNumber,
              checkState,
              checkReason,
              insuredPersonName);
        } else {
          result.setStatus(StatusCodeEnum.INTERNAL_SERVER_ERROR.getValue());
          //删除代办任务失败
          result.setMessage("审核成功");
          deputyBingdingSenderService.sendDeputyBingdingState(
              serialNumber,
              deputyName,
              deputyIdCard,
              idCard,
              securityNumber,
              checkState,
              checkReason,
              insuredPersonName);
        }
      } catch (RuntimeException e) {
        logger.error("审核成功，但删除代办信息失败。", e);
        result.setStatus(StatusCodeEnum.OK.getValue());
        result.setMessage("审核成功。");
        logger.error("删除代办信息失败:" + e);
        return result;
      }
    } else {
      throw new InsertRepeatException("记录已被他人操作，请刷新界面，重新选择数据！");
    }

    logger.debug("========result【" + result.toString() + "】=============");
    logger.debug("===进入updateDeputyBindingDO方法进行审核信息结束=========");
    return result;
  }

  /**
   * 调用MongoDb的接口，存储文件
   *
   * @return
   */
  //  private String getMongoDbIds(List<MultipartFile> fileList) {
  //    String strFileIds = "";
  //    for (MultipartFile file : fileList) {
  //      strFileIds += ";" + uploadToMongoDb(file);
  //    }
  //    if (strFileIds.length() > 0) {
  //      strFileIds = strFileIds.substring(1);
  //    }
  //    return strFileIds;
  //  }

  /**
   * 调用MongoDb的接口，存储文件
   *
   * @return
   */
  //  private String uploadToMongoDb(MultipartFile file) {
  //    String fileName = file.getOriginalFilename();
  //    logger.debug("上传附件文件名为：" + fileName);
  //    if (file.isEmpty()) {
  //      throw new RuntimeException("上传失败：附件信息不能为空！");
  //    }
  //    long size = file.getSize();
  //    if (size > 1024 * 1024) {
  //      throw new RuntimeException("上传失败：附件大小不能超过1MB！");
  //    }
  //    return UUID.randomUUID().toString().replaceAll("-", "");
  //  }

  @Override
  public IGenericDAO<DeputyBindingDO, String> getDao() {
    return deputyBindingDAO;
  }

  public String getMongDBIds(String str) {
    //to do-------------根据字符串格式转成map获取数据 是否是map格式待定
    if (StringUtils.isEmpty(str)) {
      return null;
    }
    //    Map<String, Object> map = JSONObject.parseObject(str);
    @SuppressWarnings("unchecked")
    List<String> list = (List<String>) JSONArray.parse(str);
    StringBuilder idStr = new StringBuilder();
    String returnStr = "";

    for (String string : list) {
      String id = uploadToMediaFile(string);
      idStr.append("," + id);
    }
    //    for (String key : map.keySet()) {
    //    	String id = mongodbUtils.saveFile(map.get(key).toString());
    //    	idStr += "," + id;
    //    }
    if (idStr.length() > 0) {
      returnStr = idStr.substring(1);
    }
    return returnStr;
  }

  /**
   * 调用mediaFile的接口，存储文件流
   *
   * @return
   */
  private String uploadToMediaFile(String base64) {
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

  @Override
  public ResultDTO getDeputyBindingListQuery(String deputyIdCard) {

    ResultDTO resultDTO = new ResultDTO();

    List<DeputyBindingResultDO> list =
        deputyBindingSpecialDAO.getDeputyBindingListQuery(deputyIdCard);

    resultDTO.setDatas(list);
    resultDTO.setMessage("查询成功！");
    resultDTO.setNumber(list.size());
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());
    return resultDTO;
  }

  /**
   * 3.新增MQ日志信息表 4.添加巡查任务信息表 5.添加巡查任务日志表 6.添加任务明细表 7.添加资源信息表
   *
   * @param mqBaseModel
   */
  @Override
  @Transactional
  public ResultDTO insertMqMessageLog(String mqMessage) {
    ResultDTO resultDTO = new ResultDTO();
    MqBaseModel mqBaseModel = JSONObject.parseObject(mqMessage, MqBaseModel.class);

    DeputyBindingDO deputyBindingDO = null;
    //先将监听到的数据存入日志表
    MQMessageLogDO mqMessageLogDO = new MQMessageLogDO();
    mqMessageLogDO.setId(mqBaseModel.getBusinessSerialid().replaceAll("-", ""));
    mqMessageLogDO.setType(MqTypeEnum.RECEIVE.getValue());
    mqMessageLogDO.setSendContent(mqMessage);
    mqMessageLogDO.setSendTime(mqBaseModel.getTimestamp());
    mqMessageLogDO.setReSendNum(Long.parseLong("0"));
    //发送状态暂时写1
    mqMessageLogDO.setSendState("1");
    mqMessageLogDO.setCreateTime(new Date());
    mqMessageLogDO.setQueueName(queueName);
    mqMessageLogDAO.insert(mqMessageLogDO);

    try {
      deputyBindingDO =
          JSONObject.parseObject(
              JSONObject.toJSONString(mqBaseModel.getData()), DeputyBindingDO.class);
      //      logger.debug(
      //          "======mq传入信息中的实体信息deputyBindingDO【"
      //              + JsonUtils.makeJsonForObject(deputyBindingDO)
      //              + "】============");
    } catch (Exception e) {
      logger.error("监听移动端投诉信息数据格式转换错误：", e);
      throw new ThrowsException("监听移动端投诉信息数据转换错误");
    }

    //首先根据参保人身份证号和社保卡号到参保人表中查询参保人信息 如果为空则代表没有此参保人 返回结果插入失败
    InsuredPersonDOExample insuredPersonDOExample = new InsuredPersonDOExample();
    Criteria criteria = insuredPersonDOExample.createCriteria();
    criteria.andIdCardEqualTo(deputyBindingDO.getIdCard());
    criteria.andSecurityNumberEqualTo(deputyBindingDO.getSecurityNumber());
    List<InsuredPersonDO> doList = insuredPersonDAO.selectByExample(insuredPersonDOExample);
    if (doList.isEmpty()) {
      logger.debug("=====移动端发送信息为假数据=========");
      resultDTO.setStatus(ExecutionStatusEnum.FAILD.getValue());
      return resultDTO;
    }
    InsuredPersonDO insuredPersonDO = doList.get(0);

    //获取代理人身份证扫描件字符串
    String deputyIdCardScanStr = deputyBindingDO.getDeputyIdCardScan();
    //获取社保卡扫描件附件字符串
    String securityNumberScanStr = deputyBindingDO.getSecurityNumberScan();
    //获取身份证扫描件附件字符串
    String idCardScanStr = deputyBindingDO.getIdCardScan();
    //获取病例扫描件附件字符串
    //String caseHistoryScanStr = deputyBindingDO.getCaseHistoryScan();
    //获取长护待遇申请表附件字符串
    //String applicationFormScanStr = deputyBindingDO.getApplicationFormScan();

    //将文件存入mongoDB 返回id
    //获取代理人身份证扫描件id
    String deputyIdCardScanIdList = getMongDBIds(deputyIdCardScanStr);
    deputyBindingDO.setDeputyIdCardScan(deputyIdCardScanIdList);
    //获取社保卡扫描件附件id
    String securityNumberScanList = getMongDBIds(securityNumberScanStr);
    deputyBindingDO.setSecurityNumberScan(securityNumberScanList);
    //获取身份证扫描件id
    String idCardScanList = getMongDBIds(idCardScanStr);
    deputyBindingDO.setIdCardScan(idCardScanList);
    //获取病例扫描件附件id
    // String caseHistoryScanList = getMongDBIds(caseHistoryScanStr);
    // deputyBindingDO.setCaseHistoryScan(caseHistoryScanList);
    //获取长护待遇申请表附件id
    //          String applicationFormScanList = getMongDBIds(applicationFormScanStr);
    //          deputyBindingDO.setApplicationFormScan(applicationFormScanList);

    //主键id
    String uuid = UUID.randomUUID().toString().replaceAll("-", "");
    deputyBindingDO.setDeputyBindingid(uuid);
    //参保人code
    deputyBindingDO.setInsuredPersonCode(insuredPersonDO.getInsuredPersonCode());
    //绑定审核表编号暂时写死
    deputyBindingDO.setDeputyBindingCode(UUID.randomUUID().toString().replaceAll("-", ""));
    // 待审核状态待审核 02 审核不通过01 审核通过03
    deputyBindingDO.setCheckState("02");
    //将参保人机构信息存入绑定表创建机构字段
    deputyBindingDO.setCreatedOrg(insuredPersonDO.getOperatedOrg());
    deputyBindingDO.setCreatedTime(new Date());
    //将参保人机构信息存入绑定表经办机构字段
    deputyBindingDO.setOperatedOrg(insuredPersonDO.getOperatedOrg());
    deputyBindingDO.setOperatedTime(new Date());
    deputyBindingDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
    logger.debug(
        "====要存入的deputyBindingDO【" + JsonUtils.makeJsonForObject(deputyBindingDO) + "】=========");
    deputyBindingDAO.insert(deputyBindingDO);

    // 调用新增待办提醒接口 创建代办信息
    TodoListDTO todoListDTO = new TodoListDTO();
    todoListDTO.setTitle(
        "参保人"
            + insuredPersonDO.getInsuredPersonName()
            + "与代理人"
            + deputyBindingDO.getDeputyName()
            + "绑定审批");
    //url暂时未定 记得要拼接审核表id
    String ip = "";
    String port = "8090";
    String uri = "ltci-front-page/html/treatmentApply/bindMsgDetails.html";
    String url = "http://" + ip + ":8090/ltci-front-page/html/treatmentApply/bindMsgDetails.html";
    todoListDTO.setIp(ip);
    todoListDTO.setPort(port);
    todoListDTO.setUri(uri);
    todoListDTO.setUrl(url);
    todoListDTO.setBusinessCode(deputyBindingDO.getDeputyBindingCode());
    //TO DO 移动端传递过来的业务类型暂时写死
    todoListDTO.setBusinessType(ToDoListEnum.BIND_MSG_DETAILS.getValue());
    //类型 暂时写成代办01 提醒02
    todoListDTO.setType(ToDoListTypeEnum.TASK.getValue());
    //TO DO 讨论后暂时不要接收角色
    //todoListDO.setReceiveCharactar(deputyBindingDO.getOperatedBy());
    //创建人
    todoListDTO.setCreatedBy(deputyBindingDO.getCreatedBy());
    //创建机构---用的是参保人所在机构编码
    todoListDTO.setCreatedOrg(deputyBindingDO.getCreatedOrg());
    // 跳转方式 新窗口中打开
    todoListDTO.setJumpWay("_blank");
    //TO DO 行政区域暂时未存入
    logger.debug(
        "======将要生成代办信息todoListDO【" + JsonUtils.makeJsonForObject(todoListDTO) + "】=========");

    todoListServerClient.createTodoList(todoListDTO);

    resultDTO.setStatus(ExecutionStatusEnum.SUCCESS.getValue());
    return resultDTO;
  }
}
