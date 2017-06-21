package com.taikang.dic.ltci.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.ApplicationLogDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ApplicationLogControllerIT {
  private MockMvc mockMvc;

  @Autowired private WebApplicationContext webApplicationContext;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  @Transactional
  @Rollback
  public void testCreateApplicationLog() throws Exception {
    ApplicationLogDTO dto = new ApplicationLogDTO();
    dto.setApplicationCode("ba93749b3ddc415d8c424b5be74efcc6");
    dto.setApplicationReason("123");
    dto.setApplicationStatus("123");
    dto.setOperatedBy("123");
    dto.setDeputyIdCard("123");
    dto.setSecurityNumber("123");
    dto.setSecurityPersonalNumber("123");

    String jsonString = JSONObject.toJSONString(dto);
    mockMvc
        .perform(post("/api/v1/applicationLog").contentType("application/json").content(jsonString))
        .andExpect(status().isOk());
  }
}
