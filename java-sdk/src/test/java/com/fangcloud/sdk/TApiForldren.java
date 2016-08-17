package com.fangcloud.sdk;

import com.fangcloud.sdk.api.FolderApi;
import com.fangcloud.sdk.bean.output.folder.CreateFolder;
import com.fangcloud.sdk.bean.output.folder.DeleteFolder;
import com.fangcloud.sdk.bean.output.folder.FolderInfo;
import com.fangcloud.sdk.bean.output.folder.MoveFolder;
import com.fangcloud.sdk.bean.output.folder.RestoreFolderFromTrash;
import com.fangcloud.sdk.bean.output.folder.UpdateFolder;
import com.fangcloud.sdk.bean.output.item.ItemList;
import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.core.Connection;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuning on 2016/8/15.
 * 测试结果：从回收站恢复文件，提示方法不被允许
 */
public class TApiForldren {
    public String clientId = Config.testClientID;
    public String clientSecret = Config.testClientSecret;
    public String rediectUrl = Config.testRediectUrl;
    public Connection connection = Connection.buildConnection(clientId, clientSecret, rediectUrl);
    public static long testfoldrenId=501000031450L;
    private FolderApi folderApi=FolderApi.getFolderApi();

    public TApiForldren() {
        Connection connection = Connection.buildConnection(clientId, clientSecret, rediectUrl);
        connection.setRefreshToken(Config.TestRefreshToken);
    }

    /**
     * 获取文件夹信息
     */
    @Test
    public void getForldrenInfo(){
        FolderInfo folderInfoOutput= folderApi.getFolderInfo(testfoldrenId);
        System.out.println(folderInfoOutput.getSuccess());
        System.out.println(folderInfoOutput.getName());
    }

    /**
     * 创建文件夹
     */
    @Test
    public void TcreateFolder(){
        CreateFolder createFolderOutput=FolderApi.createFolder("testUpdate", testfoldrenId);
        System.out.println(createFolderOutput.getSuccess());
        System.out.println(createFolderOutput.getName());
    }

    /**
     * 更新文件夹
     */
    @Test
    public void TupdateFolder(){
        UpdateFolder updateFolderOutput=folderApi.updateFolder(testfoldrenId,"testapi");
        System.out.println(updateFolderOutput.getSuccess());
        System.out.println(updateFolderOutput.getName());
    }

    /**
     * 删除文件夹
     */
    @Test
    public void TdeleteFolder(){
        DeleteFolder deleteFolderOutput=folderApi.deleteFolder(testfoldrenId);
        System.out.println(deleteFolderOutput.getSuccess());
    }

    /**
     * 从文件夹删除文件
     */
    @Test
    public void TdeleteFolderFromTrash(){
        DeleteFolder deleteFolderOutput=folderApi.deleteFolder(testfoldrenId);
        System.out.println(deleteFolderOutput.getSuccess());
    }

    /**
     * 从回收站恢复文件
     */
    @Test
    public void TrecoveryFolderFromTrash(){
        List<Long> longs=new ArrayList<>();
        longs.add(testfoldrenId);
        RestoreFolderFromTrash restoreFolderFromTrashOutput=folderApi.recoveryFolderFromTrash(longs,false);
        System.out.println(restoreFolderFromTrashOutput.getSuccess());
    }

    /**
     * 移动文件夹
     */
    @Test
    public void TmoveFolder(){
        List<Long> longs=new ArrayList<>();
        longs.add(testfoldrenId);
        MoveFolder moveFolderOutput=folderApi.moveFolder(longs, 0);
        System.out.println(moveFolderOutput.getSuccess());
    }

    /**
     * 获取所有的子节点
     */
    @Test
    public void TgetChildren(){
        ItemList itemListOutput=folderApi.getChildren(testfoldrenId,0,1,"file");
        System.out.println(itemListOutput.getSuccess());
    }

}
