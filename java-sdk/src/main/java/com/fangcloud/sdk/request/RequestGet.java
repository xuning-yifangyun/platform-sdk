package com.fangcloud.sdk.request;

import com.fangcloud.sdk.bean.exception.ExternalErrorCode;
import com.fangcloud.sdk.bean.exception.OpenApiSDKException;
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
    private int sendRes;
    public RequestGet() {
        this.requestClient = RequestClient.getRequestClient();
        this.headers = requestClient.getHeaders();
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

            int sendRes = httpResponse.getStatusLine().getStatusCode();
        }
        catch (IOException e) {
            System.out.println(sendRes);
            throw new OpenApiSDKException(ExternalErrorCode.EXTERNAL_LOGIN_PASSWORD_ERROR + " is:", sendRes, null);
        }catch (NullPointerException n){
            System.out.println("空指针异常");
        }
        return this.httpResponse;
    }
}
