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
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.api.model.TodoListDTO;
import com.taikang.dic.ltci.common.enumeration.EvaluateEnum;
import com.taikang.dic.ltci.common.enumeration.ExecutionStatusEnum;
import com.taikang.dic.ltci.common.enumeration.IsValidEnum;
import com.taikang.dic.ltci.common.enumeration.MqTypeEnum;
import com.taikang.dic.ltci.common.enumeration.OperationTypeEnum;
import com.taikang.dic.ltci.common.enumeration.ToDoListEnum;
import com.taikang.dic.ltci.common.enumeration.ToDoListTypeEnum;
import com.taikang.dic.ltci.common.enumeration.TransportTypeEnum;
import com.taikang.dic.ltci.common.exception.ParametersIsNullException;
import com.taikang.dic.ltci.common.exception.ThrowsException;
import com.taikang.dic.ltci.common.log.ThreadLocalUtil;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.common.util.JsonUtils;
import com.taikang.dic.ltci.common.util.SpringContextUtil;
import com.taikang.dic.ltci.common.util.UrlUtil;
import com.taikang.dic.ltci.controller.FirstEvaluateController;
import com.taikang.dic.ltci.dao.EvaluateTaskDAO;
import com.taikang.dic.ltci.dao.EvaluateTaskLogDAO;
import com.taikang.dic.ltci.dao.ExpertEvaluateDAO;
import com.taikang.dic.ltci.dao.FirstEvaluateDAO;
import com.taikang.dic.ltci.dao.FirstEvaluateSpecialDAO;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.MQMessageLogDAO;
import com.taikang.dic.ltci.model.ApplicationSimpleDO;
import com.taikang.dic.ltci.model.DetailJsonDO;
import com.taikang.dic.ltci.model.EvaluateTaskDO;
import com.taikang.dic.ltci.model.EvaluateTaskDOExample;
import com.taikang.dic.ltci.model.EvaluateTaskDOExample.Criteria;
import com.taikang.dic.ltci.model.EvaluateTaskLogDO;
import com.taikang.dic.ltci.model.ExpertEvaluateDO;
import com.taikang.dic.ltci.model.FirstEvaluateDO;
import com.taikang.dic.ltci.model.FirstEvaluateSpecialDO;
import com.taikang.dic.ltci.model.InsuredPersonDO;
import com.taikang.dic.ltci.model.MQMessageLogDO;
import com.taikang.dic.ltci.model.MQMessageLogDOExample;
import com.taikang.dic.ltci.model.MqBaseModel;
import com.taikang.dic.ltci.model.MqFailMessageLogDO;
import com.taikang.dic.ltci.model.TodoListDO;
import com.taikang.dic.ltci.serverClient.InsuredPersonServerClient;
import com.taikang.dic.ltci.serverClient.TodoListServerClient;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.FirstEvaluateService;
import com.taikang.dic.ltci.service.IMqFailMessageLogService;

