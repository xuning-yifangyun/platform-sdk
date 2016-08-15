package com.fangcloud.sdk;

import com.fangcloud.sdk.api.FileApi;
import com.fangcloud.sdk.bean.input.file.PreviewKind;
import com.fangcloud.sdk.bean.output.ResultOutput;
import com.fangcloud.sdk.bean.output.file.CreateOutput;
import com.fangcloud.sdk.bean.output.file.FileInfoOutput;
import com.fangcloud.sdk.bean.output.file.FilePresignDownloadOutput;
import com.fangcloud.sdk.bean.output.file.FilePresignUploadOutput;
import com.fangcloud.sdk.bean.output.file.FilePreviewDownloadOutput;
import com.fangcloud.sdk.bean.output.file.FilePreviewInfoOutput;
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

    public String clientId = "bbe8e63d-89b0-4f31-ba07-5fd602d501d8";
    public String clientSecret = "5c179dfe-0f5a-4124-9690-42b69ec3aef7";
    public String rediectUrl = "http://121.41.52.18:8080/callback";
    public long testFileId = 501000511232L;
    public Connection connection = new Connection(clientId, clientSecret, rediectUrl);

    /**
     * 根据id获取文件信息
     */
    @Test
    public void TgetileInfo() {
        Connection connection = new Connection(clientId, clientSecret, rediectUrl);
        connection.setAccessToken(Config.TestAccessToken);
        FileInfoOutput fileInfoOutput = new FileInfoOutput();
        FileApi fileApi = new FileApi(connection);
        FileInfoOutput fileInfo = fileApi.getFileInfo(testFileId);
        Assert.assertEquals("出现错误", "xuning", fileInfo.getOwnedBy().getName());
        Assert.assertTrue("没有正确返回信息", fileInfoOutput.getSuccess());
    }

    /**
     * 更新文件
     */
    @Test
    public void TUpdateFile() {
        Connection connection = new Connection(clientId, clientSecret, rediectUrl);
        connection.setAccessToken(Config.TestAccessToken);
        FileApi fileApi = new FileApi(connection);
        FileInfoOutput fileInfoOutput1 = fileApi.updateFile(testFileId, "dog.jpg", "这是徐宁的修改");
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
        Connection connection = new Connection(clientId, clientSecret, rediectUrl);
        connection.setAccessToken(Config.TestAccessToken);
        FileApi fileApi = new FileApi(connection);
        ResultOutput resultOutput = fileApi.deleteFile(testFileId);
        System.out.println(resultOutput.getSuccess());
    }

    /**
     * 从回收站指定删除文件
     */
    @Test
    public void TDeleteFileFromTrash() {
        Connection connection = new Connection(clientId, clientSecret, rediectUrl);
        connection.setAccessToken(Config.TestAccessToken);
        FileApi fileApi = new FileApi(connection);
        ResultOutput resultOutput = fileApi.deleteFileFromTrash(false, testFileId);
        System.out.println(resultOutput.getSuccess());
    }

    /**
     * 从回收站恢复指定的文件,因api存在问题，所以这里
     * 无法单元测试
     */
    @Test
    public void TrecoveryFileFromTrash() {
        Connection connection = new Connection(clientId, clientSecret, rediectUrl);
        connection.setAccessToken(Config.TestAccessToken);
        FileApi fileApi = new FileApi(connection);
        ResultOutput resultOutput = fileApi.recoveryFileFromTrash(true);
        System.out.println(resultOutput.getSuccess());
    }

    /**
     * 测试移动文件
     */
    @Test
    public void TmoveFile() {
        Connection connection = new Connection(clientId, clientSecret, rediectUrl);
        connection.setAccessToken(Config.TestAccessToken);
        FileApi fileApi = new FileApi(connection);
        List<Long> longs = new ArrayList<>();
        longs.add(testFileId);
        ResultOutput resultOutput = fileApi.moveFile(longs, 501000031450L);
        System.out.println(resultOutput.getSuccess());
    }

    /**
     * 测试上传文件
     */
    @Test
    public void TuploadFile() {
        Connection connection = new Connection(clientId, clientSecret, rediectUrl);
        connection.setAccessToken(Config.TestAccessToken);
        FileApi fileApi = new FileApi(connection);
        FilePresignUploadOutput filePresignUploadOutput = fileApi.uploadFile(501000031450L, "xuning的上传");
        System.out.println(filePresignUploadOutput.getSuccess());
        System.out.println(filePresignUploadOutput.getPresignUrl());
    }

    /**
     * 获取新版本上传地址
     */
    @Test
    public void TupdateNewVersionFile() {
        Connection connection = new Connection(clientId, clientSecret, rediectUrl);
        connection.setAccessToken(Config.TestAccessToken);
        FileApi fileApi = new FileApi(connection);
        FilePresignUploadOutput filePresignUploadOutput = fileApi.newVersion(501000511231L, "dog1", "test上传");
        System.out.println(filePresignUploadOutput.getSuccess());
        System.out.println(filePresignUploadOutput.getPresignUrl());
    }

    /**
     * 获取文件的下载地址
     */
    @Test
    public void TGetFileDownloadUrl() {
        Connection connection = new Connection(clientId, clientSecret, rediectUrl);
        connection.setAccessToken(Config.TestAccessToken);
        FileApi fileApi = new FileApi(connection);
        FilePresignDownloadOutput filePresignDownloadOutput = fileApi.download(testFileId);
        System.out.println(filePresignDownloadOutput.getSuccess());
        Map<Long, String> stringMap = filePresignDownloadOutput.getDownloadTargetIdToDownloadUrl();
        System.out.println(stringMap.get(testFileId));
    }

    /**
     * 获取文件的预览信息
     */
    @Test
    public void TpreviewInfo() {
        Connection connection = new Connection(clientId, clientSecret, rediectUrl);
        connection.setAccessToken(Config.TestAccessToken);
        FileApi fileApi = new FileApi(connection);
        FilePreviewInfoOutput filePreviewInfoOutput = fileApi.preview(testFileId, false, PreviewKind.IMAGE_64.getValue());
        System.out.println(filePreviewInfoOutput.getSuccess());
        System.out.println(filePreviewInfoOutput.getCategory());
    }

    /**
     * 获取文件预览转换后的下载地址
     */
    @Test
    public void TpreviewDownloadURl() {
        Connection connection = new Connection(clientId, clientSecret, rediectUrl);
        connection.setAccessToken(Config.TestAccessToken);
        FileApi fileApi = new FileApi(connection);
        FilePreviewDownloadOutput filePreviewInfoOutput = fileApi.previewDownload(testFileId, 0, PreviewKind.IMAGE_64.getValue());
        System.out.println(filePreviewInfoOutput.getSuccess());
        System.out.println(filePreviewInfoOutput.getDownloadUrl());
    }

    /**
     * 获取预览嵌入的URl
     */
    @Test
    public void TGetPreviewIframeURL() {
        Connection connection = new Connection(clientId, clientSecret, rediectUrl);
        connection.setAccessToken(Config.TestAccessToken);
        FileApi fileApi = new FileApi(connection);
        String previewUrl = fileApi.getPreviewFrameUrl(testFileId, "dog.jpg");
        System.out.println(previewUrl);
    }

    /**
     * 复制文件到指定的文件夹
     */
    @Test
    public void TcopyFile() {
        Connection connection = new Connection(clientId, clientSecret, rediectUrl);
        connection.setAccessToken(Config.TestAccessToken);
        FileApi fileApi = new FileApi(connection);
        CreateOutput createOutput = fileApi.copyFile(testFileId, 501000031450L, false);
        System.out.println(createOutput.getSuccess());
        System.out.println(createOutput.getNewFile().getName());
    }

}
