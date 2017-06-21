package com.taikang.dic.ltci.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.serviceClient.CheckInServerClient;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class CheckInClientTest {

  @Autowired private CheckInServerClient checkInServerClient;

  //  @Test
  public void fun1() {
    ResultDTO check = checkInServerClient.getInHostStat4Check("1155bcded4f74c48b96117c5f7aa64ff");
    System.out.println(JSONObject.toJSONString(check));
  }

  @Test
  public void fun() {}
}
