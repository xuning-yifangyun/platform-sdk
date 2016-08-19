package com.fangcloud.sdk.request;

import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.util.TransformationUtil;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * Created by xuning on 2016/8/10.
 */
public class RequestDelete extends RequestOperation {
    private RequestClient requestClient;
    private HttpResponse httpResponse;
    private static HttpClient httpClient;
    private String url;
    private List<Header> headers;
    private List<NameValuePair> nameValuePairs;
    private String postBody;

    public RequestDelete() {
        this.requestClient = RequestClient.getRequestClient();
        this.headers = requestClient.getHeaders();
        this.nameValuePairs = requestClient.getNameValuePairs();
        this.postBody = requestClient.getPostBody();
        this.url = requestClient.getUrl();
    }

    @Override
    protected HttpResponse oper() {
        this.httpClient = this.requestClient.getHttpClient();
        HttpDelete httpDelete = new HttpDelete(requestClient.getUrl());
        //设置header
        if (requestClient.getHeaders().size() > 0 && !Objects.equals(headers, null)) {
            for (Header header : headers) {
                httpDelete.setHeader(header.getKey(), header.getValue());
            }
        }
        if (null != nameValuePairs) {
            httpDelete.setEntity(TransformationUtil.toHttpEntity(nameValuePairs));
        }
        if (!Objects.equals(postBody, null)) {
            StringEntity stringEntity = TransformationUtil.toStringEntity(postBody);
            stringEntity.setContentType(Config.DEFAULT_CONTENT_TYPE);
            stringEntity.setContentEncoding(Config.DEFAULT_CHARSET);
            httpDelete.setEntity(stringEntity);
        }
        try {
            this.httpResponse = this.httpClient.execute(httpDelete);
        }
        catch (IOException e) {
            int sendRes = httpResponse.getStatusLine().getStatusCode();
//            throw new OpenApiSDKException(ExternalErrorCode.EXTERNAL_LOGIN_PASSWORD_ERROR + " is:" + e, sendRes, httpResponse.toString());
            System.out.println("请求错误，http响应码："+sendRes);
        }
        return this.httpResponse;
    }
}
