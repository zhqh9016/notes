package com.taikang.dic.ltci.service;

import java.util.List;

import com.taikang.dic.ltci.model.ResDO;

/**
 * 菜单服务接口
 *
 * @author liyh01 E-mail:
 * @version 创建时间：2017年4月8日 上午午10:42
 */
public interface IMenuService {

  /**
   * 获取菜单列表
   *
   * @param userId
   * @return
   */
  List<ResDO> listMenu(String userId, Integer isMenu);

  /** 获取顶级菜单和子菜单列表 */
  List<ResDO> listMenus();
}
