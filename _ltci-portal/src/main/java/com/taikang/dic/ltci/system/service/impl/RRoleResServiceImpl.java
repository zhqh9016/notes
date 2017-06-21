package com.taikang.dic.ltci.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taikang.dic.ltci.portal.api.model.RRoleResDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.common.shiro.ReloadAuthorizationInfoSevice;
import com.taikang.dic.ltci.system.serverClient.RRoleResServerClient;
import com.taikang.dic.ltci.system.service.RRoleResService;

/**
 * 角色菜单关系service
 *
 * @author itw_huodd
 * @date 2017-04-05
 */
@Service
public class RRoleResServiceImpl implements RRoleResService {
  @Autowired RRoleResServerClient rRoleResServerClient;
  @Autowired ReloadAuthorizationInfoSevice reloadAuthorizationInfoSevice;

  /**
   * 根据角色id获取所有菜单与角色关系
   *
   * @param roleId
   * @return
   */
  public ResultDTO listRRoleRes(String roleId) {
    return rRoleResServerClient.listRRoleRes(roleId);
  }

  /**
   * 更新角色菜单关系
   *
   * @param roleId
   * @param roleId
   * @return
   */
  public ResultDTO updataRRoleRes(String roleId, String resIds) {
    ResultDTO resultDto = rRoleResServerClient.updateRRoleRes(roleId, resIds);
    //修改成功后重新加载权限信息
    reloadAuthorizationInfoSevice.reloadInfo();
    return resultDto;
  }

  /** 根据菜单id获取所有菜单与角色关系 */
  @Override
  public List<RRoleResDTO> listRRoleResByResId(String redId) {
    return rRoleResServerClient.listRRoleResByResId(redId);
  }
}
