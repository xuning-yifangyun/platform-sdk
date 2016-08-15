package com.fangcloud.sdk.request;

import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.util.TransformationUtil;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by xuning on 2016/8/10.
 */
public abstract class RequestOperation {
    private RequestClient requestClient;

    public RequestOperation(RequestClient requestClient) {
        this.requestClient = requestClient;
    }

    protected void openHttpClient() {
        this.requestClient.httpClient = new DefaultHttpClient();
    }

    protected abstract HttpResponse oper();

    protected void closeHttpClient() {
        this.requestClient.httpClient.getConnectionManager().shutdown();
    }

    public void postBodyEntityConfig() {
        String method = this.requestClient.method;
        if (method.equals(Config.METHOD_POST) || method.equals(Config.METHOD_PUT)) {
            //entity配置
            StringEntity stringEntity = TransformationUtil.toStringEntity(this.requestClient.postBody);
            stringEntity.setContentType("application/json");
            stringEntity.setContentEncoding("UTF-8");
            this.requestClient.stringEntity=stringEntity;
        }
    }

    public HttpResponse execute() {
        //建立连接
        openHttpClient();

        //操作，具体为资源配置
        requestClient.httpResponse = oper();
        //关闭requestClient
        closeHttpClient();
        return requestClient.httpResponse;
    }
}
