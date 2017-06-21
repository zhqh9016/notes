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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.EvaluateEnum;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.exception.InsertRepeatException;
import com.taikang.dic.ltci.common.exception.NotFoundByIdException;
import com.taikang.dic.ltci.common.log.ThreadLocalUtil;
import com.taikang.dic.ltci.common.util.JsonUtils;
import com.taikang.dic.ltci.common.util.MediaFileUtils;
import com.taikang.dic.ltci.dao.EvaluateTaskDAO;
import com.taikang.dic.ltci.dao.EvaluateTaskLogDAO;
import com.taikang.dic.ltci.dao.ExpertEvaluateDAO;
import com.taikang.dic.ltci.dao.ExpertEvaluateSpecialDAO;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.model.ApplicationSimpleDO;
import com.taikang.dic.ltci.model.EvaluateTaskDO;
import com.taikang.dic.ltci.model.EvaluateTaskDOExample;
import com.taikang.dic.ltci.model.EvaluateTaskLogDO;
import com.taikang.dic.ltci.model.EvaluateTaskSpecialDO;
import com.taikang.dic.ltci.model.ExpertEvaluateDO;
import com.taikang.dic.ltci.model.ExpertEvaluateDOExample;
import com.taikang.dic.ltci.model.ExpertEvaluateDOExample.Criteria;
import com.taikang.dic.ltci.model.ExpertEvaluateSpecialDO;
import com.taikang.dic.ltci.serverClient.InsuredPersonServerClient;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.ExpertEvaluateService;

