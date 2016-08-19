package com.fangcloud.sdk;
import com.fangcloud.sdk.api.AuthApi;
import com.fangcloud.sdk.api.FileApi;
import com.fangcloud.sdk.core.Connection;
public class QuickStart {
    public static Connection connection=null;
    public static void main(String[] args) {
        connection = Connection.getConnection().buildConnection("clientId", "clientSecret", "rediectUrl");
        AuthApi.getTokenByAuthCode("you authcode");
        FileApi.getFileInfo(0);
    }
}
