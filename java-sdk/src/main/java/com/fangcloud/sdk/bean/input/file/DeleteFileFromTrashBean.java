package com.fangcloud.sdk.bean.input.file;

import com.fangcloud.sdk.bean.input.BaseApiBean;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DeleteFileFromTrashBean extends BaseApiBean {
    @SerializedName("file_ids")
    private List<Long> fileIds;

    @SerializedName("clear_trash")
    private boolean clearTrash;

    public DeleteFileFromTrashBean(List<Long> fileIds, boolean clearTrash) {
        this.fileIds = fileIds;
        this.clearTrash = clearTrash;
    }

    public List<Long> getFileIds() {
        return fileIds;
    }

    public void setFileIds(List<Long> fileIds) {
        this.fileIds = fileIds;
    }

    public boolean isClearTrash() {
        return clearTrash;
    }

    public void setClearTrash(boolean clearTrash) {
        this.clearTrash = clearTrash;
    }
}
