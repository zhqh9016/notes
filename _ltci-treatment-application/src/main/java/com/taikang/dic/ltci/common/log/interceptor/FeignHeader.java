package com.taikang.dic.ltci.common.log.interceptor;

import org.springframework.stereotype.Component;

import com.taikang.dic.ltci.common.log.LogConstant;
import com.taikang.dic.ltci.common.log.ThreadLocalUtil;

import feign.RequestInterceptor;
import feign.RequestTemplate;
/**
 * 设置feign请求消息头，用于对端获取服务编码
 *
 * @author itw_muwg
 */
@Component
public class FeignHeader implements RequestInterceptor {

  @Override
  public void apply(RequestTemplate template) {
    template.header(LogConstant.SYSTEM_CODE_KEY, LogConstant.SYSTEM_CODE);
    template.header(LogConstant.MODULE_CODE_KEY, LogConstant.LOG.getLocalCode());
    template.header(LogConstant.BUSINESS_SERIALID_KEY, ThreadLocalUtil.getBusinessSerialid());
    template.header(LogConstant.TIMESTAMP_KEY, ThreadLocalUtil.getTimestamp());
  }
}
