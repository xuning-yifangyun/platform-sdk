package com.fangcloud.sdk;

import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.core.Connection;

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
        public FThreadRequest(){
            Config.setAllowOutputJsonResult(true);
            Config.setOpenLogOutput(true);
            Config.setOpenLogPrint(true);
        }

        public static void main(String[] args) {
            //获取授权码字符串：
//https://oauth-server.fangcloud.net/oauth/authorize?client_id=bbe8e63d-89b0-4f31-ba07-5fd602d501d8&redirect_uri=http://121.41.52.18:8080/callback&response_type=code&state=
//            connection.setApplyTokenDate(20000);
//            connection.setExpiresIn(100000000L);
//            connection.setAccessToken("684616b1-3d39-4c87-8ba9-b487488ed7df");

//            AuthApi.getTokenByAuthCode("NHRQjH");
//            AuthApi.getTokenByAuthCode("z86lKE");
//            AuthApi.getTokenByAuthCode("bkQgdV");

            Config.setAllowOutputJsonResult(true);
            Config.setOpenLogPrint(true);
            Config.setOpenLogOutput(true);
//            connection.setRefreshToken(TestRefreshToken);
            connection.setApplyTokenDate(1);
            connection.setAccessToken("ed759f65-a86f-47c4-8dc7-57e26e35bcbc");
            ATT a=new ATT("1号窗口");
            ATT a1=new ATT("2号窗口");
            ATT a2=new ATT("3号窗口");
            Thread thread=new Thread(a);
            Thread thread1=new Thread(a1);
            Thread thread2=new Thread(a2);
            thread.start();
            thread1.start();
            thread2.start();
        }
}




