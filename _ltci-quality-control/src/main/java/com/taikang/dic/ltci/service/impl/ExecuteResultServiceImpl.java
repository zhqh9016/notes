package com.taikang.dic.ltci.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taikang.dic.ltci.api.model.ExecuteResultDTO;
import com.taikang.dic.ltci.api.model.RExecuteFileDTO;
import com.taikang.dic.ltci.common.enumeration.TaskStateEnum;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.dao.IExecuteResultDAO;
import com.taikang.dic.ltci.dao.IPatrolTaskDAO;
import com.taikang.dic.ltci.dao.IRExecuteFileDAO;
import com.taikang.dic.ltci.model.ExecuteResultDO;
import com.taikang.dic.ltci.model.ExecuteResultDOExample;
import com.taikang.dic.ltci.model.PatrolTaskDO;
import com.taikang.dic.ltci.model.RExecuteFileDO;
import com.taikang.dic.ltci.service.IExecuteResultService;
import com.taikang.dic.ltci.service.ServiceException;

@Service
public class ExecuteResultServiceImpl implements IExecuteResultService {

  @Autowired private IExecuteResultDAO executeResultDao;

  @Autowired private IRExecuteFileDAO executeFileDao;

  @Autowired private IPatrolTaskDAO patrolTaskDao;

  @Override
  @Transactional
  public boolean createExecuteResult(ExecuteResultDTO executeResultDto) throws ServiceException {
    // 录入巡查意见
    ExecuteResultDO executeResultDo = new ExecuteResultDO();
    BeanUtils.copyProperties(executeResultDto, executeResultDo);
    executeResultDo.setExecuteResultId(UUID.randomUUID().toString().replace("-", ""));
    executeResultDo.setPartolTime(
        DateFormatUtil.strToDate(
            executeResultDto.getPartolTime(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
    executeResultDo.setOperatedTime(new Date());
    executeResultDo.setCreatedTime(new Date());
    int i = executeResultDao.insertSelective(executeResultDo);
    if (i <= 0) {
      throw new ServiceException(500, "录入巡查意见失败");
    }
    // 录入巡查附件
    List<RExecuteFileDTO> executeFileDtoList = executeResultDto.getExecuteFile();
    for (RExecuteFileDTO executeFileDto : executeFileDtoList) {
      RExecuteFileDO rExecuteFileDo = new RExecuteFileDO();
      BeanUtils.copyProperties(executeFileDto, rExecuteFileDo);
      // 设置主键
      rExecuteFileDo.setId(UUID.randomUUID().toString().replace("-", ""));
      rExecuteFileDo.setExecuteResultId(executeResultDo.getExecuteResultId());
      executeFileDao.insertSelective(rExecuteFileDo);
    }
    // 更新任务状态
    PatrolTaskDO patrolTaskDo = new PatrolTaskDO();
    patrolTaskDo.setPatrolTaskId(executeResultDto.getPatrolTaskId());
    patrolTaskDo.setTaskState(TaskStateEnum.ALREDY_EXECUTE.getValue());
    patrolTaskDo.setOperatedTime(new Date());
    patrolTaskDo.setOperatedBy(executeResultDto.getOperatedBy());
    patrolTaskDo.setOperatedOrg(executeResultDto.getOperatedOrg());
    patrolTaskDao.updateByPrimaryKeySelective(patrolTaskDo);
    return true;
  }

  @Override
  public List<ExecuteResultDO> getPatrolTaskResultByTaskId(String patrolTaskId) {
    ExecuteResultDOExample example = new ExecuteResultDOExample();
    example.createCriteria().andPatrolTaskIdEqualTo(patrolTaskId);
    return executeResultDao.selectByExample(example);
  }
}
