package com.taikang.dic.ltci.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.common.ws.InsuredInfo;
import com.taikang.dic.ltci.common.ws.TreatmentState;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class WSServiceTest {

  private static final Logger logger = LoggerFactory.getLogger(WSServiceTest.class);

  @Autowired WSService wsService;

  @Test
  public void selectInsuredInfo() {
    //	  InsuredInfo ret = wsService.selectInsuredInfo("123", "123");
    //	    logger.debug("__________selectInsuredInfo=" + JSONObject.toJSONString(ret));
  }

  //  @Test
  //  public void selectApplicationStatus(){
  //	  TreatmentState ret = wsService.selectApplicationStatus("123", "123");
  //	  logger.debug("__________selectApplicationStatus=" + JSONObject.toJSONString(ret));
  //  }
}
