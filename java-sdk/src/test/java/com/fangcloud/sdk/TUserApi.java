package com.fangcloud.sdk;

import com.fangcloud.sdk.api.UserApi;
import com.fangcloud.sdk.bean.output.user.GetUserInfo;
import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.core.Connection;
import org.junit.Test;

/**
 * Created by xuning on 2016/8/12.
 */
public class TUserApi {

    public static final String testClientID = "bbe8e63d-89b0-4f31-ba07-5fd602d501d8";
    public static final String testClientSecret = "5c179dfe-0f5a-4124-9690-42b69ec3aef7";
    public static final String testRediectUrl = "http://121.41.52.18:8080/callback";
    public static final String TestRefreshToken = "bceecd8b-ba45-4aca-8c4e-a80ed253f9f2";
    private static Connection connection = Connection.buildConnection(testClientID, testClientSecret, testRediectUrl);
    private UserApi userApi = UserApi.getUserApi();//保证修改后的兼容性

    public TUserApi() {
        connection.setRefreshToken(TestRefreshToken);
        Config.setAllowOutputJsonResult(true);
        connection.setApplyTokenDate(1);
    }

    @Test
    public void TgetAsUserCode() {
        System.out.println("需要申请url，无法测试");
    }

    /**
     * 获取自己的信息
     */
    @Test
    public void TgetMeInfo() {
        GetUserInfo getUserInfoOutput = UserApi.getOwnInfo();
        System.out.println(getUserInfoOutput.getName());
    }

    /**
     * 获取其他用户的信息
     */
    @Test
    public void TgetMUserInfo() {
        GetUserInfo getUserInfoOutput = userApi.getUserInfo(22149);
        System.out.println(getUserInfoOutput.getName());
    }

    /**
     * 下载头像
     */
    public void TDownloadProfilePic() {

    }

}
