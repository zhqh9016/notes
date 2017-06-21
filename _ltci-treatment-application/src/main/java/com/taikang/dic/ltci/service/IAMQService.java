package com.taikang.dic.ltci.service;
/**
 * AMQ服务接口
 *
 * @author longfei04 E-mail:
 * @version 创建时间：2017年4月13日 下午1:25:11
 */
public interface IAMQService {
  /**
   * 发送消息到AMQ 参数1:交换机名称 参数2：队列名称 参数3：消息实体
   *
   * @param exchangeName
   * @param routingKey
   * @param message
   */
  public void sendMessage(String exchangeName, String routingKey, String message);

  public void receiveMessage(String messgae);
}
