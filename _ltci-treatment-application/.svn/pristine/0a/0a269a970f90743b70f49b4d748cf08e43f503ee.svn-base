package com.taikang.dic.ltci.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@Configuration
public class JsonSerializerConfiguration {

  @Bean
  public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
    FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
    converter.setFeatures(
        SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty);
    return converter;
  }
}
