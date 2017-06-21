package com.taikang.dic.ltci.dao;

import java.io.Serializable;

import com.taikang.dic.ltci.model.BaseModel;

/**
 * 一个通用的泛型化的DAO接口， <br>
 * 该接口里包含了比较通用的CRUD操作的方法声明。 <br>
 * 通过继承该接口，<br>
 * 可以 使你的DAO接口免去声明这些比较通用的CRUD方法的工作。
 *
 * @author longfei04 E-mail:
 * @version 创建时间：2017年3月31日 下午2:25:18
 */
public interface IGenericDAO<T extends BaseModel, ID extends Serializable> {

  int insert(T record);

  int insertSelective(T record);

  T selectByPrimaryKey(String id);

  int updateByPrimaryKeySelective(T record);

  int updateByPrimaryKey(T record);
}
