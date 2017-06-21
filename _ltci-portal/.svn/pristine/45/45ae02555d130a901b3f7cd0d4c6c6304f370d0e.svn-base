package com.taikang.dic.ltci.portal.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
public class JsonSerializerConfiguration {

  @Bean
  public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
    FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
    //为解决feign调用微服务时将对象中的null值转换成空串导致将数据库中部分字段更新为空的问题,将下面的代码注释掉
    //    converter.setFeatures(
    //        SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty);
    return converter;
  }
}
