package com.taikang.dic.ltci.system.serverClient;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.RRoleResDTO;
import com.taikang.dic.ltci.portal.api.model.Response;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;

@FeignClient(name = "${feign.system}", url = "${feign.system.url}")
public interface RRoleResServerClient {

  /**
   * 查询角色资源列表
   *
   * @param userName 用户名
   * @param departmentid 所属部门
   * @return 用户信息列表
   */
  @RequestMapping(method = RequestMethod.GET, value = "/api/v1/rRoleRes/{roleId}")
  ResultDTO listRRoleRes(@RequestParam(value = "roleId") String roleId);

  /** 更新角色和用户关系 */
  @RequestMapping(method = RequestMethod.PUT, value = "/api/v1/rRoleRes/{roleId}")
  ResultDTO updateRRoleRes(
      @RequestParam(value = "roleId") String roleId, @RequestParam(value = "resIds") String resIds);
  /**
   * 根据角色id查询所有资源关系列表
   *
   * @param roleId
   * @return
   */
  @RequestMapping(path = "/rRoleRes/res/{resId}", method = RequestMethod.GET)
  public List<RRoleResDTO> listRRoleResByResId(@PathVariable("resId") String resId);
}
