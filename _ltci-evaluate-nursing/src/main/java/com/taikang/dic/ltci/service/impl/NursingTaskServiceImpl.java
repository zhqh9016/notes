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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.IsValidEnum;
import com.taikang.dic.ltci.common.enumeration.ModuleCodeEnum;
import com.taikang.dic.ltci.common.enumeration.MqTypeEnum;
import com.taikang.dic.ltci.common.enumeration.NursingTaskEnum;
import com.taikang.dic.ltci.common.enumeration.OperationTypeEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
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
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.MQMessageLogDAO;
import com.taikang.dic.ltci.dao.NursingTaskDAO;
import com.taikang.dic.ltci.dao.NursingTaskSpecialDAO;
import com.taikang.dic.ltci.model.ApplicationSimpleDO;
import com.taikang.dic.ltci.model.EvaluateTaskSpecialDO;
import com.taikang.dic.ltci.model.MQMessageLogDO;
import com.taikang.dic.ltci.model.MqBaseModel;
import com.taikang.dic.ltci.model.MqFailMessageLogDO;
import com.taikang.dic.ltci.model.NursingTaskDO;
import com.taikang.dic.ltci.model.NursingTaskDOExample;
import com.taikang.dic.ltci.model.NursingTaskDOExample.Criteria;
import com.taikang.dic.ltci.serverClient.InsuredPersonServerClient;
import com.taikang.dic.ltci.model.NursingTaskSpecialDO;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.EvaluateTaskService;
import com.taikang.dic.ltci.service.NursingTaskService;

