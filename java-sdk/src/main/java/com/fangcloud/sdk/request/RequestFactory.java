package com.fangcloud.sdk.request;

import com.fangcloud.sdk.bean.exception.ExternalErrorCode;
import com.fangcloud.sdk.bean.exception.OpenApiSDKException;
import com.fangcloud.sdk.core.Config;

/**
 * Created by xuning on 2016/9/2.
 */
public class RequestFactory {
    public static RequestOperation getRequestMethod(RequestClient requestClient){
        RequestOperation requestOperation=null;
        switch (requestClient.getMethod()) {
        case Config.METHOD_GET:
            requestOperation = new RequestGet(requestClient);
            break;
        case Config.METHOD_POST:
            requestOperation = new RequestPost(requestClient);
            break;
        case Config.METHOD_PUT:
            requestOperation = new RequestPut(requestClient);
            break;
        case Config.METHOD_DELETE:
            requestOperation = new RequestDelete(requestClient);
            break;
        default:
            throw new OpenApiSDKException(ExternalErrorCode.REQUEST_METHOD_ERROR);
        }
        return requestOperation;
    }
}
