package com.taikang.dic.ltci.configration;

import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.taikang.dic.ltci.common.ws.LongTermCareServerImplService;
import com.taikang.dic.ltci.common.ws.LongtermCareService;

/**
 * webservice 客户端配置bean
 *
 * @author itw_zhangqh
 */
@Configuration
public class WSConfig {
  private static final Logger logger = LoggerFactory.getLogger(WSConfig.class);

  public static final String STATUS_SUCCESS = "0";

  @Value("${soap.nurse.wsdl.url}")
  String url;

  LongTermCareServerImplService service = null;

  //  @Bean
  public LongtermCareService longtermCaseService() {
    if (service == null) {
      try {
        service = new LongTermCareServerImplService(new URL(url));
      } catch (MalformedURLException e) {
        logger.error("webservice 接口指定地址[" + url + "]初始失败", e);
        return null;
      }
    }
    LongtermCareService longtermCareServicePort = service.getLongTermCareServerImplPort();
    return longtermCareServicePort;
  }
}
