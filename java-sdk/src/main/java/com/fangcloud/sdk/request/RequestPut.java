package com.fangcloud.sdk.request;

import com.fangcloud.sdk.bean.exception.ExternalErrorCode;
import com.fangcloud.sdk.bean.exception.OpenApiSDKException;
import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.util.TransformationUtil;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * Created by xuning on 2016/8/10.
 */
public class RequestPut extends RequestOperation {
    private String url;
    private List<Header> headers;
    private List<NameValuePair> nameValuePairs;
    private String postBody;

    public RequestPut(RequestClient requestClient) {
        this.url = requestClient.getUrl();
        this.headers = requestClient.getHeaders();
        this.nameValuePairs = requestClient.getNameValuePairs();
        this.postBody = requestClient.getPostBody();
    }

    @Override
    protected HttpResponse oper() {
        HttpPut httpPut = new HttpPut(url);
        if (headers.size() > 0 && !Objects.equals(headers, null)) {
            for (Header header : headers) {
                httpPut.setHeader(header.getKey(), header.getValue());
            }
        }
        if (!Objects.equals(nameValuePairs, null)) {
            httpPut.setEntity(TransformationUtil.toHttpEntity(nameValuePairs));
        }

        if (!Objects.equals(postBody, null)) {
            StringEntity stringEntity = TransformationUtil.toStringEntity(postBody);
            stringEntity.setContentType(Config.DEFAULT_CONTENT_TYPE);
            stringEntity.setContentEncoding(Config.DEFAULT_CHARSET);
            httpPut.setEntity(stringEntity);
        }
        HttpResponse httpResponse=null;
        try {
            httpResponse = httpClient.execute(httpPut);
        }
        catch (IOException e) {
            int sendRes = httpResponse.getStatusLine().getStatusCode();
            throw new OpenApiSDKException(ExternalErrorCode.EXTERNAL_LOGIN_PASSWORD_ERROR + " is:" + e, sendRes, httpResponse.toString());
        }
        return httpResponse;
    }
}
