package com.taikang.dic.ltci.portal.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.taikang.dic.ltci.portal.common.log.interceptor.LogInterceptor;

@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    //addPathPatterns添加拦截路径
    registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**");
    super.addInterceptors(registry);
  }
}
