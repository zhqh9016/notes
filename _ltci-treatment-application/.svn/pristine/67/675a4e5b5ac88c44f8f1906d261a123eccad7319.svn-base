package com.taikang.dic.ltci.config;

import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.taikang.dic.ltci.common.ws.LongTermCareServerImplService;
import com.taikang.dic.ltci.common.ws.LongtermCareService;

/**
 * WebService 客户端配置bean
 *
 * @author itw_liuxy
 * @description
 * @createTime 2017年4月18日 下午2:46:05
 */
@Configuration
public class WSConfig {
  private static final Logger logger = LoggerFactory.getLogger(WSConfig.class);

  public static final String STATUS_SUCCESS = "0";

  @Value("${soap.nurse.wsdl.url}")
  private String url;

  private LongTermCareServerImplService service = null;

  //  @Bean
  public LongtermCareService longtermCaseService() {
    if (service == null) {
      try {
        service = new LongTermCareServerImplService(new URL(url));
      } catch (MalformedURLException e) {
        logger.error("webservice 接口指定地址[" + url + "]初始失败,开始初始默认请求地址", e);
        return null;
      }
    }
    LongtermCareService longtermCareServicePort = service.getLongTermCareServerImplPort();
    return longtermCareServicePort;
  }
}
