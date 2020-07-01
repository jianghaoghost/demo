package com.ghost.utils.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 时间工具类
 *
 * @author ghost
 * @date 2018/6/18
 */
public final class DateUtils {


    public static DateTimeFormatter timeFormatter() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取当前系统时间(格式：yyyy-MM-dd HH:mm:ss)
     *
     * @return 时间字符串
     */
    public static String getCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 获取当前时间戳(格式yyyyMMddHHmmssSSS)
     *
     * @return 时间字符串
     */
    public static String getTimestamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS"));
    }

    /**
     * 获取当前时间戳毫秒数
     *
     * @return 毫秒数字符串
     */
    public static Long getMillisecond() {
        return System.currentTimeMillis();
    }

    /**
     * 自定义格式化时间
     *
     * @param format 格式化字符串(yyyy年MM月dd日 HH时mm分ss秒)
     * @return 格式化时间字符串
     */
    public static String getFormatTime(String format) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
    }

    /**
     * LocalDateTime时间格式转化为 yyyy-MM-dd HH:mm:ss
     *
     * @param time LocalDateTime
     * @return 时间字符串
     */
    public static String formatTime(LocalDateTime time) {
        return time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 获取年月日
     *
     * @param date LocalDate格式
     * @return 年月日字符串
     */
    public static String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    /**
     * 格式转换
     *
     * @param date Date格式(时间戳格式（毫秒）)
     * @return LocalDateTime格式
     */
    public static LocalDateTime date2LocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    /**
     * Date转成 年月日时分秒
     *
     * @param date Date格式
     * @return 年月日时分秒 字符串
     */
    public static String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

}
