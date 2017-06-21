package com.taikang.dic.ltci.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.portal.common.util.UserUtils;
import com.taikang.dic.ltci.system.service.UserService;

/**
 * 系统管理-用户管理
 *
 * @author itw_liyh01 2017-04-01
 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class UserController {

  @Autowired private UserService userService;

  /**
   * 按条件分页查询用户列表
   *
   * @param userDto 查询条件
   * @param page 当前页码
   * @param pageSize 每页显示件数
   * @return 用户信息列表
   */
  @RequestMapping(path = "/users/list", method = RequestMethod.POST)
  @ResponseBody
  public PageResultDTO listUser(UserDTO userDto, String roleCode, int page, int pageSize) {
    return userService.listUser(userDto, roleCode, page, pageSize);
  }

  /**
   * 根据用户名精确查询
   *
   * @param userName 用户名
   * @return
   */
  @RequestMapping(path = "/users/{userName}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO listUser(@PathVariable String userName) {
    return userService.listUser(userName);
  }

  /**
   * 新增用户
   *
   * @param userDto 用户信息
   * @return
   */
  @RequestMapping(path = "/users", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO createUser(UserDTO userDto) {
    //	UserDTO userDTO = UserUtils.getCurrentUser();
    //	String createdBy = userDTO.getUserName();
    //	userDTO.setCreatedBy(createdBy);
    return userService.createUser(userDto);
  }

  /**
   * 修改用户信息
   *
   * @param userDto
   * @return
   */
  @RequestMapping(path = "/users", method = RequestMethod.PUT)
  @ResponseBody
  public ResultDTO updateUser(UserDTO userDto) {
    return userService.updateUser(userDto);
  }

  /**
   * 根据ID查询用户信息
   *
   * @param id 用户编号
   * @return
   */
  @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO getUser(@PathVariable String id) {
    return userService.getUser(id);
  }

  /**
   * 重置密码
   *
   * @param userDto
   * @return
   */
  @RequestMapping(path = "/users/password", method = RequestMethod.PUT)
  @ResponseBody
  public ResultDTO resetPassword(UserDTO userDto) {
    return userService.resetPassword(userDto);
  }

  /**
   * 删除用户-中间服务
   *
   * @param id 用户编号
   * @param operatedBy 经办人
   * @return
   */
  @RequestMapping(path = "/users/{id}", method = RequestMethod.DELETE)
  @ResponseBody
  public ResultDTO deleteUser(@PathVariable String id) {
    return userService.deleteUser(id);
  }

  /**
   * 用户修改登录密码
   *
   * @param userDto
   * @return
   */
  @RequestMapping(path = "/users/person/password", method = RequestMethod.PUT)
  @ResponseBody
  public ResultDTO amendPassword(String oldPassword, String newPassword) {
    return userService.amendPassword(oldPassword, newPassword);
  }

  /**
   * 从session中获取用户信息
   *
   * @return
   */
  @RequestMapping(path = "/session/users", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO getUserBySession() {
    ResultDTO result = new ResultDTO();
    UserDTO userDTO = UserUtils.getCurrentUser();
    if (userDTO != null) {
      result.setStatus(StatusCodeEnum.OK.getValue());
      result.setDatas(userDTO);
    } else {
      result.setStatus(StatusCodeEnum.NOT_FOUND.getValue());
    }
    return result;
  }

  /**
   * 获取稽核人员列表
   *
   * @return
   */
  @RequestMapping(path = "/users/auditor", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO getAuditor() {
    return userService.getAuditor();
  }
}
