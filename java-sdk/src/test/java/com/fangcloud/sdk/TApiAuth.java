package com.fangcloud.sdk;

import com.fangcloud.sdk.api.AuthApi;
import com.fangcloud.sdk.core.Connection;
import org.junit.Test;

/**
 * Created by xuning on 2016/8/10.
 */
public class TApiAuth {
    public static final String testClientID = "bbe8e63d-89b0-4f31-ba07-5fd602d501d8";
    public static final String testClientSecret = "5c179dfe-0f5a-4124-9690-42b69ec3aef7";
    public static final String testRediectUrl = "http://121.41.52.18:8080/callback";
    public static final String TestRefreshToken = "bceecd8b-ba45-4aca-8c4e-a80ed253f9f2";
    private static Connection connection = Connection.buildConnection(testClientID, testClientSecret, testRediectUrl);

    public  TApiAuth(){
    }
    /**
     * 获取Auth URL
     */
    @Test
    public void TGetAuthUrl() {
        //临时测试
        //https://oauth-server.fangcloud.net/oauth/authorize?client_id=bbe8e63d-89b0-4f31-ba07-5fd602d501d8&redirect_uri=http://121.41.52.18:8080/callback&response_type=code&state=
    }

    /**
     * 测试授权接口
     * 通过授权码获取Token
     */
    @Test
    public void TGteToken() {
        String authCode = "smxSty";
        connection= connection.getAccessTokenByAuthCode(authCode);
        System.out.println("获取的Token是："+connection.getAccessToken());
        System.out.println("获取的refreshToken是："+connection.getRefreshToken());
    }

    /**q
     * 刷新Token
     * 需要setResreshToken
     */
    @Test
    public void TGetTokenByRefersh() {
        connection.setRefreshToken(TestRefreshToken);
        AuthApi.rebuildAccessToken();
        System.out.println("获取到最新的Token是：" + connection.getAccessToken());
    }
}

