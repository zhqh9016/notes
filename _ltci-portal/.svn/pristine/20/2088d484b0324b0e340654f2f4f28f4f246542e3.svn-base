package com.taikang.dic.ltci.portal.common.shiro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.portal.api.model.MenuDTO;
import com.taikang.dic.ltci.portal.api.model.OrganizationDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.RoleDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.enumeration.IsMenuEnum;
import com.taikang.dic.ltci.portal.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.system.service.IOrganizationService;
import com.taikang.dic.ltci.system.service.MenuService;
import com.taikang.dic.ltci.system.service.RoleService;

/**
 * 表单验证（包含验证码）过滤类 自定义登录过滤器,该过滤器做三个工作,
 * 1:负责从登录请求提交的表单中获取用户登录信息,然后封装到UserNamePasswordToken中返回给SecurityManager.
 * 2:当登录成功后将用户所属组织机构和可访问的资源列表存入Subject中. 3:当用户登录失败后通过流的方式向前台返回提示信息
 *
 * @author itw_zhangqh
 */
public class CustomFormAuthenticationFilter
    extends org.apache.shiro.web.filter.authc.FormAuthenticationFilter {

  @Autowired private IOrganizationService organizationService;

  @Autowired private MenuService menuService;

  @Autowired private RoleService roleService;

  private static final Logger log = LoggerFactory.getLogger(CustomFormAuthenticationFilter.class);

  protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
    // TODO 现在前台传递的用户名密码表单默认为username和password
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    log.info(username + "请求登录");

    return new UsernamePasswordToken(username, password.toCharArray());
  }

  /** 登录成功后向前台响应登录成功提示 */
  @SuppressWarnings("unchecked")
  @Override
  protected boolean onLoginSuccess(
      AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response)
      throws Exception {
    try {
      HttpServletResponse httpServletResponse = (HttpServletResponse) response;
      //      //将用户所属机构存入subject中
      //      UserDTO principal = (UserDTO) subject.getPrincipal();
      //      String departmentid = principal.getDepartmentid();
      //
      //      if (!StringUtils.isEmpty(departmentid)) {
      //        ResultDTO selectById = organizationService.selectById(departmentid);
      //        Object datas = selectById.getDatas();
      //        String jsonString = JSONObject.toJSONString(datas);
      //        OrganizationDTO userOrganization =
      //            JSONObject.parseObject(jsonString, OrganizationDTO.class);
      //        principal.setDepartment(userOrganization);
      //        log.debug("将用户组织信息存入用户凭证中,组织信息为: " + userOrganization);
      //      }
      //      // 将用户可访问菜单存入subject中
      //      ResultDTO menuDto =
      //          menuService.listMenu(principal.getId(), IsMenuEnum.IS_MENU_YES.getValue());
      //      List<MenuDTO> menuList = (List<MenuDTO>) menuDto.getDatas();
      //      log.debug("将用户菜单信息存入用户凭证中,菜单信息为: " + menuList);
      //      principal.setMenu(menuList);
      //
      //      // 将用户所拥有角色信息存入subject中
      //      ResultDTO roleDto = roleService.getRolesByUserId(principal.getId());
      //      List<Map<String, Object>> roleMapList = (List<Map<String, Object>>) roleDto.getDatas();
      //      List<RoleDTO> roleList = new ArrayList<>();
      //      if (roleDto.getDatas() != null) {
      //        roleList = JSONArray.parseArray(roleMapList.toString(), RoleDTO.class);
      //        log.debug("将用户角色信息存入用户凭证中,角色信息为: " + roleList);
      //      }
      //      principal.setRole(roleList);

      //将登录成功信息写回客户端
      httpServletResponse.setCharacterEncoding("UTF-8");
      PrintWriter out = httpServletResponse.getWriter();
      out.println("{\"success\":true,\"message\":\"登入成功\"}");
      out.flush();
      out.close();
    } catch (Exception e) {
      log.error("==CustomFormAuthenticationFilter==onLoginSuccess发生异常=", e);
      throw new AuthenticationException(e);
    }
    return false;
  }

  @Override
  protected boolean onLoginFailure(
      AuthenticationToken token,
      AuthenticationException e,
      ServletRequest request,
      ServletResponse response) {

    try {
      //如果在loginSuccess方法中出现了异常,此处需要将登录信息去除掉
      Subject subject = SecurityUtils.getSubject();
      if (subject != null && subject.isAuthenticated()) {
        subject.logout();
      }
      response.setCharacterEncoding("UTF-8");
      PrintWriter out = response.getWriter();
      String message = e.getClass().getSimpleName();
      //根据不同的异常信息返回不同的提示
      if ("IncorrectCredentialsException".equals(message)) {
        out.println("{\"success\":false,\"message\":\"密码错误\"}");
      } else if ("UnknownAccountException".equals(message)) {
        out.println("{\"success\":false,\"message\":\"账号不存在\"}");
      } else {
        out.println("{\"success\":false,\"message\":\"未知错误\"}");
      }
      out.flush();
      out.close();
    } catch (IOException e1) {
      log.error("==CustomFormAuthenticationFilter==onLoginFailure发生异常=", e1);
    }
    return false;
  }

  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response)
      throws Exception {
    try {
      //如果是登录请求,执行登录逻辑
      if (isLoginRequest(request, response)) {
        if (isLoginSubmission(request, response)) {
          if (log.isTraceEnabled()) {
            log.trace("Login submission detected.  Attempting to execute login.");
          }
          return executeLogin(request, response);
        } else {
          if (log.isTraceEnabled()) {
            log.trace("Login page view.");
          }
          //allow them to see the login page ;)
          return true;
        }
      } else {
        //如果是非登录请求,返回状态码
        if (log.isTraceEnabled()) {
          log.trace(
              "Attempting to access a path which requires authentication.  Forwarding to the "
                  + "Authentication url ["
                  + getLoginUrl()
                  + "]");
        }

        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setStatus(StatusCodeEnum.UNAUTHENTICATED.getValue());
      }
    } catch (Exception e) {
      log.error("未登录用户访问被拒绝后发生异常,异常信息为:", e);
    }
    return false;
  }
}
