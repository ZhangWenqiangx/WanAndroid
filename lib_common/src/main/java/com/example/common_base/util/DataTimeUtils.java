package com.example.common_base.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @author : zhang.wenqiang
 * @date : 2021/4/1
 * description :
 */
public class DataTimeUtils {

    /**
     * 英文全称 如：2010-12-01 23:15:06
     */
    private static final String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";
    /**
     * 精确到毫秒的完整时间 如：yyyy-MM-dd HH:mm:ss.SSS
     */
    private static final String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.SSS";
    /**
     * 英文简写（默认）如：2010-12-01
     */
    public static String FORMAT_SHORT = "yyyy-MM-dd";

    /**
     *  * 返回指定pattern样的日期时间字符串。
     * <p>
     *  *
     * <p>
     *  * @param dt
     * <p>
     *  * @param pattern
     * <p>
     *  * @return 如果时间转换成功则返回结果，否则返回空字符串""
     * <p>
     *  * @author 即时通讯网([url=http://www.52im.net]http://www.52im.net[/url])
     * <p>
     *  
     */
    public static String getTimeString(Date dt, String pattern) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);//"yyyy-MM-dd HH:mm:ss"
            sdf.setTimeZone(TimeZone.getDefault());
            return sdf.format(dt);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 仿照微信中的消息时间显示逻辑，将时间戳（单位：毫秒）转换为友好的显示格式.
     *
     * <p>
     * <p>
     * 1）7天之内的日期显示逻辑是：今天、昨天(-1d)、前天(-2d)、星期？（只显示总计7天之内的星期数，即<=-4d）；<br>
     * <p>
     * 2）7天之外（即>7天）的逻辑：直接显示完整日期时间。
     *
     * @param srcDate         要处理的源日期时间对象
     * @param mustIncludeTime true表示输出的格式里一定会包含“时间:分钟”，否则不包含（参考微信，不包含时分的情况，用于首页“消息”中显示时）
     * @return 输出格式形如：“10:30”、“昨天 12:04”、“前天 20:51”、“星期二”、“2019/2/21 12:09”等形式
     * @author 即时通讯网([url = http : / / www.52im.net]http : / / www.52im.net[ / url])
     * @since 4.5
     */
    public static String getTimeStringAutoShort2(Date srcDate, boolean mustIncludeTime) {
        String ret = "";
        try {
            GregorianCalendar gcCurrent = new GregorianCalendar();
            gcCurrent.setTime(new Date());
            int currentYear = gcCurrent.get(GregorianCalendar.YEAR);
            int currentMonth = gcCurrent.get(GregorianCalendar.MONTH) + 1;
            int currentDay = gcCurrent.get(GregorianCalendar.DAY_OF_MONTH);
            GregorianCalendar gcSrc = new GregorianCalendar();
            gcSrc.setTime(srcDate);
            int srcYear = gcSrc.get(GregorianCalendar.YEAR);
            int srcMonth = gcSrc.get(GregorianCalendar.MONTH) + 1;
            int srcDay = gcSrc.get(GregorianCalendar.DAY_OF_MONTH);
// 要额外显示的时间分钟
            String timeExtraStr = (mustIncludeTime ? " " + getTimeString(srcDate, "HH:mm") : "");
            if (currentYear == srcYear) {
                long currentTimestamp = gcCurrent.getTimeInMillis();
                long srcTimestamp = gcSrc.getTimeInMillis();
// 相差时间（单位：毫秒）
                long delta = (currentTimestamp - srcTimestamp);
                if (currentMonth == srcMonth && currentDay == srcDay) {
                    if (delta < 60 * 1000) {
                        ret = "刚刚";
                    } else {
                        ret = getTimeString(srcDate, "HH:mm");
                    }
                } else {
                    GregorianCalendar yesterdayDate = new GregorianCalendar();
                    yesterdayDate.add(GregorianCalendar.DAY_OF_MONTH, -1);
                    GregorianCalendar beforeYesterdayDate = new GregorianCalendar();
                    beforeYesterdayDate.add(GregorianCalendar.DAY_OF_MONTH, -2);
                    if (srcMonth == (yesterdayDate.get(GregorianCalendar.MONTH) + 1) && srcDay == yesterdayDate.get(GregorianCalendar.DAY_OF_MONTH)) {
                        ret = "昨天" + timeExtraStr;// -1d
                    } else if (srcMonth == (beforeYesterdayDate.get(GregorianCalendar.MONTH) + 1) && srcDay == beforeYesterdayDate.get(GregorianCalendar.DAY_OF_MONTH)) {
                        ret = "前天" + timeExtraStr;// -2d
                    } else {
                        long deltaHour = (delta / (3600 * 1000));
                        if (deltaHour < 7 * 24) {
                            String[] weekday = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
// 取出当前是星期几
                            String weedayDesc = weekday[gcSrc.get(GregorianCalendar.DAY_OF_WEEK) - 1];
                            ret = weedayDesc + timeExtraStr;
                        } else {
                            ret = getTimeString(srcDate, "yyyy/M/d") + timeExtraStr;
                        }
                    }
                }
            } else {
                ret = getTimeString(srcDate, "yyyy/M/d") + timeExtraStr;
            }
        } catch (Exception e) {
            System.err.println("【DEBUG-getTimeStringAutoShort】计算出错：" + e.getMessage() + " 【NO】");
        }
        return ret;
    }

    public static String getImTime(long time) {
        try {
            return getTimeStringAutoShort2(longToDate(time, FORMAT_LONG), true);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return String.valueOf(time);
    }

    public static Date longToDate(long currentTime, String formatType)
            throws ParseException {
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
        String sDateTime = dateToString(dateOld, formatType); // 把date类型的时间转换为string
        Date date = stringToDate(sDateTime, formatType); // 把String类型转换为Date类型
        return date;
    }

    // strTime要转换的string类型的时间，formatType要转换的格式yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日
    // HH时mm分ss秒，
    // strTime的时间格式必须要与formatType的时间格式相同
    public static Date stringToDate(String strTime, String formatType)
            throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(formatType);
        Date date = null;
        date = formatter.parse(strTime);
        return date;
    }

    // formatType格式为yyyy-MM-dd HH:mm:ss//yyyy年MM月dd日 HH时mm分ss秒
    // data Date类型的时间
    public static String dateToString(Date data, String formatType) {
        return new SimpleDateFormat(formatType).format(data);
    }
}