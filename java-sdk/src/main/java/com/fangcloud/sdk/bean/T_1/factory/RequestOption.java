package com.fangcloud.sdk.bean.T_1.factory;

import com.fangcloud.sdk.request.Header;
import org.apache.http.NameValuePair;

import java.util.List;

public class RequestOption {
    private String url;
    private String method;
    private List<Header> headers;
    private List<NameValuePair> nameValuePairs;
    private String postBody;

    public RequestOption(String url, String method) {
        this(url, method, null, null, null);
    }

    public RequestOption(String url, String method, List<Header> headers) {
        this(url, method, headers, null, null);
    }

    public RequestOption(String url, String method, List<Header> headers, List<NameValuePair> nameValuePairs) {
        this(url, method, headers, nameValuePairs, null);
    }

    public RequestOption(String url, String method, List<Header> headers, List<NameValuePair> nameValuePairs, String postBody) {
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.nameValuePairs = nameValuePairs;
        this.postBody = postBody;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    public List<NameValuePair> getNameValuePairs() {
        return nameValuePairs;
    }

    public void setNameValuePairs(List<NameValuePair> nameValuePairs) {
        this.nameValuePairs = nameValuePairs;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }
}
