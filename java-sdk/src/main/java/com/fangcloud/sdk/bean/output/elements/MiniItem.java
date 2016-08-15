package com.fangcloud.sdk.bean.output.elements;

import com.google.gson.annotations.SerializedName;

public class MiniItem {
    protected long id;
    protected String name;
    @SerializedName("typed_id")
    protected String typedId;
    @SerializedName("user_id")
    protected long userId;
    protected long size;
    @SerializedName("parent_folder_id")
    protected long parentFolderId;
    @SerializedName("in_trash")
    protected boolean inTrash;
    @SerializedName("is_deleted")
    protected boolean isDeleted;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypedId() {
        return typedId;
    }

    public void setTypedId(String typedId) {
        this.typedId = typedId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getParentFolderId() {
        return parentFolderId;
    }

    public void setParentFolderId(long parentFolderId) {
        this.parentFolderId = parentFolderId;
    }

    public boolean isInTrash() {
        return inTrash;
    }

    public void setInTrash(boolean inTrash) {
        this.inTrash = inTrash;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    /* ============================================================== */

    /**
     * type_id: file_100
     *
     * @param type
     * @return
     */
    public String getTypedId(String type) {
        return type + "_" + id;
    }
}
