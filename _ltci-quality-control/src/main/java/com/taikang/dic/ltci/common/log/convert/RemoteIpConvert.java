package com.taikang.dic.ltci.common.log.convert;

import com.taikang.dic.ltci.common.log.LogBO;
import com.taikang.dic.ltci.common.log.ThreadLocalUtil;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class RemoteIpConvert extends ClassicConverter {

  @Override
  public String convert(ILoggingEvent event) {
    LogBO logBO = ThreadLocalUtil.threadLocal.get();
    String remoteIp = "";
    if (logBO != null) {
      remoteIp = logBO.getRemoteIp();
    }
    return remoteIp;
  }
}
