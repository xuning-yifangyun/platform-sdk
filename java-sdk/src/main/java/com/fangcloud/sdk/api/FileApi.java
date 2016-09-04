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
import com.fangcloud.sdk.bean.output.Result;
import com.fangcloud.sdk.bean.output.file.Create;
import com.fangcloud.sdk.bean.output.file.FileInfo;
import com.fangcloud.sdk.bean.output.file.FilePresignDownload;
import com.fangcloud.sdk.bean.output.file.FilePresignUpload;
import com.fangcloud.sdk.bean.output.file.FilePreviewDownload;
import com.fangcloud.sdk.bean.output.file.FilePreviewInfo;
import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.core.Connection;
import com.fangcloud.sdk.request.Header;
import com.fangcloud.sdk.request.RequestClient;
import com.fangcloud.sdk.request.RequestOption;
import com.fangcloud.sdk.util.TransformationUtil;
import com.fangcloud.sdk.util.UrlTemplate;

import java.util.ArrayList;
import java.util.List;

public class FileApi {

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

    private static Connection connection = Connection.getConnection();
    private static ArrayList<Header> headers = RequestOption.getApiCommonHeader(connection);
    private static FileApi fileApi = new FileApi();

    public static FileApi getFileApi() {
        return fileApi;
    }



    /**
     * 获取文件信息
     *
     * @param id
     * @return
     */
    public static FileInfo getFileInfo(long id) {
        String url = INFO.build(Config.DEFAULT_API_URI, id);
//        RequestClient requestClient = RequestClient.buildRequest(url, "get", headers);
        RequestClient requestClient=new RequestClient().openRequest(url,"get", headers, null, null);
        return (FileInfo) TransformationUtil.requestClientToOutputObject(requestClient, FileInfo.class);
    }

    /**
     * 更新文件信息
     *
     * @param id
     * @param newName
     * @param newDescription
     * @return
     */
    public static FileInfo updateFile(long id, String newName, String newDescription) {
        String url = UPDATE.build(Config.DEFAULT_API_URI, id);
        UpdateFileBean updateFileBean = new UpdateFileBean(newName, newDescription);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(updateFileBean);
        RequestClient requestClient = new RequestClient().openRequest(url, "put", headers, null, postBodyJsonString);
        return (FileInfo) TransformationUtil.requestClientToOutputObject(requestClient, FileInfo.class);
    }

    /**
     * 删除多个文件，支持批量删除
     *
     * @param fileIds
     * @return
     */
    public static Result deleteFile(long... fileIds) {
        String url = DELETE.build(Config.DEFAULT_API_URI);
        List<Long> idArrayList = TransformationUtil.ArrToArrayListpostBody(fileIds);
        DeleteFileBean deleteFileBody = new DeleteFileBean(idArrayList);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(deleteFileBody);
        RequestClient requestClient = new RequestClient().openRequest(url, "delete", headers, null, postBodyJsonString);
        return (Result) TransformationUtil.requestClientToOutputObject(requestClient, Result.class);
    }

    /**
     * 从回收站删除指定文件，支持批量删除
     *
     * @param fileIds
     * @return
     */
    public static Result deleteFileFromTrash(boolean clear_trash, long... fileIds) {
        String url = DELETE_FROM_TRASH.build(Config.DEFAULT_API_URI);
        List<Long> idArrayList = TransformationUtil.ArrToArrayListpostBody(fileIds);
        DeleteFileFromTrashBean deleteFileBody = new DeleteFileFromTrashBean(idArrayList, clear_trash);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(deleteFileBody);
        RequestClient requestClient = new RequestClient().openRequest(url, "delete", headers, null, postBodyJsonString);
        return (Result) TransformationUtil.requestClientToOutputObject(requestClient, Result.class);
    }

    /**
     * 从回收站恢复指定文件，支持批量恢复
     *
     * @param fileIds
     * @return
     */
    public static Result recoveryFileFromTrash(boolean restoreAll, long... fileIds) {
        String url = RECOVERY_FROM_TRASH.build(Config.DEFAULT_API_URI);
        List<Long> idArrayList = TransformationUtil.ArrToArrayListpostBody(fileIds);
        RestoreFileFromTrashBean deleteFileBody = new RestoreFileFromTrashBean(restoreAll, idArrayList);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(deleteFileBody);
        RequestClient requestClient = new RequestClient().openRequest(url, "post", headers, null, postBodyJsonString);
        return (Result) TransformationUtil.requestClientToOutputObject(requestClient, Result.class);
    }

