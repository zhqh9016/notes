package com.taikang.dic.ltci.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    if (date == null) {
      return "";
    }
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
    if (date == null) {
      return "";
    }
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

  /**
   * 日期类型转换成字符串类型
   *
   * @param date 日期
   * @param formatStr 日期格式
   * @return
   */
  public static String dateToStr(Date date, String formatStr) {
    SimpleDateFormat format = new SimpleDateFormat(formatStr);
    return format.format(date);
  }

  /**
   * 获取某一日期第一天
   *
   * @param str
   * @return
   */
  public static Date getMonthFirstDay(String str) {
    SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
    Date date = null;
    Calendar calendar = Calendar.getInstance();
    try {
      date = format.parse(str);
      calendar.setTime(date);
      calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
      calendar.set(
          calendar.get(Calendar.YEAR),
          calendar.get(Calendar.MONTH),
          calendar.get(Calendar.DATE),
          00,
          00,
          00);
    } catch (ParseException e) {
      logger.error("__getMonthFirstDay", e);
    }
    return calendar.getTime();
  }

  /**
   * 获取某一日期最后一天
   *
   * @param str
   * @return
   */
  public static Date getMonthLastDay(String str) {
    SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
    Date date = null;
    Calendar calendar = Calendar.getInstance();
    try {
      date = format.parse(str);
      calendar.setTime(date);
      calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
      calendar.set(
          calendar.get(Calendar.YEAR),
          calendar.get(Calendar.MONTH),
          calendar.get(Calendar.DATE),
          23,
          59,
          59);
    } catch (ParseException e) {
      logger.error("__getMonthLastDay", e);
    }
    return calendar.getTime();
  }

  /**
   * 取得某一日期的零点时间
   *
   * @param str
   * @return
   */
  public static Date getDayFirstTime(String str) {
    SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
    Date date = null;
    Calendar calendar = Calendar.getInstance();
    try {
      date = format.parse(str);
      calendar.setTime(date);
      calendar.set(
          calendar.get(Calendar.YEAR),
          calendar.get(Calendar.MONTH),
          calendar.get(Calendar.DATE),
          00,
          00,
          00);
    } catch (ParseException e) {
      logger.error("__getDayFirstTime", e);
    }
    return calendar.getTime();
  }

  public static Date getDayFirstTime(Date date) {
    String dateToStr = DateFormatUtil.dateToStr(date, DATE_FORMAT_YYYY_MM_DD);
    return DateFormatUtil.getDayFirstTime(dateToStr);
  }

  /**
   * 取得某一日期的23:59:59时间
   *
   * @param str
   * @return
   */
  public static Date getDayLastTime(String str) {
    SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
    Date date = null;
    Calendar calendar = Calendar.getInstance();
    try {
      date = format.parse(str);
      calendar.setTime(date);
      calendar.set(
          calendar.get(Calendar.YEAR),
          calendar.get(Calendar.MONTH),
          calendar.get(Calendar.DATE),
          23,
          59,
          59);
    } catch (ParseException e) {
      logger.error("__getDayLastTime", e);
    }
    return calendar.getTime();
  }

  /**
   * 东软接口日期转换为标准日期格式
   *
   * @param date 日期
   * @return
   */
  public static String dateStrToFormatStr(String date) {
    String year = date.substring(0, 4);
    String month = date.substring(4, 6);
    String day = date.substring(6, 8);
    return year + "-" + month + "-" + day;
  }
}
