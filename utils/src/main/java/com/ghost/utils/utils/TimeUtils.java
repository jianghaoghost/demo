package com.ghost.utils.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: ghost
 * @date: 2019/8/14 14:21
 * @description: 不同日期类型转换工具类
 */
public class TimeUtils {

    /**
     * 时间戳转化为日期（yyyy-MM-dd）
     *
     * @param stamp 时间戳
     * @return 转化后的时间
     */
    public static String stampToTime(String stamp) {
        String sd = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sd = sdf.format(new Date(Long.parseLong(stamp)));
        return sd;
    }

    /**
     * 时间戳转化为日期（yyyy-MM）
     *
     * @param stamp 时间
     * @return 转化后的时间
     */
    public static String stampToTime2(String stamp) {
        String sd = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        sd = sdf.format(new Date(Long.parseLong(stamp)));
        return sd;
    }

    /**
     * 时间戳转化为日期（yyyy-MM-dd HH:mm:ss）
     *
     * @param stamp 时间
     * @return 转化后的时间
     */
    public static String stampToTime3(String stamp) {
        String sd = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sd = sdf.format(new Date(Long.parseLong(stamp)));
        return sd;
    }


    /**
     * 日期（yyyy-MM-dd）转化为时间戳
     *
     * @param stamp 时间
     * @return 转化后的时间
     */
    public static long timeToStamp(String stamp) {
        Date d = new Date();
        long timeStemp = 0;
        try {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            d = sf.parse(stamp);
            // 日期转换为时间戳
        } catch (ParseException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
        timeStemp = d.getTime();
        return timeStemp;
    }

    /**
     * 日期（yyyy-MM-dd HH:mm:ss）转化为时间戳
     *
     * @param stamp 时间
     * @return 转化后的时间
     */
    public static long timeToStamp2(String stamp) {
        Date d = new Date();
        long timeStemp = 0;
        try {
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            d = sf.parse(stamp);
            // 日期转换为时间戳
        } catch (ParseException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
        timeStemp = d.getTime();
        return timeStemp;
    }

    /**
     * yyyy-MM-dd转化为时间戳
     *
     * @param time 时间
     * @return 时间戳
     */
    public static String switchTime(String time) {
        //yyyy-MM-dd转化为时间戳
        long stamp = timeToStamp(time);
        String date = stampToTime3(String.valueOf(stamp));
        return date;
    }


    /**
     * 将2019-08-19转化为2019-08-19 00:00:00
     *
     * @param time 时间
     * @return 转化后的时间
     */
    public static String switchTime2(String time) {
        return TimeUtils.switchTime(time);
    }

    /**
     * 将2019-08-19转化为2019-08-19 23:59:59
     *
     * @param time 时间
     * @return 转化后的时间
     */
    public static String switchTime3(String time) {
        long stamp = TimeUtils.timeToStamp(time) + ((24 * 60 * 60 - 1) * 1000);
        return TimeUtils.stampToTime3(String.valueOf(stamp));
    }

    /**
     * 日期转化时间集合
     *
     * @param startDate (2019-09-10)
     * @param endDate   (2019-09-14)
     * @return 日期时间集合
     */
    public static List<String> conversionTimeList(String startDate, String endDate) {
        List<String> dateList = new ArrayList<>();
        long startStamp = timeToStamp(startDate);
        long endStamp = timeToStamp(endDate);
        for (long startTime = startStamp; startTime <= endStamp; startTime += (24 * 60 * 60 * 1000)) {
            String stamp = TimeUtils.stampToTime("" + startTime);
            dateList.add(stamp);
        }
        return dateList;
    }
}
