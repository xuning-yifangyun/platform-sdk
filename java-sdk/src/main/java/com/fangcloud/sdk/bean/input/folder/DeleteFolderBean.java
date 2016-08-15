package com.fangcloud.sdk.bean.input.folder;

import com.fangcloud.sdk.bean.input.BaseApiBean;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DeleteFolderBean extends BaseApiBean {
    @SerializedName("folder_ids")
    private List<Long> folderIds;

    public DeleteFolderBean(List<Long> folderIds) {
        this.folderIds = folderIds;
    }

    public List<Long> getFolderIds() {
        return folderIds;
    }

    public void setFolderIds(List<Long> folderIds) {
        this.folderIds = folderIds;
    }
}
