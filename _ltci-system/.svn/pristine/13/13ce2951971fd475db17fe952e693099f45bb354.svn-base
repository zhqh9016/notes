package com.taikang.dic.ltci.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.dao.RRoleResDAO;
import com.taikang.dic.ltci.dao.RUserRoleDAO;
import com.taikang.dic.ltci.dao.ResDAO;
import com.taikang.dic.ltci.model.BaseModel;
import com.taikang.dic.ltci.model.RRoleResDO;
import com.taikang.dic.ltci.model.RRoleResDOExample;
import com.taikang.dic.ltci.model.RUserRoleDO;
import com.taikang.dic.ltci.model.RUserRoleDOExample;
import com.taikang.dic.ltci.model.ResDO;
import com.taikang.dic.ltci.model.ResDOExample;
import com.taikang.dic.ltci.model.ResDOExample.Criteria;
import com.taikang.dic.ltci.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService {

  @Autowired private RUserRoleDAO ruserRoleDao;

  @Autowired private RRoleResDAO rroleResDao;

  @Autowired private ResDAO resDao;

  /** 获取菜单列表 */
  @Override
  public List<ResDO> listMenu(String userId, Integer isMenu) {
    // 查询用户所属角色
    RUserRoleDOExample userRoleExample = new RUserRoleDOExample();
    userRoleExample.createCriteria().andUserIdEqualTo(userId);
    List<RUserRoleDO> ruserRoleList = ruserRoleDao.selectByExample(userRoleExample);

    // 菜单list
    List<ResDO> resList = new ArrayList<>();

    // 记录角色ID
    List<String> roleIdList = new ArrayList<>();
    if (ruserRoleList != null && !ruserRoleList.isEmpty()) {
      for (RUserRoleDO userRoleInfo : ruserRoleList) {
        roleIdList.add(userRoleInfo.getRoleId());
      }
      // 根据角色ID查询所属权限
      RRoleResDOExample roleResExample = new RRoleResDOExample();
      roleResExample.createCriteria().andRoleIdIn(roleIdList);
      List<RRoleResDO> roleResList = rroleResDao.selectByExample(roleResExample);

      if (roleResList != null && !roleResList.isEmpty()) {
        // 记录权限ID
        List<String> resIdList = new ArrayList<>();
        for (RRoleResDO roleResInfo : roleResList) {
          resIdList.add(roleResInfo.getResId());
        }
        // 获取用户所属权限
        ResDOExample resExample = new ResDOExample();
        Criteria c = resExample.createCriteria();
        c.andIdIn(resIdList);
        c.andIsMenuEqualTo(isMenu);
        c.andIsValidEqualTo(BaseModel.IsValid.VALID.getValue());
        resExample.setOrderByClause(" sequence*1 asc ");
        resList = resDao.selectByExample(resExample);
      }
    }
    return resList;
  }

  /** 获取顶级菜单和子菜单列表 */
  @Override
  public List<ResDO> listMenus() {
    ResDOExample resExample = new ResDOExample();
    Criteria c = resExample.createCriteria();
    c.andIsValidEqualTo(BaseModel.IsValid.VALID.getValue());
    resExample.setOrderByClause(" sequence*1 asc");
    return resDao.selectByExample(resExample);
  }
}
