package com.taikang.dic.ltci.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 参数特殊字符过滤
 *
 * @author itw_huodd
 */
public class MHttpServletRequest extends HttpServletRequestWrapper {

  public MHttpServletRequest(HttpServletRequest request) {
    super(request);
  }

  @Override
  public String getParameter(String name) {
    // 返回值之前 先进行过滤
    return XssShieldUtil.stripXss(super.getParameter(XssShieldUtil.stripXss(name)));
  }

  @Override
  public String[] getParameterValues(String name) {
    // 返回值之前 先进行过滤
    String[] values = super.getParameterValues(XssShieldUtil.stripXss(name));
    if (values != null) {
      for (int i = 0; i < values.length; i++) {
        values[i] = XssShieldUtil.stripXss(values[i]);
      }
    }
    return values;
  }
}
