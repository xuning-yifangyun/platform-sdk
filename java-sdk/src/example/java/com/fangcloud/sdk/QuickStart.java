package com.fangcloud.sdk;

import com.fangcloud.sdk.core.Connection;

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
//       先构建client的基本信息
        Connection connection = Connection.buildConnection(clientId, clientSecret, rediectUrl);
        connection.getAccessTokenByAuthCode("");
        connection.refreshAccessToken();

        //获取到返回结果
    }

}
