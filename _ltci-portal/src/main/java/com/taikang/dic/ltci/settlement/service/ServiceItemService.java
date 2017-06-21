package com.taikang.dic.ltci.settlement.service;

import com.taikang.dic.ltci.portal.api.model.PageResultDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.ServiceItemDTO;

public interface ServiceItemService {

  /** 护理目录查询 */
  public PageResultDTO listItem(
      String serviceCode,
      String serviceName,
      String serviceType,
      String chargeType,
      String chargeLevel,
      String isValid,
      int page,
      int pageSize);

  /** 添加护理目录 */
  ResultDTO saveItem(ServiceItemDTO itemDTO);

  /** 删除护理目录 */
  ResultDTO deleteItem(String id);

  /** 编辑护理目录 */
  ResultDTO updateItem(ServiceItemDTO itemDTO);

  /** 根据护理目录ID查询护理目录信息 */
  ResultDTO getItem(String id);

  ResultDTO getServiceName(String serviceName);
}
