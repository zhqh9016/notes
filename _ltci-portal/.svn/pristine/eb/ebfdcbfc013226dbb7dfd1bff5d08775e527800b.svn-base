package com.taikang.dic.ltci.portal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.util.UserUtils;

@Controller
@RequestMapping("/api/v1")
public class LoginController {

  private Logger log = LoggerFactory.getLogger(LoginController.class);

  /**
   * 处理重复登录的处理
   *
   * @param request
   * @param response
   */
  @RequestMapping(path = "/login", method = RequestMethod.POST)
  @ResponseBody
  public void login(HttpServletRequest request, HttpServletResponse response) {
    UserDTO currentUser = UserUtils.getCurrentUser();
    response.setCharacterEncoding("UTF-8");
    try {
      PrintWriter out = response.getWriter();
      if (currentUser != null) {
        out.println("{\"success\":true,\"message\":\"登入成功\"}");
      } else {
        out.println("{\"success\":false,\"message\":\"请通过前台访问\"}");
      }
      out.flush();
      out.close();
    } catch (IOException e) {
      log.error("--重复登录时出现异常--", e);
    }
  }
}
