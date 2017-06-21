package com.taikang.dic.ltci.portal.common.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authc.UserFilter;

import com.taikang.dic.ltci.portal.common.enumeration.StatusCodeEnum;

/**
 * 自定义用户登录状态检查过滤器,对一些登录后才可以访问的资源,可以通过该过滤器进行验证 可以在ShiroFilterFactoryBean中配置哪些路径需要经过该过滤器
 *
 * @author itw_zhangqh
 */
public class CustomUserFilter extends UserFilter {

  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
      throws Exception {

    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
    httpServletResponse.setStatus(StatusCodeEnum.UNAUTHENTICATED.getValue());
    return false;
  }
}
