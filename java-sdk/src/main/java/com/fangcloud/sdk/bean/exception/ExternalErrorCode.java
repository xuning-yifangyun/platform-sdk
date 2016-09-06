package com.fangcloud.sdk.bean.exception;

public class ExternalErrorCode {

    // default
    public static final String INVALID_ERROR = "invalid_error";
    public static final String EXTERNAL_LOGIN_PASSWORD_ERROR = "external_login_password_error";
    public static final String REQUEST_DATA_INVALID = "request_data_invalid";
    public static final String INVALID_TOKEN="token is invalid";
    public static final String INVALID_REFRESSH_TOKEN="refresh token is invalid";
    public static final String REFRESH_TOKEN_IS_NULL="refresh token is null";
    public static final String REQUEST_METHOD_ERROR = "request method is error";
    public static final String REQUEST_NO_RESPONSE="request is not response";
    public static final String REQUEST_IS_BAD="request is bad";
    public static final String NOT_KNOW_ERROR="not know this exception's reasion";
    public static final String REFRESH_TOKEN_INVALID="refresh token is invalid";
    public static final String UN_SUPPORT_ENCODING="no support encoding in entity transformation";
    public static final String HTTP_RESPONSE_IS_NULL="http response is null";
    public static final String CONNECTION_REFUSED="connection refused";


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
