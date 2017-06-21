package com.taikang.dic.ltci.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taikang.dic.ltci.api.model.ExecuteResultDTO;
import com.taikang.dic.ltci.api.model.RExecuteFileDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.dao.IExecuteResultDAO;
import com.taikang.dic.ltci.dao.IRExecuteFileDAO;
import com.taikang.dic.ltci.model.ExecuteResultDO;
import com.taikang.dic.ltci.model.ExecuteResultDOExample;
import com.taikang.dic.ltci.model.RExecuteFileDO;
import com.taikang.dic.ltci.model.RExecuteFileDOExample;
import com.taikang.dic.ltci.service.IPatrolTaskExecuteService;
import com.taikang.dic.ltci.service.ServiceException;

@Service
public class PatrolTaskExecuteServiceImpl implements IPatrolTaskExecuteService {

  @Autowired private IRExecuteFileDAO executeFileDao;

  @Autowired private IExecuteResultDAO executeResultDao;

  @Override
  public boolean createExecuteFile(RExecuteFileDO rExecuteFileDO) throws ServiceException {
    // 设置主键
    rExecuteFileDO.setId(UUID.randomUUID().toString().replace("-", ""));
    int i = executeFileDao.insertSelective(rExecuteFileDO);
    if (i <= 0) {
      throw new ServiceException(500, "添加执行结果资源中间数据失败");
    }
    return true;
  }

  @Override
  @Transactional
  public ResultDTO getPatrolTaskExecuteFile(String patrolTaskId) {
    ResultDTO result = new ResultDTO();
    // 根据巡查任务ID查询执行结果表数据
    ExecuteResultDOExample executeResultExample = new ExecuteResultDOExample();
    executeResultExample.createCriteria().andPatrolTaskIdEqualTo(patrolTaskId);
    List<ExecuteResultDO> executeResultDoList =
        executeResultDao.selectByExample(executeResultExample);
    // 任务执行结果ID
    String executeResultId = executeResultDoList.get(0).getExecuteResultId();
    // 根据任务执行结果ID查询执行结果中间资源表数据
    RExecuteFileDOExample executeFileExampe = new RExecuteFileDOExample();
    executeFileExampe.createCriteria().andExecuteResultIdEqualTo(executeResultId);
    List<RExecuteFileDO> executeFileList = executeFileDao.selectByExample(executeFileExampe);
    List<RExecuteFileDTO> fileDtoList = new ArrayList<>();
    ExecuteResultDTO executeResultDto = new ExecuteResultDTO();
    BeanUtils.copyProperties(executeResultDoList.get(0), executeResultDto);
    for (RExecuteFileDO executeFileDo : executeFileList) {
      RExecuteFileDTO fileDto = new RExecuteFileDTO();
      BeanUtils.copyProperties(executeFileDo, fileDto);
      fileDtoList.add(fileDto);
    }
    executeResultDto.setExecuteFile(fileDtoList);
    result.setStatus(200);
    result.setDatas(executeResultDto);
    return result;
  }
}
