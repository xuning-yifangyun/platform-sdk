package com.fangcloud.sdk;

import com.fangcloud.sdk.api.UserApi;
import com.fangcloud.sdk.bean.output.user.GetUserInfo;
import com.fangcloud.sdk.core.Connection;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by xuning on 2016/8/12.
 */
public class TUserApi {

    public static final String testClientID = "bbe8e63d-89b0-4f31-ba07-5fd602d501d8";
    public static final String testClientSecret = "5c179dfe-0f5a-4124-9690-42b69ec3aef7";
    public static final String testRediectUrl = "http://121.41.52.18:8080/callback";
    public static final String TestRefreshToken = "bceecd8b-ba45-4aca-8c4e-a80ed253f9f2";
    private static Connection connection = Connection.buildConnection(testClientID, testClientSecret, testRediectUrl);


    public TUserApi() {
        connection.setRefreshToken(TestRefreshToken);
//        connection.setAccessToken("36120348-06f8-46dc-a7ea-8e204b23990d");
    }
        /*
     * 获取自己的信息
     */

    @Test
    public void TgetMeInfo() {

        GetUserInfo getUserInfoOutput = UserApi.getOwnInfo();
        System.out.println(getUserInfoOutput.getName());
    }

    /**
     * 获取其他用户的信息
     */
    @Test
    public void TgetMUserInfo() {
        GetUserInfo getUserInfoOutput =UserApi.getUserInfo(22149);
        System.out.println(getUserInfoOutput.getName());
    }

    /**
     * 下载头像
     */
    @Test
    public void TDownloadProfilePic() throws IOException {
        //下载的图片位于项目当前目录
        FileOutputStream fos = new FileOutputStream("1.png");
        InputStream is = UserApi.getPrifilePicDowload(22149, "b3c69fcb4a2f95fceee21f16ced8a07c");
        int ch = 0;
        try {
            while ((ch = is.read()) != -1) {
                fos.write(ch);
            }
        }
        catch (IOException e1) {
            e1.printStackTrace();
        }
        finally {
            if(null!=is){
                is.close();
            }else if (null!=fos){
                fos.close();
            }
        }
    }

}
