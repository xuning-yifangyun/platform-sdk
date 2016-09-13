package com.fangcloud.sdk.request;

import com.fangcloud.sdk.api.AuthApi;
import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.core.Connection;
import com.fangcloud.sdk.request.factory.RequestFactory;
import com.fangcloud.sdk.request.intercept.RequestIntercept;
import com.fangcloud.sdk.util.log.LogUtil;
import com.fangcloud.sdk.util.log.Logger;
import com.fangcloud.sdk.util.log.LoggerFactory;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.entity.StringEntity;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xuning on 2016/8/9.
 */
public class RequestClient {
    private String url;
    private int sendRes;
    private String method;
    private String postBody;
    private StringEntity stringEntity;
    private static List<Header> headers;
    private List<NameValuePair> nameValuePairs;
    private static final Lock lock = new ReentrantLock();
    private static Logger logger = LoggerFactory.getLogger(RequestClient.class);

    public RequestClient openRequest(String url, String method, List<Header> headers, List<NameValuePair> nameValuePairs, String postBody) {
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.nameValuePairs = nameValuePairs;
        this.postBody = postBody;
        return this;
    }

    public HttpResponse sendRequest() {
        Connection connection = Connection.getConnection();
        HttpResponse httpResponse = null;
        int refreshTokenCount = Config.REFRESH_TOKEN_COUNT;
        while ((refreshTokenCount--) > 0) {
            RequestOperation requestOperation = RequestFactory.getRequestMethod(this);
            httpResponse = requestOperation.execute();
            long nowTime = System.currentTimeMillis();
            sendRes = httpResponse.getStatusLine().getStatusCode();
            if (sendRes == 200) {
                logger.info(this.toString());
                return httpResponse;
            }
            else {
                RequestIntercept.ErrorInfoIntercept(httpResponse);
                if (sendRes == 401) {
                    try {
                        lock.lock();
                        if (!((nowTime - connection.getApplyTokenDate()) < connection.getExpiresIn() * 1000)) {
                            //connection.tryRefreshToken();
                            AuthApi.rebuildAccessToken();
                            if (!url.contains("oauth/token")) {
                                headers = RequestOption.getApiCommonHeader(Connection.getConnection());
                            }
                        }
                    }
                    finally {
                        lock.unlock();
                    }
                }
            }
        }
        return httpResponse;
    }

    public static void logRequest(String str) {
        LogUtil.getLogUtil().printLog(str);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    public List<NameValuePair> getNameValuePairs() {
        return nameValuePairs;
    }

    public void setNameValuePairs(List<NameValuePair> nameValuePairs) {
        this.nameValuePairs = nameValuePairs;
    }

    public StringEntity getStringEntity() {
        return stringEntity;
    }

    public void setStringEntity(StringEntity stringEntity) {
        this.stringEntity = stringEntity;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public RequestClient openRequest(String url, String method) {
        return openRequest(url, method, null, null, null);
    }

    public RequestClient openRequest(String url, String method, List<Header> headers) {
        return openRequest(url, method, headers, null, null);
    }

    public RequestClient openRequest(String url, String method, List<Header> headers, List<NameValuePair> nameValuePairs) {
        return openRequest(url, method, headers, nameValuePairs, null);
    }

    @Override
    public String toString() {
        if (Config.OPEN_LOG_OUTPUT || Config.OPEN_LOG_PRINT) {
            String hRes = "";
            for (Header h : headers) {
                hRes += (h.getKey() + ":" + h.getValue() + " ");
            }
            String nRes = "";
            if (null != nameValuePairs) {
                for (NameValuePair nameValuePair : nameValuePairs) {
                    nRes += (nameValuePair.getName() + ":" + " ");
                }
            }
            return ("[" + "response code：" + sendRes + "] request info: [url: " + this.getUrl() +
                    "] [method:" + this.getMethod() + "] [header：" + hRes + "] [request option:" +
                    nRes + "] [postbody :" + postBody + "]" + "---");
        }
        return null;
    }

}
