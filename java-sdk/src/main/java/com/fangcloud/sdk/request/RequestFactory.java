package com.fangcloud.sdk.request;

import com.fangcloud.sdk.bean.exception.ExternalErrorCode;
import com.fangcloud.sdk.bean.exception.OpenApiSDKException;
import com.fangcloud.sdk.core.Config;

/**
 * Created by xuning on 2016/9/2.
 */
public class RequestFactory {
    public static RequestOperation getRequestMethod(String method){
        RequestOperation requestOperation=null;
        switch (method) {
        case Config.METHOD_GET:
            requestOperation = new RequestGet();
            break;
        case Config.METHOD_POST:
            requestOperation = new RequestPost();
            break;
        case Config.METHOD_PUT:
            requestOperation = new RequestPut();
            break;
        case Config.METHOD_DELETE:
            requestOperation = new RequestDelete();
            break;
        default:
            throw new OpenApiSDKException(ExternalErrorCode.REQUEST_METHOD_ERROR);
        }
        return requestOperation;
    }
}
