package com.fangcloud.sdk.api;

import com.fangcloud.sdk.bean.input.folder.CreateFolderBean;
import com.fangcloud.sdk.bean.input.folder.DeleteFolderBean;
import com.fangcloud.sdk.bean.input.folder.DeleteFolderFromTrashBean;
import com.fangcloud.sdk.bean.input.folder.MoveFolderBean;
import com.fangcloud.sdk.bean.input.folder.RestoreFolderFromTrashBean;
import com.fangcloud.sdk.bean.input.folder.UpdateFolderBean;
import com.fangcloud.sdk.bean.output.folder.CreateFolder;
import com.fangcloud.sdk.bean.output.folder.DeleteFolder;
import com.fangcloud.sdk.bean.output.folder.FolderInfo;
import com.fangcloud.sdk.bean.output.folder.MoveFolder;
import com.fangcloud.sdk.bean.output.folder.RestoreFolderFromTrash;
import com.fangcloud.sdk.bean.output.folder.UpdateFolder;
import com.fangcloud.sdk.bean.output.item.ItemList;
import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.core.Connection;
import com.fangcloud.sdk.request.Header;
import com.fangcloud.sdk.request.RequestClient;
import com.fangcloud.sdk.request.RequestOption;
import com.fangcloud.sdk.util.TransformationUtil;
import com.fangcloud.sdk.util.UrlTemplate;

import java.util.List;

public class FolderApi {

    private static final UrlTemplate INFO = new UrlTemplate("/folder/%s/info");
    private static final UrlTemplate CREATE = new UrlTemplate("/folder/create");
    private static final UrlTemplate UPDATE = new UrlTemplate("/folder/%s/update");
    private static final UrlTemplate DELETE = new UrlTemplate("folder/delete");
    private static final UrlTemplate DELETE_FROM_TRASH = new UrlTemplate("/folder/delete_from_trash");
    private static final UrlTemplate RESTORE_FROM_TRASH = new UrlTemplate("/folder/restore_from_trash");
    private static final UrlTemplate MOVE = new UrlTemplate("/folder/move");
    private static final UrlTemplate CHRLDREN = new UrlTemplate("/folder/children");
    private static Connection connection = Connection.getConnection();
    private static List<Header> headers = RequestOption.getApiCommonHeader(connection);
    private static FolderApi folderApi = new FolderApi();

    public FolderApi() {
    }

    public static FolderApi getFolderApi() {
        return folderApi;
    }

    /**
     * 获取文件夹信息
     *
     * @param id
     * @return
     */
    public static FolderInfo getFolderInfo(long id) {
        String url = INFO.build(Config.DEFAULT_API_URI, id);
        RequestClient requestClient = new RequestClient().openRequest(url, "get", headers, null, null);
        return (FolderInfo) TransformationUtil.requestClientToOutputObject(requestClient, FolderInfo.class);
    }

    /**
     * 创建一个文件夹
     *
     * @param name
     * @param parentId
     * @return
     */
    public static CreateFolder createFolder(String name, long parentId) {
        String url = CREATE.build(Config.DEFAULT_API_URI);
        CreateFolderBean createFolderBean = new CreateFolderBean(name, parentId);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(createFolderBean);
        RequestClient requestClient = new RequestClient().openRequest(url, "post", headers, null, postBodyJsonString);
        return (CreateFolder) TransformationUtil.requestClientToOutputObject(requestClient, CreateFolder.class);
    }

    /**
     * 更新文件夹
     *
     * @param id
     * @param newName
     * @return
     */
    public static UpdateFolder updateFolder(long id, String newName) {
        String url = UPDATE.build(Config.DEFAULT_API_URI, id);
        UpdateFolderBean updateFolderBean = new UpdateFolderBean(newName);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(updateFolderBean);
        RequestClient requestClient = new RequestClient().openRequest(url, "put", headers, null, postBodyJsonString);
        return (UpdateFolder) TransformationUtil.requestClientToOutputObject(requestClient, UpdateFolder.class);
    }

    /**
     * 删除文件夹
     *
     * @param folderIds
     * @return
     */
    public static DeleteFolder deleteFolder(long... folderIds) {
        String url = DELETE.build(Config.DEFAULT_API_URI);
        List<Long> idArrayList = TransformationUtil.ArrToArrayListpostBody(folderIds);
        DeleteFolderBean deleteFolderBean = new DeleteFolderBean(idArrayList);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(deleteFolderBean);
        RequestClient requestClient = new RequestClient().openRequest(url, "delete", headers, null, postBodyJsonString);
        return (DeleteFolder) TransformationUtil.requestClientToOutputObject(requestClient, DeleteFolder.class);
    }

    /**
     * 从回收站删除文件夹，支持清空
     *
     * @param folderIds
     * @param clearTrash
     * @return
     */
    public static DeleteFolder deleteFolderFromTrash(List<Long> folderIds, boolean clearTrash) {
        String url = DELETE_FROM_TRASH.build(Config.DEFAULT_API_URI);
        DeleteFolderFromTrashBean deleteFolderFromTrashBean = new DeleteFolderFromTrashBean(folderIds, clearTrash);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(deleteFolderFromTrashBean);
        RequestClient requestClient = new RequestClient().openRequest(url, "delete", headers, null, postBodyJsonString);
        return (DeleteFolder) TransformationUtil.requestClientToOutputObject(requestClient, DeleteFolder.class);
    }

    /**
     * 从回收站恢复文件
     *
     * @param folderIds
     * @param restoreAll
     * @return
     */
    public static RestoreFolderFromTrash recoveryFolderFromTrash(List<Long> folderIds, boolean restoreAll) {
        String url = DELETE_FROM_TRASH.build(Config.DEFAULT_API_URI);
        RestoreFolderFromTrashBean restoreFolderFromTrashBean = new RestoreFolderFromTrashBean(restoreAll, folderIds);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(restoreFolderFromTrashBean);
        RequestClient requestClient = new RequestClient().openRequest(url, "post", headers, null, postBodyJsonString);
        return (RestoreFolderFromTrash) TransformationUtil.requestClientToOutputObject(requestClient, RestoreFolderFromTrash.class);
    }

    /**
     * 移动文件夹到指定文件夹
     *
     * @param folderIds
     * @param targetFolderId
     * @return
     */
    public static MoveFolder moveFolder(List<Long> folderIds, long targetFolderId) {
        String url = MOVE.build(Config.DEFAULT_API_URI);
        MoveFolderBean moveFolderBean = new MoveFolderBean(folderIds, targetFolderId);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(moveFolderBean);
        RequestClient requestClient = new RequestClient().openRequest(url, "post", headers, null, postBodyJsonString);
        return (MoveFolder) TransformationUtil.requestClientToOutputObject(requestClient, MoveFolder.class);
    }

    /**
     * 获取单层子文件和文件夹列表
     *
     * @param folderId
     * @param pageId
     * @param pageCapacity
     * @param type
     * @return
     */
    public static ItemList getChildren(long folderId, int pageId, int pageCapacity, String type) {
        String baseUrl = CHRLDREN.build(Config.DEFAULT_API_URI);
        String url = String.format(baseUrl + "?folder_id=%s&page_id=%s&page_capacity=%s&type=%s", folderId, pageId, pageCapacity, type);
        RequestClient requestClient = new RequestClient().openRequest(url, "get", headers, null, null);
        return (ItemList) TransformationUtil.requestClientToOutputObject(requestClient, ItemList.class);
    }

}
