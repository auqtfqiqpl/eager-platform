package com.jx.agile.core.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {

    /**
     * 将Throwable异常转换为字符串.
     *
     * @param cause 需要转换的异常
     * @return 转换后的异常字符串
     */
    public static String transform(final Throwable cause) {
        if (null == cause) {
            return "";
        }
        StringWriter result = new StringWriter();
        try (PrintWriter writer = new PrintWriter(result)) {
            cause.printStackTrace(writer);
        }
        return result.toString();
    }
}
