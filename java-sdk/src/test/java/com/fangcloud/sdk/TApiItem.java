package com.fangcloud.sdk;

import com.fangcloud.sdk.api.ItemApi;
import com.fangcloud.sdk.bean.output.item.ItemList;
import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.core.Connection;
import org.junit.Test;

/**
 * Created by xuning on 2016/8/14.
 */
public class TApiItem {
    public static final String testClientID = "bbe8e63d-89b0-4f31-ba07-5fd602d501d8";
    public static final String testClientSecret = "5c179dfe-0f5a-4124-9690-42b69ec3aef7";
    public static final String testRediectUrl = "http://121.41.52.18:8080/callback";
    public static final String TestRefreshToken = "bceecd8b-ba45-4aca-8c4e-a80ed253f9f2";
    private static Connection connection = Connection.buildConnection(testClientID, testClientSecret, testRediectUrl);
    private static ItemApi itemApi=ItemApi.getItemApi();

    public TApiItem() {
        connection.setRefreshToken(TestRefreshToken);
        Config.setAllowOutputJsonResult(true);
        connection.setApplyTokenDate(1);
    }

    /**
     * 按条件搜索文件
     */
    @Test
    public void Tsearch(){
        ItemList fileInfo = itemApi.search("aaa", "all", 0, 0);
        for(int i=0; i < fileInfo.getFiles().size(); i++){
            System.out.println("搜索到第"+(i)+"个文件："+fileInfo.getFiles().get(i).getName());
        }
    }
}
