package com.taikang.dic.ltci.common.log.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.taikang.dic.ltci.common.IPUtil;
import com.taikang.dic.ltci.common.log.LogBO;
import com.taikang.dic.ltci.common.log.LogConstant;
import com.taikang.dic.ltci.common.log.ThreadLocalUtil;

@Component
public class LogInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    String remoteIp = IPUtil.getRemoteHost(request);
    String businessSerialid = request.getHeader(LogConstant.BUSINESS_SERIALID_KEY);
    String systemCode = request.getHeader(LogConstant.SYSTEM_CODE_KEY);
    String moduleCode = request.getHeader(LogConstant.MODULE_CODE_KEY);
    String timestamp = request.getHeader(LogConstant.TIMESTAMP_KEY);
    String operatedOrg = request.getHeader(LogConstant.OPERATED_ORG_KEY);
    ThreadLocalUtil.threadLocal.set(
        new LogBO(businessSerialid, systemCode, moduleCode, remoteIp, timestamp, operatedOrg));

    //设置返回header
    if (StringUtils.isNotBlank(businessSerialid)) {
      response.addHeader(LogConstant.BUSINESS_SERIALID_KEY, businessSerialid);
    }
    response.addHeader(LogConstant.TIMESTAMP_KEY, ThreadLocalUtil.getTimestamp());

    return true;
  }

  @Override
  public void postHandle(
      HttpServletRequest request,
      HttpServletResponse response,
      Object handler,
      ModelAndView modelAndView)
      throws Exception {}

  @Override
  public void afterCompletion(
      HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
    //清空ThreadLocal
    ThreadLocalUtil.threadLocal.remove();
  }
}
