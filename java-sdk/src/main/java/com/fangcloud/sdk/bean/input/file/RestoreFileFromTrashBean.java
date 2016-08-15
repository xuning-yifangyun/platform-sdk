package com.fangcloud.sdk.bean.input.file;

import com.fangcloud.sdk.bean.input.BaseApiBean;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RestoreFileFromTrashBean extends BaseApiBean {
    @SerializedName("restore_all")
    private boolean restoreAll;

    @SerializedName("file_ids")
    private List<Long> fileIds;

    public RestoreFileFromTrashBean(boolean restoreAll, List<Long> fileIds) {
        this.restoreAll = restoreAll;
        this.fileIds = fileIds;
    }

    public boolean isRestoreAll() {
        return restoreAll;
    }

    public void setRestoreAll(boolean restoreAll) {
        this.restoreAll = restoreAll;
    }

    public List<Long> getFileIds() {
        return fileIds;
    }

    public void setFileIds(List<Long> fileIds) {
        this.fileIds = fileIds;
    }
}
