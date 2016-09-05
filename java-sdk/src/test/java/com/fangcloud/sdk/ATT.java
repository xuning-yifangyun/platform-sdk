package com.fangcloud.sdk;

import com.fangcloud.sdk.api.FileApi;
import com.fangcloud.sdk.api.FolderApi;
import com.fangcloud.sdk.bean.output.file.FileInfo;

/**
 * Created by xuning on 2016/8/26.
 */
class ATT implements Runnable {
    public long testFileId = 501000483684L;
    public static long testfoldrenId = 501000031450L;
    public String str = null;
    public ATT(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        FileApi fileApi = new FileApi();
        FolderApi folderApi = new FolderApi();
        int count = 0;
        while ((count++) < 10) {
            System.out.println(this.str + "发送第" + (count) + "次：");
            FileInfo fileInfo1 = fileApi.getFileInfo(testFileId);
            //FolderInfo folderInfoOutput = folderApi.getFolderInfo(testfoldrenId);
        }
    }
}