package com.fangcloud.sdk.bean.T_1.factory;

import com.fangcloud.sdk.bean.exception.ExternalErrorCode;
import com.fangcloud.sdk.bean.exception.OpenApiSDKException;
import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.request.Header;
import org.apache.http.NameValuePair;

import java.util.List;

public class RequestClientFactory {
    private RequestOption requestOption;
    public static RequestClient getRequestClient(String url, String method) {
        return getRequestClient(url, method, null, null, null);
    }
    public static RequestClient getRequestClient(String url, String method, List<Header> headers) {
        return getRequestClient(url, method, headers, null, null);
    }
    public static RequestClient getRequestClient(String url, String method, List<Header> headers, List<NameValuePair> nameValuePairs) {
        return getRequestClient(url, method, headers, nameValuePairs, null);
    }
    public static RequestClient getRequestClient(String url, String method, List<Header> headers, List<NameValuePair> nameValuePairs, String postBody) {
        RequestClient requestClient = null;
        RequestOption requestOption=new RequestOption(url, method, headers, nameValuePairs, postBody);
        switch (method) {
        case Config.METHOD_GET:
            requestClient = new RequestGet(requestOption);
            break;
        case Config.METHOD_POST:
            requestClient = new RequestPost(requestOption);
            break;
        case Config.METHOD_PUT:
            requestClient = new RequestPut(requestOption);
            break;
        case Config.METHOD_DELETE:
            requestClient = new RequestDelete(requestOption);
            break;
        default:
            throw new OpenApiSDKException(ExternalErrorCode.REQUEST_METHOD_ERROR);
        }
        return requestClient;
    }
}
