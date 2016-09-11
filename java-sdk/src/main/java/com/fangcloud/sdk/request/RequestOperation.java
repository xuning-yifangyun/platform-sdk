package com.fangcloud.sdk.request;

import com.fangcloud.sdk.bean.exception.ExternalErrorCode;
import com.fangcloud.sdk.bean.exception.OpenApiSDKException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.util.Objects;

/**
 * Created by xuning on 2016/8/10.
 */
public abstract class RequestOperation {
    protected CloseableHttpClient httpClient = null;

    protected void openHttpClient() {
        this.httpClient = HttpClients.createDefault();
    }

    protected abstract CloseableHttpResponse oper();

    protected void closeHttpClient() {
        if (!Objects.equals(null, httpClient)) {
            try {
                httpClient.close();
            }
            catch (Exception e) {
                throw new OpenApiSDKException(ExternalErrorCode.HTTP_CLIENT_CLOSE_EXCEPTION);
            }
        }
    }

    public HttpResponse execute() {
        openHttpClient();
        HttpResponse httpResponse = oper();
        if(!httpResponse.getEntity().getContentType().getValue().split(";")[0].equals("image/jpeg")){
            closeHttpClient();
        }
        return httpResponse;
    }

}
