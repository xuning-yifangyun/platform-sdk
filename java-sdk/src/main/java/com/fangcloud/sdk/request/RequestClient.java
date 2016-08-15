package com.fangcloud.sdk.request;

import com.fangcloud.sdk.bean.exception.ExternalErrorCode;
import com.fangcloud.sdk.bean.exception.OpenApiSDKException;
import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.core.Connection;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;

import java.util.List;

/**
 * Created by xuning on 2016/8/9.
 */
public class RequestClient {
    protected HttpResponse httpResponse;
    protected HttpClient httpClient;
    protected String url;
    protected String method;
    protected List<Header> headers;
    protected List<NameValuePair> nameValuePairs;
    protected String postBody;
    protected StringEntity stringEntity;
    private Connection connection;
    public RequestClient(String url, String method, List<Header> headers) {
        this(url, method, headers, null, null);
    }

    public RequestClient(String url, String method, List<Header> headers, List<NameValuePair> nameValuePairs) {
        this(url, method, headers, nameValuePairs, null);
    }

    public RequestClient(String url, String method, List<Header> headers, List<NameValuePair> nameValuePairs, String postBody) {
        this.url = url;
        this.postBody = postBody;
        this.method = method;
        this.headers = headers;
        this.nameValuePairs = nameValuePairs;
    }

    public HttpResponse sendRequest() {
        int refreshCount=2;
        if (method.equals(Config.METHOD_GET)){
            //get方法
            RequestOperation requestOperation = new RequestGet(this);
            this.httpResponse = requestOperation.execute();
        }
        else if (method.equals(Config.METHOD_POST)) {
            //post方法
            RequestOperation requestOperation = new RequestPost(this);
            this.httpResponse = requestOperation.execute();
        }
        else if (method.equals(Config.METHOD_PUT)) {
            //put方法
            RequestOperation requestOperation = new RequestPut(this);
            this.httpResponse = requestOperation.execute();
        }
        else if (method.equals(Config.METHOD_DELETE)) {
            //delete方法
            RequestOperation requestOperation = new RequestDelete(this);
            this.httpResponse = requestOperation.execute();
        }
        else {
            throw new OpenApiSDKException(ExternalErrorCode.CONNECTION_METHOD_INVALID);

        }
        int  sendRes=httpResponse.getStatusLine().getStatusCode();

        refreshCount--;
        //如果refreshCount为1，这里通过success结果，如果为false，刷新一次Token信息，并回调此方法，
        if (refreshCount==1){
            if(sendRes!=200){

            }
        }
        refreshCount--;
        //如果为0，异常为refreshToken过期
        return httpResponse;
    }
}
