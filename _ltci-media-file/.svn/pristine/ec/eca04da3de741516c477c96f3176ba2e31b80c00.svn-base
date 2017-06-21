package com.taikang.dic.ltci.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.taikang.dic.ltci.dao.IGenericDAO;
import com.taikang.dic.ltci.model.BaseModel;

/**
 * 基础Service接口的抽象实现类。该抽象类实现的CRUD方法几乎都在使用dao操作数据库之前添加了对缓存的操作。 例如，在T get(ID
 * id)中，实际上是先从缓存中读取该id代表的实体信息，如果没有读取到才使用dao从数据库中读取。 该抽象实现类中所使用的缓存是一个写更新缓存，所谓的写更新缓存即
 * ，每当数据库中的数据变更，缓存中的数据也会随之变更；例如:
 *
 * <ul>
 *   <li>从数据库delete的同时也会将相同id对应的实体从 缓存中删除；
 *   <li><b>但是update时例外，</b>对数据库进行update操作时，只会从缓存中删除对应的实体，而不会立即将更新之后的实体放入到缓存中
 *       ，只要当对该实体get时才会将新的实体放入到缓存中.
 *
 * @author longfei04 E-mail:
 * @version 创建时间：2017年3月31日 上午9:13:50
 */
public abstract class AbstractGenericService<T extends BaseModel, ID extends Serializable>
    implements GenericService<T, ID> {

  protected static final Logger logger = LoggerFactory.getLogger(AbstractGenericService.class);

  public abstract IGenericDAO<T, ID> getDao();

  @SuppressWarnings("unchecked")
  protected Class<T> getTClass() {
    return ((Class<T>)
        ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
  }

  public int insert(T record) {
    return this.getDao().insert(record);
  }

  public int insertSelective(T record) {
    return this.getDao().insertSelective(record);
  }

  public T selectByPrimaryKey(String id) {
    return this.getDao().selectByPrimaryKey(id);
  }

  public int updateByPrimaryKeySelective(T record) {
    return this.getDao().updateByPrimaryKeySelective(record);
  }

  public int updateByPrimaryKey(T record) {
    return this.getDao().updateByPrimaryKey(record);
  }
}
