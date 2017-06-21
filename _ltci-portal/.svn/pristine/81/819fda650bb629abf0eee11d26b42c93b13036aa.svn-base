package com.taikang.dic.ltci.portal.common.shiro;

import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用户退出处理filter 自定义退出过滤器,该过滤器负责在用户请求退出时清理 用户登录信息,并通过流的形式向前台响应提示
 *
 * @author itw_zhangqh
 */
public class TKLogoutFilter extends LogoutFilter {

  private Logger log = LoggerFactory.getLogger(TKLogoutFilter.class);

  @Override
  protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
    Subject subject = getSubject(request, response);
    try {
      subject.logout();
    } catch (SessionException ise) {
      log.debug(
          "Encountered session exception during logout.  This can generally safely be ignored.",
          ise);
    }
    httpServletResponse.setCharacterEncoding("UTF-8");
    PrintWriter out = httpServletResponse.getWriter();
    out.println("{\"success\":true,\"message\":\"退出成功\"}");
    out.flush();
    out.close();
    return false;
  }
}
