package com.fangcloud.sdk.request;

import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.util.TransformationUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.util.Objects;

/**
 * Created by xuning on 2016/8/10.
 */
public class RequestDelete extends RequestOperation {
    private RequestClient requestClient;
    private HttpClient httpClient;
    private HttpResponse httpResponse;

    public RequestDelete(RequestClient requestClient) {
        super(requestClient);
        this.requestClient = requestClient;
    }

    @Override
    protected HttpResponse oper() {
        this.httpClient = this.requestClient.httpClient;
        HttpDelete httpDelete = new HttpDelete(requestClient.url);
        //设置header
        if (requestClient.headers.size() > 0 && !Objects.equals(requestClient.headers, null)) {
            for (Header header : requestClient.headers) {
                httpDelete.setHeader(header.getKey(), header.getValue());
            }
        }
        //设置QueryString
        if (null!=requestClient.nameValuePairs) {

            httpDelete.setEntity(TransformationUtil.toHttpEntity(requestClient.nameValuePairs));

        }

        //设置postBody
        if (!Objects.equals(requestClient.postBody, null)) {
            StringEntity stringEntity = TransformationUtil.toStringEntity(requestClient.postBody);
            stringEntity.setContentType(Config.DEFAULT_CONTENT_TYPE);
            stringEntity.setContentEncoding("UTF-8");
            httpDelete.setEntity(stringEntity);
        }

        //执行
        try {
            this.httpResponse = this.httpClient.execute(httpDelete);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return this.httpResponse;
    }
}
