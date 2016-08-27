package com.fangcloud.sdk.util;

public class Logger {
    private org.slf4j.Logger myLogger;

    public Logger(org.slf4j.Logger myLogger) {
        this.myLogger = myLogger;
    }

    public boolean isTraceEnabled() {
        return this.myLogger.isTraceEnabled();
    }

    public boolean isDebugEnabled() {
        return this.myLogger.isDebugEnabled();
    }

    public boolean isInfoEnabled() {
        return this.myLogger.isInfoEnabled();
    }

    public boolean isWarnEnabled() {
        return this.myLogger.isWarnEnabled();
    }

    public boolean isErrorEnabled() {
        return this.myLogger.isErrorEnabled();
    }

//    private String getMessage(MyUUID uuid, String message) {
//        if(uuid == null) {
//            uuid = new MyUUID();
//        }
//
//        return "[" + uuid + "] " + message;
//    }
//
//    private String getMessage(MyUUID uuid, String format, Object... args) {
//        if(uuid == null) {
//            uuid = new MyUUID();
//        }
//
//        return "[" + uuid + "] " + MessageFormatter.arrayFormat(format, args).getMessage();
//    }
//
//    public void trace(MyUUID uuid, String message) {
//        if(this.isTraceEnabled()) {
//            this.myLogger.trace(this.getMessage(uuid, message));
//        }
//
//    }
//
//    public void trace(MyUUID uuid, String message, Throwable e) {
//        if(this.isTraceEnabled()) {
//            this.myLogger.trace(this.getMessage(uuid, message), e);
//        }
//
//    }
//
//    public void trace(MyUUID uuid, String format, Object... args) {
//        if(this.isTraceEnabled()) {
//            this.myLogger.trace(this.getMessage(uuid, format, args));
//        }
//
//    }
//
//    public void trace(MyUUID uuid, Throwable e, String format, Object... args) {
//        if(this.isTraceEnabled()) {
//            this.myLogger.trace(this.getMessage(uuid, format, args), e);
//        }
//
//    }
//
//    public void debug(MyUUID uuid, String message) {
//        if(this.isDebugEnabled()) {
//            this.myLogger.debug(this.getMessage(uuid, message));
//        }
//
//    }
//
//    public void debug(MyUUID uuid, String message, Throwable e) {
//        if(this.isDebugEnabled()) {
//            this.myLogger.debug(this.getMessage(uuid, message), e);
//        }
//
//    }
//
//    public void debug(MyUUID uuid, String format, Object... args) {
//        if(this.isDebugEnabled()) {
//            this.myLogger.debug(this.getMessage(uuid, format, args));
//        }
//
//    }
//
//    public void debug(MyUUID uuid, Throwable e, String format, Object... args) {
//        if(this.isDebugEnabled()) {
//            this.myLogger.debug(this.getMessage(uuid, format, args), e);
//        }
//
//    }
//
//    public void info(MyUUID uuid, String message) {
//        if(this.isInfoEnabled()) {
//            this.myLogger.info(this.getMessage(uuid, message));
//        }
//
//    }
//
//    public void info(MyUUID uuid, String message, Throwable e) {
//        if(this.isInfoEnabled()) {
//            this.myLogger.info(this.getMessage(uuid, message), e);
//        }
//
//    }
//
//    public void info(MyUUID uuid, String format, Object... args) {
//        if(this.isInfoEnabled()) {
//            this.myLogger.info(this.getMessage(uuid, format, args));
//        }
//
//    }
//
//    public void info(MyUUID uuid, Throwable e, String format, Object... args) {
//        if(this.isInfoEnabled()) {
//            this.myLogger.info(this.getMessage(uuid, format, args), e);
//        }
//
//    }
//
//    public void warn(MyUUID uuid, String message) {
//        if(this.isWarnEnabled()) {
//            this.myLogger.warn(this.getMessage(uuid, message));
//        }
//
//    }
//
//    public void warn(MyUUID uuid, String message, Throwable e) {
//        if(this.isWarnEnabled()) {
//            this.myLogger.warn(this.getMessage(uuid, message), e);
//        }
//
//    }
//
//    public void warn(MyUUID uuid, String format, Object... args) {
//        if(this.isWarnEnabled()) {
//            this.myLogger.warn(this.getMessage(uuid, format, args));
//        }
//
//    }
//
//    public void warn(MyUUID uuid, Throwable e, String format, Object... args) {
//        if(this.isWarnEnabled()) {
//            this.myLogger.warn(this.getMessage(uuid, format, args), e);
//        }
//
//    }
//
//    public void error(MyUUID uuid, String message) {
//        if(this.isErrorEnabled()) {
//            this.myLogger.error(this.getMessage(uuid, message));
//        }
//
//    }
//
//    public void error(MyUUID uuid, String message, Throwable e) {
//        if(this.isErrorEnabled()) {
//            this.myLogger.error(this.getMessage(uuid, message), e);
//        }
//
//    }
//
//    public void error(MyUUID uuid, String format, Object... args) {
//        if(this.isErrorEnabled()) {
//            this.myLogger.error(this.getMessage(uuid, format, args));
//        }
//
//    }
//
//    public void error(MyUUID uuid, Throwable e, String format, Object... args) {
//        if(this.isErrorEnabled()) {
//            this.myLogger.error(this.getMessage(uuid, format, args), e);
//        }
//
//    }
}
