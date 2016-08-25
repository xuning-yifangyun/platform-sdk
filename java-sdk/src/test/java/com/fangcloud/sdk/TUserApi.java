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

    public String clientId = "bbe8e63d-89b0-4f31-ba07-5fd602d501d8";
    public String clientSecret = "5c179dfe-0f5a-4124-9690-42b69ec3aef7";
    public String rediectUrl = "http://121.41.52.18:8080/callback";
    public Connection connection = Connection.buildConnection(clientId, clientSecret, rediectUrl);
    private UserApi userApi = UserApi.getUserApi();//保证修改后的兼容性

    public TUserApi() {
        Connection connection = Connection.buildConnection(clientId, clientSecret, rediectUrl);
        connection.setRefreshToken(Config.TestRefreshToken);
        Config.setAllowOutputJsonResult(true);
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
