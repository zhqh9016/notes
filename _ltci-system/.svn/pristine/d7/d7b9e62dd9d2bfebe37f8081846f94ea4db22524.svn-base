package com.taikang.dic.ltci.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taikang.dic.ltci.common.enumeration.IsMenuEnum;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.RRoleResDAO;
import com.taikang.dic.ltci.dao.ResDAO;
import com.taikang.dic.ltci.model.BaseModel.IsValid;
import com.taikang.dic.ltci.model.RRoleResDO;
import com.taikang.dic.ltci.model.RRoleResDOExample;
import com.taikang.dic.ltci.model.ResDO;
import com.taikang.dic.ltci.model.ResDOExample;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.IRRoleResService;
import com.taikang.dic.ltci.service.IResService;

/**
 * 角色菜单关系service
 *
 * @author itw_huodd
 * @date 2017-04-05
 */
@Service
public class RRoleResServiceImpl extends AbstractGenericService<RRoleResDO, String>
    implements IRRoleResService {
  @Autowired RRoleResDAO rRoleResDODAO;
  @Autowired IResService resService;
  @Autowired ResDAO resDao;

  @Override
  public IGenericDAO<RRoleResDO, String> getDao() {
    return rRoleResDODAO;
  }
  /**
   * 根据角色id获取所有菜单与角色关系
   *
   * @param roleId
   * @return
   */
  @Override
  public List<RRoleResDO> getRRoleResListByRoleId(String roleId) {
    RRoleResDOExample re = new RRoleResDOExample();
    re.createCriteria().andRoleIdEqualTo(roleId);
    return rRoleResDODAO.selectByExample(re);
  }

  /**
   * 更新角色菜单关系
   *
   * @param roleId
   * @param roleId
   * @return
   * @throws Exception
   */
  @Transactional
  @Override
  public boolean updataRRoleRes(String roleId, String resIds) throws Exception {
    //删除所有角色菜单关系
    RRoleResDOExample rx = new RRoleResDOExample();
    rx.createCriteria().andRoleIdEqualTo(roleId);
    rRoleResDODAO.deleteByExample(rx);

    String[] stringArr = resIds.split(",");
    //插入多个关系
    for (String resId : stringArr) {
      //校验资源id是否存在
      if (resService.getResById(resId) == null) throw new Exception("资源[id=" + resId + "]不存在");

      RRoleResDO u = new RRoleResDO();
      u.setRoleId(roleId);
      u.setResId(resId);
      rRoleResDODAO.insertSelective(u);

      // 角色添加资源权限
      ResDOExample resExample = new ResDOExample();
      resExample
          .createCriteria()
          .andParentIdEqualTo(resId)
          .andIsMenuEqualTo(IsMenuEnum.IS_MENU_NO.getValue())
          .andIsValidEqualTo(IsValid.VALID.getValue());
      List<ResDO> sourceMenu = resDao.selectByExample(resExample);
      for (ResDO resDo : sourceMenu) {
        RRoleResDO rRoleRes = new RRoleResDO();
        rRoleRes.setRoleId(roleId);
        rRoleRes.setResId(resDo.getId());
        RRoleResDOExample rRoleResExample = new RRoleResDOExample();
        rRoleResExample.createCriteria().andRoleIdEqualTo(roleId).andResIdEqualTo(resDo.getId());
        List<RRoleResDO> rRoleResCheck = rRoleResDODAO.selectByExample(rRoleResExample);
        if (rRoleResCheck == null || rRoleResCheck.isEmpty()) {
          rRoleResDODAO.insertSelective(rRoleRes);
        }
      }
    }
    return true;
  }

  @Override
  public List<RRoleResDO> getRRoleResListByResId(String resId) {
    RRoleResDOExample re = new RRoleResDOExample();
    re.createCriteria().andResIdEqualTo(resId);
    return rRoleResDODAO.selectByExample(re);
  }
}
