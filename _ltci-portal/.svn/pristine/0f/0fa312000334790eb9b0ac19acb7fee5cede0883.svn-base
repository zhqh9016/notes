package com.taikang.dic.ltci.portal.service;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import feign.Param;

/** fegin客户端，请求服务名称是spring-server的服务 */
@FeignClient(name = "ltci-system", url = "http://127.0.0.1:8080")
public interface SpringServerClient {
  //  /** 具体参数传递需要加@RequestParam */
  //  @RequestMapping(path = "/users/{page}/{pageSize}", method = RequestMethod.GET)
  //  public String listUser(
  //      @RequestParam String userName,
  //      @RequestParam String departmentid,
  //      @PathVariable int page,
  //      @PathVariable int pageSize);
  //  /** 传递对象需要加@requestBody */
  //  @RequestMapping(path = "/api/v1/users/{page}/{pageSize}", method = RequestMethod.POST)
  //  public String listUserWithBody(
  //      @RequestBody UserDTO user,
  //      @PathVariable("page") int page,
  //      @PathVariable("pageSize") int pageSize);
  //
  //  /** 传递map示例 */
  //  @RequestMapping(path = "/api/v1/users/{page}/{pageSize}", method = RequestMethod.POST)
  //  public String listUserWithMap(
  //      Map<String, String> map,
  //      @PathVariable("page") int page,
  //      @PathVariable("pageSize") int pageSize);
}
