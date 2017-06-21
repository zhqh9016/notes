package com.taikang.dic.ltci.system.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.ResultDTO;

@FeignClient(name = "${feign.system}", url = "${feign.system.url}")
public interface MenuServerClient {

  /**
   * 查询用户所拥有菜单
   *
   * @param userId
   * @param systemCode
   * @return
   */
  @RequestMapping(path = "/api/v1/menu/list/{userId}", method = RequestMethod.GET)
  ResultDTO listMenu(
      @PathVariable(value = "userId") String userId,
      @RequestParam(value = "isMenu") Integer isMenu,
      @RequestParam(value = "systemCode") String systemCode);

  @RequestMapping(path = "/api/v1/menu/list", method = RequestMethod.GET)
  ResultDTO listMenus();

  @RequestMapping(path = "/api/v1/menu/list/portal/{userId}", method = RequestMethod.GET)
  public ResultDTO listMenuForPortal(@PathVariable(value = "userId") String userId);
}
