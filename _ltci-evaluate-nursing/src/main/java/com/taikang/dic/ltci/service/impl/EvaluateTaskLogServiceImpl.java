package com.taikang.dic.ltci.service.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.dao.EvaluateTaskLogDAO;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.model.EvaluateTaskLogDO;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.EvaluateTaskLogService;

@Service
public class EvaluateTaskLogServiceImpl extends AbstractGenericService<EvaluateTaskLogDO, String>
    implements EvaluateTaskLogService {

  private Logger logger = LoggerFactory.getLogger(EvaluateTaskLogServiceImpl.class);

  private EvaluateTaskLogDAO evaluateTaskLogDAO;

  @Override
  public IGenericDAO<EvaluateTaskLogDO, String> getDao() {
    return evaluateTaskLogDAO;
  }

  @Override
  public int addEvaluateTaskLog(EvaluateTaskLogDO evaluateTaskLogDO) {
    evaluateTaskLogDO.setEvaluateTaskLogid(UUID.randomUUID().toString().replaceAll("-", ""));
    logger.info("-----------addEvaluateTaskLog----------");
    logger.info("-----------evaluateTaskLogDO:" + evaluateTaskLogDO + "-----------");
    return evaluateTaskLogDAO.insert(evaluateTaskLogDO);
  }
}
