package com.fangcloud.sdk.api;

import com.fangcloud.sdk.bean.input.file.CopyFileBean;
import com.fangcloud.sdk.bean.input.file.DeleteFileBean;
import com.fangcloud.sdk.bean.input.file.DeleteFileFromTrashBean;
import com.fangcloud.sdk.bean.input.file.FilePreviewBean;
import com.fangcloud.sdk.bean.input.file.FilePreviewDownloadBean;
import com.fangcloud.sdk.bean.input.file.MoveFileBean;
import com.fangcloud.sdk.bean.input.file.RestoreFileFromTrashBean;
import com.fangcloud.sdk.bean.input.file.UpdateFileBean;
import com.fangcloud.sdk.bean.input.file.UploadFileBean;
import com.fangcloud.sdk.bean.input.file.UploadNewVersionBean;
import com.fangcloud.sdk.bean.input.file.UploadType;
import com.fangcloud.sdk.request.RequestOption;
import com.fangcloud.sdk.bean.output.ResultOutput;
import com.fangcloud.sdk.bean.output.file.CreateOutput;
import com.fangcloud.sdk.bean.output.file.FileInfoOutput;
import com.fangcloud.sdk.bean.output.file.FilePresignDownloadOutput;
import com.fangcloud.sdk.bean.output.file.FilePresignUploadOutput;
import com.fangcloud.sdk.bean.output.file.FilePreviewDownloadOutput;
import com.fangcloud.sdk.bean.output.file.FilePreviewInfoOutput;
import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.core.Connection;
import com.fangcloud.sdk.request.Header;
import com.fangcloud.sdk.request.RequestClient;
import com.fangcloud.sdk.util.TransformationUtil;
import com.fangcloud.sdk.util.UrlTemplate;

import java.util.ArrayList;
import java.util.List;

public class FileApi {
    private Connection connection;
    private ArrayList<Header> headers;
    private static final UrlTemplate INFO = new UrlTemplate("/file/%s/info");
    private static final UrlTemplate UPDATE = new UrlTemplate("/file/%s/update");
    private static final UrlTemplate DELETE = new UrlTemplate("/file/delete");
    private static final UrlTemplate DELETE_FROM_TRASH = new UrlTemplate("/file/delete_from_trash");
    private static final UrlTemplate RECOVERY_FROM_TRASH = new UrlTemplate("/file/restore_from_trash");
    private static final UrlTemplate MOVE = new UrlTemplate("/file/move");
    private static final UrlTemplate UPLOAD = new UrlTemplate("/file/upload");
    private static final UrlTemplate NEW_VERSION = new UrlTemplate("/file/%s/new_version");
    private static final UrlTemplate DOWNLOAD = new UrlTemplate("/file/%s/download");
    private static final UrlTemplate PREVIEW = new UrlTemplate("/file/%s/preview");
    private static final UrlTemplate PREVIEW_DOWNLOAD = new UrlTemplate("/file/%s/preview_download");
    private static final UrlTemplate PREVIEW_IFRAME = new UrlTemplate("/preview/preview.html");
    private static final UrlTemplate COPY = new UrlTemplate("/file/copy");

    public FileApi(Connection connection) {
        this.connection = connection;
        this.headers = RequestOption.getApiCommonHeader(this.connection);
    }

    /**
     * 获取文件信息
     *
     * @param id
     * @return
     */
    public FileInfoOutput getFileInfo(long id) {
        String url = INFO.build(Config.DEFAULT_API_URI, id);
        RequestClient requestClient = new RequestClient(url, "get", headers, null, null);
        return (FileInfoOutput) TransformationUtil.requestClientToOutputObject(requestClient, FileInfoOutput.class);
    }

    /**
     * 更新文件信息
     *
     * @param id
     * @param newName
     * @param newDescription
     * @return
     */
    public FileInfoOutput updateFile(long id, String newName, String newDescription) {
        String url = UPDATE.build(Config.DEFAULT_API_URI, id);
        UpdateFileBean updateFileBean = new UpdateFileBean(newName, newDescription);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(updateFileBean);
        RequestClient requestClient = new RequestClient(url, "put", headers, null, postBodyJsonString);
        return (FileInfoOutput) TransformationUtil.requestClientToOutputObject(requestClient, FileInfoOutput.class);
    }

