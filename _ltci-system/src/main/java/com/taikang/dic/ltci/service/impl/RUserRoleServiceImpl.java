package com.taikang.dic.ltci.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.RUserRoleDAO;
import com.taikang.dic.ltci.model.RUserRoleDO;
import com.taikang.dic.ltci.model.RUserRoleDOExample;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.IRUserRoleService;
import com.taikang.dic.ltci.service.ServiceException;

/**
 * 用户角色关系service
 *
 * @author itw_liuzy
 * @date 2017-03-31
 */
@Service
public class RUserRoleServiceImpl extends AbstractGenericService<RUserRoleDO, String>
    implements IRUserRoleService {
  private static final Logger logger = LoggerFactory.getLogger(RUserRoleServiceImpl.class);

  @Autowired private RUserRoleDAO rUserRoleDODAO;

  @Override
  public List<RUserRoleDO> getRUserRoleListByRoleId(String id) {
    RUserRoleDOExample re = new RUserRoleDOExample();
    re.createCriteria().andRoleIdEqualTo(id);
    return rUserRoleDODAO.selectByExample(re);
  }

  @Override
  public IGenericDAO<RUserRoleDO, String> getDao() {
    return rUserRoleDODAO;
  }

  /**
   * 更新角色用户关系
   *
   * @param
   */
  @Transactional
  @Override
  public boolean updataRUserRole(String roleId, String userId) throws ServiceException {
    //删除所有用户关系
    RUserRoleDOExample rx = new RUserRoleDOExample();
    rx.createCriteria().andUserIdEqualTo(userId);
    rUserRoleDODAO.deleteByExample(rx);

    String[] stringArr = roleId.split(",");
    //插入多个关系
    for (String id : stringArr) {
      RUserRoleDO u = new RUserRoleDO();
      u.setRoleId(id);
      u.setUserId(userId);
      int userRole = rUserRoleDODAO.insertSelective(u);
      if (userRole <= 0) {
        throw new ServiceException(500, "更新角色用户关系失败");
      }
    }
    return true;
  }

  /**
   * 查询角色用户关系
   *
   * @param
   * @return
   */
  @Override
  public List<RUserRoleDO> selectRUserRole(String userId) {
    RUserRoleDOExample rx = new RUserRoleDOExample();
    rx.createCriteria().andUserIdEqualTo(userId);
    return rUserRoleDODAO.selectByExample(rx);
  }
}
