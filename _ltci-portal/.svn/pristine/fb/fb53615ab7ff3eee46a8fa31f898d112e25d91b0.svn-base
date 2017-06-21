package com.taikang.dic.ltci.treatment.application.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/** @author itw_liuxy 2017年3月29日18:17:04 用于将String类型转换为LocalDate类型的转换器 */
@Component
public class StringToLocalDateConverter implements Converter<String, LocalDate> {

  @Override
  public LocalDate convert(String personBirth) {
    if (StringUtils.isBlank(personBirth)) {
      //      return LocalDate.now();
      return null;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try {
      Date date = sdf.parse(personBirth);
      personBirth = sdf.format(date);
      LocalDate localDate = LocalDate.parse(personBirth);
      return localDate;
    } catch (ParseException e) {
      throw new RuntimeException("时间类型转换失败！");
    }
  }
}
