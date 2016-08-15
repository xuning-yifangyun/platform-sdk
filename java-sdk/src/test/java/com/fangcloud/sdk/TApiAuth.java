package com.fangcloud.sdk;

import com.fangcloud.sdk.api.AuthApi;
import com.fangcloud.sdk.bean.output.auth.TokenOutput;
import com.fangcloud.sdk.core.Connection;
import org.junit.Test;

import java.net.URL;

/**
 * Created by xuning on 2016/8/10.
 */
public class TApiAuth {
    public String clientId = "bbe8e63d-89b0-4f31-ba07-5fd602d501d8";
    public String clientSecret = "5c179dfe-0f5a-4124-9690-42b69ec3aef7";
    public String rediectUrl = "http://121.41.52.18:8080/callback";

    /**
     * 获取Auth URL
     */
    @Test
    public void TGetAuthUrl() {
        Connection connection = new Connection(clientId, clientSecret, rediectUrl);
        URL url = new AuthApi(connection).getAuthorizeUrl();
        System.out.println(url);
    }

    /**
     * 通过授权码获取Token
     */
    @Test
    public void TGteToken() {
        String authCode = "eEUB7c";
        Connection connection = new Connection(clientId, clientSecret, rediectUrl);
        TokenOutput token = new AuthApi(connection).getTokenByAuthCode(authCode);
        System.out.println("accessToken is :" + token.getAccessToken());

    }

    /**
     * 刷新Token
     * 需要setResreshToken
     */
    @Test
    public void TGetTokenByRefersh() {
        Connection connection = new Connection(clientId, clientSecret, rediectUrl);
        connection.setRefreshToken("bceecd8b-ba45-4aca-8c4e-a80ed253f9f2");
        TokenOutput token = new AuthApi(connection).getTokenByRefreshToken("bceecd8b-ba45-4aca-8c4e-a80ed253f9f2");
        System.out.println("获取到最新的Token是：" + token.getAccessToken());
        System.out.println(connection.getAccessToken());
    }

    /**
     * 自动根据授权码获取Token
     * 备注，如测试需要手动传入授权码
     */
    @Test
    public void TConnection() {
        String authCode = "81AhY0";
        Connection connection = new Connection(clientId, clientSecret, rediectUrl, authCode);
        System.out.println(connection.getAccessToken());
    }
}

