package com.taikang.dic.ltci.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.controller.MQMessageController;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.MQMessageLogDAO;
import com.taikang.dic.ltci.model.MQMessageLogDO;
import com.taikang.dic.ltci.model.MQMessageLogDOExample;
import com.taikang.dic.ltci.model.MQMessageLogDOExample.Criteria;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.MQMessageService;

@Service
public class MQMessageServiceImpl extends AbstractGenericService<MQMessageLogDO, String>
    implements MQMessageService {
  private Logger logger = LoggerFactory.getLogger(MQMessageController.class);
  @Autowired private MQMessageLogDAO mqMessageLogDAO;

  @Transactional
  @Override
  public ResultDTO repeatMQMessage(String sendStatTime, String sendEndTime) {
    //1、先获取到要重发的消息
    MQMessageLogDOExample mqMessageLogDOExample = new MQMessageLogDOExample();

    Criteria criteria = mqMessageLogDOExample.createCriteria();
    criteria.andSendTimeBetween(
        DateFormatUtil.strToDateTime(sendStatTime), DateFormatUtil.strToDateTime(sendEndTime));
    criteria.andSendStateEqualTo("0");

    List<MQMessageLogDO> mqMessageLogs =
        mqMessageLogDAO.selectByExampleWithBLOBs(mqMessageLogDOExample);

    logger.debug(JSONObject.toJSONString(mqMessageLogs));

    if (mqMessageLogs.isEmpty()) {
      ResultDTO resultDTO = new ResultDTO();
      resultDTO.setMessage("此时间段没有消息发送");
      resultDTO.setStatus(StatusCodeEnum.OK.getValue());
      return resultDTO;
    }
    for (MQMessageLogDO mqMessageLog : mqMessageLogs) {
      //2.发送MQ信息
      logger.debug(
          "====" + mqMessageLog.getId() + " start:" + DateFormatUtil.dateToTimeStr(new Date()));
      try {
        sendMessage(
            mqMessageLog.getExchangeName(),
            mqMessageLog.getQueueName(),
            mqMessageLog.getSendContent());

        logger.debug(
            "====" + mqMessageLog.getId() + " end:" + DateFormatUtil.dateToTimeStr(new Date()));
        //3.修改日志信息
        mqMessageLog.setReSendNum(mqMessageLog.getReSendNum() + 1);
        mqMessageLog.setSendTime(new Date());
        mqMessageLogDAO.updateByPrimaryKeySelective(mqMessageLog);
      } catch (Exception e) {
        logger.info("发送MQ失败错误：", e);
        MQMessageLogDO logDO = new MQMessageLogDO();
        logDO.setId(mqMessageLog.getId());
        logDO.setSendState("1");
        mqMessageLogDAO.updateByPrimaryKeySelective(logDO);
      }
    }

    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setMessage("重发完成");
    resultDTO.setStatus(StatusCodeEnum.OK.getValue());
    return resultDTO;
  }

  @Override
  public IGenericDAO<MQMessageLogDO, String> getDao() {
    return mqMessageLogDAO;
  }
}
