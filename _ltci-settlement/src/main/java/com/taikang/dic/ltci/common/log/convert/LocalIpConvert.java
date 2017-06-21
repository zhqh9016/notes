package com.taikang.dic.ltci.common.log.convert;

import com.taikang.dic.ltci.common.log.LogConstant;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class LocalIpConvert extends ClassicConverter {

  @Override
  public String convert(ILoggingEvent event) {
    return LogConstant.LOG.getLocalIp();
  }
}
