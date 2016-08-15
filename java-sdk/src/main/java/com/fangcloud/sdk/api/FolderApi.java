package com.fangcloud.sdk.api;

import com.fangcloud.sdk.bean.input.folder.CreateFolderBean;
import com.fangcloud.sdk.bean.input.folder.DeleteFolderBean;
import com.fangcloud.sdk.bean.input.folder.DeleteFolderFromTrashBean;
import com.fangcloud.sdk.bean.input.folder.MoveFolderBean;
import com.fangcloud.sdk.bean.input.folder.RestoreFolderFromTrashBean;
import com.fangcloud.sdk.bean.input.folder.UpdateFolderBean;
import com.fangcloud.sdk.request.RequestOption;
import com.fangcloud.sdk.bean.output.folder.CreateFolderOutput;
import com.fangcloud.sdk.bean.output.folder.DeleteFolderOutput;
import com.fangcloud.sdk.bean.output.folder.FolderInfoOutput;
import com.fangcloud.sdk.bean.output.folder.MoveFolderOutput;
import com.fangcloud.sdk.bean.output.folder.RestoreFolderFromTrashOutput;
import com.fangcloud.sdk.bean.output.folder.UpdateFolderOutput;
import com.fangcloud.sdk.bean.output.item.ItemListOutput;
import com.fangcloud.sdk.core.Config;
import com.fangcloud.sdk.core.Connection;
import com.fangcloud.sdk.request.Header;
import com.fangcloud.sdk.request.RequestClient;
import com.fangcloud.sdk.util.TransformationUtil;
import com.fangcloud.sdk.util.UrlTemplate;

import java.util.List;

public class FolderApi {
    private Connection connection;
    private List<Header> headers;
    private static final UrlTemplate INFO = new UrlTemplate("/folder/%s/info");
    private static final UrlTemplate CREATE = new UrlTemplate("/folder/create");
    private static final UrlTemplate UPDATE = new UrlTemplate("/folder/%s/update");
    private static final UrlTemplate DELETE = new UrlTemplate("folder/delete");
    private static final UrlTemplate DELETE_FROM_TRASH = new UrlTemplate("/folder/delete_from_trash");
    private static final UrlTemplate RESTORE_FROM_TRASH = new UrlTemplate("/folder/restore_from_trash");
    private static final UrlTemplate MOVE = new UrlTemplate("/folder/move");
    private static final UrlTemplate CHRLDREN = new UrlTemplate("/folder/children");

    public FolderApi(Connection connection) {
        this.connection = connection;
        this.headers = RequestOption.getApiCommonHeader(this.connection);
    }

    /**
     * 获取文件夹信息
     * @param id
     * @return
     */
    public FolderInfoOutput getFolderInfo(long id){
        String url = INFO.build(Config.DEFAULT_API_URI, id);
        RequestClient requestClient = new RequestClient(url, "get", headers, null, null);
        return (FolderInfoOutput) TransformationUtil.requestClientToOutputObject(requestClient, FolderInfoOutput.class);
    }

    /**
     * 创建一个文件夹
     * @param name
     * @param parentId
     * @return
     */
    public CreateFolderOutput createFolder(String name, long parentId){
        String url=CREATE.build(Config.DEFAULT_API_URI);
        CreateFolderBean createFolderBean=new CreateFolderBean(name,parentId);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(createFolderBean);
        RequestClient requestClient = new RequestClient(url, "post", headers, null, postBodyJsonString);
        return (CreateFolderOutput) TransformationUtil.requestClientToOutputObject(requestClient, CreateFolderOutput.class);
    }

    /**
     * 更新文件夹
     * @param id
     * @param newName
     * @return
     */
    public UpdateFolderOutput updateFolder(long id, String newName){
        String url=UPDATE.build(Config.DEFAULT_API_URI, id);
        UpdateFolderBean updateFolderBean=new UpdateFolderBean(newName);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(updateFolderBean);
        RequestClient requestClient = new RequestClient(url, "put", headers, null, postBodyJsonString);
        return (UpdateFolderOutput) TransformationUtil.requestClientToOutputObject(requestClient, UpdateFolderOutput.class);
    }

