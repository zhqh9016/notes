package com.taikang.dic.ltci.common;

import java.util.List;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

/**
 * json工具类
 *
 * @author itw_xuxf
 */
public class JsonUtils {
  private static final String JSON_MSG = "{\"code\":\"%d\",\"data\":%s}";

  /**
   * json文本串
   *
   * @param code
   * @param msg
   * @return
   */
  public static String makeJsonText(final int code, final String msg) {
    String jsonMsg = "{\"code\":\"%d\",\"data\":%s}";
    return String.format(jsonMsg, code, msg);
  }

  /**
   * groupid:com.alibaba artiactid:fastjson version:1.2.3
   *
   * <p>0:成功
   *
   * @param list
   * @return
   */
  public static String makeJsonForList(final List<?> list) {
    return String.format(JSON_MSG, 0, JSON.toJSONString(list));
  }

  public static String makeJsonForList(final List<?> list, final String format) {
    return String.format(JSON_MSG, 0, JSON.toJSONStringWithDateFormat(list, format));
  }
  /**
   * 选择性传入需要用的字段
   *
   * @param list
   * @param strs
   * @return
   */
  public static String makeJsonForListFilter(final List<?> list, final String... strs) {
    final SimplePropertyPreFilter filter = new SimplePropertyPreFilter(strs);
    return String.format(JSON_MSG, 0, JSON.toJSONString(list, filter));
  }
  /** json实体串 */
  public static String makeJsonForObject(final Object obj) {
    return String.format(JSON_MSG, 0, JSON.toJSONString(obj));
  }

  /** json实体串 */
  public static String makeJsonForObjectWithoutFormat(final Object obj) {
    return JSON.toJSONString(obj);
  }

  public static String makeJsonForObject(final Object obj, final String format) {
    return String.format(JSON_MSG, 0, JSON.toJSONStringWithDateFormat(obj, format));
  }
  /**
   * 选择性传入需要用的字段
   *
   * @param list
   * @param strs
   * @return
   */
  public static String makeJsonForObjectFilter(final Object obj, final String... strs) {
    final SimplePropertyPreFilter filter = new SimplePropertyPreFilter(strs);
    return String.format(JSON_MSG, 0, JSON.toJSONString(obj, filter));
  }
}
