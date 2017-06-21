package com.taikang.dic.ltci.common.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class DateFormat {

  /**
   * DTO转换为DO的时候日期类型转换方法。
   *
   * @param localDate
   * @return
   */
  public static Date localDate2Date(LocalDate localDate) {
    if (localDate == null) {
      return null;
    }
    ZoneId zoneId = ZoneId.systemDefault();
    Instant instant = localDate.atStartOfDay().atZone(zoneId).toInstant();
    return Date.from(instant);
  }

  /**
   * Date转为LocalDate
   *
   * @param inputDate
   * @return
   */
  public static LocalDate date2LocalDate(Date inputDate) {
    if (inputDate == null) {
      return null;
    }
    Instant instant = inputDate.toInstant();
    ZoneId zoneId = ZoneId.systemDefault();
    ZonedDateTime zonedDateTime = instant.atZone(zoneId);
    return zonedDateTime.toLocalDate();
  }

  /**
   * 获取当前时间
   *
   * @return
   */
  public static Timestamp getLocalDateTime() {
    LocalDateTime dateTime = LocalDateTime.now();
    return Timestamp.valueOf(dateTime);
  }

  /**
   * 获取当前long类型时间
   *
   * @return
   */
  public static String getLongDateTime() {
    Date date = new Date();
    return String.valueOf(date.getTime());
  }

  /**
   * Date转换为OffsetDateTime
   *
   * @param inputDate
   * @return
   */
  public static OffsetDateTime date2OffsetDateTime(Date inputDate) {
    Instant instant = inputDate.toInstant();
    OffsetDateTime dateTime = instant.atZone(ZoneId.systemDefault()).toOffsetDateTime();
    return dateTime;
  }

  /**
   * 根据日期获取周几
   *
   * @param time
   * @return
   */
  public static String getWeek(Timestamp time) {
    LocalDateTime dt = time.toLocalDateTime();
    DayOfWeek dayOfWeek = dt.getDayOfWeek();
    switch (dayOfWeek.getValue()) {
      case 1:
        return "星期一";
      case 2:
        return "星期二";
      case 3:
        return "星期三";
      case 4:
        return "星期四";
      case 5:
        return "星期五";
      case 6:
        return "星期六";
      default:
        return "星期日";
    }
  }

  /**
   * 根据出生日期算年龄
   *
   * @param birthDate
   * @return
   */
  public static String getAgeByBirthDay(Date birthDate) {
    String ageStr = "";
    if (birthDate != null) {
      int age = 0;
      Date now = new Date();
      SimpleDateFormat format_y = new SimpleDateFormat("yyyy");
      SimpleDateFormat format_m = new SimpleDateFormat("MM");

      String birth_year = format_y.format(birthDate);
      String now_year = format_y.format(now);

      String birth_month = format_m.format(birthDate);
      String now_month = format_m.format(now);

      //初步估算
      age = Integer.parseInt(now_year) - Integer.parseInt(birth_year);

      //如果未到出生月份，则age - 1
      if (now_month.compareTo(birth_month) < 0) {
        age -= 1;
      }
      if (age < 0) {
        age = 0;
      }
      ageStr = String.valueOf(age);
    }
    return ageStr;
  }
}
