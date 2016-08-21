package com.fangcloud.sdk.bean.exception;

/**
 * Created by xuning on 2016/8/10.
 */
public class OpenApiSDKException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private  long responseCode;
    private  String response;

    public OpenApiSDKException(String message) {
        super(message);
        this.responseCode = 0;
        this.response = null;
    }
    public OpenApiSDKException(String message, long responseCode){
        super(message);
        this.responseCode=responseCode;
    }
    public OpenApiSDKException(String message, long responseCode, String response) {
        super(message);
        this.responseCode = responseCode;
        this.response = response;
    }

    public OpenApiSDKException(String message, Throwable cause, long responseCode, String response) {
        super(message, cause);
        this.responseCode = responseCode;
        this.response = response;
    }

    public OpenApiSDKException(Throwable cause, long responseCode, String response) {
        super(cause);
        this.responseCode = responseCode;
        this.response = response;
    }

    public OpenApiSDKException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, long responseCode, String response) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.responseCode = responseCode;
        this.response = response;
    }

    public long getResponseCode() {
        return responseCode;
    }

    public String getResponse() {
        return response;
    }
}
