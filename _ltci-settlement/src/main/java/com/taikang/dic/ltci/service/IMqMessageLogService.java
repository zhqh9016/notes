package com.taikang.dic.ltci.service;

import com.taikang.dic.ltci.model.MqMessageLogDO;

public interface IMqMessageLogService extends GenericService<MqMessageLogDO, String> {

  /**
   * 记录发送日志
   *
   * @param type
   * @param reSendNum
   * @param sendState
   * @param content
   * @return
   */
  public int sendMqMessageLog(
      String uuid,
      Long reSendNum,
      String sendState,
      String content,
      String exchangeName,
      String routingKey);

  /**
   * 记录接收日志
   *
   * @param type
   * @param reSendNum
   * @param sendState
   * @param content
   * @return
   */
  public int receiveMqMessageLog(String uuid, String content);

  /**
   * 是否存在
   *
   * @param id
   * @return
   */
  public boolean isHas(String uuid);
}
