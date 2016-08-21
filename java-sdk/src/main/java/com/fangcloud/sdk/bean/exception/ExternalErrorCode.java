package com.fangcloud.sdk.bean.exception;

public class ExternalErrorCode {

    public static final String CONNECTION_METHOD_INVALID="you auth connection is invalid";
    // default
    public static final String INVALID_ERROR = "invalid_error";
    public static final String EXTERNAL_LOGIN_PASSWORD_ERROR = "external_login_password_error";
    public static final String REQUEST_DATA_INVALID = "request_data_invalid";
    public static final String SIZE_EXCEEDED = "size_exceeded";
    public static final String FIELD_REQUIRED = "field_required";
    public static final String URL_INVALID = "url_invalid";
    public static final String INVALID_TOKEN="token is invalid";
    public static final String REQUEST_METHOD_ERROR = "request method is error";
    public static final String EXECUTE_METHOD_ERROR="execute http method error";


    // permission denied
    public static final String PERMISSION_DENIED = "permission_denied";

    private String value;

    ExternalErrorCode(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }
}
