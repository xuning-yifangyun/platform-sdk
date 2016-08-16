package com.fangcloud.sdk.request;

import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.core.Connection;
import com.fangcloud.sdk.util.RequestUtil;

import java.util.ArrayList;

/**
 * Created by xuning on 2016/8/11.
 */
public class RequestOption {
    private static ArrayList<Header> headers = new ArrayList<>();
    private RequestOption(){}
    /**
     * 这里可能存在一定的问题
     *
     * @param connection
     * @return
     */
    public static ArrayList<Header> getAuthHeaders(Connection connection) {
        Header header = new Header("Authorization", "Basic " + connection.getAuthorizationBase64());
        headers = RequestUtil.addToHeaderList(header);
        return headers;
    }

    public static ArrayList<Header> getApiCommonHeader(Connection connection) {
        Header header1 = new Header("Authorization", "Bearer " + connection.getAccessToken());
        Header header2 = new Header("Content-Type", Config.DEFAULT_CONTENT_TYPE);
        headers = RequestUtil.addToHeaderList(header1, header2);
        return headers;
    }

}
