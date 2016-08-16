package com.fangcloud.sdk.request;

import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.util.TransformationUtil;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * Created by xuning on 2016/8/10.
 * 改写成单例模式
 */
public class RequestPost extends RequestOperation {
    private RequestClient requestClient;
    private HttpResponse httpResponse;
    private static HttpClient httpClient;
    private String url;
    private List<Header> headers;
    private List<NameValuePair> nameValuePairs;
    private String postBody;

    public RequestPost() {
        this.requestClient = RequestClient.getRequestClient();
        this.url=requestClient.getUrl();
        this.headers=requestClient.getHeaders();
        this.nameValuePairs=requestClient.getNameValuePairs();
        this.postBody=requestClient.getPostBody();
    }

    @Override
    protected HttpResponse oper() {
        this.httpClient = this.requestClient.getHttpClient();
        HttpPost httpPost = new HttpPost(url);
        //设置header
        if (headers.size() > 0 && !Objects.equals(headers, null)) {
            for (Header header : headers) {
                httpPost.setHeader(header.getKey(), header.getValue());
            }
        }
        //设置QueryString
        if (null!=nameValuePairs) {
            httpPost.setEntity(TransformationUtil.toHttpEntity(nameValuePairs));
        }

        //设置postBody
        if (!Objects.equals(postBody, null)) {
            StringEntity stringEntity = TransformationUtil.toStringEntity(postBody);
            stringEntity.setContentType(Config.DEFAULT_CONTENT_TYPE);
            stringEntity.setContentEncoding("UTF-8");
            httpPost.setEntity(stringEntity);
        }

        //执行
        try {
            this.httpResponse = this.httpClient.execute(httpPost);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return this.httpResponse;
    }
}
