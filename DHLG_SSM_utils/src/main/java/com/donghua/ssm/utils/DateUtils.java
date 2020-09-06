package com.donghua.ssm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    //日期转换为字符串
    public static String date2String(Date date,String patt){
        SimpleDateFormat sdf=new SimpleDateFormat(patt);
        String format=sdf.format(date);
        return  format;
    }

    //字符串转换为日期
    public static Date string2Date(Date date,String str) throws  Exception{
        SimpleDateFormat sdf=new SimpleDateFormat(str);
        Date parse=sdf.parse(str);
        return parse;
    }
}
