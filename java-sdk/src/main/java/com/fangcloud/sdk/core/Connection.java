package com.fangcloud.sdk.core;

import com.fangcloud.sdk.api.AuthApi;
import com.fangcloud.sdk.util.Base64;
import com.fangcloud.sdk.util.UrlTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xuning on 2016/8/9.
 */
public class Connection {

    private static String clientId;
    private static String clientSecret;
    private static String redirectUrl;
    private String authCode;
    private String accessToken;
    private String refreshToken;
    private long expiresIn;
    private long applyTokenDate;
    private static int refreshCount;
    private static String username;//*
    private static String password;//*
    private static String apiKey;//*
    private boolean autoRefresh;//*
    private static Connection connection = new Connection();
    private static final UrlTemplate AUTH = new UrlTemplate("/token");
    private static Logger logger = LoggerFactory.getLogger(Connection.class);

    private Connection() {
    }

    public static Connection getConnection() {
        return connection;
    }

    public static final Connection buildConnection(String clientId, String clientSecret, String redirectUrl) {
        refreshCount = Config.REFRESH_TOKEN_COUNT;
        connection.setAutoRefresh(Config.DELAULT_AUTO_REFRESH_TOKEN);
        connection.setClientId(clientId);
        connection.setClientSecret(clientSecret);
        connection.setRedirectUrl(redirectUrl);
        return connection;
    }

    //授权码接收接口
    public static Connection getAccessTokenByAuthCode(String authCode) {
        AuthApi.getTokenByAuthCode(authCode);
        return connection;
    }

    //刷新Token
    public static Connection refreshAccessToken() {
        AuthApi.rebuildAccessToken();
        return connection;
    }

    public void setApplyTokenDate(long applyTokenDate) {
        this.applyTokenDate = applyTokenDate;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getAuthorizationBase64() {
        //        return Base64.encodeBase64String((this.clientId + ":" + this.clientSecret).getBytes());
        return Base64.encode((this.clientId + ":" + this.clientSecret).getBytes());
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        Connection.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        Connection.clientSecret = clientSecret;
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

    public long getExpiresIn() {
        return expiresIn;
    }

    public long getApplyTokenDate() {
        return applyTokenDate;
    }
}
