package com.taikang.dic.ltci.dao;

import org.apache.ibatis.annotations.Mapper;

import com.taikang.dic.ltci.model.UserDO;

/**
 * 用户DAO
 *
 * @author longfei04 E-mail:
 * @version 创建时间：2017年3月31日 下午8:03:05
 */
@Mapper
public interface IUserDAO extends IGenericDAO<UserDO, Integer> {}
