package com.taikang.dic.ltci.system.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.RoleDTO;

@FeignClient(name = "${feign.system}", url = "${feign.system.url}")
public interface RoleServerClient {

  /**
   * 按条件分页查询角色列表 feignClient
   *
   * @param roleName 角色名
   * @param roleCode 角色编号
   * @param page 当前页码
   * @param pageSize 每页显示件数
   * @return 角色信息列表
   */
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/roles/list")
  PageResultDTO listRole(
      @RequestParam(value = "roleName") String roleName,
      @RequestParam(value = "roleCode") String roleCode,
      @RequestParam(value = "page") int page,
      @RequestParam(value = "pageSize") int pageSize);

  /** 添加角色 */
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/role")
  ResultDTO saveRole(@RequestBody RoleDTO roleDTO);

  /** 删除角色 */
  @RequestMapping(method = RequestMethod.DELETE, value = "/api/v1/role/{id}")
  ResultDTO deleteRole(@PathVariable(value = "id") String id);

  /** 更新角色和用户关系 */
  @RequestMapping(method = RequestMethod.PUT, value = "/api/v1/role/RUserRole")
  ResultDTO updateRUserRole(
      @RequestParam(value = "roleId") String roleId, @RequestParam(value = "userId") String userId);

  /**
   * 查询用户角色
   *
   * @return
   */
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/rUserRole")
  ResultDTO selectRUserRole(@RequestParam(value = "userId") String userId);

  /**
   * 查询用户角色
   *
   * @return
   */
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/role/roleName")
  ResultDTO getRoleName(@RequestParam(value = "roleName") String roleName);

  /**
   * 查询用户所拥有的角色信息
   *
   * @param userId
   * @return
   */
  @RequestMapping(method = RequestMethod.GET, value = "/api/v1/roles/list/{userId}")
  ResultDTO getRolesByUserId(@PathVariable(value = "userId") String userId);
}
