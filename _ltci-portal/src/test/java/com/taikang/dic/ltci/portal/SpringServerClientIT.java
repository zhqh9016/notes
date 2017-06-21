package com.taikang.dic.ltci.portal;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.taikang.dic.ltci.portal.service.SpringServerClient;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SpringServerClientIT {
  private static final Logger logger = LoggerFactory.getLogger(SpringServerClientIT.class);

  @Autowired SpringServerClient service;

  @Test
  @Rollback
  public void test() throws Exception {
    //      String str = service.listUser("zhangsan", "1", 1, 10);
    //      logger.info("_____=" + str);
  }
  //
  //  @Test
  //  @Rollback
  //  public void test2() throws Exception {
  //    UserDTO user = new UserDTO();
  //    user.setUserName("zhangsan");
  //    user.setDepartmentid("1");
  //    String str = service.listUserWithBody(user, 1, 10);
  //    logger.info("_____=" + str);
  //  }
  //
  //  @Test
  //  @Rollback
  //  public void test3() throws Exception {
  //    Map<String, String> map = new HashMap<>();
  //    map.put("userName", "zhangsan");
  //    map.put("departmentid", "1");
  //    String str = service.listUserWithMap(map, 1, 10);
  //    logger.info("_____=" + str);
  //  }
}
