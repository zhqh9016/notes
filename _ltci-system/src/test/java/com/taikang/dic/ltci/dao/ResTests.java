package com.taikang.dic.ltci.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
@Transactional
public class ResTests {
  private static final Logger logger = LoggerFactory.getLogger(ResTests.class);

  @Autowired ResDAO resDao;

  @Test
  @Rollback
  public void selectTest() throws Exception {
    //    ResDO res = resDao.selectByPrimaryKey("1");
    //    logger.info("___res=" + res);
    //    Assert.assertEquals(null, res);
  }

  @Test
  @Rollback
  public void test() throws Exception {
    //    userService.listUser("zhangsan", "", 2, 10);
    logger.info("______");
  }
}
