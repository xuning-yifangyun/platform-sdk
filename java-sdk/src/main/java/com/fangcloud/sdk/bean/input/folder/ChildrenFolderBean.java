package com.fangcloud.sdk.bean.input.folder;

/**
 * Created by xuning on 2016/8/15.
 */
public class ChildrenFolderBean {

    private long folderId;
    private int pageId;
    private int pageCapacity;
    private String type;

    public ChildrenFolderBean(long folderId, int pageId, int pageCapacity, String type) {
        this.folderId = folderId;
        this.pageId = pageId;
        this.pageCapacity = pageCapacity;
        this.type = type;
    }

    public long getFolderId() {
        return folderId;
    }

    public void setFolderId(long folderId) {
        this.folderId = folderId;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public int getPageCapacity() {
        return pageCapacity;
    }

    public void setPageCapacity(int pageCapacity) {
        this.pageCapacity = pageCapacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
