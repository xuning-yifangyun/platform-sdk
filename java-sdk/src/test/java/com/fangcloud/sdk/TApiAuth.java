package com.fangcloud.sdk;

import com.fangcloud.sdk.api.AuthApi;
import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.core.Connection;
import org.junit.Test;

/**
 * Created by xuning on 2016/8/10.
 */
public class TApiAuth {
    public String clientId = Config.testClientID;
    public String clientSecret = Config.testClientSecret;
    public String rediectUrl = Config.testRediectUrl;
    public Connection connection=Connection.buildConnection(clientId,clientSecret,rediectUrl);

    public  TApiAuth(){
        Config.setAllowOutputJsonResult(true);
    }
    /**
     * 获取Auth URL
     */
    @Test
    public void TGetAuthUrl() {

    }

    /**
     * 测试授权接口
     * 通过授权码获取Token
     */
    @Test
    public void TGteToken() {
        String authCode = "jdcuwq";
        connection= connection.getAccessTokenByAuthCode(authCode);
        System.out.println("获取的Token是："+connection.getAccessToken());
        System.out.println("获取的refreshToken是："+connection.getRefreshToken());

    }

    /**
     * 刷新Token
     * 需要setResreshToken
     */
    @Test
    public void TGetTokenByRefersh() {
        connection.setRefreshToken(Config.TestRefreshToken);
        AuthApi.rebuildAccessToken();
        System.out.println("获取到最新的Token是：" + connection.getAccessToken());
    }

}