    /**
     * 删除多个文件，支持批量删除
     *
     * @param fileIds
     * @return
     */
    public ResultOutput deleteFile(long... fileIds) {
        String url = DELETE.build(Config.DEFAULT_API_URI);
        List<Long> idArrayList = TransformationUtil.ArrToArrayListpostBody(fileIds);
        DeleteFileBean deleteFileBody = new DeleteFileBean(idArrayList);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(deleteFileBody);
        RequestClient requestClient = new RequestClient(url, "delete", headers, null, postBodyJsonString);
        return (ResultOutput) TransformationUtil.requestClientToOutputObject(requestClient, ResultOutput.class);
    }

    /**
     * 从回收站删除指定文件，支持批量删除
     *
     * @param fileIds
     * @return
     */
    public ResultOutput deleteFileFromTrash(boolean clear_trash, long... fileIds) {
        String url = DELETE_FROM_TRASH.build(Config.DEFAULT_API_URI);
        List<Long> idArrayList = TransformationUtil.ArrToArrayListpostBody(fileIds);
        DeleteFileFromTrashBean deleteFileBody = new DeleteFileFromTrashBean(idArrayList, clear_trash);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(deleteFileBody);
        RequestClient requestClient = new RequestClient(url, "delete", headers, null, postBodyJsonString);
        return (ResultOutput) TransformationUtil.requestClientToOutputObject(requestClient, ResultOutput.class);
    }

//    /**
//     * 清空回收站
//     *
//     * @param clear_trash
//     * @return
//     */
//    public ResultOutput deleteAllFileFromTrash(boolean clear_trash) {
//        String url = DELETE_FROM_TRASH.build(Config.DEFAULT_API_URI);
//        DeleteFileFromTrashBean deleteFileBody = new DeleteFileFromTrashBean(null,clear_trash);
//        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(deleteFileBody);
//        RequestClient requestClient = new RequestClient(url, "delete", headers, null, postBodyJsonString);
//        return (ResultOutput) TransformationUtil.requestClientToOutputObject(requestClient, ResultOutput.class);
//    }

    /**
     * 从回收站恢复指定文件，支持批量恢复
     *
     * @param fileIds
     * @return
     */
    public ResultOutput recoveryFileFromTrash(boolean restoreAll, long... fileIds) {
        String url = RECOVERY_FROM_TRASH.build(Config.DEFAULT_API_URI);
        List<Long> idArrayList = TransformationUtil.ArrToArrayListpostBody(fileIds);
        RestoreFileFromTrashBean deleteFileBody = new RestoreFileFromTrashBean(restoreAll,idArrayList);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(deleteFileBody);
        RequestClient requestClient = new RequestClient(url, "post", headers, null, postBodyJsonString);
        return (ResultOutput) TransformationUtil.requestClientToOutputObject(requestClient, ResultOutput.class);
    }

//    /**
//     * 从回收站恢复所有的文件
//     *
//     * @param restoreAll
//     * @return
//     */
//    public ResultOutput recoveryAllFileFromTrash(boolean restoreAll) {
//        String url = RECOVERY_FROM_TRASH.build(Config.DEFAULT_API_URI);
//        RecoveryFileBody recoveryFileBody = new RecoveryFileBody(restoreAll);
//        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(recoveryFileBody);
//        RequestClient requestClient = new RequestClient(url, "post", headers, null, postBodyJsonString);
//        return (ResultOutput) TransformationUtil.requestClientToOutputObject(requestClient, ResultOutput.class);
//    }

    /**
     * 移动文件到指定文件夹
     *
     * @param fileIds
     * @param target_folder_id
     * @return
     */
    public ResultOutput moveFile(List<Long> fileIds, long target_folder_id) {
        String url = MOVE.build(Config.DEFAULT_API_URI);
        MoveFileBean moveFileBean = new MoveFileBean(fileIds, target_folder_id);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(moveFileBean);
        RequestClient requestClient = new RequestClient(url, "post", headers, null, postBodyJsonString);
        return (ResultOutput) TransformationUtil.requestClientToOutputObject(requestClient, ResultOutput.class);
    }

