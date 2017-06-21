package com.taikang.dic.ltci.settlement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.ServiceItemDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.util.UserUtils;
import com.taikang.dic.ltci.settlement.service.ServiceItemService;

/**
 * 护理目录Controller
 *
 * @author itw_liuzy 2017-04-17
 */
@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class ServiceItemController {
  private Logger logger = LoggerFactory.getLogger(ServiceItemController.class);

  @Autowired ServiceItemService serviceItemService;

  /**
   * 按条件分页查询护理目录列表
   *
   * @param ItemDTO 查询条件
   * @param page 当前页码
   * @param pageSize 每页显示件数
   * @return 护理目录查询信息列表
   */
  @RequestMapping(path = "/serviceItem/list", method = RequestMethod.POST)
  @ResponseBody
  public PageResultDTO listItem(
      String serviceCode,
      String serviceName,
      String serviceType,
      String chargeType,
      String chargeLevel,
      String isValid,
      int page,
      int pageSize) {
    logger.debug("_listItem___serviceName=" + serviceName + page + "___pageSize=" + pageSize);
    return serviceItemService.listItem(
        serviceCode, serviceName, serviceType, chargeType, chargeLevel, isValid, page, pageSize);
  }

  /**
   * 添加护理目录
   *
   * @param itemDTO
   * @return
   */
  @RequestMapping(path = "/serviceItem", method = RequestMethod.POST)
  public ResultDTO saveItem(ServiceItemDTO itemDTO) {
    logger.debug("_saveItem___itemDTO=" + itemDTO);
    UserDTO user = UserUtils.getCurrentUser();
    logger.debug("___session user=" + user);
    itemDTO.setCreatedBy(user.getTrueName());
    itemDTO.setOperatedBy(user.getTrueName());
    return serviceItemService.saveItem(itemDTO);
  }

  /**
   * 删除护理目录
   *
   * @param id
   * @return
   */
  @RequestMapping(path = "/item/{id}", method = RequestMethod.DELETE)
  public ResultDTO deleteItem(@PathVariable String id) {
    logger.debug("_deleteItem___id=" + id);
    return serviceItemService.deleteItem(id);
  }

  /**
   * 编辑护理目录
   *
   * @param itemDTO
   * @return
   */
  @RequestMapping(path = "/service/item", method = RequestMethod.PUT)
  @ResponseBody
  public ResultDTO updateItem(ServiceItemDTO itemDTO) {
    logger.debug("_updateItem___itemDTO=" + itemDTO);
    UserDTO user = UserUtils.getCurrentUser();
    logger.debug("___session user=" + user);
    itemDTO.setOperatedBy(user.getTrueName());
    return serviceItemService.updateItem(itemDTO);
  }

  /**
   * 根据护理目录ID查询护理目录信息
   *
   * @param id
   * @return 服务目录信息
   */
  @RequestMapping(path = "/items/{id}", method = RequestMethod.GET)
  @ResponseBody
  public ResultDTO getItem(@PathVariable String id) {
    logger.debug("_getItem___id=" + id);
    return serviceItemService.getItem(id);
  }

  /**
   * 查询服务项目名称是否存在
   *
   * @param serviceName
   */
  @RequestMapping(path = "/service/item/name", method = RequestMethod.POST)
  public ResultDTO getServiceName(@RequestParam String serviceName) {
    logger.debug("_getServiceName___serviceName=" + serviceName);
    return serviceItemService.getServiceName(serviceName);
  }
}
