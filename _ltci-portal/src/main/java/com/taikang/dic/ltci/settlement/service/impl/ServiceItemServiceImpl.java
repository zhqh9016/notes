package com.taikang.dic.ltci.settlement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.ServiceItemDTO;
import com.taikang.dic.ltci.settlement.serverClient.ServiceItemServerClient;
import com.taikang.dic.ltci.settlement.service.ServiceItemService;

@Service
public class ServiceItemServiceImpl implements ServiceItemService {
  @Autowired private ServiceItemServerClient serviceItemServerClient;

  /**
   * 按条件分页查询护理目录列表
   *
   * @param ItemDTO 查询条件
   * @param page 当前页码
   * @param pageSize 每页显示件数
   * @return 护理目录查询信息列表
   */
  @Override
  public PageResultDTO listItem(
      String serviceCode,
      String serviceName,
      String serviceType,
      String chargeType,
      String chargeLevel,
      String isValid,
      int page,
      int pageSize) {
    return serviceItemServerClient.listItem(
        serviceCode, serviceName, serviceType, chargeType, chargeLevel, isValid, page, pageSize);
  }

  /** 添加护理目录 */
  public ResultDTO saveItem(ServiceItemDTO itemDTO) {
    return serviceItemServerClient.saveItem(itemDTO);
  }

  /** 删除护理目录 */
  public ResultDTO deleteItem(String id) {
    return serviceItemServerClient.deleteItem(id);
  }

  /** 编辑护理目录 */
  public ResultDTO updateItem(ServiceItemDTO itemDTO) {
    return serviceItemServerClient.updateItem(itemDTO);
  }

  /** 根据护理目录ID查询护理目录信息 */
  public ResultDTO getItem(String id) {
    return serviceItemServerClient.getItem(id);
  }

  /** 查询服务项目名称是否存在 */
  public ResultDTO getServiceName(String serviceName) {
    return serviceItemServerClient.getServiceName(serviceName);
  }
}
