package com.taikang.dic.ltci.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.taikang.dic.ltci.model.UserDO;

/**
 * 用户DAO
 *
 * @author longfei04 E-mail:
 * @version 创建时间：2017年3月31日 下午8:03:05
 */
@Mapper
public interface IUserSpecialDAO {
  List<UserDO> getUser(
      @Param("userName") String userName,
      @Param("departmentid") String departmentid,
      @Param("roleCode") String roleCode,
      @Param("page") int page,
      @Param("pageSize") int pageSize);

  int countUser(
      @Param("userName") String userName,
      @Param("departmentid") String departmentid,
      @Param("roleCode") String roleCode);

  List<UserDO> getUserNotRoleCode(
      @Param("userName") String userName,
      @Param("departmentid") String departmentid,
      @Param("page") int page,
      @Param("pageSize") int pageSize);

  int countUserNotRoleCode(
      @Param("userName") String userName, @Param("departmentid") String departmentid);
}
