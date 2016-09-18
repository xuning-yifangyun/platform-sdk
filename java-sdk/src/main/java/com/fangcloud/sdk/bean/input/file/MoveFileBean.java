package com.fangcloud.sdk.bean.input.file;

import com.fangcloud.sdk.bean.input.BaseApiBean;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoveFileBean extends BaseApiBean {

    @SerializedName("file_ids")
    private List<Long> fileIds;

    @SerializedName("target_folder_id")
    private Long targetFolderId;

    public MoveFileBean(List<Long> fileIds, Long targetFolderId) {
        this.fileIds = fileIds;
        this.targetFolderId = targetFolderId;
    }

    public List<Long> getFileIds() {
        return fileIds;
    }

    public void setFileIds(List<Long> fileIds) {
        this.fileIds = fileIds;
    }

    public Long getTargetFolderId() {
        return targetFolderId;
    }

    public void setTargetFolderId(Long targetFolderId) {
        this.targetFolderId = targetFolderId;
    }
}