    /**
     * 删除文件夹
     * @param folderIds
     * @return
     */
    public DeleteFolderOutput deleteFolder(long... folderIds){
        String url=DELETE.build(Config.DEFAULT_API_URI);
        List<Long> idArrayList = TransformationUtil.ArrToArrayListpostBody(folderIds);
        DeleteFolderBean deleteFolderBean=new DeleteFolderBean(idArrayList);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(deleteFolderBean);
        RequestClient requestClient = new RequestClient(url, "delete", headers, null, postBodyJsonString);
        return (DeleteFolderOutput) TransformationUtil.requestClientToOutputObject(requestClient, DeleteFolderOutput.class);
    }

    /**
     * 从回收站删除文件夹，支持清空
     * @param folderIds
     * @param clearTrash
     * @return
     */
    public DeleteFolderOutput deleteFolderFromTrash(List<Long> folderIds, boolean clearTrash){
        String url=DELETE_FROM_TRASH.build(Config.DEFAULT_API_URI);
        DeleteFolderFromTrashBean deleteFolderFromTrashBean=new DeleteFolderFromTrashBean(folderIds,clearTrash);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(deleteFolderFromTrashBean);
        RequestClient requestClient = new RequestClient(url, "delete", headers, null, postBodyJsonString);
        return (DeleteFolderOutput) TransformationUtil.requestClientToOutputObject(requestClient, DeleteFolderOutput.class);
    }

    /**
     * 从回收站恢复文件
     * @param folderIds
     * @param restore_all
     * @return
     */
    public RestoreFolderFromTrashOutput recoveryFolderFromTrash(List<Long> folderIds, boolean restore_all){
        String url=DELETE_FROM_TRASH.build(Config.DEFAULT_API_URI);
        RestoreFolderFromTrashBean restoreFolderFromTrashBean=new RestoreFolderFromTrashBean(restore_all, folderIds);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(restoreFolderFromTrashBean);
        RequestClient requestClient = new RequestClient(url, "post", headers, null, postBodyJsonString);
        return (RestoreFolderFromTrashOutput) TransformationUtil.requestClientToOutputObject(requestClient, RestoreFolderFromTrashOutput.class);
    }

    /**
     * 移动文件夹到指定文件夹
     * @param folderIds
     * @param targetFolderId
     * @return
     */
    public MoveFolderOutput moveFolder(List<Long> folderIds, long targetFolderId){
        String url=MOVE.build(Config.DEFAULT_API_URI);
        MoveFolderBean moveFolderBean=new MoveFolderBean(folderIds, targetFolderId);
        String postBodyJsonString = TransformationUtil.postBodyObjToJsonString(moveFolderBean);
        RequestClient requestClient = new RequestClient(url, "post", headers, null, postBodyJsonString);
        return (MoveFolderOutput) TransformationUtil.requestClientToOutputObject(requestClient, MoveFolderOutput.class);
    }

    /**
     *获取单层子文件和文件夹列表
     * @param folderId
     * @param pageId
     * @param pageCapacity
     * @param type
     * @return
     */
    public ItemListOutput getChildren(long folderId, int pageId, int pageCapacity, String type){
        String baseUrl=CHRLDREN.build(Config.DEFAULT_API_URI);
        String url=String.format(baseUrl+"?folder_id=%s&page_id=%s&page_capacity=%s&type=%s", folderId, pageId, pageCapacity, type);
        RequestClient requestClient = new RequestClient(url, "get", headers, null, null);
        return (ItemListOutput) TransformationUtil.requestClientToOutputObject(requestClient, ItemListOutput.class);
    }


}
