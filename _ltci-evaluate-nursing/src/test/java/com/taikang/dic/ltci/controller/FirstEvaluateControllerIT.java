package com.taikang.dic.ltci.controller;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.taikang.dic.ltci.service.FirstEvaluateService;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class FirstEvaluateControllerIT {

  private Logger logger = LoggerFactory.getLogger(FirstEvaluateControllerIT.class);

  private MockMvc mockMvc;

  @Autowired private WebApplicationContext webApplicationContext;
  @Autowired private FirstEvaluateService firstEvaluateService;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @Test
  public void testMq() throws Exception {
    //        InputStream inputStream = null;
    //        try {
    //          File f = new File("D:\\MyDocuments\\itw_xuyao\\桌面\\初评结果接收json-mq.txt");
    //          inputStream = new FileInputStream(f);
    //          byte[] bytes = new byte[inputStream.available()];
    //          inputStream.read(bytes);
    //          String base641 = new String(bytes);
    //          base641 = base641.replaceAll(" ", "").replaceAll("\r\n", "");
    //          logger.info("base641" + base641);
    //
    //          byte[] message = base641.getBytes();
    //          firstEvaluateService.getEvaluateReceive(message);
    //        } catch (Exception e) {
    //          e.printStackTrace();
    //        } finally {
    //          if (inputStream != null) {
    //            inputStream.close();
    //          }
    //        }
  }
}
