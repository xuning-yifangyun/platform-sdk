package com.fangcloud.sdk.bean.T_1.factory;

import org.apache.http.HttpResponse;

/**
 * Created by xuning on 2016/8/21.
 */
public class RequestDelete extends RequestAction{
    private RequestOption requestOption;
    public RequestDelete(RequestOption requestOption) {
        this.requestOption=requestOption;
    }
    @Override
    public HttpResponse sendRequest() {
        return execute();
    }

    @Override
    public HttpResponse oper() {
        return null;
    }
}
