package com.taikang.dic.ltci.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.taikang.dic.ltci.api.model.PageResultDTO;
import com.taikang.dic.ltci.api.model.ResultDTO;
import com.taikang.dic.ltci.api.model.ServiceItemDTO;
import com.taikang.dic.ltci.common.util.DateFormatUtil;
import com.taikang.dic.ltci.model.ServiceItemDO;
import com.taikang.dic.ltci.service.IServiceItemService;
import com.taikang.dic.ltci.service.ServiceException;

@RestController
@RequestMapping(path = "/api/v1", produces = "application/json;charset=utf-8")
public class ServiceItemController {

  private Logger logger = LoggerFactory.getLogger(ServiceItemController.class);

  @Autowired IServiceItemService serviceItemService;

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
    logger.debug(
        "_listItem___serviceCode=" + serviceCode + "___page=" + page + "___pageSize=" + pageSize);
    Map<String, Object> model =
        serviceItemService.listItem(
            serviceCode,
            serviceName,
            serviceType,
            chargeType,
            chargeLevel,
            isValid,
            page,
            pageSize);
    PageResultDTO pageRet = new PageResultDTO();
    pageRet.setPage(page);
    pageRet.setPageSize(pageSize);
    pageRet.setTotalDataNum(Integer.parseInt(model.get("totalDataNum").toString()));
    pageRet.setTotalPageNum(Integer.parseInt(model.get("totalPageNum").toString()));
    @SuppressWarnings("unchecked")
    List<ServiceItemDO> itemDoList = (List<ServiceItemDO>) model.get("itemDoList");

