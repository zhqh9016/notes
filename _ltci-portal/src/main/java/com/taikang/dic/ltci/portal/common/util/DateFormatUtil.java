package com.taikang.dic.ltci.portal.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateFormatUtil {

  public static final String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
  public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
  private static Logger logger = LoggerFactory.getLogger(DateFormatUtil.class);
  /**
   * 日期类型转换成字符串类型
   *
   * @param date 日期
   * @param formatStr 日期格式
   * @return
   */
  public static String DateToStr(Date date, String formatStr) {
    SimpleDateFormat format = new SimpleDateFormat(formatStr);
    String str = format.format(date);
    return str;
  }

  /**
   * 日期类型转换成字符串类型,yyyy-MM-dd HH:mm:ss
   *
   * @param date 日期
   * @return
   */
  public static String DateToTimeStr(Date date) {
    SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
    String str = format.format(date);
    return str;
  }

  /**
   * 字符串转换日期类型 yyyy-MM-dd HH:mm:ss
   *
   * @param str 日期字符串
   * @return
   */
  public static Date StrToDateTime(String str) {
    SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
    Date date = null;
    try {
      date = format.parse(str);
    } catch (ParseException e) {
      logger.error("日期转化错误：" + e);
    }
    return date;
  }

  /**
   * 字符串转换日期类型
   *
   * @param str 日期字符串
   * @param formatStr 日期格式
   * @return
   */
  public static Date StrToDate(String str, String formatStr) {
    SimpleDateFormat format = new SimpleDateFormat(formatStr);
    Date date = null;
    try {
      date = format.parse(str);
    } catch (ParseException e) {
      logger.error("");
    }
    return date;
  }
}
