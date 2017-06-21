package com.taikang.dic.ltci.portal.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
  private static final Logger logger = LoggerFactory.getLogger(TestController.class);

  @RequestMapping(path = "/ssessionId")
  public String testSessionId(HttpServletRequest req) {
    logger.info("_____listUser=" + req.getSession().getId());
    return "sessionid=" + req.getSession().getId();
  }
}
