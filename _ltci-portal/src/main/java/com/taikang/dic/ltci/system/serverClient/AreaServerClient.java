package com.taikang.dic.ltci.system.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
/**
 * 机构微服务调用工具
 *
 * @author itw_muwg
 */
@FeignClient(name = "${feign.system}", url = "${feign.system.url}")
public interface AreaServerClient {

  /** 根据上级区域id查询 */
  @RequestMapping(value = "/api/v1/area/getByParentid", method = RequestMethod.GET)
  PageResultDTO getByParentId(
      @RequestParam("parentid") String parentid,
      @RequestParam("page") Integer page,
      @RequestParam("pageSize") Integer pageSize,
      @RequestParam(value = "systemCode") String systemCode);
  /**
   * 根据区域ID精确查询
   *
   * @param id 机构ID
   * @return
   */
  @RequestMapping(value = "/api/v1/area/{id}", method = RequestMethod.GET)
  ResultDTO getById(
      @PathVariable("id") String id, @RequestParam(value = "systemCode") String systemCode);
}
