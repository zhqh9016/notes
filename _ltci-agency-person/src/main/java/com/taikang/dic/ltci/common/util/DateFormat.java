package com.taikang.dic.ltci.common.util;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class DateFormat {

  private DateFormat() {}

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
   * Date转换为OffsetDateTime
   *
   * @param inputDate
   * @return
   */
  public static OffsetDateTime date2OffsetDateTime(Date inputDate) {
    Instant instant = inputDate.toInstant();
    return instant.atZone(ZoneId.systemDefault()).toOffsetDateTime();
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
}
