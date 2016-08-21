package com.fangcloud.sdk.bean.T_1.factory;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by xuning on 2016/8/10.
 */
public abstract class RequestAction implements com.fangcloud.sdk.bean.T_1.factory.RequestClient {

    protected HttpClient httpClient;


    public void getHttpConnection() {
        httpClient = new DefaultHttpClient();
    }

    public void closeConnection() {
        httpClient.getConnectionManager().shutdown();
    }

    public abstract HttpResponse oper();

    public HttpResponse execute(){
        getHttpConnection();
        HttpResponse httpResponse=oper();
        closeConnection();
        return httpResponse;
    }
}
