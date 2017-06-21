package com.taikang.dic.ltci.service;

import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.model.RExecuteFileDO;

public interface IPatrolTaskExecuteService {

  /**
   * 添加执行结果中间资源数据
   *
   * @param rExecuteFileDO
   * @return
   * @throws ServiceException
   */
  boolean createExecuteFile(RExecuteFileDO rExecuteFileDO) throws ServiceException;

  /**
   * 查看执行结果中间资源数据
   *
   * @param rExecuteFileDO
   * @return
   * @throws ServiceException
   */
  ResultDTO getPatrolTaskExecuteFile(String patrolTaskId);
}
