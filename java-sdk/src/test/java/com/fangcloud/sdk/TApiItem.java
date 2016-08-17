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
    public String clientId = Config.testClientID;
    public String clientSecret = Config.testClientSecret;
    public String rediectUrl = Config.testRediectUrl;
    public Connection connection = Connection.buildConnection(clientId, clientSecret, rediectUrl);
    private static ItemApi itemApi=ItemApi.getItemApi();

    public TApiItem() {
        Connection connection = Connection.buildConnection(clientId, clientSecret, rediectUrl);
        connection.setRefreshToken(Config.TestRefreshToken);
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
