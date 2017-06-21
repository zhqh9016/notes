package com.taikang.dic.ltci.settlement.serverClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.ServiceItemDTO;

@FeignClient(name = "${feign.settlement}", url = "${feign.settlement.url}")
public interface ServiceItemServerClient {

  /**
   * 按条件分页查询护理目录列表
   *
   * @param ItemDTO 查询条件
   * @param page 当前页码
   * @param pageSize 每页显示件数
   * @return 护理目录查询信息列表
   */
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/serviceItem/list")
  PageResultDTO listItem(
      @RequestParam(value = "serviceCode") String serviceCode,
      @RequestParam(value = "serviceName") String serviceName,
      @RequestParam(value = "serviceType") String serviceType,
      @RequestParam(value = "chargeType") String chargeType,
      @RequestParam(value = "chargeLevel") String chargeLevel,
      @RequestParam(value = "isValid") String isValid,
      @RequestParam(value = "page") int page,
      @RequestParam(value = "pageSize") int pageSize);

  /** 添加护理目录 */
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/addItem")
  ResultDTO saveItem(@RequestBody ServiceItemDTO itemDTO);

  /** 删除护理目录 */
  @RequestMapping(method = RequestMethod.DELETE, value = "/api/v1/item/{id}")
  ResultDTO deleteItem(@PathVariable(value = "id") String id);

  /** 编辑护理目录 */
  @RequestMapping(method = RequestMethod.PUT, value = "/api/v1/service/item")
  ResultDTO updateItem(@RequestBody ServiceItemDTO itemDTO);

  /** 根据护理目录ID查询护理目录信息 */
  @RequestMapping(method = RequestMethod.GET, value = "/api/v1/items/{id}")
  ResultDTO getItem(@PathVariable(value = "id") String id);

  /** 查询服务项目名称是否存在 */
  @RequestMapping(method = RequestMethod.POST, value = "/api/v1/service/item/name")
  ResultDTO getServiceName(@RequestParam(value = "serviceName") String serviceName);
}
