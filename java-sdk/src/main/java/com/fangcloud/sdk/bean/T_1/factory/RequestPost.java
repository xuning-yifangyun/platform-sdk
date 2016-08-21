package com.fangcloud.sdk.bean.T_1.factory;

import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.core.Connection;
import com.fangcloud.sdk.request.Header;
import com.fangcloud.sdk.util.TransformationUtil;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * Created by xuning on 2016/8/21.
 */
public class RequestPost extends RequestAction {
    private RequestOption requestOption;
    private String url;
    private String method;
    private List<Header> headers;
    private List<NameValuePair> nameValuePairs;
    private String postBody;
    public RequestPost(RequestOption requestOption) {
        this.requestOption = requestOption;
        this.url=requestOption.getUrl();
        this.method=requestOption.getMethod();
        this.headers=requestOption.getHeaders();
        this.nameValuePairs=requestOption.getNameValuePairs();
        this.postBody=requestOption.getPostBody();
    }

    @Override
    public HttpResponse sendRequest() {
        HttpResponse httpResponse=null;
        while(Config.REFRESH_TOKEN_COUNT-->0){
            httpResponse=execute();
            if(httpResponse.getStatusLine().getStatusCode()==401){
                Connection.refreshAccessToken();
            }else{
                return httpResponse;
            }
        }
       return httpResponse;
    }

    public HttpResponse oper() {
        HttpPost httpPost = new HttpPost(this.url);
        if (this.headers.size() > 0 && !Objects.equals(this.headers, null)) {
            for (Header header : this.headers) {
                httpPost.setHeader(header.getKey(), header.getValue());
            }
        }
        if (null != this.nameValuePairs) {
            httpPost.setEntity(TransformationUtil.toHttpEntity(this.nameValuePairs));
        }
        if (!Objects.equals(this.postBody, null)) {
            StringEntity stringEntity = TransformationUtil.toStringEntity(this.postBody);
            stringEntity.setContentType(Config.DEFAULT_CONTENT_TYPE);
            stringEntity.setContentEncoding(Config.DEFAULT_CHARSET);
            httpPost.setEntity(stringEntity);
        }
        HttpResponse httpResponse = null;
        try {
            httpResponse = httpClient.execute(httpPost);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return httpResponse;
    }
}
