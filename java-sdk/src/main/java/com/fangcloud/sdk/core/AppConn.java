package com.fangcloud.sdk.core;

/**
 * Created by xuning on 2016/9/8.
 */
public class AppConn {
    private String accessToken;
    private String refreshToken;
    private int expirseIn;
    private static AppInfo appInfo;
    public AppConn(AppInfo appInfo){
        this.appInfo=appInfo;
    }




}
