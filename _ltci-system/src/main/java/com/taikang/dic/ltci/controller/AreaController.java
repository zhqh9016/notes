package com.taikang.dic.ltci.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.api.model.OrganizationDTO;
import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.service.IAreaService;
import com.taikang.dic.ltci.service.IOrganizationService;
/**
 * 区域管理
 *
 * @author itw_muwg
 */
@RestController
@RequestMapping(path = "${restBasePath}", produces = "application/json;charset=utf-8")
public class AreaController {
  private Logger logger = LoggerFactory.getLogger(AreaController.class);

  @Autowired private IAreaService areaService;

  /** 根据区域父id查询 */
  @RequestMapping(value = "/area/getByParentid", method = RequestMethod.GET)
  public PageResultDTO getByParentid(
      @RequestParam("parentid") String parentid, Integer page, Integer pageSize) {
    PageResultDTO resultDTO = areaService.getByParentid(parentid, page, pageSize);
    resultDTO.setStatus(HttpStatus.OK.value());
    resultDTO.setMessage("查询成功");
    logger.debug(
        "===AreaController getByParentid方法返回PageResultDTO【"
            + resultDTO.toString()
            + "】===========");
    return resultDTO;
  }
  /** 根据组织编码精确查询 */
  @RequestMapping(value = "/area/{id}", method = RequestMethod.GET)
  public ResultDTO getById(@PathVariable("id") String id) {
    ResultDTO resultDTO = areaService.getById(id);
    resultDTO.setStatus(HttpStatus.OK.value());
    resultDTO.setMessage("查询成功");
    logger.debug("===AreaController getById方法返回resultDTO【" + resultDTO.toString() + "】===========");
    return resultDTO;
  }
}
