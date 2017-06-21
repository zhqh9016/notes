package com.taikang.dic.ltci.treatment.application.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/** @author itw_liuxy 2017年3月29日18:17:04 用于将String类型转换为OffsetDateTime类型的转换器 */
@Component
public class StringToOffSetDateTimeConverter implements Converter<String, OffsetDateTime> {

  @Override
  public OffsetDateTime convert(String personBirth) {
    if (StringUtils.isBlank(personBirth)) {
      //      return LocalDate.now();
      return null;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try {
      Date date = sdf.parse(personBirth);
      Instant instant = date.toInstant();
      OffsetDateTime dateTime = instant.atZone(ZoneId.systemDefault()).toOffsetDateTime();
      return dateTime;
    } catch (ParseException e) {
      throw new RuntimeException("时间类型转换失败！");
    }
  }
}
