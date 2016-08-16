package com.fangcloud.sdk;

import com.fangcloud.sdk.api.AuthApi;
import com.fangcloud.sdk.core.Connection;
import org.junit.Test;

/**
 * Created by xuning on 2016/8/10.
 */
public class TApiAuth {
    public String clientId = "bbe8e63d-89b0-4f31-ba07-5fd602d501d8";
    public String clientSecret = "5c179dfe-0f5a-4124-9690-42b69ec3aef7";
    public String rediectUrl = "http://121.41.52.18:8080/callback";
    public Connection connection=Connection.buildConnection(clientId,clientSecret,rediectUrl).getConnection();

    /**
     * 获取Auth URL
     */
    @Test
    public void TGetAuthUrl() {

    }

    /**
     * 通过授权码获取Token
     */
    @Test
    public void TGteToken() {
        String authCode = "WMgruh";
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
        String authCode = "5Gs7br";
        connection= connection.getAccessTokenByAuthCode(authCode);
        System.out.println("获取的Token是："+connection.getAccessToken());
        AuthApi.rebuildAccessToken();
        System.out.println("获取到最新的Token是：" + connection.getAccessToken());
    }

//    /**
//     * 自动根据授权码获取Token
//     * 备注，如测试需要手动传入授权码
//     */
//    @Test
//    public void TConnection() {
//        String authCode = "81AhY0";
//        Connection connection = new Connection(clientId, clientSecret, rediectUrl, authCode);
//        System.out.println(connection.getAccessToken());
//    }
}

