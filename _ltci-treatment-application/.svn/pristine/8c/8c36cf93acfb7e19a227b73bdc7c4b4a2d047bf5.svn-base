package com.taikang.dic.ltci.service.impl;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.taikang.dic.ltci.service.MobileTreatmentApplicationSenderService;

/**
 * @author itw_xuxf
 * @description
 * @version 创建时间：2017年3月31日上午10:46:32
 */
@Component
public class MobileTreatmentApplicationSenderServiceImpl
    implements MobileTreatmentApplicationSenderService {
  @Value("${ltci.treatmentApplicationCase.exchange}")
  private String exchangeName;

  @Value("${ltci.treatmentApplicationCase.queue}")
  private String routingKey;

  @Autowired private AmqpTemplate rabbitTemplate;

  public void send(byte[] context) {
    this.rabbitTemplate.convertAndSend(exchangeName, routingKey, context);
  }
}
