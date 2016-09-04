package com.fangcloud.sdk.request;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by xuning on 2016/8/10.
 */
public abstract class RequestOperation {
    protected HttpClient httpClient=null;

    protected void openHttpClient() {
        this.httpClient=new DefaultHttpClient();
    }

    protected abstract HttpResponse oper();

    protected void closeHttpClient() {
        this.httpClient.getConnectionManager().shutdown();
    }

    public HttpResponse execute() {
        HttpResponse httpResponse=null;
        openHttpClient();
        httpResponse=oper();
        closeHttpClient();
        return httpResponse;
    }

}
