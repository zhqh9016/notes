package com.taikang.dic.ltci.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.taikang.dic.ltci.common.util.MHttpServletRequest;

/**
 * 非法字符过滤器，用来处理request.getParamater中的非法字符。如<script>alert('123');</script>
 *
 * @author itw_huodd
 */
//@WebFilter(filterName="xssAndSqlShieldFilter" ,urlPatterns="/*")
//@Component
public class XssAndSqlShieldFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    httpServletRequest = new MHttpServletRequest(httpServletRequest);
    chain.doFilter(httpServletRequest, response);
  }

  @Override
  public void destroy() {}
}
