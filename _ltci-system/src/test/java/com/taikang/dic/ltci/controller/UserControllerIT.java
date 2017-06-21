package com.taikang.dic.ltci.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.HashMap;
import java.util.List;
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

import com.taikang.dic.ltci.model.UserDO;
import com.taikang.dic.ltci.service.impl.UserServiceImpl;

import net.minidev.json.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserControllerIT {
  private MockMvc mockMvc;

  @Autowired private WebApplicationContext webApplicationContext;

  @Autowired UserServiceImpl userService;

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
  @Rollback
  @Transactional
  public void userTest() throws Exception {
    // 新增用户测试
    //    Map<String, Object> map = new HashMap<String, Object>();
    //    map.put("userName", "liyuehua");
    //    map.put("createdBy", "1");
    //    map.put("password", "111111");
    //    String requestJson = JSONObject.toJSONString(map);
    //    mockMvc
    //        .perform(post("/api/v1/users").contentType(MediaType.APPLICATION_JSON).content(requestJson))
    //        .andExpect(status().isOk())
    //        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //        .andDo(print()) // 打印出请求和响应的内容
    //        .andReturn()
    //        .getResponse()
    //        .getContentAsString(); // 将响应的数据转换为字符串
    //    ;
    //    List<UserDO> userList = userService.listUser("liyuehua");
    //    String id = userList.get(0).getId();
    //    //按用户名精确查询测试
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
    //    Map<String, Object> putMap = new HashMap<String, Object>();
    //    putMap.put("id", id);
    //    putMap.put("trueName", "李悦华");
    //    putMap.put("createdBy", "1");
    //    String requestJsonPut = JSONObject.toJSONString(map);
    //    mockMvc
    //        .perform(
    //            put("/api/v1/users").contentType(MediaType.APPLICATION_JSON).content(requestJsonPut))
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
    //    Map<String, Object> deleteMap = new HashMap<String, Object>();
    //    deleteMap.put("operatedBy", id);
    //    mockMvc
    //        .perform(delete("/api/v1/users/{id}", id))
    //        .andExpect(status().isOk())
    //        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //        .andDo(print()) // 打印出请求和响应的内容
    //        .andReturn()
    //        .getResponse()
    //        .getContentAsString(); // 将响应的数据转换为字符串
    //    ;
  }
}
