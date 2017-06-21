package com.taikang.dic.ltci.system.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.RoleDTO;
import com.taikang.dic.ltci.system.serverClient.RoleServerClient;
import com.taikang.dic.ltci.system.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
  private Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
  @Autowired private RoleServerClient roleServerClient;

  /**
   * 按条件查询角色信息列表
   *
   * @param
   * @return 角色信息列表
   */
  @Override
  public PageResultDTO listRole(RoleDTO roleDTO, int page, int pageSize) {
    return roleServerClient.listRole(roleDTO.getRoleName(), roleDTO.getRoleCode(), page, pageSize);
  }

  /**
   * 添加角色
   *
   * @param
   * @return
   */
  @Override
  public ResultDTO saveRole(RoleDTO roleDTO) {
    logger.debug("=========service roleDTO[" + roleDTO.toString() + "]=============");
    return roleServerClient.saveRole(roleDTO);
  }
  /**
   * 删除角色
   *
   * @param
   * @return
   */
  @Override
  public ResultDTO deleteRole(String id) {
    return roleServerClient.deleteRole(id);
  }
  /**
   * 更新角色和用户关系
   *
   * @param
   * @return
   */
  @Override
  public ResultDTO updateRUserRole(String roleId, String userId) {
    return roleServerClient.updateRUserRole(roleId, userId);
  }

  /**
   * 查询用户角色
   *
   * @param
   * @return
   */
  @Override
  public ResultDTO selectRUserRole(String userId) {
    return roleServerClient.selectRUserRole(userId);
  }

  /** 查询角色名称是否重复 */
  @Override
  public ResultDTO getRoleName(String roleName) {
    return roleServerClient.getRoleName(roleName);
  }

  /** 查询用户所拥有的角色信息 */
  @Override
  public ResultDTO getRolesByUserId(String userId) {
    return roleServerClient.getRolesByUserId(userId);
  }
}
