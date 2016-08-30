package com.fangcloud.sdk;

import com.fangcloud.sdk.api.FileApi;
import com.fangcloud.sdk.bean.input.file.PreviewKind;
import com.fangcloud.sdk.bean.output.Result;
import com.fangcloud.sdk.bean.output.file.Create;
import com.fangcloud.sdk.bean.output.file.FileInfo;
import com.fangcloud.sdk.bean.output.file.FilePresignDownload;
import com.fangcloud.sdk.bean.output.file.FilePresignUpload;
import com.fangcloud.sdk.bean.output.file.FilePreviewDownload;
import com.fangcloud.sdk.bean.output.file.FilePreviewInfo;
import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.core.Connection;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xuning on 2016/8/11.
 * 测试结果：文件恢复方法问题，为open-api端问题
 * 文件预览返回的URL报404
 */
public class TApiFile {
    //
    //Test
    public static final String testClientID = "bbe8e63d-89b0-4f31-ba07-5fd602d501d8";
    public static final String testClientSecret = "5c179dfe-0f5a-4124-9690-42b69ec3aef7";
    public static final String testRediectUrl = "http://121.41.52.18:8080/callback";
    public static final String TestRefreshToken = "bceecd8b-ba45-4aca-8c4e-a80ed253f9f2";
    private static Connection connection = Connection.buildConnection(testClientID, testClientSecret, testRediectUrl);

    //    public String clientId = Config.testClientID;
    //    public String clientSecret = Config.testClientSecret;
    //    public String rediectUrl = Config.testRediectUrl;
    public long testFileId = 501000511232L;

    public TApiFile() {
//        AuthApi.getTokenByAuthCode("5KmOCG");
//        connection.setRefreshToken(TestRefreshToken);
        Config.setAllowOutputJsonResult(true);
        connection.setRefreshToken(TestRefreshToken);
        connection.setApplyTokenDate(1);

//        connection.setAccessToken("9d11b455-9274-43cf-a042-539872a2729e");
    }

    /**
     * 根据id获取文件信息
     */
    @Test
    public void TgetFileInfo() {

        Config.setOpenLogOutput(true);
        FileApi fileApi = new FileApi();
        FileInfo fileInfo = fileApi.getFileInfo(testFileId);
        Assert.assertEquals("出现错误", "xuning", fileInfo.getOwnedBy().getName());
        Assert.assertTrue("没有正确返回信息", fileInfo.getSuccess());
    }

    /**
     * 更新文件
     */
    @Test
    public void TUpdateFile() {
        connection.setRefreshToken(TestRefreshToken);
        connection.setApplyTokenDate(1);
        FileInfo fileInfoOutput1 = FileApi.updateFile(testFileId, "dog.jpg", "ning update");
        System.out.println(fileInfoOutput1.getName());
        System.out.println(fileInfoOutput1.getModifiedAt());
        System.out.println("测试结果：" + fileInfoOutput1.getSuccess());
        Assert.assertEquals("xuning", fileInfoOutput1.getOwnedBy().getName());
    }

    /**
     * http协议，编码问题，已解决
     * 删除文件
     */
    @Test
    public void TDeleteFile() {
        Result resultOutput = FileApi.deleteFile(testFileId);
        System.out.println(resultOutput.getSuccess());
    }

    /**
     * 从回收站指定删除文件
     */
    @Test
    public void TDeleteFileFromTrash() {
        Result resultOutput = FileApi.deleteFileFromTrash(false, testFileId);
        System.out.println(resultOutput.getSuccess());
    }

    /**
     * 从回收站恢复指定的文件,因api存在问题，所以这里
     * 无法单元测试
     */
    @Test
    public void TrecoveryFileFromTrash() {
        Result resultOutput = FileApi.recoveryFileFromTrash(true);
        System.out.println(resultOutput.getSuccess());
    }

    /**
     * 测试移动文件
     */
    @Test
    public void TmoveFile() {
        List<Long> longs = new ArrayList<>();
        longs.add(testFileId);
        Result resultOutput = FileApi.moveFile(longs, 501000031450L);
        System.out.println(resultOutput.getSuccess());
    }

    /**
     * 测试上传文件
     */
    @Test
    public void TuploadFile() {
        FilePresignUpload filePresignUploadOutput = FileApi.uploadFile(501000031450L, "xuning的上传");
        System.out.println(filePresignUploadOutput.getSuccess());
        System.out.println(filePresignUploadOutput.getPresignUrl());
    }

    /**
     * 获取新版本上传地址
     */
    @Test
    public void TupdateNewVersionFile() {
        FilePresignUpload filePresignUploadOutput = FileApi.newVersion(501000511231L, "dog1", "test上传");
        System.out.println(filePresignUploadOutput.getSuccess());
        System.out.println(filePresignUploadOutput.getPresignUrl());
    }

    /**
     * 获取文件的下载地址
     */
    @Test
    public void TGetFileDownloadUrl() {
        FilePresignDownload filePresignDownloadOutput = FileApi.download(testFileId);
        System.out.println(filePresignDownloadOutput.getSuccess());
        Map<Long, String> stringMap = filePresignDownloadOutput.getDownloadTargetIdToDownloadUrl();
        System.out.println(stringMap.get(testFileId));
    }

    /**
     * 获取文件的预览信息
     */
    @Test
    public void TpreviewInfo() {
        FilePreviewInfo filePreviewInfoOutput = FileApi.preview(testFileId, false, PreviewKind.IMAGE_64.getValue());
        System.out.println(filePreviewInfoOutput.getSuccess());
        System.out.println(filePreviewInfoOutput.getCategory());
    }

    /**
     * 获取文件预览转换后的下载地址
     */
    @Test
    public void TpreviewDownloadURl() {
        FilePreviewDownload filePreviewInfoOutput = FileApi.previewDownload(testFileId, 0, PreviewKind.IMAGE_64.getValue());
        System.out.println(filePreviewInfoOutput.getSuccess());
        System.out.println(filePreviewInfoOutput.getDownloadUrl());
    }

    /**
     * 获取预览嵌入的URl
     */
    @Test
    public void TGetPreviewIframeURL() {
        String previewUrl = FileApi.getPreviewFrameUrl(testFileId, "dog.jpg");
        System.out.println(previewUrl);
    }

    /**
     * 复制文件到指定的文件夹
     */
    @Test
    public void TcopyFile() {
        Create createOutput = FileApi.copyFile(testFileId, 501000031450L, false);
        System.out.println(createOutput.getSuccess());
        System.out.println(createOutput.getNewFile().getName());
    }

}
