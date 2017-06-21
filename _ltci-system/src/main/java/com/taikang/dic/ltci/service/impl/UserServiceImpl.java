package com.taikang.dic.ltci.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taikang.dic.ltci.common.ConstantUtil;
import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.dao.IUserSpecialDAO;
import com.taikang.dic.ltci.dao.RUserRoleDAO;
import com.taikang.dic.ltci.dao.RoleDAO;
import com.taikang.dic.ltci.dao.UserDAO;
import com.taikang.dic.ltci.model.BaseModel;
import com.taikang.dic.ltci.model.RUserRoleDO;
import com.taikang.dic.ltci.model.RUserRoleDOExample;
import com.taikang.dic.ltci.model.RoleDO;
import com.taikang.dic.ltci.model.RoleDOExample;
import com.taikang.dic.ltci.model.UserDO;
import com.taikang.dic.ltci.model.UserDOExample;
import com.taikang.dic.ltci.model.UserDOExample.Criteria;
import com.taikang.dic.ltci.service.AbstractGenericService;
import com.taikang.dic.ltci.service.IUserService;
import com.taikang.dic.ltci.service.ServiceException;

/**
 * 用户信息UserService
 *
 * @author itw_liyh01 2017-03-29
 */
@Service
public class UserServiceImpl extends AbstractGenericService<UserDO, String>
    implements IUserService {

  @Autowired private UserDAO userDOMapper;

  @Autowired private RUserRoleDAO userRoleMapper;

  @Autowired private RoleDAO roleDao;
  @Autowired private IUserSpecialDAO userSpecialDAO;

  @Override
  public IGenericDAO<UserDO, String> getDao() {
    return userDOMapper;
  }

  /** 按条件查询用户信息列表 */
  @Override
  public Map<String, Object> listUser(UserDO userDo, String roleCode, int page, int pageSize) {
    //分2种查询--一种有rolecode查询 --一种没有rolecode查询
    List<UserDO> userDoList;
    int count;
    if ("".equals(roleCode) || roleCode == null) {
      userDoList =
          userSpecialDAO.getUserNotRoleCode(
              userDo.getUserName(), userDo.getDepartmentid(), (page - 1) * pageSize, pageSize);
      count = userSpecialDAO.countUserNotRoleCode(userDo.getUserName(), userDo.getDepartmentid());
    } else {
      userDoList =
          userSpecialDAO.getUser(
              userDo.getUserName(),
              userDo.getDepartmentid(),
              roleCode,
              (page - 1) * pageSize,
              pageSize);
      count = userSpecialDAO.countUser(userDo.getUserName(), userDo.getDepartmentid(), roleCode);
    }
    int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
    Map<String, Object> model = new HashMap<>();
    model.put("page", page);
    model.put("pageSize", pageSize);
    model.put("totalDataNum", count);
    model.put("totalPageNum", totalPage);
    model.put("userDoList", userDoList);
    return model;
  }

  /**
   * 插入用户信息
   *
   * @param userDto 用户信息对象
   * @return 用户信息
   */
  @Override
  @Transactional
  public boolean createUser(UserDO userDo) throws ServiceException {
    // 判断用户是否已添加
    List<UserDO> userList = listUser(userDo.getUserName());
    if (userList != null && !userList.isEmpty()) {
      throw new ServiceException(500, "该用户已添加");
    }
    // 设置主键
    userDo.setId(UUID.randomUUID().toString().replace("-", ""));
    // 密码
    userDo.setPassword(userDo.getPassword());
    // 创建时间
    userDo.setCreateTime(new Date());
    // 经办时间
    userDo.setOperatedTime(new Date());
    // 删除标识
    userDo.setIsValid(BaseModel.IsValid.VALID.getValue());
    int i = userDOMapper.insertSelective(userDo);
    if (i <= 0) {
      throw new ServiceException(500, "新增用户失败");
    }
    return true;
  }

  /**
   * 根据用户名精确查询
   *
   * @param userName
   * @return
   */
  @Override
  public List<UserDO> listUser(String userName) {
    UserDOExample example = new UserDOExample();
    Criteria c = example.createCriteria();
    // 用户名
    c.andUserNameEqualTo(userName);
    return userDOMapper.selectByExample(example);
  }

  /**
   * 删除用户-微服务 1.提供用户删除微服务 2.提供用户角色关联删除微服务
   *
   * @param id 用户编号
   */
  @Override
  @Transactional
  public boolean deleteUser(String id, UserDO user) throws ServiceException {
    // 用户删除标识更新为1
    UserDO userDo = new UserDO();
    userDo.setId(id);
    userDo.setIsValid(BaseModel.IsValid.INVALID.getValue());
    userDo.setOperatedBy(user.getOperatedBy());
    userDo.setOperatedOrg(user.getOperatedOrg());
    userDo.setOperatedTime(new Date());
    int userDelete = userDOMapper.updateByPrimaryKeySelective(userDo);

    if (userDelete > 0) {
      RUserRoleDOExample example = new RUserRoleDOExample();
      example.createCriteria().andUserIdEqualTo(id);
      // 判断用户是否存在角色关系
      List<RUserRoleDO> userRoleList = userRoleMapper.selectByExample(example);
      // 删除用户角色关系数据
      if (userRoleList != null && !userRoleList.isEmpty()) {
        userDelete = userRoleMapper.deleteByExample(example);
        if (userDelete <= 0) {
          throw new ServiceException(500, "删除用户角色关系失败！");
        }
      }
    } else {
      throw new ServiceException(500, ConstantUtil.DELETE_NO_ITEM);
    }
    return true;
  }

  /**
   * 根据ID查询用户信息
   *
   * @param id 用户编号
   * @return 用户信息
   */
  @Override
  public UserDO getUser(String id) {
    return userDOMapper.selectByPrimaryKey(id);
  }

  /**
   * 修改用户信息
   *
   * @param userDto 用户修改信息
   * @return
   */
  @Override
  public boolean updateUser(UserDO userDo) throws ServiceException {
    int i = userDOMapper.updateByPrimaryKeySelective(userDo);
    if (i <= 0) {
      throw new ServiceException(500, "修改用户信息失败！");
    }
    return true;
  }

  /** 获取稽核人员列表 */
  @Override
  public List<UserDO> getAuditor() {
    RoleDOExample roleExample = new RoleDOExample();
    roleExample.createCriteria().andRoleNameEqualTo("稽核人员");
    List<RoleDO> roleList = roleDao.selectByExample(roleExample);
    List<String> userIdList = new ArrayList<>();
    for (RoleDO roleDo : roleList) {
      RUserRoleDOExample userRoleExample = new RUserRoleDOExample();
      userRoleExample.createCriteria().andRoleIdEqualTo(roleDo.getId());
      List<RUserRoleDO> userRoleList = userRoleMapper.selectByExample(userRoleExample);
      userRoleList.forEach(p -> userIdList.add(p.getUserId()));
    }
    UserDOExample userExample = new UserDOExample();
    Criteria c = userExample.createCriteria();
    c.andIdIn(userIdList);
    c.andIsValidEqualTo(BaseModel.IsValid.VALID.getValue());
    return userDOMapper.selectByExample(userExample);
  }
}
