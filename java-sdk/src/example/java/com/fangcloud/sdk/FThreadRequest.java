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
        public long testFileId = 501000511232L;
    //    public FThreadRequest(){
    //        connection.setRefreshToken(TestRefreshToken);
    //        Config.setAllowOutputJsonResult(true);
    //        Config.setOpenLogOutput(true);
    //    }

        public static void main(String[] args) {
            connection.setAccessToken("be3da2b1-a0af-446c-bb58-327cca1afe89");
            Config.setAllowOutputJsonResult(true);
            Config.setOpenLogOutput(true);
            AT a=new AT("1号窗口");
            AT a1=new AT("2号窗口");
            AT a2=new AT("3号窗口");
            Thread thread=new Thread(a);
            Thread thread1=new Thread(a1);
            Thread thread2=new Thread(a2);
            thread.start();
            thread1.start();
            thread2.start();
        }
}




