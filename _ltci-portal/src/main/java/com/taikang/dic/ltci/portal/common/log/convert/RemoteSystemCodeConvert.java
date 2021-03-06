package com.taikang.dic.ltci.portal.common.log.convert;

import com.taikang.dic.ltci.portal.common.log.LogBO;
import com.taikang.dic.ltci.portal.common.log.ThreadLocalUtil;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class RemoteSystemCodeConvert extends ClassicConverter {

  @Override
  public String convert(ILoggingEvent event) {
    LogBO logBO = ThreadLocalUtil.threadLocal.get();
    String remoteCode = "";
    if (logBO != null) {
      remoteCode = logBO.getSystemCode();
    }
    return remoteCode;
  }
}
