package com.fangcloud.sdk.request;

import com.fangcloud.sdk.bean.exception.ExternalErrorCode;
import com.fangcloud.sdk.bean.exception.OpenApiSDKException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * Created by xuning on 2016/8/10.
 */
public class RequestGet extends RequestOperation {
    private String url;
    private List<Header> headers;

    public RequestGet(RequestClient requestClient) {
        this.url = requestClient.getUrl();
        this.headers =requestClient.getHeaders();
    }

    @Override
    protected HttpResponse oper() {
        HttpGet httpGet = new HttpGet(this.url);
        if (this.headers.size() > 0 && !Objects.equals(this.headers, null)) {
            for (Header header : this.headers) {
                httpGet.setHeader(header.getKey(), header.getValue());
            }
        }
        HttpResponse httpResponse=null;
        try {
            httpResponse = httpClient.execute(httpGet);
        }
        catch (IOException e) {
            int sendRes=0;
            sendRes = httpResponse.getStatusLine().getStatusCode();
            throw new OpenApiSDKException(ExternalErrorCode.EXTERNAL_LOGIN_PASSWORD_ERROR + " is:", sendRes, null);
        }
        finally {
            httpClient.getConnectionManager().shutdown();
        }
        return httpResponse;
    }
}
