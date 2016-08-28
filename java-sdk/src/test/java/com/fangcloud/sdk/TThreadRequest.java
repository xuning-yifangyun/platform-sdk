package com.fangcloud.sdk;

import com.fangcloud.sdk.api.FileApi;
import com.fangcloud.sdk.api.FolderApi;
import com.fangcloud.sdk.bean.output.file.FileInfo;
import com.fangcloud.sdk.bean.output.folder.FolderInfo;
import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.core.Connection;
import org.junit.Test;

/**
 * Created by xuning on 2016/8/26.
 */
public class TThreadRequest {
    public static final String testClientID = "bbe8e63d-89b0-4f31-ba07-5fd602d501d8";
    public static final String testClientSecret = "5c179dfe-0f5a-4124-9690-42b69ec3aef7";
    public static final String testRediectUrl = "http://121.41.52.18:8080/callback";
    public static final String TestRefreshToken = "bceecd8b-ba45-4aca-8c4e-a80ed253f9f2";
    private static Connection connection = Connection.buildConnection(testClientID, testClientSecret, testRediectUrl);
    public long testFileId = 501000511232L;
    public TThreadRequest(){
        connection.setRefreshToken(TestRefreshToken);
        Config.setAllowOutputJsonResult(true);
        Config.setOpenLogOutput(true);
    }
    @Test
    public void TgetFileInfo() {
        int count=5;
        FileApi fileApi = new FileApi();
        while ((count--)>0){
            FileInfo fileInfo1 = fileApi.getFileInfo(testFileId);
        }
    }

    /**
     * 多线程测试
     */
    @Test
    public void TRunnable(){
//        AT a=new AT("1号窗口");
//        AT a1=new AT("2号窗口");
//        Thread thread=new Thread(a);
//        Thread thread1=new Thread(a1);
//        Thread thread2=new Thread(a1);
//        thread.start();
//        thread1.start();
//        thread2.start();
    }
}
class A implements Runnable {
    public long testFileId = 501000511232L;
    public static long testfoldrenId=501000031450L;
    public String str=null;
    public A(String str){
        this.str=str;
    }
    @Override
    public void run() {
        int count=5;
        FileApi fileApi = new FileApi();
        FolderApi folderApi = new FolderApi();
        while ((count--)>0){
            System.out.println(this.str+"发送第"+(5-count)+"次：");
            FileInfo fileInfo1 = fileApi.getFileInfo(testFileId);
            FolderInfo folderInfoOutput= folderApi.getFolderInfo(testfoldrenId);
        }
    }
}