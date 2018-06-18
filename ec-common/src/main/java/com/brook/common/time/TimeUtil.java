package com.brook.common.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

/**
 * @author Brook 😈
 * @since 2018/6/16
 */
public interface TimeUtil {

  String PATTERN_ON_DATE_VALUE = "yyyy-MM-dd";
  String PATTERN_ON_DATE_SLASH_VALUE = "yyyy/MM/dd";
  String PATTERN_ON_DATE_BACKSLASH_VALUE = "yyyy\\MM\\dd";
  String PATTERN_ON_DATE_NONE_VALUE = "yyyyMMdd";
  String PATTERN_ON_DATETIME_VALUE = "yyyy-MM-dd HH:mm:ss";
  String PATTERN_ON_DATETIME_SLASH_VALUE = "yyyy/MM/dd HH:mm:ss";
  String PATTERN_ON_DATETIME_BACKSLASH_VALUE = "yyyy\\MM\\dd HH:mm:ss";
  String PATTERN_ON_DATETIME_NONE_VALUE = "yyyyMMdd HH:mm:ss";
  String PATTERN_DEFAULT_VALUE = "yyyy-MM-dd HH:mm:ss.SSS";
  String PATTERN_DEFAULT_ON_SLASH_VALUE = "yyyy/MM/dd HH:mm:ss.SSS";
  String PATTERN_DEFAULT_ON_BACKSLASH_VALUE = "yyyy\\MM\\dd HH:mm:ss.SSS";
  String PATTERN_DEFAULT_ON_NONE_VALUE = "yyyyMMdd HH:mm:ss.SSS";
  String PATTERN_DEFAULT_ON_NOSTYLE_VALUE = "yyyyMMddHHmmss";
  /**
   * 获取默认时间格式: yyyy-MM-dd HH:mm:ss
   */
  DateTimeFormatter DEFAULT_DATETIME_FORMATTER = TimeFormat
      .PATTERN_ON_DATETIME.formatter;

  /**
   * String 转时间
   */
  static LocalDateTime parse(String timeStr) {
    return LocalDateTime.parse(timeStr, DEFAULT_DATETIME_FORMATTER);
  }

  /**
   * String 转时间
   *
   * @param format 时间格式
   */
  static LocalDateTime parse(String timeStr, TimeFormat format) {
    return LocalDateTime.parse(timeStr, format.formatter);
  }

  /**
   * 时间转 String
   */
  static String format(LocalDateTime time) {
    return DEFAULT_DATETIME_FORMATTER.format(time);
  }

  static String format(LocalDate time) {
    return TimeFormat.PATTERN_ON_DATE.formatter.format(time);
  }

  /**
   * 时间转 String
   *
   * @param format 时间格式
   */
  static String format(LocalDateTime time, TimeFormat format) {
    return format.formatter.format(time);
  }

  /**
   * 获取当前时间
   */
  static String now() {
    return DEFAULT_DATETIME_FORMATTER.format(LocalDateTime.now());
  }

  /**
   * 获取当前时间
   *
   * @param format 时间格式
   */
  static String now(TimeFormat format) {
    return format.formatter.format(LocalDateTime.now());
  }

  /**
   * 转换成 {@code LocalDate}
   *
   * @return LocalDate
   */
  static LocalDate asLocalDate(Date date, ZoneId zone) {
    Objects.requireNonNull(date, "date can't be null.");
    if (date instanceof java.sql.Date) {
      return ((java.sql.Date) date).toLocalDate();
    } else {
      return Instant.ofEpochMilli(date.getTime())
          .atZone(zone).toLocalDate();
    }
  }

  static LocalDateTime asLocalDateTime(Date date) {
    return asLocalDateTime(date, ZoneId.systemDefault());
  }

  static LocalDateTime asLocalDateTime(Date date, ZoneId zone) {
    Objects.requireNonNull(date, "date can't be null.");
    if (date instanceof java.sql.Date) {
      return ((java.sql.Timestamp) date).toLocalDateTime();
    } else {
      return Instant.ofEpochMilli(date.getTime())
          .atZone(zone).toLocalDateTime();
    }
  }

  static LocalDate asLocalDate(Date date) {
    return asLocalDate(date, ZoneId.systemDefault());
  }

  static Instant asInstant(Date date) {
    Objects.requireNonNull(date, "date can't be null.");
    return Instant.ofEpochMilli(date.getTime());
  }

  static ZonedDateTime asZonedDateTime(Date date, ZoneId zone) {
    return asInstant(date).atZone(zone);
  }

  static ZonedDateTime asZonedDateTime(Date date) {
    return asInstant(date).atZone(ZoneId.systemDefault());
  }


  enum TimeFormat {

    /**
     * 格式: yyyy-MM-dd
     */
    PATTERN_ON_DATE(PATTERN_ON_DATE_VALUE),
    /**
     * 格式: yyyy/MM/dd
     */
    PATTERN_ON_DATE_SLASH(PATTERN_ON_DATE_SLASH_VALUE),
    /**
     * 格式: yyyy\MM\dd
     */
    PATTERN_ON_DATE_BACKSLASH(PATTERN_ON_DATE_BACKSLASH_VALUE),
    /**
     * 格式: yyyyMMdd
     */
    PATTERN_ON_DATE_NONE(PATTERN_ON_DATE_NONE_VALUE),

    /**
     * 格式: yyyy-MM-dd HH:mm:ss
     */
    PATTERN_ON_DATETIME(PATTERN_ON_DATETIME_VALUE),
    /**
     * 格式: yyyy/MM/dd HH:mm:ss
     */
    PATTERN_ON_DATETIME_SLASH(PATTERN_ON_DATETIME_SLASH_VALUE),
    /**
     * 格式: yyyy\MM\dd HH:mm:ss
     */
    PATTERN_ON_DATETIME_BACKSLASH(PATTERN_ON_DATETIME_BACKSLASH_VALUE),
    /**
     * 格式: yyyyMMdd HH:mm:ss
     */
    PATTERN_ON_DATETIME_NONE(PATTERN_ON_DATETIME_NONE_VALUE),

    /**
     * 格式: yyyy-MM-dd HH:mm:ss.SSS
     */
    PATTERN_DEFAULT(PATTERN_DEFAULT_VALUE),
    /**
     * 格式: yyyy/MM/dd HH:mm:ss.SSS
     */
    PATTERN_DEFAULT_ON_SLASH(PATTERN_DEFAULT_ON_SLASH_VALUE),
    /**
     * 格式: yyyy\MM\dd HH:mm:ss.SSS
     */
    PATTERN_DEFAULT_ON_BCKSLASH(PATTERN_DEFAULT_ON_BACKSLASH_VALUE),

    /**
     * 格式: yyyyMMdd HH:mm:ss.SSS
     */
    PATTERN_DEFAULT_ON_NONE(PATTERN_DEFAULT_ON_NONE_VALUE),

    /**
     * yyyyMMddHHmmss
     */
    PATTERN_DEFAULT_ON_NOSTYLE(PATTERN_DEFAULT_ON_NOSTYLE_VALUE);

    public transient DateTimeFormatter formatter;
    private String pattern;

    TimeFormat(String pattern) {
      formatter = DateTimeFormatter.ofPattern(pattern);
      this.pattern = pattern;
    }

    public static DateTimeFormatter of(String pattern) {
      return DateTimeFormatter.ofPattern(pattern);
    }

    public String pattern() {
      return this.pattern;
    }
  }
}