package com.taikang.dic.ltci.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * 护理项目服务测试类
 *
 * @author liyh01 E-mail:
 * @version 创建时间：2017年4月13日 下午4:57:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
@Transactional
public class IMonSetPerServiceTest {

  private static final Logger logger = LoggerFactory.getLogger(IMonSetPerServiceTest.class);

  @Autowired IMonSetPerService monSetPerService;

  @Test
  //  @Rollback
  public void putServiceItemMessage() {
    Date d = new Date(1488336201000L);
    System.out.println(d);
    String b =
        "{\"eventCode\":\"\",\"sysCode\":\"LTCS\",\"businessSerialid\":\"397980ab81f143308d40dbbdec4cacb8\",\"moduleCode\":\"\",\"data\":{\"inRecorduuid\":\"de81fd6a11594be99cff3cfed016\",\"orgName\":\"泰康人寿保险\",\"nurseStarttime\":1488336201000,\"paySelf\":45.0000,\"receiptNum\":\"12002\",\"cardType\":\"111\",\"isAccountUse\":\"1\",\"reimbType\":\"0\",\"beCarePersonCardNum\":\"420802197408250617\",\"expenseSelf\":135.0000,\"socSecNum\":\"H284073X\",\"nurseEndtime\":1489286601000,\"orgCode\":\"JG100000002\",\"overLimitFee\":\"\",\"siPay\":720.0000,\"setDate\":1494401975000,\"perSetCode\":\"178e78bf275c47358f27a34751ae1087\",\"nurseTotalAmount\":900.0000,\"siSrea\":\"\",\"bankCardPay\":80.0000},\"messageCode\":\"LTC_CHA_MON_001\",\"nodeIP\":\"10.130.207.115\",\"timestamp\":1494401980468}";
    logger.debug("______monSetPer = " + b);
    monSetPerService.receiveMessage(b.getBytes());
  }
}
