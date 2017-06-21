package com.taikang.dic.ltci.treatment.application.controller;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author itw_liuxy
 * @description
 * @createTime 2017年3月31日 上午9:12:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class InsuredPersonControllerIT {

  private static final Logger logger = LoggerFactory.getLogger(InsuredPersonControllerIT.class);

  private MockMvc mockMvc;

  @Autowired private WebApplicationContext webApplicationContext;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  @Rollback
  public void testGetInsuredPerson() throws Exception {

    //    InsuredPersonDTO personDTO = new InsuredPersonDTO();
    //    personDTO.setIdCard("37241618763519");
    //    personDTO.setInsuredPersonName("张三");

    //    personDTO.setInsuredPersonGender("1");
    //    personDTO.setAddress("北京昌平区史各庄");
    //    personDTO.setAreaCode("123");
    //    personDTO.setBirthday(DateFormatUtil.DateToStr(new Date(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
    //    personDTO.setCityCode("123");
    //    personDTO.setEducationid("123");
    //    personDTO.setEmail("123@hotmail.com");
    //    personDTO.setMarried("1");
    //    personDTO.setNation("123");
    //    personDTO.setOccupationid("123");
    //    personDTO.setOrgName("泰康人寿");
    //    personDTO.setPersonnelIdentityName("公务员");
    //    personDTO.setPersonnelIdentityCode("123");
    //    personDTO.setPoliticsid("123");
    //    personDTO.setProvinceCode("123");
    //    personDTO.setSecurityNumber("3714251991");
    //    personDTO.setSecurityPersonalNumber("123");
    //    personDTO.setMobile("13260199197");
    //
    //    ResultDTO resultDTO = insuredPersonServerClient.createInsuredPerson(personDTO);
    //
    //    logger.info("=========新增参保人返回："+resultDTO.toString()+"=========");

    //    String idCard = personDTO.getIdCard();
    //    String insuredPersonName = personDTO.getInsuredPersonName();
    //    insuredPersonName = URLEncoder.encode(insuredPersonName, "utf-8");
    //    mockMvc
    //        .perform(
    //            get(
    //                "/api/v1/insuredPerson/{idCard}/and/{insuredPersonName}",
    //                idCard,
    //                insuredPersonName))
    //        .andExpect(status().isOk())
    //        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //        .andExpect(jsonPath("$.status").value("200"))
    //        .andDo(print()) //打印出请求和响应的内容
    //        .andReturn()
    //        .getResponse()
    //        .getContentAsString(); //将响应的数据转换为字符串
    //    ;
  }
}
