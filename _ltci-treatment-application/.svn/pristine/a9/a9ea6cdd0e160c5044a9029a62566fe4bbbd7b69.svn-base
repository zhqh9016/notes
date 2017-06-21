package com.taikang.dic.ltci.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.ArrayList;
import java.util.List;

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
import com.taikang.dic.ltci.model.ApplicationLogDO;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ApplicationControllerIT {
  private MockMvc mockMvc;

  @Autowired private WebApplicationContext webApplicationContext;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  @Transactional
  @Rollback
  public void testCreateApplication() throws Exception {
    //    ApplicationDTO dto = new ApplicationDTO();
    //
    //    dto.setAddress("北京市昌平区");
    //    dto.setApplicationCode("59b65cf5c03f420990238b56d83e6540");
    //    dto.setApplicationFormScan("123");
    //    dto.setApplicationReason("123");
    //    dto.setApplicationStatus("123");
    //    dto.setBidType("123");
    //    dto.setCaseHistoryScan("123");
    //    dto.setCreatedBy("123");
    //    dto.setCreatedOrg("123");
    //    dto.setDeputyAddress("123");
    //    dto.setDeputyIdCard("123");
    //    dto.setDeputyIdCardScan("123");
    //    dto.setDeputyIdType("123");
    //    dto.setDeputyMobile("123");
    //    dto.setDeputyName("123");
    //    dto.setDisease("123");
    //    dto.setDiseaseCause("123");
    //    dto.setIdCardScan("123");
    //    dto.setInsuredPersonCode("123");
    //    dto.setIsRelativeCared("123");
    //    dto.setIsTaskDeadline("123");
    //    dto.setIsValid(0);
    //    dto.setMobile("13260199197");
    //    dto.setOperatedBy("123");
    //    dto.setOperatedOrg("123");
    //    dto.setSiArea("123");
    //    dto.setSources("123");
    //    dto.setSecurityNumberScan("123");
    //    dto.setSiArea("123");
    //
    //    String jsonString = JSONObject.toJSONString(dto);
    //    mockMvc
    //        .perform(post("/api/v1/application").contentType("application/json").content(jsonString))
    //        .andExpect(status().isOk());
  }

  @Test
  @Rollback
  public void testGetApplicationState() throws Exception {
    //    String idCard = "37241618763519";
    //    String securityNumber = "12";
    //    String deputyIdCard = "420801199205112719";
    //    mockMvc
    //        .perform(
    //            get(
    //                "/api/v1/insuredPerson/{idCard}/{securityNumber}/deputy/{deputyIdCard}",
    //                idCard,
    //                securityNumber,
    //                deputyIdCard))
    //        .andExpect(status().isOk())
    //        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //        .andExpect(jsonPath("$.status").value(200))
    //        .andDo(print()) //打印出请求和响应的内容
    //        .andReturn()
    //        .getResponse()
    //        .getContentAsString(); //将响应的数据转换为字符串
  }

  @Test
  @Rollback
  public void testBatchTreatmentApplicationCase() throws Exception {
    //    ApplicationLogDO logDto = new ApplicationLogDO();
    //    logDto.setApplicationCode("68b649034bea4928bddcef79209e3d25");
    //    logDto.setSecurityNumber("123");
    //    logDto.setSecurityPersonalNumber("123");
    //    logDto.setDeputyIdCard("123");
    //    logDto.setApplicationStatus("12");
    //    logDto.setApplicationReason("reason");
    //
    //    ApplicationLogDO logDto1 = new ApplicationLogDO();
    //    logDto1.setApplicationCode("f91ad7dc27c141998eb651412e55cad2");
    //    logDto1.setSecurityNumber("123");
    //    logDto1.setSecurityPersonalNumber("123");
    //    logDto1.setDeputyIdCard("123");
    //    logDto1.setApplicationStatus("12");
    //    logDto1.setApplicationReason("reason");
    //    List<ApplicationLogDO> list = new ArrayList<ApplicationLogDO>();
    //
    //    list.add(logDto);
    //    list.add(logDto1);
    //
    //    mockMvc
    //        .perform(
    //            put("/api/v1/batchTreatmentApplicationCase")
    //                .param("applicationDTOs", JSONObject.toJSONString(list)))
    //        .andExpect(status().isOk())
    //        .andDo(print()) //打印出请求和响应的内容
    //        .andReturn()
    //        .getResponse()
    //        .getContentAsString(); //将响应的数据转换为字符串
  }
}
