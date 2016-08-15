package com.fangcloud.sdk.core;

import com.fangcloud.sdk.api.AuthApi;
import com.fangcloud.sdk.bean.output.auth.TokenOutput;
import org.apache.commons.codec.binary.Base64;

/**
 * Created by xuning on 2016/8/9.
 */
public class Connection {
    private String ClientId;
    private String ClientSecret;
    private String authCode;
    private String redirectUrl;
    private String accessToken;
    private String refreshToken;
    private String username;
    private String password;
    private String apiKey;
    private Boolean autoRefresh;
    private int refreshCount;

    /**
     * 续爱发起授权请求的Connect
     *
     * @param clientId
     * @param clientSecret
     * @param redirectUrl
     */
    public Connection(String clientId, String clientSecret, String redirectUrl) {
        this(clientId, clientSecret, redirectUrl, null, null, null, null, null, null, null, Config.REFRESH_TOKEN_COUNT);
    }

    /**
     * 这里的实例化是获取到授权码之后的实例化
     * 这里的Connect建议写成一个单例模式，因为所有的Api实现都需要Connection
     *
     * @param clientId
     * @param clientSecret
     * @param redirectUrl
     * @param authCode
     */
    public Connection(String clientId, String clientSecret, String redirectUrl, String authCode) {
        ClientId = clientId;
        ClientSecret = clientSecret;
        this.authCode = authCode;
        this.redirectUrl = redirectUrl;
        TokenOutput tokenOutput = new AuthApi(this).getTokenByAuthCode();
        this.accessToken = tokenOutput.getAccessToken();
        this.refreshToken = tokenOutput.getRefreshToken();
        this.refreshCount = Config.REFRESH_TOKEN_COUNT;
        this.autoRefresh=Config.DELAULT_AUTO_REFRESH_TOKEN;
    }

    /**
     * 初始化所有的属性，扩展
     *
     * @param clientId
     * @param clientSecret
     * @param redirectUrl
     * @param authCode
     * @param accessToken
     * @param refreshToken
     * @param username
     * @param password
     * @param apiKey
     * @param autoRefresh
     * @param refreshCount
     */
    public Connection(String clientId, String clientSecret, String redirectUrl, String authCode, String accessToken, String refreshToken, String username,
            String password, String apiKey, Boolean autoRefresh, int refreshCount) {
        ClientId = clientId;
        ClientSecret = clientSecret;
        this.authCode = authCode;
        this.redirectUrl = redirectUrl;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.username = username;
        this.password = password;
        this.apiKey = apiKey;
        this.autoRefresh = autoRefresh;
        this.refreshCount = refreshCount;
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
