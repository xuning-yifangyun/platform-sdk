package com.fangcloud.sdk.request;

import com.fangcloud.sdk.bean.exception.ExternalErrorCode;
import com.fangcloud.sdk.bean.exception.OpenApiSDKException;
import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.util.TransformationUtil;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * Created by xuning on 2016/8/10.
 */
public class RequestDelete extends RequestOperation {
    private String url;
    private List<Header> headers;
    private List<NameValuePair> nameValuePairs;
    private String postBody;

    public RequestDelete(RequestClient requestClient) {
        this.headers = requestClient.getHeaders();
        this.nameValuePairs = requestClient.getNameValuePairs();
        this.postBody = requestClient.getPostBody();
        this.url = requestClient.getUrl();
    }

    @Override
    protected HttpResponse oper() {
        HttpDelete httpDelete = new HttpDelete(this.url);
        //设置header
        if (this.headers.size() > 0 && !Objects.equals(this.headers, null)) {
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
        HttpResponse httpResponse=null;
        try {
            httpResponse = httpClient.execute(httpDelete);
        }
        catch (IOException e) {
//            int sendRes = httpResponse.getStatusLine().getStatusCode();
//            throw new OpenApiSDKException(ExternalErrorCode.EXTERNAL_LOGIN_PASSWORD_ERROR + " is:" + e, sendRes, httpResponse.toString());
            throw new OpenApiSDKException(ExternalErrorCode.CONNECTION_REFUSED);
        }
        return httpResponse;
    }
}
