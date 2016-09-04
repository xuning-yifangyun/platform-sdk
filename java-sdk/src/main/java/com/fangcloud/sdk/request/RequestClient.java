package com.fangcloud.sdk.request;

import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.core.Connection;
import com.fangcloud.sdk.util.LogUtil;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xuning on 2016/8/9.
 */
public class RequestClient {
    private Lock lock = new ReentrantLock();
    private String url;
    private String method;
    private List<Header> headers;
    private List<NameValuePair> nameValuePairs;
    private String postBody;
    private StringEntity stringEntity;
    private String accessToken;
    private String refreshToken;
    private Connection connection = Connection.getConnection();
    private static RequestClient requestClient = new RequestClient();
    private int sendRes;
    private static Logger logger = LoggerFactory.getLogger(RequestClient.class);

    public static RequestClient getRequestClient() {
        return requestClient;
    }

    public static RequestClient buildRequest(String url, String method) {
        return requestClient.buildRequest(url, method, null, null, null);
    }

    public static RequestClient buildRequest(String url, String method, List<Header> headers) {
        return requestClient.buildRequest(url, method, headers, null, null);
    }

    public static RequestClient buildRequest(String url, String method, List<Header> headers, List<NameValuePair> nameValuePairs) {
        return requestClient.buildRequest(url, method, headers, nameValuePairs, null);
    }

    public static RequestClient buildRequest(String url, String method, List<Header> headers, List<NameValuePair> nameValuePairs, String postBody) {
        requestClient.setUrl(url);
        requestClient.setPostBody(postBody);
        requestClient.setMethod(method);
        requestClient.setHeaders(headers);
        requestClient.setNameValuePairs(nameValuePairs);
        return requestClient;
    }

    public RequestClient openRequest(String url, String method, List<Header> headers, List<NameValuePair> nameValuePairs, String postBody) {
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.nameValuePairs = nameValuePairs;
        this.postBody = postBody;

        return this;
    }

    public HttpResponse sendRequest() {
        HttpResponse httpResponse = null;
        int refreshTokenCount = Config.REFRESH_TOKEN_COUNT;
        while ((refreshTokenCount--) > 0) {
            RequestOperation requestOperation = RequestFactory.getRequestMethod(this);
            httpResponse = requestOperation.execute();
            long nowTime = System.currentTimeMillis();
            long applyTokenTime = connection.getApplyTokenDate();
            long expirseIn = connection.getExpiresIn();
            sendRes = httpResponse.getStatusLine().getStatusCode();
            if (Config.ALLOW_OUTPUT_LOG_FILE) {
                logger.info(this.toString());
            }
            if (sendRes == 200) {
                return httpResponse;
            }
            else {
                if(sendRes==401){
                    //M
                    if ((nowTime - applyTokenTime) < expirseIn * 1000 || (expirseIn == 0 && applyTokenTime == 0)) {
                        RequestIntercept.ErrorInfoIntercept(httpResponse);
                    }else{
                        //Y
                        lock.lock();
                        try {
                            connection.tryRefreshToken();
//                            TokenInfo tokenInfo= AuthApi.getTokenByAuthCode(connection.getRefreshToken());
//                            headers=RequestOption.reBuildAuthHeaders(tokenInfo);
                        }
                        finally {
                            lock.unlock();
//                            refreshTokenCount=0;
                        }
                        if (!url.contains("oauth/token")) {
                            headers = RequestOption.getApiCommonHeader(Connection.getConnection());
                        }
                    }
                }
            }
        }
        return httpResponse;
    }

    public static void logRequest(String str) {
        LogUtil.getLogUtil().printLog(str);
    }

    @Override
    public String toString() {
        if (Config.OPEN_LOG_OUTPUT || Config.OPEN_LOG_PRINT) {
            String requestTime = LogUtil.formateTime(System.currentTimeMillis(), "yyyy_MM_dd HH:mm:ss");
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

}
