package com.fangcloud.sdk.core;

import com.fangcloud.sdk.util.PropertiesUtil;
import org.apache.http.HttpVersion;

import java.nio.charset.Charset;

public class Config {
    private Config() {

    }

    private static Config config = new Config();

    public static Config getConfig() {
        return config;
    }

    //auth--
    public static final String DEFAULT_AUTH_URL = "https://oauth-server.fangcloud.net/oauth";
    public static final String DEFAULT_API_URI = "https://platform.fangcloud.net/api";
    public static final String DEFAULT_GRANT_TYPE = "authorization_code";
    public static final String GRANT_TYPE_PASSWORD = "password";
    public static final boolean DELAULT_AUTO_REFRESH_TOKEN = true;
    public static int REFRESH_TOKEN_COUNT = 2;

    //system
    public static final String DEFAULT_CHARSET = "UTF-8";
    public static final Charset DEFAULT_CHARSET_TYPE = Charset.defaultCharset();

    //simple log
    public static boolean OPEN_LOG_PRINT = true;
    public static boolean OPEN_LOG_OUTPUT = true;
    public static boolean OPEN_DEBUG = false;

    public static String WIN_LOG_DIR = "/var/open-api-sdk/log/";
    public static String LINUX_LOG_DIR = "C:/var/open-api-sdk/log/";
    public static final String LOG_PATH = PropertiesUtil.isLinux() ? LINUX_LOG_DIR : WIN_LOG_DIR;

    //request
    public static final HttpVersion HTTP_VERSION = HttpVersion.HTTP_1_1;
    public static final int DEFAULT_SOCKET_TIMOUT_CHARSET = 60000;
    public static final int DEFAULT_CONNECTION_TIMOUT = 60000;
    public static final String DEFAULT_REQUEST_CHARSET = "UTF-8";
    public static final String DEFAULT_CONTENT_TYPE = "application/json";
    public static final String DEFAULT_CONTENT_VERSION_TYPE = "application/v1+json";

    //request method
    public static final String METHOD_GET = "get";
    public static final String METHOD_POST = "post";
    public static final String METHOD_PUT = "put";
    public static final String METHOD_DELETE = "delete";

    //response

    //set method

    public static void setOpenLogPrint(boolean openLogPrint) {
        OPEN_LOG_PRINT = openLogPrint;
    }

    public static void setOpenLogOutput(boolean openLogOutput) {
        OPEN_LOG_OUTPUT = openLogOutput;
    }

    public static void setWinLogDir(String winLogDir) {
        WIN_LOG_DIR = winLogDir;
    }

    public static void setLinuxLogDir(String linuxLogDir) {
        LINUX_LOG_DIR = linuxLogDir;
    }

    public static void setOpenDebug(boolean openDebug) {
        OPEN_DEBUG = openDebug;
    }
}
