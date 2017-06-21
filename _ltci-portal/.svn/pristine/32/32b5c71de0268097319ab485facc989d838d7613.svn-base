package com.taikang.dic.ltci.system.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

/**
 * 资源微服务调用工具类
 *
 * @author itw_huodd 2017-04-01
 */
@FeignClient(name = "${feign.system}", url = "${feign.system.url}")
public interface ResServerClient {

  @RequestMapping(path = "/api/v1/ress/{parentId}", method = RequestMethod.POST)
  public PageResultDTO listRes(
      @PathVariable("parentId") String parentId,
      @RequestParam(value = "page") int page,
      @RequestParam(value = "pageSize") int pageSize);

  @RequestMapping(value = "/api/v1/ress", method = RequestMethod.POST)
  public ResultDTO createRes(@RequestBody ResDTO resDto);

  @RequestMapping(value = "/api/v1/ress/{id}", method = RequestMethod.PUT)
  public ResultDTO updateRes(@PathVariable("id") String id, ResDTO resDto);

  @RequestMapping(value = "/api/v1/ress/{id}", method = RequestMethod.DELETE)
  public ResultDTO delRes(@PathVariable("id") String id, ResDTO resDto);

  @RequestMapping(value = "/api/v1/ress/all", method = RequestMethod.GET)
  public ResultDTO getAllResAndRoles();
}
