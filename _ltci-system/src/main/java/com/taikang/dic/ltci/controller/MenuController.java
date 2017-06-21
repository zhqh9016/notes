package com.taikang.dic.ltci.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.taikang.dic.ltci.api.model.ResDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.model.ResDO;
import com.taikang.dic.ltci.service.IMenuService;
import com.taikang.dic.ltci.service.IResService;

/**
 * 菜单信息管理
 *
 * @author liyh01 E-mail:
 * @version 创建时间：2017年4月8日 上午午10:42
 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class MenuController {

  @Autowired private IMenuService menuService;
  @Autowired private IResService resService;

  @RequestMapping(path = "/menu/list/portal/{userId}", method = RequestMethod.GET)
  public ResultDTO listMenuForPortal(@PathVariable String userId) {
    List<ResDTO> resByUserId = resService.getResByUserId(userId);
    ResultDTO result = new ResultDTO();
    if (!CollectionUtils.isEmpty(resByUserId)) {
      result.setDatas(resByUserId);
    }
    result.setStatus(200);
    result.setMessage("查询用户所拥有菜单成功");
    return result;
  }

  /**
   * 查询用户所拥有菜单
   *
   * @param userId
   * @return
   */
  @RequestMapping(path = "/menu/list/{userId}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO listMenu(@PathVariable String userId, @RequestParam Integer isMenu) {
    List<ResDO> resDoList = menuService.listMenu(userId, isMenu);
    List<ResDTO> resDtoList = new ArrayList<>();
    ResultDTO result = new ResultDTO();
    if (resDoList != null && !resDoList.isEmpty()) {
      for (ResDO resDo : resDoList) {
        ResDTO resDto = new ResDTO();
        BeanUtils.copyProperties(resDo, resDto);
        resDtoList.add(resDto);
      }
      result.setDatas(JSONArray.toJSONString(resDtoList));
    }
    result.setStatus(200);
    result.setMessage("查询用户所拥有菜单成功");
    return result;
  }

  /** 获取顶级菜单和子菜单列表 */
  @RequestMapping(path = "/menu/list", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO listMenus() {
    List<ResDO> resDoList = menuService.listMenus();
    List<ResDTO> resDtoList = new ArrayList<>();
    ResultDTO result = new ResultDTO();
    if (resDoList != null && !resDoList.isEmpty()) {
      for (ResDO resDo : resDoList) {
        ResDTO resDto = new ResDTO();
        BeanUtils.copyProperties(resDo, resDto);
        resDtoList.add(resDto);
      }
    }
    result.setDatas(resDtoList);
    result.setStatus(200);
    result.setMessage("查询菜单成功");
    return result;
  }
}
