package com.fangcloud.sdk.request;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.Objects;

/**
 * Created by xuning on 2016/8/10.
 */
public class RequestGet extends RequestOperation {
    private RequestClient requestClient;
    private HttpClient httpClient;
    private HttpResponse httpResponse;

    public RequestGet(RequestClient requestClient) {
        super(requestClient);
        this.requestClient = requestClient;

    }

    @Override
    protected HttpResponse oper() {
        this.httpClient = requestClient.httpClient;
        HttpGet httpGet = new HttpGet(requestClient.url);
        if (requestClient.headers.size() > 0 && !Objects.equals(requestClient.headers, null)) {
            for (Header header : requestClient.headers) {
                httpGet.setHeader(header.getKey(), header.getValue());
            }
        }
        try {
            this.httpResponse = this.httpClient.execute(httpGet);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return this.httpResponse;
    }
}
