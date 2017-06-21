package com.taikang.dic.ltci.system.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.portal.api.model.RRoleResDTO;
import com.taikang.dic.ltci.portal.api.model.Response;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.system.service.RRoleResService;

/**
 * 角色资源关系列表
 *
 * @author itw_huodd
 * @date 2017-04-05
 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class RRoleResController {
  private static final Logger logger = LoggerFactory.getLogger(RRoleResController.class);

  @Autowired RRoleResService rRoleResService;

  /**
   * 根据角色id查询所有资源关系列表
   *
   * @param roleId
   * @return
   */
  @RequestMapping(path = "/rRoleRes/{roleId}", method = RequestMethod.GET)
  public ResultDTO listRRoleRes(@PathVariable String roleId) {
    logger.debug("_listRRoleRes___roleId=" + roleId);
    return rRoleResService.listRRoleRes(roleId);
  }

  /**
   * 修改角色关系列表
   *
   * @param roleId
   * @param resIds
   */
  @RequestMapping(value = "/rRoleRes/{roleId}", method = RequestMethod.PUT)
  public ResultDTO updateRRoleRes(@PathVariable String roleId, @RequestParam String resIds) {
    logger.debug("_updateRRoleRes___roleId=" + roleId + "__resIds=" + resIds);
    return rRoleResService.updataRRoleRes(roleId, resIds);
  }
}
