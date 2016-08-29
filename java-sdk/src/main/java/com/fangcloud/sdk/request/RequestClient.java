package com.fangcloud.sdk.request;

import com.fangcloud.sdk.bean.exception.ExternalErrorCode;
import com.fangcloud.sdk.bean.exception.OpenApiSDKException;
import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.core.Connection;
import com.fangcloud.sdk.util.LogUtil;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by xuning on 2016/8/9.
 */
public class RequestClient {
    private HttpResponse httpResponse;
    private HttpClient httpClient;
    private String url;
    private String method;
    private List<Header> headers;
    private List<NameValuePair> nameValuePairs;
    private String postBody;
    private StringEntity stringEntity;
    private RequestOperation requestOperation;
    private static Connection connection = Connection.getConnection();
    private static RequestClient requestClient = new RequestClient();
    private int sendRes;
    private static Logger logger= LoggerFactory.getLogger(RequestClient.class);
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

    public synchronized HttpResponse sendRequest(){
        int refreshTokenCount=Config.REFRESH_TOKEN_COUNT;
        while (refreshTokenCount > 0) {
            switch (method) {
            case Config.METHOD_GET:
                requestOperation = new RequestGet();
                break;
            case Config.METHOD_POST:
                requestOperation = new RequestPost();
                break;
            case Config.METHOD_PUT:
                requestOperation = new RequestPut();
                break;
            case Config.METHOD_DELETE:
                requestOperation = new RequestDelete();
                break;
            default:
                throw new OpenApiSDKException(ExternalErrorCode.REQUEST_METHOD_ERROR);
            }

            httpResponse = requestOperation.execute();
            long nowTime=System.currentTimeMillis();
            long applyTokenTime=connection.getApplyTokenDate();
            long expirseIn=connection.getExpiresIn();
//            logger.debug("时间差："+(nowTime-applyTokenTime)+"现在时间"+nowTime+"Token申请时间："+
//                    applyTokenTime+"有效时间"+expirseIn*1000);
//          先验证时间会有一个逻辑问题
            sendRes = httpResponse.getStatusLine().getStatusCode();
            if(Config.ALLOW_OUTPUT_LOG_FILE){
                logger.info(this.toString());
            }
            //前者为已经验证，后者为授权码换token
            if((nowTime-applyTokenTime)<expirseIn*1000||(expirseIn==0&&applyTokenTime==0)){
                if(sendRes==200){
                    return httpResponse;
                }else{
                    if(sendRes==401){
                        //这个时候的401应该是在实际业务场景中不存在的，但是，这里
                        //token刷新必须建立在已经发起过授权请求的基础之上，又非常有利于单元测试，需要考虑处理方案？
                    }
                    RequestIntercept.ErrorInfoIntercept(httpResponse);
                }
            }else{
                refreshTokenCount--;
                connection.tryRefreshToken();
                System.out.println(!url.matches("oauth/token"));
                if(!url.contains("oauth/token")){
                    headers = RequestOption.getApiCommonHeader(Connection.getConnection());
                }
            }

//            sendRes = httpResponse.getStatusLine().getStatusCode();
//
//            if(Config.ALLOW_OUTPUT_LOG_FILE){
//                logger.info(this.toString());
//            }
//
//            if (sendRes != 200) {
//                RequestIntercept.ErrorInfoIntercept(httpResponse);
//                refreshTokenCount--;
//                connection.tryRefreshToken();
//                headers = RequestOption.getApiCommonHeader(Connection.getConnection());
//            }
//            else {
//                return httpResponse;
//            }
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



    public HttpResponse getHttpResponse() {
        return httpResponse;
    }

    public void setHttpResponse(HttpResponse httpResponse) {
        this.httpResponse = httpResponse;
    }

    public HttpClient getHttpClient() {
        return httpClient;
    }

    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
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

    public RequestOperation getRequestOperation() {
        return requestOperation;
    }

    public void setRequestOperation(RequestOperation requestOperation) {
        this.requestOperation = requestOperation;
    }
}
