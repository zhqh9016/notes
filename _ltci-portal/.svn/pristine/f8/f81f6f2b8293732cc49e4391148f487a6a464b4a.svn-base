package com.taikang.dic.ltci.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.util.UserUtils;
import com.taikang.dic.ltci.system.service.ResService;

/**
 * 资源服务控制器
 *
 * @author itw_huodd 2017-04-01
 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class ResController {
  private static final Logger logger = LoggerFactory.getLogger(ResController.class);

  @Autowired ResService resService;

  @RequestMapping(path = "/ress/{parentId}", method = RequestMethod.GET)
  public PageResultDTO listRes(@PathVariable String parentId, String id, int page, int pageSize) {
    logger.debug(
        "_listRes___parentId="
            + parentId
            + "___id="
            + id
            + "___page="
            + page
            + "___pageSize="
            + pageSize);
    if (id != null && !"".equals(id)) {
      parentId = id;
    }
    return resService.listRes(parentId, page, pageSize);
  }

  @RequestMapping(value = "/ress", method = RequestMethod.POST)
  @ResponseStatus(HttpStatus.OK)
  public ResultDTO createRes(ResDTO resDto) {
    logger.debug("_create___ResDto=" + resDto);
    UserDTO user = UserUtils.getCurrentUser();
    logger.debug("___session user=" + user);
    resDto.setCreateBy(user.getTrueName());
    return resService.createRes(resDto);
  }

  @RequestMapping(value = "/ress/{id}", method = RequestMethod.PUT)
  @ResponseStatus(HttpStatus.OK)
  public ResultDTO updateRes(@PathVariable String id, ResDTO resDto) throws Exception {
    logger.debug("_updateRes___oldId=" + id + "___ResDto=" + resDto);
    UserDTO user = UserUtils.getCurrentUser();
    logger.debug("___session user=" + user);
    resDto.setUpdateBy(user.getTrueName());
    return resService.updateRes(id, resDto);
  }

  @RequestMapping(value = "/ress/{id}", method = RequestMethod.DELETE)
  public ResultDTO delRes(@PathVariable String id, ResDTO resDto) {
    logger.debug("_delRes___id=" + id + "___ResDto=" + resDto);
    return resService.delRes(id, resDto);
  }
}
