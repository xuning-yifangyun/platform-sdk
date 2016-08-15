package com.fangcloud.sdk.api;

import com.fangcloud.sdk.request.RequestOption;
import com.fangcloud.sdk.bean.output.auth.TokenOutput;
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
    private Connection connection;
    private static final UrlTemplate GET_AUTH_URI = new UrlTemplate("/authorize");
    private static final UrlTemplate TOKEN_URL = new UrlTemplate("/token");
    private ArrayList<Header> headers = new ArrayList<>();
    private ArrayList<NameValuePair> nameValuePairs = new ArrayList<>();

    public AuthApi(Connection connection) {
        this.connection = connection;
    }

    /**
     * 发起授权请求，获取授权url
     *
     * @return URL
     */
    public URL getAuthorizeUrl() {
        URL url = null;
        String urlString = GET_AUTH_URI.build(Config.DEFAULT_AUTH_URL);
        String queryPrame = String
                .format("?client_id=%s&redirect_uri=%s&response_type=%s&state=", this.connection.getClientId(), this.connection.getRedirectUrl(), "code");
        String res = urlString + queryPrame;
        try {
            url = new URL(res);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    /**
     * 通过授权码获取Token
     *
     * @param
     * @return
     */
    public TokenOutput getTokenByAuthCode(String... authCodes) {
        String authCodeRes = this.connection.getAuthCode();
        if (!CommonUtil.checkObjectsInvoke(authCodeRes)) {
            authCodeRes = CommonUtil.checkObjectsInvoke(authCodes) ? authCodes[0] : null;
        }
        //这里如果出现是空的情况，那么需要接住。并且处理
        this.connection.setAuthCode(authCodeRes);
        String url = TOKEN_URL.build(Config.DEFAULT_AUTH_URL);
        NameValuePair nameValuePair1 = new BasicNameValuePair("grant_type", Config.DEFAULT_GRANT_TYPE);
        NameValuePair nameValuePair2 = new BasicNameValuePair("code", authCodeRes);
        NameValuePair nameValuePair3 = new BasicNameValuePair("redirect_uri", this.connection.getRedirectUrl());
        headers = RequestOption.getAuthHeaders(this.connection);
        nameValuePairs = RequestUtil.addToNameValuePairList(nameValuePair1, nameValuePair2, nameValuePair3);
        RequestClient requestClient = new RequestClient(url, "post", headers, nameValuePairs);
        TokenOutput tokenOutput = (TokenOutput) TransformationUtil.requestClientToOutputObject(requestClient, TokenOutput.class);
        return tokenOutput;
    }

    /**
     * 刷新Token
     *
     * @return
     */
    public TokenOutput getTokenByRefreshToken(String... refreshtokens) {
        String refreshTokenRes = this.connection.getRefreshToken();
        if (refreshtokens.length > 0) {
            refreshTokenRes = CommonUtil.checkObjectsInvoke(refreshTokenRes) ? refreshTokenRes : refreshtokens[0];
        }
        String url = TOKEN_URL.build(Config.DEFAULT_AUTH_URL);
        NameValuePair nameValuePair1 = new BasicNameValuePair("grant_type", "refresh_token");
        NameValuePair nameValuePair2 = new BasicNameValuePair("refresh_token", refreshTokenRes);
        headers = RequestOption.getAuthHeaders(this.connection);
        nameValuePairs = RequestUtil.addToNameValuePairList(nameValuePair1, nameValuePair2);
        RequestClient requestClient = new RequestClient(url, "post", headers, nameValuePairs);
        TokenOutput tokenOutput = (TokenOutput) TransformationUtil.requestClientToOutputObject(requestClient, TokenOutput.class);
        if (CommonUtil.checkObjectsInvoke(tokenOutput.getAccessToken())) {
            //已经成功获取了新的Token，需要放入Connection
            this.connection.setAccessToken(tokenOutput.getAccessToken());
        }
        else {
            //refreshToken过期，需要抛出处理
        }
        return tokenOutput;
    }

    /**
     *重建Token
     */
    public void rebuidAccessToken(){
        //拿到regreshToken
        String reRefreshToken=this.connection.getRefreshToken();
        if(null!=reRefreshToken){
            TokenOutput tokenOutput=getTokenByRefreshToken(reRefreshToken);
            this.connection.setAccessToken(tokenOutput.getAccessToken());
        }else{
            //获取refreshToken异常,说明Token已经失效
        }
    }

}
