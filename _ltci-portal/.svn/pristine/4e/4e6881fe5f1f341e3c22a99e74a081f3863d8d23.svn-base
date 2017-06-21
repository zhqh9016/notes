package com.taikang.dic.ltci.portal.common.shiro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taikang.dic.ltci.portal.api.model.MenuDTO;
import com.taikang.dic.ltci.portal.api.model.OrganizationDTO;
import com.taikang.dic.ltci.portal.api.model.RUserRoleDTO;
import com.taikang.dic.ltci.portal.api.model.ResultDTO;
import com.taikang.dic.ltci.portal.api.model.RoleDTO;
import com.taikang.dic.ltci.portal.api.model.UserDTO;
import com.taikang.dic.ltci.portal.common.enumeration.IsMenuEnum;
import com.taikang.dic.ltci.portal.common.enumeration.IsValidEnum;
import com.taikang.dic.ltci.portal.common.util.Encodes;
import com.taikang.dic.ltci.portal.common.util.UserUtils;
import com.taikang.dic.ltci.system.service.IOrganizationService;
import com.taikang.dic.ltci.system.service.MenuService;
import com.taikang.dic.ltci.system.service.RoleService;
import com.taikang.dic.ltci.system.service.UserService;

/**
 * 系统安全认证实现类 自定义shiro Realm,主要做两个工作, 1:根据用户名从数据库中查询用户信息,然后封装到AuthenticationInfo中返回给SecurityManager.
 * 2:根据用户信息从数据库中查找用户的角色权限信息,然后封装到AuthorizationInfo中返回给SecurityManager.
 *
 * @author itw_zhangqh
 */
public class SystemAuthorizingRealm extends AuthorizingRealm implements Serializable {

  /** */
  private static final long serialVersionUID = 1L;

  private static final Logger log = LoggerFactory.getLogger(CustomFormAuthenticationFilter.class);

  @Autowired private UserService userService;
  @Autowired private RoleService roleService;
  @Autowired private IOrganizationService organizationService;
  @Autowired private MenuService menuService;

  /** 认证回调函数, 登录时调用 */
  @SuppressWarnings("unchecked")
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
      throws AuthenticationException {
    //从token中获取用户名
    UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
    String username = (String) token.getPrincipal();
    //根据用户名获取用户信息
    ResultDTO listUser = userService.listUser(username);
    List<Map<String, Object>> userList = (List<Map<String, Object>>) listUser.getDatas();
    UserDTO userDTO = null;
    //过滤已被删除的用户
    for (Map<String, Object> source : userList) {
      String jsonString = JSONObject.toJSONString(source);
      UserDTO parseObject = JSONObject.parseObject(jsonString, UserDTO.class);
      if (parseObject != null && IsValidEnum.NO_DELETE.getValue() == parseObject.getIsValid()) {
        userDTO = parseObject;
      }
    }
    //如果没有匹配到用户,直接抛出用户名不存在的异常
    if (userDTO == null) {
      throw new UnknownAccountException();
    }

    //================将用户的角色信息、组织信息、菜单信息存入用户凭证中==================
    //=================================================================================

    //将用户所属机构存入subject中
    String departmentid = userDTO.getDepartmentid();

    if (!StringUtils.isEmpty(departmentid)) {
      ResultDTO selectById = organizationService.selectById(departmentid);
      Object datas = selectById.getDatas();
      String jsonString = JSONObject.toJSONString(datas);
      OrganizationDTO userOrganization = JSONObject.parseObject(jsonString, OrganizationDTO.class);
      userDTO.setDepartment(userOrganization);
      log.debug("将用户组织信息存入用户凭证中,组织信息为: " + userOrganization);
    }

    // 将用户可访问菜单存入subject中
    ResultDTO menuDto = menuService.listMenu(userDTO.getId(), IsMenuEnum.IS_MENU_YES.getValue());
    List<MenuDTO> menuList = (List<MenuDTO>) menuDto.getDatas();
    log.debug("将用户菜单信息存入用户凭证中,菜单信息为: " + menuList);
    userDTO.setMenu(menuList);

    // 将用户所拥有角色信息存入subject中
    ResultDTO roleDto = roleService.getRolesByUserId(userDTO.getId());
    List<Map<String, Object>> roleMapList = (List<Map<String, Object>>) roleDto.getDatas();
    List<RoleDTO> roleList = new ArrayList<>();
    if (roleDto.getDatas() != null) {
      roleList = JSONArray.parseArray(roleMapList.toString(), RoleDTO.class);
      log.debug("将用户角色信息存入用户凭证中,角色信息为: " + roleList);
    }
    userDTO.setRole(roleList);

    //================================================================================
    //================================================================================

    //从查出的用户中获取密码信息,并将用户随机盐从密码中分离出来
    String userpassword = userDTO.getPassword();

    String password = userpassword.substring(16);
    String salt = userpassword.substring(0, 16);
    //构建用户认证凭证,并设置用户信息和密码,随机盐
    SimpleAuthenticationInfo simpleAuthenticationInfo =
        new SimpleAuthenticationInfo(
            userDTO, password, ByteSource.Util.bytes(Encodes.decodeHex(salt)), getName());

    return simpleAuthenticationInfo;
  }

  /** 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用 */
  @SuppressWarnings("unchecked")
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    //获取当前登录用户的id
    UserDTO currentUser = UserUtils.getCurrentUser();
    String id = currentUser.getId();
    //根据id查出所有用户角色信息
    ResultDTO selectRUserRole = roleService.selectRUserRole(id);
    List<Map<String, Object>> datas = (List<Map<String, Object>>) selectRUserRole.getDatas();
    //将用户角色信息存入authorizationInfo中
    Set<String> roles = new HashSet<>();
    for (Map<String, Object> source : datas) {
      String jsonString = JSONObject.toJSONString(source);
      RUserRoleDTO userRole = JSONObject.parseObject(jsonString, RUserRoleDTO.class);
      roles.add(userRole.getRoleId());
    }
    SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
    authorizationInfo.setRoles(roles);
    return authorizationInfo;
  }
}
