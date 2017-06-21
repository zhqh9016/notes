package com.taikang.dic.ltci.service;

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

import com.taikang.dic.ltci.api.model.PageResultDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
@Transactional
public class IResServiceTests {
  private static final Logger logger = LoggerFactory.getLogger(IResServiceTests.class);

  @Autowired IResService resService;

  @Test
  @Rollback
  public void selectTest() throws Exception {
    //    PageResultDTO dto = resService.getListResByParentId("0", 1, 10);
    //    logger.debug("______" + dto);
  }
}