    List<ServiceItemDTO> itemDtoList = new ArrayList<>();
    for (ServiceItemDO item : itemDoList) {
      ServiceItemDTO itemRet = new ServiceItemDTO();
      BeanUtils.copyProperties(item, itemRet);
      if (item.getServiceType() != null) {
        itemRet.setServiceType(item.getServiceType().toString());
      }
      if (item.getStartTime() != null) {
        itemRet.setStartTime(
            DateFormatUtil.dateToStr(item.getStartTime(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      }
      if (item.getEndTime() != null) {
        itemRet.setEndTime(
            DateFormatUtil.dateToStr(item.getEndTime(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      }
      if (item.getOperatedTime() != null) {
        itemRet.setOperatedTime(
            DateFormatUtil.dateToStr(
                item.getOperatedTime(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
      }
      itemDtoList.add(itemRet);
    }
    pageRet.setDatas(itemDtoList);
    pageRet.setStatus(200);
    pageRet.setMessage("查询护理目录成功");
    return pageRet;
  }

  /**
   * 添加护理目录
   *
   * @param itemDTO
   * @return ResultDTO
   */
  @RequestMapping(path = "/addItem", method = RequestMethod.POST)
  public ResultDTO saveItem(@RequestBody ServiceItemDTO itemDTO) {
    logger.debug("_saveItem___itemDTO=" + itemDTO);
    ServiceItemDO itemDO = new ServiceItemDO();
    BeanUtils.copyProperties(itemDTO, itemDO);
    if (itemDTO.getServiceType() != null) {
      itemDO.setServiceType(Integer.parseInt(itemDTO.getServiceType()));
    }
    if (itemDTO.getStartTime() != null) {
      itemDO.setStartTime(DateFormatUtil.getDayFirstTime(itemDTO.getStartTime()));
    }
    if (itemDTO.getEndTime() != null) {
      itemDO.setEndTime(DateFormatUtil.getDayLastTime(itemDTO.getEndTime()));
    }
    ResultDTO resultDTO = new ResultDTO();
    try {
      serviceItemService.saveItem(itemDO);
      resultDTO.setStatus(200);
      resultDTO.setMessage("添加护理目录成功");
    } catch (ServiceException e) {
      resultDTO.setStatus(e.getErrorCode());
      resultDTO.setMessage(e.getMessage());
      logger.error("_saveItem_", e);
      return resultDTO;
    }
    return resultDTO;
  }

  /**
   * 删除护理目录
   *
   * @param id
   * @return ResultDTO
   */
  @RequestMapping(path = "/item/{id}", method = RequestMethod.DELETE)
  public ResultDTO deleteItem(@PathVariable String id) {
    logger.debug("_deleteItem___id=" + id);
    ResultDTO resultDTO = new ResultDTO();
    try {
      serviceItemService.deleteItem(id);
      resultDTO.setStatus(200);
      resultDTO.setMessage("删除护理目录成功");
    } catch (ServiceException e) {
      resultDTO.setStatus(e.getErrorCode());
      resultDTO.setMessage(e.getMessage());
      logger.error("_deleteItem_", e);
      return resultDTO;
    }
    return resultDTO;
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
    logger.debug("_getUser___id=" + id);
    ServiceItemDO itemDo = serviceItemService.getItem(id);
    ResultDTO resultDto = new ResultDTO();
    ServiceItemDTO itemDto = new ServiceItemDTO();
    BeanUtils.copyProperties(itemDo, itemDto);
    if (itemDo.getServiceType() != null) {
      itemDto.setServiceType(itemDo.getServiceType().toString());
    }
    if (itemDo.getStartTime() != null) {
      itemDto.setStartTime(
          DateFormatUtil.dateToStr(itemDo.getStartTime(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
    }
    if (itemDo.getEndTime() != null) {
      itemDto.setEndTime(
          DateFormatUtil.dateToStr(itemDo.getEndTime(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
    }
    if (itemDo.getOperatedTime() != null) {
      itemDto.setOperatedTime(
          DateFormatUtil.dateToStr(
              itemDo.getOperatedTime(), DateFormatUtil.DATE_FORMAT_YYYY_MM_DD));
    }
    resultDto.setStatus(200);
    resultDto.setMessage("查询成功");
    resultDto.setDatas(itemDto);
    return resultDto;
  }

  /**
   * 编辑护理目录
   *
   * @param itemDTO
   * @return ResultDTO
   */
  @RequestMapping(path = "/service/item", method = RequestMethod.PUT)
  @ResponseBody
  public ResultDTO updateItem(@RequestBody ServiceItemDTO itemDTO) {
    logger.debug("_updateItem___itemDTO=" + itemDTO);
    ServiceItemDO itemDO = new ServiceItemDO();
    BeanUtils.copyProperties(itemDTO, itemDO);
    if (itemDTO.getServiceType() != null) {
      itemDO.setServiceType(Integer.parseInt(itemDTO.getServiceType()));
    }
    if (itemDTO.getStartTime() != null) {
      itemDO.setStartTime(DateFormatUtil.getDayFirstTime(itemDTO.getStartTime()));
    }
    if (itemDTO.getEndTime() != null) {
      itemDO.setEndTime(DateFormatUtil.getDayLastTime(itemDTO.getEndTime()));
    }
    ResultDTO resultDto = new ResultDTO();
    try {
      serviceItemService.updateItem(itemDO);
      resultDto.setStatus(200);
      resultDto.setMessage("编辑护理目录成功");
    } catch (ServiceException e) {
      resultDto.setStatus(e.getErrorCode());
      resultDto.setMessage(e.getMessage());
      logger.error("_updateItem_", e);
      return resultDto;
    }
    return resultDto;
  }

  /**
   * 查询服务项目名称是否存在
   *
   * @param serviceName
   */
  @RequestMapping(path = "/service/item/name", method = RequestMethod.POST)
  public ResultDTO getServiceName(@RequestParam String serviceName) {
    logger.debug("_getServiceName___serviceName=" + serviceName);
    List<ServiceItemDO> serviceItemDO = serviceItemService.getServiceName(serviceName);
    ResultDTO resultDTO = new ResultDTO();
    List<ServiceItemDTO> serviceList = new ArrayList<>();
    for (ServiceItemDO service : serviceItemDO) {
      ServiceItemDTO serviceItemDTO = new ServiceItemDTO();
      BeanUtils.copyProperties(service, serviceItemDTO);
      serviceList.add(serviceItemDTO);
    }
    if (!serviceList.isEmpty()) {
      resultDTO.setStatus(0);
      resultDTO.setMessage("服务项目名称存在");
    } else {
      resultDTO.setStatus(1);
      resultDTO.setMessage("服务项目名称不存在");
    }
    return resultDTO;
  }
}
