package com.fangcloud.sdk.bean.factory;

import com.fangcloud.sdk.bean.exception.ExternalErrorCode;
import com.fangcloud.sdk.bean.exception.OpenApiSDKException;
import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.request.Header;
import org.apache.http.NameValuePair;

import java.util.List;

/**
 * Created by xuning on 2016/8/21.
 */
public class RequestFactory {
    public static RequestClient getRequestClient(String url, String method, List<Header> headers, List<NameValuePair> nameValuePairs, String postBody) {
        RequestClient requestClient = null;
        switch (method) {
        case Config.METHOD_GET:
            requestClient = new RequestGet();
            break;
        case Config.METHOD_POST:
            requestClient = new RequestPost();
            break;
        case Config.METHOD_PUT:
            requestClient = new RequestPut();
            break;
        case Config.METHOD_DELETE:
            requestClient = new RequestDelete();
            break;
        default:
            throw new OpenApiSDKException(ExternalErrorCode.REQUEST_METHOD_ERROR);
        }
        return requestClient;
    }
}
