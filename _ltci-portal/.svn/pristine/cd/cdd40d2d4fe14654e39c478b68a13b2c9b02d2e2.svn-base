package com.taikang.dic.ltci.treatment.application.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

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
import com.taikang.dic.ltci.portal.api.model.DeputyBindingDTO;

/**
 * @author itw_xuyao
 * @description
 * @createTime 2017年3月31日 上午9:12:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DeputyBindingControllerIT {

  private static final Logger logger = LoggerFactory.getLogger(DeputyBindingControllerIT.class);

  private MockMvc mockMvc;

  @Autowired private WebApplicationContext webApplicationContext;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void testDeputyBinding() throws Exception {
    //     //根据deputyBindingid查询出具体信息
    //        mockMvc
    //            .perform(get("/api/v1/deputy/bindings/{deputyBindingCode}", "0001"))
    //            .andExpect(status().isOk())
    //            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //            .andExpect(jsonPath("$.message").value("查询成功"))
    //            .andDo(print()) // 打印出请求和响应的内容
    //            .andReturn()
    //            .getResponse()
    //            .getContentAsString(); // 将响应的数据转换为字符串
    //
    //        logger.info("-----------------start---------------------");
    //        // 审核代理人绑定信息 修改审核状态 并且删除代办信息
    //        mockMvc
    //            .perform(
    //                put("/api/v1/deputy/bindings/deputyBindingid/checkState")
    //                    .param("deputyBindingid", "2").param("checkState", "03").param("checkReason", ""))
    //            .andExpect(status().isOk())
    //            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //            .andExpect(jsonPath("$.message").value("审核成功"))
    //            .andDo(print()) // 打印出请求和响应的内容
    //            .andReturn()
    //            .getResponse()
    //            .getContentAsString(); // 将响应的数据转换为字符串
    //        logger.info("-----------------End---------------------");
  }
}
