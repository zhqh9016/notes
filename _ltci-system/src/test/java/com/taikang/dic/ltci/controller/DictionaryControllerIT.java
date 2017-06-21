package com.taikang.dic.ltci.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.taikang.dic.ltci.service.DictionaryService;

import net.minidev.json.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DictionaryControllerIT {
  private MockMvc mockMvc;

  @Autowired private WebApplicationContext webApplicationContext;

  @Autowired private DictionaryService dictionaryService;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  /** 字典测试 */
  @Test
  @Rollback
  @Transactional
  public void TestDictionary() throws UnsupportedEncodingException, Exception {
    //    //测试查找
    //    mockMvc
    //        .perform(post("/api/v1/dictionary"))
    //        .andExpect(status().isOk())
    //        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //        .andExpect(jsonPath("$.status").value(200))
    //        .andDo(print()) //打印出请求和响应的内容
    //        .andReturn()
    //        .getResponse()
    //        .getContentAsString(); //将响应的数据转换为字符串
    //    //测试添加
    //
    //    mockMvc
    //        .perform(
    //            post("/api/v1/new/dictionary")
    //                .param("type", "123")
    //                .param("typeName", "123")
    //                .param("value", "123")
    //                .param("valueName", "111111")
    //                .param("createdBy", "cxy")
    //                .param("createdOrg", "ccxxyy"))
    //        .andExpect(status().isOk())
    //        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //        .andExpect(jsonPath("$.status").value("201"))
    //        .andDo(print()) //打印出请求和响应的内容
    //        .andReturn()
    //        .getResponse()
    //        .getContentAsString(); //将响应的数据转换为字符串

    //		//测试删除
    //	    mockMvc
    //		.perform(delete("/dictionary/{id}/user/{operatedBy}","9be78b9d0fdc4eafb01331cdf4ef2905","cxy"))
    //		.andExpect(status().isOk())
    //        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //        .andExpect(jsonPath("$.status").value("406"))
    //        .andDo(print()) //打印出请求和响应的内容
    //        .andReturn()
    //        .getResponse()
    //        .getContentAsString(); //将响应的数据转换为字符串
    //

    //测试修改

  }
}
