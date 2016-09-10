package com.fangcloud.sdk.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xuning on 2016/8/28.
 */
public final class LogFactory {
    private static Logger logger;

    public static Logger getLogger(String loggerName) {
        logger = LoggerFactory.getLogger(loggerName);
        return logger;
    }

    public static Logger getLogger(Class classes) {
        String loggerName = classes.getName();
        return getLogger(loggerName);
    }

}
