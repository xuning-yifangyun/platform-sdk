package com.fangcloud.sdk.bean.input.folder;

import com.fangcloud.sdk.bean.input.BaseApiBean;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoveFolderBean extends BaseApiBean {
    @SerializedName("folder_ids")
    private List<Long> folderIds;
    @SerializedName("target_folder_id")
    private long targetFolderId;

    public MoveFolderBean(List<Long> folderIds, long targetFolderId) {
        this.folderIds = folderIds;
        this.targetFolderId = targetFolderId;
    }

    public List<Long> getFolderIds() {
        return folderIds;
    }

    public void setFolderIds(List<Long> folderIds) {
        this.folderIds = folderIds;
    }

    public long getTargetFolderId() {
        return targetFolderId;
    }

    public void setTargetFolderId(long targetFolderId) {
        this.targetFolderId = targetFolderId;
    }
}
