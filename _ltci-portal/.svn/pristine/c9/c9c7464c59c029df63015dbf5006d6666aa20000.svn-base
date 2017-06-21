package com.taikang.dic.ltci.portal.common.shiro;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taikang.dic.ltci.portal.common.enumeration.StatusCodeEnum;

/**
 * 自定义授权过滤器, 该过滤器负责两个工作: 1,对比用户拥有的角色和请求的资源需要的角色之间是否匹配. 2,授权失败后通过流的方式给前台响应授权失败状态码
 *
 * @author itw_zhangqh
 */
public class CustomAnyRoleAuthorizationFilter extends AuthorizationFilter {

  private static final Logger log = LoggerFactory.getLogger(CustomAnyRoleAuthorizationFilter.class);

  @Override
  protected boolean isAccessAllowed(
      ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
    Subject subject = getSubject(request, response);
    String[] rolesArray = (String[]) mappedValue;

    if (rolesArray == null || rolesArray.length == 0) {
      //no roles specified, so nothing to check - allow access.
      return true;
    }

    Set<String> roles = CollectionUtils.asSet(rolesArray);
    for (String roleIdentifier : roles) {
      boolean hasRole = subject.hasRole(roleIdentifier);
      if (hasRole) {
        return true;
      }
    }
    return false;
  }

  /** 用户授权失败后返回给前台状态为403 */
  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
      throws IOException {

    try {
      Subject subject = getSubject(request, response);
      HttpServletResponse httpServletResponse = (HttpServletResponse) response;
      if (subject.getPrincipal() == null) {
        httpServletResponse.setStatus(StatusCodeEnum.UNAUTHENTICATED.getValue());
      } else {
        httpServletResponse.setStatus(StatusCodeEnum.UNAUTHORIZED.getValue());
      }
    } catch (Exception e) {
      log.error("为授权用户访问被拒绝后发生异常,异常信息为:", e);
    }
    return false;
  }
}
