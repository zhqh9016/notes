package com.taikang.dic.ltci.common.log.convert;

import com.taikang.dic.ltci.common.log.LogBO;
import com.taikang.dic.ltci.common.log.ThreadLocalUtil;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class BusinessSerialidConvert extends ClassicConverter {

  @Override
  public String convert(ILoggingEvent event) {
    LogBO logBO = ThreadLocalUtil.threadLocal.get();
    String timestamp = "";
    if (logBO != null) {
      timestamp = logBO.getTimestamp();
    }
    return timestamp;
  }
}
