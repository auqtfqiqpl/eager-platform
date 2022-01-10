package com.jx.agile.core.utils;

import com.jx.agile.core.constant.DateFormatPattern;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String transform(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(DateFormatPattern.YYYYMMDDHHMMSS_ONE);
        String StringDate = sdf.format(date);
        return StringDate;
    }


    public static String transform(Date date,String datePattern){
        if(StringUtils.isBlank(datePattern)){
            return DateUtil.transform(date);
        }
        SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
        String StringDate = sdf.format(date);
        return StringDate;
    }


}
