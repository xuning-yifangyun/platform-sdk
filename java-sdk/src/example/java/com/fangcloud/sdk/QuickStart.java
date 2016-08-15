package com.fangcloud.sdk;

import com.fangcloud.sdk.api.AuthApi;
import com.fangcloud.sdk.api.FileApi;
import com.fangcloud.sdk.bean.output.file.FileInfoOutput;
import com.fangcloud.sdk.core.Connection;

import java.net.URL;

/**
 * Created by xuning on 2016/8/12.
 * 快速实践
 */
public class QuickStart {

    public static void main(String[] args) {

        //这些参数可以也可以用配置文件的方式读取
        String clientId = "youClientID";
        String clientSecret = "youClientSecret";
        String rediectUrl = "youRedirectURL";

        Connection connection = null;

        connection = new Connection(clientId, clientSecret, rediectUrl);

        AuthApi authApi = new AuthApi(connection);
        URL authCode = authApi.getAuthorizeUrl();

        //获取到之后发起请求，在回调方法中获取authCode传入connection
        connection = new Connection(clientId, clientSecret, rediectUrl, authCode.toString());

        //这里拿到Connection之后进行，实例化api对象，connection为参数
        FileApi fileApi = new FileApi(connection);
        FileInfoOutput fileInfoOutput = fileApi.getFileInfo(12355L);
        //获取到返回结果
    }

}
