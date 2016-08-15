package com.fangcloud.sdk.bean.input.file;

import com.fangcloud.sdk.bean.input.BaseApiBean;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DeleteFileBean extends BaseApiBean {
    @SerializedName("file_ids")
    private List<Long> fileIds;

    public DeleteFileBean(List<Long> fileIds) {
        this.fileIds = fileIds;
    }

    public List<Long> getFileIds() {
        return fileIds;
    }

    public void setFileIds(List<Long> fileIds) {
        this.fileIds = fileIds;
    }
}
