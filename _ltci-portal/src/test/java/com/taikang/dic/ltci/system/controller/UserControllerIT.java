package com.taikang.dic.ltci.system.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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

import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.system.serverClient.UserServerClient;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserControllerIT {
  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  private MockMvc mockMvc;

  @Autowired private WebApplicationContext webApplicationContext;

  @Autowired UserServerClient userClient;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  /**
   * 用户测试
   *
   * @throws Exception
   */
  @Test
  //  @Rollback
  //  @Transactional
  public void userTest() throws Exception {
    //    // 新增用户测试
    //    mockMvc
    //        .perform(post("/api/v1/users").param("userName", "liyuehua").param("createdBy", "1"))
    //        .andExpect(status().isOk())
    //        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //        .andDo(print()) // 打印出请求和响应的内容
    //        .andReturn()
    //        .getResponse()
    //        .getContentAsString(); // 将响应的数据转换为字符串
    //    ;
    //
    //    //按用户名精确查询测试
    //    ResultDTO userRet = userClient.listUser("liyuehua");
    //    logger.debug("_____userResultDto=" + userRet);
    //    String[] ret = userRet.getDatas().toString().split(",");
    //    String id = ret[0].split("=")[1];
    //    logger.debug("_____id=" + id);
    //    mockMvc
    //        .perform(get("/api/v1/users/{userName}", "liyuehua"))
    //        .andExpect(status().isOk())
    //        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //        .andDo(print()) // 打印出请求和响应的内容
    //        .andReturn()
    //        .getResponse()
    //        .getContentAsString(); // 将响应的数据转换为字符串
    //    ;
    //
    //    //按ID查询用户信息
    //    mockMvc
    //        .perform(get("/api/v1/user/{id}", id))
    //        .andExpect(status().isOk())
    //        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //        .andDo(print()) // 打印出请求和响应的内容
    //        .andReturn()
    //        .getResponse()
    //        .getContentAsString(); // 将响应的数据转换为字符串
    //    ;
    //    // 更新用户测试
    //    mockMvc
    //        .perform(
    //            put("/api/v1/users").param("id", id).param("trueName", "李悦华").param("createdBy", "1"))
    //        .andExpect(status().isOk())
    //        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //        .andDo(print()) // 打印出请求和响应的内容
    //        .andReturn()
    //        .getResponse()
    //        .getContentAsString(); // 将响应的数据转换为字符串
    //    ;
    //    //分页查询测试
    //    mockMvc
    //        .perform(
    //            post("/api/v1/users/list")
    //                .param("userName", "")
    //                .param("departmentid", "")
    //                .param("page", "1")
    //                .param("pageSize", "2"))
    //        .andExpect(status().isOk())
    //        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //        .andDo(print()) // 打印出请求和响应的内容
    //        .andReturn()
    //        .getResponse()
    //        .getContentAsString(); // 将响应的数据转换为字符串
    //    ;
    //    //删除用户测试
    //    mockMvc
    //        .perform(delete("/api/v1/users/{id}/{operatedBy}", id, "22"))
    //        .andExpect(status().isOk())
    //        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //        .andDo(print()) // 打印出请求和响应的内容
    //        .andReturn()
    //        .getResponse()
    //        .getContentAsString(); // 将响应的数据转换为字符串
    //    ;
  }
}
