package com.taikang.dic.ltci.controller;

import java.time.LocalDate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/** @author itw_liuxy 2017年3月29日18:17:04 用于将String类型转换为LocalDate类型的转换器 */
@Component
public class StringToLocalDateConverter implements Converter<String, LocalDate> {

  @Override
  public LocalDate convert(String personBirth) {
    if (StringUtils.isBlank(personBirth)) {
      return null;
    }
    return LocalDate.parse(personBirth);
  }
}
