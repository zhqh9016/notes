package com.taikang.dic.ltci.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlUtil {
  private Logger logger = LoggerFactory.getLogger(UrlUtil.class);

  @Value("${server.port}")
  private int port;

  @Value("${server.contextPath:}")
  private String contextPath;

  @Value("${restBasePath}")
  private String restBasePath;

  private String baseUrl;

  public String getBaseUrl() {
    if (baseUrl == null) {
      baseUrl = "http://127.0.0.1:" + port + contextPath + restBasePath;
    }
    return this.baseUrl;
  }
}
