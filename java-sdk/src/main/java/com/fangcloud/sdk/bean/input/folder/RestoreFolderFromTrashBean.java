package com.fangcloud.sdk.bean.input.folder;

import com.fangcloud.sdk.bean.input.BaseApiBean;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestoreFolderFromTrashBean extends BaseApiBean {
    @SerializedName("restore_all")
    private boolean restoreAll;

    @SerializedName("folder_ids")
    private List<Long> folderIds;

    public RestoreFolderFromTrashBean(boolean restoreAll, List<Long> folderIds) {
        this.restoreAll = restoreAll;
        this.folderIds = folderIds;
    }

    public boolean isRestoreAll() {
        return restoreAll;
    }

    public void setRestoreAll(boolean restoreAll) {
        this.restoreAll = restoreAll;
    }

    public List<Long> getFolderIds() {
        return folderIds;
    }

    public void setFolderIds(List<Long> folderIds) {
        this.folderIds = folderIds;
    }
}
