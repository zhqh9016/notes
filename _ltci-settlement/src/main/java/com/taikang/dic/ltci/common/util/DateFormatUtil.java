package com.taikang.dic.ltci.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateFormatUtil {

  private static final Logger logger = LoggerFactory.getLogger(DateFormatUtil.class);

  public static final String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

  public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

  public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";

  private DateFormatUtil() {}

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
   * 字符串转换日期类型
   *
   * @param str 日期字符串
   * @param formatStr 日期格式
   * @return
   */
  public static Date strToDate(String str, String formatStr) {
    SimpleDateFormat format = new SimpleDateFormat(formatStr);
    Date date = null;
    try {
      date = format.parse(str);
    } catch (ParseException e) {
      logger.error("__strToDate", e);
    }
    return date;
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

  public static Date getDayLastTime(Date date) {
    String dateToStr = DateFormatUtil.dateToStr(date, DATE_FORMAT_YYYY_MM_DD);
    return DateFormatUtil.getDayLastTime(dateToStr);
  }
  /**
   * 日期类型转换成字符串类型,yyyy-MM-dd HH:mm:ss
   *
   * @param date 日期
   * @return
   */
  public static String dateToTimeStr(Date date) {
    SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
    return format.format(date);
  }

  /**
   * 字符串转换日期类型 yyyy-MM-dd HH:mm:ss
   *
   * @param str 日期字符串
   * @return
   */
  public static Date strToDateTime(String str) {
    SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
    Date date = null;
    try {
      date = format.parse(str);
    } catch (ParseException e) {
      logger.error("__strToDateTime", e);
    }
    return date;
  }
  /**
   * 字符串转换日期类型 yyyy-MM-dd
   *
   * @param str 日期字符串
   * @return
   */
  public static Date strToDate(String str) {
    SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
    Date date = null;
    try {
      date = format.parse(str);
    } catch (ParseException e) {
      logger.error("__strToDate", e);
    }
    return date;
  }

  public static String getBeforeMonth() {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-hh");
    Calendar cad = Calendar.getInstance();
    cad.setTime(new Date());
    cad.add(Calendar.MONTH, -1);
    String result = format.format(cad.getTime());
    return result;
  }

  /**
   * 获取一个时间段内，每个月份 flag 是true时，包含结束月份
   *
   * @return
   */
  public static List<String> getMonth(String startTime, String endTime, boolean flag) {
    List<String> monthList = new ArrayList<>();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-hh");
    try {
      Date start = format.parse(startTime);
      Date end = DateFormatUtil.getMonthFirstDay(endTime);
      Calendar cad = Calendar.getInstance();
      cad.setTime(start);
      while (cad.getTime().before(end)) {
        String str = format.format(cad.getTime());
        monthList.add(str);
        cad.add(Calendar.MONTH, 1);
      }
      if (flag) {
        monthList.add(format.format(end));
      }
    } catch (ParseException e) {
      logger.error("parse date error from DateFormatUtil.", e);
    }
    return monthList;
  }
}
