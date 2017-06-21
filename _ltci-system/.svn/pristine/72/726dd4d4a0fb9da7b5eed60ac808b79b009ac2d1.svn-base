package com.taikang.dic.ltci.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.api.model.RRoleResDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.model.RRoleResDO;
import com.taikang.dic.ltci.service.IRRoleResService;

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

  @Autowired IRRoleResService rRoleResService;

  /**
   * 根据角色id查询所有资源关系列表
   *
   * @param roleId
   * @return
   */
  @RequestMapping(path = "/rRoleRes/{roleId}", method = RequestMethod.GET)
  public ResultDTO listRRoleRes(@PathVariable String roleId) {
    List<RRoleResDO> rRoleResDO = rRoleResService.getRRoleResListByRoleId(roleId);
    ResultDTO resultDTO = new ResultDTO();
    List<RRoleResDTO> rRoleResList = new ArrayList<>();
    for (RRoleResDO roleRes : rRoleResDO) {
      RRoleResDTO rRoleResDTO = new RRoleResDTO();
      BeanUtils.copyProperties(roleRes, rRoleResDTO);
      rRoleResList.add(rRoleResDTO);
    }
    resultDTO.setDatas(rRoleResList);
    resultDTO.setStatus(200);
    resultDTO.setMessage("查询角色资源关系成功");
    return resultDTO;
  }

  /**
   * 修改角色关系列表
   *
   * @param roleId
   * @param resIds
   * @throws Exception
   */
  @RequestMapping(value = "/rRoleRes/{roleId}", method = RequestMethod.PUT)
  public ResultDTO updateRRoleRes(@PathVariable String roleId, @RequestParam String resIds)
      throws Exception {
    logger.debug("_updateRRoleRes___roleId=" + roleId + "__resIds=" + resIds);
    boolean con = rRoleResService.updataRRoleRes(roleId, resIds);
    if (!con) throw new Exception("角色id不存在或关系修改失败");
    ResultDTO resp = new ResultDTO();
    resp.setStatus(200);
    return resp;
  }

  /**
   * 根据角色id查询所有资源关系列表
   *
   * @param roleId
   * @return
   */
  @RequestMapping(path = "/rRoleRes/res/{resId}", method = RequestMethod.GET)
  public List<RRoleResDO> listRRoleResByResId(@PathVariable String resId) {
    return rRoleResService.getRRoleResListByResId(resId);
  }
}
