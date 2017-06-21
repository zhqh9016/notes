package com.taikang.dic.ltci.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.api.model.ReconsiderDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.service.IReconsiderService;

/**
 * 申述复议
 *
 * @author itw_zhangqh
 */
@RestController
@RequestMapping(path = "${restBasePath}", produces = "application/json;charset=utf-8")
public class ReconsiderController {

  private Logger logger = LoggerFactory.getLogger(ReconsiderController.class);
  public static final String RETRY_URL = "/reconsiders/receive/retry";

  @Autowired private IReconsiderService reconsiderService;

  /**
   * 根据巡查任务id查询申述复议列表
   *
   * @param patrolTaskId
   * @return
   */
  @RequestMapping(value = "/reconsiders/{patrolTaskId}", method = RequestMethod.GET)
  public ResultDTO getReconsiderListByPatrolTaskId(
      @PathVariable("patrolTaskId") String patrolTaskId) {
    logger.info("=========Controller层  getReconsiderListByPatrolTaskId==========");
    logger.info("=========巡查任务ID为: " + patrolTaskId);
    //根据巡查任务id查询申述复议列表
    ResultDTO result = reconsiderService.listReconsidersByPatrolTaskId(patrolTaskId);
    result.setStatus(StatusCodeEnum.OK.getValue());
    return result;
  }

  /**
   * 根据巡查任务id查询申述复议列表
   *
   * @param jsonMessage 从mq中获取的json格式消息
   * @return
   */
  @RequestMapping(value = RETRY_URL, method = RequestMethod.POST)
  public ResultDTO retryReceiveReconsider(@RequestParam("message") String message) {
    logger.info("=====重新处理异常的mq消息=====");
    //根据巡查任务id查询申述复议列表
    ResultDTO result = new ResultDTO();
    try {
      reconsiderService.parseMessage(message);
      result.setStatus(StatusCodeEnum.OK.getValue());
    } catch (Exception e) {
      result.setStatus(HttpStatus.EXPECTATION_FAILED.value());
      logger.error("retry reconsider error !", e);
    }
    return result;
  }

  /**
   * 保存申述回复,更新最后一条回复信息为空的记录
   *
   * @param patrolTaskId
   * @param content
   * @return
   */
  @RequestMapping(value = "/reconsiders", method = RequestMethod.POST)
  public ResultDTO saveReconsider(@RequestBody ReconsiderDTO reconsider) {
    ResultDTO result = new ResultDTO();

    //复议时必须指定任务ID
    if (StringUtils.isBlank(reconsider.getPatrolTaskId())) {
      result.setStatus(407);
      result.setMessage("复议时必须指定任务ID");
      return result;
    }
    result = reconsiderService.saveReconsider(reconsider);
    //result.setStatus(StatusCodeEnum.OK.getValue());
    return result;
  }
}
