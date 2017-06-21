package com.taikang.dic.ltci.service;

import java.util.List;
import java.util.Map;

import com.taikang.dic.ltci.model.ServiceItemDO;

public interface IServiceItemService extends GenericService<ServiceItemDO, String> {

  public int putServiceItemMessage(String id, Integer valid);

  public Map<String, Object> listItem(
      String serviceCode,
      String serviceName,
      String serviceType,
      String chargeType,
      String chargeLevel,
      String isValid,
      int page,
      int pageSize);

  public boolean saveItem(ServiceItemDO itemDO) throws ServiceException;

  public boolean deleteItem(String id) throws ServiceException;

  public boolean updateItem(ServiceItemDO itemDO) throws ServiceException;

  public boolean pushServiceItem(String serviceItemId);

  public ServiceItemDO getItem(String id);

  public List<ServiceItemDO> getServiceName(String serviceName);
}
