package com.fangcloud.sdk.core;

import com.fangcloud.sdk.util.PropertiesUtil;
import org.apache.http.HttpVersion;

import java.nio.charset.Charset;

/**
 * OpenApi-Java--SDK配置文件
 * 注意：部署到生产环境需要修改DEFAULT_AUTH_URL和DEFAULT_API_URI
 * 删除TestAccessToken
 */
public class Config {
    private Config(){}
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
    public static final boolean OPEN_LOG_PRINT = true;
    public static final boolean OPEN_LOG_OUTPUT = false;
    public static final String LOG_PATH= PropertiesUtil.isLinux()?"/var/log/":"C://";

    //request
    public static final HttpVersion HTTP_VERSION = HttpVersion.HTTP_1_1;
    public static final int DEFAULT_TIMOUT_CHARSET = 30000;
    public static final String DEFAULT_REQUEST_CHARSET = "UTF-8";
    public static final String DEFAULT_CONTENT_TYPE = "application/json";
    public static final String DEFAULT_CONTENT_VERSION_TYPE = "application/v1+json";

    //request method
    public static final String METHOD_GET = "get";
    public static final String METHOD_POST = "post";
    public static final String METHOD_PUT = "put";
    public static final String METHOD_DELETE = "delete";

    //response

    //Test
    public static final String testClientID = "bbe8e63d-89b0-4f31-ba07-5fd602d501d8";
    public static final String testClientSecret = "5c179dfe-0f5a-4124-9690-42b69ec3aef7";
    public static final String testRediectUrl = "http://121.41.52.18:8080/callback";
    public static final String TestRefreshToken = "bceecd8b-ba45-4aca-8c4e-a80ed253f9f2";
}
