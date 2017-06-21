package com.taikang.dic.ltci.common.util;

import java.util.UUID;

/**
 * 生成UUID的工具,将默认生成的UUID中的"-"去掉
 *
 * @author itw_zhangqh
 */
public class UUIDUtil {

  public static String getUUID() {
    return UUID.randomUUID().toString().replace("-", "");
  }
}