    /**
     * 移动文件到指定文件夹
     *
     * @param fileIds
     * @param target_folder_id
     * @return
     */
    public static Result moveFile(List<Long> fileIds, long target_folder_id) {
        String url = MOVE.build(Config.DEFAULT_API_URI);
        MoveFileBean moveFileBean = new MoveFileBean(fileIds, target_folder_id);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(moveFileBean);
        RequestClient requestClient = new RequestClient().openRequest(url, "post", headers, null, postBodyJsonString);
        return (Result) TransformationUtil.requestClientToOutputObject(requestClient, Result.class);
    }

    /**
     * 获取文件上传地址
     *
     * @param parentId
     * @param name
     * @return
     */
    public static FilePresignUpload uploadFile(long parentId, String name) {
        String url = UPLOAD.build(Config.DEFAULT_API_URI);
        UploadFileBean uploadFileBean = new UploadFileBean(parentId, name, UploadType.API);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(uploadFileBean);
        RequestClient requestClient = new RequestClient().openRequest(url, "post", headers, null, postBodyJsonString);
        return (FilePresignUpload) TransformationUtil.requestClientToOutputObject(requestClient, FilePresignUpload.class);
    }

    /**
     * 获取文件上传新版本地址
     *
     * @param id
     * @param name
     * @param remark
     * @return
     */
    public static FilePresignUpload newVersion(long id, String name, String remark) {
        String url = NEW_VERSION.build(Config.DEFAULT_API_URI, id);
        UploadNewVersionBean uploadNewVersionBean = new UploadNewVersionBean(id, name, UploadType.API, remark);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(uploadNewVersionBean);
        RequestClient requestClient = new RequestClient().openRequest(url, "post", headers, null, postBodyJsonString);
        return (FilePresignUpload) TransformationUtil.requestClientToOutputObject(requestClient, FilePresignUpload.class);
    }

    /**
     * 获取文件下载地址
     *
     * @param id
     * @return
     */
    public static FilePresignDownload download(long id) {
        String url = DOWNLOAD.build(Config.DEFAULT_API_URI, id);
        RequestClient requestClient = new RequestClient().openRequest(url, "get", headers, null, null);
        return (FilePresignDownload) TransformationUtil.requestClientToOutputObject(requestClient, FilePresignDownload.class);
    }

    /**
     * 返回预览信息
     *
     * @param id
     * @param forceRegenerate
     * @param kind
     * @return
     */
    public static FilePreviewInfo preview(long id, boolean forceRegenerate, String kind) {
        String url = PREVIEW.build(Config.DEFAULT_API_URI, id);
        FilePreviewBean filePreviewBean = new FilePreviewBean(kind, forceRegenerate);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(filePreviewBean);
        RequestClient requestClient = new RequestClient().openRequest(url, "post", headers, null, postBodyJsonString);
        return (FilePreviewInfo) TransformationUtil.requestClientToOutputObject(requestClient, FilePreviewInfo.class);
    }

    /**
     * 获取预览后的下载地址
     *
     * @param id
     * @param pageIndex
     * @param kind
     * @return
     */
    public static FilePreviewDownload previewDownload(long id, int pageIndex, String kind) {
        String url = PREVIEW_DOWNLOAD.build(Config.DEFAULT_API_URI, id);
        FilePreviewDownloadBean filePreviewDownloadBean = new FilePreviewDownloadBean(kind, pageIndex);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(filePreviewDownloadBean);
        RequestClient requestClient = new RequestClient().openRequest(url, "post", headers, null, postBodyJsonString);
        return (FilePreviewDownload) TransformationUtil.requestClientToOutputObject(requestClient, FilePreviewDownload.class);
    }

    /**
     * 获取文件预览嵌入URL
     *
     * @param fileId
     * @param fileName
     * @return
     */
    public static String getPreviewFrameUrl(long fileId, String fileName) {
        String baseUrl = PREVIEW_IFRAME.build(Config.DEFAULT_API_URI);
        String url = String.format(baseUrl + "?access_token=%s&file_id=%s&file_name=%s", connection.getAccessToken(), fileId, fileName);
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
    public static Create copyFile(long fileId, long targetFolderId, boolean checkConflict) {
        String url = COPY.build(Config.DEFAULT_API_URI);
        CopyFileBean copyFileBean = new CopyFileBean(fileId, targetFolderId, checkConflict);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(copyFileBean);
        RequestClient requestClient = new RequestClient().openRequest(url, "post", headers, null, postBodyJsonString);
        return (Create) TransformationUtil.requestClientToOutputObject(requestClient, Create.class);
    }

}