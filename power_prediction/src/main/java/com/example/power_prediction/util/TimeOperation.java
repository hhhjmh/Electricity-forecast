package com.example.power_prediction.util;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

public class TimeOperation {
    /**
     * 返回数据库中设置的时区的ZonedDateTime对象
     * @param temporal 时间对象
     * @return 包含时区信息的日期时间型
     */
    public static ZonedDateTime getZonedDateTime(Temporal temporal) {
        return null;
    }

    /**
     * 将实现了TemporalAccessor接口的对象转换成时间戳
     * @param temporal 时间对象
     * @return 时间戳单位为秒
     */
    public static Integer getTimeStamp(Temporal temporal){
        return null;
    }


    /**
     * 根据ChronoUnit提供的时间单位，在单位下比较时间是否在某一区间内<br>
     * 如Days则只判别小时以及分钟
     * @param time 判定的时间
     * @param start 开始的时间范围
     * @param end 结束的时间范围
     * @param chronoUnit 判定的单位
     */
    public static boolean isBetween(Temporal time, Temporal start, Temporal end, ChronoUnit chronoUnit){
        return true;
    }

    /**
     * 返回数据库中设置的时区
     *
     * @return ZoneId
     */
    public static ZoneId getZoneId() {
        return null;
    }

    /**
     * 设置系统时区
     * @param zone 类似 Asia/Shanghai 的格式
     */
    public static void setZoneId(String zone) {

    }
}
