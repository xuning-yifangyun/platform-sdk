package com.fangcloud.sdk.api;

import com.fangcloud.sdk.request.RequestOption;
import com.fangcloud.sdk.bean.output.auth.TokenInfo;
import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.core.Connection;
import com.fangcloud.sdk.request.Header;
import com.fangcloud.sdk.request.RequestClient;
import com.fangcloud.sdk.util.CommonUtil;
import com.fangcloud.sdk.util.RequestUtil;
import com.fangcloud.sdk.util.TransformationUtil;
import com.fangcloud.sdk.util.UrlTemplate;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by xuning on 2016/8/10.
 * 权限类别接口
 */
public class AuthApi {
    private static Connection connection=Connection.getConnection();
    private static final UrlTemplate GET_AUTH_URI = new UrlTemplate("/authorize");
    private static final UrlTemplate TOKEN_URL = new UrlTemplate("/token");
    private static ArrayList<Header> headers;
    private static ArrayList<NameValuePair> nameValuePairs = new ArrayList<>();
    private AuthApi authApi=new AuthApi();
    private AuthApi(){}
    public AuthApi getAuthApi(){
        return authApi;
    }
    /**
     * 发起授权请求，获取授权url，改为发送请求
     *
     * @return URL
     */

    public static void getAuthorizeUrl() {
        URL url = null;
        String urlString = GET_AUTH_URI.build(Config.DEFAULT_AUTH_URL);
        String queryPrame = String
                .format("?client_id=%s&redirect_uri=%s&response_type=%s&state=", connection.getClientId(), connection.getRedirectUrl(), "code");
        String res = urlString + queryPrame;
        try {
            url = new URL(res);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        RequestClient requestClient = RequestClient.buildRequest(url.toString(), "get", null, null, null);
        requestClient.sendRequest();
    }

    /**
     * 通过授权码获取Token
     *
     * @param
     * @return
     */
    public static TokenInfo getTokenByAuthCode(String... authCodes) {
        String authCodeRes = connection.getAuthCode();
        if (!CommonUtil.checkObjectsInvoke(authCodeRes)) {
            authCodeRes = CommonUtil.checkObjectsInvoke(authCodes) ? authCodes[0] : null;
        }
        //这里如果出现是空的情况，那么需要接住。并且处理
        connection.setAuthCode(authCodeRes);
        String url = TOKEN_URL.build(Config.DEFAULT_AUTH_URL);
        NameValuePair nameValuePair1 = new BasicNameValuePair("grant_type", Config.DEFAULT_GRANT_TYPE);
        NameValuePair nameValuePair2 = new BasicNameValuePair("code", authCodeRes);
        NameValuePair nameValuePair3 = new BasicNameValuePair("redirect_uri", connection.getRedirectUrl());
        headers = RequestOption.getAuthHeaders(connection);
        nameValuePairs = RequestUtil.addToNameValuePairList(nameValuePair1, nameValuePair2, nameValuePair3);
        RequestClient requestClient = RequestClient.buildRequest(url, "post", headers, nameValuePairs);
        TokenInfo tokenOutput = (TokenInfo) TransformationUtil.requestClientToOutputObject(requestClient, TokenInfo.class);
        return tokenOutput;
    }

    /**
     * 刷新Token
     *
     * @return
     */
    public static TokenInfo getTokenByRefreshToken(String... refreshtokens) {
        String refreshTokenRes = connection.getRefreshToken();
        if (refreshtokens.length > 0) {
            refreshTokenRes = CommonUtil.checkObjectsInvoke(refreshTokenRes) ? refreshTokenRes : refreshtokens[0];
        }
        String url = TOKEN_URL.build(Config.DEFAULT_AUTH_URL);
        NameValuePair nameValuePair1 = new BasicNameValuePair("grant_type", "refresh_token");
        NameValuePair nameValuePair2 = new BasicNameValuePair("refresh_token", refreshTokenRes);
        headers = RequestOption.getAuthHeaders(connection);
        nameValuePairs = RequestUtil.addToNameValuePairList(nameValuePair1, nameValuePair2);
        RequestClient requestClient = RequestClient.buildRequest(url, "post", headers, nameValuePairs);
        TokenInfo tokenOutput = (TokenInfo) TransformationUtil.requestClientToOutputObject(requestClient, TokenInfo.class);
        if (CommonUtil.checkObjectsInvoke(tokenOutput.getAccessToken())) {
            //已经成功获取了新的Token，需要放入Connection
            connection.setAccessToken(tokenOutput.getAccessToken());
        }
        else {
            //refreshToken过期，需要抛出处理
        }
        return tokenOutput;
    }

    /**
     *重建Token
     */
    public static void rebuildAccessToken(){
        //拿到regreshToken
        String reRefreshToken=connection.getRefreshToken();
        if(null!=reRefreshToken){
            TokenInfo tokenOutput=getTokenByRefreshToken(reRefreshToken);
            connection.setAccessToken(tokenOutput.getAccessToken());
        }else{
            //获取refreshToken异常,说明Token已经失效
        }
    }

}