@Service
public class ExpertEvaluateServiceImpl extends AbstractGenericService<ExpertEvaluateDO, String>
    implements ExpertEvaluateService {

  private Logger logger = LoggerFactory.getLogger(ExpertEvaluateService.class);
  @Autowired private ExpertEvaluateDAO expertEvaluateDAO;
  @Autowired private EvaluateTaskDAO evaluateTaskDAO;
  @Autowired private ExpertEvaluateSpecialDAO expertEvaluateSpecialDAO;
  @Autowired private MediaFileUtils mediaFileUtils;
  @Autowired private EvaluateTaskLogDAO evaluateTaskLogDAO;
  @Autowired private InsuredPersonServerClient insuredPersonServerClient;

  @Override
  public PageResultDTO getExpertEvaluateList(
      String insuredPersonName,
      String idCard,
      String evaluateAgencyName,
      String operatedStartTime,
      String operatedEndTime,
      int page,
      int pageSize) {
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("insuredPersonName", insuredPersonName);
    map.put("idCard", idCard);
    map.put("evaluateAgencyName", evaluateAgencyName);
    map.put("operatedStartTime", operatedStartTime);
    map.put("operatedEndTime", operatedEndTime);
    map.put("operatedOrg", ThreadLocalUtil.threadLocal.get().getOperatedOrg());
    map.put("page", (page - 1) * pageSize);
    map.put("pageSize", pageSize);
    logger.info("查询条件为：" + JSONObject.toJSONString(map));
    List<ExpertEvaluateSpecialDO> expertEvaluateList =
        expertEvaluateSpecialDAO.getExpertEvaluate(map);

    //将expertEvaluateList里的待遇申请code取出，装成一个String串
    if (!expertEvaluateList.isEmpty()) {
      List<String> list = new ArrayList<String>();
      for (ExpertEvaluateSpecialDO expertEvaluate : expertEvaluateList) {
        list.add(expertEvaluate.getApplicationCode());
      }
      String applicationCodes = JSONArray.toJSONString(list);
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
        for (ExpertEvaluateSpecialDO expertEvaluate : expertEvaluateList) {
          if (applicationSimpleDO
              .getApplicationCode()
              .equals(expertEvaluate.getApplicationCode())) {
            expertEvaluate.setAddress(applicationSimpleDO.getAddress());
            expertEvaluate.setApplicationFormScan(applicationSimpleDO.getApplicationFormScan());
          }
        }
      }
    }

    logger.info("数据库查询的结果为" + JSONObject.toJSONString(expertEvaluateList));

    Integer count = expertEvaluateSpecialDAO.countExpertEvaluateList(map);
    logger.info("数据库查询的结果总数" + count);
    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;

    PageResultDTO pageResultDTO = new PageResultDTO();
    pageResultDTO.setDatas(expertEvaluateList);
    pageResultDTO.setPage(page);
    pageResultDTO.setPageSize(pageSize);
    pageResultDTO.setTotalDataNum(count);
    pageResultDTO.setTotalPageNum(totalPage);
    pageResultDTO.setMessage("查询成功");
    pageResultDTO.setStatus(StatusCodeEnum.OK.getValue());
    logger.info("pageResultDTO" + JSONObject.toJSONString(pageResultDTO));
    return pageResultDTO;
  }

  @Override
  public Map<String, Object> getExpertEvaluateScan(String expertEvaluateCode) {
    Map<String, Object> map = expertEvaluateSpecialDAO.getExpertEvaluateScan(expertEvaluateCode);
    if (null == map) {
      throw new NotFoundByIdException("未查询到结果");
    }
    logger.debug("=========查询出来的map【" + JsonUtils.makeJsonForObject(map) + "】=============");
    String accessoryAddress = (String) map.get("accessoryAddress");

    //将expertEvaluateList里的待遇申请code取出，装成一个String串
    List<String> applicationCodeList = new ArrayList<>();
    String applicationFormScan = null;
    if (!StringUtils.isEmpty((String) map.get("applicationCode"))) {
      applicationCodeList.add((String) map.get("applicationCode"));
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
        if (applicationSimpleDO.getApplicationCode().equals((String) map.get("applicationCode"))) {
          applicationFormScan = applicationSimpleDO.getApplicationFormScan();
        }
      }
    }

    accessoryAddress = mediaFileUtils.scanIdStrToJsonStr(accessoryAddress);
    applicationFormScan = mediaFileUtils.scanIdStrToJsonStr(applicationFormScan);
    map.put("accessoryAddress", accessoryAddress);
    map.put("applicationFormScan", applicationFormScan);
    return map;
  }

  @Override
  public IGenericDAO<ExpertEvaluateDO, String> getDao() {
    return expertEvaluateDAO;
  }

  @Transactional
  @Override
  public ResultDTO putExpertEvaluate(
      String expertEvaluateCode,
      String accessoryAddress,
      String evaluateContent,
      int fraction,
      String opinion,
      String operatedBy,
      String operatedOrg) {
    ExpertEvaluateDOExample example = new ExpertEvaluateDOExample();
    Criteria criteria = example.createCriteria();
    criteria.andExpertEvaluateCodeEqualTo(expertEvaluateCode);

    List<ExpertEvaluateDO> expertEvaluates = expertEvaluateDAO.selectByExampleWithBLOBs(example);

    if (expertEvaluates.isEmpty()) {
      throw new NotFoundByIdException("未查询到此条专家数据，提交失败");
    }

    //先修改专家评估表里的数据
    ExpertEvaluateDO expertEvaluateDO = expertEvaluates.get(0);
    expertEvaluateDO.setEvaluateContent(evaluateContent);
    expertEvaluateDO.setFraction(fraction);
    expertEvaluateDO.setOpinion(opinion);
    expertEvaluateDO.setOperatedBy(operatedBy);
    expertEvaluateDO.setOperatedOrg(operatedOrg);
    expertEvaluateDO.setOperatedTime(new Date());
    expertEvaluateDO.setAccessoryAddress(accessoryAddress);
    expertEvaluateDAO.updateByPrimaryKeySelective(expertEvaluateDO);

    //再将评估任务表里的状态设置为专家已经评估

    //要加上并发控制 插入的时候也要控制 where里状态是ALREADY_RECEIVE
    EvaluateTaskDO evaluateTaskDO = expertEvaluateSpecialDAO.getEvaluateTask(expertEvaluateCode);

    logger.debug("evaluateTaskDO:" + JSONObject.toJSONString(evaluateTaskDO));

    evaluateTaskDO.setTaskState(EvaluateEnum.NO_DELIVERY.getValue());
    evaluateTaskDO.setOperatedTime(new Date());

    //更新评估任务表状态

    EvaluateTaskDOExample evaluateTaskDOExample = new EvaluateTaskDOExample();

    com.taikang.dic.ltci.model.EvaluateTaskDOExample.Criteria createCriteria =
        evaluateTaskDOExample.createCriteria();

    createCriteria.andEvaluateTaskidEqualTo(evaluateTaskDO.getEvaluateTaskid());
    createCriteria.andTaskStateEqualTo(EvaluateEnum.ALREADY_RECEIVE.getValue());
    int updateResult =
        evaluateTaskDAO.updateByExampleSelective(evaluateTaskDO, evaluateTaskDOExample);

    if (updateResult < 1) {
      //代表更新没有成功，或者并发冲突了
      throw new InsertRepeatException("提交失败，请刷新页面后再提交");
    }

    //给评估任务日志表添加记录
    EvaluateTaskLogDO taskLogDO = new EvaluateTaskLogDO();
    taskLogDO.setEvaluateTaskLogid(UUID.randomUUID().toString().replaceAll("-", ""));
    taskLogDO.setEvaluateTaskCode(evaluateTaskDO.getEvaluateTaskCode());
    taskLogDO.setTaskState(evaluateTaskDO.getTaskState());
    taskLogDO.setTaskDeadline(evaluateTaskDO.getTaskDeadline().toString());
    taskLogDO.setEvaluateAgencyCode(evaluateTaskDO.getEvaluateAgencyCode());
    taskLogDO.setEvaluateAgencyName(evaluateTaskDO.getEvaluateAgencyName());
    taskLogDO.setCreatedBy(operatedBy);
    taskLogDO.setCreatedTime(new Date());

    logger.debug(JSONObject.toJSONString(taskLogDO));
    evaluateTaskLogDAO.insert(taskLogDO);

    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setMessage("修改成功");
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());
    return resultDTO;
  }
}
