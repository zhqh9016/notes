package com.taikang.dic.ltci.system.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

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

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class AreaControllerIT {
  private MockMvc mockMvc;

  @Autowired private WebApplicationContext webApplicationContext;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  /**
   * 区域测试
   *
   * @throws Exception
   */
  @Test
  public void areaTest() throws Exception {

    // 按ID查询区域信息
    //    mockMvc
    //        .perform(get("/api/v1/area/{id}", "8a80a4e4408547ab01408547f0e304b3"))
    //        .andExpect(status().isOk())
    //        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //        .andDo(print()) // 打印出请求和响应的内容
    //        .andReturn()
    //        .getResponse()
    //        .getContentAsString(); // 将响应的数据转换为字符串
    // 按区域父id查询区域信息
    //    mockMvc
    //        .perform(
    //            get("/api/v1/area/getByParentid")
    //                .param("parentid", "0")
    //                .param("page", "1")
    //                .param("pageSize", "10"))
    //        .andExpect(status().isOk())
    //        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //        .andDo(print()) // 打印出请求和响应的内容
    //        .andReturn()
    //        .getResponse()
    //        .getContentAsString(); // 将响应的数据转换为字符串
  }
}
