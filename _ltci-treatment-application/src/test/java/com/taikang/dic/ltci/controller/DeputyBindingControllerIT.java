package com.taikang.dic.ltci.controller;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.taikang.dic.ltci.dao.DeputyBindingDAO;
import com.taikang.dic.ltci.dao.InsuredPersonDAO;
import com.taikang.dic.ltci.service.DeputyBindingService;

/**
 * @author itw_xuyao
 * @description
 * @createTime 2017年3月31日 上午9:12:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DeputyBindingControllerIT {

  private Logger logger = LoggerFactory.getLogger(DeputyBindingControllerIT.class);

  private MockMvc mockMvc;

  @Autowired private WebApplicationContext webApplicationContext;
  @Autowired private DeputyBindingDAO DeputyBindingDAO;
  @Autowired private InsuredPersonDAO insuredPersonDAO;
  @Autowired private DeputyBindingService deputyBindingService;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  @Rollback
  @Transactional
  public void testDeputyBinding() throws Exception {
    //    String uuid = UUID.randomUUID().toString().replaceAll("-", "");
    //
    //    InsuredPersonDO insuredPersonDO = new InsuredPersonDO();
    //    insuredPersonDO.setInsuredPersonid(UUID.randomUUID().toString().replaceAll("-", ""));
    //    insuredPersonDO.setInsuredPersonCode(uuid);
    //    insuredPersonDO.setInsuredPersonName("许瑶");
    //    insuredPersonDO.setInsuredPersonGender("1");
    //    insuredPersonDO.setBirthday(new Date());
    //    insuredPersonDO.setSecurityNumber("123");
    //    insuredPersonDO.setIdCard("222304");
    //    insuredPersonDO.setEmail("email");
    //    insuredPersonDO.setMobile("19090909090");
    //    insuredPersonDO.setAddress("北京");
    //    insuredPersonDO.setOrgName("222304");
    //    insuredPersonDO.setMarried("4");
    //    insuredPersonDO.setEducationid("11");
    //    insuredPersonDO.setPoliticsid("123");
    //    insuredPersonDO.setOccupationid("1");
    //    insuredPersonDO.setAreaCode("123");
    //    insuredPersonDAO.insert(insuredPersonDO);
    //
    //    DeputyBindingDO deputyBindingDO = new DeputyBindingDO();
    //    deputyBindingDO.setDeputyBindingid(UUID.randomUUID().toString().replaceAll("-", ""));
    //    deputyBindingDO.setDeputyBindingCode("deputyBindingCode");
    //    deputyBindingDO.setSerialNumber("serialNumber");
    //    deputyBindingDO.setInsuredPersonCode(uuid);
    //    deputyBindingDO.setIdCard("222401");
    //    deputyBindingDO.setSecurityNumber("secutityNumber");
    //    deputyBindingDO.setDeputyName("测试名字");
    //    deputyBindingDO.setDeputyIdCard("222403100");
    //    deputyBindingDO.setDeputyMobile("18090909090");
    //    deputyBindingDO.setDeputyIdCardScan("");
    //    deputyBindingDO.setSecurityNumberScan("");
    //    deputyBindingDO.setIdCardScan("");
    //    deputyBindingDO.setCaseHistoryScan("");
    //    deputyBindingDO.setApplicationFormScan("");
    //    deputyBindingDO.setCheckState("02");
    //    deputyBindingDO.setCheckReason("");
    //    deputyBindingDO.setRemark("");
    //    deputyBindingDO.setIsValid(1);
    //    DeputyBindingDAO.insert(deputyBindingDO);
    //
    //    TodoListDO todoListDO = new TodoListDO();
    //    todoListDO.setTodoListid(UUID.randomUUID().toString().replaceAll("-", ""));
    //    todoListDO.setTodoListCode("todoListCode");
    //    todoListDO.setTitle("title");
    //    todoListDO.setBusinessCode(deputyBindingDO.getDeputyBindingCode());
    //    todoListDO.setBusinessType("01");
    //    todoListDO.setId("ip");
    //    todoListDO.setPort("port");
    //    todoListDO.setUri("uri");
    //    todoListDO.setUrl("url");
    //    todoListDO.setType("01");
    //    todoListDO.setReceiveCharactar("测试接收角色");
    //    todoListDO.setAdministrativeRegion("测试行政区域");
    //    todoListDO.setJumpWay("_blank");
    //    todoListDO.setIsValid(1);
    //    todoListDO.setCreatedTime(new Date());
    //    todoListDAO.insert(todoListDO);
    //
    //    // 根据deputyBindingCode查询出具体信息
    //    mockMvc
    //        .perform(
    //            get(
    //                "/api/v1/deputy/bindings/{deputyBindingCode}",
    //                deputyBindingDO.getDeputyBindingCode()))
    //        .andExpect(status().isOk())
    //        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //        //.andExpect(jsonPath("$.message").value("查询成功"))
    //        .andDo(print()) // 打印出请求和响应的内容
    //        .andReturn()
    //        .getResponse()
    //        .getContentAsString(); // 将响应的数据转换为字符串
    //
    //    logger.info("-----------------start---------------------");
    //    //审核代理人绑定信息 修改审核状态 并且删除代办信息
    //    DeputyBindingDTO dto = new DeputyBindingDTO();
    //    dto.setDeputyBindingid(deputyBindingDO.getDeputyBindingid());
    //    dto.setCheckState("03");
    //    dto.setCheckReason(deputyBindingDO.getCheckReason());
    //    String jsonString = JSONObject.toJSONString(dto);
    //    mockMvc
    //        .perform(
    //            put("/api/v1/deputy/bindings/deputyBindingid/checkState")
    //                .contentType("application/json")
    //                .content(jsonString))
    //        .andExpect(status().isOk())
    //        // .andExpect(jsonPath("$.message").value("审核成功"))
    //        .andDo(print()) // 打印出请求和响应的内容
    //        .andReturn()
    //        .getResponse()
    //        .getContentAsString(); // 将响应的数据转换为字符串
    //    logger.info("-----------------End---------------------");
    //    // 根据指定信息查询绑定信息
    //
    //    String jsonStr = JSONObject.toJSONString(deputyBindingDO);
    //    mockMvc
    //        .perform(
    //            post("/api/v1/deputy/binding/status").contentType("application/json").content(jsonStr))
    //        .andExpect(status().isOk())
    //        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //        //.andExpect(jsonPath("$.datas.result").value("1"))
    //        .andDo(print()) // 打印出请求和响应的内容
    //        .andReturn()
    //        .getResponse()
    //        .getContentAsString(); // 将响应的数据转换为字符串
    //
    //    //待遇申请列表查询
    //    mockMvc
    //        .perform(post("/api/v1/deputy/bindings"))
    //        .andExpect(status().isOk())
    //        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //        //.andExpect(jsonPath("$.status").value("200"))
    //        .andDo(print()) // 打印出请求和响应的内容
    //        .andReturn()
    //        .getResponse()
    //        .getContentAsString(); // 将响应的数据转换为字符串
  }

  //  @Test
  //  public void testMq() throws Exception {
  //    InputStream inputStream = null;
  //    try {
  //      File f = new File("D:\\MyDocuments\\itw_xuyao\\桌面\\new 3.txt");
  //      inputStream = new FileInputStream(f);
  //      byte[] bytes = new byte[inputStream.available()];
  //      inputStream.read(bytes);
  //      String base641 = new String(bytes);
  //      base641 = base641.replaceAll(" ", "").replaceAll("\r\n", "");
  //      logger.info("base641" + base641);
  //
  //      byte[] message = base641.getBytes();
  //      deputyBindingService.createDeputyBinding(message);
  //    } catch (Exception e) {
  //      e.printStackTrace();
  //    } finally {
  //      if (inputStream != null) {
  //        inputStream.close();
  //      }
  //    }
  //  }
}
