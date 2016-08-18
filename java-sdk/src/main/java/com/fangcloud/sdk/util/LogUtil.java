package com.fangcloud.sdk.util;

import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.request.RequestClient;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.MemoryHandler;

/**
 * Created by xuning on 2016/8/17.
 */
public class LogUtil {
    public static final int NUM_LINES = 100000;
    private static LogUtil logUtil = new LogUtil();
    public FileHandler fhandler;
    Logger logger;
    MemoryHandler mhandler;
    private LogUtil() {

    }

    public static LogUtil getLogUtil() {
        return logUtil;
    }

    public void createLogFolder(String log) {
        if (!Config.LOG_PATH.equals("")&&null!=Config.LOG_PATH&&(!(Config.OPEN_LOG_OUTPUT==false))) {
            File file = new File(Config.LOG_PATH);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        try {
            fhandler = new FileHandler(Config.LOG_PATH  + LogUtil.formateTime(System.currentTimeMillis(), "yyyy_MM_dd") + ".log");
            mhandler = new MemoryHandler(fhandler, NUM_LINES, Level.OFF);
            // 构造一个记录器
            logger = Logger.getLogger("requestClient");
            // 为记录器添加一个MemoryHandler


            mhandler.push();

        }
        catch (IOException e) {
            e.printStackTrace();
        }finally {
            mhandler.close();
        }


    }

    public void printLog(String log) {
        Logger logger = Logger.getLogger(RequestClient.class.getName());
        if (Config.OPEN_LOG_PRINT) {
            logger.info(log);
        }
        if (Config.OPEN_LOG_OUTPUT) {
            createLogFolder(log);
        }

    }

    public static String formateTime(long milliseconds, String timeFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(timeFormat);
        Date date = new Date(milliseconds);
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        String time = formatter.format(date);
        return time;
    }


    class MyLogHander extends Formatter {
        @Override
        public String format(LogRecord record) {
            return record.getLevel() + ":" + record.getMessage()+"\n";
        }
    }
}
