package com.fangcloud.sdk;

import com.fangcloud.sdk.api.AuthApi;
import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.core.Connection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuning on 2016/8/26.
 */
public class FThreadRequest {
    public static final String testClientID = "bbe8e63d-89b0-4f31-ba07-5fd602d501d8";
    public static final String testClientSecret = "5c179dfe-0f5a-4124-9690-42b69ec3aef7";
    public static final String testRediectUrl = "http://121.41.52.18:8080/callback";
    public static final String TestRefreshToken = "bceecd8b-ba45-4aca-8c4e-a80ed253f9f2";
    private static Connection connection = Connection.buildConnection(testClientID, testClientSecret, testRediectUrl);
    public long testFileId = 501000483684L;

    public static void main(String[] args) {

//        connection.setAccessToken("2351585f-1107-43e9-a9fb-0ab75fa18211");
//        connection.setExpiresIn(25000);
//        Config.setAllowOutputJsonResult(true);
        connection.setRefreshToken(TestRefreshToken);
//        AuthApi.getTokenByRefreshToken(TestRefreshToken);
//        AuthApi.getTokenByRefreshToken(TestRefreshToken);
//        AuthApi.getTokenByAuthCode("SyDfdS");
        Config.openDebug();
        int threadSize=10;
        List<ATT> attList=new ArrayList<>();
        for(int i=0; i < threadSize; i++){
            ATT att=new ATT((i+1)+"号线程：");
            attList.add(att);
        }
        for(int i = 0; i < threadSize; i++){
            Thread thread=new Thread(attList.get(i));
            thread.start();
        }
    }
}