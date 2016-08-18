package com.fangcloud.sdk.request;

import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.core.Connection;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by xuning on 2016/8/9.
 */
public class RequestClient {
    private HttpResponse httpResponse;
    private static HttpClient httpClient;
    private static String url;
    private static String method;
    private static List<Header> headers;
    private static List<NameValuePair> nameValuePairs;
    private static String postBody;
    private static StringEntity stringEntity;
    private static RequestOperation requestOperation;
    private static Connection connection=Connection.getConnection();
    private static RequestClient requestClient = new RequestClient();
    private static RequestClient[] requestClients=new  RequestClient[3];
    private static final Logger LOGGER = Logger.getLogger(RequestClient.class.getName());
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
        requestClient.setUrl(url);
        requestClient.setPostBody(postBody);
        requestClient.setMethod(method);
        requestClient.setHeaders(headers);
        requestClient.setNameValuePairs(nameValuePairs);
        return requestClient;
    }


    public HttpResponse sendRequest() {
        while ((Config.REFRESH_TOKEN_COUNT--)>0){
            if (method.equals(Config.METHOD_GET)) {
                requestOperation = new RequestGet();
            }
            else if (method.equals(Config.METHOD_POST)) {
                requestOperation = new RequestPost();
            }
            else if (method.equals(Config.METHOD_PUT)) {
                requestOperation = new RequestPut();
            }
            else if (method.equals(Config.METHOD_DELETE)) {
                requestOperation = new RequestDelete();
            }
            httpResponse = requestOperation.execute();
            int sendRes=httpResponse.getStatusLine().getStatusCode();
//            System.out.println("请求资源获取到响应码："+sendRes);
            //这里accesstokendier
            logRequest(this);
            if(sendRes==401){
                //只有在非oauth请求下为执行有效
                connection.tryRefreshToken();
                headers=RequestOption.getApiCommonHeader(Connection.getConnection());
            }else{
                return httpResponse;
            }

        }
        return httpResponse;
    }

    private void logRequest(RequestClient connection) {
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, this.toString());
        }
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
