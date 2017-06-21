package com.taikang.dic.ltci.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.taikang.dic.ltci.portal.api.model.MenuDTO;
import com.taikang.dic.ltci.portal.api.model.ResDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.system.serverClient.MenuServerClient;
import com.taikang.dic.ltci.system.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
  private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);

  @Value(value = "${spring.application.name}")
  private String systemCode;

  @Autowired private MenuServerClient menuServerClient;

  private List<ResDTO> menus;

  /** 查询用户所拥有菜单 */
  @Override
  public ResultDTO listMenu(String userId, Integer isMenu) {
    logger.debug("____listMenu__userId=" + userId + "__isMenu=" + isMenu);
    ResultDTO menuRet = new ResultDTO();
    ResultDTO resultDto = menuServerClient.listMenu(userId, isMenu, systemCode);
    logger.debug("____resultDto=" + com.alibaba.fastjson.JSON.toJSONString(resultDto));

    menuRet.setStatus(resultDto.getStatus());
    menuRet.setMessage(resultDto.getMessage());
    if (resultDto.getDatas() == null) return menuRet;

    menus = JSONArray.parseArray(resultDto.getDatas().toString(), ResDTO.class);
    if (menus != null && !menus.isEmpty()) {
      List<MenuDTO> menuList = new ArrayList<>();
      for (ResDTO resDto : menus) {
        MenuDTO menuDto = new MenuDTO();
        if ("0".equals(resDto.getParentId())) {
          BeanUtils.copyProperties(resDto, menuDto);
          List<MenuDTO> menuChild = getChildren(resDto);
          menuDto.setChildMenu(menuChild);
          menuList.add(menuDto);
        }
      }
      menuRet.setDatas(menuList);
    }
    logger.debug("____menuRet=" + com.alibaba.fastjson.JSON.toJSONString(menuRet));
    return menuRet;
  }

  private List<MenuDTO> getChildren(ResDTO resDto) {
    List<MenuDTO> children = new ArrayList<>();
    String id = resDto.getId();
    for (ResDTO res : menus) {
      if (id.equals(res.getParentId())) {
        MenuDTO menu = new MenuDTO();
        BeanUtils.copyProperties(res, menu);
        List<MenuDTO> sourceMenu = getChildren(res);
        if (sourceMenu != null && !sourceMenu.isEmpty()) {
          menu.setChildMenu(sourceMenu);
        }
        children.add(menu);
      }
    }
    return children;
  }

  /** 查询所有菜单 */
  @Override
  public ResultDTO listMenus() {
    ResultDTO menuRet = new ResultDTO();
    ResultDTO resultDto = menuServerClient.listMenus();

    menuRet.setStatus(resultDto.getStatus());
    menuRet.setMessage(resultDto.getMessage());
    if (resultDto.getDatas() == null) return menuRet;

    menus = JSONArray.parseArray(resultDto.getDatas().toString(), ResDTO.class);
    if (menus != null && !menus.isEmpty()) {
      List<MenuDTO> menuList = new ArrayList<>();
      for (ResDTO resDto : menus) {
        MenuDTO menuDto = new MenuDTO();
        if ("0".equals(resDto.getParentId())) {
          BeanUtils.copyProperties(resDto, menuDto);
          List<MenuDTO> menuChild = getChildren(resDto);
          menuDto.setChildMenu(menuChild);
          menuList.add(menuDto);
        }
      }
      menuRet.setDatas(menuList);
    }
    return menuRet;
  }

  @Override
  public ResultDTO listMenuForPortal(String userId) {
    return menuServerClient.listMenuForPortal(userId);
  }
}
