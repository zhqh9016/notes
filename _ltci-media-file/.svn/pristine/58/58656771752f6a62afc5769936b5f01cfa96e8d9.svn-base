package com.taikang.dic.ltci.common.cache;
/**
 * 缓存管理接口，不同缓存方式都可以实现此接口，但只有一个能被使用(使用@Component注解方式)
 *
 * @author longfei04 E-mail:
 * @version 创建时间：2017年3月31日 下午2:07:54
 */
public interface GenericCacheManager {

  /**
   * @param region
   * @param key
   * @return 通过键值获取指定区域内对象
   */
  Object get(String region, String key);

  /** 指定区域存储对象 */
  boolean put(String region, String key, Object obj);

  /**
   * @param region
   * @param key
   * @return 通过键值删除指定区域内对象
   */
  boolean remove(String region, String key);

  /**
   * @param region
   * @param keyPrefix 通过键值删除指定区域内对象
   */
  void batchRemove(String region, String keyPrefix);

  /**
   * @param region
   * @param key
   * @return 指定区域内是否存在缓存对象
   */
  boolean containsKey(String region, String key);
}
