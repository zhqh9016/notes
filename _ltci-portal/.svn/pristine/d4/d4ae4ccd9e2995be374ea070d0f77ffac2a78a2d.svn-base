package com.taikang.dic.ltci.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.RoleDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.util.UserUtils;
import com.taikang.dic.ltci.system.service.RoleService;

/**
 * 角色信息RoleController
 *
 * @author itw_liuzy 2017-03-30
 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class RoleController {
  private Logger logger = LoggerFactory.getLogger(RoleController.class);

  @Autowired private RoleService roleService;
  /**
   * 按条件分页查询角色列表
   *
   * @param roleDTO 查询条件
   * @param page 当前页码
   * @param pageSize 每页显示件数
   * @return 角色信息列表
   */
  @RequestMapping(path = "/roles/list", method = RequestMethod.POST)
  @ResponseBody
  public PageResultDTO listRole(RoleDTO roleDTO, int page, int pageSize) {
    logger.debug("_listRole___RoleDTO=" + roleDTO + "___page=" + page + "___pageSize=" + pageSize);
    return roleService.listRole(roleDTO, page, pageSize);
  }

  /**
   * 新增角色
   *
   * @param RoleDto 新增角色信息
   */
  @RequestMapping(path = "/role", method = RequestMethod.POST)
  public ResultDTO addRole(RoleDTO roleDTO) {
    logger.debug("_saveRole___RoleDTO=" + roleDTO);
    UserDTO user = UserUtils.getCurrentUser();
    logger.debug("___session user=" + user);
    roleDTO.setCreateBy(user.getTrueName());
    return roleService.saveRole(roleDTO);
  }

  /**
   * 删除角色
   *
   * @param roleDto 删除角色信息
   */
  @RequestMapping(path = "/role/{id}", method = RequestMethod.DELETE)
  public ResultDTO deleteRole(@PathVariable String id) {
    logger.debug("_deleteRole___id=" + id);
    return roleService.deleteRole(id);
  }

  /**
   * 更新角色用户关系
   *
   * @param roleDto 更新角色信息
   */
  @RequestMapping(path = "/role/RUserRole", method = RequestMethod.PUT)
  public ResultDTO updateRUserRole(@RequestParam String roleId, @RequestParam String userId) {
    logger.debug("_updateRUserRole___roleId=" + roleId + "___userId=" + userId);
    return roleService.updateRUserRole(roleId, userId);
  }

  /**
   * 查询用户角色
   *
   * @param userId 用户ID
   * @return 角色信息列表
   */
  @RequestMapping(path = "/rUserRole", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO selectRUserRole(@RequestParam String userId) {
    logger.debug("_selectRUserRole___userId=" + userId);
    return roleService.selectRUserRole(userId);
  }

  /**
   * 查询角色名称是否重复
   *
   * @param roleName
   */
  @RequestMapping(path = "/role/roleName", method = RequestMethod.POST)
  public ResultDTO getRoleName(@RequestParam String roleName) {
    logger.debug("_updataUserRole___roleName=" + roleName);
    return roleService.getRoleName(roleName);
  }
}
