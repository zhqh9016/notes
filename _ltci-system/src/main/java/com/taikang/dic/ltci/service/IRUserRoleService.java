package com.taikang.dic.ltci.service;

import java.util.List;

import com.taikang.dic.ltci.model.RUserRoleDO;

public interface IRUserRoleService extends GenericService<RUserRoleDO, String> {

  public List<RUserRoleDO> getRUserRoleListByRoleId(String id);

  public boolean updataRUserRole(String roleId, String userId) throws ServiceException;

  public List<RUserRoleDO> selectRUserRole(String userId);
}
