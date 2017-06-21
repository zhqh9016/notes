package com.taikang.dic.ltci.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class NursingTaskControllerIT {

  private MockMvc mockMvc;

  @Autowired private WebApplicationContext webApplicationContext;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  @Transactional
  @Rollback
  public void testUpdateNursingTaskIntentAgency() throws Exception {
    //    String nursingTaskCodes = "001";
    //    String intentAgencyCode = "001";
    //    String operatedBy = "张三";
    //    String operatedOrg = "荆门市经办大厅";
    //    mockMvc
    //        .perform(
    //            put("/api/v1/nursingTaskIntentAgency")
    //                .param("nursingTaskCodes", nursingTaskCodes)
    //                .param("intentAgencyCode", intentAgencyCode)
    //                .param("operatedBy", operatedBy)
    //                .param("operatedOrg", operatedOrg))
    //        .andExpect(status().isOk())
    //        .andDo(print()) //打印出请求和响应的内容
    //        .andReturn()
    //        .getResponse()
    //        .getContentAsString();
  }
}
