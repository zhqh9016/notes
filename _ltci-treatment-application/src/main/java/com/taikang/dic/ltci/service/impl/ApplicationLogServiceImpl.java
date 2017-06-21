package com.taikang.dic.ltci.service.impl;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.common.enumeration.IsValidEnum;
import com.taikang.dic.ltci.dao.ApplicationLogDAO;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.model.ApplicationLogDO;
import com.taikang.dic.ltci.service.ApplicationLogService;

@Service
public class ApplicationLogServiceImpl extends AbstractGenericService<ApplicationLogDO, String>
    implements ApplicationLogService {

  private static final Logger logger = LoggerFactory.getLogger(ApplicationLogServiceImpl.class);

  @Autowired private ApplicationLogDAO applicationLogDAO;

  /** 新增待遇申请信息时需要向日志表添加待遇申请日志信息 返回值是添加的条数 */
  public int createApplicationLog(ApplicationLogDO applicationLogDO) {
    logger.info("====Service层：进入createApplicationLog方法开始========");
    applicationLogDO.setApplicationLogid(UUID.randomUUID().toString().replaceAll("-", ""));
    applicationLogDO.setCreatedTime(new Date());
    applicationLogDO.setIsValid(IsValidEnum.NO_DELETE.getValue());
    logger.info("====Service层：applicationLogDO：" + applicationLogDO + "========");
    logger.info("====Service层：进入createApplicationLog方法结束========");
    return applicationLogDAO.insert(applicationLogDO);
  }

  @Override
  public IGenericDAO<ApplicationLogDO, String> getDao() {
    return applicationLogDAO;
  }
}
