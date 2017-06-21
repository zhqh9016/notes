package com.taikang.dic.ltci.system.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;

@FeignClient(name = "${feign.system}", url = "${feign.system.url}")
public interface UserServerClient {

  /**
   * 按条件分页查询用户列表
   *
   * @param userName 用户名
   * @param departmentid 所属部门
   * @param page 当前页码
   * @param pageSize 每页显示件数
   * @return 用户信息列表
   */
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/users/list")
  PageResultDTO listUser(
      @RequestParam(value = "userName") String userName,
      @RequestParam(value = "departmentid") String departmentid,
      @RequestParam(value = "roleCode") String roleCode,
      @RequestParam(value = "page") int page,
      @RequestParam(value = "pageSize") int pageSize,
      @RequestParam(value = "systemCode") String systemCode);

  /**
   * 新增用户
   *
   * @param userDto
   * @return
   */
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/users")
  ResultDTO createUser(
      @RequestBody UserDTO userDto, @RequestParam(value = "systemCode") String systemCode);

  /**
   * 根据用户名精确查询
   *
   * @param userName 用户名
   * @return
   */
  @RequestMapping(path = "/api/v1/users/{userName}", method = RequestMethod.GET)
  ResultDTO listUser(
      @PathVariable(value = "userName") String userName,
      @RequestParam(value = "systemCode") String systemCode);

  /**
   * 修改用户信息
   *
   * @param userDto
   * @return
   */
  @RequestMapping(method = RequestMethod.PUT, value = "/api/v1/users")
  ResultDTO updateUser(
      @RequestBody UserDTO userDto, @RequestParam(value = "systemCode") String systemCode);

  /**
   * 根据ID查询用户信息
   *
   * @param id 用户编号
   * @return
   */
  @RequestMapping(method = RequestMethod.GET, value = "/api/v1/user/{id}")
  ResultDTO getUser(
      @PathVariable(value = "id") String id, @RequestParam(value = "systemCode") String systemCode);

  /**
   * 删除用户
   *
   * @param id
   * @param operatedBy
   * @return
   */
  @RequestMapping(method = RequestMethod.DELETE, value = "/api/v1/users/{id}")
  ResultDTO deleteUser(
      @PathVariable(value = "id") String id,
      @RequestBody UserDTO userDto,
      @RequestParam(value = "systemCode") String systemCode);

  /**
   * 获取稽核人员列表
   *
   * @param systemCode
   * @return
   */
  @RequestMapping(method = RequestMethod.GET, value = "/api/v1/users/auditor")
  ResultDTO getAuditor(@RequestParam(value = "systemCode") String systemCode);
}
