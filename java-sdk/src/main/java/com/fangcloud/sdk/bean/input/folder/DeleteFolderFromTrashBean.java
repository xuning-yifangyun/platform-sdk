package com.fangcloud.sdk.bean.input.folder;

import com.fangcloud.sdk.bean.input.BaseApiBean;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DeleteFolderFromTrashBean extends BaseApiBean {
    @SerializedName("folder_ids")
    private List<Long> folderIds;
    @SerializedName("clear_trash")
    private boolean clearTrash;

    public DeleteFolderFromTrashBean(List<Long> folderIds, boolean clearTrash) {
        this.folderIds = folderIds;
        this.clearTrash = clearTrash;
    }

    public List<Long> getFolderIds() {
        return folderIds;
    }

    public void setFolderIds(List<Long> folderIds) {
        this.folderIds = folderIds;
    }

    public boolean isClearTrash() {
        return clearTrash;
    }

    public void setClearTrash(boolean clearTrash) {
        this.clearTrash = clearTrash;
    }
}
