package com.taikang.dic.ltci.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.Date;

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
import com.taikang.dic.ltci.api.model.InsuredPersonDTO;
import com.taikang.dic.ltci.common.utils.DateFormatUtil;
import com.taikang.dic.ltci.service.InsuredPersonService;

/**
 * @author itw_liuxy
 * @description
 * @createTime 2017年3月31日 上午9:12:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@Transactional
public class InsuredPersonControllerIT {
  private MockMvc mockMvc;

  @Autowired private WebApplicationContext webApplicationContext;

  @Autowired private InsuredPersonService insuredPersonService;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void testCreateInsuredPerson() throws Exception {
    //    InsuredPersonDTO dto = new InsuredPersonDTO();
    //    dto.setInsuredPersonName("李四");
    //    dto.setInsuredPersonGender("1");
    //    dto.setAddress("北京昌平区史各庄");
    //    dto.setAreaCode("123");
    //    dto.setBirthday(DateFormatUtil.DateToStr(new Date(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
    //    dto.setCityCode("123");
    //    dto.setEducationid("123");
    //    dto.setEmail("123@hotmail.com");
    //    dto.setIdCard("371425199108032579");
    //    dto.setMarried("1");
    //    dto.setNation("123");
    //    dto.setOccupationid("123");
    //    dto.setOrgName("泰康人寿");
    //    dto.setPersonnelIdentityName("公务员");
    //    dto.setPersonnelIdentityCode("123");
    //    dto.setPoliticsid("123");
    //    dto.setProvinceCode("123");
    //    dto.setSecurityNumber("3714251991");
    //    dto.setSecurityPersonalNumber("123");
    //    dto.setMobile("13260199197");
    //    String jsonString = JSONObject.toJSONString(dto);
    //    mockMvc
    //        .perform(post("/api/v1/insuredPerson").contentType("application/json").content(jsonString))
    //        .andExpect(status().isOk());
  }

  //  @Test
  //  @Transactional
  //  @Rollback
  //  public void testUpdateInsuredPerson() throws Exception {
  //    InsuredPersonDO personDO = new InsuredPersonDO();
  //
  //    personDO.setInsuredPersonName("李四");
  //    personDO.setInsuredPersonGender("1");
  //    personDO.setAddress("北京昌平区史各庄");
  //    personDO.setAreaCode("123");
  //    personDO.setBirthday(new Date());
  //    personDO.setCityCode("123");
  //    personDO.setEducationid("123");
  //    personDO.setEmail("123@hotmail.com");
  //    personDO.setIdCard("371425199108032579");
  //    personDO.setMarried("1");
  //    personDO.setNation("123");
  //    personDO.setOccupationid("123");
  //    personDO.setOrgName("泰康人寿");
  //    personDO.setPersonnelIdentityName("公务员");
  //    personDO.setPersonnelIdentityCode("123");
  //    personDO.setPoliticsid("123");
  //    personDO.setProvinceCode("123");
  //    personDO.setSecurityNumber("3714251991");
  //    personDO.setSecurityPersonalNumber("123");
  //    personDO.setMobile("13260199197");
  //
  //    insuredPersonService.createInsuredPerson(personDO);
  //
  //    personDO = insuredPersonService.getInsuredPerson("371425199108032579", "李四");
  //
  //    InsuredPersonDTO dto = new InsuredPersonDTO();
  //    dto.setInsuredPersonid(personDO.getInsuredPersonid());
  //    dto.setAddress("中国 北京市 昌平区 史各庄村");
  //    String jsonString = JSONObject.toJSONString(dto);
  //    mockMvc
  //        .perform(put("/api/v1/insuredPerson").contentType("application/json").content(jsonString))
  //        .andExpect(status().isOk())
  //        .andExpect(jsonPath("$.status").value("201"))
  //        .andExpect(jsonPath("$.message").value("修改成功"));
  //  }

  //  @Test
  //  @Transactional
  //  @Rollback
  //  public void testGetInsuredPerson() throws Exception {
  //
  //    InsuredPersonDO personDO = new InsuredPersonDO();
  //    personDO.setInsuredPersonName("李四");
  //    personDO.setInsuredPersonGender("1");
  //    personDO.setAddress("北京昌平区史各庄");
  //    personDO.setAreaCode("123");
  //    personDO.setBirthday(new Date());
  //    personDO.setCityCode("123");
  //    personDO.setEducationid("123");
  //    personDO.setEmail("123@hotmail.com");
  //    personDO.setIdCard("371425199108032579");
  //    personDO.setMarried("1");
  //    personDO.setNation("123");
  //    personDO.setOccupationid("123");
  //    personDO.setOrgName("泰康人寿");
  //    personDO.setPersonnelIdentityName("公务员");
  //    personDO.setPersonnelIdentityCode("123");
  //    personDO.setPoliticsid("123");
  //    personDO.setProvinceCode("123");
  //    personDO.setSecurityNumber("3714251991");
  //    personDO.setSecurityPersonalNumber("123");
  //    personDO.setMobile("13260199197");
  //    insuredPersonService.createInsuredPerson(personDO);
  //
  //    String idCard = personDO.getIdCard();
  //    String insuredPersonName = personDO.getInsuredPersonName();
  //    insuredPersonName = URLEncoder.encode(insuredPersonName, "utf-8");
  //    mockMvc
  //        .perform(
  //            get(
  //                "/api/v1/insuredPerson/{idCard}/and/{insuredPersonName}",
  //                idCard,
  //                insuredPersonName))
  //        .andExpect(status().isOk())
  //        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
  //        .andDo(print()) //打印出请求和响应的内容
  //        .andReturn()
  //        .getResponse()
  //        .getContentAsString(); //将响应的数据转换为字符串
  //    ;
  //  }

}
