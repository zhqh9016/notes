package com.taikang.dic.ltci.system.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

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

import net.minidev.json.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class OrganizationControllerIT {
  private MockMvc mockMvc;

  @Autowired private WebApplicationContext webApplicationContext;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  /**
   * 机构测试
   *
   * @throws Exception
   */
  @Test
  public void organizationTest() throws Exception {
    // 新增组织测试
    /* Map<String, Object> map = new HashMap<String, Object>();
    map.put("parentid", "0");
    map.put("name", "昌平区社会保障局");
    map.put("code", "CPQ");
    map.put("describe", "管社保的");
    map.put("sequence", "1");
    map.put("provinceid", "8a80a4f03b4fb59b013b4fc305e0004b");
    map.put("cityid", "8a80a4f03b4fb59b013b4fc305e0004b");
    map.put("createdBy", "1");
    String requestJson = JSONObject.toJSONString(map);
    mockMvc
        .perform(post("/api/v1/organization")
        .contentType(MediaType.APPLICATION_JSON)
        .content(requestJson))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print()) // 打印出请求和响应的内容
        .andReturn()
        .getResponse()
        .getContentAsString(); // 将响应的数据转换为字符串
    ;*/
    //按机构名精确查询测试
    /*mockMvc
        .perform(get("/api/v1/organization/getByName").param("name", "organization"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print()) // 打印出请求和响应的内容
        .andReturn()
        .getResponse()
        .getContentAsString(); // 将响应的数据转换为字符串
    ;*/

    //按ID查询组织信息
    /*mockMvc
        .perform(get("/api/v1/organization/{id}", "1"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print()) // 打印出请求和响应的内容
        .andReturn()
        .getResponse()
        .getContentAsString(); // 将响应的数据转换为字符串
    ;*/
    // 更新组织测试
    /*Map<String, Object> putMap = new HashMap<String, Object>();
    putMap.put("phone", "15229474083");
    putMap.put("operatedBy", "1");
    String requestJsonPut = JSONObject.toJSONString(map);
    mockMvc
        .perform(
            put("/api/v1/organization/{orgid}","1").contentType(MediaType.APPLICATION_JSON)
        .content(requestJsonPut))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print()) // 打印出请求和响应的内容
        .andReturn()
        .getResponse()
        .getContentAsString(); // 将响应的数据转换为字符串
    ;*/

    //删除组织测试
    /*mockMvc
        .perform(delete("/api/v1/organization/{id}", "2").param("operatedBy", "3"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andDo(print()) // 打印出请求和响应的内容
        .andReturn()
        .getResponse()
        .getContentAsString(); // 将响应的数据转换为字符串
    ;*/
  }
}
