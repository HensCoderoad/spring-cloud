package com.shiro.jpa.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期转换类
 */
public class DateUtil {

    public static Date parse(Long time){
        Date date = new Date(time);
        return date;
    }

    public static Long timeDifferLong(Long startTime, Long finishTime){
        return finishTime - startTime;
    }
}
