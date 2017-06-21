package com.taikang.dic.ltci.system.service;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.RoleDTO;

public interface RoleService {

  /**
   * 按条件查询角色信息列表
   *
   * @param
   * @return 角色信息列表
   */
  public PageResultDTO listRole(RoleDTO roleDTO, int page, int pageSize);

  /**
   * 添加角色
   *
   * @param
   * @return
   */
  ResultDTO saveRole(RoleDTO roleDTO);

  /**
   * 删除角色
   *
   * @param
   * @return
   */
  ResultDTO deleteRole(String id);

  /**
   * 更新角色用户关系
   *
   * @param
   * @return
   */
  ResultDTO updateRUserRole(String roleId, String userId);

  /**
   * 查询用户角色
   *
   * @param
   * @return
   */
  ResultDTO selectRUserRole(String userId);

  /** 查询角色名称是否重复 */
  ResultDTO getRoleName(String roleName);

  /**
   * 查询用户所拥有的角色信息
   *
   * @param userId
   * @return
   */
  ResultDTO getRolesByUserId(String userId);
}
