package com.fangcloud.sdk.core;

import com.fangcloud.sdk.api.AuthApi;
import com.fangcloud.sdk.bean.output.auth.TokenInfo;
import org.apache.commons.codec.binary.Base64;

/**
 * Created by xuning on 2016/8/9.
 */
public class Connection {

    private static String ClientId;
    private static String ClientSecret;
    private static String authCode;
    private static String redirectUrl;
    private static String accessToken;
    private static String refreshToken;
    private static String username;
    private static String password;
    private static String apiKey;
    private static Boolean autoRefresh;
    private static int refreshCount;
    private static Connection connection=new Connection();

    private Connection(){}

    /***
     * 不使用懒加载
     * @return
     */
    public static Connection getConnection(){
        return connection;
    }

    public static Connection buildConnection(String clientId, String clientSecret, String redirectUrl){
        refreshCount=Config.REFRESH_TOKEN_COUNT;
        autoRefresh=Config.DELAULT_AUTO_REFRESH_TOKEN;
        connection.setClientId(clientId);
        connection.setClientSecret(clientSecret);
        connection.setRedirectUrl(redirectUrl);
        return connection;
    }

    public static Connection getAccessTokenByAuthCode(String authCode){
        TokenInfo tokenInfo=AuthApi.getTokenByAuthCode(authCode);
        connection.setAccessToken(tokenInfo.getAccessToken());
        connection.setRefreshToken(tokenInfo.getRefreshToken());
        return connection;
    }

    public static Connection refreshAccessToken(){
        AuthApi.rebuildAccessToken();
        return connection;
    }



    public String getAuthorizationBase64() {
        return Base64.encodeBase64String((this.ClientId + ":" + this.ClientSecret).getBytes());
    }

    public String getClientId() {
        return ClientId;
    }

    public void setClientId(String clientId) {
        ClientId = clientId;
    }

    public String getClientSecret() {
        return ClientSecret;
    }

    public void setClientSecret(String clientSecret) {
        ClientSecret = clientSecret;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Boolean getAutoRefresh() {
        return autoRefresh;
    }

    public void setAutoRefresh(Boolean autoRefresh) {
        this.autoRefresh = autoRefresh;
    }

    public int getRefreshCount() {
        return refreshCount;
    }

    public void setRefreshCount(int refreshCount) {
        this.refreshCount = refreshCount;
    }
}