@Service
@Component
public class FirstEvaluateServiceImpl extends AbstractGenericService<FirstEvaluateDO, String>
    implements FirstEvaluateService {
  private Logger logger = LoggerFactory.getLogger(FirstEvaluateServiceImpl.class);

  @Autowired private FirstEvaluateDAO firstEvaluateDAO;
  @Autowired private EvaluateTaskDAO evaluateTaskDAO;
  @Autowired private ExpertEvaluateDAO expertEvaluateDAO;
  @Autowired private FirstEvaluateSpecialDAO firstEvaluateSpecialDAO;
  @Autowired private MQMessageLogDAO mqMessageLogDAO;
  @Autowired private EvaluateTaskLogDAO evaluateTaskLogDAO;
  @Autowired private TodoListServerClient todoListServerClient;
  @Autowired private SpringContextUtil springContextUtil;
  @Autowired private IMqFailMessageLogService failMessageLogService;
  @Autowired private UrlUtil urlUtil;
  @Autowired private InsuredPersonServerClient insuredPersonServerClient;

  @Value("${ltci.firstEvaluate.queue}")
  private String queueName;

  @Value("${systemCharset}")
  private String systemCharset;

  /**
   * 评估初评结果的mq接收（专业服务->经办） mq监听
   *
   * @author itw_xuyao
   * @param String message
   */
  @RabbitListener(queues = "${ltci.firstEvaluate.queue}")
  public void getEvaluateReceive(byte[] message) {
    logger.debug("=======进入getEvaluateReceive方法=========");
    logger.debug("=====queue【" + queueName + "】==========");
    String mqMessage = "";
    MqBaseModel mqBaseModel = null;
    try {
      //根据发送方节点IP地址 去选取应该接收的消息队列
      //暂时定为true 所有消息都接收
      mqMessage = new String(message, systemCharset);
      logger.debug("=======进入FirstEvaluateServiceImpl getEvaluateReceive方法=========");
      logger.debug("=======mq消息队列监听到的消息Message【" + mqMessage + "】=========");

      //转成格式是否为MqBaseModel 待定
      mqBaseModel = JSONObject.parseObject(mqMessage, MqBaseModel.class);
      logger.debug(
          "====转成mqBaseModel【" + JsonUtils.makeJsonForObject(mqBaseModel) + "】=============");

      //通过判断messageCode筛选信息
      //messageCode需要双方制定

      //首先通过id和type到日志表中查询数据 判重复
      MQMessageLogDOExample doExample = new MQMessageLogDOExample();
      com.taikang.dic.ltci.model.MQMessageLogDOExample.Criteria criteria =
          doExample.createCriteria();
      criteria.andTypeEqualTo(MqTypeEnum.RECEIVE.getValue());
      criteria.andIdEqualTo(mqBaseModel.getBusinessSerialid());

      List<MQMessageLogDO> mqMessageLogDOs = mqMessageLogDAO.selectByExample(doExample);
      if (mqMessageLogDOs.size() > 0) {
        logger.debug("======此id【" + mqBaseModel.getBusinessSerialid() + "】信息已经监听处理=============");
        return;
      }

      //在这个方法中做事务处理
      FirstEvaluateServiceImpl bean =
          springContextUtil.getApplicationContext().getBean(FirstEvaluateServiceImpl.class);
      bean.insertMqMessageLog(mqMessage);

      logger.debug("=====监听mq接收专业服务评估初评结果信息完成==========");
    } catch (Exception e) {
      logger.error("初评结果接收报错", e);
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
        failLog.setRetryUrl(urlUtil.getBaseUrl() + FirstEvaluateController.RETRY_URL);
        failMessageLogService.saveOrUpdateFailLog(failLog);
      }
    }
  };

  @Override
  public Map<String, Object> getFirstEvaluate(
      String insuredPersonName,
      String idCard,
      String evaluateOrg,
      String operatedTime,
      int page,
      int pageSize,
      String operatedOrg) {
    //首先查询是否存入代办提醒信息 如果存有进行删除

    ResultDTO resultDTO =
        todoListServerClient.getTodoListByBusinessType(
            ToDoListEnum.RECEIVE_INITIAL_RESULT.getValue(), operatedOrg);
    List<TodoListDO> todoListDOs =
        JSONArray.parseArray(JSONArray.toJSONString(resultDTO.getDatas()), TodoListDO.class);
    logger.debug("=======todoListDOs【" + JSONObject.toJSONString(todoListDOs) + "】===========");

    if (!todoListDOs.isEmpty()) {
      //不为为空  删除代办提醒信息
      TodoListDTO todoListDTO = new TodoListDTO();
      todoListDTO.setBusinessType(ToDoListEnum.RECEIVE_INITIAL_RESULT.getValue());
      todoListDTO.setBusinessCode(ToDoListEnum.RECEIVE_INITIAL_RESULT.getValue());
      todoListDTO.setCreatedOrg(operatedOrg);
      todoListServerClient.deleteTodoList(todoListDTO);
    }

    //进行查询信息
    Map<String, Object> mapForSelect = new HashMap<String, Object>();
    mapForSelect.put("insuredPersonName", insuredPersonName);
    mapForSelect.put("idCard", idCard);
    mapForSelect.put("evaluateOrg", evaluateOrg);
    mapForSelect.put("page", (page - 1) * pageSize);
    mapForSelect.put("pageSize", pageSize);
    if (null != operatedTime && !"".equals(operatedTime)) {
      mapForSelect.put("operatedTimeStart", DateFormatUtil.getDayFirstTime(operatedTime));
      mapForSelect.put("operatedTimeEnd", DateFormatUtil.getDayLastTime(operatedTime));
    }
    mapForSelect.put("operatedOrg", ThreadLocalUtil.threadLocal.get().getOperatedOrg());

    List<FirstEvaluateSpecialDO> firstEvaluateSpecialDOs =
        firstEvaluateSpecialDAO.getFirstEvaluate(mapForSelect);
    //将firstEvaluateSpecialDOs里的待遇申请appliacationCode取出，装成一个String串
    List<String> applicationCodeList = new ArrayList<>();
    if (!firstEvaluateSpecialDOs.isEmpty()) {
      for (int i = 0; i < firstEvaluateSpecialDOs.size(); i++) {
        applicationCodeList.add(firstEvaluateSpecialDOs.get(i).getApplicationCode());
      }
      String applicationCodes = JSONArray.toJSONString(applicationCodeList);
      logger.debug("appliacationCode:" + applicationCodes);

      //调用待遇申请微服务获取参保人地址
      ResultDTO applicationResult =
          insuredPersonServerClient.getApplicationSimple(applicationCodes);

      String applicationSimple = JSONObject.toJSONString(applicationResult.getDatas());
      List<ApplicationSimpleDO> applicationSimpleDOs =
          JSONArray.parseArray(applicationSimple, ApplicationSimpleDO.class);

      for (ApplicationSimpleDO applicationSimpleDO : applicationSimpleDOs) {
        for (FirstEvaluateSpecialDO firstEvaluateSpecialDO : firstEvaluateSpecialDOs) {
          if (applicationSimpleDO
              .getApplicationCode()
              .equals(firstEvaluateSpecialDO.getApplicationCode())) {
            firstEvaluateSpecialDO.setAddress(applicationSimpleDO.getAddress());
          }
        }
      }
    }

    Integer count = firstEvaluateSpecialDAO.countFirstEvaluate(mapForSelect);
    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("firstEvaluateSpecialDOs", firstEvaluateSpecialDOs);
    map.put("page", page);
    map.put("pageSize", pageSize);
    map.put("count", count);
    map.put("totalPage", totalPage);
    logger.debug("====getFirstEvaluate返回的map【" + JsonUtils.makeJsonForObject(map) + "】==========");

    return map;
  }

  @Override
  public IGenericDAO<FirstEvaluateDO, String> getDao() {
    //Auto-generated method stub
    return firstEvaluateDAO;
  }

  /**
   * 3.新增MQ日志信息表 4.添加巡查任务信息表 5.添加巡查任务日志表 6.添加任务明细表 7.添加资源信息表
   *
   * @param mqBaseModel
   */
  @Override
  @Transactional
  public ResultDTO insertMqMessageLog(String mqMessage) {
    ResultDTO dto = new ResultDTO();

    MqBaseModel mqBaseModel = JSONObject.parseObject(mqMessage, MqBaseModel.class);
    FirstEvaluateDO firstEvaluateDO = null;
    DetailJsonDO detailJsonDO = null;
    //先将监听到的数据存入日志表
    MQMessageLogDO mqMessageLogDO = new MQMessageLogDO();
    mqMessageLogDO.setId(mqBaseModel.getBusinessSerialid());
    mqMessageLogDO.setType(MqTypeEnum.RECEIVE.getValue());
    mqMessageLogDO.setSendContent(mqMessage);
    //发送状态暂时写1
    mqMessageLogDO.setSendState("1");
    mqMessageLogDO.setCreateTime(new Date());
    mqMessageLogDO.setQueueName(queueName);
    mqMessageLogDAO.insert(mqMessageLogDO);

    try {
      //存入初评返回表
      firstEvaluateDO =
          JSONObject.parseObject(
              JSONObject.toJSONString(mqBaseModel.getData()), FirstEvaluateDO.class);
      logger.debug(
          "======mq传入信息中的实体信息FirstEvaluateDO【"
              + JsonUtils.makeJsonForObject(firstEvaluateDO)
              + "】============");
      detailJsonDO = JSONObject.parseObject(firstEvaluateDO.getDetailJson(), DetailJsonDO.class);
      logger.debug(
          "======mq传入信息中的实体信息detailJsonDO【"
              + JsonUtils.makeJsonForObject(detailJsonDO)
              + "】============");
    } catch (Exception e) {
      logger.error("监听移动端投诉信息数据格式转换错误：", e);
      throw new ThrowsException("监听移动端投诉信息数据转换错误");
    }

    //通过evaluateTaskCode到evaluateTask表中查询统筹区存入初评表和专家评定表
    String evaluateTaskCode = firstEvaluateDO.getEvaluateTaskCode();
    EvaluateTaskDOExample evaluateTaskDOExample = new EvaluateTaskDOExample();
    Criteria criteria = evaluateTaskDOExample.createCriteria();
    criteria.andEvaluateTaskCodeEqualTo(evaluateTaskCode);

    List<EvaluateTaskDO> selectByExample = evaluateTaskDAO.selectByExample(evaluateTaskDOExample);
    String siArea = "";
    if (!selectByExample.isEmpty()) {
      siArea = selectByExample.get(0).getSiArea() != null ? selectByExample.get(0).getSiArea() : "";
    }
    logger.debug(
        "====evaluateTaskCode【" + evaluateTaskCode + "】对应的siArea【" + siArea + "】=========");

    firstEvaluateDO.setFirstEvaluateid(UUID.randomUUID().toString().replaceAll("-", ""));
    //初评结果业务code暂时用uuid
    firstEvaluateDO.setFirstEvaluateCode(UUID.randomUUID().toString().replaceAll("-", ""));
    firstEvaluateDO.setOperatedBy(firstEvaluateDO.getEvaluateName());
    firstEvaluateDO.setOperatedOrg(detailJsonDO.getNurseOrgCd());
    firstEvaluateDO.setOperatedTime(firstEvaluateDO.getEvaluateDate());
    firstEvaluateDO.setCreatedBy(firstEvaluateDO.getEvaluateName());
    firstEvaluateDO.setCreatedOrg(detailJsonDO.getNurseOrgCd());
    firstEvaluateDO.setCreatedTime(firstEvaluateDO.getEvaluateDate());
    firstEvaluateDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
    firstEvaluateDO.setSiArea(siArea);
    logger.debug(
        "======firstEvaluateDO【" + JSONObject.toJSONString(firstEvaluateDO) + "】==========");
    firstEvaluateDAO.insert(firstEvaluateDO);

    //更改evaluateTask表中状态前存入日志表
    EvaluateTaskLogDO evaluateTaskLogDO = new EvaluateTaskLogDO();
    evaluateTaskLogDO.setEvaluateTaskLogid(UUID.randomUUID().toString().replaceAll("-", ""));
    evaluateTaskLogDO.setEvaluateTaskCode(firstEvaluateDO.getEvaluateTaskCode());
    evaluateTaskLogDO.setTaskState(EvaluateEnum.ALREADY_RECEIVE.getValue());
    evaluateTaskLogDO.setEvaluateAgencyName(firstEvaluateDO.getOperatedOrg());
    evaluateTaskLogDO.setSendTime(new Date());
    evaluateTaskLogDO.setCreatedBy(firstEvaluateDO.getCreatedBy());
    evaluateTaskLogDO.setCreatedOrg(detailJsonDO.getNurseOrgCd());
    evaluateTaskLogDO.setCreatedTime(firstEvaluateDO.getOperatedTime());
    logger.debug(
        "======evaluateTaskLogDO【" + JSONObject.toJSONString(evaluateTaskLogDO) + "】==========");
    evaluateTaskLogDAO.insert(evaluateTaskLogDO);

    //更改evaluateTask表中状态
    EvaluateTaskDO evaluateTaskDO = new EvaluateTaskDO();
    evaluateTaskDO.setTaskState(EvaluateEnum.ALREADY_RECEIVE.getValue());
    evaluateTaskDO.setOperatedTime(new Date());

    EvaluateTaskDOExample doExampleTask = new EvaluateTaskDOExample();
    Criteria criteriaTask = doExampleTask.createCriteria();
    criteriaTask.andEvaluateTaskCodeEqualTo(firstEvaluateDO.getEvaluateTaskCode());
    logger.debug("======evaluateTaskDO【" + JSONObject.toJSONString(evaluateTaskDO) + "】==========");
    evaluateTaskDAO.updateByExampleSelective(evaluateTaskDO, doExampleTask);

    //插入专家评定表
    ExpertEvaluateDO expertEvaluateDO = new ExpertEvaluateDO();
    expertEvaluateDO.setExpertEvaluateid(UUID.randomUUID().toString().replaceAll("-", ""));
    expertEvaluateDO.setExpertEvaluateCode(UUID.randomUUID().toString().replaceAll("-", ""));
    expertEvaluateDO.setFirstEvaluateCode(firstEvaluateDO.getFirstEvaluateCode());
    expertEvaluateDO.setCreatedBy(firstEvaluateDO.getOperatedBy());
    expertEvaluateDO.setCreatedOrg(detailJsonDO.getNurseOrgCd());
    expertEvaluateDO.setCreatedTime(firstEvaluateDO.getOperatedTime());
    expertEvaluateDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
    expertEvaluateDO.setSiArea(siArea);
    logger.debug(
        "======expertEvaluateDO【" + JSONObject.toJSONString(expertEvaluateDO) + "】==========");
    expertEvaluateDAO.insert(expertEvaluateDO);

    //生成代办提醒 先查询判重
    ResultDTO resultDTO =
        todoListServerClient.getTodoListByBusinessType(
            ToDoListEnum.RECEIVE_INITIAL_RESULT.getValue(), detailJsonDO.getNurseOrgCd());
    List<TodoListDO> todoListDOs =
        JSONArray.parseArray(JSONArray.toJSONString(resultDTO.getDatas()), TodoListDO.class);
    logger.debug("=======todoListDOs【" + JSONObject.toJSONString(todoListDOs) + "】===========");

    if (todoListDOs.isEmpty()) {
      //为空  生成代办提醒信息
      TodoListDTO todoListDTO = new TodoListDTO();
      todoListDTO.setBusinessType(ToDoListEnum.RECEIVE_INITIAL_RESULT.getValue());
      todoListDTO.setBusinessCode(ToDoListEnum.RECEIVE_INITIAL_RESULT.getValue());
      todoListDTO.setTitle("初评结果接收提醒！");
      todoListDTO.setType(ToDoListTypeEnum.REMIND.getValue());
      todoListDTO.setCreatedBy(firstEvaluateDO.getEvaluateName());
      todoListDTO.setCreatedOrg(detailJsonDO.getNurseOrgCd());
      logger.debug("======todoListDTO【" + JSONObject.toJSONString(todoListDTO) + "】==========");
      todoListServerClient.createTodoList(todoListDTO);
    }
    dto.setStatus(ExecutionStatusEnum.SUCCESS.getValue());
    return dto;
  }

  @Override
  public FirstEvaluateSpecialDO getFirstDetail(String firstEvaluateCode) throws Exception {
    if (StringUtils.isEmpty(firstEvaluateCode)) {
      throw new ParametersIsNullException("传入参数firstEvaluateCode为空！");
    }
    FirstEvaluateSpecialDO firstEvaluateSpecialDO =
        firstEvaluateSpecialDAO.getFirstDetail(firstEvaluateCode);
    String insuredPersonCode = firstEvaluateSpecialDO.getInsuredPersonCode();
    logger.debug("===insuredPersonCode【" + insuredPersonCode + "】========");

    ResultDTO resultDTOFromIns =
        insuredPersonServerClient.getInsuredPersonMessage(insuredPersonCode);
    logger.debug(
        "====resultDTOFromIns【" + JSONObject.toJSONString(resultDTOFromIns) + "】==========");
    InsuredPersonDO insuredPersonDO =
        JSONObject.parseObject(
            JSONObject.toJSONString(resultDTOFromIns.getDatas()), InsuredPersonDO.class);
    String name =
        insuredPersonDO.getInsuredPersonName() != null
            ? insuredPersonDO.getInsuredPersonName()
            : "";
    String idCard = insuredPersonDO.getIdCard() != null ? insuredPersonDO.getIdCard() : "";
    String personnelIdentityCode =
        insuredPersonDO.getPersonnelIdentityCode() != null
            ? insuredPersonDO.getPersonnelIdentityCode()
            : "";
    String personnelIdentityName =
        insuredPersonDO.getPersonnelIdentityName() != null
            ? insuredPersonDO.getPersonnelIdentityName()
            : "";
    String securityNumber =
        insuredPersonDO.getSecurityNumber() != null ? insuredPersonDO.getSecurityNumber() : "";

    firstEvaluateSpecialDO.setInsuredPersonName(name);
    firstEvaluateSpecialDO.setIdCard(idCard);
    firstEvaluateSpecialDO.setPersonnelIdentityCode(personnelIdentityCode);
    firstEvaluateSpecialDO.setPersonnelIdentityName(personnelIdentityName);
    firstEvaluateSpecialDO.setSecurityNumber(securityNumber);

    return firstEvaluateSpecialDO;
  }
}
