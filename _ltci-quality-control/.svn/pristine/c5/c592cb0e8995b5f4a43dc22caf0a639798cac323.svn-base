package com.taikang.dic.ltci.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.api.model.ExecuteResultDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.model.ExecuteResultDO;
import com.taikang.dic.ltci.service.IExecuteResultService;
import com.taikang.dic.ltci.service.IPatrolTaskExecuteService;
import com.taikang.dic.ltci.service.ServiceException;

/**
 * 任务执行Controller
 *
 * @author itw_liyh01
 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class PatrolTaskExecuteController {

  private Logger logger = LoggerFactory.getLogger(PatrolTaskExecuteController.class);

  @Autowired private IPatrolTaskExecuteService taskExecuteService;

  @Autowired private IExecuteResultService executeResultService;

  /**
   * 录入巡查意见并生成执行结果资源中间表数据
   *
   * @param file
   * @return
   */
  @RequestMapping(value = "/taskExecute/resources", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO createPatrolTaskExecute(@RequestBody ExecuteResultDTO executeResultDto) {
    logger.debug("_createPatrolTaskExecute___executeResultDto=" + executeResultDto);
    ResultDTO resultDto = new ResultDTO();
    try {
      executeResultService.createExecuteResult(executeResultDto);
    } catch (ServiceException e) {
      resultDto.setStatus(e.getErrorCode());
      resultDto.setMessage(e.getMessage());
      logger.error("_createPatrolTaskExecute_", e);
      return resultDto;
    }
    resultDto.setStatus(200);
    return resultDto;
  }

  /**
   * 查看执行结果资源附件中间表
   *
   * @param file
   * @return
   */
  @RequestMapping(value = "/taskExecute/resources/{patrolTaskId}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO getPatrolTaskExecuteFile(@PathVariable String patrolTaskId) {
    logger.debug("_deletePatrolTaskExecute___patrolTaskId=" + patrolTaskId);
    return taskExecuteService.getPatrolTaskExecuteFile(patrolTaskId);
  }

  /**
   * 根据任务主键查询任务结果信息
   *
   * @param patrolTaskId
   * @return
   */
  @RequestMapping(value = "/taskExecute/{patrolTaskId}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO getPatrolTaskResultByTaskId(@PathVariable String patrolTaskId) {
    ResultDTO result = new ResultDTO();
    List<ExecuteResultDO> list = executeResultService.getPatrolTaskResultByTaskId(patrolTaskId);
    if (list != null && !list.isEmpty()) {
      result.setStatus(StatusCodeEnum.INSERT_REPEAT.getValue());
      result.setMessage("记录已被他人操作，请刷新界面，重新选择数据！");
      return result;
    }
    result.setStatus(200);
    return result;
  }
}
