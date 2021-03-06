package com.taikang.dic.ltci.evaluate.nursing.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.evaluate.nursing.service.EvaluateTaskService;
import com.taikang.dic.ltci.portal.api.model.AttachmentDTO;
import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.common.util.Encodes;

/**
 * 评估任务controller
 *
 * @author itw_xuxf
 * @version 2017年4月14日上午9:25:03
 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class EvaluateTaskController {
  @Autowired private EvaluateTaskService evaluateTaskService;
  private Logger logger = LoggerFactory.getLogger(EvaluateTaskController.class);

  /**
   * 根据评估任务code查询详情信息
   *
   * @param evaluateTaskCode
   * @return
   */
  @RequestMapping(path = "/evaluateTask/{evaluateTaskCode}")
  @ResponseBody
  public ResultDTO evaluateTaskGet(@PathVariable String evaluateTaskCode) {
    return null;
  }

  /**
   * 分页查询评估任务列表
   *
   * @param insuredPersonName
   * @param mobile
   * @param taskstate
   * @param operatedTime
   * @param page
   * @param pageSize
   * @return
   */
  @RequestMapping(value = "/evaluateTasks", method = RequestMethod.POST)
  @ResponseBody
  public PageResultDTO evaluateTaskList(
      @RequestParam(value = "insuredPersonName", defaultValue = "") String insuredPersonName,
      @RequestParam(value = "mobile", defaultValue = "") String mobile,
      @RequestParam(value = "taskState", defaultValue = "") String taskState,
      @RequestParam(value = "operatedTime", defaultValue = "") String operatedTime,
      @RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
    return evaluateTaskService.queryEvaluateTaskList(
        insuredPersonName, mobile, operatedTime, taskState, page, pageSize);
  }

  @RequestMapping(value = "/toDoListEvaluateTaskList", method = RequestMethod.GET)
  public ResultDTO getToDoListEvaluateTaskList() {
    return evaluateTaskService.getToDoListEvaluateTaskList();
  }

  /**
   * 评估任务发送 批量任务发送
   *
   * @param evaluateTaskCodes
   * @param evaluateAgencyCode
   * @param evaluateAgencyName
   * @return
   */
  @RequestMapping(value = "/evaluateTask", method = RequestMethod.PUT)
  public ResultDTO sendEvaluateTask(@RequestParam String evaluateTaskCodes) {
    return evaluateTaskService.sendEvaluateTaskBatch(evaluateTaskCodes);
  }

  @RequestMapping(
    value = "/evaluateDepartments/areaNum/{areaNum}/organizationType/{organizationType}",
    method = RequestMethod.GET
  )
  public ResultDTO getEvaluateDepartments(
      @PathVariable String areaNum, @PathVariable String organizationType) {
    ResultDTO resultDTO = evaluateTaskService.getEvaluateDepartments(areaNum, organizationType);
    return resultDTO;
  }

  /**
   * 经办人员重评
   *
   * @param evaluateTaskCode
   * @param reevalueateResult
   * @return
   */
  @RequestMapping(value = "/reviewEvaluateTask", method = RequestMethod.PUT)
  public ResultDTO reviewEvaluateTask(
      @RequestParam String evaluateTaskCode, @RequestParam String reevalueateResult) {
    return evaluateTaskService.reviewEvaluateTask(evaluateTaskCode, reevalueateResult);
  }

  /**
   * 根据评估任务编号批量修改送达状态 evaluateTaskCodes是一个以,为分开的编号字符串
   *
   * @param taskState
   * @param operatedBy
   * @param evaluateTaskCodes
   * @return
   */
  @RequestMapping(path = "/evaluateTaskStauts/{taskState}/{operatedBy}/{evaluateTaskCodes}")
  @ResponseBody
  public ResultDTO evaluateTaskStautsCase(
      @PathVariable String taskState,
      @PathVariable String operatedBy,
      @PathVariable String evaluateTaskCodes) {
    return evaluateTaskService.batchTreatmentApplicationCase(
        taskState, operatedBy, evaluateTaskCodes);
  }

  /**
   * 评估结果送达页面列表查询
   *
   * @param insuredPersonName
   * @param idCard
   * @param evaluateOrg
   * @param operatedTime
   * @param taskState
   * @param page
   * @param pageSize
   * @return
   */
  @RequestMapping(value = "/evaluateTask/sendMessage", method = RequestMethod.POST)
  public PageResultDTO listExpertTask(
      String insuredPersonName,
      String idCard,
      String evaluateOrg,
      String operatedTime,
      String taskState,
      @RequestParam(value = "page", defaultValue = "1") int page,
      @RequestParam(value = "pageSize", defaultValue = "15") int pageSize) {
    logger.debug("=======进入评估结果送达页面中间层查询信息===============");
    logger.debug("=======insuredPersonName【" + insuredPersonName + "】========");
    logger.debug("=======idCard【" + idCard + "】========");
    logger.debug("=======evaluateOrg【" + evaluateOrg + "】========");
    logger.debug("=======operatedTime【" + operatedTime + "】========");
    logger.debug("=======taskState【" + taskState + "】========");

    if (page < 1) page = 1;

    PageResultDTO pageResultDTO =
        evaluateTaskService.getExpertTaskList(
            insuredPersonName, idCard, evaluateOrg, operatedTime, taskState, page, pageSize);

    logger.debug("=======进入初评结果查询中间层接口结束===============");
    return pageResultDTO;
  }

  /**
   * 根据图片id查询具体的图片信息
   *
   * @param id
   */
  @RequestMapping(value = "/evaluateTask/mongoDBMessage", method = RequestMethod.POST)
  public ResultDTO getMongoDBMessage(String id) {
    logger.debug("=======id【" + id + "】=========");
    return evaluateTaskService.getMongoDBMessage(id);
  }

  /**
   * 根据图片id查询图片
   *
   * @param id
   */
  @RequestMapping(value = "/evaluateTask/pic", method = RequestMethod.GET)
  public void getMongoDBMessage(HttpServletResponse response, String id) {
    logger.debug("=======id【" + id + "】=========");
    ResultDTO dto = evaluateTaskService.getMongoDBMessage(id);
    if (dto.getDatas() != null && !"".equals(dto.getDatas())) {
      try {
        byte[] data = Encodes.decodeBase64(dto.getDatas().toString());
        response.setContentType("image/jpeg");
        OutputStream out = response.getOutputStream();
        out.write(data);
        out.flush();
        out.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
