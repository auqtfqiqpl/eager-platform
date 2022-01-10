package com.jx.agile.core.utils;

public class StringUtils{

    public static boolean isBlank(final CharSequence cs){

        if("null".equals(cs) || "NULL".equals(cs)){
            return true;
        }
        return org.apache.commons.lang3.StringUtils.isBlank(cs);
    }

    public static boolean isNotBlank(final CharSequence cs){

        if("null".equals(cs) || "NULL".equals(cs)){
            return false;
        }
        return org.apache.commons.lang3.StringUtils.isNotBlank(cs);
    }
}
