package com.taikang.dic.ltci.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.ResDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.model.CustomResDO;
import com.taikang.dic.ltci.model.ResDO;
import com.taikang.dic.ltci.service.IResService;

@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class ResController {
  private static final Logger logger = LoggerFactory.getLogger(ResController.class);

  @Autowired IResService resService;

  @RequestMapping(path = "/ress/{parentId}", method = RequestMethod.POST)
  public PageResultDTO listRes(@PathVariable String parentId, int page, int pageSize) {
    logger.debug("_listRes___parentId=" + parentId + "___page=" + page + "___pageSize=" + pageSize);
    Map<String, Object> model = resService.getListResByParentId(parentId, page, pageSize);

    PageResultDTO pageRet = new PageResultDTO();
    pageRet.setPage(page);
    pageRet.setPageSize(pageSize);
    pageRet.setTotalDataNum(Integer.parseInt(model.get("totalDataNum").toString()));
    pageRet.setTotalPageNum(Integer.parseInt(model.get("totalPageNum").toString()));
    @SuppressWarnings("unchecked")
    List<ResDO> resDoList = (List<ResDO>) model.get("resDoList");

    List<ResDO> resDtoList = new ArrayList<ResDO>();
    for (ResDO res : resDoList) {
      ResDO resRet = new ResDO();
      BeanUtils.copyProperties(res, resRet);
      resDtoList.add(resRet);
    }
    // 用户列表
    pageRet.setDatas(resDtoList);
    pageRet.setStatus(200);
    pageRet.setMessage("查询成功");
    return pageRet;
  }

  @RequestMapping(value = "/ress", method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.OK)
  public ResultDTO createRes(@RequestBody ResDTO resDto) throws Exception {
    logger.debug("_create___ResDto=" + resDto);
    ResDO resDO = new ResDO();
    BeanUtils.copyProperties(resDto, resDO);
    boolean con = resService.createRes(resDO);
    if (!con) throw new Exception("添加菜单失败");
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(200);
    resultDTO.setMessage("添加菜单成功");
    return resultDTO;
  }

  @RequestMapping(value = "/ress/{id}", method = RequestMethod.PUT)
  public ResultDTO updateRes(@PathVariable String id, @RequestBody ResDTO resDto) throws Exception {
    logger.debug("_update___oldId=" + id);
    logger.debug("_update___ResDto=" + resDto);
    ResDO resDO = new ResDO();
    BeanUtils.copyProperties(resDto, resDO);
    ResDTO dto = resService.getResById(id);
    if (dto == null) {
      logger.debug("___id" + id + "不存在");
    }
    boolean con = resService.updateResById(id, resDO);
    if (!con) throw new Exception("修改菜单失败");
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(200);
    resultDTO.setMessage("修改菜单成功");
    return resultDTO;
  }

  @RequestMapping(value = "/ress/{id}", method = RequestMethod.DELETE)
  public ResultDTO delRes(@PathVariable String id, @RequestBody ResDTO resDto) throws Exception {
    logger.debug("_del___id=" + id);
    ResDO resDO = new ResDO();
    BeanUtils.copyProperties(resDto, resDO);
    //校验是否有有效子菜单，有则不可删除
    if (resService.IsHasSubRes(id)) {
      logger.debug("_del___存在子菜单，不能删除");
    }
    boolean con = resService.removeById(id, resDO);
    if (!con) throw new Exception("删除菜单失败");
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setStatus(200);
    resultDTO.setMessage("删除菜单成功");
    return resultDTO;
  }

  /**
   * 获取所有有效的资源信息,以及资源对应的角色信息
   *
   * @return
   */
  @RequestMapping(value = "/ress/all", method = RequestMethod.GET)
  public ResultDTO getAllResAndRoles() {
    logger.debug("_get_res_roles");
    ResultDTO result = new ResultDTO();
    List<CustomResDO> resources = resService.getAllResWithRoles();
    List<ResDTO> dtoResult = new ArrayList<>();
    if (resources != null) {
      for (CustomResDO customResDO : resources) {
        ResDTO res = new ResDTO();
        BeanUtils.copyProperties(customResDO, res);
        dtoResult.add(res);
      }
    }
    result.setDatas(dtoResult);
    return result;
  }
}
