package com.fangcloud.sdk.request;

import com.fangcloud.sdk.util.TransformationUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.util.Objects;

/**
 * Created by xuning on 2016/8/10.
 */
public class RequestPut extends RequestOperation {
    private RequestClient requestClient;
    private HttpClient httpClient;
    private HttpResponse httpResponse;

    public RequestPut(RequestClient requestClient) {
        super(requestClient);
        this.requestClient = requestClient;
    }

    @Override
    protected HttpResponse oper() {
        this.httpClient = this.requestClient.httpClient;
        HttpPut httpPut = new HttpPut(requestClient.url);
        //设置header
        if (requestClient.headers.size() > 0 && !Objects.equals(requestClient.headers, null)) {
            for (Header header : requestClient.headers) {
                httpPut.setHeader(header.getKey(), header.getValue());
            }
        }
        //设置QueryString
        if (!Objects.equals(requestClient.nameValuePairs, null)) {
            httpPut.setEntity(TransformationUtil.toHttpEntity(requestClient.nameValuePairs));
        }

        //设置postBody
        if (!Objects.equals(requestClient.postBody, null)) {
            StringEntity stringEntity = TransformationUtil.toStringEntity(requestClient.postBody);
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
