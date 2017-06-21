package com.taikang.dic.ltci.system.service;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;

public interface UserService {

  /**
   * 按条件分页查询用户列表
   *
   * @param userDto 查询条件
   * @param page 当前页码
   * @param pageSize 每页显示件数
   * @return 用户信息列表
   */
  PageResultDTO listUser(UserDTO userDto, String roleCode, int page, int pageSize);

  /**
   * 新增用户
   *
   * @param userDto
   * @return
   */
  ResultDTO createUser(UserDTO userDto);

  /**
   * 根据用户名精确查询
   *
   * @param userName
   * @return
   */
  ResultDTO listUser(String userName);

  /**
   * 修改用户信息
   *
   * @param userDto
   * @return
   */
  ResultDTO updateUser(UserDTO userDto);

  /**
   * 根据ID查询用户信息
   *
   * @param id
   * @return
   */
  ResultDTO getUser(String id);

  /**
   * 重置密码
   *
   * @param userDto
   * @return
   */
  ResultDTO resetPassword(UserDTO userDto);

  /**
   * 删除用户
   *
   * @param id
   * @param operatedBy
   * @return
   */
  ResultDTO deleteUser(String id);

  /**
   * 用户修改登录密码
   *
   * @param userDto
   * @return
   */
  ResultDTO amendPassword(String oldPassword, String newPassword);

  /**
   * 获取稽核人员列表
   *
   * @return
   */
  ResultDTO getAuditor();
}
