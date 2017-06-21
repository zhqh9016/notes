package com.taikang.dic.ltci.treatment.application.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.portal.api.model.ApplicationLogDTO;
import com.taikang.dic.ltci.portal.api.model.TreatmentApplicationDTO;
import com.taikang.dic.ltci.portal.common.util.DateFormatUtil;

/**
 * @author itw_liuxy
 * @description
 * @createTime 2017年3月31日 上午9:12:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TreatmentApplicationControllerIT {

  private static final Logger logger =
      LoggerFactory.getLogger(TreatmentApplicationControllerIT.class);

  private MockMvc mockMvc;

  @Autowired private WebApplicationContext webApplicationContext;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void testCreateTreatmentApplication() throws Exception {
    //      TreatmentApplicationDTO dto = new TreatmentApplicationDTO();
    //      dto.setInsuredPersonName("李四");
    //      dto.setInsuredPersonGender("1");
    //      dto.setAddress("北京昌平区史各庄");
    //      dto.setAreaCode("123");
    //      dto.setBirthday(DateFormatUtil.DateToStr(new Date(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
    //      dto.setCityCode("123");
    //      dto.setEducationid("123");
    //      dto.setEmail("123@hotmail.com");
    //      dto.setIdCard("371425199108032579");
    //      dto.setMarried("1");
    //      dto.setNation("123");
    //      dto.setOccupationid("123");
    //      dto.setOrgName("泰康人寿");
    //      dto.setPersonnelIdentityName("公务员");
    //      dto.setPersonnelIdentityCode("123");
    //      dto.setPoliticsid("123");
    //      dto.setProvinceCode("123");
    //      dto.setSecurityNumber("3714251991");
    //      dto.setSecurityPersonalNumber("123");
    //      dto.setMobile("13260199197");
    //
    //      dto.setAddress("北京市昌平区");
    //      dto.setApplicationFormScan("123");
    //      dto.setApplicationReason("123");
    //      dto.setApplicationStatus("123");
    //      dto.setBidType("123");
    //      dto.setCaseHistoryScan("123");
    //      dto.setCreatedBy("123");
    //      dto.setCreatedOrg("123");
    //      dto.setDeputyAddress("123");
    //      dto.setDeputyIdCard("123");
    //      dto.setDeputyIdCardScan("123");
    //      dto.setDeputyIdType("123");
    //      dto.setDeputyMobile("123");
    //      dto.setDeputyName("123");
    //      dto.setDisease("123");
    //      dto.setDiseaseCause("123");
    //      dto.setIdCardScan("123");
    //      dto.setIsRelativeCared("123");
    //      dto.setIsTaskDeadline("123");
    //      dto.setMobile("13260199197");
    //      dto.setSiArea("123");
    //      dto.setSources("123");
    //      dto.setSecurityNumberScan("123");
    //      dto.setSiArea("123");
    //
    //      String jsonString = JSONObject.toJSONString(dto);
    //      mockMvc
    //          .perform(post("/api/v1/treatmentApplication").contentType("application/json").content(jsonString))
    //          .andExpect(status().isOk())
    //          .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //          .andDo(print()) //打印出请求和响应的内容
    //          .andReturn()
    //          .getResponse()
    //          .getContentAsString()
    //          ;
    //    ApplicationLogDTO logDto = new ApplicationLogDTO();
    //    logDto.setApplicationCode("ba93749b3ddc415d8c424b5be74efcc6");
    //    logDto.setSecurityNumber("123");
    //    logDto.setSecurityPersonalNumber("123");
    //    logDto.setDeputyIdCard("123");
    //    logDto.setApplicationStatus("12");
    //    logDto.setApplicationReason("12345");
    //
    //    ApplicationLogDTO logDto1 = new ApplicationLogDTO();
    //    logDto1.setApplicationCode("f91ad7dc27c141998eb651412e55cad2");
    //    logDto1.setSecurityNumber("123");
    //    logDto1.setSecurityPersonalNumber("123");
    //    logDto1.setDeputyIdCard("123");
    //    logDto1.setApplicationStatus("12");
    //    logDto1.setApplicationReason("12345");
    //    List<ApplicationLogDTO> list = new ArrayList<ApplicationLogDTO>();
    //
    //    list.add(logDto);
    //    list.add(logDto1);
    //
    //    mockMvc
    //        .perform(
    //            post("/api/v1/batchTreatmentApplicationCase")
    //                .param("applicationLogDTOs", JSONObject.toJSONString(list)))
    //        .andExpect(status().isOk())
    //        .andDo(print()) //打印出请求和响应的内容
    //        .andReturn()
    //        .getResponse()
    //        .getContentAsString(); //将响应的数据转换为字符串
  }
}
