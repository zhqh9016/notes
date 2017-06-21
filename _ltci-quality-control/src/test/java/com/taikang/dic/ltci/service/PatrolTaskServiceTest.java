package com.taikang.dic.ltci.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.service.impl.PatrolTaskServiceImpl;
import com.taikang.dic.ltci.service.impl.ScheduleMqFailRetry;

/**
 * 巡查任务测试类
 *
 * @author itw_liuxy
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class PatrolTaskServiceTest {

  private Logger logger = LoggerFactory.getLogger(PatrolTaskServiceTest.class);

  @Autowired private PatrolTaskServiceImpl patrolTaskService;
  @Autowired ScheduleMqFailRetry scheduleMqFailRetry;

  @Test
  public void testGetMobileCompliain() {
    scheduleMqFailRetry.retryFailMessage();
    //    InputStream inputStream = null;
    //    try {
    //      File f = new File("D:\\MyDocuments\\itw_xuyao\\桌面\\new 8.txt");
    //      inputStream = new FileInputStream(f);
    //      byte[] bytes = new byte[inputStream.available()];
    //      inputStream.read(bytes);
    //      String base641 = new String(bytes);
    //      base641 = base641.replaceAll("\r\n", "").replaceAll("\t", "");
    //      logger.info("base641" + base641);
    //      patrolTaskService.getMobileCompliain(base641.getBytes("utf-8"));
    //    } catch (Exception e) {
    //      e.printStackTrace();
    //    } finally {
    //      if (inputStream != null) {
    //        try {
    //          inputStream.close();
    //        } catch (IOException e) {
    //          e.printStackTrace();
    //        }
    //      }
    //    }
  }
}
