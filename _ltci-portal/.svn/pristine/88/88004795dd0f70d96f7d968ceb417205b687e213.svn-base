package com.taikang.dic.ltci.portal.common.log;

import java.io.IOException;
import java.lang.reflect.Type;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.support.SpringDecoder;
import org.springframework.stereotype.Component;

import feign.Response;
/**
 * 跨系统交互时统一了消息头，用feign调用后可以在这里获取response的header信息， 目前系统没有用到，需要使用时开启@component注解，在decode方法中处理逻辑。
 *
 * @author itw_muwg
 */
//@Component
public class ResponseDecoder extends SpringDecoder {

  public ResponseDecoder(ObjectFactory<HttpMessageConverters> messageConverters) {
    super(messageConverters);
  }

  @Override
  public Object decode(final Response response, Type type) throws IOException {
    //从response 中获取header进行处理逻辑
    return super.decode(response, type);
  }
}
