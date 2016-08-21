package com.fangcloud.sdk.bean.factory;

import org.apache.http.HttpResponse;

/**
 * Created by xuning on 2016/8/21.
 */
public interface RequestClient {
    public HttpResponse sendRequest();
}
