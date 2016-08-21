package com.fangcloud.sdk.bean.T_1.factory;

import com.fangcloud.sdk.request.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;

import java.util.List;

/**
 * Created by xuning on 2016/8/21.
 */
public class RequestPut extends RequestAction {
    private RequestOption requestOption;
    private String url;
    private String method;
    private List<Header> headers;
    private List<NameValuePair> nameValuePairs;
    private String postBody;

    public RequestPut(RequestOption requestOption) {
        this.requestOption = requestOption;
        this.url=requestOption.getUrl();
        this.method=requestOption.getMethod();
        this.headers=requestOption.getHeaders();
        this.nameValuePairs=requestOption.getNameValuePairs();
        this.postBody=requestOption.getPostBody();
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
