package com.fangcloud.sdk.core;

/**
 * Created by xuning on 2016/9/8.
 */
public final class AppInfo {
    private static String clientId;
    private static String clientSecret;
    private static String redirectUrl;
    private static int refreshCount = Config.REFRESH_TOKEN_COUNT;
    private static boolean autoRefresh = Config.DELAULT_AUTO_REFRESH_TOKEN;
    private static AppInfo appInfo = new AppInfo();

    public static AppInfo build(String clientId, String clientSecret, String redirectUrl) {
        appInfo.setClientId(clientId);
        appInfo.setClientSecret(clientSecret);
        appInfo.setRedirectUrl(redirectUrl);
        return appInfo;
    }

    public static String getClientId() {
        return clientId;
    }

    public static void setClientId(String clientId) {
        AppInfo.clientId = clientId;
    }

    public static String getClientSecret() {
        return clientSecret;
    }

    public static void setClientSecret(String clientSecret) {
        AppInfo.clientSecret = clientSecret;
    }

    public static String getRedirectUrl() {
        return redirectUrl;
    }

    public static void setRedirectUrl(String redirectUrl) {
        AppInfo.redirectUrl = redirectUrl;
    }
}
