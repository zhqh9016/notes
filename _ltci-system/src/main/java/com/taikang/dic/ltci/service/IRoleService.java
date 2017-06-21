package com.taikang.dic.ltci.service;

import java.util.List;
import java.util.Map;

import com.taikang.dic.ltci.model.RoleDO;

public interface IRoleService extends GenericService<RoleDO, String> {

  Map<String, Object> listRole(RoleDO roleDO, int page, int pageSize);

  boolean saveRole(RoleDO roleDO) throws ServiceException;

  public boolean deleteRole(String id) throws ServiceException;

  public List<RoleDO> getRoleName(String roleName);

  public List<RoleDO> getRolesByUserId(String userId);
}
