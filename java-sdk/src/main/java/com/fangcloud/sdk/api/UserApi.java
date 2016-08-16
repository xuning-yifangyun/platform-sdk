package com.fangcloud.sdk.api;

import com.fangcloud.sdk.bean.output.user.AsUser;
import com.fangcloud.sdk.bean.output.user.GetUserInfo;
import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.core.Connection;
import com.fangcloud.sdk.request.Header;
import com.fangcloud.sdk.request.RequestClient;
import com.fangcloud.sdk.request.RequestOption;
import com.fangcloud.sdk.util.TransformationUtil;
import com.fangcloud.sdk.util.UrlTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class UserApi {

    private static final UrlTemplate AS_USER_CODE = new UrlTemplate("/user/as_user_code");
    private static final UrlTemplate ME_INFO = new UrlTemplate("/user/info");
    private static final UrlTemplate USER_INFO = new UrlTemplate("/user/%s/info");
    private static final UrlTemplate DOWNLOAD_PROFILE_PIC = new UrlTemplate("/user/profile_pic_download");
    private static Connection connection = Connection.getConnection();
    private static ArrayList<Header> headers = RequestOption.getApiCommonHeader(connection);
    private static UserApi userApi= new UserApi();
    public static  UserApi getUserApi(){
        return userApi;
    }
    /**
     * 获取用户的as_user码
     * 注：高级接口，如果使用，需要联系客服
     *
     * @param authUrl
     * @return
     */
    public static AsUser getAsUserCode(String authUrl) {
        String baseUrl = AS_USER_CODE.build(Config.DEFAULT_API_URI);
        String url = String.format(baseUrl + "?url=%s", authUrl);
        RequestClient requestClient = RequestClient.buildRequest(url, "get", headers, null, null);
        return (AsUser) TransformationUtil.requestClientToOutputObject(requestClient, AsUser.class);
    }

    /**
     * 获取指定用户信息
     *
     * @param
     * @return
     */
    public static GetUserInfo getOwnInfo() {
        String url = ME_INFO.build(Config.DEFAULT_API_URI);
        RequestClient requestClient = RequestClient.buildRequest(url, "get", headers);
        return (GetUserInfo) TransformationUtil.requestClientToOutputObject(requestClient, GetUserInfo.class);
    }

    /**
     * 获取自己的用户信息
     *
     * @return
     */
    public static GetUserInfo getUserInfo(long id) {
        String url = USER_INFO.build(Config.DEFAULT_API_URI, id);
        RequestClient requestClient = RequestClient.buildRequest(url, "get", headers, null, null);
        return (GetUserInfo) TransformationUtil.requestClientToOutputObject(requestClient, GetUserInfo.class);
    }

    /**
     * 下载用户头像
     *
     * @param userId
     * @param profilePicKey
     */
    public static InputStream getPrifilePicDowload(long userId, String profilePicKey) {
        String baseUrl = DOWNLOAD_PROFILE_PIC.build(Config.DEFAULT_API_URI);
        String url = String.format(baseUrl + "?user_id=%s&profile_pic_key=%s", userId, profilePicKey);
        RequestClient requestClient = RequestClient.buildRequest(url, "get", headers, null, null);
        InputStream httpResponse = null;
        try {
            httpResponse = requestClient.sendRequest().getEntity().getContent();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return httpResponse;
    }
}
