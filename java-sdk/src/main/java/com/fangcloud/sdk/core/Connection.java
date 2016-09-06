package com.fangcloud.sdk.core;

import com.fangcloud.sdk.api.AuthApi;
import com.fangcloud.sdk.bean.exception.ExternalErrorCode;
import com.fangcloud.sdk.bean.exception.OpenApiSDKException;
import com.fangcloud.sdk.bean.output.auth.TokenInfo;
import com.fangcloud.sdk.request.Header;
import com.fangcloud.sdk.request.RequestOption;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by xuning on 2016/8/9.
 */
public class Connection {

    private static String clientId;
    private static String clientSecret;
    private String authCode;
    private static String redirectUrl;
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

    public static Connection refreshAccessToken() {
        AuthApi.rebuildAccessToken();
        return connection;
    }

    /**
     * 独立不为单例刷新Token，仅做Token失效刷新使用
     * 需要进一步优化此方法代码
     */
    public synchronized static void tryRefreshToken() {
        HttpClient httpClient = null;
        try {
            httpClient = new DefaultHttpClient();
            String url = AUTH.build(Config.DEFAULT_AUTH_URL);
            NameValuePair nameValuePair1 = new BasicNameValuePair("grant_type", "refresh_token");
            String refreshToken = connection.getRefreshToken();
            if (refreshToken == null) {
                throw new OpenApiSDKException(ExternalErrorCode.REFRESH_TOKEN_IS_NULL);
            }
            NameValuePair nameValuePair2 = new BasicNameValuePair("refresh_token", refreshToken);
            List<NameValuePair> nameValuePairs = RequestUtil.addToNameValuePairList(nameValuePair1, nameValuePair2);
            HttpPost httpPost = new HttpPost(url);

            List<Header> headers = RequestOption.getApiCommonHeader(Connection.getConnection());
            httpPost.setHeader("Authorization", "Basic " + connection.getAuthorizationBase64());
            HttpEntity stringEntity = new UrlEncodedFormEntity(nameValuePairs, "UTF-8");
            httpPost.setEntity(stringEntity);
            HttpResponse httpResponse = null;
            httpResponse = httpClient.execute(httpPost);

            if (null == httpResponse) {
                throw new OpenApiSDKException(ExternalErrorCode.REQUEST_NO_RESPONSE);
            }
//            RequestIntercept.ErrorInfoIntercept(httpResponse);
            String jsonString = TransformationUtil.httpResponseToString(httpResponse);
            TokenInfo tokenInfo = new Gson().fromJson(jsonString, TokenInfo.class);
            connection.setAccessToken(tokenInfo.getAccessToken());
            connection.setExpiresIn(tokenInfo.getExpiresIn());
            connection.setApplyTokenDate(System.currentTimeMillis());
        }
        catch (Exception e) {
            //这里需要修改
//            throw new OpenApiSDKException(e.toString());
            throw new OpenApiSDKException(ExternalErrorCode.INVALID_REFRESSH_TOKEN);
        }
        finally {
            httpClient.getConnectionManager().shutdown();
        }
    }

    public void setApplyTokenDate(long applyTokenDate) {
        this.applyTokenDate = applyTokenDate;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getAuthorizationBase64() {
        return Base64.encodeBase64String((this.clientId + ":" + this.clientSecret).getBytes());
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
