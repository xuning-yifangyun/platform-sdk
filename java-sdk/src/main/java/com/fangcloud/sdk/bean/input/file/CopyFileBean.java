package com.fangcloud.sdk.bean.input.file;

import com.fangcloud.sdk.bean.input.BaseApiBean;
import com.google.gson.annotations.SerializedName;

public class CopyFileBean extends BaseApiBean {
    @SerializedName("file_id")
    private long fileId;

    @SerializedName("target_folder_id")
    private long targetFolderId;

    @SerializedName("is_check_conflict")
    private Boolean isCheckConflict;

    public CopyFileBean(long fileId, long targetFolderId, Boolean isCheckConflict) {
        this.fileId = fileId;
        this.targetFolderId = targetFolderId;
        this.isCheckConflict = isCheckConflict;
    }

    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    public long getTargetFolderId() {
        return targetFolderId;
    }

    public void setTargetFolderId(long targetFolderId) {
        this.targetFolderId = targetFolderId;
    }

    public Boolean getCheckConflict() {
        return isCheckConflict;
    }

    public void setCheckConflict(Boolean checkConflict) {
        isCheckConflict = checkConflict;
    }
}
