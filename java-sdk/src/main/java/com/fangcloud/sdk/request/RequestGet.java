package com.fangcloud.sdk.request;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * Created by xuning on 2016/8/10.
 */
public class RequestGet extends RequestOperation {
    private RequestClient requestClient;
    private HttpClient httpClient;
    private HttpResponse httpResponse;
    private List<Header> headers;
    public RequestGet() {
        this.requestClient = RequestClient.getRequestClient();
        this.headers=requestClient.getHeaders();
    }

    @Override
    protected HttpResponse oper() {
        this.httpClient = requestClient.getHttpClient();
        HttpGet httpGet = new HttpGet(requestClient.getUrl());
        if (headers.size() > 0 && !Objects.equals(headers, null)) {
            for (Header header : headers) {
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