    /**
     * 获取文件上传地址
     *
     * @param parentId
     * @param name
     * @return
     */
    public FilePresignUploadOutput uploadFile(long parentId, String name) {
        String url = UPLOAD.build(Config.DEFAULT_API_URI);
        UploadFileBean uploadFileBean = new UploadFileBean(parentId, name, UploadType.API);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(uploadFileBean);
        RequestClient requestClient = new RequestClient(url, "post", headers, null, postBodyJsonString);
        return (FilePresignUploadOutput) TransformationUtil.requestClientToOutputObject(requestClient, FilePresignUploadOutput.class);
    }

    /**
     * 获取文件上传新版本地址
     *
     * @param id
     * @param name
     * @param remark
     * @return
     */
    public FilePresignUploadOutput newVersion(long id, String name, String remark) {
        String url = NEW_VERSION.build(Config.DEFAULT_API_URI, id);
        UploadNewVersionBean uploadNewVersionBean = new UploadNewVersionBean(id, name, UploadType.API, remark);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(uploadNewVersionBean);
        RequestClient requestClient = new RequestClient(url, "post", headers, null, postBodyJsonString);
        return (FilePresignUploadOutput) TransformationUtil.requestClientToOutputObject(requestClient, FilePresignUploadOutput.class);
    }

    /**
     * 获取文件下载地址
     *
     * @param id
     * @return
     */
    public FilePresignDownloadOutput download(long id) {
        String url = DOWNLOAD.build(Config.DEFAULT_API_URI, id);
        RequestClient requestClient = new RequestClient(url, "get", headers, null, null);
        return (FilePresignDownloadOutput) TransformationUtil.requestClientToOutputObject(requestClient, FilePresignDownloadOutput.class);
    }

    /**
     * 返回预览信息
     *
     * @param id
     * @param forceRegenerate
     * @param kind
     * @return
     */
    public FilePreviewInfoOutput preview(long id, boolean forceRegenerate, String kind) {
        String url = PREVIEW.build(Config.DEFAULT_API_URI, id);
        FilePreviewBean filePreviewBean = new FilePreviewBean(kind, forceRegenerate);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(filePreviewBean);
        RequestClient requestClient = new RequestClient(url, "post", headers, null, postBodyJsonString);
        return (FilePreviewInfoOutput) TransformationUtil.requestClientToOutputObject(requestClient, FilePreviewInfoOutput.class);
    }

    /**
     * 获取预览后的下载地址
     *
     * @param id
     * @param pageIndex
     * @param kind
     * @return
     */
    public FilePreviewDownloadOutput previewDownload(long id, int pageIndex, String kind) {
        String url = PREVIEW_DOWNLOAD.build(Config.DEFAULT_API_URI, id);
        FilePreviewDownloadBean filePreviewDownloadBean = new FilePreviewDownloadBean(kind, pageIndex);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(filePreviewDownloadBean);
        RequestClient requestClient = new RequestClient(url, "post", headers, null, postBodyJsonString);
        return (FilePreviewDownloadOutput) TransformationUtil.requestClientToOutputObject(requestClient, FilePreviewDownloadOutput.class);
    }

    /**
     * 获取文件预览嵌入URL
     *
     * @param fileId
     * @param fileName
     * @return
     */
    public String getPreviewFrameUrl(long fileId, String fileName) {
        String baseUrl = PREVIEW_IFRAME.build(Config.DEFAULT_API_URI);
        String url = String.format(baseUrl + "?access_token=%s&file_id=%s&file_name=%s", this.connection.getAccessToken(), fileId, fileName);
        return url;
    }

    /**
     * 复制文件到指定文件夹
     *
     * @param fileId
     * @param targetFolderId
     * @param checkConflict
     * @return
     */
    public CreateOutput copyFile(long fileId, long targetFolderId, boolean checkConflict) {
        String url = COPY.build(Config.DEFAULT_API_URI);
        CopyFileBean copyFileBean = new CopyFileBean(fileId, targetFolderId, checkConflict);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(copyFileBean);
        RequestClient requestClient = new RequestClient(url, "post", headers, null, postBodyJsonString);
        return (CreateOutput) TransformationUtil.requestClientToOutputObject(requestClient, CreateOutput.class);
    }

}