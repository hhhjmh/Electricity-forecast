package com.example.power_prediction.util;


import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;


public class TimeOperation {


    /**
     * 返回ZonedDateTime对象
     *
     * @param temporal 时间对象
     * @return 与传入对象相同时区信息的日期时间型
     */
    public static ZonedDateTime getZonedDateTime(Temporal temporal) {
        return ZonedDateTime.from(temporal);
    }

    /**
     * 返回ZonedDateTime对象，并指定时区
     *
     * @param temporal 时间对象
     * @param zoneId   时区
     * @return 返回指定时区的ZonedDateTime对象
     */
    public static ZonedDateTime getZonedDateTime(Temporal temporal, ZoneId zoneId) {
        return ZonedDateTime.from(temporal).withZoneSameInstant(zoneId);
    }

    /**
     * 传入时间戳获得ZonedDateTime对象
     *
     * @param timeStamp Integer类型的以秒为单位时间戳
     * @param zoneId    时区
     * @return 返回指定时区的ZonedDataTime对象
     */
    public static ZonedDateTime getZonedDateTime(Integer timeStamp, ZoneId zoneId) {
        return ZonedDateTime.ofInstant(Instant.ofEpochSecond(timeStamp), zoneId);
    }

    /**
     * 将实现了Temporal接口的对象转换成时间戳
     *
     * @param temporal 时间对象
     * @return 时间戳单位为秒
     */
    public static Integer getTimeStamp(Temporal temporal) {
        return (int) Instant.from(temporal).toEpochMilli() / 1000;
    }


    /**
     * 根据ChronoUnit提供的时间单位，在单位下比较时间是否在某一区间内<br>
     * 如果end比start小则表示end在start的最高计量单位下+1<br>
     * 如 LocalTime start 23:00 end 01：00则表示从23：00第二天01：00<br>
     * 左闭右开
     *
     * @param time       判定的时间
     * @param start      开始的时间范围
     * @param end        结束的时间范围
     * @param chronoUnit 判定的单位
     */
    public static boolean isBetween(Temporal time, Temporal start, Temporal end, ChronoUnit chronoUnit) {
        end = end.minus(1, chronoUnit);
        if (chronoUnit.between(start, end) < 0) {
            return chronoUnit.between(start, time) * chronoUnit.between(end, time) > 0;
        } else {
            return chronoUnit.between(start, time) * chronoUnit.between(end, time) <= 0;
        }

    }
}
