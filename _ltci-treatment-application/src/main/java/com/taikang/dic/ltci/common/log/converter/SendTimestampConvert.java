package com.taikang.dic.ltci.common.log.converter;

import com.taikang.dic.ltci.common.log.LogBO;
import com.taikang.dic.ltci.common.log.ThreadLocalUtil;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;

public class SendTimestampConvert extends ClassicConverter {

  @Override
  public String convert(ILoggingEvent event) {
    LogBO logBO = ThreadLocalUtil.threadLocal.get();
    String businessSerialid = "";
    if (logBO != null) {
      businessSerialid = logBO.getBusinessSerialid();
    }
    return businessSerialid;
  }
}
