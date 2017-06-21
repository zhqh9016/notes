package com.taikang.dic.ltci.system.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.taikang.dic.ltci.system.serverClient.RoleServerClient;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class RoleControllerIT {
  private static final Logger logger = LoggerFactory.getLogger(RoleControllerIT.class);

  private MockMvc mockMvc;

  @Autowired private WebApplicationContext webApplicationContext;

  @Autowired RoleServerClient roleServerClient;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  /**
   * 角色测试
   *
   * @throws Exception
   */
  @Test
  //  @Rollback
  //  @Transactional
  public void roleTest() throws Exception {
    //        //角色分页查询测试
    //        mockMvc
    //            .perform(
    //                post("/api/v1/roles/list")
    //                    .param("page", "1")
    //                    .param("pageSize", "10"))
    //            .andExpect(status().isOk())
    //            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //            .andDo(print()) // 打印出请求和响应的内容
    //            .andReturn()
    //            .getResponse()
    //            .getContentAsString(); // 将响应的数据转换为字符串
    //        ;
    //
    //    	        //新增角色测试
    //    	        mockMvc
    //    	             .perform(post("/api/v1/role")
    //    	                    .param("createBy", "liuziyang")
    //    	                    .param("roleCode", "123")
    //    	                    .param("roleName", "123")
    //    	                	.param("sequence", "1"))
    //    	                .andExpect(status().isOk())
    //    	                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //    	                .andDo(print()) // 打印出请求和响应的内容
    //    	                .andReturn()
    //    	                .getResponse()
    //    	                .getContentAsString(); // 将响应的数据转换为字符串
    //    	            ;
    //
    //                //删除角色测试
    //                mockMvc
    //                    .perform(delete("/api/v1/role/{id}", "09903c81602e4b2b8dcabbc97e2140e4"))
    //                    .andExpect(status().isOk())
    //                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //                    .andDo(print()) // 打印出请求和响应的内容
    //                    .andReturn()
    //                    .getResponse()
    //                    .getContentAsString(); // 将响应的数据转换为字符串
    //                ;
    //
    //                // 更新用户和角色关系测试
    //                mockMvc
    //                    .perform(
    //                        put("/api/v1/role/RUserRole")
    //                        .param("userId", "130882b96a124c83a0daa50824b6bf19")
    //                        .param("roleId", "130882b96a124c83a0daa50824b6bf1a,130882b96a124c83a0daa50824b6bf1b"))
    //                    .andExpect(status().isOk())
    //                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //                    .andDo(print()) // 打印出请求和响应的内容
    //                    .andReturn()
    //                    .getResponse()
    //                    .getContentAsString(); // 将响应的数据转换为字符串
    //                ;
    //
    //                //查询用户角色测试
    //                mockMvc
    //                    .perform(post("/api/v1/rUserRole")
    //                    		.param("userId", "130882b96a124c83a0daa50824b6bf19"))
    //                    .andExpect(status().isOk())
    //                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
    //                    .andDo(print()) // 打印出请求和响应的内容
    //                    .andReturn()
    //                    .getResponse()
    //                    .getContentAsString(); // 将响应的数据转换为字符串
    //                ;
  }
}
