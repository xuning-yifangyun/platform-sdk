package com.fangcloud.sdk.bean.input.file;

import com.fangcloud.sdk.bean.input.BaseApiBean;
import com.google.gson.annotations.SerializedName;

public class UploadFileBean extends BaseApiBean {
    @SerializedName("parent_id")
    private long parentFolderId; // 父文件夹id
    protected String name; // 文件名
    @SerializedName("upload_type")
    protected UploadType uploadType;

    public UploadFileBean(long parentFolderId, String name, UploadType uploadType) {
        this.parentFolderId = parentFolderId;
        this.name = name;
        this.uploadType = uploadType;
    }

    public long getParentFolderId() {
        return parentFolderId;
    }

    public void setParentFolderId(long parentFolderId) {
        this.parentFolderId = parentFolderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UploadType getUploadType() {
        return uploadType;
    }

    public void setUploadType(UploadType uploadType) {
        this.uploadType = uploadType;
    }
}
