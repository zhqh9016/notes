package com.taikang.dic.ltci.service;

import java.io.Serializable;

import com.taikang.dic.ltci.model.BaseModel;

/**
 * 该Service接口提供了基础的CRUD方法，通过实现该接口，即可获取这些接口；
 * AbstractGenericService实现了该接口，通过继承AbstractGenericService，你的Service类中将自动拥有
 * 这些CRUD操作的实现，而且，这些CRUD操作都是同时对数据库和缓存进行操作；
 *
 * @author longfei04 E-mail:
 * @version 创建时间：2017年3月31日 上午9:55:48
 */
public interface GenericService<T extends BaseModel, ID extends Serializable> {

  int insertSelective(T t);
}
