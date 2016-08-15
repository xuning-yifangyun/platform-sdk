package com.fangcloud.sdk.core;

import org.apache.http.HttpVersion;

import java.nio.charset.Charset;

/**
 * OpenApi-Java--SDK配置文件
 * 注意：部署到生产环境需要修改DEFAULT_AUTH_URL和DEFAULT_API_URI
 * 删除TestAccessToken
 */
public class Config {
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
    public static final String TestAccessToken = "d930b17b-bab2-40e8-8022-92a3bcc7348a";
}
