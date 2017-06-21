package com.taikang.dic.ltci.treatment.application.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.net.URLEncoder;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.taikang.dic.ltci.portal.api.model.InsuredPersonDTO;

/**
 * @author itw_xuyao
 * @description
 * @createTime 2017年3月31日 上午9:12:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class TodoListControllerIT {

  private static final Logger logger = LoggerFactory.getLogger(TodoListControllerIT.class);

  private MockMvc mockMvc;

  @Autowired private WebApplicationContext webApplicationContext;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  @Rollback
  public void testlistTodo() throws Exception {

    //        mockMvc
    //            .perform(get("/api/v1/todoList"))
    //            .andExpect(status().isOk())
    //            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //            .andExpect(jsonPath("$.status").value("200"))
    //            .andDo(print()) //打印出请求和响应的内容
    //            .andReturn()
    //            .getResponse()
    //            .getContentAsString(); //将响应的数据转换为字符串
    //        ;
  }
}
