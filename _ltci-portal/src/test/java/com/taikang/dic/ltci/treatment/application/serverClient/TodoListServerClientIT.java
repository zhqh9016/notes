package com.taikang.dic.ltci.treatment.application.serverClient;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.portal.api.model.DeputyBindingDTO;
import com.taikang.dic.ltci.portal.api.model.InsuredPersonDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.treatment.application.serverClient.InsuredPersonServerClient;

/**
 * @author itw_liuxy
 * @description
 * @createTime 2017年3月31日 上午9:12:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TodoListServerClientIT {

  private static final Logger logger = LoggerFactory.getLogger(TodoListServerClientIT.class);

  @Autowired private DeputyBindingServerClient deputyBindingServerClient;

  @Test
  @Rollback
  public void testDeputyBinding() {
    //              logger.info("==========testDeputyBinding开始==============");
    //              ResultDTO resultDTO = deputyBindingServerClient.getDeputyBindingDTO("1");
    //              logger.info("==========查询返回resultDTO:" + resultDTO.toString() + "==============");
    //              logger.info("==========testDeputyBinding结束==============");

    //              logger.info("==========testDeputyBinding开始==============");
    //              DeputyBindingDTO deputyBindingDTO = new DeputyBindingDTO();
    //              deputyBindingDTO.setDeputyBindingid("1");
    //              deputyBindingDTO.setCheckState("03");
    //              deputyBindingDTO.setCheckReason("");
    //              deputyBindingDTO.setTitle("123");
    //              deputyBindingDTO.setUrl("123");
    //              ResultDTO resultDTO = deputyBindingServerClient.updateDeputyBindingDTO(deputyBindingDTO);
    //              logger.info("==========查询返回resultDTO:" + resultDTO.toString() + "==============");
    //              logger.info("==========testDeputyBinding结束==============");
  }
}
