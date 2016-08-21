package com.fangcloud.sdk.bean.factory;

import com.fangcloud.sdk.request.RequestOperation;
import org.apache.http.HttpResponse;

/**
 * Created by xuning on 2016/8/21.
 */
public class RequestDelete  extends RequestOperation implements RequestClient{

    @Override
    public HttpResponse sendRequest() {
        return null;
    }

    @Override
    protected HttpResponse oper() {
        return null;
    }
}
