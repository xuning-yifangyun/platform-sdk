package com.fangcloud.sdk.request;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by xuning on 2016/8/10.
 */
public abstract class RequestOperation {
    private RequestClient requestClient;

    public RequestOperation() {
        requestClient = RequestClient.getRequestClient();
    }

    protected void openHttpClient() {
        this.requestClient.setHttpClient(new DefaultHttpClient());
    }

    protected abstract HttpResponse oper();

    protected void closeHttpClient() {
        this.requestClient.getHttpClient().getConnectionManager().shutdown();
    }

    public HttpResponse execute() {
        openHttpClient();

        requestClient.setHttpResponse(oper());

        closeHttpClient();

        return requestClient.getHttpResponse();
    }
}
