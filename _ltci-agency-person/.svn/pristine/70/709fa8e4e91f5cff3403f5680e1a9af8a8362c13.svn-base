package com.taikang.dic.ltci.common.log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class ThreadLocalUtil {

  private ThreadLocalUtil() {
    super();
  }

  public static final ThreadLocal<LogBO> threadLocal = new ThreadLocal<>();

  public static String getTimestamp() {
    SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd HH:mm:ss SSS");
    return fmt.format(new Date());
  }

  public static String getBusinessSerialid() {
    return UUID.randomUUID().toString().replace("-", "");
  }
}
