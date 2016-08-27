package com.fangcloud.sdk.core;

import com.fangcloud.sdk.api.AuthApi;
import com.fangcloud.sdk.bean.exception.ExternalErrorCode;
import com.fangcloud.sdk.bean.exception.OpenApiSDKException;
import com.fangcloud.sdk.bean.output.auth.TokenInfo;
import com.fangcloud.sdk.util.RequestUtil;
import com.fangcloud.sdk.util.TransformationUtil;
import com.fangcloud.sdk.util.UrlTemplate;
import com.google.gson.Gson;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by xuning on 2016/8/9.
 */
public class Connection {

    private static String ClientId;
    private static String ClientSecret;
    private String authCode;
    private static String redirectUrl;
    private String accessToken;
    private static String refreshToken;
    private static String username;
    private static String password;
    private static String apiKey;
    private static Boolean autoRefresh;
    private static int refreshCount;
    private static Connection connection = new Connection();
    private static final UrlTemplate AUTH = new UrlTemplate("/token");

    private Connection() {
    }

    public static Connection getConnection() {
        return connection;
    }

    public static Connection buildConnection(String clientId, String clientSecret, String redirectUrl) {
        refreshCount = Config.REFRESH_TOKEN_COUNT;
        autoRefresh = Config.DELAULT_AUTO_REFRESH_TOKEN;
        connection.setClientId(clientId);
        connection.setClientSecret(clientSecret);
        connection.setRedirectUrl(redirectUrl);
        return connection;
    }

    public static Connection getAccessTokenByAuthCode(String authCode) {
        TokenInfo tokenInfo = AuthApi.getTokenByAuthCode(authCode);
        connection.setAccessToken(tokenInfo.getAccessToken());
        connection.setRefreshToken(tokenInfo.getRefreshToken());
        return connection;
    }

    public static Connection refreshAccessToken() {
        AuthApi.rebuildAccessToken();
        return connection;
    }

    /**
     * 独立不为单例刷新Token，仅做Token失效刷新使用
     */
    public static void  tryRefreshToken() {
        HttpClient httpClient = null;
        try {
            httpClient = new DefaultHttpClient();
            String url = AUTH.build(Config.DEFAULT_AUTH_URL);
            NameValuePair nameValuePair1 = new BasicNameValuePair("grant_type", "refresh_token");
            NameValuePair nameValuePair2 = new BasicNameValuePair("refresh_token", refreshToken);
            List<NameValuePair> nameValuePairs = RequestUtil.addToNameValuePairList(nameValuePair1, nameValuePair2);
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Authorization", "Basic " + connection.getAuthorizationBase64());
            try {
                HttpEntity stringEntity = new UrlEncodedFormEntity(nameValuePairs, "UTF-8");
                httpPost.setEntity(stringEntity);
            }
            catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            HttpResponse httpResponse = null;
            try {
                httpResponse = httpClient.execute(httpPost);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            String jsonString = TransformationUtil.httpResponseToString(httpResponse);
            TokenInfo tokenInfo = new Gson().fromJson(jsonString, TokenInfo.class);
            connection.setAccessToken(tokenInfo.getAccessToken());
        }
        catch (Exception e) {
            throw new OpenApiSDKException(ExternalErrorCode.INVALID_TOKEN);
        }
        finally {
            httpClient.getConnectionManager().shutdown();
        }
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
