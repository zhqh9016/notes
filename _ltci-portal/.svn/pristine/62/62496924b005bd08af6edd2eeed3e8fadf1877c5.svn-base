package com.taikang.dic.ltci.portal.common.log.convert;

import com.taikang.dic.ltci.portal.common.log.LogConstant;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class LocalSystemCodeConvert extends ClassicConverter {

  @Override
  public String convert(ILoggingEvent event) {
    return LogConstant.LOG.getLocalCode();
  }
}
