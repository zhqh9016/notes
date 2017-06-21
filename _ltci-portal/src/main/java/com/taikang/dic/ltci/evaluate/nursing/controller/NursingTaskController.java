package com.taikang.dic.ltci.evaluate.nursing.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.evaluate.nursing.service.NursingTaskService;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class NursingTaskController {

  private static final Logger logger = LoggerFactory.getLogger(FirstEvaluateController.class);

  @Autowired private NursingTaskService nursingTaskService;

  /**
   * 修改意向机构
   *
   * @param nursingTaskCodes
   * @param intentAgencyCodes
   * @param operatedBy
   * @param operatedOrg
   * @return
   */
  @RequestMapping(value = "/nursingTaskIntentAgency", method = RequestMethod.PUT)
  public ResultDTO updateNursingTaskIntentAgency(
      @RequestParam(value = "nursingTaskCodes") String nursingTaskCodes,
      @RequestParam(value = "intentAgencyCode") String intentAgencyCode,
      @RequestParam(value = "applyType") String applyType,
      @RequestParam(value = "isRelativeCared") String isRelativeCared) {
    logger.info("-------------------updateNursingTaskIntentAgency------------");
    logger.info("-------------------nursingTaskCodes:" + nursingTaskCodes + "---------------");
    logger.info("-------------------intentAgencyCode:" + intentAgencyCode + "-------------");
    logger.info("-------------------applyType:" + applyType + "------------");
    logger.info("-------------------isRelativeCared:" + isRelativeCared + "------------");
    return nursingTaskService.updateNursingTaskIntentAgency(
        nursingTaskCodes, intentAgencyCode, applyType, isRelativeCared);
  }

  /**
   * 选择最终护理机构
   *
   * @param nursingTaskCodes
   * @param intentAgencyCodes
   * @param operatedBy
   * @param operatedOrg
   * @return
   */
  @RequestMapping(value = "/nursingTaskFinalAgency", method = RequestMethod.PUT)
  public ResultDTO updateNursingTaskFinalAgency(
      @RequestParam(value = "nursingTaskCodes") String nursingTaskCodes,
      @RequestParam(value = "finalAgencyCode") String finalAgencyCode,
      @RequestParam(value = "finalAgencyName") String finalAgencyName,
      @RequestParam(value = "applyType") String applyType,
      @RequestParam(value = "isRelativeCared") String isRelativeCared) {
    logger.info("-------------------updateNursingTaskIntentAgency------------");
    logger.info("-------------------nursingTaskCodes:" + nursingTaskCodes + "---------");
    logger.info("-------------------finalAgencyCode:" + finalAgencyCode + "----------");
    logger.info("-------------------finalAgencyName:" + finalAgencyName + "-----------");
    logger.info("-------------------applyType:" + applyType + "------------");
    logger.info("-------------------isRelativeCared:" + isRelativeCared + "------------");

    return nursingTaskService.updateNursingTaskFinalAgency(
        nursingTaskCodes, finalAgencyCode, finalAgencyName, applyType, isRelativeCared);
  }

  /**
   * 护理机构确认页面列表查询
   *
   * @param insuredPersonName
   * @param idCard
   * @param evaluateAgencyName
   * @param operatedTime
   * @param state
   * @param page
   * @param pageSize
   * @return
   */
  @RequestMapping(value = "/nursingTasks", method = RequestMethod.POST)
  public PageResultDTO listExpertTask(
      String insuredPersonName,
      String idCard,
      String evaluateAgencyName,
      String operatedTime,
      String state,
      @RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "pageSize", defaultValue = "15") int pageSize) {
    logger.debug("=======进入评估结果送达页面查询信息===============");
    logger.debug("=======insuredPersonName【" + insuredPersonName + "】============");
    logger.debug("=======idCard【" + idCard + "】==========");
    logger.debug("=======evaluateAgencyName【" + evaluateAgencyName + "】=========");
    logger.debug("=======operatedTime【" + operatedTime + "】=======");
    logger.debug("=======taskState【" + state + "】=======");
    logger.debug("=======page【" + page + "】=======");
    logger.debug("=======pageSize【" + pageSize + "】=======");

    PageResultDTO pageResultDTO =
        nursingTaskService.getNursingTaskList(
            insuredPersonName, idCard, evaluateAgencyName, operatedTime, state, page, pageSize);

    logger.debug("=======进入初评结果查询接口结束===============");
    return pageResultDTO;
  }
}