@Service
public class NursingTaskServiceImpl extends AbstractGenericService<NursingTaskDO, String>
    implements NursingTaskService {
  private static final Logger logger = LoggerFactory.getLogger(NursingTaskServiceImpl.class);

  @Autowired private NursingTaskDAO nursingTaskDAO;
  @Autowired private NursingTaskSpecialDAO nursingTaskSpecialDAO;
  @Autowired private EvaluateTaskService evaluateTaskService;
  @Autowired private MQMessageLogDAO mqMessageLogDAO;
  @Autowired private MediaFileUtils mediaFileUtils;
  @Autowired private InsuredPersonServerClient insuredPersonServerClient;
  @Autowired private MqFailMessageLogServiceImpl failMessageLogService;

  @Value("${ltci.nursingTaskLongTermService.queue}")
  private String longTermServiceRoutingKey;

  @Value("${ltci.nursingTaskLongTermService.exchange}")
  private String longTermServiceExchangeName;

  @Value("${ltci.sendNursingTaskLongTermService.messageCode}")
  private String longTermServiceMessageCode;

  @Value("${ltci.nursingTaskBigData.queue}")
  private String bigDataRoutingKey;

  @Value("${ltci.nursingTaskBigData.exchange}")
  private String bigDataExchangeName;

  @Value("${ltci.sendNursingTaskBigData.messageCode}")
  private String bigDataMessageCode;

  @Override
  public IGenericDAO<NursingTaskDO, String> getDao() {
    return nursingTaskDAO;
  }

  /** 修改意向选择机构 */
  @Override
  public ResultDTO updateNursingTaskIntentAgency(
      String nursingTaskCodes,
      String intentAgencyCode,
      String applyType,
      String isRelativeCared,
      String operatedBy,
      String operatedOrg) {
    if (StringUtils.isBlank(nursingTaskCodes)) {
      throw new ParametersIsNullException("修改意向机构的请求参数不能为空！");
    }

    String[] nursingTaskCodeArrs = nursingTaskCodes.split(",");
    for (String nursingTaskCode : nursingTaskCodeArrs) {
      NursingTaskDO nursingTaskDO = new NursingTaskDO();

      nursingTaskDO.setIntentAgency(intentAgencyCode);
      if (StringUtils.isBlank(intentAgencyCode)) {
        //如果为空表示修改为未选择意向机构
        nursingTaskDO.setState(NursingTaskEnum.NO_INTENT_AGENCY.getValue());
      } else {
        nursingTaskDO.setState(NursingTaskEnum.ALREADY_INTENT_AGENCY.getValue());
      }

      nursingTaskDO.setApplyType(applyType);
      nursingTaskDO.setIsRelativeCared(isRelativeCared);

      nursingTaskDO.setOperatedBy(operatedBy);
      nursingTaskDO.setOperatedOrg(operatedOrg);
      nursingTaskDO.setOperatedTime(new Date());

      NursingTaskDOExample doExample = new NursingTaskDOExample();
      Criteria criteria = doExample.createCriteria();
      criteria.andNursingTaskCodeEqualTo(nursingTaskCode);

      nursingTaskDAO.updateByExampleSelective(nursingTaskDO, doExample);
    }

    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.CREATED.getValue());
    resultDTO.setMessage("意向选择机构机构确认成功！");
    return resultDTO;
  }

  @Override
  public int createNursingTask(NursingTaskDO uursingTaskDO) {
    return nursingTaskDAO.insert(uursingTaskDO);
  }

  /** 选择最终护理机构 1.发送MQ请求 2.记录发送日志 3.修改数据库状态 4.新增协议信息 5.返回ResultDTO信息 */
  @Transactional
  @Override
  public ResultDTO updateNursingTaskFinalAgency(
      String nursingTaskCodes,
      String finalAgencyCode,
      String finalAgencyName,
      String applyType,
      String isRelativeCared,
      String operatedBy,
      String operatedOrg) {
    if (StringUtils.isBlank(nursingTaskCodes)
        || StringUtils.isBlank(finalAgencyCode)
        || StringUtils.isBlank(finalAgencyName)) {
      throw new ParametersIsNullException("选择最终护理机构的请求参数不能为空！");
    }

    String[] nursingTaskCodeArrs = nursingTaskCodes.split(",");
    for (String nursingTaskCode : nursingTaskCodeArrs) {
      //1.修改数据库状态
      NursingTaskDO nursingTaskDO = new NursingTaskDO();
      nursingTaskDO.setFinalAgencyCode(finalAgencyCode);
      nursingTaskDO.setFinalAgencyName(finalAgencyName);
      nursingTaskDO.setState(NursingTaskEnum.ALREADY_FINAL_AGENCY.getValue());

      nursingTaskDO.setApplyType(applyType);
      nursingTaskDO.setIsRelativeCared(isRelativeCared);

      nursingTaskDO.setOperatedBy(operatedBy);
      nursingTaskDO.setOperatedOrg(operatedOrg);
      nursingTaskDO.setOperatedTime(new Date());

      NursingTaskDOExample doExample = new NursingTaskDOExample();
      Criteria criteria = doExample.createCriteria();
      criteria.andNursingTaskCodeEqualTo(nursingTaskCode);
      criteria.andStateEqualTo(NursingTaskEnum.NO_INTENT_AGENCY.getValue());
      criteria.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());

      NursingTaskDOExample doExample1 = new NursingTaskDOExample();
      Criteria criteria1 = doExample1.createCriteria();
      criteria1.andNursingTaskCodeEqualTo(nursingTaskCode);
      criteria1.andStateEqualTo(NursingTaskEnum.ALREADY_INTENT_AGENCY.getValue());
      criteria1.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());

      doExample.or(criteria1);

      int size = nursingTaskDAO.updateByExampleSelective(nursingTaskDO, doExample);
      if (size == 0) {
        throw new InsertRepeatException("记录已被他人操作，请刷新界面，重新选择数据！");
      }
    }

    for (String nursingTaskCode : nursingTaskCodeArrs) {
      Date date = new Date();
      //2.查询护理任务详细信息，作为发送数据
      //封装MqBaseModel信息
      Map<String, Object> map;
      try {
        map = getMqDetailsMsg(nursingTaskCode, applyType, isRelativeCared, operatedBy, operatedOrg);
      } catch (Exception e1) {
        logger.error("错误信息：" + e1);
        continue;
      }
      MqBaseModel mqBaseModel = new MqBaseModel();
      mqBaseModel.setBusinessSerialid(UUID.randomUUID().toString().replaceAll("-", ""));
      mqBaseModel.setTimestamp(DateFormat.getLocalDateTime());
      try {
        mqBaseModel.setNodeIP(IPUtil.getLocalIp());
      } catch (Exception e) {
        logger.error("错误信息：" + e);
        throw new ThrowsException("获取本地IP失败！");
      }
      mqBaseModel.setSystemCode(systemCode);
      mqBaseModel.setModuleCode(ModuleCodeEnum.SEND_NURSING_TASK.getValue());
      mqBaseModel.setMessageCode(longTermServiceMessageCode);
      mqBaseModel.setData(map);
      String jsonString = JSONObject.toJSONString(mqBaseModel);
      //3.创建日志基本信息
      MQMessageLogDO mqLogDo = new MQMessageLogDO();
      mqLogDo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
      mqLogDo.setType(MqTypeEnum.SEND.getValue());
      mqLogDo.setSendTime(date);
      mqLogDo.setCreateTime(date);
      mqLogDo.setReSendNum(0L);
      mqLogDo.setSendState("0"); //成功
      mqLogDo.setExchangeName(longTermServiceExchangeName);
      mqLogDo.setQueueName(longTermServiceRoutingKey);
      mqLogDo.setSendContent(jsonString);

      //4.保存日志信息
      mqMessageLogDAO.insert(mqLogDo);
      logger.debug("====sendEvaluateTask start:" + DateFormatUtil.dateToTimeStr(date));
      //5.发送专业服务信息
      try {
        sendMessage(longTermServiceExchangeName, longTermServiceRoutingKey, jsonString);
      } catch (Exception e) {
        logger.info("发送MQ失败错误：", e);
        mqMessageLogDAO.deleteByPrimaryKey(mqLogDo.getId());
        MqFailMessageLogDO failLog = new MqFailMessageLogDO();

        failLog.setId(mqLogDo.getId());
        failLog.setTransportType(TransportTypeEnum.ASYNCHRONIZE.getValue()); //交互方式：异步
        failLog.setOperationType(OperationTypeEnum.SEND.getValue()); //发送接收类型
        failLog.setExchangeName(longTermServiceExchangeName);
        failLog.setQueryName(longTermServiceRoutingKey);
        failLog.setContent(jsonString);
        failLog.setErrorMessage(e.getMessage());
        failLog.setCreateTime(new Date());
        failLog.setHttpAction(HttpMethod.POST.name());
        // 添加重试url
        failMessageLogService.saveOrUpdateFailLog(failLog);
      }

      logger.debug("====sendEvaluateTask end:" + DateFormatUtil.dateToTimeStr(date));
      /* modify by itw_huodd; at date 05-28; desc : 一个交换机下有两个队列，只需要忘一个队列发消息，另一个队列也会收到，不需要同时往两个队列发消息
      //6.发送大数据信息
      mqBaseModel.setMessageCode(bigDataMessageCode);
      jsonString = JSONObject.toJSONString(mqBaseModel);

      //7.创建日志基本信息
      mqLogDo = new MQMessageLogDO();
      mqLogDo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
      mqLogDo.setType(MqTypeEnum.SEND.getValue());
      mqLogDo.setSendTime(date);
      mqLogDo.setCreateTime(date);
      mqLogDo.setReSendNum(0L);
      mqLogDo.setSendState("0"); //成功
      mqLogDo.setExchangeName(bigDataExchangeName);
      mqLogDo.setQueueName(bigDataRoutingKey);
      mqLogDo.setSendContent(jsonString);

      //8.保存日志信息
      mqMessageLogDAO.insert(mqLogDo);
      try {
        sendMessage(bigDataExchangeName, bigDataRoutingKey, jsonString);
      } catch (Exception e) {
        logger.info("发送MQ失败错误：", e);
        mqMessageLogDAO.deleteByPrimaryKey(mqLogDo.getId());
        MqFailMessageLogDO failLog = new MqFailMessageLogDO();

        failLog.setId(mqLogDo.getId());
        failLog.setTransportType(TransportTypeEnum.ASYNCHRONIZE.getValue()); //交互方式：异步
        failLog.setOperationType(OperationTypeEnum.SEND.getValue()); //发送接收类型
        failLog.setExchangeName(bigDataExchangeName);
        failLog.setQueryName(bigDataRoutingKey);
        failLog.setContent(jsonString);
        failLog.setErrorMessage(e.getMessage());
        failLog.setCreateTime(new Date());
        failLog.setHttpAction(HttpMethod.POST.name());
        // 添加重试url
        failMessageLogService.saveOrUpdateFailLog(failLog);
      }
      logger.debug("====sendEvaluateTask end:" + DateFormatUtil.dateToTimeStr(date));
      */
    }

    //5.返回结果信息
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(StatusCodeEnum.CREATED.getValue());
    resultDTO.setMessage("选择最终护理机构成功！");
    return resultDTO;
  }

  @Override
  public Map<String, Object> getNursingTaskList(
      String insuredPersonName,
      String idCard,
      String evaluateAgencyName,
      String operatedTime,
      String State,
      int page,
      int pageSize) {
    Map<String, Object> mapForSelect = new HashMap<>();
    mapForSelect.put("insuredPersonName", insuredPersonName);
    mapForSelect.put("idCard", idCard);
    mapForSelect.put("evaluateAgencyName", evaluateAgencyName);
    if (StringUtils.isNotBlank(State)) {
      String[] arr = State.split(",");
      mapForSelect.put("State", arr);
    }
    mapForSelect.put("page", (page - 1) * pageSize);
    mapForSelect.put("pageSize", pageSize);
    if (null != operatedTime && !"".equals(operatedTime)) {
      mapForSelect.put("operatedTimeStart", DateFormatUtil.getDayFirstTime(operatedTime));
      mapForSelect.put("operatedTimeEnd", DateFormatUtil.getDayLastTime(operatedTime));
    }
    mapForSelect.put("operatedOrg", ThreadLocalUtil.threadLocal.get().getOperatedOrg());

    List<NursingTaskSpecialDO> nursingTaskSpecialDOs =
        nursingTaskSpecialDAO.getNursingTaskList(mapForSelect);
    for (NursingTaskSpecialDO nursingTaskSpecialDO : nursingTaskSpecialDOs) {
      nursingTaskSpecialDO.setScore(nursingTaskSpecialDO.getScore().split("\\.")[0]);
    }

    //将expertEvaluateList里的待遇申请code取出，装成一个String串
    List<String> applicationCodeList = new ArrayList<>();
    if (!nursingTaskSpecialDOs.isEmpty()) {
      for (int i = 0; i < nursingTaskSpecialDOs.size(); i++) {
        applicationCodeList.add(nursingTaskSpecialDOs.get(i).getApplicationCode());
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
        for (NursingTaskSpecialDO nursingTaskSpecialDO : nursingTaskSpecialDOs) {
          if (applicationSimpleDO
              .getApplicationCode()
              .equals(nursingTaskSpecialDO.getApplicationCode())) {
            nursingTaskSpecialDO.setAddress(applicationSimpleDO.getAddress());
          }
        }
      }
    }

    Integer count = nursingTaskSpecialDAO.countNursingTaskList(mapForSelect);
    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    Map<String, Object> map = new HashMap<>();
    map.put("nursingTaskSpecialDOs", nursingTaskSpecialDOs);
    map.put("page", page);
    map.put("pageSize", pageSize);
    map.put("count", count);
    map.put("totalPage", totalPage);
    logger.debug("====getFirstEvaluate返回的map【" + JsonUtils.makeJsonForObject(map) + "】==========");

    return map;
  }

  @Override
  public int insertNursingTaskList(List<NursingTaskDO> list) {
    return nursingTaskSpecialDAO.insertNursingTaskList(list);
  }
  /**
   * 根据护理任务编号查询具体发送信息，拼接为Map发送
   *
   * @param nursingTaskCode
   * @return
   */
  private Map<String, Object> getMqDetailsMsg(
      String nursingTaskCode,
      String applyType,
      String isRelativeCared,
      String operatedBy,
      String operatedOrg) {

    Map<String, Object> map = new HashMap<>();

    NursingTaskDO nursingTaskDO = getNursingTaskByCode(nursingTaskCode);

    EvaluateTaskSpecialDO evaluateTaskSpecialDO =
        evaluateTaskService.getEvaluateTaskSpecialDOByCode(nursingTaskDO.getEvaluateTaskCode());

    if (evaluateTaskSpecialDO == null) {
      throw new NotFoundByIdException("根据护理任务Code:" + nursingTaskCode + " 关联查询评估信息失败，未找到该评估任务");
    }

    map.put("address", evaluateTaskSpecialDO.getAddress());
    map.put("areaCode", evaluateTaskSpecialDO.getAreaCode());
    map.put("bidType", applyType);
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
    map.put("idCard", evaluateTaskSpecialDO.getIdCard());
    map.put("insuredPersonGender", evaluateTaskSpecialDO.getInsuredPersonGender());
    map.put("insuredPersonName", evaluateTaskSpecialDO.getInsuredPersonName());

    map.put("isRelativeCared", isRelativeCared);
    map.put("isTaskDeadline", evaluateTaskSpecialDO.getTaskDeadline());
    map.put("married", evaluateTaskSpecialDO.getMarried());
    map.put("mobile", evaluateTaskSpecialDO.getMobile());
    map.put("nation", evaluateTaskSpecialDO.getNation());
    map.put("finalAgencyName", nursingTaskDO.getFinalAgencyName());

    map.put("nursingTaskCode", nursingTaskCode);
    map.put("occupationid", evaluateTaskSpecialDO.getOccupationid());
    map.put("operatedBy", operatedBy);
    map.put("operatedOrg", operatedOrg);
    map.put("orgName", evaluateTaskSpecialDO.getOrgName());

    map.put("politicsid", evaluateTaskSpecialDO.getPoliticsid());
    map.put("provinceCode", evaluateTaskSpecialDO.getProvinceCode());
    map.put("securityNumber", evaluateTaskSpecialDO.getSecurityNumber());
    map.put("siArea", evaluateTaskSpecialDO.getSiArea());
    map.put("finalAgencyCode", nursingTaskDO.getFinalAgencyCode());

    //-----------------新增专家评分和专家意见-----------------------
    if (evaluateTaskSpecialDO.getFraction() == null) {
      map.put("fraction", 0);
    } else {
      map.put("fraction", evaluateTaskSpecialDO.getFraction());
    }
    map.put("opinion", evaluateTaskSpecialDO.getOpinion());
    //    String accessoryAddress = evaluateTaskSpecialDO.getAccessoryAddress();
    //    map.put("accessoryAddress", mediaFileUtils.scanIdStrToMapStr(accessoryAddress));

    //附件信息
    String idCardScan = evaluateTaskSpecialDO.getIdCardScan();
    map.put("idCardScan", mediaFileUtils.scanIdStrToMapStr(idCardScan));
    String securityNumberScan = evaluateTaskSpecialDO.getSecurityNumberScan();
    map.put("securityNumberScan", mediaFileUtils.scanIdStrToMapStr(securityNumberScan));
    String deputyIdCardScan = evaluateTaskSpecialDO.getDeputyIdCardScan();
    map.put("deputyIdCardScan", mediaFileUtils.scanIdStrToMapStr(deputyIdCardScan));
    return map;
  }

  /**
   * 根据Code查询护理详细信息
   *
   * @param nursingTaskCode
   * @return
   */
  public NursingTaskDO getNursingTaskByCode(String nursingTaskCode) {
    NursingTaskDOExample doExample = new NursingTaskDOExample();
    Criteria criteria = doExample.createCriteria();
    criteria.andNursingTaskCodeEqualTo(nursingTaskCode);
    criteria.andIsValidEqualTo(IsValidEnum.NO_DELETE.getValue());

    List<NursingTaskDO> list = nursingTaskDAO.selectByExample(doExample);
    if (list.isEmpty()) {
      throw new NotFoundByIdException("根据Code: " + nursingTaskCode + " 查询护理任务失败，未找到该护理任务");
    }
    if (list.size() > 1) {
      throw new ThrowsException("根据Code: " + nursingTaskCode + " 查询护理任务失败，数据库存在多条重复数据");
    }
    return list.get(0);
  }

  /**
   * 根据Code查询护理详细信息
   *
   * @param nursingTaskCode
   * @return
   */
  public boolean getNursingTaskByEvaluateTaskCode(String evaluateTaskCode) {
    NursingTaskDOExample doExample = new NursingTaskDOExample();
    Criteria criteria = doExample.createCriteria();
    criteria.andEvaluateTaskCodeEqualTo(evaluateTaskCode);
    List<NursingTaskDO> list = nursingTaskDAO.selectByExample(doExample);
    if (!list.isEmpty()) {
      logger.debug("====evaluateTaskCode：" + evaluateTaskCode + "，已经产生护理对象任务==========");
      return false;
    } else {
      return true;
    }
  }
}
