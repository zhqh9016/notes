package com.taikang.dic.ltci.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.dao.IMqFailMessageLogDAO;
import com.taikang.dic.ltci.model.MqFailMessageLogDO;
import com.taikang.dic.ltci.service.IMqFailMessageLogService;

@Service
public class MqFailMessageLogServiceImpl implements IMqFailMessageLogService {

  @Autowired private IMqFailMessageLogDAO mqFailMessageLogDAO;
  private static final Logger logger = LoggerFactory.getLogger(MqFailMessageLogServiceImpl.class);

  @Override
  public void saveOrUpdateFailLog(MqFailMessageLogDO failMessageLog) {
    //先去查询是否已经有错误记录，如果有说明是重试调用失败，更新重试次数
    try {
      MqFailMessageLogDO select = mqFailMessageLogDAO.selectByPrimaryKey(failMessageLog.getId());
      if (select != null) {
        failMessageLog.setRetryNum(select.getRetryNum() + 1);
        mqFailMessageLogDAO.updateByPrimaryKeySelective(failMessageLog);
      } else {
        mqFailMessageLogDAO.insertSelective(failMessageLog);
      }

    } catch (Exception e) {
      logger.error("insert or update mqFailMessageLog error !", e);
    }
  }
}
