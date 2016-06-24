package com.yzw.timer.util;

import org.apache.log4j.Logger;

/**
 * Created by BoYang on 2015/10/30.
 */
public class LogUtil {
    protected static Logger log = Logger.getLogger(LogUtil.class);

    public static void info(String msg) {
        log.info(msg);
    }

    public static void debug(String msg) {
        log.debug(msg);
    }

    public static void error(String msg) {
        log.error(msg);
    }

    public static void error(String msg, Throwable e) {
        StringBuilder sb = new StringBuilder(msg);
        for (StackTraceElement stackTraceElement : e.getStackTrace()) {
            sb.append("\r\n").append(stackTraceElement.toString());
        }
        log.error(sb.toString());
    }
}
