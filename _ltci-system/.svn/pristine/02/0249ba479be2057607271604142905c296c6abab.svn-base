package com.taikang.dic.ltci.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.RUserRoleDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.api.model.RoleDTO;
import com.taikang.dic.ltci.model.RUserRoleDO;
import com.taikang.dic.ltci.model.RoleDO;
import com.taikang.dic.ltci.service.IRUserRoleService;
import com.taikang.dic.ltci.service.IRoleService;
import com.taikang.dic.ltci.service.ServiceException;

/**
 * 角色信息RoleController
 *
 * @author itw_liuzy 2017-03-30
 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class RoleController {
  private Logger logger = LoggerFactory.getLogger(RoleController.class);

  @Autowired IRoleService iRoleService;

  @Autowired IRUserRoleService iRUserRoleService;

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
  public PageResultDTO listRole(
      RoleDTO roleDTO, @RequestParam int page, @RequestParam int pageSize) {
    logger.debug("_listRole___RoleDTO=" + roleDTO + "___page=" + page + "___pageSize=" + pageSize);
    RoleDO roleDO = new RoleDO();
    BeanUtils.copyProperties(roleDTO, roleDO);
    Map<String, Object> model = iRoleService.listRole(roleDO, page, pageSize);

    PageResultDTO pageRet = new PageResultDTO();
    pageRet.setPage(page);
    pageRet.setPageSize(pageSize);
    pageRet.setTotalDataNum(Integer.parseInt(model.get("totalDataNum").toString()));
    pageRet.setTotalPageNum(Integer.parseInt(model.get("totalPageNum").toString()));
    @SuppressWarnings("unchecked")
    List<RoleDO> roleDoList = (List<RoleDO>) model.get("roleDoList");

    List<RoleDTO> roleDtoList = new ArrayList<>();
    for (RoleDO role : roleDoList) {
      RoleDTO roleRet = new RoleDTO();
      BeanUtils.copyProperties(role, roleRet);
      roleDtoList.add(roleRet);
    }
    // 用户列表
    pageRet.setDatas(roleDtoList);
    pageRet.setStatus(200);
    pageRet.setMessage("查询角色信息成功");
    return pageRet;
  }

  /**
   * 新增角色
   *
   * @param roleDto 新增角色信息
   */
  @RequestMapping(path = "/role", method = RequestMethod.POST)
  public ResultDTO saveRole(@RequestBody RoleDTO roleDTO) {
    logger.debug("_saveRole___RoleDTO=" + roleDTO);
    ResultDTO resultDTO = new ResultDTO();
    try {
      RoleDO roleDO = new RoleDO();
      BeanUtils.copyProperties(roleDTO, roleDO);
      iRoleService.saveRole(roleDO);
      resultDTO.setStatus(200);
      resultDTO.setMessage("添加角色成功");
    } catch (ServiceException e) {
      resultDTO.setStatus(e.getErrorCode());
      resultDTO.setMessage(e.getMessage());
      logger.error("_saveRole_", e);
      return resultDTO;
    }
    return resultDTO;
  }

  /**
   * 删除角色
   *
   * @param id
   */
  @RequestMapping(path = "/role/{id}", method = RequestMethod.DELETE)
  public ResultDTO deleteRole(@PathVariable String id) {
    logger.debug("_deleteRole___id=" + id);
    ResultDTO resultDTO = new ResultDTO();
    try {
      iRoleService.deleteRole(id);
      resultDTO.setStatus(200);
      resultDTO.setMessage("删除角色成功");
    } catch (ServiceException e) {
      resultDTO.setStatus(e.getErrorCode());
      resultDTO.setMessage(e.getMessage());
      logger.error("_deleteRole_", e);
      return resultDTO;
    }
    return resultDTO;
  }

  /**
   * 更新角色用户关系
   *
   * @param roleId
   * @param userId
   */
  @RequestMapping(path = "/role/RUserRole", method = RequestMethod.PUT)
  public ResultDTO updataUserRole(@RequestParam String roleId, @RequestParam String userId) {
    logger.debug("_updataUserRole___roleId=" + roleId + "__userId=" + userId);
    ResultDTO resultDTO = new ResultDTO();
    try {
      iRUserRoleService.updataRUserRole(roleId, userId);
      resultDTO.setStatus(200);
      resultDTO.setMessage("更新用户角色关系成功");
    } catch (ServiceException e) {
      resultDTO.setStatus(e.getErrorCode());
      resultDTO.setMessage(e.getMessage());
      logger.error("_updataRUserRole_", e);
      return resultDTO;
    }
    return resultDTO;
  }

  /**
   * 查询用户所用角色
   *
   * @param userId
   * @return 角色信息列表
   */
  @RequestMapping(path = "/rUserRole", method = RequestMethod.POST)
  @ResponseBody
  public ResultDTO selectRUserRole(@RequestParam String userId) {
    List<RUserRoleDO> rUserRoleDO = iRUserRoleService.selectRUserRole(userId);
    ResultDTO resultDTO = new ResultDTO();
    List<RUserRoleDTO> rUserRoleList = new ArrayList<>();
    for (RUserRoleDO userRole : rUserRoleDO) {
      RUserRoleDTO rUserRoleDTO = new RUserRoleDTO();
      BeanUtils.copyProperties(userRole, rUserRoleDTO);
      rUserRoleList.add(rUserRoleDTO);
    }
    resultDTO.setDatas(rUserRoleList);
    resultDTO.setStatus(200);
    resultDTO.setMessage("查询用户角色成功");
    return resultDTO;
  }

  /**
   * 查询角色名称是否重复
   *
   * @param roleName
   */
  @RequestMapping(path = "/role/roleName", method = RequestMethod.POST)
  public ResultDTO getRoleName(@RequestParam String roleName) {
    logger.debug("_updataUserRole___roleName=" + roleName);
    List<RoleDO> roleDO = iRoleService.getRoleName(roleName);
    ResultDTO resultDTO = new ResultDTO();
    List<RoleDTO> roleList = new ArrayList<>();
    for (RoleDO role : roleDO) {
      RoleDTO roleDTO = new RoleDTO();
      BeanUtils.copyProperties(role, roleDTO);
      roleList.add(roleDTO);
    }
    if (!roleList.isEmpty()) {
      resultDTO.setStatus(0);
      resultDTO.setMessage("角色名称已经存在,不可使用");
    } else {
      resultDTO.setStatus(1);
      resultDTO.setMessage("角色名称不存在,可以使用");
    }
    return resultDTO;
  }

  /**
   * 查询用户所拥有的角色信息
   *
   * @param userId 用户编号
   * @return 角色信息列表
   */
  @RequestMapping(path = "/roles/list/{userId}", method = RequestMethod.GET)
  public ResultDTO getRolesByUserId(@PathVariable String userId) {
    ResultDTO resultDto = new ResultDTO();
    resultDto.setStatus(200);
    List<RoleDO> roleList = iRoleService.getRolesByUserId(userId);
    List<RoleDTO> roleDtoList = new ArrayList<>();
    for (RoleDO role : roleList) {
      RoleDTO roleRet = new RoleDTO();
      BeanUtils.copyProperties(role, roleRet);
      roleDtoList.add(roleRet);
    }
    resultDto.setDatas(roleDtoList);
    return resultDto;
  }
}
