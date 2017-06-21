package com.taikang.dic.ltci.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.TaskStateEnum;
import com.taikang.dic.ltci.service.IPatrolResultService;
import com.taikang.dic.ltci.service.ServiceException;

/**
 * 巡查结果Controller
 *
 * @author itw_liuzy
 */
@Controller
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class PatrolResultController {

  private Logger logger = LoggerFactory.getLogger(PatrolResultController.class);

  @Autowired IPatrolResultService patrolResultService;

  /**
   * 巡查结果审核状态
   *
   * @param auditState
   * @param rejectionReason
   * @return ResultDTO
   */
  @RequestMapping(path = "/patrol/result/state", method = RequestMethod.PUT)
  @ResponseBody
  public ResultDTO updateAuditState(String patrolTaskId, int auditState, String rejectionReason) {
    logger.debug(
        "_updateAuditState___auditState=" + auditState + "rejectionReason" + rejectionReason);
    ResultDTO resultDto = new ResultDTO();
    try {
      // 更新巡查状态
      patrolResultService.updateAuditState(patrolTaskId, auditState, rejectionReason);
      resultDto.setStatus(200);
      resultDto.setMessage("巡查结果审核成功");
    } catch (ServiceException e) {
      resultDto.setStatus(e.getErrorCode());
      resultDto.setMessage(e.getMessage());
      logger.error("_updateItem_", e);
      return resultDto;
    }
    return resultDto;
  }
}
