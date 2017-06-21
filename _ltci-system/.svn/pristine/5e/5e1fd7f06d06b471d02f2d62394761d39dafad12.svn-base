package com.taikang.dic.ltci.common.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

/** 预防xss漏洞攻击 */
@Component
public class XSSFilter implements Filter {
  private String spiltChar = "@";
  private String filterChar = ">@<@\\@#@(@)";
  private String replaceChar = "＞@＜@＼@＃@（@）";
  private String removeChar = "delete@select@update@or@DELETE@SELECT@UPDATE@OR";
  private Set<String> pathList = new HashSet<>();

  @Override
  public void destroy() {}

  /** 执行拦截器 */
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
      throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletRequest response = (HttpServletRequest) servletRequest;
    String path = request.getServletPath();
    if (isCheckParmUrl(path)) {
      //进行XSS参数防注入拦截
      chain.doFilter(
          new XssHttpServerletRequestWrapper(request, filterChar, replaceChar, spiltChar),
          servletResponse);
    } else {
      chain.doFilter(servletRequest, servletResponse);
    }
  }

  /** 参数初始化 */
  public void init(FilterConfig config) throws ServletException {

    //=================过滤排除地址======

    //		pathList.add("/goods/manage/editGoodsNew.do");
  }
  /**
   * 校验URL是否需要拦截参数
   *
   * @param path
   * @return
   */
  private boolean isCheckParmUrl(String path) {
    if (pathList.contains(path)) {
      return false;
    }
    return true;
  }
}
