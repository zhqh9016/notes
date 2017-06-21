package com.taikang.dic.ltci.service.impl;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.common.NotFoundByIdException;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.RRoleResDAO;
import com.taikang.dic.ltci.dao.RoleDAO;
import com.taikang.dic.ltci.model.BaseModel;
import com.taikang.dic.ltci.model.RRoleResDO;
import com.taikang.dic.ltci.model.RRoleResDOExample;
import com.taikang.dic.ltci.model.RUserRoleDO;
import com.taikang.dic.ltci.model.RoleDO;
import com.taikang.dic.ltci.model.RoleDOExample;
import com.taikang.dic.ltci.model.RoleDOExample.Criteria;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.IRRoleResService;
import com.taikang.dic.ltci.service.IRUserRoleService;
import com.taikang.dic.ltci.service.IRoleService;
import com.taikang.dic.ltci.service.ServiceException;

/**
 * 用户信息RoleServiceImpl
 *
 * @author itw_liuzy 2017-03-30
 */
@Service
public class RoleServiceImpl extends AbstractGenericService<RoleDO, String>
    implements IRoleService {

  @Autowired private RoleDAO roleDAO;

  @Autowired RRoleResDAO rRoleResDODAO;

  @Autowired private IRUserRoleService iRUserRoleService;

  @Autowired private IRRoleResService rRoleResService;

  @Override
  public IGenericDAO<RoleDO, String> getDao() {
    return roleDAO;
  }

  /**
   * 按条件查询角色信息列表
   *
   * @param
   * @return 角色信息列表
   */
  @Override
  public Map<String, Object> listRole(RoleDO roleDO, int page, int pageSize) {
    RoleDOExample example = new RoleDOExample();
    Criteria c = example.createCriteria();
    if (!StringUtils.isEmpty(roleDO.getRoleName())) {
      c.andRoleNameLike("%" + roleDO.getRoleName() + "%");
    }
    if (!StringUtils.isEmpty(roleDO.getRoleCode())) {
      c.andRoleCodeLike("%" + roleDO.getRoleCode() + "%");
    }
    // 删除标识
    c.andIsValidEqualTo(BaseModel.IsValid.VALID.getValue());
    int count = roleDAO.countByExample(example);

    int pageIndex = (page - 1) * pageSize;
    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;

    example.setOrderByClause(" sequence asc  limit " + pageIndex + " , " + pageSize + " ");
    List<RoleDO> roleDoList = roleDAO.selectByExample(example);
    if (roleDoList == null) {
      throw new NotFoundByIdException("无法查询到此数据");
    }

    Map<String, Object> model = new HashMap<>();
    model.put("page", page);
    model.put("pageSize", pageSize);
    model.put("totalDataNum", count);
    model.put("totalPageNum", totalPage);
    model.put("roleDoList", roleDoList);
    return model;
  }

  /**
   * 添加角色
   *
   * @param
   * @return
   */
  @Override
  public boolean saveRole(RoleDO roleDO) throws ServiceException {
    // 判断角色是否已添加
    List<RoleDO> roleList = getRoleName(roleDO.getRoleName());
    if (roleList != null && !roleList.isEmpty()) {
      throw new ServiceException(500, "该角色已添加");
    }
    // 设置主键
    roleDO.setId(UUID.randomUUID().toString().replace("-", ""));
    // 创建时间
    roleDO.setCreateTime(new Date());
    // 经办时间
    roleDO.setUpdateTime(new Date());
    SecureRandom random = new SecureRandom();
    int res = random.nextInt(1000000);
    String s = Integer.toString(res);
    roleDO.setRoleCode(s);
    // 删除标识
    roleDO.setIsValid(BaseModel.IsValid.VALID.getValue());
    int i = roleDAO.insertSelective(roleDO);
    if (i <= 0) {
      throw new ServiceException(500, "添加角色失败");
    }
    return true;
  }

  /**
   * 删除角色
   *
   * @param
   * @return
   */
  @Override
  public boolean deleteRole(String id) throws ServiceException {
    // 查询角色和用户是否有关系
    List<RUserRoleDO> list = iRUserRoleService.getRUserRoleListByRoleId(id);
    if (list != null && !list.isEmpty()) {
      throw new ServiceException(500, "删除失败！用户和角色存在关系");
    } else {
      // 删除角色的同时删除角色和菜单的关系
      List<RRoleResDO> roleRes = rRoleResService.getRRoleResListByRoleId(id);
      if (roleRes != null && !roleRes.isEmpty()) {
        RRoleResDOExample rx = new RRoleResDOExample();
        rx.createCriteria().andRoleIdEqualTo(id);
        rRoleResDODAO.deleteByExample(rx);
      }
      RoleDO rd = new RoleDO();
      rd.setId(id);
      rd.setIsValid(0);
      int i = roleDAO.updateByPrimaryKeySelective(rd);
      if (i <= 0) {
        throw new ServiceException(500, "删除失败");
      }
    }
    return true;
  }

  /**
   * 查询角色名称是否重复
   *
   * @param roleName
   * @return roleDOList
   */
  @Override
  public List<RoleDO> getRoleName(String roleName) {
    RoleDOExample example = new RoleDOExample();
    Criteria c = example.createCriteria();
    c.andIsValidEqualTo(BaseModel.IsValid.VALID.getValue());
    c.andRoleNameEqualTo(roleName);
    return roleDAO.selectByExample(example);
  }

  /** 查询用户所拥有的角色信息 */
  @Override
  public List<RoleDO> getRolesByUserId(String userId) {
    List<RUserRoleDO> userRoleList = iRUserRoleService.selectRUserRole(userId);
    List<RoleDO> roleList = new ArrayList<>();
    if (userRoleList != null && !userRoleList.isEmpty()) {
      for (RUserRoleDO userRoleInfo : userRoleList) {
        roleList.add(roleDAO.selectByPrimaryKey(userRoleInfo.getRoleId()));
      }
    }
    return roleList;
  }
}
