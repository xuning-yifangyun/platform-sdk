package com.fangcloud.sdk;

import com.fangcloud.sdk.api.FileApi;
import com.fangcloud.sdk.bean.output.file.FileInfo;
import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.core.Connection;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by xuning on 2016/8/26.
 */
public class TThreadRequest {
    public static final String testClientID = "bbe8e63d-89b0-4f31-ba07-5fd602d501d8";
    public static final String testClientSecret = "5c179dfe-0f5a-4124-9690-42b69ec3aef7";
    public static final String testRediectUrl = "http://121.41.52.18:8080/callback";
    public static final String TestRefreshToken = "bceecd8b-ba45-4aca-8c4e-a80ed253f9f2";
    private static Connection connection = Connection.buildConnection(testClientID, testClientSecret, testRediectUrl);
    public long testFileId = 501000511232L;
    public TThreadRequest(){
        connection.setRefreshToken(TestRefreshToken);
        Config.setAllowOutputJsonResult(true);
        Config.setOpenLogOutput(true);
    }
    @Test
    public void TgetFileInfo() {
        int count=5;
        while((count--)>0){
            FileApi fileApi = new FileApi();
            FileInfo fileInfo = fileApi.getFileInfo(testFileId);
            Assert.assertEquals("出现错误", "xuning", fileInfo.getOwnedBy().getName());
            Assert.assertTrue("没有正确返回信息", fileInfo.getSuccess());
        }
    }
}
