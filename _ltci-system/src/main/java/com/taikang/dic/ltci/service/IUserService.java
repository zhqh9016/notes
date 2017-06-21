package com.taikang.dic.ltci.service;

import java.util.List;
import java.util.Map;

import com.taikang.dic.ltci.model.UserDO;

/**
 * 用户服务接口
 *
 * @author longfei04 E-mail:
 * @version 创建时间：2017年3月31日 下午7:21:32
 */
public interface IUserService extends GenericService<UserDO, String> {

  /**
   * 按条件查询用户信息列表
   *
   * @param userDto
   * @param page
   * @param pageSize
   * @return
   */
  Map<String, Object> listUser(UserDO userDo, String roleCode, int page, int pageSize);

  /**
   * 插入用户信息
   *
   * @param userDto
   * @return
   */
  boolean createUser(UserDO userDo) throws ServiceException;

  /**
   * 根据用户名精确查询
   *
   * @param userName
   * @return
   */
  List<UserDO> listUser(String userName);

  /**
   * 删除用户
   *
   * @param id
   * @param operatedBy
   * @return
   */
  boolean deleteUser(String id, UserDO userDo) throws ServiceException;

  /**
   * 根据ID查询用户信息
   *
   * @param id
   * @return
   */
  UserDO getUser(String id);

  /**
   * 修改用户信息
   *
   * @param userDto
   * @return
   */
  boolean updateUser(UserDO userDo) throws ServiceException;

  /**
   * 获取稽核人员列表
   *
   * @return
   */
  List<UserDO> getAuditor();
}
