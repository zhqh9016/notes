package com.taikang.dic.ltci.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.ApplicationDTO;
import com.taikang.dic.ltci.api.model.RestBaseDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.api.model.TreatmentApplicationDTO;
import com.taikang.dic.ltci.common.enumeration.SourcesEnum;
import com.taikang.dic.ltci.common.utils.DateFormat;
import com.taikang.dic.ltci.common.utils.DateFormatUtil;
import com.taikang.dic.ltci.common.utils.Encodes;
import com.taikang.dic.ltci.model.ApplicationDO;
import com.taikang.dic.ltci.model.InsuredPersonDO;
import com.taikang.dic.ltci.service.ApplicationService;
import com.taikang.dic.ltci.service.InsuredPersonService;

import rx.internal.util.LinkedArrayList;

/**
 * @author itw_xuxf
 * @description
 * @version 创建时间：2017年4月6日上午9:06:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TreatmentApplicationControllerIT {
  private Logger logger = LoggerFactory.getLogger(TreatmentApplicationControllerIT.class);
  private MockMvc mockMvc;

  @Autowired private WebApplicationContext webApplicationContext;

  @Autowired private ApplicationService applicationService;
  @Autowired private InsuredPersonService insuredPersonService;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  /**
   * 根据待遇申请编号获取详情信息
   *
   * @throws Exception
   */
  //@Test
  //@Transactional
  //@Rollback
  //public void testGetTreatmentApplication() throws Exception {
  //    InsuredPersonDO dto = new InsuredPersonDO();
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
  //    String insuredPersonCode = insuredPersonService.createInsuredPerson(personDO);
  //    logger.debug(
  //        "=============================================生成的insuredPersonCode：" + insuredPersonCode);
  //
  //    ApplicationDTO dto1 = new ApplicationDTO();
  //    dto1.setAddress("北京市昌平区");
  //    dto1.setApplicationFormScan("123");
  //    dto1.setApplicationReason("123");
  //    dto1.setApplicationStatus("00");
  //    dto1.setBidType("123");
  //    dto1.setCaseHistoryScan("123");
  //    dto1.setCreatedBy("123");
  //    dto1.setCreatedOrg("123");
  //    dto1.setDeputyAddress("123");
  //    dto1.setDeputyIdCard("123");
  //    dto1.setDeputyIdCardScan("123");
  //    dto1.setDeputyIdType("123");
  //    dto1.setDeputyMobile("123");
  //    dto1.setDeputyName("123");
  //    dto1.setDisease("123");
  //    dto1.setDiseaseCause("123");
  //    dto1.setIdCardScan("123");
  //    dto1.setInsuredPersonCode(insuredPersonCode);
  //    dto1.setIsRelativeCared("123");
  //    dto1.setIsTaskDeadline("123");
  //    dto1.setIsValid(1);
  //    dto1.setMobile("13260199197");
  //    dto1.setOperatedBy("123");
  //    dto1.setOperatedOrg("123");
  //    dto1.setSiArea("123");
  //    dto1.setSources("123");
  //    dto1.setSecurityNumberScan("123");
  //    dto1.setSiArea("123");
  //
  //    ApplicationDO applicationDO = new ApplicationDO();
  //    BeanUtils.copyProperties(dto1, applicationDO);
  //    String applicationCode = applicationService.createApplication(applicationDO);
  //    logger.debug(
  //        "=============================================生成的applicationCode：" + applicationCode);

  //    mockMvc
  //        .perform(get("/api/v1/mobileTreatmentApplication/{applicationCode}", applicationCode))
  //        .andExpect(status().isOk())
  //        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
  //        .andExpect(jsonPath("$.status").value("200"))
  //        .andExpect(jsonPath("$.datas.insuredPersonCode").value(insuredPersonCode))
  //        .andExpect(jsonPath("$.datas.applicationCode").value(applicationCode))
  //        .andDo(print()) //打印出请求和响应的内容
  //        .andReturn()
  //        .getResponse()
  //        .getContentAsString(); //将响应的数据转换为字符串
  //
  //    String applicationStatus = "02";
  //    String applicationReason = "dsfgdfgdgd";
  //    mockMvc
  //        .perform(
  //            put(
  //                "/api/v1/mobileTreatmentApplicationCase/{applicationCode}/{applicationStatus}/{applicationReason}",
  //                applicationCode,
  //                applicationStatus,
  //                applicationReason))
  //        .andExpect(status().isOk())
  //        .andExpect(jsonPath("$.status").value("201"))
  //        .andDo(print())
  //        .andReturn()
  //        .getResponse()
  //        .getContentAsString();

  //    Map<String, Object> map = new HashMap<String, Object>();
  //    map.put("insuredPersonName", "");
  //    map.put("idCard", "");
  //    map.put("securityNumber", "");
  //    map.put("disease", "");
  //    map.put("operatedTime", "");
  //    map.put("applicationStatus", "");
  //    map.put("page", 0);
  //    map.put("pageSize", 10);
  //    String jsonString = JSONObject.toJSONString(map);
  //    mockMvc
  //        .perform(
  //            post("/api/v1/mobileTreatmentApplications")
  //                .contentType("application/json")
  //                .content(jsonString))
  //        .andExpect(status().isOk())
  //        .andExpect(jsonPath("$.status").value("200"))
  //        .andDo(print())
  //        .andReturn()
  //        .getResponse()
  //        .getContentAsString();

  // ;
  //}

  @Test
  public void createMobileTreatmentApplication() throws UnsupportedEncodingException, Exception {

    //    InputStream inputStream = null;
    //    try {
    //      File f = new File("D:\\待遇申请接口入参.txt");
    //      inputStream = new FileInputStream(f);
    //      byte[] bytes = new byte[inputStream.available()];
    //      inputStream.read(bytes);
    //      String base641 = new String(bytes);
    //      base641 = base641.replaceAll(" ", "").replaceAll("\r\n", "");
    //      logger.info("base641" + base641);
    //
    //      TreatmentApplicationDTO applicationDTO =
    //          JSONObject.parseObject(base641, TreatmentApplicationDTO.class);
    //
    //      logger.info("xxx:" + applicationDTO.getApplicationCode());
    //
    //      String jsonString = JSONObject.toJSONString(applicationDTO);
    //
    //      logger.info("测试数据：" + jsonString);
    //
    //      mockMvc
    //          .perform(
    //              post("/api/v1/mobileTreatmentApplication")
    //                  .contentType("application/json")
    //                  .content(jsonString))
    //          .andExpect(status().isOk())
    //          .andDo(print()) //打印出请求和响应的内容
    //          .andReturn()
    //          .getResponse()
    //          .getContentAsString(); //将响应的数据转换为字符串
    //
    //    } catch (Exception e) {
    //      e.printStackTrace();
    //    } finally {
    //      if (inputStream != null) {
    //        inputStream.close();
    //      }
    //    }
  }
}
