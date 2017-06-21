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

import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.enumeration.StatusCodeEnum;
import com.taikang.dic.ltci.portal.common.util.UserUtils;
import com.taikang.dic.ltci.system.service.MenuService;

@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class MenuController {
  private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

  @Autowired private MenuService menuService;

  /**
   * 查询用户所拥有菜单
   *
   * @param userId
   * @return
   */
  @RequestMapping(path = "/menu/list/{userId}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO listMenu(@PathVariable String userId, @RequestParam Integer isMenu) {
    logger.debug("__listMenu______userId=" + userId + "___isMenu=" + isMenu);
    UserDTO user = UserUtils.getCurrentUser();
    //logger.debug("___session user=" + user);
    ResultDTO result = new ResultDTO();
    result.setStatus(StatusCodeEnum.OK.getValue());
    result.setDatas(user.getMenu());
    //    return menuService.listMenu(user.getId(), isMenu);
    return result;
  }

  /**
   * 查询所有菜单
   *
   * @return
   */
  @RequestMapping(path = "/menu/list", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO listMenus() {
    return menuService.listMenus();
  }

  /**
   * 查询用户可访问的所有html地址
   *
   * @return
   */
  @RequestMapping(path = "/menu/list/portal", method = RequestMethod.GET)
  public ResultDTO listMenuForPortal() {
    UserDTO userDTO = UserUtils.getCurrentUser();
    String userId = userDTO.getId();
    return menuService.listMenuForPortal(userId);
  }
}
