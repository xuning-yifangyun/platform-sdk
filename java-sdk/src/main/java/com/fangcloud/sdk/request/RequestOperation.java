package com.fangcloud.sdk.request;

import com.fangcloud.sdk.bean.exception.ExternalErrorCode;
import com.fangcloud.sdk.bean.exception.OpenApiSDKException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import java.util.Objects;

/**
 * Created by xuning on 2016/8/10.
 */
public abstract class RequestOperation {
    protected HttpClient httpClient = null;

    protected void openHttpClient() {
        this.httpClient = new DefaultHttpClient();
    }

    protected abstract HttpResponse oper();

    protected void closeHttpClient() {
        if (!Objects.equals(null, httpClient)) {
            try {
                this.httpClient.getConnectionManager().shutdown();
            }
            catch (Exception e) {
                throw new OpenApiSDKException(ExternalErrorCode.HTTP_CLIENT_CLOSE_EXCEPTION);
            }
        }
    }

    public HttpResponse execute() {
        HttpResponse httpResponse = null;
        openHttpClient();
        httpResponse = oper();
        closeHttpClient();
        return httpResponse;
    }

}
