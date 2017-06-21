package com.taikang.dic.ltci.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.taikang.dic.ltci.model.RRoleResDO;

/**
 * 角色菜单关系service
 *
 * @author itw_huodd
 * @date 2017-04-05
 */
public interface IRRoleResService extends GenericService<RRoleResDO, String> {

  /**
   * 根据角色id获取所有菜单与角色关系
   *
   * @param roleId
   * @return
   */
  public List<RRoleResDO> getRRoleResListByRoleId(String roleId);

  /**
   * 更新角色菜单关系
   *
   * @param roleId
   * @param roleId
   * @return
   */
  public boolean updataRRoleRes(String roleId, String resIds) throws Exception;

  /**
   * 根据权限id获取所有菜单与角色关系
   *
   * @param resId
   * @return
   */
  List<RRoleResDO> getRRoleResListByResId(String resId);
}
