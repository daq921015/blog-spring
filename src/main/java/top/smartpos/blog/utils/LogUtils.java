package top.smartpos.blog.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtils {
    private final static Logger logger = LoggerFactory.getLogger(LogUtils.class);

    public static void info(String msg) {
        logger.info(msg);
    }

    public static void info(String format, Object arg) {
        logger.info(format, arg);
    }

    public static void info(String format, Object arg1, Object arg2) {
        logger.info(format, arg1, arg2);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void warn(String format, Object arg) {
        logger.warn(format, arg);
    }

    public static void warn(String format, Object arg1, Object arg2) {
        logger.warn(format, arg1, arg2);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void error(String format, Object arg) {
        logger.error(format, arg);
    }

    public static void error(String format, Object arg1, Object arg2) {
        logger.error(format, arg1, arg2);
    }

    public static void error(String msg, Throwable t) {
        logger.error(msg, t);
    }

    public static void debug(String msg, Throwable t) {
        logger.debug(msg, t);
    }
}
