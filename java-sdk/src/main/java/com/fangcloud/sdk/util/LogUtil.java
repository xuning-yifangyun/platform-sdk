package com.fangcloud.sdk.util;

/**
 * Created by xuning on 2016/8/17.
 */
public class LogUtil {
    private static LogUtil logUtil =new LogUtil();
    private LogUtil(){

    }
    public static LogUtil getLogUtil(){
        return logUtil;
    }
//
//    public static void InitLogEnver(){
//        try {
//
//            // 构造名为my.log的日志记录文件
//            if (!Config.LOG_PATH.equals("")) {
//                File file = new File(Config.LOG_PATH);
//                if (!file.exists()) {
//                    file.mkdir();
//                }
//            }
//        }
//    }

    public static void printLog(){

    }

}
