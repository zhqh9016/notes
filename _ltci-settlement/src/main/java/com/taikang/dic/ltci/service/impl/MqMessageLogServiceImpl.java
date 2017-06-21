package com.taikang.dic.ltci.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.common.enumeration.MqTypeEnum;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.MqMessageLogDAO;
import com.taikang.dic.ltci.model.MqMessageLogDO;
import com.taikang.dic.ltci.model.MqMessageLogDOExample;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.IMqMessageLogService;

@Service
public class MqMessageLogServiceImpl extends AbstractGenericService<MqMessageLogDO, String>
    implements IMqMessageLogService {

  @Autowired MqMessageLogDAO mqMessageLogDAO;

  @Override
  public int sendMqMessageLog(
      String uuid,
      Long reSendNum,
      String sendState,
      String content,
      String exchangeName,
      String routingKey) {
    MqMessageLogDO mqLogDo = new MqMessageLogDO();
    mqLogDo.setId(UUID.randomUUID().toString().replaceAll("-", ""));
    mqLogDo.setType(MqTypeEnum.SEND.getValue());
    mqLogDo.setSendTime(new Date());
    mqLogDo.setCreateTime(new Date());
    mqLogDo.setReSendNum(reSendNum);
    mqLogDo.setSendState(sendState); //成功
    mqLogDo.setSendContent(content);
    mqLogDo.setExchangeName(exchangeName);
    mqLogDo.setQueueName(routingKey);
    return mqMessageLogDAO.insert(mqLogDo);
  }

  @Override
  public int receiveMqMessageLog(String uuid, String content) {
    MqMessageLogDO mqLogDo = new MqMessageLogDO();
    mqLogDo.setId(uuid);
    mqLogDo.setType(MqTypeEnum.RECEIVE.getValue());
    mqLogDo.setCreateTime(new Date());
    mqLogDo.setSendContent(content);
    return mqMessageLogDAO.insert(mqLogDo);
  }

  public boolean isHas(String uuid) {
    MqMessageLogDOExample doExample = new MqMessageLogDOExample();
    MqMessageLogDOExample.Criteria criteria = doExample.createCriteria();
    criteria.andTypeEqualTo(MqTypeEnum.RECEIVE.getValue());
    criteria.andIdEqualTo(uuid);
    List<MqMessageLogDO> mqMessageLogDOs = mqMessageLogDAO.selectByExample(doExample);
    return mqMessageLogDOs.size() > 0;
  }

  @Override
  public IGenericDAO<MqMessageLogDO, String> getDao() {
    // TODO Auto-generated method stub
    return null;
  }
}
