package com.fangcloud.sdk;

import com.fangcloud.sdk.core.Connection;

/**
 * Created by xuning on 2016/8/12.
 * 快速实践
 */
public class QuickStart {

    public static void main(String[] args) {

        //这些参数可以也可以用配置文件的方式读取
        String clientId = "bbe8e63d-89b0-4f31-ba07-5fd602d501d8";
        String clientSecret = "5c179dfe-0f5a-4124-9690-42b69ec3aef7";
        String rediectUrl = "http://121.41.52.18:8080/callback";
        //       先构建client的基本信息
        Connection connection = Connection.getConnection().buildConnection(clientId, clientSecret, rediectUrl);
//        connection.
        System.out.println(connection.getClientId());

        //获取到返回结果
    }

}
