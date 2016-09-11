package com.fangcloud.sdk.request;

import com.fangcloud.sdk.bean.exception.OpenApiSDKException;
import com.fangcloud.sdk.core.Config;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * Created by xuning on 2016/8/10.
 */
public class RequestGet extends RequestOperation {
    private String url;
    private List<Header> headers;

    public RequestGet(RequestClient requestClient) {
        this.url = requestClient.getUrl();
        this.headers = requestClient.getHeaders();
    }

    @Override
    protected CloseableHttpResponse oper() {
        CloseableHttpResponse httpResponse;
        HttpGet httpGet = new HttpGet(this.url);
        if (this.headers.size() > 0 && !Objects.equals(this.headers, null)) {
            for (Header header : this.headers) {
                httpGet.setHeader(header.getKey(), header.getValue());
            }
        }
        RequestConfig requestConfig = RequestConfig
                .custom()
                .setSocketTimeout(Config.DEFAULT_SOCKET_TIMOUT_CHARSET)
                .setConnectTimeout(Config.DEFAULT_CONNECTION_TIMOUT)
                .build();
        httpGet.setConfig(requestConfig);
        try {
            httpResponse = httpClient.execute(httpGet);
            if (!Objects.equals(null, httpResponse)) {
                if(!httpResponse.getEntity().getContentType().getValue().split(";")[0].equals("image/jpeg")){
                      httpResponse.close();
                }

            }
        }
        catch (IOException e) {
            throw new OpenApiSDKException(e.getMessage());

        }
        return httpResponse;
    }
}
