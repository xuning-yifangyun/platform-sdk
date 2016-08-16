package com.fangcloud.sdk.request;

import com.fangcloud.sdk.util.TransformationUtil;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * Created by xuning on 2016/8/10.
 */
public class RequestPut extends RequestOperation {
    private RequestClient requestClient;
    private static HttpClient httpClient;
    private HttpResponse httpResponse;
    private String url;
    private List<Header> headers;
    private List<NameValuePair> nameValuePairs;
    private String postBody;
    public RequestPut() {
        this.requestClient = RequestClient.getRequestClient();
        this.url=requestClient.getUrl();
        this.headers=requestClient.getHeaders();
        this.nameValuePairs=requestClient.getNameValuePairs();
        this.postBody=requestClient.getPostBody();
    }

    @Override
    protected HttpResponse oper() {
        this.httpClient = this.requestClient.getHttpClient();
        HttpPut httpPut = new HttpPut(url);
        //设置header
        if (headers.size() > 0 && !Objects.equals(headers, null)) {
            for (Header header : headers) {
                httpPut.setHeader(header.getKey(), header.getValue());
            }
        }
        //设置QueryString
        if (!Objects.equals(nameValuePairs, null)) {
            httpPut.setEntity(TransformationUtil.toHttpEntity(nameValuePairs));
        }

        //设置postBody
        if (!Objects.equals(postBody, null)) {
            StringEntity stringEntity = TransformationUtil.toStringEntity(postBody);
            stringEntity.setContentType("application/json");
            stringEntity.setContentEncoding("UTF-8");
            httpPut.setEntity(stringEntity);
        }

        //执行,这里出现报错
        try {
            this.httpResponse = this.httpClient.execute(httpPut);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return this.httpResponse;
    }
}
