package com.fangcloud.sdk.bean.T_1.factory;

import org.apache.http.HttpResponse;

/**
 * Created by xuning on 2016/8/21.
 */
public class RequestGet extends RequestAction {
    private RequestOption requestOption;
    public RequestGet(RequestOption requestOption) {
        this.requestOption=requestOption;
    }


    public HttpResponse sendRequest() {
        return execute();
    }

    @Override
    public HttpResponse oper() {
        return null;
    }
}
