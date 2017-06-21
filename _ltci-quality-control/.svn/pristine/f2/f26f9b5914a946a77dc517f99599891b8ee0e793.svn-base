package com.taikang.dic.ltci.service;

import java.util.List;

import com.taikang.dic.ltci.api.model.ExecuteResultDTO;
import com.taikang.dic.ltci.model.ExecuteResultDO;

public interface IExecuteResultService {

  /**
   * 录入巡查意见
   *
   * @param executeResultDo
   * @return
   */
  boolean createExecuteResult(ExecuteResultDTO executeResultDto) throws ServiceException;

  /**
   * 根据任务主键查询任务结果信息
   *
   * @param patrolTaskId
   * @return
   */
  List<ExecuteResultDO> getPatrolTaskResultByTaskId(String patrolTaskId);
}
