package com.fangcloud.sdk;

import com.fangcloud.sdk.api.FileApi;
import com.fangcloud.sdk.api.FolderApi;
import com.fangcloud.sdk.bean.output.file.FileInfo;
import com.fangcloud.sdk.bean.output.folder.FolderInfo;

/**
 * Created by xuning on 2016/8/26.
 */
class AT implements Runnable {
    public long testFileId = 501000511232L;
    public static long testfoldrenId = 501000031450L;
    public String str = null;

    public AT(String str) {
        this.str = str;
    }

    private int count = 5;

    @Override
    public void run() {
        FileApi fileApi = new FileApi();
        FolderApi folderApi = new FolderApi();
        int count = 5;
        while ((count--) > 0) {
            System.out.println(this.str + "发送第" + (5 - count) + "次：");
            FileInfo fileInfo1 = fileApi.getFileInfo(testFileId);
            FolderInfo folderInfoOutput = folderApi.getFolderInfo(testfoldrenId);
        }
    }
}