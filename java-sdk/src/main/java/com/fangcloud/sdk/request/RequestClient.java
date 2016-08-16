package com.fangcloud.sdk.request;

import com.fangcloud.sdk.bean.exception.ExternalErrorCode;
import com.fangcloud.sdk.bean.exception.OpenApiSDKException;
import com.fangcloud.sdk.core.Config;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;

import java.util.List;

/**
 * Created by xuning on 2016/8/9.
 */
public class RequestClient {
    private HttpResponse httpResponse;
    private static HttpClient httpClient;
    private String url;
    private String method;
    private List<Header> headers;
    private List<NameValuePair> nameValuePairs;
    private String postBody;
    private StringEntity stringEntity;
    private static RequestOperation requestOperation;
    private static RequestClient requestClient = new RequestClient();

    private RequestClient() {
    }

    public static RequestClient getRequestClient() {
        return requestClient;
    }

    public static RequestClient buildRequest(String url, String method, List<Header> headers) {
        return requestClient.buildRequest(url, method, headers, null, null);
    }

    public static RequestClient buildRequest(String url, String method, List<Header> headers, List<NameValuePair> nameValuePairs) {
        return requestClient.buildRequest(url, method, headers, nameValuePairs, null);
    }

    public static RequestClient buildRequest(String url, String method, List<Header> headers, List<NameValuePair> nameValuePairs, String postBody) {
        requestClient.url = url;
        requestClient.postBody = postBody;
        requestClient.method = method;
        requestClient.headers = headers;
        requestClient.nameValuePairs = nameValuePairs;
        return requestClient;
    }

    public HttpResponse sendRequest() {
        int refreshCount = 2;
        if (method.equals(Config.METHOD_GET)) {
            //get方法
            requestOperation = new RequestGet();
        }
        else if (method.equals(Config.METHOD_POST)) {
            //post方法
            requestOperation = new RequestPost();
        }
        else if (method.equals(Config.METHOD_PUT)) {
            //put方法
            requestOperation = new RequestPut();
        }
        else if (method.equals(Config.METHOD_DELETE)) {
            //delete方法
            requestOperation = new RequestDelete();
        }
        else {
            throw new OpenApiSDKException(ExternalErrorCode.CONNECTION_METHOD_INVALID);
        }
        requestClient.httpResponse = requestOperation.execute();

        int sendRes = httpResponse.getStatusLine().getStatusCode();

        refreshCount--;
        //如果refreshCount为1，这里通过success结果，如果为false，刷新一次Token信息，并回调此方法，
        if (refreshCount == 1) {
            if (sendRes != 200) {

            }
        }
        refreshCount--;
        //如果为0，异常为refreshToken过期
        return httpResponse;
    }

    public HttpResponse getHttpResponse() {
        return httpResponse;
    }

    public void setHttpResponse(HttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    public static HttpClient getHttpClient() {
        return httpClient;
    }

    public static void setHttpClient(HttpClient httpClient) {
        RequestClient.httpClient = httpClient;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    public List<NameValuePair> getNameValuePairs() {
        return nameValuePairs;
    }

    public void setNameValuePairs(List<NameValuePair> nameValuePairs) {
        this.nameValuePairs = nameValuePairs;
    }

    public StringEntity getStringEntity() {
        return stringEntity;
    }

    public void setStringEntity(StringEntity stringEntity) {
        this.stringEntity = stringEntity;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public static RequestOperation getRequestOperation() {
        return requestOperation;
    }

    public static void setRequestOperation(RequestOperation requestOperation) {
        RequestClient.requestOperation = requestOperation;
    }
}
